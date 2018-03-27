package com.yundian.fssapi.flow;

/**
 * Author:jiyanbin@zafh.com.cn
 * JDK: 1.8
 * Created on 2015/11/27.
 */
public interface BusinessTypeOperator<E extends FlowNodeOperator> {
    /**
     * 列出所有流程节点
     * @return
     */
    E[] listFlowNode();

    /**
     * 获取指定的node
     *
     * @param nodeKey
     * @return
     */
    E getFlowNode(String nodeKey);

    /**
     * 获取第一个节点
     *
     * @return
     */
    E getFirstNode();

    /**
     * 获取最后一个节点
     *
     * @return
     */
    E getLastNode();
}
