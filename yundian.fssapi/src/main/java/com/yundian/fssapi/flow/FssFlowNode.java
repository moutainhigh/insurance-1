package com.yundian.fssapi.flow;/**
 * Author: jiyanbin@zafh.com.cn
 * JDK: 1.8
 * Created on 16/8/9.
 */


import java.util.Objects;
import java.util.stream.Stream;

/**
 * 修改历史
 * 修改日期         修改人          问题类型           说明
 */
public enum FssFlowNode  implements FlowNodeOperator<FssFlowNode> {
    FSS_LAUNCH(1, "面签发起", ""),
    FSS_SUBMIT_APPROVE(2, "提交审批", ""),
    FSS_APPROVE(3, "机构审核", ""),
    BANK_CONFIRMATION(4, "银行确认", "");

    private int nodeIndex;
    private String nodeName;
    private String desc;

    FssFlowNode(int nodeIndex, String nodeName, String desc) {
        this.nodeIndex = nodeIndex;
        this.nodeName = nodeName;
        this.desc = desc;
    }

    public FssFlowNode[] getValues() {
        return FssFlowNode.values();
    }

    public int getNodeIndex() {
        return nodeIndex;
    }

    public String getNodeName() {
        return nodeName;
    }

    @Override
    public String getNodeDesc() {
        return desc;
    }


    public BusinessType getBusinessType() {
        return BusinessType.FSS_FLOW;
    }

    public String getNodeCode() {
        return name();
    }

    @Override
    public FssFlowNode self() {
        return this;
    }


    public static FssFlowNode getInstance(String nodeCode) {
        return Stream.of(FssFlowNode.values())
                .filter(node -> Objects.equals(node.name(), nodeCode))
                .findAny()
                .orElse(null);
    }
}
