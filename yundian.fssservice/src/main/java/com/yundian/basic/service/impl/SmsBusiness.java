package com.yundian.basic.service.impl;

import com.yundian.basic.business.ISmsExecutor;
import com.yundian.basic.domain.SysConfigModel;
import com.yundian.basic.service.SysConfigService;
import com.yundian.basic.tools.SmsPropertiesUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;


public class SmsBusiness {
	
	Logger logger = Logger.getLogger(SmsBusiness.class);
	
	/**
	 * 短信接口是否打开
	 */
	private String open = SmsPropertiesUtil.readValue("sms.open");
	
	/**
	 * 语音验证码接口是否打开
	 */
	private String open_sound = SmsPropertiesUtil.readValue("sms.sound.open");
	
	
	@Autowired
	SysConfigService sysConfigService;

	
	/**
	 * 发送短信
	 * @param phone
	 * @param sms
	 * @return String[]   {result,msgid}
	 * @throws Exception
	 */
	protected String[] sendSms(String phone, String sms) throws Exception {
		if (this.open.equals("false"))
			return new String[]{"close","",""};
		 
		 SysConfigModel smsConfig = sysConfigService.getModel("smschannel");
		 smsConfig.getValue();
		 ISmsExecutor smsExecutor =null;
		if(SmsChannel.CHANNEL_ZHUTONG.equals(smsConfig.getValue()))
		{
			smsExecutor = new SmsZhuTongExecutor();
		}
		else if(SmsChannel.CHANNEL_CHUANLAN.equals(smsConfig.getValue()))
		{
			smsExecutor = new SmsChuanlanExecutor();
		}
		else
		{
			throw new Exception("获取短信通道失败，找不着当前短信通道配置项。");
		}
	
		return smsExecutor.sendSms(phone, sms);
		
	}
	
	/**
	 * 语音验证码
	 * 
	 * @param phone
	 * @param sms
	 * @return String[]   {result,msgid}
	 * @throws Exception
	 */
	protected String[] sendSoundSms(String phone, String sms) throws Exception {
		
		if (this.open_sound.trim().equalsIgnoreCase("false")){
			return new String[] { "close", "", "" };
		}
		
		SysConfigModel smsConfig = sysConfigService.getModel("smschannel");
		ISmsExecutor smsExecutor = null;
		if (SmsChannel.CHANNEL_ZHUTONG.equals(smsConfig.getValue())) {
			smsExecutor = new SmsZhuTongExecutor();
		} else if (SmsChannel.CHANNEL_CHUANLAN.equals(smsConfig.getValue())) {
			smsExecutor = new SmsChuanlanExecutor();
		} else {
			throw new Exception("获取语音通道失败，找不着当前语音通道配置项。");
		}
		
		return smsExecutor.sendSoundSms(phone, sms);
	}

	public int getStatus(String status,String channel)
	{
		int sucessStatus =1;
		int failedStatus =0;
		if(SmsChannel.CHANNEL_ZHUTONG.equals(channel)) {
			//status	返回的状态。1代表成功，非1代表失败
			if(status.toUpperCase().equals("1")) {
				return sucessStatus;
			}
			else {
				return failedStatus;
			}
		}
		else if(SmsChannel.CHANNEL_CHUANLAN.equals(channel))
		{
			/**
			 * status:
			 DELIVRD	短消息转发成功
			EXPIRED	短消息超过有效期
			UNDELIV	短消息是不可达的
			UNKNOWN	未知短消息状态
			REJECTD	短消息被短信中心拒绝
			DTBLACK	目的号码是黑名单号码
			ERR:104	系统忙
			REJECT	审核驳回
			其他	网关内部状态

			 */
			if(status.toUpperCase().equals("DELIVRD"))
			{
				return sucessStatus;
			}
			else
			{
				return failedStatus;
			}
			
		}
		return failedStatus;
	}
	 
	public String isOpen() {
		return open;
	}

	public void setOpen(String open) {
		this.open = open;
	}
	

}
