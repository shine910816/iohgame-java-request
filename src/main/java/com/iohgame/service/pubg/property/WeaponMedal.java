package com.iohgame.service.pubg.property;

import com.iohgame.framework.utility.parameters.property.Parameters;

public enum WeaponMedal implements Parameters
{
    DEAD_EYE("MedalDeadeye", "死亡之眼", ""),

    ASSASSIN("MedalAssassin", "刺客", ""),

    DOUBLE_KILL("MedalDoubleKill", "双击败", ""),

    TRIPLE_KILL("MedalTripleKill", "三击败", ""),

    QUAD_KILL("MedalQuadKill", "四击败", ""),

    LAST_MAN_STANDING("MedalLastManStanding", "最终生存者", ""),

    PUNISHER("MedalPunisher", "子弹暴雨", ""),

    LONG_SHOT("MedalLongshot", "远距离", ""),

    FRENZY("MedalFrenzy", "狂战士", ""),

    RAMPAGE("MedalRampage", "奋勇突进", ""),

    ANNIHILATION("MedalAnnihilation", "全部淘汰", ""),

    FIRST_BLOOD("MedalFirstBlood", "第一滴血", "");

    private String m_val;
    private String m_name;
    private String m_desc;

    private WeaponMedal(String val, String name, String desc)
    {
        m_val = val;
        m_name = name;
        m_desc = desc;
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

    public String getDesc()
    {
        return m_desc;
    }

    @Override
    public Parameters unknown()
    {
        return null;
    }
}
