package com.yundian.fss.dao;

import java.util.List;
import java.util.Map;

import com.yundian.fssapi.domain.FssLoanAuditingLogModel;
import com.yundian.fssapi.domain.query.FssLoanAuditingLogQueryModel;
import com.yundian.fssapi.dto.MyTaskQueryCriterion;

public interface FssLoanAuditingLogModelMapper {
    int deleteByPrimaryKey(Long logId);

    int insert(FssLoanAuditingLogModel record);

    FssLoanAuditingLogModel selectByPrimaryKey(Long logId);

    int updateByPrimaryKey(FssLoanAuditingLogModel record);

	List<FssLoanAuditingLogQueryModel> getFssLoanAuditingLogPaging(
			Map<String, Object> param);

	Integer getFssLoanAuditingLogPagingCount(Map<String, Object> param);

	List<FssLoanAuditingLogQueryModel> getFssLoanAuditingLogListByLoanId(Long loanId);

    List<FssLoanAuditingLogQueryModel> queryUnprocessedPagingResult(MyTaskQueryCriterion queryCriterion);

    Integer queryUnprocessedPagingResultCount(MyTaskQueryCriterion queryCriterion);

    List<FssLoanAuditingLogQueryModel> queryProcessedPagingResult(MyTaskQueryCriterion queryCriterion);

    Integer queryProcessedPagingResultCount(MyTaskQueryCriterion queryCriterion);
}