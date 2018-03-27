package com.yundian.fssapi.service;

import java.util.List;

import com.yundian.fssapi.domain.FssLoanRelationRecognitionModel;
import com.yundian.result.PaginatedResult;
import com.yundian.result.Paginator;
import com.yundian.result.Result;

/**
 * 人脸识别结果服务
 * 
 * @author hehaibo
 * @version $Id: FssLoanRelationRecognitionService.java, v 0.1 2016年7月26日
 *          下午8:59:44 hehaibo Exp $
 */
public interface FssLoanRelationRecognitionService {
	Result<Integer> insertFssLoanRelationRecognition(
			FssLoanRelationRecognitionModel fssLoanRelationRecognitionModel);

	Result<Integer> updateFssLoanRelationRecognition(
			FssLoanRelationRecognitionModel fssLoanRelationRecognitionModel);

	Result<Integer> deleteFssLoanRelationRecognitionById(Long id);

	Result<FssLoanRelationRecognitionModel> getFssLoanRelationRecognitionById(
			Long id);

	Result<List<FssLoanRelationRecognitionModel>> getFssLoanRelationRecognitionList(
			FssLoanRelationRecognitionModel fssLoanRelationRecognitionModel);

	Result<PaginatedResult<FssLoanRelationRecognitionModel>> getPaginatorFssLoanRelationRecognition(
			Paginator<FssLoanRelationRecognitionModel> paginator);
}
