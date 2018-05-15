package com.yundian.toolkit.excel;

import com.alibaba.fastjson.JSON;
import com.yundian.tookit.excel.annotation.XLSValue;
import com.yundian.toolkit.utils.MapUtil;
import com.yundian.toolkit.utils.StringUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import java.beans.IntrospectionException;
import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;


public class ExcelUtil {

	/**
	 * 导出excel
	 * @param title  sheet页标题
	 * @param headers  第一行标题，一般中文名称
	 * @param columnNames  和headers对应属性名称
	 * @param mapList	数据
	 * @param out	文件流
	 */
	public static void exportExcel(String title, String[] headers,String[] columnNames,List<Map<String,Object>> mapList, OutputStream out) {
		// 声明一个工作簿
		HSSFWorkbook workbook = new HSSFWorkbook();
		// 生成一个表格
		HSSFSheet sheet = workbook.createSheet(title);
		// 设置表格默认列宽度为15个字符
		sheet.setDefaultColumnWidth(20);
		// 生成一个样式，用来设置标题样式
		HSSFCellStyle styleHeader = workbook.createCellStyle();
		// 设置这些样式
		styleHeader.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		styleHeader.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		styleHeader.setBorderRight(HSSFCellStyle.BORDER_THIN);
		styleHeader.setBorderTop(HSSFCellStyle.BORDER_THIN);
		styleHeader.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		// 生成一个字体
		HSSFFont font = workbook.createFont();
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		// 把字体应用到当前的样式
		styleHeader.setFont(font);

		// 生成一个样式，用来设置主体样式
		HSSFCellStyle styleBody = workbook.createCellStyle();
		// 设置这些样式
		styleBody.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		styleBody.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		styleBody.setBorderRight(HSSFCellStyle.BORDER_THIN);
		styleBody.setBorderTop(HSSFCellStyle.BORDER_THIN);
		styleBody.setAlignment(HSSFCellStyle.ALIGN_CENTER);

		// 产生表格标题行
		HSSFRow row = sheet.createRow(0);
		for (int i = 0; i < headers.length; i++) {
			HSSFCell cell = row.createCell(i);
			cell.setCellStyle(styleHeader);
			HSSFRichTextString text = new HSSFRichTextString(headers[i]);
			cell.setCellValue(text);
		}
		for (int i = 0; i < mapList.size(); i++) {
			Map<String, Object> map = (Map<String, Object>) mapList.get(i);
			row = sheet.createRow(i + 1);
			if(null != columnNames&&columnNames.length>0){
				for(int j=0;j<columnNames.length;j++){
					HSSFCell cell = row.createCell(j);
					cell.setCellStyle(styleBody);
					Object v = map.get(columnNames[j]);
					cell.setCellValue(v==null?StringUtils.EMPTY:String.valueOf(map.get(columnNames[j])));
				}
			}
		}
		try {
			workbook.write(out);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 编码格式设置 防止文件名乱码
	 * @param useragent
	 * @param filename
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String fileDisposition(String useragent, String filename) throws UnsupportedEncodingException {
		String charset = "UTF-8";
		String userAgent = StringUtils.lowerCase(useragent);
		String new_filename = URLEncoder.encode(filename, charset);
		String str = "attachment; filename=" + URLEncoder.encode(filename, charset);
		if (StringUtils.isEmpty(userAgent)) {
			return str;
		}
		// IE浏览器
		if (userAgent.indexOf("msie") != -1) {

		}
		// Opera浏览器只能采用filename*
		else if (userAgent.indexOf("opera") != -1) {
			str = "attachment; filename*=UTF-8''" + new_filename;
		}
		// Safari浏览器，只能采用ISO编码的中文输出
		else if (userAgent.indexOf("safari") != -1) {
			str = "attachment; filename=" + new String(filename.getBytes("UTF-8"), "ISO8859-1");
		}
		// Chrome浏览器，只能采用MimeUtility编码或ISO编码的中文输出
		else if (userAgent.indexOf("applewebkit") != -1) {

		}
		// FireFox浏览器，可以使用MimeUtility或filename*或ISO编码的中文输出
		else if (userAgent.indexOf("mozilla") != -1) {
			str = "attachment; filename*=UTF-8''" + new_filename;
		}
		return str;
	}

	/**
	 * 读取Excel数据内容
	 * @param fileFullPath 文件类型
	 * @param sheetNo sheet 页号
	 * @return Map 包含单元格数据内容的Map对象
	 */
	public static List<Map<String,Object>> readExcel(String fileFullPath,int sheetNo) {

		POIFSFileSystem fs;
		HSSFWorkbook wb=null;
		HSSFSheet sheet;
		HSSFRow row;

		System.out.println("开始解析xls...");
		sheetNo--;//从1开始及从0开始
		InputStream is = null;
		try {
			is = new FileInputStream(fileFullPath);
		} catch (FileNotFoundException e1) {
			System.out.println(e1.getMessage());
		}
		Map<String,Object> dataMap = null;
		List<Map<String,Object>> dataList= new ArrayList<>();
		String value = "";
		try {
			fs = new POIFSFileSystem(is);
			wb = new HSSFWorkbook(fs);
		} catch (IOException e) {
			System.out.println(e);
		}
		sheet = wb.getSheetAt(sheetNo);
		row = sheet.getRow(0);
		// 标题总列数
		int colNum = row.getPhysicalNumberOfCells();
		String[] keyArray = new String[colNum];
		for (int i = 0; i < colNum; i++) {
			keyArray[i] = getCellFormatValue(row.getCell((short) i));
		}
		int rowNum = sheet.getLastRowNum();
		// 正文内容应该从第二行开始,第一行为表头的标题
		for (int i = 2; i <= rowNum; i++) {
			dataMap= new HashMap<>();
			row = sheet.getRow(i);
			if(row!=null){
				int j = 0;
				while (j < colNum) {
					//这里把列循环到Map
					if(row.getCell((short) j)!=null){
						value = getCellFormatValue(row.getCell((short) j)).trim();
						dataMap.put(keyArray[j],value);
					}
					j++;
				}
				value = "";
				dataList.add(dataMap);
			}
		}
		System.out.println("解析xls完成...");
		try {
			if(is!=null){
				is.close();
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return dataList;
	}

	/**
	 * 根据HSSFCell类型设置数据
	 * @param cell
	 * @return
	 */
	private static String getCellFormatValue(HSSFCell cell) {
		String cellvalue = "";
		if (cell != null) {
			// 判断当前Cell的Type
			switch (cell.getCellType()) {
				// 如果当前Cell的Type为NUMERIC
				case HSSFCell.CELL_TYPE_NUMERIC:
				case HSSFCell.CELL_TYPE_FORMULA: {
					// 判断当前的cell是否为Date
					if (HSSFDateUtil.isCellDateFormatted(cell)) {
						Date date = cell.getDateCellValue();
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						cellvalue = sdf.format(date);
					}
					// 如果是纯数字
					else {
						// 取得当前Cell的数值
						DecimalFormat df = new DecimalFormat("0");
						String dfStr = df.format(cell.getNumericCellValue());
						cellvalue = dfStr;
					}
					break;
				}
				// 如果当前Cell的Type为STRIN
				case HSSFCell.CELL_TYPE_STRING:
					// 取得当前的Cell字符串
					cellvalue = cell.getRichStringCellValue().getString();
					break;
				// 默认的Cell值
				default:
					cellvalue = " ";
			}
		} else {
			cellvalue = "";
		}
		return cellvalue;

	}


	public static  <T> List<T> xlsToModel(String xlsPath,Class<T> modelClass){
		List<Map<String,Object>> xlsList = readExcel(xlsPath,1);
		List<T> modelList = new ArrayList<T>();

		for(Map<String,Object> item :xlsList){
			try {
				T o = convertMap(modelClass, item);
				modelList.add(o);
			}catch (Exception e ){
				System.out.printf("map->model 失败"+e.getMessage());
			}
		}
		return modelList;
	}
	private static <T> T convertMap(Class<T> type, Map<String,Object> map)
			throws IntrospectionException, IllegalAccessException,
			InstantiationException, InvocationTargetException{

		T obj = type.newInstance();

		Field[] fields = type.getDeclaredFields();
		for(Field field:fields)
		{
			// 获取原来的访问控制权限
			boolean accessFlag = field.isAccessible();
			// 修改访问控制权限
			field.setAccessible(true);
			try {

				XLSValue xlsValue = field.getAnnotation(XLSValue.class);
				if(xlsValue!=null
						&&StringUtil.isNotBlank(xlsValue.value())
						&&map.containsKey(xlsValue.value())){

					field.set(obj,map.get(xlsValue.value()));
				}
			}catch (Exception e){
				System.out.printf("toPropField error"+e.getMessage());
			}
			field.setAccessible(accessFlag);
		}
		return obj;
	}

	public static void main(String... args) {

		String filePath="/Users/jnx/Documents/客户.xls";
		List<Map<String,Object>> list= 	readExcel(filePath,1);
		System.out.println(JSON.toJSONString(list));
	}
}
