package com.iohgame.service.jira;

import com.iohgame.framework.utility.Utility;
import com.iohgame.framework.utility.parameters.constant.ConstDatetime;
import com.iohgame.framework.utility.parameters.property.OptionElement;

public enum JiraTicketDescColumns implements OptionElement
{
    ACTUAL("-"),

    TARGET("-"),

    PROCESS("-"),

    EXPECT("-"),

    REFER("-"),

    DATA("-"),

    CASE("-"),

    SNAPSHOT("-"),

    ENV("-"),

    PERCENT("100"),

    DATE(Utility.getCurrentDate(ConstDatetime.DATE_SLASH)),

    NOTE("特に無し");

    private String m_val;

    private JiraTicketDescColumns(String val)
    {
        m_val = val;
    }

    @Override
    public String val()
    {
        return m_val;
    }
}
