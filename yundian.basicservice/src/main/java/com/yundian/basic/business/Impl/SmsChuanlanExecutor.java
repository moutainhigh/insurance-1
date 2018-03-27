package com.yundian.basic.business.Impl;

import java.net.URLEncoder;

import com.yundian.basic.business.ISmsExecutor;
import com.yundian.basic.business.Impl.SmsBusiness.SmsChannel;
import com.yundian.basic.tools.SmsPropertiesUtil;
import com.yundian.toolkit.utils.HttpClientUtil;

public class SmsChuanlanExecutor implements ISmsExecutor{


	/**
	 * 应用地址，类似于http://ip:port/msg/
		 http://222.73.117.158/msg/HttpBatchSendSM
	 */
	private String url = SmsPropertiesUtil.readValue("sms.cl.url");  //"http://222.73.117.158/msg/HttpBatchSendSM";
	 /**
	  *  account 账号
	  */
	private String account = SmsPropertiesUtil.readValue("sms.cl.username");//"jiekou-clcs-16";
	/**
	 * 密码
	 */
	private String pswd = SmsPropertiesUtil.readValue("sms.cl.password");//"Tch123456";
	
	/**
	  *  语音账号
	  */
	private String account_sound = SmsPropertiesUtil.readValue("sms.cl.sound.username");//"yuyin-clcs-16";
	
	/**
	 * 语音账号密码
	 */
	private String pswd_sound = SmsPropertiesUtil.readValue("sms.cl.sound.password");//"Tch123456";

	/**
	 * 是否需要状态报告，需要true，不需要false
	 */
	private String needstatus = String.valueOf(true);

	/**
	 * 可选参数。用户订购的产品id，不填写（针对老用户）系统采用用户的默认产品，用户订购多个产品时必填，否则会发生计费错误。
	 */
	private String product = "";
	/**
	 * 可选参数，扩展码，用户定义扩展码，3位
	 */
	private String extno = "";

	/**
	 * 短信发送
	 * 
	 * @return
	 * @throws Exception
	 */
	@Override
	public String[] sendSms(String phone, String sms) throws Exception {
		
		StringBuffer builder = new StringBuffer();
		builder.append("account=" + account);
		builder.append("&pswd="
				+ pswd);
		builder.append("&mobile=" + phone);
		builder.append("&msg=" + URLEncoder.encode(sms, "UTF-8"));
		builder.append("&needstatus=" + needstatus);
		builder.append("&product=" + product);
		builder.append("&extno="+extno);
		String result= HttpClientUtil.sendGet(url, builder.toString(), "utf-8");
		//20151209112013,0\n
		//1001209112013849000\n
		String msgid = result.split("\n").length>1?result.split("\n")[1]:"";
		return new String[]{result,msgid,getChannel()};
	}
	
	@Override
	public String[] sendSoundSms(String phone, String sms) throws Exception {
		StringBuffer builder = new StringBuffer();
		builder.append("account=" + account_sound);
		builder.append("&pswd=" + pswd_sound);
		builder.append("&mobile=" + phone);
		builder.append("&msg=" + URLEncoder.encode(sms, "UTF-8"));
		builder.append("&needstatus=" + needstatus);
		builder.append("&product=" + product);
		builder.append("&extno=" + extno);
		String result = HttpClientUtil.sendGet(url, builder.toString(), "utf-8");
		String msgid = result.split("\n").length > 1 ? result.split("\n")[1] : "";
		return new String[] { result, msgid, getChannel() };
	}
	
	@Override
	public String[] smsReport(String report) {
		return null;
	}
 
	@Override
	public String getChannel() {
		 return SmsChannel.CHANNEL_CHUANLAN;
	}

	public static void main(String[] args) {
		try {
			SmsChuanlanExecutor sms = new SmsChuanlanExecutor();
			String[] result = sms.sendSms("13758298275", "监控服务IChooseCarService.getCarBrandsByFirstChar,发生告警,尽快处理,时间:2016-06-20 20:13:46 ");
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPswd() {
		return pswd;
	}

	public void setPswd(String pswd) {
		this.pswd = pswd;
	}

	 

	public String getNeedstatus() {
		return needstatus;
	}

	public void setNeedstatus(String needstatus) {
		this.needstatus = needstatus;
	}

	 

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getExtno() {
		return extno;
	}

	public void setExtno(String extno) {
		this.extno = extno;
	}

	public String getAccount_sound() {
		return account_sound;
	}

	public void setAccount_sound(String account_sound) {
		this.account_sound = account_sound;
	}

	public String getPswd_sound() {
		return pswd_sound;
	}

	public void setPswd_sound(String pswd_sound) {
		this.pswd_sound = pswd_sound;
	}
	
}
