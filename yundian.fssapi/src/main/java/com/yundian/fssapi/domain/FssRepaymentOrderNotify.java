package com.yundian.fssapi.domain;

import java.util.Date;

public class FssRepaymentOrderNotify {
    private Long id;

    private String notifyType;

    private String notifySide;

    private String tradeNo;

    private String bankTradeNo;

    private String tradeAmount;

    private String tradeStatus;

    private String tradeRemark;

    private Date ctime;

    private Date mtime;

    private String remark;

    private String notifyParam;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNotifyType() {
        return notifyType;
    }

    public void setNotifyType(String notifyType) {
        this.notifyType = notifyType == null ? null : notifyType.trim();
    }

    public String getNotifySide() {
        return notifySide;
    }

    public void setNotifySide(String notifySide) {
        this.notifySide = notifySide == null ? null : notifySide.trim();
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo == null ? null : tradeNo.trim();
    }

    public String getBankTradeNo() {
        return bankTradeNo;
    }

    public void setBankTradeNo(String bankTradeNo) {
        this.bankTradeNo = bankTradeNo == null ? null : bankTradeNo.trim();
    }

    public String getTradeAmount() {
        return tradeAmount;
    }

    public void setTradeAmount(String tradeAmount) {
        this.tradeAmount = tradeAmount == null ? null : tradeAmount.trim();
    }

    public String getTradeStatus() {
        return tradeStatus;
    }

    public void setTradeStatus(String tradeStatus) {
        this.tradeStatus = tradeStatus == null ? null : tradeStatus.trim();
    }

    public String getTradeRemark() {
        return tradeRemark;
    }

    public void setTradeRemark(String tradeRemark) {
        this.tradeRemark = tradeRemark == null ? null : tradeRemark.trim();
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

    public String getNotifyParam() {
        return notifyParam;
    }

    public void setNotifyParam(String notifyParam) {
        this.notifyParam = notifyParam == null ? null : notifyParam.trim();
    }
}