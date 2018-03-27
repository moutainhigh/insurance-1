package com.yundian.fss.manager;

import java.util.List;

import com.yundian.fssapi.domain.FssLoanRelationRecognitionModel;
import com.yundian.result.PaginatedResult;
import com.yundian.result.Paginator;

/**
 * 人脸识别结果服务
 * 
 * @author hehaibo
 * @version $Id: FssLoanRelationRecognitionService.java, v 0.1 2016年7月26日
 *          下午8:59:44 hehaibo Exp $
 */
public interface FssLoanRelationRecognitionManager {
	Integer insertFssLoanRelationRecognition(
			FssLoanRelationRecognitionModel fssLoanRelationRecognitionModel);

	Integer updateFssLoanRelationRecognition(
			FssLoanRelationRecognitionModel fssLoanRelationRecognitionModel);

	Integer deleteFssLoanRelationRecognitionById(Long id);

	FssLoanRelationRecognitionModel getFssLoanRelationRecognitionById(
			Long id);
	FssLoanRelationRecognitionModel getFssLoanRelationRecognitionByRelationId(
			Long relationId);
	List<FssLoanRelationRecognitionModel> getFssLoanRelationRecognitionList(
			FssLoanRelationRecognitionModel fssLoanRelationRecognitionModel);

	PaginatedResult<FssLoanRelationRecognitionModel> getPaginatorFssLoanRelationRecognition(
			Paginator<FssLoanRelationRecognitionModel> paginator);
}
