package com.yundian.fss.manager;

import java.util.List;

import com.yundian.fssapi.domain.FssLoanRelationModel;

/**
 * 贷款关系人服务
 * 
 * @author hehaibo
 * @version $Id: FssLoanRelationService.java, v 0.1 2016年7月26日 下午8:59:44
 *          hehaibo Exp $
 */
public interface FssLoanRelationManager {
	Integer insertFssLoanRelation(
			FssLoanRelationModel fssLoanRelationModel);

	Integer updateFssLoanRelation(
			FssLoanRelationModel fssLoanRelationModel);

	Integer deleteFssLoanRelationByRelationId(Long relationId);

	FssLoanRelationModel getFssLoanRelationById(Long id);

	List<FssLoanRelationModel> getFssLoanRelationListByLoanId(Long loanId);

	List<FssLoanRelationModel> getFssLoanRelationAndDocumentListByLoanId(
			Long loanId);

	List<FssLoanRelationModel> getFssLoanRelationAndRecognitionByLoanId(Long loanId);
}
