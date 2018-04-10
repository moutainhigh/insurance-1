package com.yundian.fssapi.domain.statistics;

import com.yundian.fssapi.enums.FssLoanStatusEnum;

import java.io.Serializable;

/**
 * 流程推进对象
 *
 * @author jnx
 * @create 2018/4/10
 */
public class FlowDataModel  implements Serializable{

    /**
     * 分期id
     */
    private Long loanId;
    /**
     * 操作人
     */
    private String operater;
    /**
     * 推进到流程状态
     */
    private FssLoanStatusEnum flowToStatus;
    /**
     * 原来的状态
     */
    private FssLoanStatusEnum flowPreStatus;

    /**
     * 审核内容
     */
    private String content;


    public Long getLoanId() {
        return this.loanId;
    }

    public void setLoanId(Long loanId) {
        this.loanId = loanId;
    }

    public String getOperater() {
        return this.operater;
    }

    public void setOperater(String operater) {
        this.operater = operater;
    }

    public FssLoanStatusEnum getFlowToStatus() {
        return this.flowToStatus;
    }

    public void setFlowToStatus(FssLoanStatusEnum flowToStatus) {
        this.flowToStatus = flowToStatus;
    }

    public FssLoanStatusEnum getFlowPreStatus() {
        return this.flowPreStatus;
    }

    public void setFlowPreStatus(FssLoanStatusEnum flowPreStatus) {
        this.flowPreStatus = flowPreStatus;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
