package com.yundian.fssapi.service;

import java.util.List;

import com.yundian.fssapi.domain.FssLoanDocumentModel;
import com.yundian.result.PaginatedResult;
import com.yundian.result.Paginator;
import com.yundian.result.Result;

/**
 * 贷款文档服务
 * 
 * @author hehaibo
 * @version $Id: FssLoanModelcumentService.java, v 0.1 2016年7月26日 下午8:59:44
 *          hehaibo Exp $
 */
public interface FssLoanDocumentService {
	Result<Integer> insertFssLoanDocument(
			FssLoanDocumentModel fssLoanDocumentModel);

	Result<Integer> updateFssLoanDocument(
			FssLoanDocumentModel fssLoanDocumentModel);

	Result<Integer> deleteFssLoanDocumentById(Long id);

	Result<FssLoanDocumentModel> getFssLoanDocumentById(Long id);

	Result<List<FssLoanDocumentModel>> getFssLoanDocumentListByLoanId(
			Long loanId);

	Result<PaginatedResult<FssLoanDocumentModel>> getPaginatorFssLoanDocument(
			Paginator<FssLoanDocumentModel> paginator);

	Result<List<FssLoanDocumentModel>> getFssLoanDocumentListByLoanIdAndDocumentType(
			Long loanId, String documentType);

}
