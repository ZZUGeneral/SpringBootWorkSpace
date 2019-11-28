HSSF（用于操作Excel的组件）提供给用户使用的对象在rg.apache.poi.hssf.usermodel包中,主要部分包括Excel对象，样式和格式，有以下几种常用的对象：

常用组件：
HSSFWorkbook     excel的文档对象
HSSFSheet            excel的表单
HSSFRow               excel的行
HSSFCell                excel的格子单元
HSSFFont               excel字体
样式：
HSSFCellStyle         cell样式

首先，我们应该要知道的是，一个Excel文件对应一个workbook，一个workbook中有多个sheet组成，一个sheet是由多个行(row)和列(cell)组成。那么我们用poi要导出一个Excel表格
的正确顺序应该是：
1、用HSSFWorkbook打开或者创建“Excel文件对象”
2、用HSSFWorkbook对象返回或者创建Sheet对象
3、用Sheet对象返回行对象，用行对象得到Cell对象
4、对Cell对象读写。
5、将生成的HSSFWorkbook放入HttpServletResponse中响应到前端页面