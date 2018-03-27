package com.yundian.fss.manager;

import java.util.List;
import java.util.Map;

import com.yundian.fssapi.domain.FssLoanAuditingLogModel;
import com.yundian.fssapi.domain.FssLoanModel;
import com.yundian.fssapi.domain.FssOrganizationUserModel;
import com.yundian.fssapi.domain.FssUserModel;
import com.yundian.fssapi.domain.query.FssLoanQueryModel;
import com.yundian.fssapi.domain.statistics.LoanCompareStatModel;
import com.yundian.fssapi.domain.statistics.LoanTypeMonthTrendStatModel;
import com.yundian.fssapi.domain.statistics.LoanTypeStatItemModel;
import com.yundian.fssapi.dto.FssLoanAuditStatusStatisticsResult;
import com.yundian.fssapi.dto.param.FssLoanQueryParam;
import com.yundian.result.PaginatedResult;
import com.yundian.result.Paginator;

/**
 * 贷款服务
 * 
 * @author hehaibo
 * @version $Id: FssLoanService.java, v 0.1 2016年7月26日 下午8:59:44 hehaibo Exp $
 */
public interface FssLoanManager {
	/**
	 * 插入一笔贷款信息，返回新增后的ID
	 * 
	 * @param fssLoanModel
	 * @return
	 */
	Long insertFssLoan(FssLoanModel fssLoanModel);

	Integer updateFssLoan(FssLoanModel fssLoanModel);

	Integer deleteFssLoanByLoanId(Long loanId);

	FssLoanModel getFssLoanById(Long id);

	List<FssLoanModel> getFssLoanList(FssLoanModel fssLoanModel);

	PaginatedResult<FssLoanQueryModel> getPaginatorFssLoan(
			Paginator<FssLoanQueryParam> paginator);

	FssLoanModel getFssLoanByLoanCode(String loanCode);

	FssLoanAuditStatusStatisticsResult getFssLoanStatisticsCountByAuditStatus(
			FssLoanQueryParam fssLoanQueryParam);
	
	Integer submitLoanApprove(FssUserModel fssUserModel,
			FssLoanAuditingLogModel fssLoanAuditingLogModel);
	
	Integer approvePass(FssOrganizationUserModel organizationUser,
			FssLoanAuditingLogModel fssLoanAuditingLogModel);
	
	Integer approveReject(FssOrganizationUserModel organizationUser,
			FssLoanAuditingLogModel fssLoanAuditingLogModel);

	List<LoanTypeStatItemModel> loanTypeStat(Long guaranteeId,Long bankId,String startDate, String endDate);

	LoanCompareStatModel loanCompareStat(Long guaranteeId,Long bankId,String startDate);

	LoanTypeMonthTrendStatModel loanTypeCompareStat(Long guaranteeId,Long bankId,String startDate,
			String endDate);
	
	Map<String,Integer> loanStatusStat(Long guaranteeId,Long bankId);
	
}
