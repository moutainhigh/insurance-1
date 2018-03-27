package com.yundian.fssapi.enums;

/**
 * 
 * @author hehaibo
 *
 */
public enum FssCreditStatusEnum {
	/**
	 * 已提交
	 */
	SUBMITED("SUBMITED","已提交"){
		 
	},
	/**
	 * 待审核
	 */
	WAIT_ADUIT("WAIT_ADUIT","待调查"){
		 
	},
	/**
	 * 通过
	 */
	ADUIT_PASS("CREDIT_PASS","征信通过"),
	/**
	 * 不通过
	 */
	AUDIT_NOT_PASS("CREDIT_NOT_PASS","征信不通过"){
       
	},
	/**
	 * 退回
	 */
	CREDIT_BACK("CREDIT_BACK","退回"){
        
	}
	
	;
	
	private String code;
	private String desc;
	private FssCreditStatusEnum(String code,String desc){
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
