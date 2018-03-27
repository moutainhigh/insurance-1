package com.yundian.fssapi.enums;

/**
 * 贷款办理状态
 * 
 * @author hehaibo
 *
 */
public enum FssLoanDealwithStatusEnum {
	/**
	 * 已办
	 */
	HAVE_TODO("HAVE_TODO","已办"),
	/**
	 * 未办
	 */
	UN_TODO("UN_TODO","未办"),
	;
	
	private String code;
	private String desc;
	private FssLoanDealwithStatusEnum(String code,String desc){
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
