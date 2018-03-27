package com.yundian.fss.dao;

import java.util.List;

import com.yundian.fssapi.domain.FssLoanRelationModel;

public interface FssLoanRelationModelMapper {
    int deleteByPrimaryKey(Long relationId);

    int insert(FssLoanRelationModel record);

    FssLoanRelationModel selectByPrimaryKey(Long relationId);

    int updateByPrimaryKey(FssLoanRelationModel record);

    /**
     * 通过贷款ID 查询贷款关联人
     * @param loanId
     * @return
     */
	List<FssLoanRelationModel> getFssLoanRelationListByLoanId(Long loanId);
}