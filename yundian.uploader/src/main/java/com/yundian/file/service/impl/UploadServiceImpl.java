package com.yundian.file.service.impl;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import sun.misc.BASE64Decoder;

import com.yundian.file.service.UploadService;
import com.yundian.file.utils.AliOssFileUpload;
import com.yundian.file.utils.Constants;
import com.yundian.file.utils.Util;

@Service
public class UploadServiceImpl implements UploadService {

	public String uploadfile(HttpServletRequest request) {
		// 路径
		String fileName = null;
		String key = "";
		FileItem item = null;
		// 设置临时文件存储位置
		DiskFileItemFactory factory = new DiskFileItemFactory();
		//设置内存缓冲区，超过后写入临时文件
		factory.setSizeThreshold(10240000);
		key = "files" + Constants.FILE_SEPARATOR + new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		key = key + Constants.FILE_SEPARATOR + new SimpleDateFormat("yyyyMMddHHmmssSSS") .format(new Date());
		key += Util.generatePassword(4);
		ServletFileUpload upload = new ServletFileUpload(factory);
		// 设置单个文件的最大上传值
		upload.setFileSizeMax(10002400000l);
		// 设置整个request的最大值
		upload.setSizeMax(10002400000l);
		upload.setHeaderEncoding("UTF-8");
		String strReulst = null;
		try {
			List<?> items = upload.parseRequest(request);
			if(items.size() > 0){
				for (int i = 0; i < items.size(); i++) {
					item = (FileItem) items.get(i);
					
					
					if(item.getName() == null){
						continue;
					}else{
						// 文件大小
						fileName = item.getName();	
						int index = fileName.lastIndexOf(".");
						if(index > -1){
							key += fileName.substring(index);
						}
						else{
							key += ".jpg";
						}
						if(AliOssFileUpload.uploadToAliImgServer(key, item.get())){
							strReulst = "{\"handle\": \"1\",\"message\": \"success\",\"path\":\""
								+ key
								+ "\",\"fileserver\":\""
								+ AliOssFileUpload.cdnName
								+ "\",\"thumbnailserver\":\""
								+ AliOssFileUpload.thumbnailName + "\"}";
						}
						else{
							strReulst = "{\"handle\": \"0\",\"message\":\"文件上传失败\"}";
						}
						break;
					}
				}
				if(strReulst == null){
					strReulst = "{\"handle\": \"0\",\"message\":\"没找到待上传的文件\"}";
				}
			}
			else{
				strReulst = "{\"handle\": \"0\",\"message\":\"没找到待上传的文件\"}";
			}
		} catch (Exception e) {
			e.printStackTrace();
			strReulst = "{\"handle\": \"0\",\"message\":\"文件上传失败\"}";
		}
		return strReulst;
	}

	
	public String uploadFileForBase64(String filecontent, String fileBasePath, String newdir, String extname) {
		String path = "";
		// 设置临时文件存储位置
		if (StringUtils.hasLength(newdir)) {
			path = "files" + Constants.FILE_SEPARATOR + newdir + Constants.FILE_SEPARATOR
					+ new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		} else {
			path = "files" + Constants.FILE_SEPARATOR + new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		}
		String strReulst = null;
		try {
			String key = path + Constants.FILE_SEPARATOR + new SimpleDateFormat("yyyyMMddHHmmssSSS") .format(new Date());
			key += Util.generatePassword(4);
			// 默认jpg格式
			if (StringUtils.isEmpty(extname)) {
				extname = ".jpg";
			} else if (!extname.startsWith(".")) {
				extname = "." + extname;
			}
			key = key + extname;
			BASE64Decoder decoder = new BASE64Decoder();
			// Base64解码
			byte[] b = decoder.decodeBuffer(filecontent);
			for (int i = 0; i < b.length; ++i) {
				if (b[i] < 0) {// 调整异常数据
					b[i] += 256;
				}
			}
			//生成文件
			if(AliOssFileUpload.uploadToAliImgServer(key, b)){
				strReulst = "{\"handle\": \"1\",\"message\": \"上传成功\",\"path\":\""
						+ key
						+ "\",\"fileserver\":\""
						+ AliOssFileUpload.cdnName
						+ "\",\"thumbnailserver\":\""
						+ AliOssFileUpload.thumbnailName + "\"}";
			}
			else{
				strReulst = "{\"handle\": \"0\",\"message\":\"文件上传失败\"}";
			}
         } catch (IOException e) { 
        	 e.printStackTrace(); 
        	 strReulst = "{\"handle\": \"0\",\"message\":\"文件上传失败\"}";
		}
		return strReulst;
	}
}
