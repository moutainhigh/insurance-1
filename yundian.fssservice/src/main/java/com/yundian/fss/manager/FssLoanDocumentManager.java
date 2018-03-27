package com.yundian.fss.manager;

import java.util.List;

import com.yundian.fssapi.domain.FssLoanDocumentModel;
import com.yundian.result.PaginatedResult;
import com.yundian.result.Paginator;

/**
 * 贷款文档服务
 * 
 * @author hehaibo
 * @version $Id: FssLoanModelcumentService.java, v 0.1 2016年7月26日 下午8:59:44
 *          hehaibo Exp $
 */
public interface FssLoanDocumentManager {
	Integer insertFssLoanDocument(FssLoanDocumentModel fssLoanDocumentModel);

	Integer batchInsertFssLoanDocument(
			List<FssLoanDocumentModel> loanDocumentList);

	Integer updateFssLoanDocument(FssLoanDocumentModel fssLoanDocumentModel);

	Integer deleteFssLoanDocumentById(Long id);

	FssLoanDocumentModel getFssLoanDocumentById(Long id);

	List<FssLoanDocumentModel> getFssLoanDocumentListByLoanId(Long loanId);

	PaginatedResult<FssLoanDocumentModel> getPaginatorFssLoanDocument(
			Paginator<FssLoanDocumentModel> paginator);

	List<FssLoanDocumentModel> getFssLoanDocumentListByLoanIdAndDocumentType(
			Long loanId, String documentType);

}
