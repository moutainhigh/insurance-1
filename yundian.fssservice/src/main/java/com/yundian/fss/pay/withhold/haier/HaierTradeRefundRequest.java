package com.yundian.fss.pay.withhold.haier;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.yundian.fss.pay.withhold.haier.annotation.AnnotationValue;
import com.yundian.fssapi.haier.response.HaierResult;
import com.yundian.fssapi.haier.response.HaierTradeRefundResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 交易退款接口
 *
 * @author jnx
 * @create 2018/6/4
 */
@Slf4j
@Component("haierTradeRefundRequest")
public class HaierTradeRefundRequest extends HaierRequestBase {

    /**
     *平台(商户)退款订单号
     */
    @AnnotationValue("out_trade_no")
    private String outTradeNo;


    /**
     * 平台(商户)原始订单号
     */
    @AnnotationValue("orig_out_trade_no")
    private String origOutTradeNo;

    /**
     * 退款金额，15 位以内最 大保留 2 位精度数字， 支持部分退款，退款金 额不能大于交易金额
     */
    @AnnotationValue("refund_amount")
    private String refundAmount;

    @AnnotationValue("currency")
    private String currency="CNY";

    private String royaltyInfo;

    @AnnotationValue("notify_url")
    @Value("${kjt.refund.notifyUrl}")
    private String notifyUrl;



    @Override
    public String getService() {
        return "trade_refund";
    }

    private String requestNo;

    @Override
    public String getRequestNo() {

        return requestNo;
    }

    /**
     *调用退款接口
     * @param outTradeNo 退款订单号
     * @param origOutTradeNo （商户）原始交易订单号
     * @param refundAmount 退款金额，小数2位
     * @return
     */
    public HaierResult<HaierTradeRefundResponse> invoke(String requestNo, String outTradeNo, String origOutTradeNo, String refundAmount) throws  Exception{
        System.out.println("outTradeNo = [" + outTradeNo + "], origOutTradeNo = [" + origOutTradeNo + "], refundAmount = [" + refundAmount + "]");
        this.requestNo = requestNo;
        this.outTradeNo = outTradeNo;
        this.origOutTradeNo = origOutTradeNo;
        this.refundAmount=refundAmount;
        String httpResult = post();
        HaierResult<HaierTradeRefundResponse> haierResult= JSON.parseObject(httpResult, new TypeReference<HaierResult<HaierTradeRefundResponse>>(){});
        log.info("返回结果："+ httpResult);
        return haierResult;
    }


}
