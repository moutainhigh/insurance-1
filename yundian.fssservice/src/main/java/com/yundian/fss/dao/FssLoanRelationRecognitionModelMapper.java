package com.yundian.fss.dao;

import com.yundian.fssapi.domain.FssLoanRelationRecognitionModel;

public interface FssLoanRelationRecognitionModelMapper {
    int deleteByPrimaryKey(Long id);

    int insert(FssLoanRelationRecognitionModel record);

    FssLoanRelationRecognitionModel selectByPrimaryKey(Long id);

    FssLoanRelationRecognitionModel getFssLoanRelationRecognitionByRelationId(Long relationId);
    int updateByPrimaryKey(FssLoanRelationRecognitionModel record);
}