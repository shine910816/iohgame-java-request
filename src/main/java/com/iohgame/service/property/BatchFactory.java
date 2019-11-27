package com.iohgame.service.property;

import com.iohgame.framework.utility.ServiceFactory;
import com.iohgame.framework.utility.parameters.property.Action;
import com.iohgame.framework.utility.parameters.property.OptionElement;
import com.iohgame.service.jira.export.NbaRakutenWeeklyReportExportAction;
import com.iohgame.service.jira.export.property.NbaRakutenConnect;

public class BatchFactory extends ServiceFactory
{
    public static BatchFactory getInstance()
    {
        return new BatchFactory();
    }

    @Override
    public void execute(OptionElement page)
    {
        Action act = null;
        switch ((BatchOption) page)
        {
            case NBA_RAKUTEN_WEEKLY_REPORT:
                act = new NbaRakutenWeeklyReportExportAction(new NbaRakutenConnect());
                break;
            default:
                LOG.error("Batch option is nou found by " + page);
                break;
        }
        if (act != null)
        {
            if (!act.doMainValidate())
            {
                LOG.error("Validate is not passed");
                return;
            }
            if (!act.doMainExecute())
            {
                LOG.error("Execute is not passed");
                return;
            }
        }
    }

    public enum BatchOption implements OptionElement
    {
        NBA_RAKUTEN_WEEKLY_REPORT;

        @Override
        public String val()
        {
            return name();
        }
    }
}
