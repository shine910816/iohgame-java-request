package com.iohgame.service.nba.synch;

import java.util.Map;

import com.iohgame.framework.connect.mysql.parameters.Database;

public interface Team extends Database
{
    public Map<Integer, TeamDao> selectTeamInfo();
}
