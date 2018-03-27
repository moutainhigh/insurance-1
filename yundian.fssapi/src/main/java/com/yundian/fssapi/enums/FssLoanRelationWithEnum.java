package com.yundian.fssapi.enums;

/**
 * 和主贷人关系
 * 
 * @author hehaibo
 *
 */
public enum FssLoanRelationWithEnum {
	/**
	 * 兄弟
	 */
	BROTHER("BROTHER","兄弟"),
	/**
	 * 配偶
	 */
	SPOUSE("SPOUSE","配偶"),
	/**
	 * 父母
	 */
	PARENT("PARENT","父母"),
	/**
	 * 朋友
	 */
	FRIEND("FRIEND","朋友");

	private String code;
	private String desc;
	private FssLoanRelationWithEnum(String code,String desc){
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
