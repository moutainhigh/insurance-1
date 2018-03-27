package com.yundian.basic.business;

public interface ISmsExecutor {

	
	/**
	 * 发送短信验证码
	 * 
	 * @param phone
	 * @param sms
	 * @return
	 * @throws Exception
	 */
	
	String[] sendSms(String phone, String sms) throws Exception;
	
	/**
	 * 发送语音验证码
	 * 
	 * @param phone
	 * @param sms
	 * @return
	 * @throws Exception
	 */
	String[] sendSoundSms(String phone, String sms) throws Exception;
	
	String getChannel();
	/**
	 * 短信状态报告处理
	 * @param report
	 * @return
	 */
	String[] smsReport(String report);
}
