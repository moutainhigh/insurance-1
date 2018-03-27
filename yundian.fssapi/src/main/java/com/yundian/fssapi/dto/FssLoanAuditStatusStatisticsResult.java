package com.yundian.fssapi.dto;

import java.io.Serializable;
import java.util.List;

/**
 * 审核状态统计结果
 * @author hehaibo
 *
 */
public class FssLoanAuditStatusStatisticsResult implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 完成签约个数
	 */
	private Integer finishSignCount;
	/**
	 * 在途签约个数
	 */
	private Integer onTheWayCount;
	
	private List<FssLoanAuditStatusStatistics> auditStatusStatisticsList;
	
	
	public Integer getFinishSignCount() {
		return finishSignCount;
	}
	public void setFinishSignCount(Integer finishSignCount) {
		this.finishSignCount = finishSignCount;
	}
	public Integer getOnTheWayCount() {
		return onTheWayCount;
	}
	public void setOnTheWayCount(Integer onTheWayCount) {
		this.onTheWayCount = onTheWayCount;
	}

	public List<FssLoanAuditStatusStatistics> getAuditStatusStatisticsList() {
		return auditStatusStatisticsList;
	}
	public void setAuditStatusStatisticsList(
			List<FssLoanAuditStatusStatistics> auditStatusStatisticsList) {
		this.auditStatusStatisticsList = auditStatusStatisticsList;
	}

}
