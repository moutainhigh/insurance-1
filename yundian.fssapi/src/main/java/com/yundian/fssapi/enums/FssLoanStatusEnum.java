package com.yundian.fssapi.enums;

/**
 * 保险分期订单状态
 * 
 * @author
 * 审核状态:0待提交、1审核中、2申请放款、3待修改（保单信息审核退回、合同资料审核退回）、4审核通过，待放款、5已放款、6已关闭
 *
 */
public enum FssLoanStatusEnum {

	INIT("INIT","待提交"),

	AUDITING("AUDITING","审核中"),

	APPLY_LOAN("APPLY_LOAN","申请放款"),

	WAITING_REVISED("WAITING_REVISED","待资料修改"),

	WAITING_LOAN("WAITING_LOAN","审核通过待放款"),

	HAVE_LOAN("HAVE_LOAN","已放款"),

	CLOSED("CLOSED","订单已关闭");

	private String code;
	private String desc;
	private FssLoanStatusEnum(String code, String desc){
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
