package com.yundian.fssapi.domain;

import java.io.Serializable;
import java.util.Date;

public class FssBankAddedConfModel implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * 
     */
    private Long id;

    /**
     * 银行id
     */
    private Long bankId;

    /**
     * 银行名称
     */
    private String bankName;

    /**
     * 征信申请采集
     */
    private String haveCreditCollect;

    /**
     * 
     */
    private Integer creditCollectPrice;

    /**
     * 风险信息查询
     */
    private String haveRiskSearching;

    /**
     * 
     */
    private Integer riskSearchingPrice;

    /**
     * 人脸识别功能
     */
    private String haveFaceMatching;

    /**
     * 
     */
    private Integer faceMatchingPrice;

    /**
     * 公安身份核验
     */
    private String haveIdentityVerification;

    /**
     * 
     */
    private Integer identityVerificationPrice;

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
     * @param id the value for fss_bank_added_conf.id
     *
     * @cgw 2016-10-09 10:41:49
     */
    public void setId(Long id) {
        this.id = id;
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
     * @param bankId the value for fss_bank_added_conf.bank_id
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
     * @param bankName the value for fss_bank_added_conf.bank_name
     *
     * @cgw 2016-10-09 10:41:49
     */
    public void setBankName(String bankName) {
        this.bankName = bankName == null ? null : bankName.trim();
    }

    /**
     * 获取征信申请采集
     *
     * @cgw 2016-10-09 10:41:49
     */
    public String getHaveCreditCollect() {
        return haveCreditCollect;
    }

    /**
     * 设置征信申请采集
     *
     * @param haveCreditCollect the value for fss_bank_added_conf.have_credit_collect
     *
     * @cgw 2016-10-09 10:41:49
     */
    public void setHaveCreditCollect(String haveCreditCollect) {
        this.haveCreditCollect = haveCreditCollect == null ? null : haveCreditCollect.trim();
    }

    /**
     * 获取
     *
     * @cgw 2016-10-09 10:41:49
     */
    public Integer getCreditCollectPrice() {
        return creditCollectPrice;
    }

    /**
     * 设置
     *
     * @param creditCollectPrice the value for fss_bank_added_conf.credit_collect_price
     *
     * @cgw 2016-10-09 10:41:49
     */
    public void setCreditCollectPrice(Integer creditCollectPrice) {
        this.creditCollectPrice = creditCollectPrice;
    }

    /**
     * 获取风险信息查询
     *
     * @cgw 2016-10-09 10:41:49
     */
    public String getHaveRiskSearching() {
        return haveRiskSearching;
    }

    /**
     * 设置风险信息查询
     *
     * @param haveRiskSearching the value for fss_bank_added_conf.have_risk_searching
     *
     * @cgw 2016-10-09 10:41:49
     */
    public void setHaveRiskSearching(String haveRiskSearching) {
        this.haveRiskSearching = haveRiskSearching == null ? null : haveRiskSearching.trim();
    }

    /**
     * 获取
     *
     * @cgw 2016-10-09 10:41:49
     */
    public Integer getRiskSearchingPrice() {
        return riskSearchingPrice;
    }

    /**
     * 设置
     *
     * @param riskSearchingPrice the value for fss_bank_added_conf.risk_searching_price
     *
     * @cgw 2016-10-09 10:41:49
     */
    public void setRiskSearchingPrice(Integer riskSearchingPrice) {
        this.riskSearchingPrice = riskSearchingPrice;
    }

    /**
     * 获取人脸识别功能
     *
     * @cgw 2016-10-09 10:41:49
     */
    public String getHaveFaceMatching() {
        return haveFaceMatching;
    }

    /**
     * 设置人脸识别功能
     *
     * @param haveFaceMatching the value for fss_bank_added_conf.have_face_matching
     *
     * @cgw 2016-10-09 10:41:49
     */
    public void setHaveFaceMatching(String haveFaceMatching) {
        this.haveFaceMatching = haveFaceMatching == null ? null : haveFaceMatching.trim();
    }

    /**
     * 获取
     *
     * @cgw 2016-10-09 10:41:49
     */
    public Integer getFaceMatchingPrice() {
        return faceMatchingPrice;
    }

    /**
     * 设置
     *
     * @param faceMatchingPrice the value for fss_bank_added_conf.face_matching_price
     *
     * @cgw 2016-10-09 10:41:49
     */
    public void setFaceMatchingPrice(Integer faceMatchingPrice) {
        this.faceMatchingPrice = faceMatchingPrice;
    }

    /**
     * 获取公安身份核验
     *
     * @cgw 2016-10-09 10:41:49
     */
    public String getHaveIdentityVerification() {
        return haveIdentityVerification;
    }

    /**
     * 设置公安身份核验
     *
     * @param haveIdentityVerification the value for fss_bank_added_conf.have_identity_verification
     *
     * @cgw 2016-10-09 10:41:49
     */
    public void setHaveIdentityVerification(String haveIdentityVerification) {
        this.haveIdentityVerification = haveIdentityVerification == null ? null : haveIdentityVerification.trim();
    }

    /**
     * 获取
     *
     * @cgw 2016-10-09 10:41:49
     */
    public Integer getIdentityVerificationPrice() {
        return identityVerificationPrice;
    }

    /**
     * 设置
     *
     * @param identityVerificationPrice the value for fss_bank_added_conf.identity_verification_price
     *
     * @cgw 2016-10-09 10:41:49
     */
    public void setIdentityVerificationPrice(Integer identityVerificationPrice) {
        this.identityVerificationPrice = identityVerificationPrice;
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
     * @param ctime the value for fss_bank_added_conf.ctime
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
     * @param mtime the value for fss_bank_added_conf.mtime
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
     * @param remark the value for fss_bank_added_conf.remark
     *
     * @cgw 2016-10-09 10:41:49
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}