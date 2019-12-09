package com.iohgame.service.nba.synch;

import com.iohgame.framework.connect.mysql.parameters.Database;

public interface Nba extends Database
{
    public Player player();

    public Team team();

    public Schedule schedule();

    public Boxscore boxscore();

    public Standings standings();

    public Stats stats();
}
