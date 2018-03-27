package com.yundian.basic.enums;

/**
 * 短信验证码类型枚举
 * 
 * @author ningxia.jin
 *
 */
public enum BasicSmsInvokeTypeEnum {
	/**
	 * 找回密码
	 */
	FINDPASSWORD("FindPassword","找回密码"),
	;
	
	private String code;
	private String desc;
	private BasicSmsInvokeTypeEnum(String code,String desc){
		this.code=code;
		this.desc=desc;
	}
	public String code() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String desc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	
}
