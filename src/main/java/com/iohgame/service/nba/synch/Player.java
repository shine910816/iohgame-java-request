package com.iohgame.service.nba.synch;

import java.util.Map;

import com.iohgame.framework.connect.mysql.parameters.Database;

public interface Player extends Database
{
    public Map<Integer, PlayerDao> selectPlayerInfo();

    public Boolean insertPlayer(Map<String, String> insertData);

    public Boolean updatePlayer(Map<String, String> updateData, Integer playerId);
}
