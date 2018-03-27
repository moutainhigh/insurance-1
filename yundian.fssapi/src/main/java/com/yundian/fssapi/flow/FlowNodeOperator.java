package com.yundian.fssapi.flow;

/**
 * FlowNode操作器接口，所有流程节点定义实现此接口
 * @param <E>
 */
public interface FlowNodeOperator<E extends FlowNodeOperator<E>> {
    /**
     * 获取某一流程的所有节点
     * @return
     */
    E[] getValues();

    /**
     * 获取节点在整个流程中的索引
     * @return
     */
    int getNodeIndex();

    /**
     * 获取节点的名称
     * @return
     */
    String getNodeName();

    /**
     * 获取节点描述
     * @return
     */
    String getNodeDesc();

    /**
     * 获取节点所属的流程
     * @return
     */
    BusinessType getBusinessType();

    /**
     * 获取节点编码
     * @return
     */
    String getNodeCode();

    /**
     * 获取自身的flowNode实例
     *
     * @return
     */
    E self();

}
