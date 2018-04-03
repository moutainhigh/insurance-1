package com.yundian.fss.dao;

import com.yundian.fssapi.domain.FssLoanDocumentModel;

public interface FssLoanDocumentModelMapper {
    int deleteByPrimaryKey(Long id);

    int insert(FssLoanDocumentModel record);

    int insertSelective(FssLoanDocumentModel record);

    FssLoanDocumentModel selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FssLoanDocumentModel record);

    int updateByPrimaryKey(FssLoanDocumentModel record);
}