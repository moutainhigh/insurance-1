package com.yundian.fssapi.domain.statistics;

import com.yundian.fssapi.domain.FssLoanDocumentModel;
import com.yundian.fssapi.domain.FssLoanModel;

import java.io.Serializable;
import java.util.List;

public class LoanInfoModel implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long loanId;

	/**
	 * 保险分期对象
	 */
	private FssLoanModel fssLoanModel;
	/**
	 * 资料数据
	 */
	private List<FssLoanDocumentModel> fssLoanDocumentModels;

	public Long getLoanId() {
		return this.loanId;
	}

	public void setLoanId(Long loanId) {
		this.loanId = loanId;
	}

	public FssLoanModel getFssLoanModel() {
		return this.fssLoanModel;
	}

	public void setFssLoanModel(FssLoanModel fssLoanModel) {
		this.fssLoanModel = fssLoanModel;
	}

	public List<FssLoanDocumentModel> getFssLoanDocumentModels() {
		return this.fssLoanDocumentModels;
	}

	public void setFssLoanDocumentModels(List<FssLoanDocumentModel> fssLoanDocumentModels) {
		this.fssLoanDocumentModels = fssLoanDocumentModels;
	}
}
