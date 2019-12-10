package com.iohgame.service.custom;

import java.util.Date;

import com.iohgame.framework.connect.mysql.parameters.Dao;
import com.iohgame.framework.utility.parameters.property.Builder;
import com.iohgame.framework.utility.parameters.property.Parameters;

public class CustomInfoDao implements Dao
{
    private final Integer m_customId;
    private final String m_customLoginName;
    private final Boolean m_customHasTel;
    private final Boolean m_customHasMail;
    private final String m_customTelNumber;
    private final String m_customMailAddr;
    private final String m_customNick;
    private final CustomGender m_customGender;
    private final Date m_customBirth;
    private final Boolean m_customHasConfirm;
    private final OpenLevel m_customOpenLevel;

    private CustomInfoDao(ContainerBuilder builder)
    {
        m_customId = builder.m_customId;
        m_customLoginName = builder.m_customLoginName;
        m_customHasTel = builder.m_customHasTel;
        m_customHasMail = builder.m_customHasMail;
        m_customTelNumber = builder.m_customTelNumber;
        m_customMailAddr = builder.m_customMailAddr;
        m_customNick = builder.m_customNick;
        m_customGender = builder.m_customGender;
        m_customBirth = builder.m_customBirth;
        m_customHasConfirm = builder.m_customHasConfirm;
        m_customOpenLevel = builder.m_customOpenLevel;
    }

    public Integer customId()
    {
        return m_customId;
    }

    public String customLoginName()
    {
        return m_customLoginName;
    }

    public Boolean customHasTel()
    {
        return m_customHasTel;
    }

    public Boolean customHasMail()
    {
        return m_customHasMail;
    }

    public String customTelNumber()
    {
        return m_customTelNumber;
    }

    public String customMailAddr()
    {
        return m_customMailAddr;
    }

    public String customNick()
    {
        return m_customNick;
    }

    public CustomGender customGender()
    {
        return m_customGender;
    }

    public Date customBirth()
    {
        return m_customBirth;
    }

    public Boolean customHasConfirm()
    {
        return m_customHasConfirm;
    }

    public OpenLevel customOpenLevel()
    {
        return m_customOpenLevel;
    }

    public static class ContainerBuilder implements Builder<CustomInfoDao>
    {
        private Integer m_customId;
        private String m_customLoginName;
        private Boolean m_customHasTel;
        private Boolean m_customHasMail;
        private String m_customTelNumber;
        private String m_customMailAddr;
        private String m_customNick;
        private CustomGender m_customGender;
        private Date m_customBirth;
        private Boolean m_customHasConfirm;
        private OpenLevel m_customOpenLevel;

        public ContainerBuilder customId(Integer customId)
        {
            m_customId = customId;
            return this;
        }

        public ContainerBuilder customLoginName(String customLoginName)
        {
            m_customLoginName = customLoginName;
            return this;
        }

        public ContainerBuilder customHasTel(Boolean customHasTel)
        {
            m_customHasTel = customHasTel;
            return this;
        }

        public ContainerBuilder customHasMail(Boolean customHasMail)
        {
            m_customHasMail = customHasMail;
            return this;
        }

        public ContainerBuilder customTelNumber(String customTelNumber)
        {
            m_customTelNumber = customTelNumber;
            return this;
        }

        public ContainerBuilder customMailAddr(String customMailAddr)
        {
            m_customMailAddr = customMailAddr;
            return this;
        }

        public ContainerBuilder customNick(String customNick)
        {
            m_customNick = customNick;
            return this;
        }

        public ContainerBuilder customGender(CustomGender customGender)
        {
            m_customGender = customGender;
            return this;
        }

        public ContainerBuilder customBirth(Date customBirth)
        {
            m_customBirth = customBirth;
            return this;
        }

        public ContainerBuilder customHasConfirm(Boolean customHasConfirm)
        {
            m_customHasConfirm = customHasConfirm;
            return this;
        }

        public ContainerBuilder customOpenLevel(OpenLevel customOpenLevel)
        {
            m_customOpenLevel = customOpenLevel;
            return this;
        }

        @Override
        public CustomInfoDao build()
        {
            return new CustomInfoDao(this);
        }
    }

    public enum CustomGender implements Parameters
    {
        FEMALE("0"),

        MALE("1");

        private String m_val;

        private CustomGender(String val)
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

    public enum OpenLevel implements Parameters
    {
        SELF("0"),

        FRIEND("1"),

        TOTAL("2");

        private String m_val;

        private OpenLevel(String val)
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
