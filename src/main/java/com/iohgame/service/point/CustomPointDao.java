package com.iohgame.service.point;

import com.iohgame.framework.connect.mysql.parameters.Dao;
import com.iohgame.framework.utility.parameters.property.Builder;

public class CustomPointDao implements Dao
{
    private final Integer m_customId;
    private final Integer m_customPoint;

    private CustomPointDao(ContainerBuilder builder)
    {
        m_customId = builder.m_customId;
        m_customPoint = builder.m_customPoint;
    }

    public Integer customId()
    {
        return m_customId;
    }

    public Integer customPoint()
    {
        return m_customPoint;
    }

    public static class ContainerBuilder implements Builder<CustomPointDao>
    {
        private Integer m_customId;
        private Integer m_customPoint;

        public ContainerBuilder customId(Integer customId)
        {
            m_customId = customId;
            return this;
        }

        public ContainerBuilder customPoint(Integer customPoint)
        {
            m_customPoint = customPoint;
            return this;
        }

        @Override
        public CustomPointDao build()
        {
            return new CustomPointDao(this);
        }
    }
}
