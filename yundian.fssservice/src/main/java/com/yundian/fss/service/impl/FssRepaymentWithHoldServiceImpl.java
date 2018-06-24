package com.yundian.fss.service.impl;

import com.alibaba.fastjson.JSON;
import com.yundian.fss.biz.service.FssLoanRepaymentPlanBizService;
import com.yundian.fss.biz.service.FssRepaymentOrderBizService;
import com.yundian.fss.dao.FssLoanRepaymentPlanModelMapper;
import com.yundian.fss.dao.FssRepaymentOrderNotifyMapper;
import com.yundian.fss.pay.withhold.haier.HaierResult;
import com.yundian.fss.pay.withhold.haier.WithHoldHaierBizService;
import com.yundian.fss.pay.withhold.haier.model.HaierTradeQueryResponse;
import com.yundian.fssapi.domain.FssRepaymentOrderModel;
import com.yundian.fssapi.domain.FssRepaymentOrderNotifyModel;
import com.yundian.fssapi.enums.FssRepaymentOrderStatusEnum;
import com.yundian.fssapi.haier.request.RefundNotifyRequest;
import com.yundian.fssapi.haier.request.WitholdingNotifyRequest;
import com.yundian.fssapi.service.FssRepaymentWithHoldService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 代扣服务
 *
 * @author jnx
 * @create 2018/6/1
 */
@Slf4j
@Service("fssRepaymentWithHoldService")
public class FssRepaymentWithHoldServiceImpl implements FssRepaymentWithHoldService{

    @Autowired
    WithHoldHaierBizService withHoldHaierBizService;

    @Autowired
    FssLoanRepaymentPlanModelMapper fssLoanRepaymentPlanModelMapper;

    @Autowired
    FssRepaymentOrderBizService fssRepaymentOrderBizService;

    @Autowired
    FssRepaymentOrderNotifyMapper fssRepaymentOrderNotifyMapper;

    @Autowired
    FssLoanRepaymentPlanBizService fssLoanRepaymentPlanBizService;
    @Override
    public Boolean verfiySign(Map<String, String> param, String sign) {

        return withHoldHaierBizService.verify(param,sign);
    }

    @Override
    public void tradeWithHolding(Long planId) {


    }

    @Override
    public void batchTradeWithHolding() {

    }

    @Override
    public void tradeRefund() {

    }

    @Override
    public void tradeQuery(String kjtTradeCode) {
        HaierResult<HaierTradeQueryResponse> responseHaierResult= withHoldHaierBizService.tradeQuery(kjtTradeCode);
    }

    @Override
    public void notifyWithHold(WitholdingNotifyRequest notifyRequest) {

        FssRepaymentOrderNotifyModel notifyModel = new FssRepaymentOrderNotifyModel();
        notifyModel.setTradeStatus(notifyRequest.getTrade_status());
        notifyModel.setTradeNo(notifyRequest.getOuter_trade_no());
        notifyModel.setTradeRemark("");
        notifyModel.setBankTradeNo(notifyRequest.getInner_trade_no());
        notifyModel.setNotifyParam(JSON.toJSONString(notifyRequest));
        notifyModel.setNotifySide("kjt");
        notifyModel.setNotifyType("Witholding");
        notifyModel.setTradeAmount(notifyRequest.getTrade_amount());
        fssRepaymentOrderNotifyMapper.insert(notifyModel);

        FssRepaymentOrderStatusEnum orderStatusEnum =Enum.valueOf(FssRepaymentOrderStatusEnum.class,notifyRequest.getTrade_status());
        FssRepaymentOrderModel orderModel =fssRepaymentOrderBizService.getRepaymentOrder(notifyModel.getTradeNo());
        fssRepaymentOrderBizService.updateRepaymentOrderStatus(orderModel.getId(),orderStatusEnum,notifyRequest.getFailReason());
        if(orderStatusEnum ==FssRepaymentOrderStatusEnum.TRADE_CLOSED){
            fssLoanRepaymentPlanBizService.updateRepaymentPlanUnPayment(orderModel.getPlanId());
        }


        }

    @Override
    public void notifyRefund(RefundNotifyRequest refundNotifyRequest) {

    }
}
