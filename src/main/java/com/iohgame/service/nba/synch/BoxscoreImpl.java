package com.iohgame.service.nba.synch;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.iohgame.framework.utility.Utility;
import com.iohgame.service.nba.synch.BoxscoreDao.StartMemberPosition;
import com.iohgame.service.property.mysql.property.ServerDBI;

public class BoxscoreImpl extends ServerDBI implements Boxscore
{
    @Override
    public Boolean insertBoxscore(Map<String, String> insertData)
    {
        LOG.info("Insert boxscore: " + insertData);

        master().insert("g_nba_boxscore", insertData);
        master().free();

        return true;
    }

    @Override
    public Map<String, Integer> selectBoxscoreCountByGameSeason(Integer season)
    {
        LOG.info("Select team info");

        Map<String, Integer> list = new TreeMap<>();
        ResultSet result = slave().query("SELECT game_id, COUNT(*) AS number FROM g_nba_boxscore" + //
                " WHERE game_season = " + season + " AND del_flg = 0 GROUP BY game_id");
        try
        {
            while (result.next())
            {
                list.put(result.getString("game_id"), Utility.toInteger(result.getString("number")));
            }
        }
        catch (SQLException e)
        {
            LOG.error(e.getMessage());
        }
        slave().free();

        return list;
    }

    @Override
    public Map<Integer, Integer> selectTeamGamePlayed(Integer season, SeasonStage seasonStage)
    {
        LOG.info("Select team game played for: " + season + " season " + seasonStage);

        Map<Integer, Integer> list = new TreeMap<>();
        ResultSet result = slave().query("SELECT t_id, game_id, COUNT(*) AS player_count FROM g_nba_boxscore" + //
                " WHERE del_flg = 0 AND game_season = " + Utility.toString(season) + " AND game_season_stage = " + seasonStage.val() + //
                " GROUP BY t_id, game_id ORDER BY t_id");
        try
        {
            while (result.next())
            {
                Integer teamId = Utility.toInteger(result.getString("t_id"));
                if (list.containsKey(teamId))
                {
                    Integer gamePlayed = list.get(teamId);
                    list.put(teamId, gamePlayed + 1);
                }
                else
                {
                    list.put(teamId, 1);
                }
            }
        }
        catch (SQLException e)
        {
            LOG.error(e.getMessage());
        }
        slave().free();

        return list;
    }

    @Override
    public Map<Integer, BoxscoreDao> selectTeamStats(Integer season, SeasonStage seasonStage)
    {
        Map<Integer, Integer> teamGamePlayed = selectTeamGamePlayed(season, seasonStage);
        LOG.info("Select team stats for: " + season + " season " + seasonStage);

        Map<Integer, BoxscoreDao> list = new TreeMap<>();
        ResultSet result = slave().query("SELECT t_id, SUM(g_points) AS pts, SUM(g_field_goals_made) AS fgm, SUM(g_field_goals_attempted) AS fga,"
                + " SUM(g_three_points_made) AS tpm, SUM(g_three_points_attempted) AS tpa, SUM(g_free_throw_made) AS ftm, SUM(g_free_throw_attempted) AS fta,"
                + " SUM(g_rebounds) AS reb, SUM(g_offensive_rebounds) AS off, SUM(g_defensive_rebounds) AS def, SUM(g_assists) AS ast, SUM(g_steals) AS stl,"
                + " SUM(g_blocks) AS blk, SUM(g_turnovers) AS `to`, SUM(g_personal_fouls) AS pf FROM g_nba_boxscore WHERE game_season = " + season + " AND game_season_stage = " + seasonStage.val()
                + " AND del_flg = 0 GROUP BY t_id ORDER BY t_id");
        try
        {
            while (result.next())
            {
                Integer teamId = Utility.toInteger(result.getString("t_id"));
                Integer gamePlayed = 1;
                if (teamGamePlayed.containsKey(teamId))
                {
                    gamePlayed = teamGamePlayed.get(teamId);
                }
                BoxscoreDao dao = new BoxscoreDao.ContainerBuilder() //
                        .gameId(0) //
                        .playerId(0) //
                        .season(season) //
                        .seasonStage(seasonStage) //
                        .playDate(0) //
                        .teamId(teamId) //
                        .gamePlayed(gamePlayed) //
                        .position(StartMemberPosition.NO_GAME_STARTED) //
                        .minutes(0) //
                        .minutesSec(0) //
                        .points(Utility.toInteger(result.getString("pts"))) //
                        .fieldGoalsMade(Utility.toInteger(result.getString("fgm"))) //
                        .fieldGoalsAttempted(Utility.toInteger(result.getString("fga"))) //
                        .threePointsMade(Utility.toInteger(result.getString("tpm"))) //
                        .threePointsAttempted(Utility.toInteger(result.getString("tpa"))) //
                        .freeThrowMade(Utility.toInteger(result.getString("ftm"))) //
                        .freeThrowAttempted(Utility.toInteger(result.getString("fta"))) //
                        .rebounds(Utility.toInteger(result.getString("reb"))) //
                        .offensiveRebounds(Utility.toInteger(result.getString("off"))) //
                        .defensiveRebounds(Utility.toInteger(result.getString("def"))) //
                        .assists(Utility.toInteger(result.getString("ast"))) //
                        .steals(Utility.toInteger(result.getString("stl"))) //
                        .blocks(Utility.toInteger(result.getString("blk"))) //
                        .personalFouls(Utility.toInteger(result.getString("pf"))) //
                        .turnover(Utility.toInteger(result.getString("to"))) //
                        .plusMinus(0) //
                        .sort(0f) //
                        .doubleDouble(false) //
                        .tripleDouble(false) //
                        .eject(false) //
                        .build();
                list.put(teamId, dao);
            }
        }
        catch (SQLException e)
        {
            LOG.error(e.getMessage());
        }
        slave().free();

        return list;
    }

    @Override
    public List<BoxscoreDao> selectPlayerStats(Integer season, SeasonStage seasonStage)
    {
        LOG.info("Select player stats for: " + season + " season " + seasonStage);

        List<BoxscoreDao> list = new ArrayList<>();
        ResultSet result = slave().query("SELECT p_id, COUNT(*) AS gp, SUM(g_points) AS pts, SUM(g_rebounds) AS reb, SUM(g_assists) AS ast," + //
                " SUM(g_steals) AS stl, SUM(g_blocks) AS blk FROM g_nba_boxscore" + //
                " WHERE game_season = " + season + " AND game_season_stage = " + seasonStage.val() + " AND del_flg = 0 GROUP BY p_id ORDER BY p_id");
        try
        {
            while (result.next())
            {
                BoxscoreDao dao = new BoxscoreDao.ContainerBuilder() //
                        .gameId(0) //
                        .playerId(Utility.toInteger(result.getString("p_id"))) //
                        .season(season) //
                        .seasonStage(seasonStage) //
                        .playDate(0) //
                        .teamId(0) //
                        .gamePlayed(Utility.toInteger(result.getString("gp"))) //
                        .position(StartMemberPosition.NO_GAME_STARTED) //
                        .minutes(0) //
                        .minutesSec(0) //
                        .points(Utility.toInteger(result.getString("pts"))) //
                        .fieldGoalsMade(0) //
                        .fieldGoalsAttempted(0) //
                        .threePointsMade(0) //
                        .threePointsAttempted(0) //
                        .freeThrowMade(0) //
                        .freeThrowAttempted(0) //
                        .rebounds(Utility.toInteger(result.getString("reb"))) //
                        .offensiveRebounds(0) //
                        .defensiveRebounds(0) //
                        .assists(Utility.toInteger(result.getString("ast"))) //
                        .steals(Utility.toInteger(result.getString("stl"))) //
                        .blocks(Utility.toInteger(result.getString("blk"))) //
                        .personalFouls(0) //
                        .turnover(0) //
                        .plusMinus(0) //
                        .sort(0f) //
                        .doubleDouble(false) //
                        .tripleDouble(false) //
                        .eject(false) //
                        .build();
                list.add(dao);
            }
        }
        catch (SQLException e)
        {
            LOG.error(e.getMessage());
        }
        slave().free();

        return list;
    }
}
