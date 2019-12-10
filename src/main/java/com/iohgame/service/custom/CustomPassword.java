package com.iohgame.service.custom;

import com.iohgame.framework.connect.mysql.parameters.Dao;
import com.iohgame.framework.utility.parameters.property.Builder;

public class CustomPassword implements Dao
{
    private final Integer m_customId;
    private final String m_customSalt;
    private final String m_customPassword;

    private CustomPassword(ContainerBuilder builder)
    {
        m_customId = builder.m_customId;
        m_customSalt = builder.m_customSalt;
        m_customPassword = builder.m_customPassword;
    }

    public Integer customId()
    {
        return m_customId;
    }

    public String customSalt()
    {
        return m_customSalt;
    }

    public String customPassword()
    {
        return m_customPassword;
    }

    public static class ContainerBuilder implements Builder<CustomPassword>
    {
        private Integer m_customId;
        private String m_customSalt;
        private String m_customPassword;

        public ContainerBuilder customId(Integer customId)
        {
            m_customId = customId;
            return this;
        }

        public ContainerBuilder customSalt(String customSalt)
        {
            m_customSalt = customSalt;
            return this;
        }

        public ContainerBuilder customPassword(String customPassword)
        {
            m_customPassword = customPassword;
            return this;
        }

        @Override
        public CustomPassword build()
        {
            return new CustomPassword(this);
        }
    }
}
