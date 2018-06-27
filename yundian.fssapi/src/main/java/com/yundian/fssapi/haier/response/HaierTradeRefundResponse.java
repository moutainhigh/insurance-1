package com.yundian.fssapi.haier.response;

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


    public String getOut_trade_no() {
        return this.out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public String getTrade_no() {
        return this.trade_no;
    }

    public void setTrade_no(String trade_no) {
        this.trade_no = trade_no;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
