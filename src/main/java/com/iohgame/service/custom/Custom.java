package com.iohgame.service.custom;

import java.util.Map;

import com.iohgame.framework.connect.mysql.parameters.Database;

public interface Custom extends Database
{
    public Map<Integer, CustomInfoDao> selectCustomInfo();

    public Map<Integer, CustomPassword> selectCustomPassword();
}
