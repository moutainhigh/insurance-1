package com.yundian.fssapi.service.dto;

import java.io.Serializable;
import java.util.List;

import com.yundian.fssapi.domain.FssLoanDocumentModel;
import com.yundian.fssapi.domain.FssLoanRelationModel;

/**
 * 关系人与照片
 * @author ningixa.jin
 *
 */
public class LoanAddRelationAndDoc implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1254544736866347483L;
	/**
	 * 关系人信息
	 */
	FssLoanRelationModel relation;
	/**
	 * 关系人照片信息
	 */
	List<FssLoanDocumentModel> pics;
	public FssLoanRelationModel getRelation() {
		return relation;
	}
	public void setRelation(FssLoanRelationModel relation) {
		this.relation = relation;
	}
	public List<FssLoanDocumentModel> getPics() {
		return pics;
	}
	public void setPics(List<FssLoanDocumentModel> pics) {
		this.pics = pics;
	}
	
	
	
}
