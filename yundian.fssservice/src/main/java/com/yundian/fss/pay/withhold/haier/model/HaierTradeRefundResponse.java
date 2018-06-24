package com.yundian.fss.pay.withhold.haier.model;

/**
 * 退款返回对象
 *
 * @author jnx
 * @create 2018/6/4
 */
public class HaierTradeRefundResponse {

    /**
     * 平台(商户)退款订单号
     */
    private String out_trade_no;
    /**
     * 快捷通退款订单号
     */
    private String trade_no;
    /**
     * S-订单受理成功 P-处理中 F-失败
     */
    private String status;



}
