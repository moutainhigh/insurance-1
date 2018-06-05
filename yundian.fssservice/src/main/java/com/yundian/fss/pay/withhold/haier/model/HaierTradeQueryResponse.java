package com.yundian.fss.pay.withhold.haier.model;

/**
 * 代扣申请返回对象
 *
 * @author jnx
 * @create 2018/6/4
 */
public class HaierTradeQueryResponse {

    private String out_trade_no;
    private String trade_no;
    private String subject;
    private String partner_id;


    private String payer_id;
    private String payer_name;
    private String payee_id;
    private String payee_name;
    private String royalty_list;
    private String amount;
    private String partner_fee;
    private String payer_fee;
    private String payee_fee;
    private String memo;

    /**
     * 交易状态，WAIT_BUYER_PAY-交易创 建，等待买家付款 TRADE_CLOSED- 未付款交易超时关闭，或支付完成 后全额退款 TRADE_SUCCESS-交易支付成功，不 可退款 TRADE_FINISHED-交易结束 如为 TRADE_CLOSED 时错误编码和错 误原因放入 sub_code 和 sub_msg 中
     */
    private String status;
    private String modify_time;


}
