package com.yundian.fssapi.dto;/**
 * Author: jiyanbin@zafh.com.cn
 * JDK: 1.8
 * Created on 16/8/12.
 */


import java.io.Serializable;
import java.util.Date;

/**
 * 修改历史
 * 修改日期         修改人          问题类型           说明
 */
public class MyTaskQueryCriterion implements Serializable {
    //借款人姓名
    private String borrowerName;
    //借款人身份证号
    private String borrowerCardId;
    //审批机构ID
    private long orgId;
    //审批机构编码
    private String orgCode;
    //审批机构名称
    private String orgName;
    //担保机构code
    private String guaranteeCode;
    //担保机构Name
    private String guaranteeName;
    //操作者ID
    private long operatorId;
    //操作者姓名
    private String operatorName;
    //提交开始日期
    private Date commitBeginDate;
    //提交结束日期
    private Date commitEndDate;
    //true:已办,false:待办
    private Boolean isProcessed;
    //开始偏移量
    private int offset;
    //限制条数
    private int limit;

    public String getBorrowerName() {
        return borrowerName;
    }

    public void setBorrowerName(String borrowerName) {
        this.borrowerName = borrowerName;
    }

    public String getBorrowerCardId() {
        return borrowerCardId;
    }

    public void setBorrowerCardId(String borrowerCardId) {
        this.borrowerCardId = borrowerCardId;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public Date getCommitBeginDate() {
        return commitBeginDate;
    }

    public void setCommitBeginDate(Date commitBeginDate) {
        this.commitBeginDate = commitBeginDate;
    }

    public Date getCommitEndDate() {
        return commitEndDate;
    }

    public void setCommitEndDate(Date commitEndDate) {
        this.commitEndDate = commitEndDate;
    }

    public Boolean getProcessed() {
        return isProcessed;
    }

    public void setProcessed(Boolean processed) {
        isProcessed = processed;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public long getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(long operatorId) {
        this.operatorId = operatorId;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public long getOrgId() {
        return orgId;
    }

    public void setOrgId(long orgId) {
        this.orgId = orgId;
    }

    public String getGuaranteeCode() {
        return guaranteeCode;
    }

    public void setGuaranteeCode(String guaranteeCode) {
        this.guaranteeCode = guaranteeCode;
    }

    public String getGuaranteeName() {
        return guaranteeName;
    }

    public void setGuaranteeName(String guaranteeName) {
        this.guaranteeName = guaranteeName;
    }
}
