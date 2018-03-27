package com.yundian.fssapi.service;

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
import com.yundian.result.Result;

/**
 * 贷款服务
 * 
 * @author hehaibo
 * @version $Id: FssLoanService.java, v 0.1 2016年7月26日 下午8:59:44 hehaibo Exp $
 */
public interface FssLoanService {
	/**
	 * 插入一笔贷款信息，返回新增后的ID
	 * 
	 * @param fssLoanModel
	 * @return
	 */
	Result<Long> insertFssLoan(FssLoanModel fssLoanModel);

	Result<Integer> updateFssLoan(FssLoanModel fssLoanModel);

	Result<Integer> deleteFssLoanByLoanId(Long loanId);

	Result<FssLoanModel> getFssLoanById(Long id);

	Result<FssLoanModel> getFssLoanByLoanCode(String loanCode);

	/**
	 * 根据条件查询列表
	 * 
	 * @param fssLoanModel
	 * @return
	 */
	Result<List<FssLoanModel>> getFssLoanList(FssLoanModel fssLoanModel);

	/**
	 * 分页查询贷款信息
	 * 
	 * @param paginator
	 * @return
	 */
	Result<PaginatedResult<FssLoanQueryModel>> getPaginatorFssLoan(
			Paginator<FssLoanQueryParam> paginator);

	/**
	 * 根据审核状态统计每个状态的结果
	 * 
	 * @param fssLoanQueryParam
	 * @return
	 */
	Result<FssLoanAuditStatusStatisticsResult> getFssLoanStatisticsCountByAuditStatus(
			FssLoanQueryParam fssLoanQueryParam);

	/**
	 * 提交审核
	 * 
	 * @param fssUserModel
	 * @param fssLoanAuditingLogModel
	 * @return
	 */
	Result<Integer> submitLoanApprove(FssUserModel fssUserModel,
			FssLoanAuditingLogModel fssLoanAuditingLogModel);
	
	/**
	 * 贷款审批通过
	 * @param organizationUser
	 * @param fssLoanAuditingLogModel
	 * @return
	 */
	Result<Integer> approvePass(FssOrganizationUserModel organizationUser,
			FssLoanAuditingLogModel fssLoanAuditingLogModel);

	/**
	 * 贷款审批拒绝
	 * @param organizationUser
	 * @param fssLoanAuditingLogModel
	 * @return
	 */
	Result<Integer> approveNotPass(FssOrganizationUserModel organizationUser,
			FssLoanAuditingLogModel fssLoanAuditingLogModel);

	/**
	 * 贷款类型统计结果
	 * @param guaranteeId 合作机构id
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	Result<List<LoanTypeStatItemModel>> loanTypeStat(Long guaranteeId,Long bankId,String startDate, String endDate);

	/**
	 * 2个月比对结果查询
	 * @param guaranteeId 合作机构id
	 * @param startDate
	 * @return
	 */
	Result<LoanCompareStatModel> loanCompareStat(Long guaranteeId,Long bankId,String startDate);

	/**
	 * 贷款类型按照类型和时间统计
	 * @param guaranteeId 合作机构id
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	Result<LoanTypeMonthTrendStatModel> loanTypeCompareStat(Long guaranteeId,Long bankId,String startDate,
			String endDate);

	/**
	 * 按贷款审核状态统计总数
	 * @param guaranteeId
	 * @param bankId
	 * @return
	 */
	Result<Map<String, Integer>> loanStatusStat(Long guaranteeId, Long bankId);
	
	

}
