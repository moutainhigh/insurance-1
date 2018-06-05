//package com.yundian.fss.pay.withhold.haier;
//
//import com.alibaba.fastjson.JSON;
//import com.yundian.fss.pay.withhold.haier.annotation.AnnotationValue;
//import com.yundian.fss.pay.withhold.haier.model.HaierTradeBankWitholdingResponse;
//import com.yundian.fss.pay.withhold.haier.model.HaierTradeQueryResponse;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//
///**
// * 交易查询网关接口
// *
// * @author jnx
// * @create 2018/6/4
// */
//@Slf4j
//@Component("haierTradeQueryRequest")
//public class HaierTradeQueryRequest extends HaierRequestBase {
//
//    /**
//     *平台(商户) 订单号，字 母数字下划 线，确保每 笔订单唯一
//     */
//    @AnnotationValue("out_trade_no")
//    private String outTradeNo;
//
//
//    @Override
//    public String getService() {
//        return "trade_query";
//    }
//
//
//    /**
//     *
//     * @param outTradeNo 订单号
//     * @return
//     */
//    public HaierResult<HaierTradeQueryResponse> post(String outTradeNo){
//        log.info("调用交易查询接口:outTradeNo = [" + outTradeNo + "]");
//        this.outTradeNo = outTradeNo;
//        HaierResult<HaierTradeQueryResponse> haierResult= post();
//        log.info("返回结果："+ JSON.toJSONString(haierResult));
//        return haierResult;
//    }
//
//
//}
