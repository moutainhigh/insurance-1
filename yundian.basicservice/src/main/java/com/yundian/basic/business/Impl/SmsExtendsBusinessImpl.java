package com.yundian.basic.business.Impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.yundian.basic.dao.ISmsDao;
import com.yundian.basic.dao.ISmsTemplateDao;
import com.yundian.basic.domain.Sms;
import com.yundian.basic.domain.SmsTemplate;
import com.yundian.basic.domain.SmsTemplateValue;
import com.yundian.basic.tools.StaticConst;
import com.yundian.toolkit.utils.StringUtil;

@Service
public class SmsExtendsBusinessImpl extends SmsBusiness {

	Logger logger = Logger.getLogger(SmsExtendsBusinessImpl.class);

	@Autowired
	private ISmsDao iSmsDao;

	private SmsTemplateValue templateValue;

	private static Map<String, String> smsTemplateData;
	
	/**
	 * 
	 * @param msgid
	 * @param phone
	 * @param status
	 * @return
	 */
	public boolean smsReport(String msgid, String phone, String status) {
		Sms sms = iSmsDao.getSmsInfo(msgid);
		if (sms != null) {
			Sms reportSms = new Sms();
			reportSms.setStatus(super.getStatus(status, sms.getChannel()));
			reportSms.setMsgid(sms.getMsgid());
			reportSms.setReport(status);
			reportSms.setReporttime(new Date());
			iSmsDao.updateSmsReport(reportSms);
			return true;
		}
		return false;
	}

	/**
	 * 发送短信验证码
	 * 
	 * @param phone
	 *            手机号
	 * @param code
	 *            验证码数字
	 * @param ip
	 *            客户端IP
	 */
	public void sendSmsValidateCode(String phone, String code, String ip) {
		templateValue = new SmsTemplateValue(phone, null, null, code, null, null);
		sendSms(phone, StaticConst.SMSVALIDATECODE, ip);
	}
	
	/**
	 * 发送语音验证码
	 * 
	 * @param phone:手机号
	 * @param code:验证码数字
	 * @param ip:客户端IP
	 */
	public void sendSoundSmsValidateCode(String phone, String code, String ip) {
		templateValue = new SmsTemplateValue(phone, null, null, code, null, null);
		sendSoundSms(phone, StaticConst.SOUNDVALIDATECODE, ip);
	}
	
	private void sendSoundSms(String phone, String templateType, String ip) {
		String template = getSmsTemplateData(templateType);
		if (template == null) {
			logger.error("template of [" + templateType + "] is empty!");
		}
		if (templateValue == null) {
			logger.error("templateValue is empty!");
		}
		String sms = templateValue.analyzeTemplate(template);
		sendSoundSms(phone, sms, templateValue.getCode(), ip, templateType);
	}
	
	private void sendSoundSms(String phone, String sms, String code, String ip, String smsType) {
		Sms smsData = new Sms();
		smsData.setCode(code);
		smsData.setCtime(new Date());
		smsData.setIp(ip);
		smsData.setPhone(phone);
		smsData.setSms(sms);
		smsData.setStatus(0);
		smsData.setSmstype(smsType);
		iSmsDao.addSmsInfo(smsData);
		String result = "";
		try {
			String[] arrayResult = super.sendSoundSms(phone, sms);
			smsData.setMsgid(arrayResult[1]);
			smsData.setChannel(arrayResult[2]);
			result = arrayResult[0];
		} catch (Exception e) {
			e.printStackTrace();
			result = e.getMessage();
			smsData.setStatus(-1);
		}
		smsData.setResult(result);
		smsData.setSendtime(new Date());
		iSmsDao.updateSmsInfo(smsData);
	}

 

	private void sendSms(String phone, String templateType, String ip) {
		String template = getSmsTemplateData(templateType);
		if (template == null) {
			logger.error("template of [" + templateType + "] is empty!");
		}
		if (templateValue == null) {
			logger.error("templateValue is empty!");
		}
		String sms = templateValue.analyzeTemplate(template);
		Sendsms(phone, sms, templateValue.getCode(), ip, templateType);
	}

	private void Sendsms(String phone, String sms, String code, String ip, String smsType) {
		Sms smsData = new Sms();
		smsData.setCode(code);
		smsData.setCtime(new Date());
		smsData.setIp(ip);
		smsData.setPhone(phone);
		smsData.setSms(sms);
		smsData.setStatus(0);
		smsData.setSmstype(smsType);
		iSmsDao.addSmsInfo(smsData);
		String result = "";
		try {

			String[] arrayResult = super.sendSms(phone, sms);
			smsData.setMsgid(arrayResult[1]);
			smsData.setChannel(arrayResult[2]);
			result = arrayResult[0];

		} catch (Exception e) {
			e.printStackTrace();
			result = e.getMessage();
			smsData.setStatus(-1);
		}
		smsData.setResult(result);
		smsData.setSendtime(new Date());

		// if (smsData.getStatus() == null || smsData.getStatus() == 0) {
		// smsData.setStatus(1);
		// }
		iSmsDao.updateSmsInfo(smsData);
	}

	@Resource
	private ISmsTemplateDao smsTemplateDao;

 

	public SmsTemplateValue getTemplateValue() {
		return templateValue;
	}

	public void setTemplateValue(SmsTemplateValue templateValue) {
		this.templateValue = templateValue;
	}

	/**
	 * 发送验证码
	 * 
	 * @param phone
	 *            手机号
	 * @param code
	 *            验证码
	 */
	public void sendValidateCode(String phone, String code, String staticConst) {
		templateValue = new SmsTemplateValue(phone, null, null, code, null, null);
		sendSms(phone, staticConst, "");
	}

	/**
	 * 电话号码，模板编码，模板参数
	 */
	public void sendMessage(String phone, String templatename, String paramjson) {
		String template = getSmsTemplateData(templatename);
		if (template == null) {
			logger.error("template of [" + templatename + "] is empty!");
		}

		Map<String, String> map = new HashMap<String, String>();

		if (!StringUtil.isBlank(paramjson)) {
			map = jsonToMap(paramjson);
		}
		String sms = generationTemplate(template, map);
		Sendsms(phone, sms, null, "", templatename);
	}

	// 替换模板参数
	private static String generationTemplate(String template, Map<String, String> map) {
		for (Map.Entry<String, String> entry : map.entrySet()) {
			template = template.replaceAll("\\{" + entry.getKey() + "}", entry.getValue());
		}
		return template;
	}

	// JSON转化为MAP
	private static Map<String, String> jsonToMap(String json) {
		HashMap<String, String> data = new HashMap<String, String>();

		JSONObject jsonObject = JSONObject.parseObject(json);
		Iterator<Entry<String, Object>> it = jsonObject.entrySet().iterator();
		while (it.hasNext()) {
			Entry<String, Object> entry = it.next();
			data.put(entry.getKey(), entry.getValue().toString());
		}
		return data;
	}

	public int getValidateCodeSendNum(String phone, Date date) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return iSmsDao.getValidateCodeSendNum(df.format(date), phone, "ValidateCode");
	}
	
	public int getSoundValidateCodeSendNum(String phone, Date date) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return iSmsDao.getValidateCodeSendNum(df.format(date), phone, "SoundValidateCode");
	}

 

	public void sendSmsRegister(String phone, String password, String ip) {
		templateValue = new SmsTemplateValue(phone, password, null, null, null, null);
		sendSms(phone, StaticConst.SMSREGISTER, ip);
	}

	public String getSmsTemplateData(String key) {
		if (smsTemplateData == null){
			System.out.println("初始化系统配置表sms_template");
			smsTemplateData = new HashMap<String, String>();
			List<SmsTemplate> smsTemplateList = smsTemplateDao.getSmsTemplate();
			System.out.println(String.format("共获取%s条数据", smsTemplateList.size()));
			for (SmsTemplate sysTemplate : smsTemplateList) {
				smsTemplateData.put(sysTemplate.getTemplatetype(), sysTemplate.getTemplate());
			}
		}
		return smsTemplateData.get(key);
	}

	// public static void main(String[] args) {
	// String template =
	// "【车果网】亲爱的{name}{sex}：您的车贷申请已提交，并已成功帮您开户，登录账号为您申请的手机号码，密码为{password}，后续客户经理会主动联系到您，请保持手机畅通，您也可以登录后查看申请进度，谢谢！";
	// String params = "{\"name\":\"张三\",\"sex\":\"先生\",\"password\":\"22万元\"}";
	// System.out.println(template);
	// System.out.println(params);
	//
	// Map<String, String> map = jsonToMap(params);
	// System.out.println(map.get("name"));
	// // generationTemplate(template, map)
	// }
	
}
