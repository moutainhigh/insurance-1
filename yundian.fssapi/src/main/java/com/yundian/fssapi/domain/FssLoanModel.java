package com.yundian.fssapi.domain;

import com.yundian.fssapi.enums.FssLoanAuditStatusEnum;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 贷款信息
 * 
 * @author hehaibo
 *
 */
public class FssLoanModel implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
     * 
     */
    private Long loanId;

    /**
     * 银行id
     */
    private Long bankId;

    /**
     * 担保公司id
     */
    private Long guaranteeId;

    /**
     * 担保机构名称
     */
    private String guaranteeName;

    /**
     * 担保机构业务员id
     */
    private Long guaranteeUserId;

    /**
     * 担保机构业务员姓名
     */
    private String guaranteeUserName;
    
    //审批机构
    /**
     * 审核机构id
     */
    private Long organizationId;
	/**
     * 审批机构用户ID
     */
    private Long orguserId;
    /**
     * 审核机构用户姓名
     */
    private String orguserName; 
    
    /**
     * 贷款编号
     */
    private String loanCode;

    /**
     * 贷款类型:1购车分期
     */
    private String loanType;

    /**
     * 借款人
     */
    private String name;

    /**
     * 借款人身份证
     */
    private String idcard;

    /**
     * 借款人手机号码
     */
    private String phone;

    /**
     * 性别
     */
    private String sex;

    /**
     * 共同还款人数
     */
    private Integer commonRepaymentCount;

    /**
     * 担保人数
     */
    private Integer guaranteeCount;

    /**
     * 签约时间
     */
    private Date signTime;

    /**
     * 审核状态:0未提交，1待审核，2通过，3不通过，4退回
     */
    private String auditStatus= FssLoanAuditStatusEnum.UNSUBMIT.code();
    
    /**
     * 办理状态 已办，未办
     */
    private String dealwithStatus;

    /**
     * 审核时间
     */
    private Date auditTime;
    
    /**
     * 贷款是否完成
     */
    private String isFinish;
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
     * 贷款关系人
     */
    private List<FssLoanRelationModel> loanRelationList;
    /**
     * 贷款相关的所有文档资料
     */
    private List<FssLoanDocumentModel> loanAllDocumentList;

    /**
     * 获取
     *
     *
     * @cgw 2016-07-26 11:23:26
     */
    public Long getLoanId() {
        return loanId;
    }

    /**
     * 设置
     *
     * @param loanId the value for fss_loan.loan_id
     *
     * @cgw 2016-07-26 11:23:26
     */
    public void setLoanId(Long loanId) {
        this.loanId = loanId;
    }

    /**
     * 获取银行id
     *
     * @cgw 2016-07-26 11:23:26
     */
    public Long getBankId() {
        return bankId;
    }

    /**
     * 设置银行id
     *
     * @param bankId the value for fss_loan.bank_id
     *
     * @cgw 2016-07-26 11:23:26
     */
    public void setBankId(Long bankId) {
        this.bankId = bankId;
    }

    /**
     * 获取担保公司id
     *
     * @cgw 2016-07-26 11:23:26
     */
    public Long getGuaranteeId() {
        return guaranteeId;
    }

    /**
     * 设置担保公司id
     *
     * @param guaranteeId the value for fss_loan.guarantee_id
     *
     * @cgw 2016-07-26 11:23:26
     */
    public void setGuaranteeId(Long guaranteeId) {
        this.guaranteeId = guaranteeId;
    }

    /**
     * 获取担保机构名称
     *
     * @cgw 2016-07-26 11:23:26
     */
    public String getGuaranteeName() {
        return guaranteeName;
    }

    /**
     * 设置担保机构名称
     *
     * @param guaranteeName the value for fss_loan.guarantee_name
     *
     * @cgw 2016-07-26 11:23:26
     */
    public void setGuaranteeName(String guaranteeName) {
        this.guaranteeName = guaranteeName == null ? null : guaranteeName.trim();
    }

    /**
     * 获取担保机构业务员id
     *
     * @cgw 2016-07-26 11:23:26
     */
    public Long getGuaranteeUserId() {
        return guaranteeUserId;
    }

    /**
     * 设置担保机构业务员id
     *
     * @param guaranteeUserId the value for fss_loan.guarantee_user_id
     *
     * @cgw 2016-07-26 11:23:26
     */
    public void setGuaranteeUserId(Long guaranteeUserId) {
        this.guaranteeUserId = guaranteeUserId;
    }

    /**
     * 获取担保机构业务员姓名
     *
     * @cgw 2016-07-26 11:23:26
     */
    public String getGuaranteeUserName() {
        return guaranteeUserName;
    }

    /**
     * 设置担保机构业务员姓名
     *
     * @param guaranteeUserName the value for fss_loan.guarantee_user_name
     *
     * @cgw 2016-07-26 11:23:26
     */
    public void setGuaranteeUserName(String guaranteeUserName) {
        this.guaranteeUserName = guaranteeUserName == null ? null : guaranteeUserName.trim();
    }
    

    public Long getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Long organizationId) {
		this.organizationId = organizationId;
	}

	public Long getOrguserId() {
		return orguserId;
	}

	public void setOrguserId(Long orguserId) {
		this.orguserId = orguserId;
	}

	public String getOrguserName() {
		return orguserName;
	}

	public void setOrguserName(String orguserName) {
		this.orguserName = orguserName;
	}

	/**
     * 获取贷款编号
     *
     * @cgw 2016-07-26 11:23:26
     */
    public String getLoanCode() {
        return loanCode;
    }

    /**
     * 设置贷款编号
     *
     * @param loanCode the value for fss_loan.loan_code
     *
     * @cgw 2016-07-26 11:23:26
     */
    public void setLoanCode(String loanCode) {
        this.loanCode = loanCode == null ? null : loanCode.trim();
    }

    /**
     * 获取贷款类型:1购车分期
     *
     * @cgw 2016-07-26 11:23:26
     */
    public String getLoanType() {
        return loanType;
    }

    /**
     * 设置贷款类型:1购车分期
     *
     * @param loanType the value for fss_loan.loan_type
     *
     * @cgw 2016-07-26 11:23:26
     */
    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    /**
     * 获取借款人
     *
     * @cgw 2016-07-26 11:23:26
     */
    public String getName() {
        return name;
    }

    /**
     * 设置借款人
     *
     * @param name the value for fss_loan.name
     *
     * @cgw 2016-07-26 11:23:26
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取借款人身份证
     *
     * @cgw 2016-07-26 11:23:26
     */
    public String getIdcard() {
        return idcard;
    }

    /**
     * 设置借款人身份证
     *
     * @param idcard the value for fss_loan.idcard
     *
     * @cgw 2016-07-26 11:23:26
     */
    public void setIdcard(String idcard) {
        this.idcard = idcard == null ? null : idcard.trim();
    }

    /**
     * 获取借款人手机号码
     *
     * @cgw 2016-07-26 11:23:26
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置借款人手机号码
     *
     * @param phone the value for fss_loan.phone
     *
     * @cgw 2016-07-26 11:23:26
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * 获取性别
     *
     * @cgw 2016-07-26 11:23:26
     */
    public String getSex() {
        return sex;
    }

    /**
     * 设置性别
     *
     * @param sex the value for fss_loan.sex
     *
     * @cgw 2016-07-26 11:23:26
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * 获取共同还款人数
     *
     * @cgw 2016-07-26 11:23:26
     */
    public Integer getCommonRepaymentCount() {
        return commonRepaymentCount;
    }

    /**
     * 设置共同还款人数
     *
     * @param commonRepaymentCount the value for fss_loan.common_repayment_count
     *
     * @cgw 2016-07-26 11:23:26
     */
    public void setCommonRepaymentCount(Integer commonRepaymentCount) {
        this.commonRepaymentCount = commonRepaymentCount;
    }

    /**
     * 获取担保人数
     *
     * @cgw 2016-07-26 11:23:26
     */
    public Integer getGuaranteeCount() {
        return guaranteeCount;
    }

    /**
     * 设置担保人数
     *
     * @param guaranteeCount the value for fss_loan.guarantee_count
     *
     * @cgw 2016-07-26 11:23:26
     */
    public void setGuaranteeCount(Integer guaranteeCount) {
        this.guaranteeCount = guaranteeCount;
    }

    /**
     * 获取签约时间
     *
     * @cgw 2016-07-26 11:23:26
     */
    public Date getSignTime() {
        return signTime;
    }

    /**
     * 设置签约时间
     *
     * @param signTime the value for fss_loan.sign_time
     *
     * @cgw 2016-07-26 11:23:26
     */
    public void setSignTime(Date signTime) {
        this.signTime = signTime;
    }

    
    public String getDealwithStatus() {
		return dealwithStatus;
	}

	public void setDealwithStatus(String dealwithStatus) {
		this.dealwithStatus = dealwithStatus;
	}

	/**
     * 获取审核状态:0未提交，1待审核，2通过，3不通过，4退回
     *
     * @cgw 2016-07-26 11:23:26
     */
    public String getAuditStatus() {
        return auditStatus;
    }

    /**
     * 设置审核状态:0未提交，1待审核，2通过，3不通过，4退回
     *
     * @param auditStatus the value for fss_loan.audit_status
     *
     * @cgw 2016-07-26 11:23:26
     */
    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus;
    }
    

    public String getIsFinish() {
		return isFinish;
	}

	public void setIsFinish(String isFinish) {
		this.isFinish = isFinish;
	}

	/**
     * 获取审核时间
     *
     * @cgw 2016-07-26 11:23:26
     */
    public Date getAuditTime() {
        return auditTime;
    }

    /**
     * 设置审核时间
     *
     * @param auditTime the value for fss_loan.audit_time
     *
     * @cgw 2016-07-26 11:23:26
     */
    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    /**
     * 获取
     *
     * @cgw 2016-07-26 11:23:26
     */
    public Date getCtime() {
        return ctime;
    }

    /**
     * 设置
     *
     * @param ctime the value for fss_loan.ctime
     *
     * @cgw 2016-07-26 11:23:26
     */
    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    /**
     * 获取
     *
     * @cgw 2016-07-26 11:23:26
     */
    public Date getMtime() {
        return mtime;
    }

    /**
     * 设置
     *
     * @param mtime the value for fss_loan.mtime
     *
     * @cgw 2016-07-26 11:23:26
     */
    public void setMtime(Date mtime) {
        this.mtime = mtime;
    }

    /**
     * 获取
     *
     * @cgw 2016-07-26 11:23:26
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置
     *
     * @param remark the value for fss_loan.remark
     *
     * @cgw 2016-07-26 11:23:26
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

	public List<FssLoanRelationModel> getLoanRelationList() {
		return loanRelationList;
	}

	public void setLoanRelationList(List<FssLoanRelationModel> loanRelationList) {
		this.loanRelationList = loanRelationList;
	}

	public List<FssLoanDocumentModel> getLoanAllDocumentList() {
		return loanAllDocumentList;
	}

	public void setLoanAllDocumentList(List<FssLoanDocumentModel> loanDocumentList) {
		this.loanAllDocumentList = loanDocumentList;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FssLoanModel [loanId=" + loanId + ", bankId=" + bankId
				+ ", guaranteeId=" + guaranteeId + ", guaranteeName="
				+ guaranteeName + ", guaranteeUserId=" + guaranteeUserId
				+ ", guaranteeUserName=" + guaranteeUserName
				+ ", organizationId=" + organizationId + ", orguserId="
				+ orguserId + ", orguserName=" + orguserName + ", loanCode="
				+ loanCode + ", loanType=" + loanType + ", name=" + name
				+ ", idcard=" + idcard + ", phone=" + phone + ", sex=" + sex
				+ ", commonRepaymentCount=" + commonRepaymentCount
				+ ", guaranteeCount=" + guaranteeCount + ", signTime="
				+ signTime + ", auditStatus=" + auditStatus
				+ ", dealwithStatus=" + dealwithStatus + ", auditTime="
				+ auditTime + ", isFinish=" + isFinish + ", ctime=" + ctime
				+ ", mtime=" + mtime + ", remark=" + remark
				+ ", loanRelationList=" + loanRelationList
				+ ", loanAllDocumentList=" + loanAllDocumentList + "]";
	}
    
    
}