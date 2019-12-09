package com.iohgame.service.nba.synch;

import com.iohgame.framework.utility.parameters.property.Parameters;

public enum SeasonStage implements Parameters
{
    PRESEASON("1"),

    REGULAR("2"),

    ALL_STAR("3"),

    PLAYOFFS("4"),

    FINAL("5");

    private String m_val;

    private SeasonStage(String val)
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
