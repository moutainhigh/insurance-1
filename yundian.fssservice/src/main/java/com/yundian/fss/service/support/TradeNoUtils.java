package com.yundian.fss.service.support;

import com.yundian.toolkit.utils.DateUtils;
import com.yundian.toolkit.utils.RandomUtil;

import java.util.Date;

/**
 * 订单编号生成
 *
 * @author jnx
 * @create 2018/6/22
 */
public class TradeNoUtils {

    /**
     * 生成代扣订单号
     * @return
     */
    public static String generateWitholdingTradeNo(){

        String tradeNo = "w"+DateUtils.formatString(new Date(),"yyyyMMddHHmmss")+ RandomUtil.generateRandomNumber(6);
        return tradeNo;
    }

    public static String generateRefundTradeNo(){

        String tradeNo = "R"+DateUtils.formatString(new Date(),"yyyyMMddHHmmss")+ RandomUtil.generateRandomNumber(6);
        return tradeNo;
    }
    public static String generateRequestNo(){
        return DateUtils.formatString(new Date(),"yyyyMMddHHmmssSS")+ RandomUtil.generateRandomNumber(4);

    }
}
