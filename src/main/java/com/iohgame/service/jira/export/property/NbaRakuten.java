package com.iohgame.service.jira.export.property;

import com.iohgame.framework.connect.jira.parameters.JiraAccount;
import com.iohgame.framework.utility.MainClass;

public class NbaRakuten extends MainClass implements JiraAccount
{
    private final String m_requestUri = "https://jira.rakuten-it.com/jira";
    private final String m_accountName = "wang.lichun@trans-cosmos.com.cn";
    private final String m_password = "!QAZxsw2";
    private final String m_proxyHost = "";
    private final String m_proxyport = "";
    private final Integer m_authMax = 100;

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
        return m_proxyport;
    }

    @Override
    public Integer authMax()
    {
        return m_authMax;
    }

    public static NbaRakuten getInstance()
    {
        return new NbaRakuten();
    }
}
