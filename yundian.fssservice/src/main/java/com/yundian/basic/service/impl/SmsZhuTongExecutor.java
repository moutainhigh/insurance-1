package com.yundian.basic.service.impl;

import com.yundian.basic.business.ISmsExecutor;
import com.yundian.basic.tools.SmsPropertiesUtil;
import com.yundian.toolkit.utils.HttpClientUtil;
import com.yundian.toolkit.utils.MD5;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class SmsZhuTongExecutor implements ISmsExecutor{

	private String url = SmsPropertiesUtil.readValue("sms.zt.url");;
	private String username = SmsPropertiesUtil.readValue("sms.zt.username");
	private String password = SmsPropertiesUtil.readValue("sms.zt.password");
	private String productid = SmsPropertiesUtil.readValue("sms.zt.productid");
	private String dstime ="";


	/**
	 * 短信发送
	 *
	 * @return
	 * @throws Exception
	 */
	public String[] sendSms(String phone, String sms) throws Exception {


        Map<String,String> param = new HashMap<>();
        param.put("username",this.username);
        param.put("password",MD5.encodePassword(this.password).toLowerCase());
        param.put("mobile",phone);
        param.put("content",URLEncoder.encode(sms, "UTF-8"));
        param.put("dstime",dstime);
        param.put("productid",productid);
        param.put("xh","");
        String result= HttpClientUtil.sendGet(url, param);

		//1,201512091113076736[20151210190224,101]
		String msgid = result.split(",").length>1?result.split(",")[1]:"";
		return new String[]{result,msgid,getChannel()};
	}

	@Override
	public String[] sendSoundSms(String phone, String sms) throws Exception {
		return null;
	}

	@Override
	public String[] smsReport(String report) {
		//msgid=xxxxx&mobile=xxxxxx&status=xxxxxxx


		return null;
	}

	@Override
	public String getChannel() {
		 return SmsChannel.CHANNEL_ZHUTONG;
	}
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getProductid() {
		return productid;
	}

	public void setProductid(String productid) {
		this.productid = productid;
	}

	public String getDstime() {
		return dstime;
	}

	public void setDstime(String dstime) {
		this.dstime = dstime;
	}

}
