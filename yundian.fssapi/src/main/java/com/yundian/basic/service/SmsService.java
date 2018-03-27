package com.yundian.basic.service;


public interface SmsService {

	public boolean smsReport(String msgid,String phone,String status);
	
	/**
	 * 发送验证码（验证码时效内不重新生成新验证码）
	 * @param phone
	 * @param code
	 * @param ip
	 */
	public String sendSmsValidateCode(String phone, String invokeType, String ip);
	
	/**
	 * 发送声音验证码（验证码时效内不重新生成新验证码）
	 * @param phone
	 * @param code
	 * @param ip
	 */
	public String sendSoundSmsValidateCode(String phone, String invokeType, String ip);
	
	/**
	 * 检查验证码是否过期 
	 * @param phone
	 * @param invokeType
	 * @param code
	 * @return
	 */
	public String checkValidateCode(String phone, String invokeType, String code);

	
	
	/**
	 * 发送验证码
	 * @param phone
	 * @return
	 */
	public String sendValidateCode(String phone, String invokeType, String staticConst);
	
	/**
	 * 发送短信 
	 * @param phone 电话号码
	 * @param templatename 模板名称
	 * @param paramjson 模板参数（json格式）{"name":"张三","sex":"先生"}
	 * @return
	 */
	public String sendMessage(String phone, String templatename, String paramjson);
 
	
}
