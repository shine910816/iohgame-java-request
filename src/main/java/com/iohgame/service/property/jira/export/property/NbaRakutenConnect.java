package com.iohgame.service.property.jira.export.property;

import java.util.List;

import com.atlassian.jira.rest.client.api.domain.Issue;
import com.iohgame.framework.connect.base.ConnectBase;
import com.iohgame.framework.connect.jira.property.JiraConnect;

public class NbaRakutenConnect extends ConnectBase
{
    private JiraConnect<NbaRakuten> m_connect;

    public NbaRakutenConnect()
    {
        if (m_connect == null)
        {
            m_connect = new JiraConnect<NbaRakuten>(NbaRakuten.getInstance());
        }
    }

    public List<Issue> selectNotClosedTicketsFromTcic()
    {
        return m_connect.searchIssue("project = RTNODP AND issuetype = Bug AND status != Closed" + //
                " AND reporter in (ts-zhaoxiong.a.yan, \"wang.lichun@trans-cosmos.com.cn\", \"yuan.jing@trans-cosmos.com.cn\") ORDER BY created ASC");
    }

    public List<Issue> selectPart6TicketsFromTcic()
    {
        return m_connect.searchIssue("project = RTNODP AND issuetype = Bug" + //
                " AND fixVersion = \"QA part6 [2019-09-]\" AND reporter in (\"wang.lichun@trans-cosmos.com.cn\", ts-zhaoxiong.a.yan) ORDER BY created ASC");
    }

    public List<Issue> selectBugOnProdTicketsFromTcic()
    {
        return m_connect.searchIssue("project = RTNODP AND issuetype = Bug" + //
                " AND fixVersion = \"Bug on NBA PROD.\" AND reporter in (\"wang.lichun@trans-cosmos.com.cn\", ts-zhaoxiong.a.yan) ORDER BY created ASC");
    }
}
