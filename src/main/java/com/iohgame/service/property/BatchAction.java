package com.iohgame.service.property;

import com.iohgame.framework.connect.base.ConnectBase;
import com.iohgame.framework.utility.ServiceAction;

public abstract class BatchAction<T extends ConnectBase> extends ServiceAction
{
    private T m_connect;

    public BatchAction(T connect)
    {
        m_connect = connect;
    }

    protected T connect()
    {
        return m_connect;
    }
}
