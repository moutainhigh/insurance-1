package com.yundian.file.utils;

import javax.ws.rs.core.MultivaluedMap;

import org.apache.log4j.Logger;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.core.util.MultivaluedMapImpl;


public class BaiduMapProvider {

    private final static String BIDU_URL = "http://api.map.baidu.com/geocoder/v2/";
    private final static String BIDU_AK = "PA7ucQsHjU69kXRIBpupF69O";
    
    private static final Logger LOGGER = Logger.getLogger(BaiduMapProvider.class);

    /**
     * 根据百度地图api转换地址
     *
     * @param location 纬度,经度
     * @return
     */
    public static String transformatLocation(String location) {
        //java.util.concurrent.ArrayBlockingQueue<String> queue = new ConcurrentLinkedQueue<String>();
        if (!StringUtils.hasLength(location) || location.indexOf("null") >= 0) {
            return "未获取到GPS信号，无法定位。";
        } else {
            MultivaluedMap<String, String> param = new MultivaluedMapImpl();
            param.add("output", "json");
            param.add("ak", BIDU_AK);
            param.add("location", location);
            // param.add("coordtype", "bd09mc");

            try {
                ClientConfig cc = new DefaultClientConfig();
                cc.getProperties().put(ClientConfig.PROPERTY_CONNECT_TIMEOUT, 1000);
                ClientResponse response = Client.create(cc).resource(BIDU_URL).post(ClientResponse.class, param);

                if (response.getStatus() != 200) {
                    LOGGER.warn("百度地址转换结果异常状态:" + response.getStatus());
                }
                String result = response.getEntity(String.class);
                JSONObject json = JSON.parseObject(result);
                if (json == null) LOGGER.error("百度地址转换结果异常(json=null):" + result);

                if (json.getInteger("status") == 0) {
                    return json.getJSONObject("result").getString("formatted_address");
                } else {
                    LOGGER.warn("百度地址转换结果异常:" + json);
                    String[] lr = location.split(",");
                    return "经度：" + lr[1] + " 纬度：" + lr[0] + " 未成功解析地址。";
                }

            } catch (Exception e) {
                LOGGER.error("百度地址转换失败", e);
                String[] lr = location.split(",");
                return "经度：" + lr[1] + " 纬度：" + lr[0] + " 未成功解析地址。";
            }
        }
    }
}
