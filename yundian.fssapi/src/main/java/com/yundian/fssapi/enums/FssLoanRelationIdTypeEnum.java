package com.yundian.fssapi.enums;

/**
 * 证件类型
 * 
 * @author hehaibo
 *
 */
public enum FssLoanRelationIdTypeEnum {
	/**
	 * 身份证
	 */
	ID("ID","身份证"),
	/**
	 * 军官证
	 */
	ARMY_CERTIFICATE("ARMY_CERTIFICATE","军官证"),
	/**
	 * 侨胞证
	 */
	OVERSEAS_CHINA_CERTIFICATE("ADUIT_PASS","侨胞证"),
	/**
	 * 外籍人士
	 */
	FOREIGNERS_CERTIFICATE("FOREIGNERS_CERTIFICATE","外籍人士");
	
	private String code;
	private String desc;
	private FssLoanRelationIdTypeEnum(String code,String desc){
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
