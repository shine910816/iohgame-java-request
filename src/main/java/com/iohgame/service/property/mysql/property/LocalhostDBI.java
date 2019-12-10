package com.iohgame.service.property.mysql.property;

import com.iohgame.framework.connect.base.ConnectBase;
import com.iohgame.framework.connect.mysql.MysqlMasterDBI;
import com.iohgame.framework.connect.mysql.MysqlSlaveDBI;

public abstract class LocalhostDBI extends ConnectBase
{
    private MysqlSlaveDBI<Localhost> m_slave;
    private MysqlMasterDBI<Localhost> m_master;

    public LocalhostDBI()
    {
        if (m_slave == null)
        {
            m_slave = new MysqlSlaveDBI<Localhost>(Localhost.getInstance());
        }
        if (m_master == null)
        {
            m_master = new MysqlMasterDBI<Localhost>(Localhost.getInstance());
        }
    }

    protected MysqlSlaveDBI<Localhost> slave()
    {
        return m_slave;
    }

    protected MysqlMasterDBI<Localhost> master()
    {
        return m_master;
    }
}
