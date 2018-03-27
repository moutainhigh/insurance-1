package com.yundian.fssapi.domain;

import java.io.Serializable;
import java.util.Date;

public class FssCreditLogModel implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * 
     */
    private Long id;

    /**
     * 征信申请id
     */
    private Long creditId;

    /**
     * 节点编号
     */
    private String node;

    /**
     * 节点名称
     */
    private String nodeName;

    /**
     * 银行id
     */
    private Long bankId;

    /**
     * 银行名称
     */
    private String bankName;

    /**
     * 银行审核人id
     */
    private Long bankUserId;

    /**
     * 银行审核人姓名
     */
    private String bankUserName;

    /**
     * 审核状态
     */
    private String auditStatus;

    /**
     * 审核内容
     */
    private String auditContent;

    /**
     * 审核时间
     */
    private Date auditTime;

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
     * 获取
     *
     * @cgw 2016-10-09 10:41:49
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置
     *
     * @param id the value for fss_credit_log.id
     *
     * @cgw 2016-10-09 10:41:49
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取征信申请id
     *
     * @cgw 2016-10-09 10:41:49
     */
    public Long getCreditId() {
        return creditId;
    }

    /**
     * 设置征信申请id
     *
     * @param creditId the value for fss_credit_log.credit_id
     *
     * @cgw 2016-10-09 10:41:49
     */
    public void setCreditId(Long creditId) {
        this.creditId = creditId;
    }

    /**
     * 获取节点编号
     *
     * @cgw 2016-10-09 10:41:49
     */
    public String getNode() {
        return node;
    }

    /**
     * 设置节点编号
     *
     * @param node the value for fss_credit_log.node
     *
     * @cgw 2016-10-09 10:41:49
     */
    public void setNode(String node) {
        this.node = node == null ? null : node.trim();
    }

    /**
     * 获取节点名称
     *
     * @cgw 2016-10-09 10:41:49
     */
    public String getNodeName() {
        return nodeName;
    }

    /**
     * 设置节点名称
     *
     * @param nodeName the value for fss_credit_log.node_name
     *
     * @cgw 2016-10-09 10:41:49
     */
    public void setNodeName(String nodeName) {
        this.nodeName = nodeName == null ? null : nodeName.trim();
    }

    /**
     * 获取银行id
     *
     * @cgw 2016-10-09 10:41:49
     */
    public Long getBankId() {
        return bankId;
    }

    /**
     * 设置银行id
     *
     * @param bankId the value for fss_credit_log.bank_id
     *
     * @cgw 2016-10-09 10:41:49
     */
    public void setBankId(Long bankId) {
        this.bankId = bankId;
    }

    /**
     * 获取银行名称
     *
     * @cgw 2016-10-09 10:41:49
     */
    public String getBankName() {
        return bankName;
    }

    /**
     * 设置银行名称
     *
     * @param bankName the value for fss_credit_log.bank_name
     *
     * @cgw 2016-10-09 10:41:49
     */
    public void setBankName(String bankName) {
        this.bankName = bankName == null ? null : bankName.trim();
    }

    /**
     * 获取银行审核人id
     *
     * @cgw 2016-10-09 10:41:49
     */
    public Long getBankUserId() {
        return bankUserId;
    }

    /**
     * 设置银行审核人id
     *
     * @param bankUserId the value for fss_credit_log.bank_user_id
     *
     * @cgw 2016-10-09 10:41:49
     */
    public void setBankUserId(Long bankUserId) {
        this.bankUserId = bankUserId;
    }

    /**
     * 获取银行审核人姓名
     *
     * @cgw 2016-10-09 10:41:49
     */
    public String getBankUserName() {
        return bankUserName;
    }

    /**
     * 设置银行审核人姓名
     *
     * @param bankUserName the value for fss_credit_log.bank_user_name
     *
     * @cgw 2016-10-09 10:41:49
     */
    public void setBankUserName(String bankUserName) {
        this.bankUserName = bankUserName == null ? null : bankUserName.trim();
    }

    /**
     * 获取审核状态
     *
     * @cgw 2016-10-09 10:41:49
     */
    public String getAuditStatus() {
        return auditStatus;
    }

    /**
     * 设置审核状态
     *
     * @param auditStatus the value for fss_credit_log.audit_status
     *
     * @cgw 2016-10-09 10:41:49
     */
    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus == null ? null : auditStatus.trim();
    }

    /**
     * 获取审核内容
     *
     * @cgw 2016-10-09 10:41:49
     */
    public String getAuditContent() {
        return auditContent;
    }

    /**
     * 设置审核内容
     *
     * @param auditContent the value for fss_credit_log.audit_content
     *
     * @cgw 2016-10-09 10:41:49
     */
    public void setAuditContent(String auditContent) {
        this.auditContent = auditContent == null ? null : auditContent.trim();
    }

    /**
     * 获取审核时间
     *
     * @cgw 2016-10-09 10:41:49
     */
    public Date getAuditTime() {
        return auditTime;
    }

    /**
     * 设置审核时间
     *
     * @param auditTime the value for fss_credit_log.audit_time
     *
     * @cgw 2016-10-09 10:41:49
     */
    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    /**
     * 获取
     *
     * @cgw 2016-10-09 10:41:49
     */
    public Date getCtime() {
        return ctime;
    }

    /**
     * 设置
     *
     * @param ctime the value for fss_credit_log.ctime
     *
     * @cgw 2016-10-09 10:41:49
     */
    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    /**
     * 获取
     *
     * @cgw 2016-10-09 10:41:49
     */
    public Date getMtime() {
        return mtime;
    }

    /**
     * 设置
     *
     * @param mtime the value for fss_credit_log.mtime
     *
     * @cgw 2016-10-09 10:41:49
     */
    public void setMtime(Date mtime) {
        this.mtime = mtime;
    }

    /**
     * 获取
     *
     * @cgw 2016-10-09 10:41:49
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置
     *
     * @param remark the value for fss_credit_log.remark
     *
     * @cgw 2016-10-09 10:41:49
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}