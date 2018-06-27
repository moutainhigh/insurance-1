package com.yundian.fssapi.domain;

import java.io.Serializable;
import java.util.Date;

public class FssLoanRepaymentPlanModel implements Serializable {
    private Long id;

    private Long loanId;

    private Integer period;
    /**
     * 总期数
     */
    private Integer periodCount;

    private String agreedRepaymentDate;

    /**
     * 实际还款日期
     */
    private String repaymentDate;
    /**
     * 还款时间
     */
    private Date repaymentTime;

    private Integer payAmount;

    private Integer payFee;

    private Integer planAmount;

    private Integer planCaptialAmount;

    private Integer planInterestAmount;

    private Integer overdueDays;

    private String repaymentStatus;

    /**
     * 1：代扣中
     */
    private Integer inPayment;

    private Date ctime;

    private Date mtime;

    private String remark;

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

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public String getAgreedRepaymentDate() {
        return agreedRepaymentDate;
    }

    public void setAgreedRepaymentDate(String agreedRepaymentDate) {
        this.agreedRepaymentDate = agreedRepaymentDate == null ? null : agreedRepaymentDate.trim();
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

    public Integer getOverdueDays() {
        return overdueDays;
    }

    public void setOverdueDays(Integer overdueDays) {
        this.overdueDays = overdueDays;
    }

    public String getRepaymentStatus() {
        return repaymentStatus;
    }

    public void setRepaymentStatus(String repaymentStatus) {
        this.repaymentStatus = repaymentStatus == null ? null : repaymentStatus.trim();
    }

    public Integer getPeriodCount() {
        return this.periodCount;
    }

    public void setPeriodCount(Integer periodCount) {
        this.periodCount = periodCount;
    }

    public String getRepaymentDate() {
        return this.repaymentDate;
    }

    public void setRepaymentDate(String repaymentDate) {
        this.repaymentDate = repaymentDate;
    }

    public Date getRepaymentTime() {
        return this.repaymentTime;
    }

    public void setRepaymentTime(Date repaymentTime) {
        this.repaymentTime = repaymentTime;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getInPayment() {
        return this.inPayment;
    }

    public void setInPayment(Integer inPayment) {
        this.inPayment = inPayment;
    }
}