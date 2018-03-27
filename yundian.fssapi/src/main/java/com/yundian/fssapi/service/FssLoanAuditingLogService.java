package com.yundian.fssapi.service;

import java.util.List;

import com.yundian.fssapi.domain.FssLoanAuditingLogModel;
import com.yundian.fssapi.domain.query.FssLoanAuditingLogQueryModel;
import com.yundian.fssapi.dto.MyTaskQueryCriterion;
import com.yundian.result.PaginatedResult;
import com.yundian.result.Paginator;
import com.yundian.result.Result;

/**
 * 贷款审核服务
 * 
 * @author hehaibo
 * @version $Id: FssLoanAuditingLogService.java, v 0.1 2016年7月26日 下午8:59:44
 *          hehaibo Exp $
 */
public interface FssLoanAuditingLogService {
	Result<Integer> insertFssLoanAuditingLog(
			FssLoanAuditingLogModel fssLoanAuditingLogModel);

	Result<Integer> updateFssLoanAuditingLog(
			FssLoanAuditingLogModel fssLoanAuditingLogModel);

	Result<Integer> deleteFssLoanAuditingLogByLogId(Long logId);

	Result<FssLoanAuditingLogModel> getFssLoanAuditingLogById(Long id);

	Result<List<FssLoanAuditingLogQueryModel>> getFssLoanAuditingLogListByLoanId(Long loanId);

	Result<List<FssLoanAuditingLogModel>> _getFssLoanAuditingLogListByLoanId(Long loanId);

	Result<PaginatedResult<FssLoanAuditingLogQueryModel>> getPaginatorFssLoanAuditingLog(
			Paginator<FssLoanAuditingLogModel> paginator);

	Result<PaginatedResult<FssLoanAuditingLogQueryModel>> queryPagingResult(MyTaskQueryCriterion queryCriterion);
}
