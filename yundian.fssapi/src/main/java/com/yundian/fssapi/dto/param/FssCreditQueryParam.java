package com.yundian.fssapi.dto.param;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class FssCreditQueryParam implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * 
     */
    private Long creditId;

    /**
     * 合作机构ID
     */
    private Long guaranteeId;

    /**
     * 合作机构名称
     */
    private String guaranteeName;

    /**
     * ID
     */
    private Long guaranteeUserId;

    /**
     * 合作机构业务员姓名
     */
    private String guaranteeUserName;

    /**
     * 合作机构业务员手机号码
     */
    private String guaranteeUserPhone;

    /**
     * 银行id
     */
    private Long bankId;

    /**
     * 银行名称
     */
    private String bankName;

    /**
     * 银行编号
     */
    private String bankCode;

    /**
     * 姓名
     */
    private String name;

    /**
     * 性别
     */
    private String sex;

    /**
     * 身份证号
     */
    private String idcard;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 出生年月
     */
    private String birthday;

    /**
     * 身份证正面照片
     */
    private String cardFrontimg;

    /**
     * 身份证反面照片
     */
    private String cardOppositeimg;

    /**
     * 征信授权书亲签照片
     */
    private String requisitionSignImg;

    /**
     * 征信授权书原件照片
     */
    private String originalImg;

    /**
     * 征信状态:,见：FssCreditAuditStatusEnum
     */
    private String creditStatus;

    /**
     * 银行征信报告日期
     */
    private Date creditReportTime;

    /**
     * 贷款笔数
     */
    private Integer loanNum;

    /**
     * 总贷款金额
     */
    private BigDecimal loanTotalAmount;

    /**
     * 当前累计逾期期数
     */
    private Integer overduePeriods;

    /**
     * 当前累计逾期金额
     */
    private BigDecimal overdueAmount;

    /**
     * 贷记卡总账户数
     */
    private Integer debitAccountNum;

    /**
     * 贷记卡总授信额度
     */
    private BigDecimal debitTotalPosition;

    /**
     * 贷记卡当前累计逾期期数
     */
    private Integer debitOverduePeriods;

    /**
     * 贷记卡当前累计逾期金额
     */
    private BigDecimal debitOverdueAmount;

    /**
     * 准贷记卡总账户数
     */
    private Integer semiAccountNum;

    /**
     * 准贷记卡总授信额度
     */
    private BigDecimal semiTotalPosition;

    /**
     * 准贷记卡透支180天以上累计金额
     */
    private BigDecimal semiOverdrawnAmount180;

    /**
     * 准贷记卡当前累计透支余额
     */
    private BigDecimal semiOverdrawnBalance;

    /**
     * 有无住房公积金
     */
    private String housingFund;

    /**
     * 银行征信报告备注
     */
    private String creditReportRemark;

    /**
     * 征信申请时间
     */
    private String creditApplyTimeStart;
    /**
     * 征信申请时间
     */
    private String creditApplyTimeEnd;
    /**
     * 征信审核时间
     */
    private Date creditAuditTime;

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
    public Long getCreditId() {
        return creditId;
    }

    /**
     * 设置
     *
     * @param creditId the value for fss_credit.credit_id
     *
     * @cgw 2016-10-09 10:41:49
     */
    public void setCreditId(Long creditId) {
        this.creditId = creditId;
    }

    /**
     * 获取合作机构ID
     *
     * @cgw 2016-10-09 10:41:49
     */
    public Long getGuaranteeId() {
        return guaranteeId;
    }

    /**
     * 设置合作机构ID
     *
     * @param guaranteeId the value for fss_credit.guarantee_id
     *
     * @cgw 2016-10-09 10:41:49
     */
    public void setGuaranteeId(Long guaranteeId) {
        this.guaranteeId = guaranteeId;
    }

    /**
     * 获取合作机构名称
     *
     * @cgw 2016-10-09 10:41:49
     */
    public String getGuaranteeName() {
        return guaranteeName;
    }

    /**
     * 设置合作机构名称
     *
     * @param guaranteeName the value for fss_credit.guarantee_name
     *
     * @cgw 2016-10-09 10:41:49
     */
    public void setGuaranteeName(String guaranteeName) {
        this.guaranteeName = guaranteeName == null ? null : guaranteeName.trim();
    }

    /**
     * 获取ID
     *
     * @cgw 2016-10-09 10:41:49
     */
    public Long getGuaranteeUserId() {
        return guaranteeUserId;
    }

    /**
     * 设置ID
     *
     * @param guaranteeUserId the value for fss_credit.guarantee_user_id
     *
     * @cgw 2016-10-09 10:41:49
     */
    public void setGuaranteeUserId(Long guaranteeUserId) {
        this.guaranteeUserId = guaranteeUserId;
    }

    /**
     * 获取合作机构业务员姓名
     *
     * @cgw 2016-10-09 10:41:49
     */
    public String getGuaranteeUserName() {
        return guaranteeUserName;
    }

    /**
     * 设置合作机构业务员姓名
     *
     * @param guaranteeUserName the value for fss_credit.guarantee_user_name
     *
     * @cgw 2016-10-09 10:41:49
     */
    public void setGuaranteeUserName(String guaranteeUserName) {
        this.guaranteeUserName = guaranteeUserName == null ? null : guaranteeUserName.trim();
    }

    /**
     * 获取合作机构业务员手机号码
     *
     * @cgw 2016-10-09 10:41:49
     */
    public String getGuaranteeUserPhone() {
        return guaranteeUserPhone;
    }

    /**
     * 设置合作机构业务员手机号码
     *
     * @param guaranteeUserPhone the value for fss_credit.guarantee_user_phone
     *
     * @cgw 2016-10-09 10:41:49
     */
    public void setGuaranteeUserPhone(String guaranteeUserPhone) {
        this.guaranteeUserPhone = guaranteeUserPhone == null ? null : guaranteeUserPhone.trim();
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
     * @param bankId the value for fss_credit.bank_id
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
     * @param bankName the value for fss_credit.bank_name
     *
     * @cgw 2016-10-09 10:41:49
     */
    public void setBankName(String bankName) {
        this.bankName = bankName == null ? null : bankName.trim();
    }

    /**
     * 获取银行编号
     *
     * @cgw 2016-10-09 10:41:49
     */
    public String getBankCode() {
        return bankCode;
    }

    /**
     * 设置银行编号
     *
     * @param bankCode the value for fss_credit.bank_code
     *
     * @cgw 2016-10-09 10:41:49
     */
    public void setBankCode(String bankCode) {
        this.bankCode = bankCode == null ? null : bankCode.trim();
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
     * @param name the value for fss_credit.name
     *
     * @cgw 2016-10-09 10:41:49
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取性别
     *
     * @cgw 2016-10-09 10:41:49
     */
    public String getSex() {
        return sex;
    }

    /**
     * 设置性别
     *
     * @param sex the value for fss_credit.sex
     *
     * @cgw 2016-10-09 10:41:49
     */
    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    /**
     * 获取身份证号
     *
     * @cgw 2016-10-09 10:41:49
     */
    public String getIdcard() {
        return idcard;
    }

    /**
     * 设置身份证号
     *
     * @param idcard the value for fss_credit.idcard
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
    public String getPhone() {
        return phone;
    }

    /**
     * 设置手机号码
     *
     * @param phone the value for fss_credit.phone
     *
     * @cgw 2016-10-09 10:41:49
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * 获取出生年月
     *
     * @cgw 2016-10-09 10:41:49
     */
    public String getBirthday() {
        return birthday;
    }

    /**
     * 设置出生年月
     *
     * @param birthday the value for fss_credit.birthday
     *
     * @cgw 2016-10-09 10:41:49
     */
    public void setBirthday(String birthday) {
        this.birthday = birthday == null ? null : birthday.trim();
    }

    /**
     * 获取身份证正面照片
     *
     * @cgw 2016-10-09 10:41:49
     */
    public String getCardFrontimg() {
        return cardFrontimg;
    }

    /**
     * 设置身份证正面照片
     *
     * @param cardFrontimg the value for fss_credit.card_frontimg
     *
     * @cgw 2016-10-09 10:41:49
     */
    public void setCardFrontimg(String cardFrontimg) {
        this.cardFrontimg = cardFrontimg == null ? null : cardFrontimg.trim();
    }

    /**
     * 获取身份证反面照片
     *
     * @cgw 2016-10-09 10:41:49
     */
    public String getCardOppositeimg() {
        return cardOppositeimg;
    }

    /**
     * 设置身份证反面照片
     *
     * @param cardOppositeimg the value for fss_credit.card_oppositeimg
     *
     * @cgw 2016-10-09 10:41:49
     */
    public void setCardOppositeimg(String cardOppositeimg) {
        this.cardOppositeimg = cardOppositeimg == null ? null : cardOppositeimg.trim();
    }

    /**
     * 获取征信授权书亲签照片
     *
     * @cgw 2016-10-09 10:41:49
     */
    public String getRequisitionSignImg() {
        return requisitionSignImg;
    }

    /**
     * 设置征信授权书亲签照片
     *
     * @param requisitionSignImg the value for fss_credit.requisition_sign_img
     *
     * @cgw 2016-10-09 10:41:49
     */
    public void setRequisitionSignImg(String requisitionSignImg) {
        this.requisitionSignImg = requisitionSignImg == null ? null : requisitionSignImg.trim();
    }

    /**
     * 获取征信授权书原件照片
     *
     * @cgw 2016-10-09 10:41:49
     */
    public String getOriginalImg() {
        return originalImg;
    }

    /**
     * 设置征信授权书原件照片
     *
     * @param originalImg the value for fss_credit.original_img
     *
     * @cgw 2016-10-09 10:41:49
     */
    public void setOriginalImg(String originalImg) {
        this.originalImg = originalImg == null ? null : originalImg.trim();
    }

    /**
     * 获取征信状态
     *
     * @cgw 2016-10-09 10:41:49
     */
    public String getCreditStatus() {
        return creditStatus;
    }

    /**
     * 设置征信状态
     *
     * @param creditStatus the value for fss_credit.credit_status
     *
     * @cgw 2016-10-09 10:41:49
     */
    public void setCreditStatus(String creditStatus) {
        this.creditStatus = creditStatus == null ? null : creditStatus.trim();
    }

    /**
     * 获取银行征信报告日期
     *
     * @cgw 2016-10-09 10:41:49
     */
    public Date getCreditReportTime() {
        return creditReportTime;
    }

    /**
     * 设置银行征信报告日期
     *
     * @param creditReportTime the value for fss_credit.credit_report_time
     *
     * @cgw 2016-10-09 10:41:49
     */
    public void setCreditReportTime(Date creditReportTime) {
        this.creditReportTime = creditReportTime;
    }

    /**
     * 获取贷款笔数
     *
     * @cgw 2016-10-09 10:41:49
     */
    public Integer getLoanNum() {
        return loanNum;
    }

    /**
     * 设置贷款笔数
     *
     * @param loanNum the value for fss_credit.loan_num
     *
     * @cgw 2016-10-09 10:41:49
     */
    public void setLoanNum(Integer loanNum) {
        this.loanNum = loanNum;
    }

    /**
     * 获取总贷款金额
     *
     * @cgw 2016-10-09 10:41:49
     */
    public BigDecimal getLoanTotalAmount() {
        return loanTotalAmount;
    }

    /**
     * 设置总贷款金额
     *
     * @param loanTotalAmount the value for fss_credit.loan_total_amount
     *
     * @cgw 2016-10-09 10:41:49
     */
    public void setLoanTotalAmount(BigDecimal loanTotalAmount) {
        this.loanTotalAmount = loanTotalAmount;
    }

    /**
     * 获取当前累计逾期期数
     *
     * @cgw 2016-10-09 10:41:49
     */
    public Integer getOverduePeriods() {
        return overduePeriods;
    }

    /**
     * 设置当前累计逾期期数
     *
     * @param overduePeriods the value for fss_credit.overdue_periods
     *
     * @cgw 2016-10-09 10:41:49
     */
    public void setOverduePeriods(Integer overduePeriods) {
        this.overduePeriods = overduePeriods;
    }

    /**
     * 获取当前累计逾期金额
     *
     * @cgw 2016-10-09 10:41:49
     */
    public BigDecimal getOverdueAmount() {
        return overdueAmount;
    }

    /**
     * 设置当前累计逾期金额
     *
     * @param overdueAmount the value for fss_credit.overdue_amount
     *
     * @cgw 2016-10-09 10:41:49
     */
    public void setOverdueAmount(BigDecimal overdueAmount) {
        this.overdueAmount = overdueAmount;
    }

    /**
     * 获取贷记卡总账户数
     *
     * @cgw 2016-10-09 10:41:49
     */
    public Integer getDebitAccountNum() {
        return debitAccountNum;
    }

    /**
     * 设置贷记卡总账户数
     *
     * @param debitAccountNum the value for fss_credit.debit_account_num
     *
     * @cgw 2016-10-09 10:41:49
     */
    public void setDebitAccountNum(Integer debitAccountNum) {
        this.debitAccountNum = debitAccountNum;
    }

    /**
     * 获取贷记卡总授信额度
     *
     * @cgw 2016-10-09 10:41:49
     */
    public BigDecimal getDebitTotalPosition() {
        return debitTotalPosition;
    }

    /**
     * 设置贷记卡总授信额度
     *
     * @param debitTotalPosition the value for fss_credit.debit_total_position
     *
     * @cgw 2016-10-09 10:41:49
     */
    public void setDebitTotalPosition(BigDecimal debitTotalPosition) {
        this.debitTotalPosition = debitTotalPosition;
    }

    /**
     * 获取贷记卡当前累计逾期期数
     *
     * @cgw 2016-10-09 10:41:49
     */
    public Integer getDebitOverduePeriods() {
        return debitOverduePeriods;
    }

    /**
     * 设置贷记卡当前累计逾期期数
     *
     * @param debitOverduePeriods the value for fss_credit.debit_overdue_periods
     *
     * @cgw 2016-10-09 10:41:49
     */
    public void setDebitOverduePeriods(Integer debitOverduePeriods) {
        this.debitOverduePeriods = debitOverduePeriods;
    }

    /**
     * 获取贷记卡当前累计逾期金额
     *
     * @cgw 2016-10-09 10:41:49
     */
    public BigDecimal getDebitOverdueAmount() {
        return debitOverdueAmount;
    }

    /**
     * 设置贷记卡当前累计逾期金额
     *
     * @param debitOverdueAmount the value for fss_credit.debit_overdue_amount
     *
     * @cgw 2016-10-09 10:41:49
     */
    public void setDebitOverdueAmount(BigDecimal debitOverdueAmount) {
        this.debitOverdueAmount = debitOverdueAmount;
    }

    /**
     * 获取准贷记卡总账户数
     *
     * @cgw 2016-10-09 10:41:49
     */
    public Integer getSemiAccountNum() {
        return semiAccountNum;
    }

    /**
     * 设置准贷记卡总账户数
     *
     * @param semiAccountNum the value for fss_credit.semi_account_num
     *
     * @cgw 2016-10-09 10:41:49
     */
    public void setSemiAccountNum(Integer semiAccountNum) {
        this.semiAccountNum = semiAccountNum;
    }

    /**
     * 获取准贷记卡总授信额度
     *
     * @cgw 2016-10-09 10:41:49
     */
    public BigDecimal getSemiTotalPosition() {
        return semiTotalPosition;
    }

    /**
     * 设置准贷记卡总授信额度
     *
     * @param semiTotalPosition the value for fss_credit.semi_total_position
     *
     * @cgw 2016-10-09 10:41:49
     */
    public void setSemiTotalPosition(BigDecimal semiTotalPosition) {
        this.semiTotalPosition = semiTotalPosition;
    }

    /**
     * 获取准贷记卡透支180天以上累计金额
     *
     * @cgw 2016-10-09 10:41:49
     */
    public BigDecimal getSemiOverdrawnAmount180() {
        return semiOverdrawnAmount180;
    }

    /**
     * 设置准贷记卡透支180天以上累计金额
     *
     * @param semiOverdrawnAmount180 the value for fss_credit.semi_overdrawn_amount_180
     *
     * @cgw 2016-10-09 10:41:49
     */
    public void setSemiOverdrawnAmount180(BigDecimal semiOverdrawnAmount180) {
        this.semiOverdrawnAmount180 = semiOverdrawnAmount180;
    }

    /**
     * 获取准贷记卡当前累计透支余额
     *
     * @cgw 2016-10-09 10:41:49
     */
    public BigDecimal getSemiOverdrawnBalance() {
        return semiOverdrawnBalance;
    }

    /**
     * 设置准贷记卡当前累计透支余额
     *
     * @param semiOverdrawnBalance the value for fss_credit.semi_overdrawn_balance
     *
     * @cgw 2016-10-09 10:41:49
     */
    public void setSemiOverdrawnBalance(BigDecimal semiOverdrawnBalance) {
        this.semiOverdrawnBalance = semiOverdrawnBalance;
    }

    /**
     * 获取有无住房公积金
     *
     * @cgw 2016-10-09 10:41:49
     */
    public String getHousingFund() {
        return housingFund;
    }

    /**
     * 设置有无住房公积金
     *
     * @param housingFund the value for fss_credit.housing_fund
     *
     * @cgw 2016-10-09 10:41:49
     */
    public void setHousingFund(String housingFund) {
        this.housingFund = housingFund == null ? null : housingFund.trim();
    }

    /**
     * 获取银行征信报告备注
     *
     * @cgw 2016-10-09 10:41:49
     */
    public String getCreditReportRemark() {
        return creditReportRemark;
    }

    /**
     * 设置银行征信报告备注
     *
     * @param creditReportRemark the value for fss_credit.credit_report_remark
     *
     * @cgw 2016-10-09 10:41:49
     */
    public void setCreditReportRemark(String creditReportRemark) {
        this.creditReportRemark = creditReportRemark == null ? null : creditReportRemark.trim();
    }

    /**
	 * @return the creditApplyTimeStart
	 */
	public String getCreditApplyTimeStart() {
		return creditApplyTimeStart;
	}

	/**
	 * @param creditApplyTimeStart the creditApplyTimeStart to set
	 */
	public void setCreditApplyTimeStart(String creditApplyTimeStart) {
		this.creditApplyTimeStart = creditApplyTimeStart;
	}

	/**
	 * @return the creditApplyTimeEnd
	 */
	public String getCreditApplyTimeEnd() {
		return creditApplyTimeEnd;
	}

	/**
	 * @param creditApplyTimeEnd the creditApplyTimeEnd to set
	 */
	public void setCreditApplyTimeEnd(String creditApplyTimeEnd) {
		this.creditApplyTimeEnd = creditApplyTimeEnd;
	}

	/**
     * 获取征信审核时间
     *
     * @cgw 2016-10-09 10:41:49
     */
    public Date getCreditAuditTime() {
        return creditAuditTime;
    }

    /**
     * 设置征信审核时间
     *
     * @param creditAuditTime the value for fss_credit.credit_audit_time
     *
     * @cgw 2016-10-09 10:41:49
     */
    public void setCreditAuditTime(Date creditAuditTime) {
        this.creditAuditTime = creditAuditTime;
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
     * @param ctime the value for fss_credit.ctime
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
     * @param mtime the value for fss_credit.mtime
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
     * @param remark the value for fss_credit.remark
     *
     * @cgw 2016-10-09 10:41:49
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}