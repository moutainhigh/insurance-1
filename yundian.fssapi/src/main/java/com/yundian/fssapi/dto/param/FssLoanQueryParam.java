package com.yundian.fssapi.dto.param;

import java.io.Serializable;
import java.util.Date;

/**
 * 贷款查询参数
 * 
 * @author hehaibo
 *
 */
public class FssLoanQueryParam implements Serializable{

	/**
	 * 
	 */
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
     * 签约开始时间
     */
    private String signTimeStart;
    
    /**
     * 签约结束时间
     */
    private String signTimeEnd;
    
    /**
     * 审核状态:0未提交，1待审核，2通过，3不通过，4退回
     */
    private String auditStatus;
    
    /**
     * 办理状态 已办，未办
     */
    private String dealwithStatus;
    
    /**
     * 任务是否完成
     */
    private String isFinish;

    /**
     * 审核时间
     */
    private Date auditTime;

    /**
     * 审核机构id
     */
    private Long organizationId;
	/**
     * 审批机构用户ID
     */
    private Long orguserId;
    
	public Long getLoanId() {
		return loanId;
	}

	public void setLoanId(Long loanId) {
		this.loanId = loanId;
	}

	public Long getBankId() {
		return bankId;
	}

	public void setBankId(Long bankId) {
		this.bankId = bankId;
	}

	public Long getGuaranteeId() {
		return guaranteeId;
	}

	public void setGuaranteeId(Long guaranteeId) {
		this.guaranteeId = guaranteeId;
	}

	public String getGuaranteeName() {
		return guaranteeName;
	}

	public void setGuaranteeName(String guaranteeName) {
		this.guaranteeName = guaranteeName;
	}

	public Long getGuaranteeUserId() {
		return guaranteeUserId;
	}

	public void setGuaranteeUserId(Long guaranteeUserId) {
		this.guaranteeUserId = guaranteeUserId;
	}

	public String getGuaranteeUserName() {
		return guaranteeUserName;
	}

	public void setGuaranteeUserName(String guaranteeUserName) {
		this.guaranteeUserName = guaranteeUserName;
	}

	public String getLoanCode() {
		return loanCode;
	}

	public void setLoanCode(String loanCode) {
		this.loanCode = loanCode;
	}

	public String getLoanType() {
		return loanType;
	}

	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getCommonRepaymentCount() {
		return commonRepaymentCount;
	}

	public void setCommonRepaymentCount(Integer commonRepaymentCount) {
		this.commonRepaymentCount = commonRepaymentCount;
	}

	public Integer getGuaranteeCount() {
		return guaranteeCount;
	}

	public void setGuaranteeCount(Integer guaranteeCount) {
		this.guaranteeCount = guaranteeCount;
	}

	public String getSignTimeStart() {
		return signTimeStart;
	}

	public void setSignTimeStart(String signTimeStart) {
		this.signTimeStart = signTimeStart;
	}

	public String getSignTimeEnd() {
		return signTimeEnd;
	}

	public void setSignTimeEnd(String signTimeEnd) {
		this.signTimeEnd = signTimeEnd;
	}

	public String getAuditStatus() {
		return auditStatus;
	}

	public void setAuditStatus(String auditStatus) {
		this.auditStatus = auditStatus;
	}

	public String getDealwithStatus() {
		return dealwithStatus;
	}

	public void setDealwithStatus(String dealwithStatus) {
		this.dealwithStatus = dealwithStatus;
	}

	public Date getAuditTime() {
		return auditTime;
	}

	public void setAuditTime(Date auditTime) {
		this.auditTime = auditTime;
	}
	
	

	public String getIsFinish() {
		return isFinish;
	}

	public void setIsFinish(String isFinish) {
		this.isFinish = isFinish;
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
    

}
