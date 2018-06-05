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
    private String pay_time;
    private String return_time;


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

    public String getPay_time() {
        return this.pay_time;
    }

    public void setPay_time(String pay_time) {
        this.pay_time = pay_time;
    }

    public String getReturn_time() {
        return this.return_time;
    }

    public void setReturn_time(String return_time) {
        this.return_time = return_time;
    }
}
