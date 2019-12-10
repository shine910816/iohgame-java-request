package com.iohgame.service.point;

import java.util.Date;

import com.iohgame.framework.connect.mysql.parameters.Dao;
import com.iohgame.framework.utility.parameters.property.Builder;
import com.iohgame.framework.utility.parameters.property.Parameters;

public class CustomPointHistoryDao implements Dao
{
    private final Integer m_pointId;
    private final Integer m_customId;
    private final Integer m_pointValue;
    private final PointType m_pointType;
    private final String m_pointNote;
    private final Integer m_pointBefore;
    private final Integer m_pointAfter;
    private final Date m_insertDate;

    private CustomPointHistoryDao(ContainerBuilder builder)
    {
        m_pointId = builder.m_pointId;
        m_customId = builder.m_customId;
        m_pointValue = builder.m_pointValue;
        m_pointType = builder.m_pointType;
        m_pointNote = builder.m_pointNote;
        m_pointBefore = builder.m_pointBefore;
        m_pointAfter = builder.m_pointAfter;
        m_insertDate = builder.m_insertDate;
    }

    public Integer pointId()
    {
        return m_pointId;
    }

    public Integer customId()
    {
        return m_customId;
    }

    public Integer pointValue()
    {
        return m_pointValue;
    }

    public PointType pointType()
    {
        return m_pointType;
    }

    public String pointNote()
    {
        return m_pointNote;
    }

    public Integer pointBefore()
    {
        return m_pointBefore;
    }

    public Integer pointAfter()
    {
        return m_pointAfter;
    }

    public Date insertDate()
    {
        return m_insertDate;
    }

    public static class ContainerBuilder implements Builder<CustomPointHistoryDao>
    {
        private Integer m_pointId;
        private Integer m_customId;
        private Integer m_pointValue;
        private PointType m_pointType;
        private String m_pointNote;
        private Integer m_pointBefore;
        private Integer m_pointAfter;
        private Date m_insertDate;

        public ContainerBuilder pointId(Integer pointId)
        {
            m_pointId = pointId;
            return this;
        }

        public ContainerBuilder customId(Integer customId)
        {
            m_customId = customId;
            return this;
        }

        public ContainerBuilder pointValue(Integer pointValue)
        {
            m_pointValue = pointValue;
            return this;
        }

        public ContainerBuilder pointType(PointType pointType)
        {
            m_pointType = pointType;
            return this;
        }

        public ContainerBuilder pointNote(String pointNote)
        {
            m_pointNote = pointNote;
            return this;
        }

        public ContainerBuilder pointBefore(Integer pointBefore)
        {
            m_pointBefore = pointBefore;
            return this;
        }

        public ContainerBuilder pointAfter(Integer pointAfter)
        {
            m_pointAfter = pointAfter;
            return this;
        }

        public ContainerBuilder insertDate(Date insertDate)
        {
            m_insertDate = insertDate;
            return this;
        }

        @Override
        public CustomPointHistoryDao build()
        {
            return new CustomPointHistoryDao(this);
        }
    }

    public enum PointType implements Parameters
    {
        REGISTER("0"),

        SIGNIN("1"),

        SERVICE("2"),

        COMPENSATE("3"),

        BIRTHDAY("4");

        private String m_val;

        private PointType(String val)
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
