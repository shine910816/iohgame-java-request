package com.iohgame.service.point;

import java.util.List;
import java.util.Map;

import com.iohgame.framework.connect.mysql.parameters.Database;

public interface CustomPoint extends Database
{
    public CustomPointDao getCustomPoint(Integer customId);

    public void updateCustomPoint(Integer customId, Integer customPoint);

    public List<CustomPointHistoryDao> getCustomPointHistory(Integer customId);

    public void insertPointHistory(Map<String, String> params);
}
