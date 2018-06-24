package com.yundian.fssapi.enums;

/**
 * 还款代扣状态
 * 
 * @author
 *订单受理中P、订单已受理S、订单受理失败F、TRADE_SUCCESS付款成功、TRADE_FINISHED交易结束、TRADE_CLOSED交易关闭
 */
public enum FssRepaymentOrderStatusEnum {

	INIT("初始化"),
	FAILED("接口调用失败"),
	P("订单受理中"),
	S("订单已受理S"),
	F("订单受理失败"),
	TRADE_SUCCESS("付款成功"),
	TRADE_FINISHED("交易成功"),
	TRADE_CLOSED("交易关闭");

	private String description;

	FssRepaymentOrderStatusEnum(String desc)
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
