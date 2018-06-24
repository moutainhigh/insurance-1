package com.yundian.fss.pay.withhold.haier.model;

/**
 * 代扣申请返回对象
 *
 * @author jnx
 * @create 2018/6/4
 */
public class HaierTradeBankWitholdingResponse {

    private String out_trade_no;
    private String trade_no;
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
