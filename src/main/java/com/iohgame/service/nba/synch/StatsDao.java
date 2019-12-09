package com.iohgame.service.nba.synch;

import com.iohgame.framework.connect.mysql.parameters.Dao;
import com.iohgame.framework.utility.parameters.property.Builder;
import com.iohgame.framework.utility.parameters.property.Parameters;

public class StatsDao implements Dao
{
    private final Integer m_season;
    private final SeasonStage m_seasonStage;
    private final StatsType m_statsType;
    private final Float m_ppg;
    private final Float m_rpg;
    private final Float m_apg;
    private final Float m_spg;
    private final Float m_bpg;
    private final Float m_fgp;
    private final Float m_tpp;
    private final Float m_ftp;
    private final Float m_opg;
    private final Float m_dpg;
    private final Float m_tpg;
    private final Float m_fpg;

    private StatsDao(ContainerBuilder builder)
    {
        m_season = builder.m_season;
        m_seasonStage = builder.m_seasonStage;
        m_statsType = builder.m_statsType;
        m_ppg = builder.m_ppg;
        m_rpg = builder.m_rpg;
        m_apg = builder.m_apg;
        m_spg = builder.m_spg;
        m_bpg = builder.m_bpg;
        m_fgp = builder.m_fgp;
        m_tpp = builder.m_tpp;
        m_ftp = builder.m_ftp;
        m_opg = builder.m_opg;
        m_dpg = builder.m_dpg;
        m_tpg = builder.m_tpg;
        m_fpg = builder.m_fpg;
    }

    public Integer season()
    {
        return m_season;
    }

    public SeasonStage seasonStage()
    {
        return m_seasonStage;
    }

    public StatsType statsType()
    {
        return m_statsType;
    }

    public Float ppg()
    {
        return m_ppg;
    }

    public Float rpg()
    {
        return m_rpg;
    }

    public Float apg()
    {
        return m_apg;
    }

    public Float spg()
    {
        return m_spg;
    }

    public Float bpg()
    {
        return m_bpg;
    }

    public Float fgp()
    {
        return m_fgp;
    }

    public Float tpp()
    {
        return m_tpp;
    }

    public Float ftp()
    {
        return m_ftp;
    }

    public Float opg()
    {
        return m_opg;
    }

    public Float dpg()
    {
        return m_dpg;
    }

    public Float tpg()
    {
        return m_tpg;
    }

    public Float fpg()
    {
        return m_fpg;
    }

    public static class ContainerBuilder implements Builder<StatsDao>
    {
        private Integer m_season;
        private SeasonStage m_seasonStage;
        private StatsType m_statsType;
        private Float m_ppg;
        private Float m_rpg;
        private Float m_apg;
        private Float m_spg;
        private Float m_bpg;
        private Float m_fgp;
        private Float m_tpp;
        private Float m_ftp;
        private Float m_opg;
        private Float m_dpg;
        private Float m_tpg;
        private Float m_fpg;

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

        public ContainerBuilder statsType(StatsType statsType)
        {
            m_statsType = statsType;
            return this;
        }

        public ContainerBuilder ppg(Float ppg)
        {
            m_ppg = ppg;
            return this;
        }

        public ContainerBuilder rpg(Float rpg)
        {
            m_rpg = rpg;
            return this;
        }

        public ContainerBuilder apg(Float apg)
        {
            m_apg = apg;
            return this;
        }

        public ContainerBuilder spg(Float spg)
        {
            m_spg = spg;
            return this;
        }

        public ContainerBuilder bpg(Float bpg)
        {
            m_bpg = bpg;
            return this;
        }

        public ContainerBuilder fgp(Float fgp)
        {
            m_fgp = fgp;
            return this;
        }

        public ContainerBuilder tpp(Float tpp)
        {
            m_tpp = tpp;
            return this;
        }

        public ContainerBuilder ftp(Float ftp)
        {
            m_ftp = ftp;
            return this;
        }

        public ContainerBuilder opg(Float opg)
        {
            m_opg = opg;
            return this;
        }

        public ContainerBuilder dpg(Float dpg)
        {
            m_dpg = dpg;
            return this;
        }

        public ContainerBuilder tpg(Float tpg)
        {
            m_tpg = tpg;
            return this;
        }

        public ContainerBuilder fpg(Float fpg)
        {
            m_fpg = fpg;
            return this;
        }

        @Override
        public StatsDao build()
        {
            return new StatsDao(this);
        }
    }

    public enum StatsType implements Parameters
    {
        PLAYER("1"),

        TEAM("2"),

        UNKNOWN("0");

        private String m_val;

        private StatsType(String val)
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
