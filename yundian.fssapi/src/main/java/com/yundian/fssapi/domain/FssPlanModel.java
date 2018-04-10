package com.yundian.fssapi.domain;

import java.io.Serializable;
import java.util.Date;

public class FssPlanModel implements Serializable {
    private Long id;

    private String productName;

    private String capitalType;

    private String interestType;

    private Integer period;

    private Integer rate;

    private Integer bondPercent;

    private Integer servicePercent;

    private Integer discount;

    private Integer discountPercent;

    private Integer offsetFinalPayment;

    private Date ctime;

    private Date mtime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public String getCapitalType() {
        return capitalType;
    }

    public void setCapitalType(String capitalType) {
        this.capitalType = capitalType == null ? null : capitalType.trim();
    }

    public String getInterestType() {
        return interestType;
    }

    public void setInterestType(String interestType) {
        this.interestType = interestType == null ? null : interestType.trim();
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public Integer getBondPercent() {
        return bondPercent;
    }

    public void setBondPercent(Integer bondPercent) {
        this.bondPercent = bondPercent;
    }

    public Integer getServicePercent() {
        return servicePercent;
    }

    public void setServicePercent(Integer servicePercent) {
        this.servicePercent = servicePercent;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public Integer getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(Integer discountPercent) {
        this.discountPercent = discountPercent;
    }

    public Integer getOffsetFinalPayment() {
        return offsetFinalPayment;
    }

    public void setOffsetFinalPayment(Integer offsetFinalPayment) {
        this.offsetFinalPayment = offsetFinalPayment;
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
}