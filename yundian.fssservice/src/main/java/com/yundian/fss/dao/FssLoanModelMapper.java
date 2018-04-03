package com.yundian.fss.dao;

import com.yundian.fssapi.domain.FssLoanModel;

public interface FssLoanModelMapper {
    int deleteByPrimaryKey(Long loanId);

    int insert(FssLoanModel record);

    int insertSelective(FssLoanModel record);

    FssLoanModel selectByPrimaryKey(Long loanId);

    int updateByPrimaryKeySelective(FssLoanModel record);

    int updateByPrimaryKey(FssLoanModel record);
}