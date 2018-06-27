package com.yundian.fss.pay.withhold.haier;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.yundian.fss.pay.withhold.haier.annotation.AnnotationValue;
import com.yundian.fssapi.haier.response.HaierResult;
import com.yundian.fssapi.haier.response.HaierTradeBankWitholdingResponse;
import com.yundian.fssapi.haier.response.HaierTradeQueryResponse;
import com.yundian.toolkit.utils.DateUtils;
import com.yundian.toolkit.utils.RandomUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 交易查询网关接口
 *
 * @author jnx
 * @create 2018/6/4
 */
@Slf4j
@Component("haierTradeQueryRequest")
public class HaierTradeQueryRequest extends HaierRequestBase {

    /**
     *平台(商户) 订单号，字 母数字下划 线，确保每 笔订单唯一
     */
    @AnnotationValue("trade_no")
    private String tradeNo;


    @Override
    public String getService() {
        return "trade_query";
    }

    @Override
    public String getRequestNo() {

        return DateUtils.formatString(new Date(),"yyyyMMddHHmmssSS")+ RandomUtil.generateRandomNumber(4);
    }
    /**
     *
     * @param tradeNo 快捷通订单号
     * @return
     */
    public HaierResult<HaierTradeQueryResponse> invoke(String tradeNo) throws Exception{
        log.info("调用交易查询接口:outTradeNo = [" + tradeNo + "]");
        this.tradeNo = tradeNo;
        String httpResult = post();
        HaierResult<HaierTradeQueryResponse> haierResult= JSON.parseObject(httpResult, new TypeReference<HaierResult<HaierTradeQueryResponse>>(){});

        log.info("返回结果："+ httpResult);
        return haierResult;
    }


}
