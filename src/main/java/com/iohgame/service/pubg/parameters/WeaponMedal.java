package com.iohgame.service.pubg.parameters;

import com.iohgame.framework.utility.parameters.property.OptionElement;

public enum WeaponMedal implements OptionElement
{
    DEAD_EYE("MedalDeadeye","",""),

    ASSASSIN("MedalAssassin","",""),

    DOUBLE_KILL("MedalDoubleKill","",""),

    PUNISHER("MedalPunisher","",""),

    FRENZY("MedalFrenzy","",""),

    LAST_MAN_STANDING("MedalLastManStanding","",""),

    RAMPAGE("MedalRampage","",""),

    LONGSHOT("MedalLongshot","",""),

    FIRST_BLOOD("MedalFirstBlood","",""),

    TRIPLE_KILL("MedalTripleKill","",""),

    QUAD_KILL("MedalQuadKill","",""),

    ANNIHILATION("MedalAnnihilation","","");

    private String m_val;
    private String m_name;
    private String m_desc;

    private WeaponMedal(String val,String name,String desc) {
        m_val=val;
        m_name=name;
        m_desc=desc;
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
}
