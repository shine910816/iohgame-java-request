package com.iohgame.service.nba.synch;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.iohgame.framework.utility.Utility;
import com.iohgame.service.nba.synch.StatsDao.StatsType;
import com.iohgame.service.property.mysql.property.ServerDBI;

public class StatsImpl extends ServerDBI implements Stats
{
    @Override
    public List<StatsDao> selectStats()
    {
        LOG.info("Select stats");

        List<StatsDao> list = new ArrayList<>();
        ResultSet result = slave().query("SELECT * FROM g_nba_stats WHERE del_flg = 0 AND g_finish_flg = 0");
        try
        {
            while (result.next())
            {
                StatsDao dao = new StatsDao.ContainerBuilder() //
                        .statsType(Utility.getEnum(result.getString("game_stats_type"), StatsType.class)) //
                        .season(Utility.toInteger(result.getString("game_season"))) //
                        .seasonStage(Utility.getEnum(result.getString("game_season_stage"), SeasonStage.class)) //
                        .ppg(Utility.toFloat(result.getString("g_ppg"))) //
                        .rpg(Utility.toFloat(result.getString("g_rpg"))) //
                        .apg(Utility.toFloat(result.getString("g_apg"))) //
                        .spg(Utility.toFloat(result.getString("g_spg"))) //
                        .bpg(Utility.toFloat(result.getString("g_bpg"))) //
                        .fgp(Utility.toFloat(result.getString("g_fgp"))) //
                        .tpp(Utility.toFloat(result.getString("g_tpp"))) //
                        .ftp(Utility.toFloat(result.getString("g_ftp"))) //
                        .opg(Utility.toFloat(result.getString("g_opg"))) //
                        .dpg(Utility.toFloat(result.getString("g_dpg"))) //
                        .tpg(Utility.toFloat(result.getString("g_tpg"))) //
                        .fpg(Utility.toFloat(result.getString("g_fpg"))) //
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

    @Override
    public Boolean updateStats(Map<String, String> data, Integer season, SeasonStage seasonStage, StatsType statsType)
    {
        LOG.info("Update stats: " + data + ", for: " + statsType + " " + seasonStage + " " + season);

        master().update("g_nba_stats", data, "game_season = " + season + " AND game_season_stage = " + seasonStage.val() + " AND game_stats_type = " + statsType.val());
        master().free();

        return true;
    }
}
