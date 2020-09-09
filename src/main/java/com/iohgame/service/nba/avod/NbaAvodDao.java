package com.iohgame.service.nba.avod;

import com.iohgame.framework.connect.mysql.parameters.Dao;
import com.iohgame.framework.utility.parameters.property.Builder;

public class NbaAvodDao implements Dao
{
    private final String m_title;
    private final String m_description;
    private final String m_link;

    private NbaAvodDao(ContainerBuilder builder)
    {
        m_title = builder.m_title;
        m_description = builder.m_description;
        m_link = builder.m_link;
    }

    public String title()
    {
        return m_title;
    }

    public String description()
    {
        return m_description;
    }

    public String link()
    {
        return m_link;
    }

    public static class ContainerBuilder implements Builder<NbaAvodDao>
    {
        private String m_title;
        private String m_description;
        private String m_link;

        public ContainerBuilder title(String title)
        {
            m_title = title;
            return this;
        }

        public ContainerBuilder description(String description)
        {
            m_description = description;
            return this;
        }

        public ContainerBuilder link(String link)
        {
            m_link = link;
            return this;
        }

        @Override
        public NbaAvodDao build()
        {
            return new NbaAvodDao(this);
        }
    }
}
