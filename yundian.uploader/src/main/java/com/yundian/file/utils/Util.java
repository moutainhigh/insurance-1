package com.yundian.file.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.activation.MimetypesFileTypeMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.util.FileCopyUtils;

import com.alibaba.fastjson.JSONObject;

public class Util {

	/**
	 * 说明:随便产生多少位的随即数
	 * 
	 * @param codeCount
	 *            随即数的个数
	 * @param codeSequence
	 *            数组
	 * @return
	 */
	public static String getValidateCode(int codeCount, char[] codeSequence) {
		String randomCode = "";
		for (int i = 0; i < codeCount; i++) {
			randomCode += codeSequence[(int) Math.floor(Math.random()
					* (codeSequence.length))];
		}
		return randomCode;
	}

	/**
	 * 生成随机密码
	 * 
	 * @return
	 */
	public static String generatePassword(int count) {
		char[] codeSequence = { '0', '1', '2', '3', '4', '5', '6', '7', '8',
				'9' };
		if (count < 1 || count > 16)
			count = 4;
		return getValidateCode(count, codeSequence);
	}

	public static String[] getUploadFileName(String fileName) {
		// 文件名 年月日时分秒+毫秒+4位随机数
		String strfileName = new SimpleDateFormat("yyyyMMddHHmmssSSS")
				.format(new Date()) + generatePassword(4);
		int lastIndexOfDot = fileName.lastIndexOf('.');
		int fileNameLength = fileName.length();
		String extension = fileName.substring(lastIndexOfDot + 1,
				fileNameLength);
		String fileNameBig = strfileName + "." + extension;
		String fileNameSmall = strfileName + "S." + extension;
		String[] fileNames = {fileNameBig,fileNameSmall};
		return fileNames;
//		return strfileName + "." + extension;
	}

	/**
	 * 下载文件
	 * 
	 * @param filepath
	 *            文件路径
	 * @param filename
	 *            文件名称
	 * @param httpServletRequest
	 *            httpRequest对象
	 * @param httpServletResponse
	 *            httpResponse对象
	 * @throws IOException
	 */
	public static void downLoadFile(String filepath, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException {
		if (filepath == null || filepath.trim().length() == 0
				|| httpServletRequest == null || httpServletResponse == null) {
			return;
		}
		File file = new File(filepath);
		if (!file.exists()) {
			System.out.println(file.getAbsolutePath() + " 文件不存在!");
			return;
		}

		// 下载文件
		// 设置响应头和下载保存的文件名
		String filename = file.getName();
		if (filename != null && filename.length() > 0) {
			httpServletResponse.setContentType(new MimetypesFileTypeMap()
					.getContentType(file));
			httpServletResponse.setHeader(
					"content-disposition",
					"attachment; filename="
							+ URLEncoder.encode(filename, "UTF-8"));
			httpServletResponse.setHeader("Content-Length",
					String.valueOf(file.length()));

			InputStream is = new FileInputStream(file);
			FileCopyUtils.copy(is, httpServletResponse.getOutputStream());
			httpServletResponse.flushBuffer();
		}
	}

	/**
	 * 
	 * 
	 * @param request
	 * @param key
	 * @param value
	 */
	public static JSONObject exceptionProcess(Exception e, String message) {
		JSONObject resultJson = new JSONObject();
		resultJson.put(Constants.RESULT_CODE, Constants.RESULT_CODE_FAILURE);
		resultJson.put(Constants.RESULT_MESSAGE, message);
		resultJson.put(Constants.EXCEPTION_STACK_TRACE,
				ExceptionUtils.getFullStackTrace(e));
		return resultJson;
	}
}
