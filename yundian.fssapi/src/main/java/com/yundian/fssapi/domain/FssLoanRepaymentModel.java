package com.yundian.fssapi.domain;

import java.io.Serializable;
import java.util.Date;

public class FssLoanRepaymentModel implements Serializable {
    private Long id;

    private Long loanId;

    private Long repaymentPlanId;

    private Integer period;

    private Integer payAmount;

    private Integer payFee;

    private Integer planAmount;

    private Integer planCaptialAmount;

    private Integer planInterestAmount;

    private Date payTime;

    private String payDate;

    private String payStatus;

    private Integer overdueDays;

    private String bankCode;

    private String accountName;

    private String accountCard;

    private Date ctime;

    private Date mtime;

    private Date remark;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLoanId() {
        return loanId;
    }

    public void setLoanId(Long loanId) {
        this.loanId = loanId;
    }

    public Long getRepaymentPlanId() {
        return repaymentPlanId;
    }

    public void setRepaymentPlanId(Long repaymentPlanId) {
        this.repaymentPlanId = repaymentPlanId;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public Integer getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(Integer payAmount) {
        this.payAmount = payAmount;
    }

    public Integer getPayFee() {
        return payFee;
    }

    public void setPayFee(Integer payFee) {
        this.payFee = payFee;
    }

    public Integer getPlanAmount() {
        return planAmount;
    }

    public void setPlanAmount(Integer planAmount) {
        this.planAmount = planAmount;
    }

    public Integer getPlanCaptialAmount() {
        return planCaptialAmount;
    }

    public void setPlanCaptialAmount(Integer planCaptialAmount) {
        this.planCaptialAmount = planCaptialAmount;
    }

    public Integer getPlanInterestAmount() {
        return planInterestAmount;
    }

    public void setPlanInterestAmount(Integer planInterestAmount) {
        this.planInterestAmount = planInterestAmount;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public String getPayDate() {
        return payDate;
    }

    public void setPayDate(String payDate) {
        this.payDate = payDate == null ? null : payDate.trim();
    }

    public String getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus == null ? null : payStatus.trim();
    }

    public Integer getOverdueDays() {
        return overdueDays;
    }

    public void setOverdueDays(Integer overdueDays) {
        this.overdueDays = overdueDays;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode == null ? null : bankCode.trim();
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName == null ? null : accountName.trim();
    }

    public String getAccountCard() {
        return accountCard;
    }

    public void setAccountCard(String accountCard) {
        this.accountCard = accountCard == null ? null : accountCard.trim();
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public Date getMtime() {
        return mtime;
    }

    public void setMtime(Date mtime) {
        this.mtime = mtime;
    }

    public Date getRemark() {
        return remark;
    }

    public void setRemark(Date remark) {
        this.remark = remark;
    }
}