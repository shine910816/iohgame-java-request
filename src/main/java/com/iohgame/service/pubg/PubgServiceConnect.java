package com.iohgame.service.pubg;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.iohgame.framework.connect.base.ConnectBase;
import com.iohgame.framework.utility.Utility;
import com.iohgame.framework.utility.parameters.constant.ConstQuote;
import com.iohgame.framework.utility.parameters.property.OptionElement;

public class PubgServiceConnect extends ConnectBase
{
    private final String BASE_URL;

    private PubgServiceConnect(ShardsPlatform platform)
    {
        BASE_URL = "https://api.pubg.com/shards/" + platform.val();
    }

    public JsonObject getPlayersById(String[] playerIds)
    {
        String requestUrl = BASE_URL + "/players?filter[playerIds]=" + Utility.implode(playerIds, ",", ConstQuote.UNKNOWN);
        return getPubgJson(requestUrl);
    }

    public JsonObject getPlayersByName(String[] playerNames)
    {
        String requestUrl = BASE_URL + "/players?filter[playerNames]=" + Utility.implode(playerNames, ",", ConstQuote.UNKNOWN);
        return getPubgJson(requestUrl);
    }

    public JsonObject getWeaponMastery(String accountId)
    {
        String requestUrl = BASE_URL + "/players/" + accountId + "/weapon_mastery";
        return getPubgJson(requestUrl);
    }

    private JsonObject getPubgJson(String url)
    {
        try
        {
            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Authorization", "Bearer " + //
                    "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJjMzQ5OGM0MC04ODMxLTAxMzgtMmY4ZS00ZDk1MjEyYTg1YmEiLCJpc3MiOiJnYW1lbG9ja2VyIiwiaWF0Ijo" + //
                    "xNTkxMjM0NjAwLCJwdWIiOiJibHVlaG9sZSIsInRpdGxlIjoicHViZyIsImFwcCI6InNoaW5lOTEwODE2LWdtIn0.MEw_gHh_5WwRDV2zPU2g-ioOahkk-EJAed_w3YQL_RE");
            conn.setRequestProperty("Accept", "application/vnd.api+json");
            JsonParser parse = new JsonParser();
            return (JsonObject) parse.parse(new BufferedReader(new InputStreamReader(conn.getInputStream())));
        }
        catch (Exception e)
        {
            LOG.error(e.getMessage());
        }
        return null;
    }

    public static PubgServiceConnect getInstance()
    {
        return new PubgServiceConnect(ShardsPlatform.STEAM);
    }

    public enum ShardsPlatform implements OptionElement
    {
        KAKAO("kakao"),

        STADIA("stadia"),

        STEAM("steam"),

        TOURNAMENTS("tournament"),

        PS4("psn"),

        XBOX("xbox"),

        PS4_XBOX("console");

        private String m_val;

        private ShardsPlatform(String val)
        {
            m_val = val;
        }

        @Override
        public String val()
        {
            return m_val;
        }
    }
}
