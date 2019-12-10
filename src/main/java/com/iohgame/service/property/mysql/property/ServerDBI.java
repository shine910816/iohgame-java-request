package com.iohgame.service.property.mysql.property;

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

    protected MysqlSlaveDBI<Server> slave()
    {
        return m_slave;
    }

    protected MysqlMasterDBI<Server> master()
    {
        return m_master;
    }

    protected Boolean judge(String param)
    {
        return param.equals("0") ? false : true;
    }
}
