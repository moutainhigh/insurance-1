package com.yundian.basic.business.Impl;

import java.net.URLEncoder;

import com.yundian.basic.business.ISmsExecutor;
import com.yundian.basic.business.Impl.SmsBusiness.SmsChannel;
import com.yundian.basic.tools.SmsPropertiesUtil;
import com.yundian.toolkit.utils.HttpClientUtil;
import com.yundian.toolkit.utils.MD5;

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

		StringBuffer builder = new StringBuffer();
		builder.append("username=" + this.username);
		builder.append("&password="
				+ MD5.encodePassword(this.password).toLowerCase());
		builder.append("&mobile=" + phone);
		builder.append("&content=" + URLEncoder.encode(sms, "UTF-8"));
		builder.append("&dstime=" + dstime);
		builder.append("&productid=" + productid);
		builder.append("&xh=");
		String result = HttpClientUtil.sendGet(url, builder.toString(), "utf-8");
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
