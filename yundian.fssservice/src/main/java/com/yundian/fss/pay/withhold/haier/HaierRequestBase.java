package com.yundian.fss.pay.withhold.haier;

import com.alibaba.dubbo.common.json.JSON;
import com.alibaba.fastjson.JSONObject;
import com.kjtpay.gateway.common.util.security.SecurityService;
import com.yundian.basic.service.SysConfigService;
import com.yundian.fss.pay.withhold.haier.annotation.AnnotationValue;
import com.yundian.toolkit.utils.DateUtils;
import com.yundian.toolkit.utils.HttpClientUtil;
import com.yundian.toolkit.utils.MapUtil;
import com.yundian.toolkit.utils.RandomUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.collections.map.LinkedMap;
import org.apache.http.client.utils.URLEncodedUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 快捷通接口基础类
 *
 * @author jnx
 * @create 2018/6/1
 */
@Slf4j
public abstract class HaierRequestBase {

    @Autowired
    SecurityService securityService;

    @Value("${kjt.gateWay}")
    private String url;
    /**
     * 请求号，字母数字下划线，确保每次请求唯一
     */
    private String requestNo;
    /**
     * 接口名称
     */
    private String service;

    private String version="1.0";

    /**
     * 签约后分配的快捷通平 台(商户)ID，非平台则使 用商户 ID
     */
    @Value("${kjt.partnerId}")
    private String partnerId;

    private String charset="UTF-8";

    private String sign;

    private String signType="RSA";
    private String timestamp;

    private String format="JSON";
    private String bizContent;
    /**
     * 请求号，字母数字下划线，确保每次请求唯一
     */
    public abstract String getRequestNo();

    public abstract  String getService();

    private final static String separator="&";

    public  HaierResult post(){

        Map<String, String> param =new LinkedHashMap();
        param.put("request_no",getRequestNo());
        param.put("service",getService());
        param.put("version",version);
        param.put("partner_id",partnerId);
        param.put("charset",charset);
        param.put("timestamp", DateUtils.formatString(new Date(),"yyyy-MM-dd HH:mm:ss"));
        param.put("format",format);
        //初始bizContent
        bizContent="";

         Field[] fields =this.getClass().getDeclaredFields();
        JSONObject jsonObject =  new JSONObject();
         for(Field m :fields){
             m.setAccessible(true);
             AnnotationValue annotationValue= m.getAnnotation(AnnotationValue.class);
             if(annotationValue!=null){
                 try {
                     jsonObject.put(annotationValue.value(), m.get(this)==null?"":m.get(this).toString());
                 }catch (Exception e){
                     System.out.println("获取字段值失败，"+e.getMessage());
                 }
             }
         }
        log.info("请求代扣申请：URL="+url);
        log.info("请求：bizContent="+jsonObject.toJSONString());
        String bizContentEncrypt ="";
         bizContentEncrypt = securityService.encrypt(jsonObject.toJSONString(), charset);
        param.put("biz_content",bizContentEncrypt);
        String sign = securityService.sign(param,charset);
        param.put("sign",sign);
        param.put("sign_type",signType);
        log.info("请求：param="+ com.alibaba.fastjson.JSON.toJSONString(param));
        try {

            for(Map.Entry entry:param.entrySet()){
                entry.setValue(URLEncoder.encode(entry.getValue()==null?"":entry.getValue().toString(),"utf-8"));
            }
            log.info("请求 encode param="+ com.alibaba.fastjson.JSON.toJSONString(param));
            String result = HttpClientUtil.sendSSLPost2(url, param);
            return JSON.parse(result,HaierResult.class);
        }catch (Exception e){
            System.out.printf("调用快捷通接口失败，"+e.getMessage());
        }
        return null;
    }
}
