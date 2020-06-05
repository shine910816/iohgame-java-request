package com.iohgame.service.pubg;

import com.google.gson.JsonObject;
import com.iohgame.framework.utility.MainClass;
import com.iohgame.service.pubg.property.Weapon;
import com.iohgame.service.pubg.property.WeaponMasteryDao;
import com.iohgame.service.pubg.property.parameters.WeaponMastery;

public class WeaponMasteryImpl extends MainClass implements WeaponMastery
{
    private JsonObject m_weaponMastery;

    public WeaponMasteryImpl(String accountId)
    {
        m_weaponMastery = PubgServiceConnect.getInstance().getWeaponMastery(accountId) //
                .get("data").getAsJsonObject() //
                .get("attributes").getAsJsonObject() //
                .get("weaponSummaries").getAsJsonObject();
    }

    public WeaponMasteryDao getWeaponMasteryDao(Weapon weapon)
    {
        return WeaponMasteryDao.build(m_weaponMastery.get(weapon.val()).getAsJsonObject());
    }

    @Override
    public WeaponMasteryDao p92()
    {
        return getWeaponMasteryDao(Weapon.P92);
    }

    @Override
    public WeaponMasteryDao p1911()
    {
        return getWeaponMasteryDao(Weapon.P1911);
    }

    @Override
    public WeaponMasteryDao m1895()
    {
        return getWeaponMasteryDao(Weapon.M1895);
    }

    @Override
    public WeaponMasteryDao g18c()
    {
        return getWeaponMasteryDao(Weapon.G18C);
    }

    @Override
    public WeaponMasteryDao r45()
    {
        return getWeaponMasteryDao(Weapon.R45);
    }

    @Override
    public WeaponMasteryDao sawnoff()
    {
        return getWeaponMasteryDao(Weapon.SAWNOFF);
    }

    @Override
    public WeaponMasteryDao skorpion()
    {
        return getWeaponMasteryDao(Weapon.SKORPION);
    }

    @Override
    public WeaponMasteryDao desertEagle()
    {
        return getWeaponMasteryDao(Weapon.DESERT_EAGLE);
    }

    @Override
    public WeaponMasteryDao crossbow()
    {
        return getWeaponMasteryDao(Weapon.CROSSBOW);
    }

    @Override
    public WeaponMasteryDao s1897()
    {
        return getWeaponMasteryDao(Weapon.S1897);
    }

    @Override
    public WeaponMasteryDao s686()
    {
        return getWeaponMasteryDao(Weapon.S686);
    }

    @Override
    public WeaponMasteryDao s12k()
    {
        return getWeaponMasteryDao(Weapon.S12K);
    }

    @Override
    public WeaponMasteryDao dbs()
    {
        return getWeaponMasteryDao(Weapon.DBS);
    }

    @Override
    public WeaponMasteryDao uzi()
    {
        return getWeaponMasteryDao(Weapon.UZI);
    }

    @Override
    public WeaponMasteryDao ump45()
    {
        return getWeaponMasteryDao(Weapon.UMP45);
    }

    @Override
    public WeaponMasteryDao vector()
    {
        return getWeaponMasteryDao(Weapon.VECTOR);
    }

    @Override
    public WeaponMasteryDao thompson()
    {
        return getWeaponMasteryDao(Weapon.THOMPSON);
    }

    @Override
    public WeaponMasteryDao pp19()
    {
        return getWeaponMasteryDao(Weapon.PP19);
    }

    @Override
    public WeaponMasteryDao mp5()
    {
        return getWeaponMasteryDao(Weapon.MP5);
    }

    @Override
    public WeaponMasteryDao akm()
    {
        return getWeaponMasteryDao(Weapon.AKM);
    }

    @Override
    public WeaponMasteryDao m16a4()
    {
        return getWeaponMasteryDao(Weapon.M16A4);
    }

    @Override
    public WeaponMasteryDao scarl()
    {
        return getWeaponMasteryDao(Weapon.SCARL);
    }

    @Override
    public WeaponMasteryDao m416()
    {
        return getWeaponMasteryDao(Weapon.M416);
    }

    @Override
    public WeaponMasteryDao groza()
    {
        return getWeaponMasteryDao(Weapon.GROZA);
    }

    @Override
    public WeaponMasteryDao m762()
    {
        return getWeaponMasteryDao(Weapon.M762);
    }

    @Override
    public WeaponMasteryDao qbz()
    {
        return getWeaponMasteryDao(Weapon.QBZ);
    }

    @Override
    public WeaponMasteryDao g36c()
    {
        return getWeaponMasteryDao(Weapon.G36C);
    }

    @Override
    public WeaponMasteryDao aug()
    {
        return getWeaponMasteryDao(Weapon.AUG);
    }

    @Override
    public WeaponMasteryDao mk47()
    {
        return getWeaponMasteryDao(Weapon.MK47);
    }

    @Override
    public WeaponMasteryDao vss()
    {
        return getWeaponMasteryDao(Weapon.VSS);
    }

    @Override
    public WeaponMasteryDao sks()
    {
        return getWeaponMasteryDao(Weapon.SKS);
    }

    @Override
    public WeaponMasteryDao mk14()
    {
        return getWeaponMasteryDao(Weapon.MK14);
    }

    @Override
    public WeaponMasteryDao mini14()
    {
        return getWeaponMasteryDao(Weapon.MINI14);
    }

    @Override
    public WeaponMasteryDao slr()
    {
        return getWeaponMasteryDao(Weapon.SLR);
    }

    @Override
    public WeaponMasteryDao qbu()
    {
        return getWeaponMasteryDao(Weapon.QBU);
    }

    @Override
    public WeaponMasteryDao kar98k()
    {
        return getWeaponMasteryDao(Weapon.KAR98K);
    }

    @Override
    public WeaponMasteryDao m24()
    {
        return getWeaponMasteryDao(Weapon.M24);
    }

    @Override
    public WeaponMasteryDao awm()
    {
        return getWeaponMasteryDao(Weapon.AWM);
    }

    @Override
    public WeaponMasteryDao win94()
    {
        return getWeaponMasteryDao(Weapon.WIN94);
    }

    @Override
    public WeaponMasteryDao mosinNagant()
    {
        return getWeaponMasteryDao(Weapon.MOSIN_NAGANT);
    }

    @Override
    public WeaponMasteryDao m249()
    {
        return getWeaponMasteryDao(Weapon.M249);
    }

    @Override
    public WeaponMasteryDao dp28()
    {
        return getWeaponMasteryDao(Weapon.DP28);
    }
}
