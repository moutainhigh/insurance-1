package com.yundian.fss.service;

import com.alibaba.fastjson.JSON;
import com.yundian.fss.pay.withhold.haier.HaierTradeBankWitholdingRequest;
import com.yundian.fss.pay.withhold.haier.HaierTradeQueryRequest;
import com.yundian.fss.pay.withhold.haier.HaierTradeRefundRequest;
import com.yundian.fss.service.support.TradeNoUtils;
import com.yundian.fss.test.AbstractJUnit;
import com.yundian.fssapi.haier.response.HaierResult;
import com.yundian.fssapi.haier.response.HaierTradeBankWitholdingResponse;
import com.yundian.fssapi.haier.response.HaierTradeQueryResponse;
import com.yundian.fssapi.haier.response.HaierTradeRefundResponse;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 代扣测试
 *
 * @author jnx
 * @create 2018/4/3
 */
public class FssRepaymentWitholdingServiceTest extends AbstractJUnit{

    @Autowired
    HaierTradeBankWitholdingRequest haierTradeBankWitholdingRequest;

    @Autowired
    HaierTradeQueryRequest haierTradeQueryRequest;


    @Autowired
    HaierTradeRefundRequest haierTradeRefundRequest;
    @Test
    public void witholding() throws Exception{
        String outTradeNo="luoyi2018062110553000004";
        String bankAccountName="金宁夏";
        String bankCardNo="6212264100011335373";
        String bankCode="ICBC";
        String certificatesNumber="330327198312251714";
        String payableAmount="0.11";
        HaierResult<HaierTradeBankWitholdingResponse> responseHaierResult = haierTradeBankWitholdingRequest.invoke("",outTradeNo,bankAccountName,
                bankCardNo,bankCode,certificatesNumber,payableAmount);
        System.out.printf("witholding:"+JSON.toJSONString(responseHaierResult));
    }


    @Test
    public void query() throws Exception{
        String tradeNo="101152958090002381353";
        HaierResult<HaierTradeQueryResponse> haierTradeQueryResponseHaierResult =haierTradeQueryRequest.invoke(tradeNo);
        System.out.printf("query:"+JSON.toJSONString(haierTradeQueryResponseHaierResult));
    }

    @Test
    public void refund()throws Exception {
        String outTradeNo="luoyirefund2018062110553000003";
        String orgTradeNo="luoyi2018062110553000004";
        HaierResult<HaierTradeRefundResponse> result =haierTradeRefundRequest.invoke(TradeNoUtils.generateRefundTradeNo(),outTradeNo,orgTradeNo,"0.11");
        System.out.printf("query:"+JSON.toJSONString(result));
    }

}
