package com.yundian.fssapi.dto;

import java.io.Serializable;

public class FssLoanAuditStatusStatistics implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 统计状态
	 */
	private String auditStatus;
	/**
	 * 统计结果
	 */
	private Integer auditStatusCount;
	
	public String getAuditStatus() {
		return auditStatus;
	}
	public void setAuditStatus(String auditStatus) {
		this.auditStatus = auditStatus;
	}
	public Integer getAuditStatusCount() {
		return auditStatusCount;
	}
	public void setAuditStatusCount(Integer auditStatusCount) {
		this.auditStatusCount = auditStatusCount;
	}
}
