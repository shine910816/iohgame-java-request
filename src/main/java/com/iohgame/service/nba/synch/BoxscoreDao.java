package com.iohgame.service.nba.synch;

import com.iohgame.framework.connect.mysql.parameters.Dao;
import com.iohgame.framework.utility.Utility;
import com.iohgame.framework.utility.parameters.property.Builder;
import com.iohgame.framework.utility.parameters.property.Parameters;

public class BoxscoreDao implements Dao
{
    private final Integer m_season;
    private final SeasonStage m_seasonStage;
    private final Integer m_playDate;
    private final Integer m_gameId;
    private final Integer m_teamId;
    private final Integer m_playerId;
    private final Integer m_gamePlayed;
    private final Integer m_minutes;
    private final Integer m_minutesSec;
    private final StartMemberPosition m_position;
    private final Integer m_points;
    private final Integer m_fieldGoalsMade;
    private final Integer m_fieldGoalsAttempted;
    private final Integer m_threePointsMade;
    private final Integer m_threePointsAttempted;
    private final Integer m_freeThrowMade;
    private final Integer m_freeThrowAttempted;
    private final Integer m_rebounds;
    private final Integer m_offensiveRebounds;
    private final Integer m_defensiveRebounds;
    private final Integer m_assists;
    private final Integer m_steals;
    private final Integer m_blocks;
    private final Integer m_personalFouls;
    private final Integer m_turnover;
    private final Integer m_plusMinus;
    private final Float m_sort;
    private final Boolean m_doubleDouble;
    private final Boolean m_tripleDouble;
    private final Boolean m_eject;

    private BoxscoreDao(ContainerBuilder builder)
    {
        m_season = builder.m_season;
        m_seasonStage = builder.m_seasonStage;
        m_playDate = builder.m_playDate;
        m_gameId = builder.m_gameId;
        m_teamId = builder.m_teamId;
        m_playerId = builder.m_playerId;
        m_gamePlayed = builder.m_gamePlayed;
        m_position = builder.m_position;
        m_minutes = builder.m_minutes;
        m_minutesSec = builder.m_minutesSec;
        m_points = builder.m_points;
        m_fieldGoalsMade = builder.m_fieldGoalsMade;
        m_fieldGoalsAttempted = builder.m_fieldGoalsAttempted;
        m_threePointsMade = builder.m_threePointsMade;
        m_threePointsAttempted = builder.m_threePointsAttempted;
        m_freeThrowMade = builder.m_freeThrowMade;
        m_freeThrowAttempted = builder.m_freeThrowAttempted;
        m_rebounds = builder.m_rebounds;
        m_offensiveRebounds = builder.m_offensiveRebounds;
        m_defensiveRebounds = builder.m_defensiveRebounds;
        m_assists = builder.m_assists;
        m_steals = builder.m_steals;
        m_blocks = builder.m_blocks;
        m_personalFouls = builder.m_personalFouls;
        m_turnover = builder.m_turnover;
        m_plusMinus = builder.m_plusMinus;
        m_sort = builder.m_sort;
        m_doubleDouble = builder.m_doubleDouble;
        m_tripleDouble = builder.m_tripleDouble;
        m_eject = builder.m_eject;
    }

    /**
     * Game season year
     */
    public Integer season()
    {
        return m_season;
    }

    /**
     * Season stage
     */
    public SeasonStage seasonStage()
    {
        return m_seasonStage;
    }

    /**
     * Game play date (yyyyMMdd)
     */
    public Integer playDate()
    {
        return m_playDate;
    }

    /**
     * Game ID
     */
    public Integer gameId()
    {
        return m_gameId;
    }

    /**
     * Game ID string
     */
    public String gameIdString()
    {
        return "00" + m_gameId;
    }

    /**
     * Team ID
     */
    public Integer teamId()
    {
        return m_teamId;
    }

    /**
     * Player ID
     */
    public Integer playerId()
    {
        return m_playerId;
    }

    /**
     * Game played
     */
    public Integer gp()
    {
        return m_gamePlayed;
    }

    /**
     * Position
     */
    public StartMemberPosition position()
    {
        return m_position;
    }

    /**
     * Minutes
     */
    public Integer min()
    {
        return m_minutes;
    }

    /**
     * Minutes (second)
     */
    public Integer sec()
    {
        return m_minutesSec;
    }

    public Float playedTimeSecond()
    {
        return (float) (m_minutes * 60 + m_minutesSec);
    }

    /**
     * Time
     */
    public String time()
    {
        return String.format("%d:%02d", m_minutes, m_minutesSec);
    }

    /**
     * Points
     */
    public Integer pts()
    {
        return m_points;
    }

    /**
     * Field goals made
     */
    public Integer fgm()
    {
        return m_fieldGoalsMade;
    }

    /**
     * Field goals attempted
     */
    public Integer fga()
    {
        return m_fieldGoalsAttempted;
    }

    /**
     * Field goals missed
     */
    public Integer fgx()
    {
        return m_fieldGoalsAttempted - m_fieldGoalsMade;
    }

    /**
     * Field goals percentage
     */
    public Float fgp()
    {
        if (m_fieldGoalsAttempted == 0)
        {
            return 0f;
        }
        else
        {
            Float res = Utility.toFloat(m_fieldGoalsMade.toString()) / Utility.toFloat(m_fieldGoalsAttempted.toString());
            return Utility.toFloat(String.format("%.3f", res));
        }
    }

    /**
     * Three points made
     */
    public Integer tpm()
    {
        return m_threePointsMade;
    }

    /**
     * Three points attempted
     */
    public Integer tpa()
    {
        return m_threePointsAttempted;
    }

    /**
     * Three points missed
     */
    public Integer tpx()
    {
        return m_threePointsAttempted - m_threePointsMade;
    }

    /**
     * Three points percentage
     */
    public Float tpp()
    {
        if (m_threePointsAttempted == 0)
        {
            return 0f;
        }
        else
        {
            Float res = Utility.toFloat(m_threePointsMade.toString()) / Utility.toFloat(m_threePointsAttempted.toString());
            return Utility.toFloat(String.format("%.3f", res));
        }
    }

    /**
     * Free throw made
     */
    public Integer ftm()
    {
        return m_freeThrowMade;
    }

    /**
     * Free throw attempted
     */
    public Integer fta()
    {
        return m_freeThrowAttempted;
    }

    /**
     * Free throw missed
     */
    public Integer ftx()
    {
        return m_freeThrowAttempted - m_freeThrowMade;
    }

    /**
     * Free throw percentage
     */
    public Float ftp()
    {
        if (m_freeThrowAttempted == 0)
        {
            return 0f;
        }
        else
        {
            Float res = Utility.toFloat(m_freeThrowMade.toString()) / Utility.toFloat(m_freeThrowAttempted.toString());
            return Utility.toFloat(String.format("%.3f", res));
        }
    }

    /**
     * Offensive rebounds
     */
    public Integer off()
    {
        return m_offensiveRebounds;
    }

    /**
     * Defensive rebounds
     */
    public Integer def()
    {
        return m_defensiveRebounds;
    }

    /**
     * Total rebounds
     */
    public Integer reb()
    {
        return m_rebounds;
    }

    /**
     * Assists
     */
    public Integer ast()
    {
        return m_assists;
    }

    /**
     * Steals
     */
    public Integer stl()
    {
        return m_steals;
    }

    /**
     * Blocks
     */
    public Integer blk()
    {
        return m_blocks;
    }

    /**
     * Personal fouls
     */
    public Integer pf()
    {
        return m_personalFouls;
    }

    /**
     * Turnovers
     */
    public Integer to()
    {
        return m_turnover;
    }

    /**
     * Plus minus
     */
    public Integer pm()
    {
        return m_plusMinus;
    }

    /**
     * Double double
     */
    public Boolean dd2()
    {
        return m_doubleDouble;
    }

    /**
     * Triple double
     */
    public Boolean td3()
    {
        return m_tripleDouble;
    }

    /**
     * Eject
     */
    public Boolean eject()
    {
        return m_eject;
    }

    /**
     * Sort
     */
    public Float sort()
    {
        return m_sort;
    }

    /**
     * Average statistics
     */
    public AverageStats average()
    {
        return new AverageStats(this);
    }

    public static class ContainerBuilder implements Builder<BoxscoreDao>
    {
        private Integer m_season;
        private SeasonStage m_seasonStage;
        private Integer m_playDate;
        private Integer m_gameId;
        private Integer m_teamId;
        private Integer m_playerId;
        private Integer m_gamePlayed;
        private StartMemberPosition m_position;
        private Integer m_minutes;
        private Integer m_minutesSec;
        private Integer m_points;
        private Integer m_fieldGoalsMade;
        private Integer m_fieldGoalsAttempted;
        private Integer m_threePointsMade;
        private Integer m_threePointsAttempted;
        private Integer m_freeThrowMade;
        private Integer m_freeThrowAttempted;
        private Integer m_rebounds;
        private Integer m_offensiveRebounds;
        private Integer m_defensiveRebounds;
        private Integer m_assists;
        private Integer m_steals;
        private Integer m_blocks;
        private Integer m_personalFouls;
        private Integer m_turnover;
        private Integer m_plusMinus;
        private Float m_sort;
        private Boolean m_doubleDouble;
        private Boolean m_tripleDouble;
        private Boolean m_eject;

        public ContainerBuilder season(Integer season)
        {
            m_season = season;
            return this;
        }

        public ContainerBuilder seasonStage(SeasonStage seasonStage)
        {
            m_seasonStage = seasonStage;
            return this;
        }

        public ContainerBuilder playDate(Integer playDate)
        {
            m_playDate = playDate;
            return this;
        }

        public ContainerBuilder gameId(Integer gameId)
        {
            m_gameId = gameId;
            return this;
        }

        public ContainerBuilder teamId(Integer teamId)
        {
            m_teamId = teamId;
            return this;
        }

        public ContainerBuilder playerId(Integer playerId)
        {
            m_playerId = playerId;
            return this;
        }

        public ContainerBuilder gamePlayed(Integer gamePlayed)
        {
            m_gamePlayed = gamePlayed;
            return this;
        }

        public ContainerBuilder position(StartMemberPosition position)
        {
            m_position = position;
            return this;
        }

        public ContainerBuilder minutes(Integer minutes)
        {
            m_minutes = minutes;
            return this;
        }

        public ContainerBuilder minutesSec(Integer minutesSec)
        {
            m_minutesSec = minutesSec;
            return this;
        }

        public ContainerBuilder points(Integer points)
        {
            m_points = points;
            return this;
        }

        public ContainerBuilder fieldGoalsMade(Integer fieldGoalsMade)
        {
            m_fieldGoalsMade = fieldGoalsMade;
            return this;
        }

        public ContainerBuilder fieldGoalsAttempted(Integer fieldGoalsAttempted)
        {
            m_fieldGoalsAttempted = fieldGoalsAttempted;
            return this;
        }

        public ContainerBuilder threePointsMade(Integer threePointsMade)
        {
            m_threePointsMade = threePointsMade;
            return this;
        }

        public ContainerBuilder threePointsAttempted(Integer threePointsAttempted)
        {
            m_threePointsAttempted = threePointsAttempted;
            return this;
        }

        public ContainerBuilder freeThrowMade(Integer freeThrowMade)
        {
            m_freeThrowMade = freeThrowMade;
            return this;
        }

        public ContainerBuilder freeThrowAttempted(Integer freeThrowAttempted)
        {
            m_freeThrowAttempted = freeThrowAttempted;
            return this;
        }

        public ContainerBuilder rebounds(Integer rebounds)
        {
            m_rebounds = rebounds;
            return this;
        }

        public ContainerBuilder offensiveRebounds(Integer offensiveRebounds)
        {
            m_offensiveRebounds = offensiveRebounds;
            return this;
        }

        public ContainerBuilder defensiveRebounds(Integer deffensiveRebounds)
        {
            m_defensiveRebounds = deffensiveRebounds;
            return this;
        }

        public ContainerBuilder assists(Integer assists)
        {
            m_assists = assists;
            return this;
        }

        public ContainerBuilder steals(Integer steals)
        {
            m_steals = steals;
            return this;
        }

        public ContainerBuilder blocks(Integer blocks)
        {
            m_blocks = blocks;
            return this;
        }

        public ContainerBuilder personalFouls(Integer personalFouls)
        {
            m_personalFouls = personalFouls;
            return this;
        }

        public ContainerBuilder turnover(Integer turnover)
        {
            m_turnover = turnover;
            return this;
        }

        public ContainerBuilder plusMinus(Integer plusMinus)
        {
            m_plusMinus = plusMinus;
            return this;
        }

        public ContainerBuilder sort(Float sort)
        {
            m_sort = sort;
            return this;
        }

        public ContainerBuilder doubleDouble(Boolean doubleDouble)
        {
            m_doubleDouble = doubleDouble;
            return this;
        }

        public ContainerBuilder tripleDouble(Boolean tripleDouble)
        {
            m_tripleDouble = tripleDouble;
            return this;
        }

        public ContainerBuilder eject(Boolean eject)
        {
            m_eject = eject;
            return this;
        }

        @Override
        public BoxscoreDao build()
        {
            return new BoxscoreDao(this);
        }
    }

    public enum StartMemberPosition implements Parameters
    {
        NO_GAME_STARTED("0"),

        CENTER("1"),

        POWER_FORWARD("2"),

        SMALL_FORWARD("3"),

        SHOOTING_GUARD("4"),

        POINT_GUARD("5");

        private String m_val;

        private StartMemberPosition(String val)
        {
            m_val = val;
        }

        @Override
        public String val()
        {
            return m_val;
        }

        @Override
        public Parameters unknown()
        {
            return NO_GAME_STARTED;
        }
    }
}
