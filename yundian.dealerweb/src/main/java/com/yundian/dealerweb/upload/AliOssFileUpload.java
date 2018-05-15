package com.yundian.dealerweb.upload;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.PutObjectRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;


public class AliOssFileUpload {


	private  String accessKeyId;
	private  String accessKeySecret;

	/**
	 * 阿里云图片上传地址(http://oss.aliyuncs.com/)
	 */
	private  String endPoint;
	/**
	 * 缩略图上传地址
	 */
	private  String thumbnailEndPoint;

	/**
	 * 根目录
	 */
	private  String bucketName;
	private   String cdnName;
	private   String thumbnailName;
	
	public  boolean uploadThumbnailToAliImgServer(String key, byte[] fileContent) {
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

	public  boolean uploadToAliImgServer(String key, byte[] fileContent) {
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

	public String getAccessKeyId() {
		return this.accessKeyId;
	}

	public void setAccessKeyId(String accessKeyId) {
		this.accessKeyId = accessKeyId;
	}

	public String getAccessKeySecret() {
		return this.accessKeySecret;
	}

	public void setAccessKeySecret(String accessKeySecret) {
		this.accessKeySecret = accessKeySecret;
	}

	public String getEndPoint() {
		return this.endPoint;
	}

	public void setEndPoint(String endPoint) {
		this.endPoint = endPoint;
	}

	public String getThumbnailEndPoint() {
		return this.thumbnailEndPoint;
	}

	public void setThumbnailEndPoint(String thumbnailEndPoint) {
		this.thumbnailEndPoint = thumbnailEndPoint;
	}

	public String getBucketName() {
		return this.bucketName;
	}

	public void setBucketName(String bucketName) {
		this.bucketName = bucketName;
	}

	public String getCdnName() {
		return this.cdnName;
	}

	public void setCdnName(String cdnName) {
		this.cdnName = cdnName;
	}

	public String getThumbnailName() {
		return this.thumbnailName;
	}

	public void setThumbnailName(String thumbnailName) {
		this.thumbnailName = thumbnailName;
	}
}
