package com.yundian.fssapi.haier.notify.param;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * 快捷通代扣异步通知对象
 * @author jnx
 * @create 2018/6/22
 */
public class WitholdingNotifyParam implements Serializable{

    /**
     * 通知的唯一标识
     */
    private String notify_id;
    /**
     * 通知类型，交易通知此字段为:trade_status_sync
     */
    private String notify_type;
    /**
     * 通知时间：20091225091010
     */
    private String notify_time;
    /**
     * UTF-8
     */
    private String _input_charset;
    /**
     * 对报文摘要的签名
     */
    private String sign;
    /**
     * 签名方式
     */
    private String sign_type;
    /**
     * 接口版本号
     */
    private String version;
    /**
     * 商户唯一订单号
     */
    private String outer_trade_no;
    /**
     * 快捷通订单号
     */
    private String inner_trade_no;
    /**
     * 交易状态
     *
     * TRADE_SUCCESS
     交易成功，用户付款成功
     TRADE_FINISHED
     交易结束，付款金额已结算给商户
     TRADE_CLOSED
     交易关闭，交易失败
     */
    private String trade_status;


    /**
     * 交易金额，单位为:RMB 元
     */
    private String trade_amount;
    /**
     * 交易修改时间：20091225091010
     */
    private String gmt_create;
    /**
     * 交易支付时间
     */
    private String gmt_payment;
    /**
     * 交易关闭时间
     */
    private String gmt_close;
    /**
     * 失败原因
     */
    private String failReason;


    /**
     * 获取参与验签的参数
     * @return
     */
    public Map<String,String> getSignMap(){
        Map<String,String> map = new HashMap<>(5);
        Field[] fields = this.getClass().getDeclaredFields();
        for(Field field:fields){
            field.setAccessible(true);
            try {
                if(!field.getName().equals("sign")&&!field.getName().equals("sign_type")) {
                    map.put(field.getName(), field.get(this) == null ? "" : field.get(this).toString());
                }
            }catch (IllegalAccessException e){
                System.out.println("WitholdingNotifyRequest getSignMap error, "+e.getMessage());
            }

        }
        return map;
    }

    public String getNotify_id() {
        return this.notify_id;
    }

    public void setNotify_id(String notify_id) {
        this.notify_id = notify_id;
    }

    public String getNotify_type() {
        return this.notify_type;
    }

    public void setNotify_type(String notify_type) {
        this.notify_type = notify_type;
    }

    public String getNotify_time() {
        return this.notify_time;
    }

    public void setNotify_time(String notify_time) {
        this.notify_time = notify_time;
    }

    public String get_input_charset() {
        return this._input_charset;
    }

    public void set_input_charset(String _input_charset) {
        this._input_charset = _input_charset;
    }

    public String getSign() {
        return this.sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getSign_type() {
        return this.sign_type;
    }

    public void setSign_type(String sign_type) {
        this.sign_type = sign_type;
    }

    public String getVersion() {
        return this.version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getOuter_trade_no() {
        return this.outer_trade_no;
    }

    public void setOuter_trade_no(String outer_trade_no) {
        this.outer_trade_no = outer_trade_no;
    }

    public String getInner_trade_no() {
        return this.inner_trade_no;
    }

    public void setInner_trade_no(String inner_trade_no) {
        this.inner_trade_no = inner_trade_no;
    }

    public String getTrade_status() {
        return this.trade_status;
    }

    public void setTrade_status(String trade_status) {
        this.trade_status = trade_status;
    }

    public String getTrade_amount() {
        return this.trade_amount;
    }

    public void setTrade_amount(String trade_amount) {
        this.trade_amount = trade_amount;
    }

    public String getGmt_create() {
        return this.gmt_create;
    }

    public void setGmt_create(String gmt_create) {
        this.gmt_create = gmt_create;
    }

    public String getGmt_payment() {
        return this.gmt_payment;
    }

    public void setGmt_payment(String gmt_payment) {
        this.gmt_payment = gmt_payment;
    }

    public String getGmt_close() {
        return this.gmt_close;
    }

    public void setGmt_close(String gmt_close) {
        this.gmt_close = gmt_close;
    }

    public String getFailReason() {
        return this.failReason;
    }

    public void setFailReason(String failReason) {
        this.failReason = failReason;
    }
}
