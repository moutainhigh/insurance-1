package com.yundian.fssapi.domain;

import java.io.Serializable;
import java.util.Date;

public class FssCreditRiskDetailModel implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * 
     */
    private Long id;

    /**
     * 
     */
    private Long riskId;

    /**
     * 风险规则名称
     */
    private String itemName;

    /**
     * 规则等级
     */
    private String riskLevel;

    /**
     * 风险详细
     */
    private String itemDetail;

    /**
     * 
     */
    private Date ctime;

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
     * @param id the value for fss_credit_risk_detail.id
     *
     * @cgw 2016-10-09 10:41:49
     */
    public void setId(Long id) {
        this.id = id;
    }

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
     * @param riskId the value for fss_credit_risk_detail.risk_id
     *
     * @cgw 2016-10-09 10:41:49
     */
    public void setRiskId(Long riskId) {
        this.riskId = riskId;
    }

    /**
     * 获取风险规则名称
     *
     * @cgw 2016-10-09 10:41:49
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * 设置风险规则名称
     *
     * @param itemName the value for fss_credit_risk_detail.item_name
     *
     * @cgw 2016-10-09 10:41:49
     */
    public void setItemName(String itemName) {
        this.itemName = itemName == null ? null : itemName.trim();
    }

    /**
     * 获取规则等级
     *
     * @cgw 2016-10-09 10:41:49
     */
    public String getRiskLevel() {
        return riskLevel;
    }

    /**
     * 设置规则等级
     *
     * @param riskLevel the value for fss_credit_risk_detail.risk_level
     *
     * @cgw 2016-10-09 10:41:49
     */
    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel == null ? null : riskLevel.trim();
    }

    /**
     * 获取风险详细
     *
     * @cgw 2016-10-09 10:41:49
     */
    public String getItemDetail() {
        return itemDetail;
    }

    /**
     * 设置风险详细
     *
     * @param itemDetail the value for fss_credit_risk_detail.item_detail
     *
     * @cgw 2016-10-09 10:41:49
     */
    public void setItemDetail(String itemDetail) {
        this.itemDetail = itemDetail == null ? null : itemDetail.trim();
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
     * @param ctime the value for fss_credit_risk_detail.ctime
     *
     * @cgw 2016-10-09 10:41:49
     */
    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }
}