package com.yundian.fssapi.service.dto;

import java.io.Serializable;
import java.util.List;

import com.yundian.fssapi.domain.FssLoanDocumentModel;

/**
 * 面签项目保存对象
 * @author ningixa.jin
 *
 */
public class LoanAdd implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6182991368990002943L;

	/**
	 * 担保机构id
	 */
	private long guaranteeId;
	/**
	 * 担保机构名称
	 */
	private String guaranteeName;
	/**
	 * 担保机构面签员id
	 */
	private long guaranteeUserId;
	/**
	 * 担保机构面签员姓名
	 */
	private String guaranteeUserName;
	/**
	 * 贷款类型
	 */
	private String loanType;
	
	/**
	 * 关系人的身份信息、身份证、授权书、人脸识别
	 */
	List<LoanAddRelationAndDoc> relations;

	/**
	 * 面签照片、面签视频
	 */
	List<FssLoanDocumentModel> signPic;
	
	public long getGuaranteeId() {
		return guaranteeId;
	}


	public void setGuaranteeId(long guaranteeId) {
		this.guaranteeId = guaranteeId;
	}


	public String getGuaranteeName() {
		return guaranteeName;
	}


	public void setGuaranteeName(String guaranteeName) {
		this.guaranteeName = guaranteeName;
	}


	public long getGuaranteeUserId() {
		return guaranteeUserId;
	}


	public void setGuaranteeUserId(long guaranteeUserId) {
		this.guaranteeUserId = guaranteeUserId;
	}


	public String getGuaranteeUserName() {
		return guaranteeUserName;
	}


	public void setGuaranteeUserName(String guaranteeUserName) {
		this.guaranteeUserName = guaranteeUserName;
	}


	public String getLoanType() {
		return loanType;
	}


	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}


	public List<LoanAddRelationAndDoc> getRelations() {
		return relations;
	}


	public void setRelations(List<LoanAddRelationAndDoc> relations) {
		this.relations = relations;
	}


	
	
}
