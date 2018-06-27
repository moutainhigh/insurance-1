package com.yundian.fss.biz.service;

import com.yundian.fssapi.domain.FssRepaymentOrderModel;
import com.yundian.fssapi.enums.FssRepaymentOrderStatusEnum;

/**
 * Created by jnx on 2018/6/22.
 */
public interface FssRepaymentOrderBizService {

    FssRepaymentOrderModel getRepaymentOrderById(Long orderId);
    /**
     *
     * @param tradeNo
     * @return
     */
    FssRepaymentOrderModel getRepaymentOrder(String tradeNo);

    /**
     * 初始还款订单
     * @param fssRepaymentOrderModel
     */
    Integer initRepaymentOrder(FssRepaymentOrderModel fssRepaymentOrderModel);

    /**
     * 更新还款订单状态
     * @param id
     * @param orderStatus 状态
     * @param tradeRemark 说明
     */
    void updateRepaymentOrderStatus(Long id, FssRepaymentOrderStatusEnum orderStatus,String tradeRemark);


}
