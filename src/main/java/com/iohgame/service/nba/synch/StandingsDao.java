package com.iohgame.service.nba.synch;

import com.iohgame.framework.connect.mysql.parameters.Dao;
import com.iohgame.framework.utility.parameters.property.Builder;

public class StandingsDao implements Dao
{
    private final Integer m_teamId;
    private final Integer m_win;
    private final Integer m_loss;
    private final Float m_winPercent;
    private final Float m_gameBehind;
    private final Float m_gameBehindDiv;
    private final Integer m_confRank;
    private final Integer m_confWin;
    private final Integer m_confLoss;
    private final Integer m_divRank;
    private final Integer m_divWin;
    private final Integer m_divLoss;
    private final Integer m_homeWin;
    private final Integer m_homeLoss;
    private final Integer m_awayWin;
    private final Integer m_awayLoss;
    private final Integer m_lastTenWin;
    private final Integer m_lastTenLoss;
    private final Boolean m_winStreak;
    private final Integer m_streak;

    private StandingsDao(ContainerBuilder builder)
    {
        m_teamId = builder.m_teamId;
        m_win = builder.m_win;
        m_loss = builder.m_loss;
        m_winPercent = builder.m_winPercent;
        m_gameBehind = builder.m_gameBehind;
        m_gameBehindDiv = builder.m_gameBehindDiv;
        m_confRank = builder.m_confRank;
        m_confWin = builder.m_confWin;
        m_confLoss = builder.m_confLoss;
        m_divRank = builder.m_divRank;
        m_divWin = builder.m_divWin;
        m_divLoss = builder.m_divLoss;
        m_homeWin = builder.m_homeWin;
        m_homeLoss = builder.m_homeLoss;
        m_awayWin = builder.m_awayWin;
        m_awayLoss = builder.m_awayLoss;
        m_lastTenWin = builder.m_lastTenWin;
        m_lastTenLoss = builder.m_lastTenLoss;
        m_winStreak = builder.m_winStreak;
        m_streak = builder.m_streak;
    }

    public Integer teamId()
    {
        return m_teamId;
    }

    public Integer win()
    {
        return m_win;
    }

    public Integer loss()
    {
        return m_loss;
    }

    public Float winPercent()
    {
        return m_winPercent;
    }

    public Float gameBehind()
    {
        return m_gameBehind;
    }

    public Float gameBehindDiv()
    {
        return m_gameBehindDiv;
    }

    public Integer confRank()
    {
        return m_confRank;
    }

    public Integer confWin()
    {
        return m_confWin;
    }

    public Integer confLoss()
    {
        return m_confLoss;
    }

    public Integer divRank()
    {
        return m_divRank;
    }

    public Integer divWin()
    {
        return m_divWin;
    }

    public Integer divLoss()
    {
        return m_divLoss;
    }

    public Integer homeWin()
    {
        return m_homeWin;
    }

    public Integer homeLoss()
    {
        return m_homeLoss;
    }

    public Integer awayWin()
    {
        return m_awayWin;
    }

    public Integer awayLoss()
    {
        return m_awayLoss;
    }

    public Integer lastTenWin()
    {
        return m_lastTenWin;
    }

    public Integer lastTenLoss()
    {
        return m_lastTenLoss;
    }

    public Boolean winStreak()
    {
        return m_winStreak;
    }

    public Integer streak()
    {
        return m_streak;
    }

    public static class ContainerBuilder implements Builder<StandingsDao>
    {
        private Integer m_teamId;
        private Integer m_win;
        private Integer m_loss;
        private Float m_winPercent;
        private Float m_gameBehind;
        private Float m_gameBehindDiv;
        private Integer m_confRank;
        private Integer m_confWin;
        private Integer m_confLoss;
        private Integer m_divRank;
        private Integer m_divWin;
        private Integer m_divLoss;
        private Integer m_homeWin;
        private Integer m_homeLoss;
        private Integer m_awayWin;
        private Integer m_awayLoss;
        private Integer m_lastTenWin;
        private Integer m_lastTenLoss;
        private Boolean m_winStreak;
        private Integer m_streak;

        public ContainerBuilder teamId(Integer teamId)
        {
            m_teamId = teamId;
            return this;
        }

        public ContainerBuilder win(Integer win)
        {
            m_win = win;
            return this;
        }

        public ContainerBuilder loss(Integer loss)
        {
            m_loss = loss;
            return this;
        }

        public ContainerBuilder winPercent(Float winPercent)
        {
            m_winPercent = winPercent;
            return this;
        }

        public ContainerBuilder gameBehind(Float gameBehind)
        {
            m_gameBehind = gameBehind;
            return this;
        }

        public ContainerBuilder gameBehindDiv(Float gameBehindDiv)
        {
            m_gameBehindDiv = gameBehindDiv;
            return this;
        }

        public ContainerBuilder confRank(Integer confRank)
        {
            m_confRank = confRank;
            return this;
        }

        public ContainerBuilder confWin(Integer confWin)
        {
            m_confWin = confWin;
            return this;
        }

        public ContainerBuilder confLoss(Integer confLoss)
        {
            m_confLoss = confLoss;
            return this;
        }

        public ContainerBuilder divRank(Integer divRank)
        {
            m_divRank = divRank;
            return this;
        }

        public ContainerBuilder divWin(Integer divWin)
        {
            m_divWin = divWin;
            return this;
        }

        public ContainerBuilder divLoss(Integer divLoss)
        {
            m_divLoss = divLoss;
            return this;
        }

        public ContainerBuilder homeWin(Integer homeWin)
        {
            m_homeWin = homeWin;
            return this;
        }

        public ContainerBuilder homeLoss(Integer homeLoss)
        {
            m_homeLoss = homeLoss;
            return this;
        }

        public ContainerBuilder awayWin(Integer awayWin)
        {
            m_awayWin = awayWin;
            return this;
        }

        public ContainerBuilder awayLoss(Integer awayLoss)
        {
            m_awayLoss = awayLoss;
            return this;
        }

        public ContainerBuilder lastTenWin(Integer lastTenWin)
        {
            m_lastTenWin = lastTenWin;
            return this;
        }

        public ContainerBuilder lastTenLoss(Integer lastTenLoss)
        {
            m_lastTenLoss = lastTenLoss;
            return this;
        }

        public ContainerBuilder winStreak(Boolean winStreak)
        {
            m_winStreak = winStreak;
            return this;
        }

        public ContainerBuilder streak(Integer streak)
        {
            m_streak = streak;
            return this;
        }

        @Override
        public StandingsDao build()
        {
            return new StandingsDao(this);
        }
    }
}
