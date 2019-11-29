package com.iohgame.service.mysql.property;

import com.iohgame.framework.connect.mysql.parameters.MysqlAccount;
import com.iohgame.framework.utility.MainClass;

public class Localhost extends MainClass implements MysqlAccount
{
    private final String m_userName = "root";
    private final String m_password = "";
    private final String m_requestUrl = "127.0.0.1";
    private final String m_port = "3306";
    private final String m_databaseName = "wod";

    @Override
    public String userName()
    {
        return m_userName;
    }

    @Override
    public String password()
    {
        return m_password;
    }

    @Override
    public String requestUrl()
    {
        return m_requestUrl;
    }

    @Override
    public String port()
    {
        return m_port;
    }

    @Override
    public String databaseName()
    {
        return m_databaseName;
    }

    public static Localhost getInstance()
    {
        return new Localhost();
    }
}
