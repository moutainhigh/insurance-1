package com.yundian.file.utils;

import java.io.ByteArrayInputStream;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.PutObjectRequest;

public class AliOssFileUpload {

	private static String accessKeyId = GetProperties.readValue("accesskeyid");
	private static String accessKeySecret = GetProperties.readValue("accesskeysecret");

	/**
	 * 阿里云图片上传地址(http://oss.aliyuncs.com/)
	 */
	private static String endPoint = GetProperties.readValue("aliyunserver");
	/**
	 * 缩略图上传地址
	 */
	private static String thumbnailEndPoint = GetProperties.readValue("thumbnailserver");

	/**
	 * 根目录
	 */
	private static String bucketName = GetProperties.readValue("bucketname");
	public static final String cdnName = GetProperties.readValue("cdnname");
	public static final String thumbnailName = GetProperties.readValue("thumbnailname");
	
	public static boolean uploadThumbnailToAliImgServer(String key, byte[] fileContent) {
		// 初始化上传客户端
		OSSClient client = new OSSClient(thumbnailEndPoint, accessKeyId, accessKeySecret);
		try {
			// 上传到阿里云图片服务器
			client.putObject(new PutObjectRequest(bucketName, key, new ByteArrayInputStream(fileContent)));
			return true;
		} catch (OSSException e) {
			e.printStackTrace();
		} catch (ClientException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			client.shutdown();
		}
		return false;
	}

	public static boolean uploadToAliImgServer(String key, byte[] fileContent) {
		// 初始化上传客户端
		OSSClient client = new OSSClient(endPoint, accessKeyId, accessKeySecret);
		try {
			// 上传到阿里云图片服务器
			client.putObject(new PutObjectRequest(bucketName, key, new ByteArrayInputStream(fileContent)));
			return true;
		} catch (OSSException e) {
			e.printStackTrace();
		} catch (ClientException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			client.shutdown();
		}
		return false;
	}
}
