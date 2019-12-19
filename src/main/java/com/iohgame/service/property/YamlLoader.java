package com.iohgame.service.property;

import java.util.EnumSet;
import java.util.Map;
import java.util.TreeMap;

import com.iohgame.framework.utility.MainClass;
import com.iohgame.framework.utility.Utility;
import com.iohgame.framework.utility.parameters.property.OptionElement;

public class YamlLoader extends MainClass
{
    @SuppressWarnings("unchecked")
    public <T extends Enum<T> & OptionElement> Map<OptionElement, String> analysis(String filename, Class<T> columnClazz)
    {
        LOG.info("Start analysis map");

        Map<String, String> fileMap = (Map<String, String>) Utility.yamlAnalysis(filename);
        Map<OptionElement, String> result = new TreeMap<>();
        EnumSet<T> enumList = EnumSet.allOf(columnClazz);
        for (T val : enumList)
        {
            String value = "";
            if (fileMap.containsKey(val.name().toLowerCase()))
            {
                value = fileMap.get(val.name().toLowerCase());
            }
            else
            {
                value = val.val();
            }
            LOG.info(val + " is setting by " + value);
            result.put(val, value);
        }

        return result;
    }

    public static YamlLoader getInstance()
    {
        return new YamlLoader();
    }
}
