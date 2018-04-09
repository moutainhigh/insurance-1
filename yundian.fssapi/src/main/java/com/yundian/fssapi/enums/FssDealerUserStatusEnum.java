package com.yundian.fssapi.enums;

/**
 * 用户状态
 * 
 * @author ningxia.jin
 *
 */
public enum FssDealerUserStatusEnum {
	/**
	 * 已办
	 */
	DISABLE("DISABLE","停用"),
	/**
	 * 未办
	 */
	NORMAL("NORMAL","正常"),
	;

	private String code;
	private String desc;
	private FssDealerUserStatusEnum(String code, String desc){
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
