package com.iohgame;

import com.iohgame.service.jiraexport.NbaRakutenBatchFactory;
import com.iohgame.service.jiraexport.NbaRakutenBatchFactory.BatchOption;

public class App
{
    public static void main(String[] args)
    {
        NbaRakutenBatchFactory.getInstance().execute(BatchOption.NBA_RAKUTEN_WEEKLY_REPORT);
    }
}
