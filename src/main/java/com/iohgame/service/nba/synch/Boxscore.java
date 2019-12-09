package com.iohgame.service.nba.synch;

import java.util.List;
import java.util.Map;

public interface Boxscore
{
    public Boolean insertBoxscore(Map<String, String> insertData);

    public Map<String, Integer> selectBoxscoreCountByGameSeason(Integer season);

    public Map<Integer, Integer> selectTeamGamePlayed(Integer season, SeasonStage seasonStage);

    public Map<Integer, BoxscoreDao> selectTeamStats(Integer season, SeasonStage seasonStage);

    public List<BoxscoreDao> selectPlayerStats(Integer season, SeasonStage seasonStage);
}
