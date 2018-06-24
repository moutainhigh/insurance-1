package com.yundian.fss.pay.withhold.haier;

/**
 * 返回结果对象
 *
 * @author jnx
 * @create 2018/6/1
 */
public class HaierResult<T> {

    private String code;

    private String msg;

    private String sub_code;

    private String sub_msg;

    private String sign;

    private String sign_type;

    private String charset;

    private T biz_content;


    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getSub_code() {
        return this.sub_code;
    }

    public void setSub_code(String sub_code) {
        this.sub_code = sub_code;
    }

    public String getSub_msg() {
        return this.sub_msg;
    }

    public void setSub_msg(String sub_msg) {
        this.sub_msg = sub_msg;
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

    public String getCharset() {
        return this.charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public T getBiz_content() {
        return this.biz_content;
    }

    public void setBiz_content(T biz_content) {
        this.biz_content = biz_content;
    }
}
