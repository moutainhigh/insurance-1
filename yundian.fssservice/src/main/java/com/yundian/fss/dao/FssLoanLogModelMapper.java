package com.yundian.fss.dao;

import com.yundian.fssapi.domain.FssLoanLogModel;

public interface FssLoanLogModelMapper {
    int deleteByPrimaryKey(Long logId);

    int insert(FssLoanLogModel record);

    int insertSelective(FssLoanLogModel record);

    FssLoanLogModel selectByPrimaryKey(Long logId);

    int updateByPrimaryKeySelective(FssLoanLogModel record);

    int updateByPrimaryKey(FssLoanLogModel record);
}