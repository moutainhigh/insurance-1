package com.yundian.fss.dao;

import com.yundian.fssapi.domain.FssLoanRepaymentModel;

public interface FssLoanRepaymentModelMapper {
    int deleteByPrimaryKey(Long id);

    int insert(FssLoanRepaymentModel record);

    int insertSelective(FssLoanRepaymentModel record);

    FssLoanRepaymentModel selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FssLoanRepaymentModel record);

    int updateByPrimaryKey(FssLoanRepaymentModel record);
}