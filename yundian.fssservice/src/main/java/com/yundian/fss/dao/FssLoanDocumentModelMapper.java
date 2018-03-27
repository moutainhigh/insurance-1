package com.yundian.fss.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yundian.fssapi.domain.FssLoanDocumentModel;

public interface FssLoanDocumentModelMapper {
    int deleteByPrimaryKey(Long id);

    int insert(FssLoanDocumentModel record);

    FssLoanDocumentModel selectByPrimaryKey(Long id);

    int updateByPrimaryKey(FssLoanDocumentModel record);

	int batchInsert(@Param("loanDocumentList") List<FssLoanDocumentModel> loanDocumentList);

	List<FssLoanDocumentModel> getFssLoanDocumentListByLoanId(Long loanId);

	List<FssLoanDocumentModel> getFssLoanDocumentListByLoanIdAndDocumentType(@Param("loanId")
			Long loanId,@Param("documentType") String documentType);
}