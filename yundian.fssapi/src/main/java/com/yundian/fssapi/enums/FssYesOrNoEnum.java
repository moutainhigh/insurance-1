package com.yundian.fssapi.enums;

/**
 * 
 * @author hehaibo
 *
 */
public enum FssYesOrNoEnum {
	/**
	 * 是
	 */
	Y("Y","是"),
	/**
	 * 否
	 */
	N("N","否");
	
	private String code;
	private String desc;
	private FssYesOrNoEnum(String code,String desc){
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
