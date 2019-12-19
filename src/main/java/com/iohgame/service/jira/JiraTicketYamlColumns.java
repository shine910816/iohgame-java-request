package com.iohgame.service.jira;

import com.iohgame.framework.utility.parameters.property.OptionElement;

public enum JiraTicketYamlColumns implements OptionElement
{
    PROJECT("Rakuten TV NBA One Destination Project (RTNODP)"),

    ISSUE_TYPE("Bug"),

    SUMMARY(""),

    PRIORITY("Major"),

    COMPONENTS("qa"),

    ASSIGNEE("Unassigned"),

    DESCRIPTION(""),

    LABELS(""),

    FIX_VERSIONS("QA part6 [2019-09-]"),

    CARBON_COPY("kota.murase, nobumichi.atobe, ts-zhaoxiong.a.yan, wang.lichun@trans-cosmos.com.cn, yujiro.a.ueda, yuki.obayashi, zheng.li@trans-cosmos.com.cn");

    private String m_val;

    private JiraTicketYamlColumns(String val)
    {
        m_val = val;
    }

    @Override
    public String val()
    {
        return m_val;
    }
}
