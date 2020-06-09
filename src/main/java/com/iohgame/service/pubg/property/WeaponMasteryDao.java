package com.iohgame.service.pubg.property;

import java.util.EnumSet;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.iohgame.framework.connect.mysql.parameters.Dao;
import com.iohgame.framework.utility.MainClass;
import com.iohgame.framework.utility.Utility;

public class WeaponMasteryDao extends MainClass implements Dao
{
    private final Integer m_exp;
    private final Integer m_level;
    private final WeaponTier m_tier;
    private Boolean m_medalDisp = false;
    private Map<WeaponMedal, Integer> m_medals = new TreeMap<>();
    private WeaponStats m_stats;

    private WeaponMasteryDao(JsonObject json)
    {
        EnumSet<WeaponMedal> enumList = EnumSet.allOf(WeaponMedal.class);
        for (WeaponMedal val : enumList)
        {
            m_medals.put(val, 0);
        }
        m_exp = json.get("XPTotal").getAsInt();
        m_level = json.get("LevelCurrent").getAsInt();
        m_tier = Utility.getEnum(json.get("TierCurrent").getAsString(), WeaponTier.class);
        m_stats = new WeaponMasteryDao.WeaponStats(json.get("StatsTotal").getAsJsonObject());
        Iterator<JsonElement> jsonMedals = json.get("Medals").getAsJsonArray().iterator();
        while (jsonMedals.hasNext())
        {
            JsonObject jsonMedal = jsonMedals.next().getAsJsonObject();
            WeaponMedal targetMedalKey = Utility.getEnum(jsonMedal.get("MedalId").getAsString(), WeaponMedal.class);
            m_medals.replace(targetMedalKey, jsonMedal.get("Count").getAsInt());
        }
    }

    /**
     * 经验值
     */
    public Integer exp()
    {
        return m_exp;
    }

    /**
     * 等级
     */
    public Integer level()
    {
        return m_level;
    }

    /**
     * 进阶等级
     */
    public WeaponTier tier()
    {
        return m_tier;
    }

    /**
     * 数据统计
     */
    public WeaponStats stats()
    {
        return m_stats;
    }

    /**
     * 奖牌展示
     */
    public Boolean isMedalDisp()
    {
        return m_medalDisp;
    }

    /**
     * 奖牌列表
     */
    public Map<WeaponMedal, Integer> medals()
    {
        return m_medals;
    }

    public static class WeaponStats extends MainClass implements Dao
    {
        private final Integer m_defeats;
        private final Integer m_defeatsMax;
        private final Double m_damagePlayer;
        private final Double m_damagePlayerMax;
        private final Integer m_headShots;
        private final Integer m_headShotsMax;
        private final Double m_longestDefeat;
        private final Integer m_longRangeDefeats;
        private final Integer m_kills;
        private final Integer m_killsMax;
        private final Integer m_groggies;
        private final Integer m_groggiesMax;

        private WeaponStats(JsonObject json)
        {
            m_defeats = json.get("Defeats").getAsInt();
            m_defeatsMax = json.get("MostDefeatsInAGame").getAsInt();
            m_damagePlayer = json.get("DamagePlayer").getAsDouble();
            m_damagePlayerMax = json.get("MostDamagePlayerInAGame").getAsDouble();
            m_headShots = json.get("HeadShots").getAsInt();
            m_headShotsMax = json.get("MostHeadShotsInAGame").getAsInt();
            m_longestDefeat = json.get("LongestDefeat").getAsDouble();
            m_longRangeDefeats = json.get("LongRangeDefeats").getAsInt();
            m_kills = json.get("Kills").getAsInt();
            m_killsMax = json.get("MostKillsInAGame").getAsInt();
            m_groggies = json.get("Groggies").getAsInt();
            m_groggiesMax = json.get("MostGroggiesInAGame").getAsInt();
        }

        /**
         * 总击败
         */
        public Integer defeats()
        {
            return m_defeats;
        }

        /**
         * 单场最高击败
         */
        public Integer mostDefeatsInAGame()
        {
            return m_defeatsMax;
        }

        /**
         * 总伤害
         */
        public Double damagePlayer()
        {
            return m_damagePlayer;
        }

        /**
         * 单场最高伤害
         */
        public Double mostDamagePlayerInAGame()
        {
            return m_damagePlayerMax;
        }

        /**
         * 总爆头
         */
        public Integer headShots()
        {
            return m_headShots;
        }

        /**
         * 单场最高爆头
         */
        public Integer mostHeadShotsInAGame()
        {
            return m_headShotsMax;
        }

        /**
         * 最远击败距离
         */
        public Double longestDefeat()
        {
            return m_longestDefeat;
        }

        /**
         * 远距离击败数
         */
        public Integer longRangeDefeats()
        {
            return m_longRangeDefeats;
        }

        /**
         * 总击杀
         */
        public Integer kills()
        {
            return m_kills;
        }

        /**
         * 单场最高击杀
         */
        public Integer mostKillsInAGame()
        {
            return m_killsMax;
        }

        /**
         * 总击倒
         */
        public Integer groggies()
        {
            return m_groggies;
        }

        /**
         * 单场最高击倒
         */
        public Integer mostGroggiesInAGame()
        {
            return m_groggiesMax;
        }
    }

    public static WeaponMasteryDao build(JsonObject json)
    {
        return new WeaponMasteryDao(json);
    }
}
