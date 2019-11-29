package com.iohgame.service.mysql.property;

import com.iohgame.framework.connect.mysql.parameters.MysqlAccount;
import com.iohgame.framework.utility.MainClass;

public class Server extends MainClass implements MysqlAccount
{
    private final String m_userName = "qdm174930477";
    private final String m_password = "kinsama317317";
    private final String m_requestUrl = "qdm174930477.my3w.com";
    private final String m_port = "3306";
    private final String m_databaseName = "qdm174930477_db";

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

    public static Server getInstance()
    {
        return new Server();
    }
}
