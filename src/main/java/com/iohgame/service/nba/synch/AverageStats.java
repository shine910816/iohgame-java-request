package com.iohgame.service.nba.synch;

import com.iohgame.framework.utility.MainClass;
import com.iohgame.framework.utility.Utility;

public class AverageStats extends MainClass
{
    private final BoxscoreDao m_boxscore;

    protected AverageStats(BoxscoreDao boxscore)
    {
        m_boxscore = boxscore;
    }

    /**
     * Game season year
     */
    public Integer season()
    {
        return m_boxscore.season();
    }

    /**
     * Season stage
     */
    public SeasonStage seasonStage()
    {
        return m_boxscore.seasonStage();
    }

    /**
     * Team ID
     */
    public Integer teamId()
    {
        return m_boxscore.teamId();
    }

    /**
     * Player ID
     */
    public Integer playerId()
    {
        return m_boxscore.playerId();
    }

    /**
     * Game played
     */
    public Float gp()
    {
        return transToFloat(m_boxscore.gp());
    }

    /**
     * Minutes per game
     */
    public Float mpg()
    {
        return transToFloat(m_boxscore.playedTimeSecond() / 60f / gp());
    }

    /**
     * Points per game
     */
    public Float ppg()
    {
        return transToFloat(transToFloat(m_boxscore.pts()) / gp());
    }

    /**
     * Field goals made per game
     */
    public Float fgmpg()
    {
        return transToFloat(transToFloat(m_boxscore.fgm()) / gp());
    }

    /**
     * Field goals attempted per game
     */
    public Float fgapg()
    {
        return transToFloat(transToFloat(m_boxscore.fga()) / gp());
    }

    /**
     * Field goals missed per game
     */
    public Float fgxpg()
    {
        return transToFloat(transToFloat(m_boxscore.fgx()) / gp());
    }

    /**
     * Field goals percentage
     */
    public Float fgp()
    {
        return transToFloat(m_boxscore.fgp() * 100f);
    }

    /**
     * Three points made per game
     */
    public Float tpmpg()
    {
        return transToFloat(transToFloat(m_boxscore.tpm()) / gp());
    }

    /**
     * Three points attempted per game
     */
    public Float tpapg()
    {
        return transToFloat(transToFloat(m_boxscore.tpa()) / gp());
    }

    /**
     * Three points missed per game
     */
    public Float tpxpg()
    {
        return transToFloat(transToFloat(m_boxscore.tpx()) / gp());
    }

    /**
     * Three points percentage
     */
    public Float tpp()
    {
        return transToFloat(m_boxscore.tpp() * 100f);
    }

    /**
     * Free throw made per game
     */
    public Float ftmpg()
    {
        return transToFloat(transToFloat(m_boxscore.ftm()) / gp());
    }

    /**
     * Free throw attempted per game
     */
    public Float ftapg()
    {
        return transToFloat(transToFloat(m_boxscore.fta()) / gp());
    }

    /**
     * Free throw missed per game
     */
    public Float ftxpg()
    {
        return transToFloat(transToFloat(m_boxscore.ftx()) / gp());
    }

    /**
     * Free throw percentage
     */
    public Float ftp()
    {
        return transToFloat(m_boxscore.ftp() * 100f);
    }

    /**
     * Offensive rebounds per game
     */
    public Float orpg()
    {
        return transToFloat(transToFloat(m_boxscore.off()) / gp());
    }

    /**
     * Defensive rebounds per game
     */
    public Float drpg()
    {
        return transToFloat(transToFloat(m_boxscore.def()) / gp());
    }

    /**
     * Total rebounds per game
     */
    public Float rpg()
    {
        return transToFloat(transToFloat(m_boxscore.reb()) / gp());
    }

    /**
     * Assists per game
     */
    public Float apg()
    {
        return transToFloat(transToFloat(m_boxscore.ast()) / gp());
    }

    /**
     * Steals per game
     */
    public Float spg()
    {
        return transToFloat(transToFloat(m_boxscore.stl()) / gp(), 2);
    }

    /**
     * Blocks per game
     */
    public Float bpg()
    {
        return transToFloat(transToFloat(m_boxscore.blk()) / gp(), 2);
    }

    /**
     * Personal fouls per game
     */
    public Float pfpg()
    {
        return transToFloat(transToFloat(m_boxscore.pf()) / gp());
    }

    /**
     * Turnovers per game
     */
    public Float topg()
    {
        return transToFloat(transToFloat(m_boxscore.to()) / gp());
    }

    private Float transToFloat(Float param, Integer i)
    {
        return Utility.toFloat(String.format("%." + Utility.toString(i) + "f", param));
    }

    private Float transToFloat(Float param)
    {
        return transToFloat(param, 1);
    }

    private Float transToFloat(Integer param)
    {
        return Utility.toFloat(param.toString());
    }
}
