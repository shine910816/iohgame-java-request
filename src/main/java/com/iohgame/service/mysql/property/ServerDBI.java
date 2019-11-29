package com.iohgame.service.mysql.property;

import com.iohgame.framework.connect.base.ConnectBase;
import com.iohgame.framework.connect.mysql.MysqlMasterDBI;
import com.iohgame.framework.connect.mysql.MysqlSlaveDBI;

public abstract class ServerDBI extends ConnectBase
{
    private MysqlSlaveDBI<Server> m_slave;
    private MysqlMasterDBI<Server> m_master;

    public ServerDBI()
    {
        if (m_slave == null)
        {
            m_slave = new MysqlSlaveDBI<Server>(Server.getInstance());
        }
        if (m_master == null)
        {
            m_master = new MysqlMasterDBI<Server>(Server.getInstance());
        }
    }

    protected MysqlSlaveDBI<Server> master()
    {
        return m_slave;
    }

    protected MysqlMasterDBI<Server> slave()
    {
        return m_master;
    }
}
