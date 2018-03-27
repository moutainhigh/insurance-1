package com.yundian.fss.dao;

import java.util.List;

import com.yundian.fssapi.domain.FssLoanDistributeModel;
import com.yundian.fssapi.domain.query.FssLoanDistributeQueryModel;

public interface FssLoanDistributeModelMapper {
    int deleteByPrimaryKey(Long id);

    int insert(FssLoanDistributeModel record);

    FssLoanDistributeModel selectByPrimaryKey(Long id);

    int updateByPrimaryKey(FssLoanDistributeModel record);

	List<FssLoanDistributeQueryModel> getFssLoanDistributeListByLoanId(Long loanId);
}