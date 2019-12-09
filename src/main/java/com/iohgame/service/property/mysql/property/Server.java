package com.iohgame.service.property.mysql.property;

import java.util.Properties;

import com.iohgame.framework.connect.mysql.parameters.MysqlAccount;
import com.iohgame.framework.utility.MainClass;
import com.iohgame.service.property.ConfigLoader;

public class Server extends MainClass implements MysqlAccount
{
    private final String m_userName;
    private final String m_password;
    private final String m_requestUrl;
    private final String m_port;
    private final String m_databaseName;

    public Server()
    {
        Properties prop = ConfigLoader.getInstance().load("server");
        m_requestUrl = prop.getProperty("request");
        m_port = prop.getProperty("port");
        m_userName = prop.getProperty("account");
        m_password = prop.getProperty("password");
        m_databaseName = prop.getProperty("name");
    }

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
