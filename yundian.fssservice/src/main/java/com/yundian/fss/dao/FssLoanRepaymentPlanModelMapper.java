package com.yundian.fss.dao;

import com.yundian.fssapi.domain.FssLoanModel;
import com.yundian.fssapi.domain.FssLoanRepaymentPlanModel;

import java.util.List;
import java.util.Map;

public interface FssLoanRepaymentPlanModelMapper {
    int deleteByPrimaryKey(Long id);

    int insert(FssLoanRepaymentPlanModel record);

    int insertSelective(FssLoanRepaymentPlanModel record);

    FssLoanRepaymentPlanModel selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FssLoanRepaymentPlanModel record);

    int updateByPrimaryKey(FssLoanRepaymentPlanModel record);

    /**
     * 分页查询还款计划
     * @param param
     * @return
     */
    List<FssLoanRepaymentPlanModel> getFssLoanRepaymentPlaPaging(
            Map<String, Object> param);

    Integer getFssLoanPagingCount(Map<String, Object> param);

}