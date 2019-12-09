package com.iohgame.service.nba.synch;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.TreeMap;

import com.iohgame.framework.utility.Utility;
import com.iohgame.service.nba.synch.TeamDao.Conference;
import com.iohgame.service.nba.synch.TeamDao.Division;
import com.iohgame.service.property.mysql.property.ServerDBI;

public class TeamImpl extends ServerDBI implements Team
{
    @Override
    public Map<Integer, TeamDao> selectTeamInfo()
    {
        LOG.info("Select team info");

        Map<Integer, TeamDao> list = new TreeMap<>();
        ResultSet result = slave().query("SELECT * FROM g_nba_team WHERE del_flg = 0 ORDER BY t_name_short ASC");
        try
        {
            while (result.next())
            {
                TeamDao dao = new TeamDao.ContainerBuilder() //
                        .teamId(Utility.toInteger(result.getString("t_id"))) //
                        .name(result.getString("t_name")) //
                        .shortName(result.getString("t_name_short")) //
                        .cityCn(result.getString("t_city_cn")) //
                        .nameCn(result.getString("t_name_cn")) //
                        .conference(Utility.getEnum(result.getString("t_conference"), Conference.class)) //
                        .division(Utility.getEnum(result.getString("t_division"), Division.class)) //
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
}
