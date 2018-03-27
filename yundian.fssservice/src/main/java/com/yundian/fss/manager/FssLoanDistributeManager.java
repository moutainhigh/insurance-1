package com.yundian.fss.manager;

import java.util.List;

import com.yundian.fssapi.domain.FssLoanDistributeModel;
import com.yundian.fssapi.domain.query.FssLoanDistributeQueryModel;
import com.yundian.result.PaginatedResult;
import com.yundian.result.Paginator;

/**
 * 贷款分配服务
 * 
 * @author hehaibo
 * @version $Id: FssLoanDistributeService.java, v 0.1 2016年7月26日 下午8:59:44
 *          hehaibo Exp $
 */
public interface FssLoanDistributeManager {
	Integer insertFssLoanDistribute(
			FssLoanDistributeModel fssLoanDistributeModel);

	Integer updateFssLoanDistribute(
			FssLoanDistributeModel fssLoanDistributeModel);

	Integer deleteFssLoanDistributeById(Long id);

	FssLoanDistributeModel getFssLoanDistributeById(Long id);

	List<FssLoanDistributeQueryModel> getFssLoanDistributeListByLoanId(Long loanId);

	PaginatedResult<FssLoanDistributeModel> getPaginatorFssLoanDistribute(
			Paginator<FssLoanDistributeModel> paginator);
}
