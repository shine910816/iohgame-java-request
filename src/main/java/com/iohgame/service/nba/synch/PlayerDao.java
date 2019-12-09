package com.iohgame.service.nba.synch;

import java.util.Date;

import com.iohgame.framework.connect.mysql.parameters.Dao;
import com.iohgame.framework.utility.parameters.property.Builder;
import com.iohgame.framework.utility.parameters.property.Parameters;

public class PlayerDao implements Dao
{
    private final Integer m_playerId;
    private final Integer m_teamId;
    private final String m_firstName;
    private final String m_lastName;
    private final PlayerPosition m_position;
    private final PlayerPosition m_position2;
    private final String m_country;
    private final Date m_birthdate;
    private final Float m_height;
    private final Float m_weight;
    private final Integer m_jersey;
    private final Boolean m_isStandard;
    private final Boolean m_isAfrica;
    private final Boolean m_isSacramento;
    private final Boolean m_isVegas;
    private final Boolean m_isUtah;
    private final Boolean m_isView;

    private PlayerDao(ContainerBuilder builder)
    {
        m_playerId = builder.m_playerId;
        m_teamId = builder.m_teamId;
        m_firstName = builder.m_firstName;
        m_lastName = builder.m_lastName;
        m_position = builder.m_position;
        m_position2 = builder.m_position2;
        m_country = builder.m_country;
        m_birthdate = builder.m_birthdate;
        m_height = builder.m_height;
        m_weight = builder.m_weight;
        m_jersey = builder.m_jersey;
        m_isStandard = builder.m_isStandard;
        m_isAfrica = builder.m_isAfrica;
        m_isSacramento = builder.m_isSacramento;
        m_isVegas = builder.m_isVegas;
        m_isUtah = builder.m_isUtah;
        m_isView = builder.m_isView;
    }

    public Integer playerId()
    {
        return m_playerId;
    }

    public Integer teamId()
    {
        return m_teamId;
    }

    public String firstName()
    {
        return m_firstName;
    }

    public String lastName()
    {
        return m_lastName;
    }

    public PlayerPosition position()
    {
        return m_position;
    }

    public PlayerPosition position2()
    {
        return m_position2;
    }

    public String country()
    {
        return m_country;
    }

    public Date birthdate()
    {
        return m_birthdate;
    }

    public Float height()
    {
        return m_height;
    }

    public Float weight()
    {
        return m_weight;
    }

    public Integer jersey()
    {
        return m_jersey;
    }

    public Boolean isStandard()
    {
        return m_isStandard;
    }

    public Boolean isAfrica()
    {
        return m_isAfrica;
    }

    public Boolean isSacramento()
    {
        return m_isSacramento;
    }

    public Boolean isVegas()
    {
        return m_isVegas;
    }

    public Boolean isUtah()
    {
        return m_isUtah;
    }

    public Boolean isView()
    {
        return m_isView;
    }

    public static class ContainerBuilder implements Builder<PlayerDao>
    {
        private Integer m_playerId;
        private Integer m_teamId;
        private String m_firstName;
        private String m_lastName;
        private PlayerPosition m_position;
        private PlayerPosition m_position2;
        private String m_country;
        private Date m_birthdate;
        private Float m_height;
        private Float m_weight;
        private Integer m_jersey;
        private Boolean m_isStandard;
        private Boolean m_isAfrica;
        private Boolean m_isSacramento;
        private Boolean m_isVegas;
        private Boolean m_isUtah;
        private Boolean m_isView;

        public ContainerBuilder playerId(Integer playerId)
        {
            m_playerId = playerId;
            return this;
        }

        public ContainerBuilder teamId(Integer teamId)
        {
            m_teamId = teamId;
            return this;
        }

        public ContainerBuilder firstName(String firstName)
        {
            m_firstName = firstName;
            return this;
        }

        public ContainerBuilder lastName(String lastName)
        {
            m_lastName = lastName;
            return this;
        }

        public ContainerBuilder position(PlayerPosition position)
        {
            m_position = position;
            return this;
        }

        public ContainerBuilder position2(PlayerPosition position)
        {
            m_position2 = position;
            return this;
        }

        public ContainerBuilder country(String country)
        {
            m_country = country;
            return this;
        }

        public ContainerBuilder birthdate(Date birthdate)
        {
            m_birthdate = birthdate;
            return this;
        }

        public ContainerBuilder height(Float height)
        {
            m_height = height;
            return this;
        }

        public ContainerBuilder weight(Float weight)
        {
            m_weight = weight;
            return this;
        }

        public ContainerBuilder jersey(Integer jersey)
        {
            m_jersey = jersey;
            return this;
        }

        public ContainerBuilder isStandard(Boolean isStandard)
        {
            m_isStandard = isStandard;
            return this;
        }

        public ContainerBuilder isAfrica(Boolean isAfrica)
        {
            m_isAfrica = isAfrica;
            return this;
        }

        public ContainerBuilder isSacramento(Boolean isSacramento)
        {
            m_isSacramento = isSacramento;
            return this;
        }

        public ContainerBuilder isVegas(Boolean isVegas)
        {
            m_isVegas = isVegas;
            return this;
        }

        public ContainerBuilder isUtah(Boolean isUtah)
        {
            m_isUtah = isUtah;
            return this;
        }

        public ContainerBuilder isView(Boolean isView)
        {
            m_isView = isView;
            return this;
        }

        @Override
        public PlayerDao build()
        {
            return new PlayerDao(this);
        }
    }

    public enum PlayerPosition implements Parameters
    {
        CENTER("1"),

        FORWARD("2"),

        GUARD("3"),

        NONE("0");

        private String m_val;

        private PlayerPosition(String val)
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

    public enum PlayerLeague implements Parameters
    {
        UTAH("4", "utah"),

        VEGAS("3", "vegas"),

        SACRAMENTO("2", "sacramento"),

        AFRICA("1", "africa"),

        STANDARD("0", "standard");

        private String m_val;
        private String m_name;

        private PlayerLeague(String val, String name)
        {
            m_val = val;
            m_name = name;
        }

        @Override
        public String val()
        {
            return m_val;
        }

        public String leagueName()
        {
            return m_name;
        }

        @Override
        public Parameters unknown()
        {
            return null;
        }
    }
}
