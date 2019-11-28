package com.yhl.test.outputfirst.util;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.HorizontalAlignment;

/**
 * @author 杨贺龙
 * @name ExccelUtil
 * @create 2019-11-27 8:52
 * @description:导出Excel文件的工具类
 */
public class ExcelUtil {
    public static HSSFWorkbook getHSSFWorkbook(String sheetname, String[] title, String[][] values, HSSFWorkbook wb) {
//第一步,创建一个HSSFWorkbook,对应一个Excel文件
        if (wb == null) {
            wb = new HSSFWorkbook();
        }
        //第二步,在woekbook中添加一个sheet,对应Excel中的sheet
        HSSFSheet sheet = wb.createSheet();
        //第三步,在sheet中添加表头第0行
        HSSFRow row = sheet.createRow(0);
        //第四步,创建单元格,并设置值表头,设置表头居中
        HSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER_SELECTION);
        //创建列对象
        HSSFCell cell = null;
        //创建标题
        for (int i = 0; i < title.length; i++) {
            cell = row.createCell(i);
            cell.setCellValue(title[i]);
            cell.setCellStyle(style);
        }
        //创建内容
        for (int i = 0; i < values.length; i++) {
            row = sheet.createRow(i + 1);
            for (int j = 0; j < values[i].length; j++) {
                row.createCell(j).setCellValue(values[i][j]);
            }
        }
        return wb;
    }

}
