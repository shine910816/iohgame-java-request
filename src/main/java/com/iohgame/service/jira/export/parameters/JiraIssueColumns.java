package com.iohgame.service.jira.export.parameters;

import com.iohgame.framework.utility.parameters.property.OptionElement;

/**
 * Jira issue columns
 * TODO implement all of columns
 */
public enum JiraIssueColumns implements OptionElement
{
    KEY,

    SUMMARY,

    TYPE,

    STATUS,

    PRIORITY,

    RESOLUTION,

    FIXVERSIONS,

    COMPONENTS,

    LABELS,

    DESCRIPTION;

    @Override
    public String val()
    {
        return name();
    }
}
