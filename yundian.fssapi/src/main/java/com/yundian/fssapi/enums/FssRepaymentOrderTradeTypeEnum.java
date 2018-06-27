package com.yundian.fssapi.enums;

/**
 * 订单类型：witholding,refund
 * 
 * @author
 *
 */
public enum FssRepaymentOrderTradeTypeEnum {

	WITHOLDING("代扣订单"),
	REFUND("退款订单");

	private String description;

	FssRepaymentOrderTradeTypeEnum(String desc)
	{
		this.description = desc;
	}


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
