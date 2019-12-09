package com.iohgame.service.nba.synch;

import java.util.Map;

public interface Standings
{
    public Map<Integer, StandingsDao> selectStandings();

    public Boolean updateStandings(Map<String, String> updateData, Integer teamId);
}
