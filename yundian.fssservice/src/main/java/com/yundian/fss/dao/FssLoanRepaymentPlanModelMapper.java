package com.yundian.fss.dao;

import com.yundian.fssapi.domain.FssLoanRepaymentPlanModel;

public interface FssLoanRepaymentPlanModelMapper {
    int deleteByPrimaryKey(Long id);

    int insert(FssLoanRepaymentPlanModel record);

    int insertSelective(FssLoanRepaymentPlanModel record);

    FssLoanRepaymentPlanModel selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FssLoanRepaymentPlanModel record);

    int updateByPrimaryKey(FssLoanRepaymentPlanModel record);
}