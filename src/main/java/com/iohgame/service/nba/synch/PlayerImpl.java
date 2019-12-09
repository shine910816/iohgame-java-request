package com.iohgame.service.nba.synch;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.TreeMap;

import com.iohgame.framework.utility.Utility;
import com.iohgame.framework.utility.parameters.constant.ConstDatetime;
import com.iohgame.service.nba.synch.PlayerDao.PlayerPosition;
import com.iohgame.service.property.mysql.property.ServerDBI;

public class PlayerImpl extends ServerDBI implements Player
{
    @Override
    public Map<Integer, PlayerDao> selectPlayerInfo()
    {
        LOG.info("Select player info");

        Map<Integer, PlayerDao> list = new TreeMap<>();
        ResultSet result = slave().query("SELECT * FROM g_nba_player WHERE del_flg = 0");
        try
        {
            while (result.next())
            {
                PlayerDao dao = new PlayerDao.ContainerBuilder() //
                        .playerId(Utility.toInteger(result.getString("p_id"))) //
                        .teamId(Utility.toInteger(result.getString("t_id"))) //
                        .firstName(result.getString("p_first_name")) //
                        .lastName(result.getString("p_last_name")) //
                        .position(Utility.getEnum(result.getString("p_position"), PlayerPosition.class)) //
                        .position2(Utility.getEnum(result.getString("p_position_2"), PlayerPosition.class)) //
                        .country(result.getString("p_country")) //
                        .birthdate(Utility.toDate(result.getString("p_birth_date"), ConstDatetime.DATE)) //
                        .height(Utility.toFloat(result.getString("p_height"))) //
                        .weight(Utility.toFloat(result.getString("p_weight"))) //
                        .jersey(Utility.toInteger(result.getString("p_jersey"))) //
                        .isStandard(judge(result.getString("p_standard_flg"))) //
                        .isAfrica(judge(result.getString("p_africa_flg"))) //
                        .isSacramento(judge(result.getString("p_sacramento_flg"))) //
                        .isVegas(judge(result.getString("p_vegas_flg"))) //
                        .isUtah(judge(result.getString("p_utah_flg"))) //
                        .isView(judge(result.getString("view_flg"))) //
                        .build();
                list.put(dao.playerId(), dao);
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
    public Boolean insertPlayer(Map<String, String> insertData)
    {
        LOG.info("Insert player: " + insertData);

        master().insert("g_nba_player", insertData);
        master().free();

        return true;
    }

    @Override
    public Boolean updatePlayer(Map<String, String> updateData, Integer playerId)
    {
        LOG.info("Update player: " + updateData + ", for: " + playerId);

        master().update("g_nba_player", updateData, "p_id = " + playerId);
        master().free();

        return true;
    }
}
