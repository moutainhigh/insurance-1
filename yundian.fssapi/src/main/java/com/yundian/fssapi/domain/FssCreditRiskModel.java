package com.yundian.fssapi.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class FssCreditRiskModel implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * 
     */
    private Long riskId;

    /**
     * 征信id
     */
    private Long creditId;

    /**
     * 姓名
     */
    private String name;

    /**
     * 身份证号码
     */
    private String idcard;

    /**
     * 手机号码
     */
    private String mobile;

    /**
     * 风险等级
     */
    private String riskLevel;

    /**
     * 风险结果
     */
    private String riskDecision;

    /**
     * 风险描述摘要
     */
    private String ristAbstract;

    /**
     * 申请时间
     */
    private Date applyTime;

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
     * 风险详情
     */
    private List<FssCreditRiskDetailModel> creditRiskDetailList;

    /**
     * 获取
     *
     * @cgw 2016-10-09 10:41:49
     */
    public Long getRiskId() {
        return riskId;
    }

    /**
     * 设置
     *
     * @param riskId the value for fss_credit_risk.risk_id
     *
     * @cgw 2016-10-09 10:41:49
     */
    public void setRiskId(Long riskId) {
        this.riskId = riskId;
    }

    /**
     * 获取征信id
     *
     * @cgw 2016-10-09 10:41:49
     */
    public Long getCreditId() {
        return creditId;
    }

    /**
     * 设置征信id
     *
     * @param creditId the value for fss_credit_risk.credit_id
     *
     * @cgw 2016-10-09 10:41:49
     */
    public void setCreditId(Long creditId) {
        this.creditId = creditId;
    }

    /**
     * 获取姓名
     *
     * @cgw 2016-10-09 10:41:49
     */
    public String getName() {
        return name;
    }

    /**
     * 设置姓名
     *
     * @param name the value for fss_credit_risk.name
     *
     * @cgw 2016-10-09 10:41:49
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取身份证号码
     *
     * @cgw 2016-10-09 10:41:49
     */
    public String getIdcard() {
        return idcard;
    }

    /**
     * 设置身份证号码
     *
     * @param idcard the value for fss_credit_risk.idcard
     *
     * @cgw 2016-10-09 10:41:49
     */
    public void setIdcard(String idcard) {
        this.idcard = idcard == null ? null : idcard.trim();
    }

    /**
     * 获取手机号码
     *
     * @cgw 2016-10-09 10:41:49
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置手机号码
     *
     * @param mobile the value for fss_credit_risk.mobile
     *
     * @cgw 2016-10-09 10:41:49
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * 获取风险等级
     *
     * @cgw 2016-10-09 10:41:49
     */
    public String getRiskLevel() {
        return riskLevel;
    }

    /**
     * 设置风险等级
     *
     * @param riskLevel the value for fss_credit_risk.risk_level
     *
     * @cgw 2016-10-09 10:41:49
     */
    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel == null ? null : riskLevel.trim();
    }

    /**
     * 获取风险结果
     *
     * @cgw 2016-10-09 10:41:49
     */
    public String getRiskDecision() {
        return riskDecision;
    }

    /**
     * 设置风险结果
     *
     * @param riskDecision the value for fss_credit_risk.risk_decision
     *
     * @cgw 2016-10-09 10:41:49
     */
    public void setRiskDecision(String riskDecision) {
        this.riskDecision = riskDecision == null ? null : riskDecision.trim();
    }

    /**
     * 获取风险描述摘要
     *
     * @cgw 2016-10-09 10:41:49
     */
    public String getRistAbstract() {
        return ristAbstract;
    }

    /**
     * 设置风险描述摘要
     *
     * @param ristAbstract the value for fss_credit_risk.rist_abstract
     *
     * @cgw 2016-10-09 10:41:49
     */
    public void setRistAbstract(String ristAbstract) {
        this.ristAbstract = ristAbstract == null ? null : ristAbstract.trim();
    }

    /**
     * 获取申请时间
     *
     * @cgw 2016-10-09 10:41:49
     */
    public Date getApplyTime() {
        return applyTime;
    }

    /**
     * 设置申请时间
     *
     * @param applyTime the value for fss_credit_risk.apply_time
     *
     * @cgw 2016-10-09 10:41:49
     */
    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
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
     * @param ctime the value for fss_credit_risk.ctime
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
     * @param mtime the value for fss_credit_risk.mtime
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
     * @param remark the value for fss_credit_risk.remark
     *
     * @cgw 2016-10-09 10:41:49
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

	/**
	 * @return the creditRiskDetailList
	 */
	public List<FssCreditRiskDetailModel> getCreditRiskDetailList() {
		return creditRiskDetailList;
	}

	/**
	 * @param creditRiskDetailList the creditRiskDetailList to set
	 */
	public void setCreditRiskDetailList(
			List<FssCreditRiskDetailModel> creditRiskDetailList) {
		this.creditRiskDetailList = creditRiskDetailList;
	}
    
}