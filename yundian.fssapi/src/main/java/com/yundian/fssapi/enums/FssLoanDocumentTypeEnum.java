package com.yundian.fssapi.enums;

/**
 * 贷款审核状态枚举
 * 
 * @author hehaibo
 *
 */
public enum FssLoanDocumentTypeEnum {

	LOAN_CONTRACT("loanContractPic","贷款合同"),

	WITHHOLDING_AGREEMENT("withholdingAgreementPic","委托代扣协议"),

	COMMERCIAL_INSURANCE("commercialInsurancePic","商业险保单"),

	COMPULSORY_INSURANCE("compulsoryInsurancePic","交强险保单"),

	IDCARD_BACK("idcardBackPic","身份证反面"),

	IDCARD_FRONT("idcardFrontPic","身份证正面"),


	;

	private String code;
	private String desc;
	private FssLoanDocumentTypeEnum(String code, String desc){
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
