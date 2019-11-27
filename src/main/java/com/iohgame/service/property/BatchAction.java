package com.iohgame.service.property;

import com.iohgame.framework.utility.ServiceAction;
import com.iohgame.framework.utility.parameters.property.Connectable;

public abstract class BatchAction<T extends Connectable> extends ServiceAction
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
