package com.iohgame.service.jira;

import java.util.List;

import com.iohgame.framework.connect.mysql.parameters.Dao;
import com.iohgame.framework.utility.parameters.property.Builder;
import com.iohgame.framework.utility.parameters.property.Parameters;

public class JiraTicketContent implements Dao
{
    private final String m_project;
    private final String m_issueType;
    private final String m_summary;
    private final String m_priority;
    private final String m_components;
    private final String m_assignee;
    private final String m_description;
    private final List<JiraTicketLabels> m_labels;
    private final String m_fixVersions;
    private final String m_carbonCopy;

    private JiraTicketContent(ContainerBuilder builder)
    {
        m_project = builder.m_project;
        m_issueType = builder.m_issueType;
        m_summary = builder.m_summary;
        m_priority = builder.m_priority;
        m_components = builder.m_components;
        m_assignee = builder.m_assignee;
        m_description = builder.m_description;
        m_labels = builder.m_labels;
        m_fixVersions = builder.m_fixVersions;
        m_carbonCopy = builder.m_carbonCopy;
    }

    public String project()
    {
        return m_project;
    }

    public String issueType()
    {
        return m_issueType;
    }

    public String summary()
    {
        return m_summary;
    }

    public String priority()
    {
        return m_priority;
    }

    public String components()
    {
        return m_components;
    }

    public String assignee()
    {
        return m_assignee;
    }

    public String description()
    {
        return m_description;
    }

    public List<JiraTicketLabels> labels()
    {
        return m_labels;
    }

    public String fixVersions()
    {
        return m_fixVersions;
    }

    public String cc()
    {
        return m_carbonCopy;
    }

    public static class ContainerBuilder implements Builder<JiraTicketContent>
    {
        private String m_project;
        private String m_issueType;
        private String m_summary;
        private String m_priority;
        private String m_components;
        private String m_assignee;
        private String m_description;
        private List<JiraTicketLabels> m_labels;
        private String m_fixVersions;
        private String m_carbonCopy;

        public ContainerBuilder project(String project)
        {
            m_project = project;
            return this;
        }

        public ContainerBuilder issueType(String issueType)
        {
            m_issueType = issueType;
            return this;
        }

        public ContainerBuilder summary(String summary)
        {
            m_summary = summary;
            return this;
        }

        public ContainerBuilder priority(String priority)
        {
            m_priority = priority;
            return this;
        }

        public ContainerBuilder components(String components)
        {
            m_components = components;
            return this;
        }

        public ContainerBuilder assignee(String assignee)
        {
            m_assignee = assignee;
            return this;
        }

        public ContainerBuilder description(String description)
        {
            m_description = description;
            return this;
        }

        public ContainerBuilder labels(List<JiraTicketLabels> labels)
        {
            m_labels = labels;
            return this;
        }

        public ContainerBuilder fixVersions(String fixVersions)
        {
            m_fixVersions = fixVersions;
            return this;
        }

        public ContainerBuilder carbonCopy(String carbonCopy)
        {
            m_carbonCopy = carbonCopy;
            return this;
        }

        @Override
        public JiraTicketContent build()
        {
            return new JiraTicketContent(this);
        }
    }

    public enum JiraTicketLabels implements Parameters
    {
        QA_SERVER("qa-server"),

        STG_SERVER("stg-server"),

        PRODUCT("product"),

        ANDROID("android"),

        IOS("ios"),

        CHROMECAST("Chromecast"),

        UNKNOWN("");

        private String m_val;

        private JiraTicketLabels(String val)
        {
            m_val = val;
        }

        @Override
        public String val()
        {
            return m_val;
        }

        @Override
        public Parameters unknown()
        {
            return UNKNOWN;
        }
    }
}
