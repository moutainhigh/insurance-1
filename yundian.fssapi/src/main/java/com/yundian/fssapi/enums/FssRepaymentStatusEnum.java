package com.yundian.fssapi.enums;

/**
 * 还款状态
 * 
 * @author
 *
 */
public enum FssRepaymentStatusEnum {

	PENDINGREPAYMENT("待还款"),
	HASREPAYMENT("已还款"),
	OVERDUE("当前逾期"),
	PAUSE("账单暂停"),
	CLOSED("账单关闭"),
	SETTLE("账单结清");

	private String description;

	FssRepaymentStatusEnum(String desc)
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
