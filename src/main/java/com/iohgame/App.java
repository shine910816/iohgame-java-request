package com.iohgame;

import com.iohgame.service.property.BatchFactory;
import com.iohgame.service.property.BatchFactory.BatchOption;

public class App
{
    public static void main(String[] args)
    {
        BatchFactory.getInstance().execute(BatchOption.NBA_RAKUTEN_WEEKLY_REPORT);
    }
}
