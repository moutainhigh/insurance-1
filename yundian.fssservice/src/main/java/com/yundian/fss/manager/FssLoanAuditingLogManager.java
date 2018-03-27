package com.yundian.fss.manager;

import java.util.List;

import com.yundian.fssapi.domain.FssLoanAuditingLogModel;
import com.yundian.fssapi.domain.query.FssLoanAuditingLogQueryModel;
import com.yundian.fssapi.dto.MyTaskQueryCriterion;
import com.yundian.result.PaginatedResult;
import com.yundian.result.Paginator;

/**
 * 贷款审核服务
 * 
 * @author hehaibo
 * @version $Id: FssLoanAuditingLogService.java, v 0.1 2016年7月26日 下午8:59:44
 *          hehaibo Exp $
 */
public interface FssLoanAuditingLogManager {
	Integer insertFssLoanAuditingLog(
			FssLoanAuditingLogModel fssLoanAuditingLogModel);

	Integer updateFssLoanAuditingLog(
			FssLoanAuditingLogModel fssLoanAuditingLogModel);

	Integer deleteFssLoanAuditingLogByLogId(Long logId);

	FssLoanAuditingLogModel getFssLoanAuditingLogById(Long id);

	List<FssLoanAuditingLogQueryModel> getFssLoanAuditingLogListByLoanId(Long loanId);

	PaginatedResult<FssLoanAuditingLogQueryModel> getPaginatorFssLoanAuditingLog(
			Paginator<FssLoanAuditingLogModel> paginator);

	PaginatedResult<FssLoanAuditingLogQueryModel> queryPagingResult(MyTaskQueryCriterion queryCriterion);
}
