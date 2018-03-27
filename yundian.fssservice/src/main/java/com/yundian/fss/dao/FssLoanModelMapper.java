package com.yundian.fss.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.yundian.fss.dao.vo.StatisticsGenericResult;
import com.yundian.fssapi.domain.FssLoanModel;
import com.yundian.fssapi.domain.query.FssLoanQueryModel;
import com.yundian.fssapi.domain.statistics.LoanTypeStatItemModel;
import com.yundian.fssapi.dto.FssLoanAuditStatusStatistics;
import com.yundian.fssapi.dto.param.FssLoanQueryParam;

public interface FssLoanModelMapper {
	int deleteByPrimaryKey(Long loanId);

	int insert(FssLoanModel record);

	FssLoanModel selectByPrimaryKey(Long loanId);

	int updateByPrimaryKey(FssLoanModel record);
	
	int updateLoanCode(FssLoanModel record);
	
	List<FssLoanQueryModel> getFssLoanPaging(Map<String, Object> param);

	Integer getFssLoanPagingCount(Map<String, Object> param);

	FssLoanModel getFssLoanByLoanCode(String loanId);

	List<FssLoanAuditStatusStatistics> getFssLoanStatisticsCountByAuditStatus(
			FssLoanQueryParam fssLoanQueryParam);

	List<StatisticsGenericResult> getFssLoanStatisticsByOrganization();

	List<StatisticsGenericResult> getFssLoanStatisticsOrgUserIdByOrganizationId(
			Long organizationId);

	List<LoanTypeStatItemModel> selectLoanTypeStat(@Param("guaranteeId") Long guaranteeId,@Param("bankId") Long bankId,@Param("startDate") String startDate,
			@Param("endDate") String endDate);
	
	List<Map<String, Object>> selectLoanCompareStat(@Param("guaranteeId") Long guaranteeId,@Param("bankId") Long bankId,@Param("startDate") String startDate,
			@Param("endDate") String endDate);
	
	List<Map<String, Object>> selectLoanTypeCompareStat(@Param("guaranteeId") Long guaranteeId,@Param("bankId") Long bankId,@Param("startDate") String startDate,
			@Param("endDate") String endDate);
	
	Map<String,Integer> selectLoanStatusStat(@Param("guaranteeId") Long guaranteeId,@Param("bankId") Long bankId);
	
	
}