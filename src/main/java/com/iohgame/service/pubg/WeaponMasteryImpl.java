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
        m_weaponMastery=PubgServiceConnect.getInstance().getWeaponMastery(accountId)//
        .get("data").getAsJsonObject()//
        .get("attributes").getAsJsonObject()//
        .get("weaponSummaries").getAsJsonObject();
    }

    private WeaponMasteryDao getWeaponMasteryDao(Weapon weapon)
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
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public WeaponMasteryDao m1895()
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public WeaponMasteryDao g18c()
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public WeaponMasteryDao r45()
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public WeaponMasteryDao sawnoff()
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public WeaponMasteryDao skorpion()
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public WeaponMasteryDao desertEagle()
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public WeaponMasteryDao crossbow()
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public WeaponMasteryDao s1897()
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public WeaponMasteryDao s686()
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public WeaponMasteryDao s12k()
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public WeaponMasteryDao dbs()
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public WeaponMasteryDao uzi()
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public WeaponMasteryDao ump45()
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public WeaponMasteryDao vector()
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public WeaponMasteryDao thompson()
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public WeaponMasteryDao pp19()
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public WeaponMasteryDao mp5()
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public WeaponMasteryDao akm()
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public WeaponMasteryDao m16a4()
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public WeaponMasteryDao scarl()
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public WeaponMasteryDao m416()
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public WeaponMasteryDao groza()
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public WeaponMasteryDao m762()
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public WeaponMasteryDao qbz()
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public WeaponMasteryDao g36c()
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public WeaponMasteryDao aug()
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public WeaponMasteryDao mk47()
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public WeaponMasteryDao vss()
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public WeaponMasteryDao sks()
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public WeaponMasteryDao mk14()
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public WeaponMasteryDao mini14()
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public WeaponMasteryDao slr()
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public WeaponMasteryDao qbu()
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public WeaponMasteryDao kar98k()
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public WeaponMasteryDao m24()
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public WeaponMasteryDao awm()
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public WeaponMasteryDao win94()
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public WeaponMasteryDao mosinNagant()
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public WeaponMasteryDao m249()
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public WeaponMasteryDao dp28()
    {
        // TODO Auto-generated method stub
        return null;
    }
}
