package com.yundian.fss.service;

import com.alibaba.fastjson.JSON;
import com.yundian.fss.pay.withhold.haier.HaierResult;
import com.yundian.fss.pay.withhold.haier.HaierTradeBankWitholdingRequest;
import com.yundian.fss.pay.withhold.haier.HaierTradeQueryRequest;
import com.yundian.fss.pay.withhold.haier.HaierTradeRefundRequest;
import com.yundian.fss.pay.withhold.haier.model.HaierTradeBankWitholdingResponse;
import com.yundian.fss.pay.withhold.haier.model.HaierTradeQueryResponse;
import com.yundian.fss.pay.withhold.haier.model.HaierTradeRefundResponse;
import com.yundian.fss.test.AbstractJUnit;
import com.yundian.fssapi.domain.FssCarBrandModel;
import com.yundian.fssapi.domain.FssCarModelsModel;
import com.yundian.fssapi.domain.FssCarSeriesModel;
import com.yundian.fssapi.service.FssCarService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 代扣测试
 *
 * @author jnx
 * @create 2018/4/3
 */
public class FssHaierWitholdingTest extends AbstractJUnit{

    @Autowired
    HaierTradeBankWitholdingRequest haierTradeBankWitholdingRequest;

    @Autowired
    HaierTradeQueryRequest haierTradeQueryRequest;


    @Autowired
    HaierTradeRefundRequest haierTradeRefundRequest;
    @Test
    public void witholding() {
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
    public void query() {
        String tradeNo="101152958090002381353";
        HaierResult<HaierTradeQueryResponse> haierTradeQueryResponseHaierResult =haierTradeQueryRequest.invoke(tradeNo);
        System.out.printf("query:"+JSON.toJSONString(haierTradeQueryResponseHaierResult));
    }

    @Test
    public void refund() {
        String outTradeNo="luoyirefund2018062110553000003";
        String orgTradeNo="luoyi2018062110553000004";
        HaierResult<HaierTradeRefundResponse> result =haierTradeRefundRequest.invoke(outTradeNo,orgTradeNo,"0.11");
        System.out.printf("query:"+JSON.toJSONString(result));
    }

}
