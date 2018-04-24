package com.yundian.fss.dao;

import com.yundian.fssapi.domain.FssLoanDocumentModel;

import java.util.List;

public interface FssLoanDocumentModelMapper {
    int deleteByPrimaryKey(Long id);

    int deleteByDocmentType(Long loanId,String  documentType);

    int insert(FssLoanDocumentModel record);

    int insertSelective(FssLoanDocumentModel record);

    FssLoanDocumentModel selectByPrimaryKey(Long id);

    List<FssLoanDocumentModel> selectByLoanId(Long loanId);

    int updateByPrimaryKeySelective(FssLoanDocumentModel record);

    int updateByPrimaryKey(FssLoanDocumentModel record);
}