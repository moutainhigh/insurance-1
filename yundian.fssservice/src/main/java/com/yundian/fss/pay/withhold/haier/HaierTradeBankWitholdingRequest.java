//package com.yundian.fss.pay.withhold.haier;
//
//import com.alibaba.fastjson.JSON;
//import com.yundian.fss.pay.withhold.haier.annotation.AnnotationValue;
//import com.yundian.fss.pay.withhold.haier.model.HaierTradeBankWitholdingResponse;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//
///**
// * 代扣网关接口
// *
// * @author jnx
// * @create 2018/6/4
// */
//@Slf4j
//@Component("haierTradeBankWitholdingRequest")
//public class HaierTradeBankWitholdingRequest extends HaierRequestBase {
//
//    /**
//     *平台(商户) 订单号，字 母数字下划 线，确保每 笔订单唯一
//     */
//    @AnnotationValue("out_trade_no")
//    private String outTradeNo;
//    /**
//     *银行卡账户名，不能包含数字
//     */
//    @AnnotationValue("bank_account_name")
//    private String bankAccountName;
//    /**
//     *证件类型,01默认身份证
//     */
//    @AnnotationValue("certificates_type")
//    private String certificatesType="01";
//    /**
//     *证件号码，身份证
//     */
//    @AnnotationValue("certificates_number")
//    private String certificatesNumber;
//    /**
//     *银行卡号， 字母数字
//     */
//    @AnnotationValue("bank_card_no")
//    private String bankCardNo;
//    /**
//     *银行编码， 字母：ICBC
//     */
//
//    @AnnotationValue("bank_code")
//    private String bankCode;
//    /**
//     *协议号，字母数字下划线，当协议号非空时，以协议号匹配的信息为准
//     */
//    @AnnotationValue("token_id")
//    private String tokenId;
//    /**
//     *交易金额， 15 位以内最 大保留2位 精度数字
//     */
//    @AnnotationValue("payable_amount")
//    private String payableAmount;
//    /**
//     *币种，默认 人民币 CNY[否]
//     */
//    @AnnotationValue("currency")
//    private String currency="CNY";
//    /**
//     *代扣授权号[否]
//     */
//    @AnnotationValue("authorize_no")
//    private String authorizeNo;
//    /**
//     *入款快捷通 会员标识类 型，默认 1 1-快捷通会 员ID 2-快捷通会员登录号[否]
//     */
//    @AnnotationValue("payee_identity_type")
//    private String payeeIdentityType="1";
//    /**
//     *入款账号
//     */
//    @AnnotationValue("payee_identity")
////    @Value("${witholding.haier.payeeIdentity}")
//    private String payeeIdentity;
//    /**
//     *润账号 集，最多支 持10个分润 账号
//     */
//    @AnnotationValue("royalty_info")
//    private String royaltyInfo;
//    /**
//     *业务产品码 20204-银行 卡代扣
//     */
//    @AnnotationValue("biz_product_code")
//    private String bizProductCode="20204";
//    /**
//     *支付产品码 61-银行卡 代扣-借记 卡 62-银行卡 代扣-信用 卡 63-银行卡 代扣-对公
//     */
//    @AnnotationValue("pay_product_code")
//    private String payProductCode="61";
//    /**
//     *手机号码
//     */
//    @AnnotationValue("phone_num")
//    private String phoneNum;
//    /**
//     *服务器异步 通知地址
//     */
//    @AnnotationValue("notify_url")
////    @Value("${witholding.haier.notifyUrl}")
//    private String notifyUrl;
//
//
//
//
//
//    @Override
//    public String getService() {
//        return "trade_bank_witholding";
//    }
//
//
//    /**
//     * 提交银行卡代扣申请
//     * @param outTradeNo 订单号
//     * @param bankAccountName 银行卡账号名称
//     * @param bankCardNo 银行卡号
//     * @param certificatesNumber 身份证号码
//     * @param payableAmount 金额，保留小数点后两位，单位:元
//     * @return
//     */
//    public HaierResult<HaierTradeBankWitholdingResponse> invoke(String outTradeNo, String bankAccountName, String bankCardNo,
//                                                              String certificatesNumber, String payableAmount){
//        log.info("调用代扣申请接口:outTradeNo = [" + outTradeNo + "], bankAccountName = [" + bankAccountName + "], bankCardNo = [" + bankCardNo + "], certificatesNumber = [" + certificatesNumber + "], payableAmount = [" + payableAmount + "]");
//        this.outTradeNo = outTradeNo;
//        this.bankAccountName = bankAccountName;
//        this.bankCardNo = bankCardNo;
//        this.certificatesNumber = certificatesNumber;
//        this.payableAmount = payableAmount;
//        HaierResult<HaierTradeBankWitholdingResponse> haierResult= post();
//        log.info("返回结果："+ JSON.toJSONString(haierResult));
//        return haierResult;
//    }
//
//
//}
