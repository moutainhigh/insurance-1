package com.yundian.fss.biz.service.impl;

import com.yundian.fss.biz.service.FssRepaymentOrderBizService;
import com.yundian.fssapi.domain.FssRepaymentOrderModel;
import com.yundian.fssapi.enums.FssRepaymentOrderStatusEnum;
import org.springframework.stereotype.Component;

/**
 * @author jnx
 * @create 2018/6/22
 */
@Component("fssRepaymentOrderBizService")
public class FssRepaymentOrderBizServiceImpl implements FssRepaymentOrderBizService {
    @Override
    public FssRepaymentOrderModel getRepaymentOrder(String tradeNo) {
        return null;
    }

    @Override
    public Long initRepaymentOrder(FssRepaymentOrderModel fssRepaymentOrderModel) {
        return null;
    }

    @Override
    public void updateRepaymentOrderStatus(Long id, FssRepaymentOrderStatusEnum orderStatus, String tradeRemark) {

    }

    @Override
    public void updateRepaymentOrderStatusByTradeNo(String tradeNo, FssRepaymentOrderStatusEnum orderStatus, String tradeRemark) {

    }


}
