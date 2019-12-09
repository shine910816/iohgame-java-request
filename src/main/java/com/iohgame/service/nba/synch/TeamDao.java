package com.iohgame.service.nba.synch;

import com.iohgame.framework.connect.mysql.parameters.Dao;
import com.iohgame.framework.utility.parameters.property.Builder;
import com.iohgame.framework.utility.parameters.property.Parameters;

public class TeamDao implements Dao
{
    private final Integer m_teamId;
    private final String m_name;
    private final String m_shortName;
    private final String m_cityCn;
    private final String m_nameCn;
    private final Conference m_conference;
    private final Division m_division;

    private TeamDao(ContainerBuilder builder)
    {
        m_teamId = builder.m_teamId;
        m_name = builder.m_name;
        m_shortName = builder.m_shortName;
        m_cityCn = builder.m_cityCn;
        m_nameCn = builder.m_nameCn;
        m_conference = builder.m_conference;
        m_division = builder.m_division;
    }

    public Integer teamId()
    {
        return m_teamId;
    }

    public String name()
    {
        return m_name;
    }

    public String shortName()
    {
        return m_shortName;
    }

    public String cityCn()
    {
        return m_cityCn;
    }

    public String nameCn()
    {
        return m_nameCn;
    }

    public Conference conference()
    {
        return m_conference;
    }

    public Division division()
    {
        return m_division;
    }

    public static class ContainerBuilder implements Builder<TeamDao>
    {
        private Integer m_teamId;
        private String m_name;
        private String m_shortName;
        private String m_cityCn;
        private String m_nameCn;
        private Conference m_conference;
        private Division m_division;

        public ContainerBuilder teamId(Integer teamId)
        {
            m_teamId = teamId;
            return this;
        }

        public ContainerBuilder name(String name)
        {
            m_name = name;
            return this;
        }

        public ContainerBuilder shortName(String shortName)
        {
            m_shortName = shortName;
            return this;
        }

        public ContainerBuilder cityCn(String cityCn)
        {
            m_cityCn = cityCn;
            return this;
        }

        public ContainerBuilder nameCn(String nameCn)
        {
            m_nameCn = nameCn;
            return this;
        }

        public ContainerBuilder conference(Conference conference)
        {
            m_conference = conference;
            return this;
        }

        public ContainerBuilder division(Division division)
        {
            m_division = division;
            return this;
        }

        @Override
        public TeamDao build()
        {
            return new TeamDao(this);
        }
    }

    public enum Conference implements Parameters
    {
        EASTERN("1"),

        WESTERN("2");

        private String m_val;

        private Conference(String val)
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
            return null;
        }
    }

    public enum Division implements Parameters
    {
        SOUTHEAST("1"),

        ATLANTIC("2"),

        CENTERAL("3"),

        SOUTHWEST("4"),

        PACIFIC("5"),

        NORTHWEST("6");

        private String m_val;

        private Division(String val)
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
            return null;
        }
    }
}
