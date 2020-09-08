package com.iohgame.service.nba.avod;

import com.iohgame.framework.connect.mysql.parameters.Dao;
import com.iohgame.framework.utility.parameters.property.Builder;

public class NbaAvodDao implements Dao
{
    private final String m_title;
    private final String m_description;
    private final Float m_version;
    private final String m_linkId;

    private NbaAvodDao(ContainerBuilder builder)
    {
        m_title = builder.m_title;
        m_description = builder.m_description;
        m_version = builder.m_version;
        m_linkId = builder.m_linkId;
    }

    public String title()
    {
        return m_title;
    }

    public String description()
    {
        return m_description;
    }

    public Float version()
    {
        return m_version;
    }

    public String linkId()
    {
        return m_linkId;
    }

    public String link()
    {
        // TODO Request address ?
        return "https://qa-image.nba.rakuten.co.jp/media/ad/" + m_linkId + "_0.xml";
    }

    public static class ContainerBuilder implements Builder<NbaAvodDao>
    {
        private String m_title;
        private String m_description;
        private Float m_version;
        private String m_linkId;

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

        public ContainerBuilder version(Float version)
        {
            m_version = version;
            return this;
        }

        public ContainerBuilder linkId(String linkId)
        {
            m_linkId = linkId;
            return this;
        }

        @Override
        public NbaAvodDao build()
        {
            return new NbaAvodDao(this);
        }
    }
}
