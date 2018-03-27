package com.yundian.fssapi.enums;

/**
 * 贷款人关系类型  主贷人，担保人，共同还款人
 * 
 * @author hehaibo
 *
 */
public enum FssLoanRelationRelationTypeEnum {
	
	/**
	 * 主贷人
	 */
	MAIN_LOAN_PERSON("MAIN_LOAN_PERSON","主贷人"),
	/**
	 * 担保人
	 */
	GUARANTEE_PERSON("GUARANTEE_PERSON","担保人"),
	/**
	 * 共同还款人
	 */
	COMMON_REPAYMENT_PERSON("COMMON_REPAYMENT_PERSON","共同还款人");
	
	private String code;
	private String desc;
	private FssLoanRelationRelationTypeEnum(String code,String desc){
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
