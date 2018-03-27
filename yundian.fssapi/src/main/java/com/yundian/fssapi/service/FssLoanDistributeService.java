package com.yundian.fssapi.service;

import java.util.List;

import com.yundian.fssapi.domain.FssLoanDistributeModel;
import com.yundian.fssapi.domain.query.FssLoanDistributeQueryModel;
import com.yundian.result.PaginatedResult;
import com.yundian.result.Paginator;
import com.yundian.result.Result;

/**
 * 贷款分配服务
 * 
 * @author hehaibo
 * @version $Id: FssLoanDistributeService.java, v 0.1 2016年7月26日 下午8:59:44
 *          hehaibo Exp $
 */
public interface FssLoanDistributeService {
	Result<Integer> insertFssLoanDistribute(
			FssLoanDistributeModel fssLoanDistributeModel);

	Result<Integer> updateFssLoanDistribute(
			FssLoanDistributeModel fssLoanDistributeModel);

	Result<Integer> deleteFssLoanDistributeById(Long id);

	Result<FssLoanDistributeModel> getFssLoanDistributeById(Long id);

	Result<List<FssLoanDistributeQueryModel>> getFssLoanDistributeListByLoanId(Long loanId);

	Result<PaginatedResult<FssLoanDistributeModel>> getPaginatorFssLoanDistribute(
			Paginator<FssLoanDistributeModel> paginator);
}
