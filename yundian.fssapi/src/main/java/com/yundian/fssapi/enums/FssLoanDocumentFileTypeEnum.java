package com.yundian.fssapi.enums;

/**
 * 贷款审核状态枚举
 * 
 * @author hehaibo
 *
 */
public enum FssLoanDocumentFileTypeEnum {
	/**
	 * 图片
	 */
	IMAGE("IMAGE","图片"),
	/**
	 * 视频
	 */
	VIDEO("VIDEO","视频"),
	/**
	 * 其他
	 */
	OTHER("OTHER","其他"),
	;
	
	private String code;
	private String desc;
	private FssLoanDocumentFileTypeEnum(String code,String desc){
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
