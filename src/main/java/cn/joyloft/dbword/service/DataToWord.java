package cn.joyloft.dbword.service;

import cn.joyloft.dbword.entity.TableFileds;
import cn.joyloft.dbword.entity.Tables;
import cn.joyloft.dbword.mapper.QueryDao;
import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.rtf.RtfWriter2;
import org.springframework.stereotype.Component;


import javax.annotation.Resource;
import java.awt.*;
import java.io.FileOutputStream;
import java.util.List;

@Component
public class DataToWord {

    @Resource
    QueryDao queryDao;


    public void toWord(String dataName, String fileName) {// 创建word文档,并设置纸张的大小

        Document document = new Document(PageSize.A4);
        try {
            List<Tables> tables = queryDao.getAllTables(dataName);//库名

            // 创建word文档
            RtfWriter2.getInstance(document, new FileOutputStream(fileName));
            document.open();
            Paragraph ph = new Paragraph();

            Font f = new Font();
            Paragraph p = new Paragraph(dataName, new Font(Font.NORMAL, 24, Font.BOLDITALIC, new Color(0, 0, 0)));
            p.setAlignment(1);
            document.add(p);
            ph.setFont(f);

            for (int i = 0; i < tables.size(); i++) {
                String table_name = tables.get(i).getName();
                String table_comment = tables.get(i).getComment();
                List<TableFileds> fileds = queryDao.getTable(tables.get(i).getName());
                String all = "" + (i + 1) + " 表名:" + table_name + ":" + table_comment;//表头

                Table table = new Table(5);//5列
                table.setWidth(100.0f);
                table.setBorderWidth(1);
                table.setPadding(0);
                table.setSpacing(0);

                document.add(new Paragraph(""));

                /*
                 * 添加表头的元素，并设置表头背景的颜色
                 */
                Color chade = new Color(176, 196, 222);
                Cell cell = new Cell("field");// 单元格
                cell.setBackgroundColor(chade);
                table.addCell(cell);
                cell = new Cell("type");// 单元格
                cell.setBackgroundColor(chade);
                table.addCell(cell);
                cell = new Cell("isNull");// 单元格
                cell.setBackgroundColor(chade);
                table.addCell(cell);
                cell = new Cell("primary key");// 单元格
                cell.setBackgroundColor(chade);
                table.addCell(cell);
                cell = new Cell("comment");// 单元格
                cell.setBackgroundColor(chade);
                table.addCell(cell);
                table.endHeaders();// 表头结束
                // 表格的主体
                for (int k = 0; k < fileds.size(); k++) {
                    String Field = fileds.get(k).getField();
                    String Type = fileds.get(k).getType();
                    String Null = fileds.get(k).getNull();
                    String Key = fileds.get(k).getKey();
                    String Comment = fileds.get(k).getComment();
                    table.addCell(Field);
                    table.addCell(Type);
                    table.addCell(Null);
                    table.addCell(Key);
                    table.addCell(Comment);
                }
                Paragraph pheae = new Paragraph(all);
                //写入表说明
                document.add(pheae);
                //生成表格
                document.add(table);
            }
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
