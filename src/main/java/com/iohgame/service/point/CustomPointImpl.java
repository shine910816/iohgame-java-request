package com.iohgame.service.point;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.iohgame.framework.utility.Utility;
import com.iohgame.service.point.CustomPointHistoryDao.PointType;
import com.iohgame.service.property.mysql.property.ServerDBI;

public class CustomPointImpl extends ServerDBI implements CustomPoint
{
    @Override
    public CustomPointDao getCustomPoint(Integer customId)
    {
        LOG.info("Select custom point");

        ResultSet result = slave().query("SELECT * FROM c_point WHERE del_flg = 0 AND custom_id = " + customId);
        CustomPointDao dao = null;
        try
        {
            while (result.next())
            {
                if (Utility.toInteger(result.getString("custom_id")).equals(customId))
                {
                    dao = new CustomPointDao.ContainerBuilder() //
                            .customId(Utility.toInteger(result.getString("custom_id"))) //
                            .customPoint(Utility.toInteger(result.getString("custom_point"))) //
                            .build();
                    break;
                }
            }
        }
        catch (SQLException e)
        {
            LOG.error(e.getMessage());
        }
        slave().free();

        return dao;
    }

    @Override
    public void updateCustomPoint(Integer customId, Integer customPoint)
    {
        LOG.info("Update custom point");

        Map<String, String> params = new HashMap<>();
        params.put("custom_point", Utility.toString(customPoint));
        master().update("c_point", params, "custom_id = " + customId);
        master().free();
    }

    @Override
    public List<CustomPointHistoryDao> getCustomPointHistory(Integer customId)
    {
        LOG.info("Select custom point history");

        ResultSet result = slave().query("SELECT * FROM c_point_history WHERE del_flg = 0 AND custom_id = " + customId + " ORDER BY insert_date DESC");
        List<CustomPointHistoryDao> list = new ArrayList<>();
        try
        {
            while (result.next())
            {
                CustomPointHistoryDao dao = new CustomPointHistoryDao.ContainerBuilder() //
                        .customId(Utility.toInteger(result.getString("custom_id"))) //
                        .pointId(Utility.toInteger(result.getString("point_id"))) //
                        .pointType(Utility.getEnum(result.getString("point_type"), PointType.class)) //
                        .pointValue(Utility.toInteger(result.getString("point_value"))) //
                        .pointNote(result.getString("point_note")) //
                        .pointBefore(Utility.toInteger(result.getString("point_before"))) //
                        .pointAfter(Utility.toInteger(result.getString("point_after"))) //
                        .insertDate(Utility.toDate(result.getString("insert_date"))) //
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
    public void insertPointHistory(Map<String, String> params)
    {
        LOG.info("Insert custom point history");

        master().insert("c_point_history", params);
        master().free();
    }
}
