package com.iohgame.service.jira;

import java.util.Map;

import com.iohgame.framework.connect.base.ConnectBase;
import com.iohgame.framework.utility.Utility;
import com.iohgame.framework.utility.parameters.property.OptionElement;
import com.iohgame.service.jira.JiraTicketContent.JiraTicketLabels;

public class JiraTicketAnalysis extends ConnectBase
{
    private Map<OptionElement, String> m_map;

    public JiraTicketAnalysis(Map<OptionElement, String> map)
    {
        m_map = map;
    }

    public JiraTicketContent getContent()
    {
        JiraTicketContent content = new JiraTicketContent.ContainerBuilder() //
                .project(m_map.get(JiraTicketYamlColumns.PROJECT)) //
                .issueType(m_map.get(JiraTicketYamlColumns.ISSUE_TYPE)) //
                .summary(m_map.get(JiraTicketYamlColumns.SUMMARY)) //
                .priority(m_map.get(JiraTicketYamlColumns.PRIORITY)) //
                .components(m_map.get(JiraTicketYamlColumns.COMPONENTS)) //
                .assignee(m_map.get(JiraTicketYamlColumns.ASSIGNEE)) //
                .description(m_map.get(JiraTicketYamlColumns.DESCRIPTION)) //
                .labels(Utility.getEnums(m_map.get(JiraTicketYamlColumns.LABELS), JiraTicketLabels.class)) //
                .fixVersions(m_map.get(JiraTicketYamlColumns.FIX_VERSIONS)) //
                .carbonCopy(m_map.get(JiraTicketYamlColumns.CARBON_COPY)) //
                .build();
        return content;
    }
}
