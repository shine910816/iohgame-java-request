package com.iohgame;

import com.iohgame.service.jira.export.NbaRakutenWeeklyReportExportAction;
import com.iohgame.service.jira.export.property.NbaRakutenConnect;

public class App
{
    public static void main(String[] args)
    {
        App app = new App();
        app.execute();
    }
    
    public void execute()
    {
        new NbaRakutenWeeklyReportExportAction(new NbaRakutenConnect()).doMainExecute();
    }
}
