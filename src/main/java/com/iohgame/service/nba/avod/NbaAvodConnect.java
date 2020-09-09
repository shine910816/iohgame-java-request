package com.iohgame.service.nba.avod;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.iohgame.framework.connect.base.ConnectBase;
import com.iohgame.framework.utility.Utility;
import com.iohgame.service.nba.avod.NbaContentDao.ContentType;

public class NbaAvodConnect extends ConnectBase
{
    private List<String> m_list = new ArrayList<>();

    public NbaAvodConnect set(List<String> fileContents)
    {
        for (String avodId : fileContents)
        {
            m_list.add("https://qa-image.nba.rakuten.co.jp/media/ad/" + avodId + "_0.xml");
        }
        return this;
    }

    public List<NbaContentDao> get()
    {
        List<NbaContentDao> result = new ArrayList<>();
        try
        {
            for (String requestUrl : m_list)
            {
                System.out.println("Analyzing URL: " + requestUrl);
                DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
                HttpURLConnection url = (HttpURLConnection) new URL(requestUrl).openConnection();
                Document doc = db.parse(url.getInputStream());
                NbaAvodDao avod = new NbaAvodDao.ContainerBuilder() //
                        .title(doc.getElementsByTagName("title").item(0).getTextContent()) //
                        .description(doc.getElementsByTagName("description").item(0).getTextContent()) //
                        .link(doc.getElementsByTagName("link").item(0).getTextContent()) //
                        .build();
                NodeList items = doc.getElementsByTagName("item");
                for (int i = 0; i < items.getLength(); i++)
                {
                    Element item = (Element) items.item(i);
                    String itemTitle = item.getElementsByTagName("title").item(0).getTextContent();
                    String itemCuepoint = item.getElementsByTagName("dfpvideo:cuepoints").item(0).getTextContent();
                    String itemDuration = ((Element) item.getElementsByTagName("media:content").item(0)).getAttribute("duration");
                    String[] contentId = item.getElementsByTagName("dfpvideo:contentId").item(0).getTextContent().split("_");
                    ContentType contentType = Utility.getEnum(contentId[0], ContentType.class);
                    int gameId = 0;
                    int eventId = 0;
                    int videoId = 0;
                    int resourceId = 0;
                    switch (contentType)
                    {
                        case GAME:
                            gameId = Utility.toInteger(contentId[1].replace("id:", ""));
                            resourceId = Utility.toInteger(contentId[3].replace("id:", ""));
                            break;
                        case EVENT:
                            eventId = Utility.toInteger(contentId[1].replace("id:", ""));
                            resourceId = Utility.toInteger(contentId[3].replace("id:", ""));
                            break;
                        case VIDEO:
                        default:
                            videoId = Utility.toInteger(contentId[1].replace("id:", ""));
                            break;
                    }
                    NbaContentDao c = new NbaContentDao.ContainerBuilder() //
                            .title(itemTitle)//
                            .contentType(contentType)//
                            .gameId(gameId)//
                            .eventId(eventId)//
                            .videoId(videoId)//
                            .resourceId(resourceId)//
                            .cuepoints(itemCuepoint)//
                            .duration(Utility.toInteger(itemDuration))//
                            .avod(avod)//
                            .build();
                    result.add(c);
                }
            }
        }
        catch (Exception e)
        {
            LOG.error(e.getMessage());
        }
        return result;
    }
}
