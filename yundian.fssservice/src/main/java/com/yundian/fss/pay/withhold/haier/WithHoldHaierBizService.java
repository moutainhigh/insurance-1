//package com.yundian.fss.pay.withhold.haier;
//
//import com.alibaba.fastjson.JSON;
//import com.kjtpay.gateway.common.domain.VerifyResult;
//import com.kjtpay.gateway.common.util.security.SecurityService;
//import com.sun.org.apache.xpath.internal.operations.Bool;
//import com.yundian.fssapi.exception.FssRepaymentException;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.util.Map;
//
///**
// * 快捷通代扣
// *
// * @author jnx
// * @create 2018/5/31
// */
//@Slf4j
//@Component("withHoldHaierBizService")
//public class WithHoldHaierBizService {
//
////    @Autowired
//    SecurityService securityService;
//    public static final String BIZ_CONTENT_KEY="biz_content";
//
//    public static final String SIGN_TYPE_KEY="sign_type";
//
//    public static final String CHARSET_KEY="charset";
//
//
//
//    /**
//     *提交代扣网关
//     */
//    public void tradeBankWithHolding(){
///*
//  提交参数：
// {"bank_code":"BOC","payee_identity_type":"1","bank_card_no":"******","notify_ur l":"http://127.0.0.1:8082/AlphaTest/gateway/asyncNotify.do","pay_product_code": "61","bank_account_name":"泮 **","biz_product_code":"20204","authorize_no":"","out_trade_no":"20170929101955 62576670268365","payee_identity":"200000058825","token_id":"","certificates_num ber":"******","phone_num":"******","currency":"CNY","certificates_type":"01","p ayable_amount":"0.33"}
// 返回参数：
//    {"code":"S10000","msg":"接口调用成功","sign":"快捷通返回的签名值 ","charset":"UTF-8","sign_type":"ITRUS","biz_content":{"out_trade_no":"20170929 10195562576670268365","trade_no":"101150665163804546208","status":"S","pay_time ":"2017-09-29 10:20:42","return_time":"2017-09-29 10:20:42"}}
// */
//
//    }
//
//    /**
//     * 批量提交
//     */
//    public void batchTradeBankWithHolding(){
//
//    }
//
//
//    /**
//     * 退款网关
//     */
//    public void tradeRefund(){
//
//    }
//
//    /**
//     * 交易查询
//     */
//    public void   tradeQuery(){
//
//    }
//
//    /**
//     * 验签
//     */
//    public Boolean verify(Map<String, String> param, String sign){
//
//        VerifyResult verifyResult =null;
//        String bizContent = param.get(BIZ_CONTENT_KEY)==null ? null : JSON.toJSONString(param.get(BIZ_CONTENT_KEY));
//        param.remove(BIZ_CONTENT_KEY);
//        param.put(BIZ_CONTENT_KEY, bizContent);
//
//        String signType = param.get(SIGN_TYPE_KEY);
//        String charset = param.get(CHARSET_KEY);
//
//        try {
//            if ("RSA".equals(signType)) {
//                //RSA验签
//                verifyResult = securityService.verify(param, sign, charset);
//            } else if ("ITRUS".equals(signType)) {
//                verifyResult = securityService.verify(param, sign, charset);
//            }
//            return verifyResult.isSuccess();
//        }catch (Exception e )
//        {
//            log.error("快捷通验签失败!,param:"+ JSON.toJSONString(param)+",sign:"+sign);
//            throw new FssRepaymentException("","快捷通验签失败！");
//        }
//
//    }
//
//}
