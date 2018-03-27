package com.yundian.fssapi.enums;

/**
 * 贷款审核状态枚举
 * 
 * @author hehaibo
 *
 */
public enum FssGuaranteeVerifyStatusEnum {
	
	/**
	 * 未认证
	 */
	NO_AUTH("NO_AUTH","未认证"),
	/**
	 * 认证中
	 */
	AUTH_PROCESSING("AUTH_PROCESSING","认证中"),
	/**
	 * 已认证
	 */
	AUTH_PASS("AUTH_PASS","已认证"),
	/**
	 * 认证失败
	 */
	AUTH_FAIL("AUTH_FAIL","认证失败");
	
	private String code;
	private String desc;
	private FssGuaranteeVerifyStatusEnum(String code,String desc){
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
