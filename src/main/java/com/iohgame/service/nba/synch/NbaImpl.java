package com.iohgame.service.nba.synch;

import com.iohgame.framework.connect.base.ConnectBase;

public class NbaImpl extends ConnectBase implements Nba
{
    private Player m_player;
    private Team m_team;
    private Schedule m_schedule;
    private Boxscore m_boxscore;
    private Standings m_standings;
    private Stats m_stats;

    public NbaImpl()
    {
        if (m_player == null)
        {
            m_player = new PlayerImpl();
        }
        if (m_team == null)
        {
            m_team = new TeamImpl();
        }
        if (m_schedule == null)
        {
            m_schedule = new ScheduleImpl(m_team.selectTeamInfo());
        }
        if (m_boxscore == null)
        {
            m_boxscore = new BoxscoreImpl();
        }
        if (m_standings == null)
        {
            m_standings = new StandingsImpl();
        }
        if (m_stats == null)
        {
            m_stats = new StatsImpl();
        }
    }

    @Override
    public Player player()
    {
        return m_player;
    }

    @Override
    public Team team()
    {
        return m_team;
    }

    @Override
    public Schedule schedule()
    {
        return m_schedule;
    }

    @Override
    public Boxscore boxscore()
    {
        return m_boxscore;
    }

    @Override
    public Standings standings()
    {
        return m_standings;
    }

    @Override
    public Stats stats()
    {
        return m_stats;
    }
}
