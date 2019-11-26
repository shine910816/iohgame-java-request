package com.iohgame.service.jira.export;

import com.iohgame.framework.utility.Utility;
import com.iohgame.framework.utility.parameters.constant.ConstDatetime;
import com.iohgame.service.jira.export.parameters.JiraIssueColumns;
import com.iohgame.service.jira.export.property.JiraTicketsExport;
import com.iohgame.service.jira.export.property.NbaRakutenConnect;
import com.iohgame.service.property.BatchAction;

public class NbaRakutenWeeklyReportExportAction extends BatchAction<NbaRakutenConnect>
{
    public NbaRakutenWeeklyReportExportAction(NbaRakutenConnect connect)
    {
        super(connect);
    }

    @Override
    public boolean doMainExecute()
    {
        JiraTicketsExport.getIntance() //
                .createEmptySheet("NBA週報(" + Utility.getCurrentDate(ConstDatetime.DATE_MONTH_DAY_NONE) + ")") //
                .createExportSheet("QA part6", connect().selectPart6TicketsFromTcic(), JiraIssueColumns.KEY, JiraIssueColumns.STATUS, JiraIssueColumns.PRIORITY, JiraIssueColumns.RESOLUTION) //
                .createExportSheet("Bug on NBA PROD", connect().selectBugOnProdTicketsFromTcic(), JiraIssueColumns.KEY, JiraIssueColumns.STATUS, JiraIssueColumns.PRIORITY, JiraIssueColumns.RESOLUTION) //
                .createExportSheet("Not Closed", connect().selectNotClosedTicketsFromTcic(), JiraIssueColumns.KEY, JiraIssueColumns.STATUS) //
                .saveExcelFile("WeeklyReport(" + Utility.getCurrentDate(ConstDatetime.DATE_NONE) + ")");
        return true;
    }

}
