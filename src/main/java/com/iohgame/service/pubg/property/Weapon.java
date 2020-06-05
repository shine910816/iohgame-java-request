package com.iohgame.service.pubg.property;

import com.iohgame.framework.utility.parameters.property.Parameters;

public enum Weapon implements Parameters
{
    P92("Item_Weapon_M9_C", "P92"),

    P1911("Item_Weapon_M1911_C", "P1911"),

    M1895("Item_Weapon_NagantM1895_C", "M1895"),

    G18C("Item_Weapon_G18_C", "G18C"),

    R45("Item_Weapon_Rhino_C", "R45"),

    SAWNOFF("Item_Weapon_Sawnoff_C", "锯短霰弹枪"),

    SKORPION("Item_Weapon_vz61Skorpion_C", "蝎式手枪"),

    DESERT_EAGLE("Item_Weapon_DesertEagle_C", "沙漠之鹰"),

    CROSSBOW("Item_Weapon_Crossbow_C", "十字弩"),

    S1897("Item_Weapon_Winchester_C", "S1897"),

    S686("Item_Weapon_Berreta686_C", "S686"),

    S12K("Item_Weapon_Saiga12_C", "S12K"),

    DBS("Item_Weapon_DP12_C", "DBS"),

    UZI("Item_Weapon_UZI_C", "Micro-UZI"),

    UMP45("Item_Weapon_UMP_C", "UMP45"),

    VECTOR("Item_Weapon_Vector_C", "Vector"),

    THOMPSON("Item_Weapon_Thompson_C", "汤姆逊"),

    PP19("Item_Weapon_BizonPP19_C", "PP19"),

    MP5("Item_Weapon_MP5K_C", "MP5K"),

    AKM("Item_Weapon_AK47_C", "AKM"),

    M16A4("Item_Weapon_M16A4_C", "M16A4"),

    SCARL("Item_Weapon_SCAR-L_C", "SCAR-L"),

    M416("Item_Weapon_HK416_C", "M416"),

    GROZA("Item_Weapon_Groza_C", "Groza"),

    M762("Item_Weapon_BerylM762_C", "M762"),

    QBZ("Item_Weapon_QBZ95_C", "QBZ"),

    G36C("Item_Weapon_G36C_C", "G36C"),

    AUG("Item_Weapon_AUG_C", "AUG"),

    MK47("Item_Weapon_Mk47Mutant_C", "Mk47Mutant"),

    VSS("Item_Weapon_VSS_C", "VSS"),

    SKS("Item_Weapon_SKS_C", "SKS"),

    MK14("Item_Weapon_Mk14_C", "Mk14"),

    MINI14("Item_Weapon_Mini14_C", "Mini14"),

    SLR("Item_Weapon_FNFal_C", "自动装填步枪"),

    QBU("Item_Weapon_QBU88_C", "QBU"),

    KAR98K("Item_Weapon_Kar98k_C", "Kar98k"),

    M24("Item_Weapon_M24_C", "M24"),

    AWM("Item_Weapon_AWM_C", "AWM"),

    WIN94("Item_Weapon_Win1894_C", "Win94"),

    MOSIN_NAGANT("Item_Weapon_Mosin_C", "莫辛纳甘"),

    M249("Item_Weapon_M249_C", "M249"),

    DP28("Item_Weapon_DP28_C", "DP28");

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

    @Override
    public Parameters unknown()
    {
        return null;
    }
}
