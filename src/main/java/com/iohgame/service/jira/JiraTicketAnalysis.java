package com.iohgame.service.jira;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.iohgame.framework.connect.base.ConnectBase;
import com.iohgame.framework.utility.Utility;
import com.iohgame.framework.utility.parameters.constant.ConstBreak;
import com.iohgame.framework.utility.parameters.property.OptionElement;
import com.iohgame.service.jira.JiraTicketContent.JiraTicketLabels;
import com.iohgame.service.property.YamlLoader;

public class JiraTicketAnalysis extends ConnectBase
{
    private Map<OptionElement, Object> m_map;

    public JiraTicketAnalysis(Map<OptionElement, Object> map)
    {
        m_map = map;
    }

    public JiraTicketContent getContent()
    {
        JiraTicketContent content = new JiraTicketContent.ContainerBuilder() //
                .project(toString(m_map.get(JiraTicketYamlColumns.PROJECT))) //
                .issueType(toString(m_map.get(JiraTicketYamlColumns.ISSUE_TYPE))) //
                .summary(toString(m_map.get(JiraTicketYamlColumns.SUMMARY))) //
                .priority(toString(m_map.get(JiraTicketYamlColumns.PRIORITY))) //
                .components(toString(m_map.get(JiraTicketYamlColumns.COMPONENTS))) //
                .assignee(toString(m_map.get(JiraTicketYamlColumns.ASSIGNEE))) //
                .description(transDescription()) //
                .labels(Utility.getEnums(toString(m_map.get(JiraTicketYamlColumns.LABELS)), JiraTicketLabels.class)) //
                .fixVersions(toString(m_map.get(JiraTicketYamlColumns.FIX_VERSIONS))) //
                .carbonCopy(toString(m_map.get(JiraTicketYamlColumns.CARBON_COPY))) //
                .build();
        return content;
    }

    private String transDescription()
    {
        final String BL = ConstBreak.LINUX.val() + ConstBreak.LINUX.val();
        final String BR = ConstBreak.LINUX.val();
        String desc = "お世話になっております。大宇宙の王 利春です。";
        Map<OptionElement, Object> descMap = YamlLoader.getInstance().getMap(m_map.get(JiraTicketYamlColumns.DESCRIPTION), JiraTicketDescColumns.class);
        for (Entry<OptionElement, Object> item : descMap.entrySet())
        {
            desc += BL + "■" + getColumnMap().get(item.getKey()) + BR + item.getValue();
        }
        desc += BL + "以上、よろしくお願い致します。";
        return desc;
    }

    private Map<JiraTicketDescColumns, String> getColumnMap()
    {
        Map<JiraTicketDescColumns, String> res = new HashMap<>();
        res.put(JiraTicketDescColumns.ACTUAL, "現象");
        res.put(JiraTicketDescColumns.TARGET, "対象画面");
        res.put(JiraTicketDescColumns.PROCESS, "再現手順");
        res.put(JiraTicketDescColumns.EXPECT, "期待値");
        res.put(JiraTicketDescColumns.REFER, "参考資料");
        res.put(JiraTicketDescColumns.DATA, "テストデータ");
        res.put(JiraTicketDescColumns.CASE, "対象テストケース/確認項目");
        res.put(JiraTicketDescColumns.SNAPSHOT, "Screenshots");
        res.put(JiraTicketDescColumns.ENV, "環境");
        res.put(JiraTicketDescColumns.PERCENT, "再現率");
        res.put(JiraTicketDescColumns.DATE, "発生日時");
        res.put(JiraTicketDescColumns.NOTE, "備考");
        return res;
    }
}
