package com.yundian.fssapi.domain;

import java.util.Date;

public class FssApiCallLog {
    private Long serialId;

    private Integer interfaceType;

    private String interfaceName;

    private String interfaceDesc;

    private String callParam;

    private Integer callStatus;

    private String callResult;

    private Date callTime;

    private Date replyTime;

    private Integer timeConsuming;

    private String callIp;

    private Long callTimeTimestamp;

    private Long replyTimeTimestamp;

    public Long getSerialId() {
        return serialId;
    }

    public void setSerialId(Long serialId) {
        this.serialId = serialId;
    }

    public Integer getInterfaceType() {
        return interfaceType;
    }

    public void setInterfaceType(Integer interfaceType) {
        this.interfaceType = interfaceType;
    }

    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName == null ? null : interfaceName.trim();
    }

    public String getInterfaceDesc() {
        return interfaceDesc;
    }

    public void setInterfaceDesc(String interfaceDesc) {
        this.interfaceDesc = interfaceDesc == null ? null : interfaceDesc.trim();
    }

    public String getCallParam() {
        return callParam;
    }

    public void setCallParam(String callParam) {
        this.callParam = callParam == null ? null : callParam.trim();
    }

    public Integer getCallStatus() {
        return callStatus;
    }

    public void setCallStatus(Integer callStatus) {
        this.callStatus = callStatus;
    }

    public String getCallResult() {
        return callResult;
    }

    public void setCallResult(String callResult) {
        this.callResult = callResult == null ? null : callResult.trim();
    }

    public Date getCallTime() {
        return callTime;
    }

    public void setCallTime(Date callTime) {
        this.callTime = callTime;
    }

    public Date getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(Date replyTime) {
        this.replyTime = replyTime;
    }

    public Integer getTimeConsuming() {
        return timeConsuming;
    }

    public void setTimeConsuming(Integer timeConsuming) {
        this.timeConsuming = timeConsuming;
    }

    public String getCallIp() {
        return callIp;
    }

    public void setCallIp(String callIp) {
        this.callIp = callIp == null ? null : callIp.trim();
    }

    public Long getCallTimeTimestamp() {
        return callTimeTimestamp;
    }

    public void setCallTimeTimestamp(Long callTimeTimestamp) {
        this.callTimeTimestamp = callTimeTimestamp;
    }

    public Long getReplyTimeTimestamp() {
        return replyTimeTimestamp;
    }

    public void setReplyTimeTimestamp(Long replyTimeTimestamp) {
        this.replyTimeTimestamp = replyTimeTimestamp;
    }
}