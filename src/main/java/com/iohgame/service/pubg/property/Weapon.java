package com.iohgame.service.pubg.property;

import com.iohgame.framework.utility.parameters.property.OptionElement;

public enum Weapon implements OptionElement
{
    ;

    private String m_val;
    private String m_name;

    private Weapon(String val, String name)
    {
        m_val = val;
        m_name = name;
    }

    @Override
    public String val()
    {
        return m_val;
    }

    public String getName()
    {
        return m_name;
    }
}
