package com.yundian.fssapi.user.dto;

import java.util.List;

import com.yundian.fssapi.domain.FssLoanDocumentModel;
import com.yundian.fssapi.domain.FssLoanModel;
import com.yundian.fssapi.domain.FssLoanRelationModel;

/**
 * 签约项目明细对象
 * @author ningxia.jin
 *
 */
public class LoanDetailDTO {
	 
	/**
	 * 签约项目
	 */
	private FssLoanModel loan;
	
	/**
	 * 关系人信息
	 */
	private List<FssLoanRelationModel> relation;
	
	/**
	 * 项目照片，文档信息
	 */
	private List<FssLoanDocumentModel> document;

	
	public FssLoanModel getLoan() {
		return loan;
	}

	public void setLoan(FssLoanModel loan) {
		this.loan = loan;
	}

	public List<FssLoanRelationModel> getRelation() {
		return relation;
	}

	public void setRelation(List<FssLoanRelationModel> relation) {
		this.relation = relation;
	}

	public List<FssLoanDocumentModel> getDocument() {
		return document;
	}

	public void setDocument(List<FssLoanDocumentModel> document) {
		this.document = document;
	} 
	
	
	
}

