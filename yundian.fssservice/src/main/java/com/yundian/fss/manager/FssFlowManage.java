package com.yundian.fss.manager;

import com.yundian.fssapi.domain.statistics.FlowDataModel;

/**
 * Created by jnx on 2018/4/10.
 *流程状态
 */
public interface FssFlowManage {

    /**
     * 流程推进
     */
    void flow(FlowDataModel flowDataModel);
}
