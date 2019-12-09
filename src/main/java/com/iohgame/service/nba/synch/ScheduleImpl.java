package com.iohgame.service.nba.synch;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.TreeMap;

import com.iohgame.framework.utility.Utility;
import com.iohgame.framework.utility.parameters.constant.ConstDatetime;
import com.iohgame.service.nba.synch.ScheduleDao.GameStatus;
import com.iohgame.service.property.mysql.property.ServerDBI;

public class ScheduleImpl extends ServerDBI implements Schedule
{
    private Map<Integer, TeamDao> m_teamMap;

    protected ScheduleImpl(Map<Integer, TeamDao> teamMap)
    {
        m_teamMap = teamMap;
    }

    @Override
    public Map<Integer, ScheduleDao> selectSchedule(Integer season)
    {
        LOG.info("Select schedule info");

        Map<Integer, ScheduleDao> list = new TreeMap<>();
        ResultSet result = slave().query("SELECT * FROM g_nba_schedule WHERE del_flg = 0 AND game_season = " + Utility.toString(season));
        try
        {
            while (result.next())
            {
                ScheduleDao dao = new ScheduleDao.ContainerBuilder() //
                        .gameId(Utility.toInteger(result.getString("game_id"))) //
                        .season(Utility.toInteger(result.getString("game_season"))) //
                        .seasonStage(Utility.getEnum(result.getString("game_season_stage"), SeasonStage.class)) //
                        .playDate(Utility.toInteger(result.getString("game_date"))) //
                        .name(result.getString("game_name")) //
                        .playDateCn(Utility.toInteger(result.getString("game_date_cn"))) //
                        .startDate(Utility.toDate(result.getString("game_start_date"), ConstDatetime.DATETIME)) //
                        .arena(result.getString("game_arena")) //
                        .homeTeam(m_teamMap.get(Utility.toInteger(result.getString("game_home_team")))) //
                        .awayTeam(m_teamMap.get(Utility.toInteger(result.getString("game_away_team")))) //
                        .gameStatus(Utility.getEnum(result.getString("game_status"), GameStatus.class)) //
                        .homeScore(Utility.toInteger(result.getString("game_home_score"))) //
                        .awayScore(Utility.toInteger(result.getString("game_away_score"))) //
                        .awayLineScore(result.getString("game_away_line_score")) //
                        .homeLineScore(result.getString("game_home_line_score")) //
                        .isSynch(judge(result.getString("game_synch_flg"))) //
                        .build();
                list.put(dao.gameId(), dao);
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
    public Boolean insertSchedule(Map<String, String> param)
    {
        LOG.info("Insert schedule: " + param);

        master().insert("g_nba_schedule", param);
        master().free();

        return true;
    }

    @Override
    public Boolean updateSchedule(Map<String, String> param, Integer gameId)
    {
        LOG.info("Update schedule: " + param + ", for: " + gameId);

        master().update("g_nba_schedule", param, "game_id = " + gameId);
        master().free();

        return true;
    }
}
