package com.yundian.dealerweb.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yundian.dealerweb.upload.AliOssFileUpload;
import com.yundian.result.Result;
import com.yundian.result.ResultProvider;
import com.yundian.toolkit.utils.RandomUtil;
import com.yundian.toolkit.utils.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 文件上传
 *
 * @author jnx
 * @create 2018/5/3
 */
@Slf4j
@Controller
public class UploadController {


    @Autowired
    AliOssFileUpload aliOssFileUpload;

    private static final String FILE_SEPARATOR = "/";
    //临时缓存大小
    public static final int SIZE_THRESHOLD=10240000;

    @ResponseBody
    @RequestMapping(value = "/uploadfileforaliyun", method = RequestMethod.POST)
    public Result aoAliyunImgServer(HttpServletRequest request, HttpServletResponse response) {

        //{"success":true,"data":{"thumbUrl":"http://cheguo-image.cheguo.com/files/2018-05-07/20180507162405770L4mW.jpg","url":"http://cdn-file.cheguo.com/files/2018-05-07/20180507162405770L4mW.jpg"},"msg":"success","code":"200"}

        JSONObject jsonObject = JSON.parseObject("{\"thumbUrl\":\"http://cheguo-image.cheguo.com/files/2018-05-07/20180507162405770L4mW.jpg\",\"url\":\"http://cdn-file.cheguo.com/files/2018-05-07/20180507162405770L4mW.jpg\"}");
       return Result.success(jsonObject);
//        String key = null;
//        Result strReulst = null;
//        String filesource = request.getParameter("source");
//        //启用水印
//        String hasWaterMarks = request.getParameter("hasWaterMarks");
//        log.info("=======================请求文件上传====================");
//        log.info("source："+filesource);
//        log.info("hasWaterMarks："+hasWaterMarks);
//
//        if(StringUtil.isBlank(filesource)){
//            return getFailedResult("未找到验证参数");
//        }
//        try{
//                 // 设置临时文件存储位置
//                key = "files" + FILE_SEPARATOR + new SimpleDateFormat("yyyy-MM-dd").format(new Date());
//                key = key + FILE_SEPARATOR + new SimpleDateFormat("yyyyMMddHHmmssSSS") .format(new Date());
//                key += RandomUtil.generatePassword(4);
//                DiskFileItemFactory factory = new DiskFileItemFactory();
//                // 设置内存缓冲区，超过后写入临时文件
//                factory.setSizeThreshold(SIZE_THRESHOLD);
//                ServletFileUpload upload = new ServletFileUpload(factory);
//                List<?> items = upload.parseRequest(request);
//                FileItem item = null;
//                String fileName = null;
//                if(items.size()==0){
//                    return getFailedResult("文件不存在");
//                }
//                    for (int i = 0; i < items.size(); i++) {
//                        byte[] picByte = null;
//                        item = (FileItem) items.get(i);
//                        if (item.getName() == null) {
//                            continue;
//                        } else {
//                            // 文件大小
//                            fileName = item.getName();
//                            int index = fileName.lastIndexOf(".");
//                            if (index > -1) {
//                                key += fileName.substring(index);
//                            } else {
//                                key += ".jpg";
//                            }
//                            if (aliOssFileUpload.uploadToAliImgServer(key, picByte == null ? item.get() : picByte)) {
//                                return getSuccessResult(key, aliOssFileUpload.getCdnName(), aliOssFileUpload.getThumbnailName());
//                            } else {
//                                return  getFailedResult("文件上传失败");
//                            }
//                        }
//                    }
//        }catch(Exception e){
//            log.error(e.getMessage(),e);
//            return getFailedResult("上传文件处理异常");
//        }
//        return getFailedResult("上传文件处理异常");
    }

    private Result<?> getFailedResult(String message){
        return Result.fail("",message);
    }
    private Result<JSONObject> getSuccessResult(String path, String fileserver, String thumbnailserver){
        JSONObject jsonData = new JSONObject();
        jsonData.put("thumbUrl", thumbnailserver+path);
        jsonData.put("url", fileserver+path);
        return Result.success(jsonData);

    }
}
