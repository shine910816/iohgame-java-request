package com.iohgame.service.nba.synch;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.TreeMap;

import com.iohgame.framework.utility.Utility;
import com.iohgame.service.property.mysql.property.ServerDBI;

public class StandingsImpl extends ServerDBI implements Standings
{
    @Override
    public Map<Integer, StandingsDao> selectStandings()
    {
        LOG.info("Select standings info");

        Map<Integer, StandingsDao> list = new TreeMap<>();
        ResultSet result = slave().query("SELECT * FROM g_nba_standings WHERE del_flg = 0");
        try
        {
            while (result.next())
            {
                StandingsDao dao = new StandingsDao.ContainerBuilder() //
                        .teamId(Utility.toInteger(result.getString("t_id"))) //
                        .win(Utility.toInteger(result.getString("t_win"))) //
                        .loss(Utility.toInteger(result.getString("t_loss"))) //
                        .winPercent(Utility.toFloat(result.getString("t_win_percent"))) //
                        .gameBehind(Utility.toFloat(result.getString("t_game_behind"))) //
                        .gameBehindDiv(Utility.toFloat(result.getString("t_game_behind_div"))) //
                        .confRank(Utility.toInteger(result.getString("t_conf_rank"))) //
                        .confWin(Utility.toInteger(result.getString("t_conf_win"))) //
                        .confLoss(Utility.toInteger(result.getString("t_conf_loss"))) //
                        .divRank(Utility.toInteger(result.getString("t_div_rank"))) //
                        .divWin(Utility.toInteger(result.getString("t_div_win"))) //
                        .divLoss(Utility.toInteger(result.getString("t_div_loss"))) //
                        .homeWin(Utility.toInteger(result.getString("t_home_win"))) //
                        .homeLoss(Utility.toInteger(result.getString("t_home_loss"))) //
                        .awayWin(Utility.toInteger(result.getString("t_away_win"))) //
                        .awayLoss(Utility.toInteger(result.getString("t_away_loss"))) //
                        .lastTenWin(Utility.toInteger(result.getString("t_last_ten_win"))) //
                        .lastTenLoss(Utility.toInteger(result.getString("t_last_ten_loss"))) //
                        .winStreak(judge(result.getString("t_win_streak_flg"))) //
                        .streak(Utility.toInteger(result.getString("t_streak"))) //
                        .build();
                list.put(dao.teamId(), dao);
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
    public Boolean updateStandings(Map<String, String> updateData, Integer teamId)
    {
        LOG.info("Update standings: " + updateData + ", for: " + teamId);

        master().update("g_nba_standings", updateData, "t_id = " + teamId);
        master().free();

        return true;
    }
}
