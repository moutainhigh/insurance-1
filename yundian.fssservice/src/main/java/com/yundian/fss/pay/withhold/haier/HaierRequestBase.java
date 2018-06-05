//package com.yundian.fss.pay.withhold.haier;
//
//import com.alibaba.dubbo.common.json.JSON;
//import com.alibaba.fastjson.JSONObject;
//import com.kjtpay.gateway.common.util.security.SecurityService;
//import com.yundian.basic.service.SysConfigService;
//import com.yundian.fss.pay.withhold.haier.annotation.AnnotationValue;
//import com.yundian.toolkit.utils.DateUtils;
//import com.yundian.toolkit.utils.HttpClientUtil;
//import com.yundian.toolkit.utils.RandomUtil;
//import org.apache.commons.collections.map.HashedMap;
//import org.apache.commons.collections.map.LinkedMap;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.lang.reflect.Field;
//import java.time.LocalDate;
//import java.time.LocalTime;
//import java.util.Date;
//import java.util.LinkedHashMap;
//import java.util.Map;
//
///**
// * 快捷通接口基础类
// *
// * @author jnx
// * @create 2018/6/1
// */
//public abstract class HaierRequestBase {
//
////    @Autowired
//    SecurityService securityService;
//
//    private String url;
//    /**
//     * 请求号，字母数字下划线，确保每次请求唯一
//     */
//    private String requestNo;
//    /**
//     * 接口名称
//     */
//    private String service;
//
//    private String version="1.0";
//
//    /**
//     * 签约后分配的快捷通平 台(商户)ID，非平台则使 用商户 ID
//     */
//    private String partnerId;
//
//    private String charset="UTF-8";
//
//    private String sign;
//
//    private String signType="ITRUS";
//    private String timestamp;
//
//    private String format="JSON";
//    private String bizContent;
//
//
//    public abstract  String getService();
//
//
//    public  HaierResult post(){
//
//        Map<String, String> param =new LinkedHashMap();
//        String requestNo =DateUtils.formatString(new Date(),"yyyyMMddHHmmssSS")+ RandomUtil.generateRandomNumber(4);
//        param.put("request_no",requestNo);
//        param.put("service",getService());
//        param.put("version",version);
//        param.put("partner_id",partnerId);
//        param.put("charset",charset);
//        param.put("timestamp", DateUtils.formatString(new Date(),"yyyy-MM-dd HH:mm:ss"));
//        param.put("format",format);
//        //初始bizContent
//        bizContent="";
//
//         Field[] fields =this.getClass().getDeclaredFields();
//        JSONObject jsonObject = new JSONObject();
//         for(Field m :fields){
//             AnnotationValue annotationValue= m.getAnnotation(AnnotationValue.class);
//             if(annotationValue!=null){
//                 try {
//                     jsonObject.put(annotationValue.value(), m.get(this));
//                 }catch (Exception e){
//                     System.out.println("获取字段值失败，"+e.getMessage());
//                 }
//             }
//         }
//        bizContent = jsonObject.toString();
//        String bizContentEncrypt = securityService.encrypt(bizContent,charset);
//        param.put("biz_content",bizContentEncrypt);
//        String sign = securityService.sign(param,charset);
//        param.put("sign",sign);
//        param.put("sign_type",signType);
//        try {
//            String result = HttpClientUtil.sendSSLPost2(url, param);
//            return JSON.parse(result,HaierResult.class);
//        }catch (Exception e){
//            System.out.printf("调用快捷通接口失败，"+e.getMessage());
//        }
//        return null;
//    }
//}
