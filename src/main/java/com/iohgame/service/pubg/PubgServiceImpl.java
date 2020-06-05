package com.iohgame.service.pubg;

import com.iohgame.framework.utility.MainClass;
import com.iohgame.service.pubg.property.parameters.PubgService;
import com.iohgame.service.pubg.property.parameters.WeaponMastery;

public class PubgServiceImpl extends MainClass implements PubgService
{
    @Override
    public WeaponMastery weaponMastery(String accountId)
    {
        return new WeaponMasteryImpl(accountId);
    }
}
