package com.iohgame.service.nba.synch;

import java.util.Date;

import com.iohgame.framework.connect.mysql.parameters.Dao;
import com.iohgame.framework.utility.parameters.property.Builder;
import com.iohgame.framework.utility.parameters.property.Parameters;

public class ScheduleDao implements Dao
{
    private final Integer m_gameId;
    private final Integer m_season;
    private final SeasonStage m_seasonStage;
    private final Integer m_playDate;
    private final String m_name;
    private final Integer m_playDateCn;
    private final Date m_startDate;
    private final String m_arena;
    private final TeamDao m_homeTeam;
    private final TeamDao m_awayTeam;
    private final GameStatus m_gameStatus;
    private final Integer m_homeScore;
    private final Integer m_awayScore;
    private final String m_homeLineScore;
    private final String m_awayLineScore;
    private final Boolean m_isSynch;

    private ScheduleDao(ContainerBuilder builder)
    {
        m_gameId = builder.m_gameId;
        m_season = builder.m_season;
        m_seasonStage = builder.m_seasonStage;
        m_playDate = builder.m_playDate;
        m_name = builder.m_name;
        m_playDateCn = builder.m_playDateCn;
        m_startDate = builder.m_startDate;
        m_arena = builder.m_arena;
        m_homeTeam = builder.m_homeTeam;
        m_awayTeam = builder.m_awayTeam;
        m_gameStatus = builder.m_gameStatus;
        m_homeScore = builder.m_homeScore;
        m_awayScore = builder.m_awayScore;
        m_homeLineScore = builder.m_homeLineScore;
        m_awayLineScore = builder.m_awayLineScore;
        m_isSynch = builder.m_isSynch;
    }

    public Integer gameId()
    {
        return m_gameId;
    }

    public Integer season()
    {
        return m_season;
    }

    public SeasonStage seasonStage()
    {
        return m_seasonStage;
    }

    public Integer playDate()
    {
        return m_playDate;
    }

    public String name()
    {
        return m_name;
    }

    public Integer playDateCn()
    {
        return m_playDateCn;
    }

    public Date startDate()
    {
        return m_startDate;
    }

    public String arena()
    {
        return m_arena;
    }

    public TeamDao homeTeam()
    {
        return m_homeTeam;
    }

    public TeamDao awayTeam()
    {
        return m_awayTeam;
    }

    public GameStatus gameStatus()
    {
        return m_gameStatus;
    }

    public Integer homeScore()
    {
        return m_homeScore;
    }

    public Integer awayScore()
    {
        return m_awayScore;
    }

    public String homeLineScore()
    {
        return m_homeLineScore;
    }

    public String awayLineScore()
    {
        return m_awayLineScore;
    }

    public Boolean isSynch()
    {
        return m_isSynch;
    }

    public static class ContainerBuilder implements Builder<ScheduleDao>
    {
        private Integer m_gameId;
        private Integer m_season;
        private SeasonStage m_seasonStage;
        private Integer m_playDate;
        private String m_name;
        private Integer m_playDateCn;
        private Date m_startDate;
        private String m_arena;
        private TeamDao m_homeTeam;
        private TeamDao m_awayTeam;
        private GameStatus m_gameStatus;
        private Integer m_homeScore;
        private Integer m_awayScore;
        private String m_homeLineScore;
        private String m_awayLineScore;
        private Boolean m_isSynch;

        public ContainerBuilder gameId(Integer gameId)
        {
            m_gameId = gameId;
            return this;
        }

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

        public ContainerBuilder name(String name)
        {
            m_name = name;
            return this;
        }

        public ContainerBuilder playDateCn(Integer playDateCn)
        {
            m_playDateCn = playDateCn;
            return this;
        }

        public ContainerBuilder startDate(Date startDate)
        {
            m_startDate = startDate;
            return this;
        }

        public ContainerBuilder arena(String arena)
        {
            m_arena = arena;
            return this;
        }

        public ContainerBuilder homeTeam(TeamDao homeTeam)
        {
            m_homeTeam = homeTeam;
            return this;
        }

        public ContainerBuilder awayTeam(TeamDao awayTeam)
        {
            m_awayTeam = awayTeam;
            return this;
        }

        public ContainerBuilder gameStatus(GameStatus gameStatus)
        {
            m_gameStatus = gameStatus;
            return this;
        }

        public ContainerBuilder homeScore(Integer homeScore)
        {
            m_homeScore = homeScore;
            return this;
        }

        public ContainerBuilder awayScore(Integer awayScore)
        {
            m_awayScore = awayScore;
            return this;
        }

        public ContainerBuilder homeLineScore(String homeLineScore)
        {
            m_homeLineScore = homeLineScore;
            return this;
        }

        public ContainerBuilder awayLineScore(String awayLineScore)
        {
            m_awayLineScore = awayLineScore;
            return this;
        }

        public ContainerBuilder isSynch(Boolean isSynch)
        {
            m_isSynch = isSynch;
            return this;
        }

        @Override
        public ScheduleDao build()
        {
            return new ScheduleDao(this);
        }
    }

    public enum GameStatus implements Parameters
    {
        NOT_STARTED("1"),

        DOING("2"),

        FINISH("3"),

        UNKNOWN("0");

        private String m_val;

        private GameStatus(String val)
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
            return UNKNOWN;
        }
    }
}
