package com.iohgame;

import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import com.atlassian.jira.rest.client.api.domain.Issue;

import cn.com.transcosmos.framework.utility.Document;
import cn.com.transcosmos.framework.utility.Document.ExcleBook;
import cn.com.transcosmos.framework.utility.MainClass;
import cn.com.transcosmos.framework.utility.connect.jira.parameter.JiraIssueColumns;

public class JiraTicketsExport extends MainClass
{
    private ExcleBook m_book;

    public JiraTicketsExport()
    {
        LOG.info("Start export jira issue tickets");
        m_book = Document.createExcleBook();
    }

    public JiraTicketsExport createEmptySheet(String sheetName)
    {
        LOG.info("Create empty sheet for " + sheetName);
        m_book.getBook().createSheet(sheetName);
        return this;
    }

    public JiraTicketsExport createExportSheet(String sheetName, List<Issue> issues, JiraIssueColumns... columns)
    {
        int columnsCount = columns.length;
        if (columnsCount > 0)
        {
            LOG.info("Create sheet for " + sheetName);
            Sheet sheet = m_book.getBook().createSheet(sheetName);

            LOG.info("Create header row");
            Row headerRow = sheet.createRow(0);
            int cellIndex = 0;
            for (JiraIssueColumns column : columns)
            {
                Cell headerCell = headerRow.createCell(cellIndex++);
                headerCell.setCellStyle(m_book.getStyle());
                headerCell.setCellValue(column.val());
            }

            LOG.info("Create content rows");
            int rowIndex = 1;
            for (final Issue issue : issues)
            {
                Row contentRow = sheet.createRow(rowIndex++);
                cellIndex = 0;
                for (JiraIssueColumns column : columns)
                {
                    Cell contentCell = contentRow.createCell(cellIndex++);
                    String cellValue = "";
                    // TODO implement all of columns
                    switch (column)
                    {
                        case KEY:
                            cellValue = issue.getKey();
                            break;
                        case STATUS:
                            cellValue = issue.getStatus().getName();
                            break;
                        case PRIORITY:
                            cellValue = issue.getPriority().getName();
                            break;
                        case RESOLUTION:
                            if (issue.getResolution() == null)
                            {
                                cellValue = "Unresolved";
                            }
                            else
                            {
                                cellValue = issue.getResolution().getName();
                            }
                            break;
                        default:
                            break;
                    }
                    contentCell.setCellStyle(m_book.getStyle());
                    contentCell.setCellValue(cellValue);
                }
            }

            LOG.info("Adjust columns size");
            for (int as = 0; as < columnsCount; as++)
            {
                sheet.autoSizeColumn(as);
            }
        }
        else
        {
            LOG.error("No request columns");
        }
        return this;
    }

    public void saveExcelFile(String exportFile)
    {
        LOG.info("Write file " + exportFile);
        Document.saveExcelFile(exportFile + ".xls", m_book.getBook());
    }

    public static JiraTicketsExport getIntance()
    {
        return new JiraTicketsExport();
    }
}
