package com.yundian.fssapi.service;

import java.util.List;

import com.yundian.fssapi.domain.FssLoanRelationModel;
import com.yundian.result.Result;

/**
 * 贷款关系人服务
 * 
 * @author hehaibo
 * @version $Id: FssLoanRelationService.java, v 0.1 2016年7月26日 下午8:59:44
 *          hehaibo Exp $
 */
public interface FssLoanRelationService {
	Result<Integer> insertFssLoanRelation(
			FssLoanRelationModel fssLoanRelationModel);

	Result<Integer> updateFssLoanRelation(
			FssLoanRelationModel fssLoanRelationModel);

	Result<Integer> deleteFssLoanRelationByRelationId(Long relationId);

	Result<FssLoanRelationModel> getFssLoanRelationById(Long id);

	/**
	 * 通过贷款ID查询联系人信息
	 * @param loanId
	 * @return
	 */
	Result<List<FssLoanRelationModel>> getFssLoanRelationListByLoanId(Long loanId);
	
	/**
	 * 通过贷款ID查询联系人以及联系人下面的照片信息
	 * @param loanId
	 * @return
	 */
	Result<List<FssLoanRelationModel>> getFssLoanRelationAndDocumentListByLoanId(Long loanId);

	Result<List<FssLoanRelationModel>> getFssLoanRelationAndRecognitionByLoanId(
			Long loanId);
	
}
