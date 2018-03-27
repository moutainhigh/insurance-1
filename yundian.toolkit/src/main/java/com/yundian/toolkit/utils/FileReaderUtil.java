package com.yundian.toolkit.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class FileReaderUtil {
	
	 /**
	  * 缓存
	  */
     private static Map<String, String> files = new HashMap<String,String>(); 

     /**
      * 车商邮件模板
      */
	 private static String carMailFile = "pageinfo/mail/cardealer.htm";
	 /**
	  * 金融服务商邮件模板
	  */
	 private static String financeMailFile = "pageinfo/mail/finance.htm";
	 
	 /**
	  * 读取文件内容
	  * @param fileName
	  * @return
	  */
     public static String getFileContent(String fileName){
		if (files != null && files.containsKey(fileName)) {
			return files.get(fileName);
		}else{
			URL url = FileReaderUtil.class.getClassLoader().getResource("/");
			String filePath = null;
			if(url != null){
				filePath = url.getFile();
				if(filePath.endsWith(File.separator) || filePath.endsWith("/")){
					//去掉最后一个路径分隔符
					filePath = filePath.substring(0, filePath.length() - 1);
				}
				//路径最后一级目录为classes
				if(filePath.toLowerCase().endsWith("classes")){
					filePath = filePath.substring(0,filePath.toLowerCase().lastIndexOf("classes"));
				}
			}
			else{
				return "";
			}
			String fileContent = null;
			//表示要获取车商邮件
			if(carMailFile.toLowerCase().contains(fileName)){
				filePath = filePath + File.separator + carMailFile.replace("/", File.separator);
				fileContent = readFile(filePath);
				files.put(fileName, fileContent);
			}else if(financeMailFile.toLowerCase().contains(fileName)){
				filePath = filePath + File.separator + financeMailFile.replace("/", File.separator);
				fileContent = readFile(filePath);
				files.put(fileName, fileContent);
			}
			return fileContent;
		}
     }
     
	/**
	 * 读取文件内容
	 * 
	 * @param filePath 文件路径
	 * @return
	 */
	private static String readFile(String filePath) {
		String fileContent = "";
		try {
			String tempStr = "";
			FileInputStream fileInputStream = new FileInputStream(filePath);
			BufferedReader buffer = new BufferedReader(new InputStreamReader(
					fileInputStream,"utf-8"));
			while ((tempStr = buffer.readLine()) != null)
				fileContent += tempStr;
			fileInputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
			return "";
		}
		return fileContent;
	}
	
	/**
	 * 读取文件内容
	 * 
	 * @param filePath 文件路径
	 * @return
	 */
	public static String readFileLineByLine(String filePath) {
		try {
			String encoding = "utf-8";
			File file = new File(filePath);
			if (file.isFile() && file.exists()) { // 判断文件是否存在
				InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);// 考虑到编码格式
				BufferedReader bufferedReader = new BufferedReader(read);
				String lineTxt = null;
				StringBuffer sb = new StringBuffer();
				while ((lineTxt = bufferedReader.readLine()) != null) {
					sb.append(lineTxt);
					sb.append("\n");
				}
				read.close();
				return sb.toString();
			} else {
				System.out.println("找不到指定的文件");
			}
		} catch (Exception e) {
			System.out.println("读取文件内容出错");
			e.printStackTrace();
		}
		return filePath;
	}
}
