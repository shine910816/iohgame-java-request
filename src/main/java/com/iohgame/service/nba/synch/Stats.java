package com.iohgame.service.nba.synch;

import java.util.List;
import java.util.Map;

import com.iohgame.framework.connect.mysql.parameters.Database;
import com.iohgame.service.nba.synch.StatsDao.StatsType;

public interface Stats extends Database
{
    public List<StatsDao> selectStats();

    public Boolean updateStats(Map<String, String> data, Integer season, SeasonStage seasonStage, StatsType statsType);
}
