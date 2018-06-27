package com.yundian.fss.service;

import com.alibaba.fastjson.JSON;
import com.yundian.fss.service.support.TradeNoUtils;
import com.yundian.fss.test.AbstractJUnit;
import com.yundian.fssapi.haier.notify.param.RefundNotifyParam;
import com.yundian.fssapi.haier.notify.param.WitholdingNotifyParam;
import com.yundian.fssapi.haier.response.HaierResult;
import com.yundian.fssapi.haier.response.HaierTradeQueryResponse;
import com.yundian.fssapi.haier.response.HaierTradeRefundResponse;
import com.yundian.fssapi.service.FssRepaymentWithHoldService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 代扣测试
 *
 * @author jnx
 * @create 2018/4/3
 */
public class FssHaierWitholdingTest extends AbstractJUnit{

    @Autowired
    FssRepaymentWithHoldService fssRepaymentWithHoldService;




    @Test
    public void witholding() {

        Long planId=37L;
        fssRepaymentWithHoldService.tradeWithHolding(planId);

    }


    @Test
    public void query() {
        String tradeNo="103153001086649611208";
        HaierResult<HaierTradeQueryResponse> haierTradeQueryResponseHaierResult =fssRepaymentWithHoldService.tradeQuery(tradeNo);
        System.out.printf("query:"+JSON.toJSONString(haierTradeQueryResponseHaierResult));
    }

    @Test
    public void refund() {

        Long repaymentOrderId= 5L;
         fssRepaymentWithHoldService.tradeRefund(repaymentOrderId);
    }


    @Test
    public void notifyWitholding(){
        String param ="{\n" +
                "    \"notify_time\":\"20170414105550\",\n" +
                "    \"sign_type\":\"RSA\",\n" +
                "    \"notify_type\":\"trade_status_sync\",\n" +
                "    \"gmt_payment\":\"20170414105318\",\n" +
                "    \"trade_status\":\"TRADE_SUCCESS\",\n" +
                "    \"version\":\"1.0\",\n" +
                "    \"sign\":\"70d6f06f6e4f68c2de2435b3047743a4\",\n" +
                "    \"gmt_create\":\"20170414105318\",\n" +
                "    \"_input_charset\":\"UTF-8\",\n" +
                "    \"outer_trade_no\":\"w20180626184411330681\",\n" +
                "    \"trade_amount\":1,\n" +
                "    \"inner_trade_no\":\"101153000985394811200\",\n" +
                "    \"notify_id\":\"71b6ec69cbce4b2eab309340d7081bad\"\n" +
                "}";

        WitholdingNotifyParam witholdingNotifyParam =JSON.parseObject(param, WitholdingNotifyParam.class);
        fssRepaymentWithHoldService.notifyWithHold(witholdingNotifyParam);
    }

    @Test
    public void notifyRefund(){
        String param ="{\n" +
                "    \"notify_time\":\"20170414105550\",\n" +
                "    \"sign_type\":\"RSA\",\n" +
                "    \"notify_type\":\"redund_status_sync\",\n" +
                "    \"refund_status\":\"REFUND_SUCCESS\",\n" +
                "    \"version\":\"1.0\",\n" +
                "    \"orig_outer_trade_no\":\"w20180626184411330681\",\n" +
                "    \"sign\":\"70d6f06f6e4f68c2de2435b3047743a4\",\n" +
                "    \"gmt_refund\":\"20170414105318\",\n" +
                "    \"_input_charset\":\"UTF-8\",\n" +
                "    \"outer_trade_no\":\"R20180626190105479008\",\n" +
                "    \"trade_amount\":1,\n" +
                "    \"inner_trade_no\":\"103153001086649611208\",\n" +
                "    \"notify_id\":\"71b6ec69cbce4b2eab309340d7081bad\"\n" +
                "}";

        RefundNotifyParam refundNotifyParam =JSON.parseObject(param, RefundNotifyParam.class);
        fssRepaymentWithHoldService.notifyRefund(refundNotifyParam);
    }

}
