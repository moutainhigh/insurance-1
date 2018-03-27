package com.yundian.fssapi.enums;

/**
 * 贷款审核状态枚举
 * 
 * @author hehaibo
 *
 */
public enum FssLoanLoanTypeEnum {
	/**
	 * PURCHASE_CAR_TERM  购车分期
	 */
	PURCHASE_CAR_TERM("PURCHASE_CAR_TERM","新车分期"),
	PURCHASE_2CAR_TERM("PURCHASE_2CAR_TERM","二手车分期"),
	PURCHASE_MORTGAGECAR_TERM("PURCHASE_MORTGAGECAR_TERM","抵押贷款"),
	OTHER("other","其他"),
	;
	
	private String code;
	private String desc;
	private FssLoanLoanTypeEnum(String code,String desc){
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
	
	public static String getDesc(String code){
		for(FssLoanLoanTypeEnum type:FssLoanLoanTypeEnum.values()){
			if(type.code.equals(code)){
				return type.desc;
			}
		}
		return FssLoanLoanTypeEnum.OTHER.desc;
	}
}
