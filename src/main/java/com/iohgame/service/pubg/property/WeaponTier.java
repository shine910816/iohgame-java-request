package com.iohgame.service.pubg.property;

import com.iohgame.framework.utility.parameters.property.Parameters;

public enum WeaponTier implements Parameters
{
    WEAPON_TIER_1("1", "新手"),

    WEAPON_TIER_2("2", "学徒"),

    WEAPON_TIER_3("3", "初学者"),

    WEAPON_TIER_4("4", "业余"),

    WEAPON_TIER_5("5", "专业"),

    WEAPON_TIER_6("6", "职业"),

    WEAPON_TIER_7("7", ""),

    WEAPON_TIER_8("8", ""),

    WEAPON_TIER_9("9", ""),

    WEAPON_TIER_10("10", "王牌");

    private String m_val;
    private String m_name;

    private WeaponTier(String val, String name)
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

    @Override
    public Parameters unknown()
    {
        return null;
    }
}
