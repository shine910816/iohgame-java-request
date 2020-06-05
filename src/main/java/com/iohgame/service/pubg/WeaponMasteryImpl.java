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

    @Override
    public WeaponMasteryDao get(Weapon weapon)
    {
        if (!m_weaponMastery.has(weapon.val()))
        {
            return null;
        }
        return WeaponMasteryDao.build(m_weaponMastery.get(weapon.val()).getAsJsonObject());
    }

    @Override
    public WeaponMasteryDao p92()
    {
        return get(Weapon.P92);
    }

    @Override
    public WeaponMasteryDao p1911()
    {
        return get(Weapon.P1911);
    }

    @Override
    public WeaponMasteryDao m1895()
    {
        return get(Weapon.M1895);
    }

    @Override
    public WeaponMasteryDao g18c()
    {
        return get(Weapon.G18C);
    }

    @Override
    public WeaponMasteryDao r45()
    {
        return get(Weapon.R45);
    }

    @Override
    public WeaponMasteryDao sawnoff()
    {
        return get(Weapon.SAWNOFF);
    }

    @Override
    public WeaponMasteryDao skorpion()
    {
        return get(Weapon.SKORPION);
    }

    @Override
    public WeaponMasteryDao desertEagle()
    {
        return get(Weapon.DESERT_EAGLE);
    }

    @Override
    public WeaponMasteryDao crossbow()
    {
        return get(Weapon.CROSSBOW);
    }

    @Override
    public WeaponMasteryDao s1897()
    {
        return get(Weapon.S1897);
    }

    @Override
    public WeaponMasteryDao s686()
    {
        return get(Weapon.S686);
    }

    @Override
    public WeaponMasteryDao s12k()
    {
        return get(Weapon.S12K);
    }

    @Override
    public WeaponMasteryDao dbs()
    {
        return get(Weapon.DBS);
    }

    @Override
    public WeaponMasteryDao uzi()
    {
        return get(Weapon.UZI);
    }

    @Override
    public WeaponMasteryDao ump45()
    {
        return get(Weapon.UMP45);
    }

    @Override
    public WeaponMasteryDao vector()
    {
        return get(Weapon.VECTOR);
    }

    @Override
    public WeaponMasteryDao thompson()
    {
        return get(Weapon.THOMPSON);
    }

    @Override
    public WeaponMasteryDao pp19()
    {
        return get(Weapon.PP19);
    }

    @Override
    public WeaponMasteryDao mp5()
    {
        return get(Weapon.MP5);
    }

    @Override
    public WeaponMasteryDao akm()
    {
        return get(Weapon.AKM);
    }

    @Override
    public WeaponMasteryDao m16a4()
    {
        return get(Weapon.M16A4);
    }

    @Override
    public WeaponMasteryDao scarl()
    {
        return get(Weapon.SCARL);
    }

    @Override
    public WeaponMasteryDao m416()
    {
        return get(Weapon.M416);
    }

    @Override
    public WeaponMasteryDao groza()
    {
        return get(Weapon.GROZA);
    }

    @Override
    public WeaponMasteryDao m762()
    {
        return get(Weapon.M762);
    }

    @Override
    public WeaponMasteryDao qbz()
    {
        return get(Weapon.QBZ);
    }

    @Override
    public WeaponMasteryDao g36c()
    {
        return get(Weapon.G36C);
    }

    @Override
    public WeaponMasteryDao aug()
    {
        return get(Weapon.AUG);
    }

    @Override
    public WeaponMasteryDao mk47()
    {
        return get(Weapon.MK47);
    }

    @Override
    public WeaponMasteryDao vss()
    {
        return get(Weapon.VSS);
    }

    @Override
    public WeaponMasteryDao sks()
    {
        return get(Weapon.SKS);
    }

    @Override
    public WeaponMasteryDao mk14()
    {
        return get(Weapon.MK14);
    }

    @Override
    public WeaponMasteryDao mini14()
    {
        return get(Weapon.MINI14);
    }

    @Override
    public WeaponMasteryDao slr()
    {
        return get(Weapon.SLR);
    }

    @Override
    public WeaponMasteryDao qbu()
    {
        return get(Weapon.QBU);
    }

    @Override
    public WeaponMasteryDao kar98k()
    {
        return get(Weapon.KAR98K);
    }

    @Override
    public WeaponMasteryDao m24()
    {
        return get(Weapon.M24);
    }

    @Override
    public WeaponMasteryDao awm()
    {
        return get(Weapon.AWM);
    }

    @Override
    public WeaponMasteryDao win94()
    {
        return get(Weapon.WIN94);
    }

    @Override
    public WeaponMasteryDao mosinNagant()
    {
        return get(Weapon.MOSIN_NAGANT);
    }

    @Override
    public WeaponMasteryDao m249()
    {
        return get(Weapon.M249);
    }

    @Override
    public WeaponMasteryDao dp28()
    {
        return get(Weapon.DP28);
    }
}
