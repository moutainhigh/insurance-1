package com.yundian.fssapi.domain.query;

import java.io.Serializable;
import java.util.Date;

public class FssLoanAuditingLogQueryModel implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
     * 
     */
    private Long logId;

    /**
     * 贷款id
     */
    private Long loanId;

    /**
     * 审核节点编号
     */
    private String node;

    /**
     * 审核节点名称
     */
    private String nodeName;

    /**
     * 审核机构id
     */
    private Long organizationId;

    /**
     * 担保机构id
     */
    private Long guaranteeId;

    /**
     * 审核人id
     */
    private Long orguserId;

    /**
     * 审核人姓名
     */
    private String orguserName;

    /**
     * 审核状态:通过，不通过，退回
     */
    private String auditStatus;

    /**
     * 审核时间
     */
    private Date auditTime;

    /**
     * 审核内容
     */
    private String auditContent;

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
     * 审批机构名称
     */
    private String organizationName;

    /**
     * 担保机构名称
     */
    private String guaranteeName;

    /**
     * 获取
     *
     * @cgw 2016-07-26 11:23:26
     */
    public Long getLogId() {
        return logId;
    }

    /**
     * 设置
     *
     * @param logId the value for fss_loan_auditing_log.log_id
     *
     * @cgw 2016-07-26 11:23:26
     */
    public void setLogId(Long logId) {
        this.logId = logId;
    }

    /**
     * 获取贷款id
     *
     * @cgw 2016-07-26 11:23:26
     */
    public Long getLoanId() {
        return loanId;
    }

    /**
     * 设置贷款id
     *
     * @param loanId the value for fss_loan_auditing_log.loan_id
     *
     * @cgw 2016-07-26 11:23:26
     */
    public void setLoanId(Long loanId) {
        this.loanId = loanId;
    }

    /**
     * 获取审核节点编号
     *
     * @cgw 2016-07-26 11:23:26
     */
    public String getNode() {
        return node;
    }

    /**
     * 设置审核节点编号
     *
     * @param node the value for fss_loan_auditing_log.node
     *
     * @cgw 2016-07-26 11:23:26
     */
    public void setNode(String node) {
        this.node = node == null ? null : node.trim();
    }

    /**
     * 获取审核节点名称
     *
     * @cgw 2016-07-26 11:23:26
     */
    public String getNodeName() {
        return nodeName;
    }

    /**
     * 设置审核节点名称
     *
     * @param nodeName the value for fss_loan_auditing_log.node_name
     *
     * @cgw 2016-07-26 11:23:26
     */
    public void setNodeName(String nodeName) {
        this.nodeName = nodeName == null ? null : nodeName.trim();
    }

    /**
     * 获取审核机构id
     *
     * @cgw 2016-07-26 11:23:26
     */
    public Long getOrganizationId() {
        return organizationId;
    }

    /**
     * 设置审核机构id
     *
     * @param organizationId the value for fss_loan_auditing_log.organization_id
     *
     * @cgw 2016-07-26 11:23:26
     */
    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    /**
     * 获取担保机构id
     *
     * @cgw 2016-07-26 11:23:26
     */
    public Long getGuaranteeId() {
        return guaranteeId;
    }

    /**
     * 设置担保机构id
     *
     * @param guaranteeId the value for fss_loan_auditing_log.guarantee_id
     *
     * @cgw 2016-07-26 11:23:26
     */
    public void setGuaranteeId(Long guaranteeId) {
        this.guaranteeId = guaranteeId;
    }

    /**
     * 获取审核人id
     *
     * @cgw 2016-07-26 11:23:26
     */
    public Long getOrguserId() {
        return orguserId;
    }

    /**
     * 设置审核人id
     *
     * @param orguserId the value for fss_loan_auditing_log.orguser_id
     *
     * @cgw 2016-07-26 11:23:26
     */
    public void setOrguserId(Long orguserId) {
        this.orguserId = orguserId;
    }

    /**
     * 获取审核人姓名
     *
     * @cgw 2016-07-26 11:23:26
     */
    public String getOrguserName() {
        return orguserName;
    }

    /**
     * 设置审核人姓名
     *
     * @param orguserName the value for fss_loan_auditing_log.orguser_name
     *
     * @cgw 2016-07-26 11:23:26
     */
    public void setOrguserName(String orguserName) {
        this.orguserName = orguserName;
    }

    /**
     * 获取审核状态:通过，不通过，退回
     *
     * @cgw 2016-07-26 11:23:26
     */
    public String getAuditStatus() {
        return auditStatus;
    }

    /**
     * 设置审核状态:通过，不通过，退回
     *
     * @param auditStatus the value for fss_loan_auditing_log.audit_status
     *
     * @cgw 2016-07-26 11:23:26
     */
    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus;
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
     * @param auditTime the value for fss_loan_auditing_log.audit_time
     *
     * @cgw 2016-07-26 11:23:26
     */
    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    /**
     * 获取审核内容
     *
     * @cgw 2016-07-26 11:23:26
     */
    public String getAuditContent() {
        return auditContent;
    }

    /**
     * 设置审核内容
     *
     * @param auditContent the value for fss_loan_auditing_log.audit_content
     *
     * @cgw 2016-07-26 11:23:26
     */
    public void setAuditContent(String auditContent) {
        this.auditContent = auditContent == null ? null : auditContent.trim();
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
     * @param ctime the value for fss_loan_auditing_log.ctime
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
     * @param mtime the value for fss_loan_auditing_log.mtime
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
     * @param remark the value for fss_loan_auditing_log.remark
     *
     * @cgw 2016-07-26 11:23:26
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public String getGuaranteeName() {
		return guaranteeName;
	}

	public void setGuaranteeName(String guaranteeName) {
		this.guaranteeName = guaranteeName;
	}
    
}