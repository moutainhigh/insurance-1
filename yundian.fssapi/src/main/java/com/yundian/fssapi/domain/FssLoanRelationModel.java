package com.yundian.fssapi.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
/**
 * 贷款关系人
 * @author cheguo
 *
 */
public class FssLoanRelationModel implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * 
     */
    private Long relationId;

    /**
     * 贷款id
     */
    private Long loanId;

    /**
     * 关系人姓名
     */
    private String relationName;

    /**
     * 关系人类型：主贷人，担保人，共同还款人
     */
    private String relationType;

    /**
     * 关系人类型名称
     */
    private String relationTypeName;

    /**
     * 证件类型
     */
    private String idType;

    /**
     * 证件号码
     */
    private String idcard;

    /**
     * 性别：1男，0女
     */
    private String sex;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 与主贷人关系：兄弟、配偶、父母等
     */
    private String relationWith;

    /**
     * 与主贷人关系名称
     */
    private String relationWithName;

    /**
     * 
     */
    private Date ctime;

    /**
     * 
     */
    private Date mtime;

    /**
     * 
     */
    private String remark;
    
    /**
     * 贷款人人脸识别结果
     */
    private FssLoanRelationRecognitionModel relationRecognition;
    /**
     * 该人对应的贷款文档资料
     */
    private List<FssLoanDocumentModel> loanDocumentList;
    /**
     * 获取
     *
     * @cgw 2016-07-22 15:18:23
     */
    public Long getRelationId() {
        return relationId;
    }

    /**
     * 设置
     *
     * @param relationId the value for fss_loan_relation.relation_id
     *
     * @cgw 2016-07-22 15:18:23
     */
    public void setRelationId(Long relationId) {
        this.relationId = relationId;
    }

    /**
     * 获取贷款id
     *
     * @cgw 2016-07-22 15:18:23
     */
    public Long getLoanId() {
        return loanId;
    }

    /**
     * 设置贷款id
     *
     * @param loanId the value for fss_loan_relation.loan_id
     *
     * @cgw 2016-07-22 15:18:23
     */
    public void setLoanId(Long loanId) {
        this.loanId = loanId;
    }

    /**
     * 获取关系人姓名
     *
     * @cgw 2016-07-22 15:18:23
     */
    public String getRelationName() {
        return relationName;
    }

    /**
     * 设置关系人姓名
     *
     * @param relationName the value for fss_loan_relation.relation_name
     *
     * @cgw 2016-07-22 15:18:23
     */
    public void setRelationName(String relationName) {
        this.relationName = relationName == null ? null : relationName.trim();
    }

    /**
     * 获取关系人类型：主贷人，担保人，共同还款人
     *
     * @cgw 2016-07-22 15:18:23
     */
    public String getRelationType() {
        return relationType;
    }

    /**
     * 设置关系人类型：主贷人，担保人，共同还款人
     *
     * @param relationType the value for fss_loan_relation.relation_type
     *
     * @cgw 2016-07-22 15:18:23
     */
    public void setRelationType(String relationType) {
        this.relationType = relationType;
    }

    /**
     * 获取关系人类型名称
     *
     * @cgw 2016-07-22 15:18:23
     */
    public String getRelationTypeName() {
        return relationTypeName;
    }

    /**
     * 设置关系人类型名称
     *
     * @param relationTypeName the value for fss_loan_relation.relation_type_name
     *
     * @cgw 2016-07-22 15:18:23
     */
    public void setRelationTypeName(String relationTypeName) {
        this.relationTypeName = relationTypeName == null ? null : relationTypeName.trim();
    }

    /**
     * 获取证件类型
     *
     * @cgw 2016-07-22 15:18:23
     */
    public String getIdType() {
        return idType;
    }

    /**
     * 设置证件类型
     *
     * @param idType the value for fss_loan_relation.id_type
     *
     * @cgw 2016-07-22 15:18:23
     */
    public void setIdType(String idType) {
        this.idType = idType;
    }

    /**
     * 获取证件号码
     *
     * @cgw 2016-07-22 15:18:23
     */
    public String getIdcard() {
        return idcard;
    }

    /**
     * 设置证件号码
     *
     * @param idcard the value for fss_loan_relation.idcard
     *
     * @cgw 2016-07-22 15:18:23
     */
    public void setIdcard(String idcard) {
        this.idcard = idcard == null ? null : idcard.trim();
    }

    /**
     * 获取性别：1男，0女
     *
     * @cgw 2016-07-22 15:18:23
     */
    public String getSex() {
        return sex;
    }

    /**
     * 设置性别：1男，0女
     *
     * @param sex the value for fss_loan_relation.sex
     *
     * @cgw 2016-07-22 15:18:23
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * 获取手机号码
     *
     * @cgw 2016-07-22 15:18:23
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置手机号码
     *
     * @param phone the value for fss_loan_relation.phone
     *
     * @cgw 2016-07-22 15:18:23
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * 获取与主贷人关系：兄弟、配偶、父母等
     *
     * @cgw 2016-07-22 15:18:23
     */
    public String getRelationWith() {
        return relationWith;
    }

    /**
     * 设置与主贷人关系：兄弟、配偶、父母等
     *
     * @param relationWith the value for fss_loan_relation.relation_with
     *
     * @cgw 2016-07-22 15:18:23
     */
    public void setRelationWith(String relationWith) {
        this.relationWith = relationWith;
    }

    /**
     * 获取与主贷人关系名称
     *
     * @cgw 2016-07-22 15:18:23
     */
    public String getRelationWithName() {
        return relationWithName;
    }

    /**
     * 设置与主贷人关系名称
     *
     * @param relationWithName the value for fss_loan_relation.relation_with_name
     *
     * @cgw 2016-07-22 15:18:23
     */
    public void setRelationWithName(String relationWithName) {
        this.relationWithName = relationWithName == null ? null : relationWithName.trim();
    }

    /**
     * 获取
     *
     * @cgw 2016-07-22 15:18:23
     */
    public Date getCtime() {
        return ctime;
    }

    /**
     * 设置
     *
     * @param ctime the value for fss_loan_relation.ctime
     *
     * @cgw 2016-07-22 15:18:23
     */
    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    /**
     * 获取
     *
     * @cgw 2016-07-22 15:18:23
     */
    public Date getMtime() {
        return mtime;
    }

    /**
     * 设置
     *
     * @param mtime the value for fss_loan_relation.mtime
     *
     * @cgw 2016-07-22 15:18:23
     */
    public void setMtime(Date mtime) {
        this.mtime = mtime;
    }

    /**
     * 获取
     *
     * @cgw 2016-07-22 15:18:23
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置
     *
     * @param remark the value for fss_loan_relation.remark
     *
     * @cgw 2016-07-22 15:18:23
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

 
	public FssLoanRelationRecognitionModel getRelationRecognition() {
		return relationRecognition;
	}

	public void setRelationRecognition(
			FssLoanRelationRecognitionModel relationRecognition) {
		this.relationRecognition = relationRecognition;
	}

	public List<FssLoanDocumentModel> getLoanDocumentList() {
		return loanDocumentList;
	}

	public void setLoanDocumentList(List<FssLoanDocumentModel> loanDocumentList) {
		this.loanDocumentList = loanDocumentList;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FssLoanRelationModel [relationId=" + relationId + ", loanId="
				+ loanId + ", relationName=" + relationName + ", relationType="
				+ relationType + ", relationTypeName=" + relationTypeName
				+ ", idType=" + idType + ", idcard=" + idcard + ", sex=" + sex
				+ ", phone=" + phone + ", relationWith=" + relationWith
				+ ", relationWithName=" + relationWithName + ", ctime=" + ctime
				+ ", mtime=" + mtime + ", remark=" + remark
				+ ", relationRecognition" + relationRecognition
				+ ", loanDocumentList=" + loanDocumentList + "]";
	}
    
	
    
}