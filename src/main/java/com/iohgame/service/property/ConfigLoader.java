package com.iohgame.service.property;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Properties;

import com.iohgame.framework.utility.MainClass;

public class ConfigLoader extends MainClass
{
    public Properties load(String fileName)
    {
        Properties properties = new Properties();
        FileInputStream fis = null;
        InputStreamReader isr = null;
        try
        {
            fis = new FileInputStream("src/main/resource/" + fileName + ".ini");
            isr = new InputStreamReader(fis, Charset.defaultCharset());
            properties.load(isr);
            if (isr != null)
            {
                if (fis != null)
                {
                    fis.close();
                }
                isr.close();
            }
        }
        catch (Exception e)
        {
            LOG.error(e.getMessage());
        }
        return properties;
    }

    public static ConfigLoader getInstance()
    {
        return new ConfigLoader();
    }
}
