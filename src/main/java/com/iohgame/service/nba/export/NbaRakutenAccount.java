package com.iohgame.service.nba.export;

import java.util.Properties;

import com.iohgame.framework.connect.jira.parameters.JiraAccount;
import com.iohgame.framework.utility.MainClass;
import com.iohgame.framework.utility.Utility;
import com.iohgame.service.property.ConfigLoader;

public class NbaRakutenAccount extends MainClass implements JiraAccount
{
    private final String m_requestUri;
    private final String m_accountName;
    private final String m_password;
    private final String m_proxyHost;
    private final String m_proxyPort;
    private final Integer m_authMax;

    public NbaRakutenAccount()
    {
        Properties prop = ConfigLoader.getInstance().load("rakutennba");
        m_requestUri = prop.getProperty("request");
        m_accountName = prop.getProperty("account");
        m_password = prop.getProperty("password");
        m_proxyHost = prop.getProperty("proxyHost");
        m_proxyPort = prop.getProperty("proxyPort");
        m_authMax = Utility.toInteger(prop.getProperty("auth"));
    }

    @Override
    public String requestUrl()
    {
        return m_requestUri;
    }

    @Override
    public String userName()
    {
        return m_accountName;
    }

    @Override
    public String password()
    {
        return m_password;
    }

    @Override
    public String proxyHost()
    {
        return m_proxyHost;
    }

    @Override
    public String proxyPort()
    {
        return m_proxyPort;
    }

    @Override
    public Integer authMax()
    {
        return m_authMax;
    }

    public static NbaRakutenAccount getInstance()
    {
        return new NbaRakutenAccount();
    }
}
