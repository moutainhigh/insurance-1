package com.yundian.fss.biz.service.impl;

import com.yundian.fss.biz.service.FssRepaymentOrderBizService;
import com.yundian.fss.dao.FssRepaymentOrderMapper;
import com.yundian.fssapi.domain.FssRepaymentOrderModel;
import com.yundian.fssapi.enums.FssRepaymentOrderStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author jnx
 * @create 2018/6/22
 */
@Component("fssRepaymentOrderBizService")
public class FssRepaymentOrderBizServiceImpl implements FssRepaymentOrderBizService {

    @Autowired
    FssRepaymentOrderMapper fssRepaymentOrderMapper;

    @Override
    public FssRepaymentOrderModel getRepaymentOrderById(Long orderId) {
        return fssRepaymentOrderMapper.selectByPrimaryKey(orderId);
    }

    @Override
    public FssRepaymentOrderModel getRepaymentOrder(String tradeNo) {

        return fssRepaymentOrderMapper.selectByTradeCode(tradeNo);
    }

    @Override
    public Integer initRepaymentOrder(FssRepaymentOrderModel fssRepaymentOrderModel) {
        return fssRepaymentOrderMapper.insert(fssRepaymentOrderModel);
    }

    @Override
    public void updateRepaymentOrderStatus(Long id, FssRepaymentOrderStatusEnum orderStatus, String tradeRemark) {

        FssRepaymentOrderModel orderModel = new FssRepaymentOrderModel();
        orderModel.setId(id);
        orderModel.setTradeStatus(orderStatus.name());
        orderModel.setTradeRemark(tradeRemark);
        orderModel.setMtime(new Date());
        fssRepaymentOrderMapper.updateByPrimaryKeySelective(orderModel);
    }



}
