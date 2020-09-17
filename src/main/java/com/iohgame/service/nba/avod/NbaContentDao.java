package com.iohgame.service.nba.avod;

import java.util.ArrayList;
import java.util.List;

import com.iohgame.framework.connect.mysql.parameters.Dao;
import com.iohgame.framework.utility.Utility;
import com.iohgame.framework.utility.parameters.property.Builder;
import com.iohgame.framework.utility.parameters.property.Parameters;

public class NbaContentDao implements Dao
{
    private final String m_title;
    private final ContentType m_contentType;
    private final Integer m_gameId;
    private final Integer m_eventId;
    private final Integer m_videoId;
    private final Integer m_resourceId;
    private final String m_cuepoints;
    private final Integer m_duration;
    private final NbaAvodDao m_avod;

    private NbaContentDao(ContainerBuilder builder)
    {
        m_title = builder.m_title;
        m_contentType = builder.m_contentType;
        m_gameId = builder.m_gameId;
        m_eventId = builder.m_eventId;
        m_videoId = builder.m_videoId;
        m_resourceId = builder.m_resourceId;
        m_cuepoints = builder.m_cuepoints;
        m_duration = builder.m_duration;
        m_avod = builder.m_avod;
    }

    public String title()
    {
        return m_title;
    }

    public ContentType contentType()
    {
        return m_contentType;
    }

    public Integer gameId()
    {
        return m_gameId;
    }

    public Integer eventId()
    {
        return m_eventId;
    }

    public Integer videoId()
    {
        return m_videoId;
    }

    public Integer resourceId()
    {
        return m_resourceId;
    }

    public String cuepoints()
    {
        return m_cuepoints;
    }

    public List<String> cuepointList()
    {
        List<String> result = new ArrayList<>();
        if (m_cuepoints.equals(""))
        {
            return result;
        }
        for (String cuepoint : m_cuepoints.split(","))
        {
            int point = Utility.toInteger(cuepoint);
            result.add(getTimeFormat(point));
        }
        return result;
    }

    public Integer duration()
    {
        return m_duration;
    }

    public String durationTime()
    {
        return getTimeFormat(m_duration);
    }

    public NbaAvodDao avod()
    {
        return m_avod;
    }

    public String url()
    {
        Integer id = 0;
        switch (m_contentType)
        {
            case GAME:
                id = m_gameId;
                break;
            case EVENT:
                id = m_eventId;
                break;
            case VIDEO:
            default:
                id = m_videoId;
                break;
        }
        return "https://qa.nba.rakuten.co.jp/" + m_contentType.val() + "s/" + id;
    }

    private String getTimeFormat(int second)
    {
        if (second < 60)
        {
            return String.format("00:00:%02d", second);
        }
        else if (second > 3599)
        {
            int hour = second / 3600;
            int ms = second % 3600;
            int minute = ms / 60;
            int newSecond = ms % 60;
            return String.format("%02d:%02d:%02d", hour, minute, newSecond);
        }
        else
        {
            int ms = second % 3600;
            int minute = ms / 60;
            int newSecond = ms % 60;
            return String.format("00:%02d:%02d", minute, newSecond);
        }
    }

    public static class ContainerBuilder implements Builder<NbaContentDao>
    {
        private String m_title;
        private ContentType m_contentType;
        private Integer m_gameId;
        private Integer m_eventId;
        private Integer m_videoId;
        private Integer m_resourceId;
        private String m_cuepoints;
        private Integer m_duration;
        private NbaAvodDao m_avod;

        public ContainerBuilder title(String title)
        {
            m_title = title;
            return this;
        }

        public ContainerBuilder contentType(ContentType contentType)
        {
            m_contentType = contentType;
            return this;
        }

        public ContainerBuilder gameId(Integer gameId)
        {
            m_gameId = gameId;
            return this;
        }

        public ContainerBuilder eventId(Integer eventId)
        {
            m_eventId = eventId;
            return this;
        }

        public ContainerBuilder videoId(Integer videoId)
        {
            m_videoId = videoId;
            return this;
        }

        public ContainerBuilder resourceId(Integer resourceId)
        {
            m_resourceId = resourceId;
            return this;
        }

        public ContainerBuilder cuepoints(String cuepoints)
        {
            m_cuepoints = cuepoints;
            return this;
        }

        public ContainerBuilder duration(Integer duration)
        {
            m_duration = duration;
            return this;
        }

        public ContainerBuilder avod(NbaAvodDao avod)
        {
            m_avod = avod;
            return this;
        }

        @Override
        public NbaContentDao build()
        {
            return new NbaContentDao(this);
        }
    }

    public enum ContentType implements Parameters
    {
        GAME,

        EVENT,

        VIDEO;

        @Override
        public String val()
        {
            return name().toLowerCase();
        }

        @Override
        public Parameters unknown()
        {
            return null;
        }
    }
}
