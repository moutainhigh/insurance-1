package com.yundian.fssapi.haier.notify.param;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * 快捷通退款异步通知对象
 * @author jnx
 * @create 2018/6/22
 */
public class RefundNotifyParam implements Serializable{

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
     * 原交易商户网站唯一订单号
     */
    private String orig_outer_trade_no;
    /**
     * 快捷通退款交易订单号
     */
    private String inner_trade_no;

    /**
     * 商户网站退款唯一订单
     */
    private String outer_trade_no;
    /**
     * 交易状态
     *
     * REFUND_SUCCESS 退款成功
        REFUND_FAIL 退款失败
     */
    private String refund_status;


    /**
     * 退款金额，单位为:RMB 元。
     */
    private String refund_amount;
    /**
     * 交易退款时间：20091225091010
     */
    private String gmt_refund;

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

    public String getOrig_outer_trade_no() {
        return this.orig_outer_trade_no;
    }

    public void setOrig_outer_trade_no(String orig_outer_trade_no) {
        this.orig_outer_trade_no = orig_outer_trade_no;
    }

    public String getInner_trade_no() {
        return this.inner_trade_no;
    }

    public void setInner_trade_no(String inner_trade_no) {
        this.inner_trade_no = inner_trade_no;
    }

    public String getOuter_trade_no() {
        return this.outer_trade_no;
    }

    public void setOuter_trade_no(String outer_trade_no) {
        this.outer_trade_no = outer_trade_no;
    }

    public String getRefund_status() {
        return this.refund_status;
    }

    public void setRefund_status(String refund_status) {
        this.refund_status = refund_status;
    }

    public String getRefund_amount() {
        return this.refund_amount;
    }

    public void setRefund_amount(String refund_amount) {
        this.refund_amount = refund_amount;
    }

    public String getGmt_refund() {
        return this.gmt_refund;
    }

    public void setGmt_refund(String gmt_refund) {
        this.gmt_refund = gmt_refund;
    }
}
