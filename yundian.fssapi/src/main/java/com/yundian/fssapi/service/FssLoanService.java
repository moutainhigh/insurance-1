package com.yundian.fssapi.service;

import com.yundian.fssapi.domain.FssDealerUserModel;
import com.yundian.fssapi.domain.FssLoanDocumentModel;
import com.yundian.fssapi.domain.FssLoanModel;
import com.yundian.fssapi.domain.FssPlanModel;
import com.yundian.fssapi.domain.statistics.LoanInfoModel;
import com.yundian.result.Page;
import com.yundian.result.PaginatedResult;
import com.yundian.result.Paginator;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *分期服务
 */
public interface FssLoanService {


	List<FssPlanModel> getFssPlanList();
	/**
     *获取保险分期详细信息
	 * @param loanId
     * @return
     */
	LoanInfoModel getFssLoan(Long loanId);

	/**
	 * 获取保险分期详细信息
	 * @param loanId
	 * @return
	 */
	FssLoanModel getFssLoanModel(Long loanId);

	/**
     * 新增保险分期
	 * @param fssLoanModel
     * @return
     */
	Long insertFssLoan(FssLoanModel fssLoanModel);

	void updateFssLoan(FssLoanModel fssLoanModel);


	/**
	 * 新增分期资料附件,会按照documentType删除原来有的文档
	 * @param fssLoanDocumentModels
	 * @return
	 */
	Integer insertFssLoanDocument(Long loanId,List<FssLoanDocumentModel> fssLoanDocumentModels);



	Integer updateFssLoanDocment(Long loanId,List<FssLoanDocumentModel> fssLoanDocumentModels);

	/**
	 * 分页查询分期列表
	 * @param paginator
	 * @return
	 */
	Page<FssLoanModel> getPaginatorFssLoan(
            Paginator<FssLoanModel> paginator);

	/**
	 *
	 * @param idCardNo 身份证号码
	 * @return
	 */
	List<FssLoanModel> getFssLoanListByIdCardNo(String  idCardNo);

	/**
	 * 分期资料保存
	 */
	Long saveLoan(LoanInfoModel loanInfoModel);

	/**
	 * 提交审核
	 */
	void submitLoan(LoanInfoModel loanInfoModel,String operater);

	/**
	 * 退回，资料补充
	 */
	void  returnLoan(Long loanId,String operater);

	/**
	 * 申请放款
	 */
	void applyLoan(Long loanId,List<FssLoanDocumentModel> fssLoanDocumentModelList,String operater);


	/**
	 * 审核通过（资料审核）
	 */
	void  auditPass(Long loanId,String operater);

	/**
	 * 审核拒绝
	 */
	void  auditReject(Long loanId,String reason,String operater);

	/**
	 * 放款
	 */
	void makeloan(Long loanId,String operater);
}
