package com.yundian.basic.service.impl;

import com.alibaba.fastjson.JSON;
import com.yundian.basic.cache.CodeCache;
import com.yundian.basic.service.CacheService;
import com.yundian.basic.service.SmsService;
import com.yundian.basic.tools.ResultExtendsProvider;
import com.yundian.toolkit.utils.RandomUtil;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Map;

@Service
public class SmsServiceImpl implements SmsService {

	/**
	 * 日志记录类
	 */
	Logger logger = Logger.getLogger(SmsServiceImpl.class);

	@Resource
	private SmsExtendsBusinessImpl smsExtendsService;
	
	@Resource
	private CacheService cacheService;
	
	@Override
	public boolean smsReport(String msgid, String phone, String status) {
		return smsExtendsService.smsReport(msgid, phone, status);
	}
	
	/**
	 *	获取短信验证码（验证码时效内不重新生成新验证码）
	 */
	@Override
	public String sendSmsValidateCode(String phone, String invokeType, String ip) {
		try {
			if (StringUtils.hasLength(phone)) {
				//验证验证码是否少于60s发送一次
				Map<String, String> map = CodeCache.checkValidateCodeFor60s(phone, invokeType, 0, cacheService);
				if(map.get("code").equals("1")){
					return ResultExtendsProvider.getsFailedResult(map.get("message"));
				}
				int sendNum = smsExtendsService.getValidateCodeSendNum(phone, new Date());
				if(sendNum >= 6){
					return ResultExtendsProvider.getsFailedResult("操作过于频繁，稍后再试");
				}
				String code = this.getCode(phone, invokeType, 0);
				//发送验证码
				smsExtendsService.sendSmsValidateCode(phone, code, ip);
				CodeCache.saveValidateCode(phone, invokeType + "_0", code, cacheService);
				return ResultExtendsProvider.getsSuccessResult("验证码已发送");

			} else {
				return ResultExtendsProvider.getsFailedResult("接口sendSmsValidateCode的参数phone为空");

			}
		} catch (Exception e) {
			logger.error(ExceptionUtils.getFullStackTrace(e));
			return ResultExtendsProvider.getsFailedResult("接口sendSmsValidateCode数据处理错误");
		}
	}
	
	/**
	 *	获取语音验证码（验证码时效内不重新生成新验证码）
	 */
	@Override
	public String sendSoundSmsValidateCode(String phone, String invokeType, String ip) {
		try {
			if (StringUtils.hasLength(phone)) {
				//验证验证码是否少于60s发送一次
				Map<String, String> map = CodeCache.checkValidateCodeFor60s(phone, invokeType, 1, cacheService);
				if(map.get("code").equals("1")){
					return ResultExtendsProvider.getsFailedResult(map.get("message"));
				}
				int sendNum = smsExtendsService.getSoundValidateCodeSendNum(phone, new Date());
				if (sendNum >= 6) {
					return ResultExtendsProvider.getsFailedResult("操作过于频繁，稍后再试");
				}
				String code = this.getCode(phone, invokeType, 1);
				//发送语音验证码
				smsExtendsService.sendSoundSmsValidateCode(phone, code, ip);
				CodeCache.saveValidateCode(phone, invokeType + "_1", code, cacheService);
				return ResultExtendsProvider.getsSuccessResult("验证码已发送");
			} else {
				return ResultExtendsProvider.getsFailedResult("接口sendSoundSmsValidateCode的参数phone或code为空");
			}
		} catch (Exception e) {
			logger.error(ExceptionUtils.getFullStackTrace(e));
			return ResultExtendsProvider.getsFailedResult("接口sendSoundSmsValidateCode数据处理错误");
		}
	}
	
	/**
	 *	获取验证码:缓存里读取验证码，读取到发送。没读取到再生成一个验证码,自定义生成验证码位数和验证码成活时间
	 */
	private String getCode(String phone, String invokeType, Integer codeType) {
		String code = null;
		String key = phone + "_" + invokeType + "_" + codeType;
		Object cacheCode = cacheService.get(key);
		if (cacheCode != null) {// 缓存中有验证码
			String[] codeInfo = cacheCode.toString().split("\\|");
			code = codeInfo[0];
		} else {
			//取语音或者文字验证码，和当前状态相反的验证码
			if (codeType == 0) {
				key = phone + "_" + invokeType + "_1";
			}else{
				key = phone + "_" + invokeType + "_0";
			}
			cacheCode = cacheService.get(key);
			if (cacheCode != null) {// 缓存中有验证码
				String[] codeInfo = cacheCode.toString().split("\\|");
				code = codeInfo[0];
			}else{
				// 生成验证码并放入缓存中
				code = RandomUtil.generateRandomNumber(6);
			}
		}
		return code;
	}

	@Override
	public String checkValidateCode(String phone, String invokeType, String code){
		return JSON.toJSONString(CodeCache.checkValidateCode(phone, invokeType, code, cacheService));
	}
	
	/**
	 * 发送验证码
	 * 
	 * @param phone
	 * @return
	 */
	public String sendValidateCode(String phone, String invokeType, String staticConst) {
		try {
			if (StringUtils.hasLength(phone)) {
				//验证验证码是否少于60s发送一次
				Map<String, String> map = CodeCache.checkValidateCodeFor60s(phone, invokeType, 0, cacheService);
				if(map.get("code").equals("1")){
					return ResultExtendsProvider.getsFailedResult(map.get("message"));
				}
				int sendNum = smsExtendsService.getValidateCodeSendNum(phone, new Date());
				if(sendNum >= 6){
					return ResultExtendsProvider.getsFailedResult("操作过于频繁，稍后再试");
				}
				String code = this.getCode(phone, invokeType, 0);
				smsExtendsService.sendValidateCode(phone, code, staticConst);
				CodeCache.saveValidateCode(phone, invokeType + "_0", code, cacheService);
				return ResultExtendsProvider.getsSuccessResult("验证码已发送");
			} else {
				return ResultExtendsProvider.getsFailedResult("接口sendValidateCode的参数phone或invoketype为空");
			}
		} catch (Exception e) {
			logger.error(ExceptionUtils.getFullStackTrace(e));
			return ResultExtendsProvider.getsFailedResult("接口sendValidateCode数据处理错误");
		}
	}

	@Override
	public String sendMessage(String phone, String templatename, String paramjson) {
		try {
			if (StringUtils.hasLength(phone) && StringUtils.hasLength(templatename)) {
				if(templatename.equalsIgnoreCase("validatecode")){
					int sendNum = smsExtendsService.getValidateCodeSendNum(phone, new Date());
					if(sendNum >= 6){
						return ResultExtendsProvider.getsFailedResult("操作过于频繁，稍后再试");
					}
				}
				smsExtendsService.sendMessage(phone, templatename, paramjson);
				return ResultExtendsProvider.getsSuccessResult("验证码已发送");
			} else {
				return ResultExtendsProvider.getsFailedResult("接口sendMessage的参数phone或templatename为空");
			}
		} catch (Exception e) {
			logger.error(ExceptionUtils.getFullStackTrace(e));
			return ResultExtendsProvider.getsFailedResult("接口sendMessage数据处理错误");
		}
	}
 
 

}
