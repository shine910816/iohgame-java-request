package com.iohgame.service.nba.avod;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;

import com.iohgame.framework.connect.base.ConnectBase;

public class NbaAvodConnect extends ConnectBase
{
    private List<String> m_list = new ArrayList<>();

    public NbaAvodConnect set()
    {
        String fileContent = "";
        for (String avodId : fileContent.split("\n"))
        {
            m_list.add("https://qa-image.nba.rakuten.co.jp/media/ad/" + avodId + "_0.xml");
        }
        return this;
    }

    public void get()
    {
        try
        {
            for (String requestUrl : m_list)
            {
                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                DocumentBuilder db = dbf.newDocumentBuilder();
                InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(requestUrl);
                Document doc = db.parse(is);
                // TODO XML analysis
            }
        }
        catch (Exception e)
        {
            LOG.error(e.getMessage());
        }
    }
}
