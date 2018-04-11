package com.yundian.file.action;

import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.yundian.file.service.UploadService;
import com.yundian.file.utils.AliOssFileUpload;
import com.yundian.file.utils.BaiduMapProvider;
import com.yundian.file.utils.Constants;
import com.yundian.file.utils.Util;
import com.yundian.file.utils.WaterMarksUtils;

@Controller
@RequestMapping()
public class UploadAction {
	
	Logger logger = Logger.getLogger(UploadAction.class);
	@Resource
	UploadService uploadService;
	
	@ResponseBody
	@RequestMapping(value = "/uploadfile", method = RequestMethod.POST)
	public void uploadfile(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = null;
		try{
			String strReulst = uploadService.uploadfile(request);
			response.setContentType("text/html;charset=UTF-8");
			pw = response.getWriter();
			pw.write(strReulst);
		}catch(Exception e){
			e.printStackTrace();
			pw.write(getFailedResult("文件上传失败"));
		}finally{
			if(pw != null)
				pw.close();
		}
	}
	
	
	@RequestMapping(value = "/uploadfileforbase64", method = RequestMethod.POST)
	public void uploadfileForBase64(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = null;
		try{
			pw = response.getWriter();
			ByteArrayOutputStream outSteam = new ByteArrayOutputStream();  
			byte[] buffer = new byte[1024];  
			int len = -1;  
			while ((len = request.getInputStream().read(buffer)) != -1) {  
			    outSteam.write(buffer, 0, len);  
			}  
		    String params = new String(outSteam.toByteArray());
		    outSteam.close(); 
		    String strReulst = null;
		    String newdir = null;
		    String extname = null;
		    String filecontent = null;
			if(params == null || params.length() == 0){
				strReulst =getFailedResult("未找到文件");
			}else{
				String[] pArr = params.split("&");
				for (int i = 0; i < pArr.length; i++) {
					if(pArr[i].startsWith("filecontent")){
						filecontent = pArr[i].substring(pArr[i].indexOf("=") + 1);
					}else if(pArr[i].startsWith("newdir")){
						newdir = pArr[i].substring(pArr[i].indexOf("=") + 1);
					}else if(pArr[i].startsWith("extname")){
						extname = pArr[i].substring(pArr[i].indexOf("=") + 1);
					}
				}
				filecontent = filecontent.replaceAll(" ", "+");
				@SuppressWarnings("deprecation")
				String fileBasePath = request.getRealPath(Constants.FILE_SEPARATOR);
				strReulst = uploadService.uploadFileForBase64(filecontent, fileBasePath, newdir, extname);
			}
			pw.write(strReulst);
		}catch(Exception e){
			e.printStackTrace();
			pw.write(getFailedResult("文件上传失败"));
		}finally{
			if(pw != null)
				pw.close();
		}
	}

	
	@RequestMapping(value = "/uploadfileforaliyun", method = RequestMethod.POST)
	public void aoAliyunImgServer(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = null;
		String key = null;
		String strReulst = null;
		try{
			
			//读取客户端信息
			String os = request.getHeader("os");//移动端版本
			String eq = request.getHeader("eq");//设备号
			String coordinate = request.getHeader("coordinate"); //经纬度
			//String coordinate = request.getParameter("coordinate");
			String app_version = request.getHeader("app_version"); 
			pw = response.getWriter();
			String filesource = request.getParameter("source");
			String hasWaterMarks = request.getParameter("hasWaterMarks");//启用水印
			String photo_op = request.getParameter("photo_op");////时间
			logger.info("=======================请求文件上传====================");
			logger.info("source："+filesource);
			logger.info("os："+os);
			logger.info("eq："+eq);
			logger.info("coordinate："+coordinate);
			logger.info("app_version："+app_version);
			logger.info("hasWaterMarks："+hasWaterMarks);
			logger.info("photo_op："+photo_op);
			if(StringUtils.hasLength(filesource)){
				// 设置临时文件存储位置
				key = "files" + Constants.FILE_SEPARATOR + new SimpleDateFormat("yyyy-MM-dd").format(new Date());
				key = key + Constants.FILE_SEPARATOR + new SimpleDateFormat("yyyyMMddHHmmssSSS") .format(new Date());
				key += Util.generatePassword(4);
				DiskFileItemFactory factory = new DiskFileItemFactory();
				// 设置内存缓冲区，超过后写入临时文件
				factory.setSizeThreshold(10240000);
				ServletFileUpload upload = new ServletFileUpload(factory);
				List<?> items = upload.parseRequest(request);
				FileItem item = null;
				String fileName = null;
				
				if (items.size() > 0) {
					for (int i = 0; i < items.size(); i++) {
						byte[] picByte=null;
						item = (FileItem) items.get(i);
						if(item.getName() == null){
							continue;
						}else{
							
							//经纬度水印
							if(StringUtils.hasLength(hasWaterMarks)&&hasWaterMarks.equals("true"))
							{
								String[]  watermarks = new String[2];
						            watermarks[0] = BaiduMapProvider.transformatLocation(coordinate);
						            watermarks[1] = "拍摄时间:" + photo_op==null?
						            		new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()):photo_op;
								
						        picByte=  WaterMarksUtils.markImageByIcon(watermarks, item.getInputStream(), 128);
							}
							// 文件大小
							fileName = item.getName();	
							int index = fileName.lastIndexOf(".");
							if(index > -1){
								key += fileName.substring(index);
							}
							else{
								key += ".jpg";
							}
							if(AliOssFileUpload.uploadToAliImgServer(key, picByte==null?item.get():picByte)){
								strReulst =getSuccessResult(key,AliOssFileUpload.cdnName,AliOssFileUpload.thumbnailName);
							}
							else{
								strReulst = getFailedResult("文件上传失败");
							}
							break;
						}
					}
					if(strReulst == null){
						strReulst = getFailedResult("没找到待上传的文件"); 
					}
				}else{
					strReulst = getFailedResult("未找到待上传文件");
				}
			}else{
				strReulst =getFailedResult("未找到验证参数");
			}
			pw.write(strReulst);
		}catch(Exception e){
			logger.error(e.getMessage(),e);
			pw.write(getFailedResult("文件上传失败"));
		}finally{
			if(pw != null)
				pw.close();
		}
	}
	
	private String getFailedResult(String message){
		JSONObject json = new JSONObject();
		json.put("code", 20000);
		json.put("message", message);
		logger.info(json.toString());
		return json.toString();
	}
	private String getSuccessResult(String path,String fileserver,String thumbnailserver){
		JSONObject json = new JSONObject();
		json.put("code", 10000);
		json.put("message", "success");
		json.put("path", path);
		json.put("fileserver", fileserver);
		json.put("thumbnailserver", thumbnailserver);
		logger.info(json.toString());
		return json.toString();
	}
}
