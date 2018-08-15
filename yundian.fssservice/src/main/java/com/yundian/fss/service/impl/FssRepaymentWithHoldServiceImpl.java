package com.yundian.fss.service.impl;

import com.alibaba.fastjson.JSON;
import com.yundian.fss.biz.service.FssLoanRepaymentPlanBizService;
import com.yundian.fss.biz.service.FssRepaymentOrderBizService;
import com.yundian.fss.dao.FssLoanRepaymentPlanModelMapper;
import com.yundian.fss.dao.FssRepaymentOrderNotifyMapper;
import com.yundian.fss.pay.withhold.haier.WithHoldHaierBizService;
import com.yundian.fssapi.domain.FssLoanRepaymentPlanModel;
import com.yundian.fssapi.domain.FssRepaymentOrderModel;
import com.yundian.fssapi.domain.FssRepaymentOrderNotifyModel;
import com.yundian.fssapi.enums.FssRepaymentOrderStatusEnum;
import com.yundian.fssapi.enums.FssRepaymentOrderTradeTypeEnum;
import com.yundian.fssapi.haier.notify.param.RefundNotifyParam;
import com.yundian.fssapi.haier.notify.param.WitholdingNotifyParam;
import com.yundian.fssapi.haier.response.HaierResult;
import com.yundian.fssapi.haier.response.HaierTradeQueryResponse;
import com.yundian.fssapi.service.FssRepaymentWithHoldService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
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

        return withHoldHaierBizService.verify(param,sign,"RSA");
    }

    @Override
    public void tradeWithHolding(Long planId) {

        FssLoanRepaymentPlanModel planModel = fssLoanRepaymentPlanModelMapper.selectByPrimaryKey(planId);
        withHoldHaierBizService.tradeBankWithHolding(planModel);

    }

    @Override
    public void batchTradeWithHolding() {

    }

    @Override
    public void tradeRefund(Long repaymentOrderId) {
        withHoldHaierBizService.tradeRefund(repaymentOrderId);
    }

    @Override
    public HaierResult<HaierTradeQueryResponse> tradeQuery(String kjtTradeCode) {
        return withHoldHaierBizService.tradeQuery(kjtTradeCode);
    }

    @Override
    public void notifyWithHold(WitholdingNotifyParam notifyRequest) {

        FssRepaymentOrderNotifyModel notifyModel = new FssRepaymentOrderNotifyModel();
        notifyModel.setTradeStatus(notifyRequest.getTrade_status());
        notifyModel.setTradeNo(notifyRequest.getOuter_trade_no());
        notifyModel.setTradeRemark(notifyRequest.getFailReason());
        notifyModel.setBankTradeNo(notifyRequest.getInner_trade_no());
        notifyModel.setNotifyParam(JSON.toJSONString(notifyRequest));
        notifyModel.setNotifySide("kjt");
        notifyModel.setNotifyType(FssRepaymentOrderTradeTypeEnum.WITHOLDING.name());
        notifyModel.setTradeAmount(notifyRequest.getTrade_amount());
        notifyModel.setCtime(new Date());
        notifyModel.setMtime(new Date());
        fssRepaymentOrderNotifyMapper.insert(notifyModel);

        FssRepaymentOrderStatusEnum orderStatusEnum =Enum.valueOf(FssRepaymentOrderStatusEnum.class,notifyRequest.getTrade_status());
        FssRepaymentOrderModel orderModel =fssRepaymentOrderBizService.getRepaymentOrder(notifyModel.getTradeNo());
        fssRepaymentOrderBizService.updateRepaymentOrderStatus(orderModel.getId(),orderStatusEnum,notifyRequest.getFailReason());

        if(orderStatusEnum ==FssRepaymentOrderStatusEnum.TRADE_CLOSED){
            fssLoanRepaymentPlanBizService.updateRepaymentPlanUnPayment(orderModel.getPlanId());
        }else if(orderStatusEnum ==FssRepaymentOrderStatusEnum.TRADE_FINISHED||
                orderStatusEnum ==FssRepaymentOrderStatusEnum.TRADE_SUCCESS){
            Double tradeAmountDouble = Double.valueOf(notifyModel.getTradeAmount())*100;
            //时间格式：20091225091010
            String paymentTimeStr = notifyRequest.getGmt_payment();
            DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
            LocalDateTime paymentDateTime = LocalDateTime.parse(paymentTimeStr, df);
            DateTimeFormatter df2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            fssLoanRepaymentPlanBizService.repaymentSuccess(orderModel.getPlanId(),tradeAmountDouble.intValue(),
                    paymentDateTime.toLocalDate().toString(),paymentDateTime.format(df2));
        }


        }

    @Override
    public void notifyRefund(RefundNotifyParam refundNotifyParam) {
        FssRepaymentOrderNotifyModel notifyModel = new FssRepaymentOrderNotifyModel();
        notifyModel.setTradeStatus(refundNotifyParam.getRefund_status());
        notifyModel.setTradeNo(refundNotifyParam.getOuter_trade_no());
        notifyModel.setBankTradeNo(refundNotifyParam.getInner_trade_no());
        notifyModel.setNotifyParam(JSON.toJSONString(refundNotifyParam));
        notifyModel.setTradeRemark("原始订单号："+refundNotifyParam.getOrig_outer_trade_no());
        notifyModel.setNotifySide("kjt");
        notifyModel.setNotifyType(FssRepaymentOrderTradeTypeEnum.REFUND.name());
        notifyModel.setTradeAmount(refundNotifyParam.getRefund_amount());
        notifyModel.setCtime(new Date());
        notifyModel.setMtime(new Date());
        fssRepaymentOrderNotifyMapper.insert(notifyModel);

        FssRepaymentOrderStatusEnum orderStatusEnum =Enum.valueOf(FssRepaymentOrderStatusEnum.class,refundNotifyParam.getRefund_status());
        FssRepaymentOrderModel orderModel =fssRepaymentOrderBizService.getRepaymentOrder(notifyModel.getTradeNo());
        fssRepaymentOrderBizService.updateRepaymentOrderStatus(orderModel.getId(),orderStatusEnum,"");

    }
}
