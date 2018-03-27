package com.yundian.fssapi.flow;

import java.io.Serializable;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.stream.Stream;

/**
 * Author: jiyanbin@zafh.com.cn
 * JDK: 1.8
 * Created on 15/11/11.
 */
public enum BusinessType implements BusinessTypeOperator<FlowNodeOperator>, Serializable {
    /**
     * 征信流程
     */
    FSS_FLOW("面签审批流程") {
        @Override
        public FlowNodeOperator[] listFlowNode() {
            return FssFlowNode.values();
        }

        @Override
        public FlowNodeOperator getFirstNode() {
            return FssFlowNode.FSS_LAUNCH;
        }

        @Override
        public FlowNodeOperator getLastNode() {
            return FssFlowNode.BANK_CONFIRMATION;
        }
    };

    private String desc;

    BusinessType(String desc) {
        this.desc = desc;
    }


    public String getBusinessType() {
        return this.name();
    }

    public String getDesc() {
        return desc;
    }

    public static BusinessType getInstance(String businessType) {
        return Stream.of(BusinessType.values())
                .filter(type -> Objects.equals(type.getBusinessType(), businessType))
                .findAny()
                .orElseThrow(() -> new RuntimeException("流程类型[" + businessType + "]不存在，请检查数据是否正确！"));
    }

    @Override
    public FlowNodeOperator getFlowNode(String nodeKey) {
        FlowNodeOperator[] nodes = listFlowNode();
        return Stream.of(nodes)
                .filter(node -> Objects.equals(node.getNodeCode(), nodeKey))
                .findAny()
                .orElseThrow(() -> new NoSuchElementException("流程类型[" + name() + "]中不存在[" + nodeKey + "]流程节点"));
    }
}
