package com.yundian.fssapi.enums;

/**
 * 
 * @author hehaibo
 *
 */
public enum FssLoanSexEnum {
	/**
	 * 女
	 */
	F("F","女"),
	/**
	 * 男
	 */
	M("M","男");
	
	private String code;
	private String desc;
	private FssLoanSexEnum(String code,String desc){
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
