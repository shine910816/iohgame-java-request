package com.iohgame.service.nba.synch;

import java.util.Map;

import com.iohgame.framework.connect.mysql.parameters.Database;

public interface Schedule extends Database
{
    public Map<Integer, ScheduleDao> selectSchedule(Integer season);

    public Boolean insertSchedule(Map<String, String> param);

    public Boolean updateSchedule(Map<String, String> param, Integer gameId);
}
