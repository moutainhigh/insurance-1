package com.yundian.basic.cache;


import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.ResultContext;

import com.yundian.basic.service.CacheService;
import com.yundian.result.ResultCodeContants;
import com.yundian.result.ResultProvider;

public class CodeCache {
	
	/**
	 * 1分钟频率
	 */
	private static final long timespan = 1 * 60 * 1000;
	
	/**
	 * 验证码存活时间(单位:秒)
	 */
	private final static long VALIDCODELIVETIME = 1800;
	
	/**
	 * 验证验证码是否少于60s发送一次
	 * @param phone 手机号码
	 * @param invokeType 调用类型
	 */
	public static Map<String, String> checkValidateCodeFor60s(String phone, String invokeType, Integer codeType, CacheService cachService){
		Map<String, String> result = new HashMap<String, String>(); 
		long currentTime = System.currentTimeMillis() - timespan;
		String key = phone + "_" + invokeType + "_" + codeType;
		Object cacheCode = cachService.get(key);
		if(cacheCode != null){
			String[] codeInfo = cacheCode.toString().split("\\|");
			if(Long.valueOf(codeInfo[1]).longValue() > currentTime){
				result.put("code", "1");
				result.put("message", "60s内仅能获取一次验证码，请稍后再试");
				return result;
			}
		}
//		else{
//			//取语音或者文字验证码，和当前状态相反的验证码
//			if (codeType == 0) {
//				key = phone + "_" + invokeType + "_1";
//			}else{
//				key = phone + "_" + invokeType + "_0";
//			}
//			cacheCode = cachService.get(key);
//			if(cacheCode != null){
//				String[] codeInfo = cacheCode.toString().split("\\|");
//				if(Long.valueOf(codeInfo[1]).longValue() > currentTime){
//					result.put("code", "1");
//					result.put("message", "60s内仅能获取一次验证码，请稍后再试");
//					return result;
//				}
//			}
//		}
		result.put("code", "0");
		result.put("message", "success");
		return result;
	}
	
	
	/**
	 * 保存验证码到缓存中
	 * @param phone 手机号码
	 * @param invokeType 调用类型
	 * @param code 验证码
	 */
	public static void saveValidateCode(String phone, String invokeType, String code, CacheService cachService){
		String key = phone + "_" + invokeType;
		Object value = code + "|" + String.valueOf(System.currentTimeMillis());
		cachService.set(key, value, VALIDCODELIVETIME);
	}
	
	/**
	 * 保存验证码到缓存中
	 * @param phone 手机号码
	 * @param invokeType 调用类型
	 * @param code 验证码
	 * @param validcodelivetime 验证码存活时间(单位:秒)
	 */
	public static void saveValidateCode(String phone, String invokeType, String code, CacheService cachService, long validcodelivetime){
		String key = phone + "_" + invokeType;
		Object value = code + "|" + String.valueOf(System.currentTimeMillis());
		cachService.set(key, value, validcodelivetime);
	}
	
	/**
	 * 检验验证码是否正确
	 * @param phone 手机号码
	 * @param invokeType 调用类型
	 * @param code 验证码
	 * @return
	 */
	public static Map<String, Object> checkValidateCode(String phone, String invokeType, String code, CacheService cachService){
		Map<String, Object> result = new HashMap<String, Object>(); 
		//获取验证码
		String key = phone + "_" + invokeType;
		
		String txtKey = key + "_0";
		String soundKey = key + "_1";
		Object cacheCode = cachService.get(txtKey);
		
		if(cacheCode == null){
			cacheCode = cachService.get(soundKey);
		}
		
		if(cacheCode != null){
			long currentTime = System.currentTimeMillis();
			//验证码存活时间为半个小时
			currentTime = currentTime - 30 * 60 * 1000;
			String[] codeInfo = cacheCode.toString().split("\\|");
			if(Long.valueOf(codeInfo[1]).longValue() > currentTime){
				//判断验证码过期
				if(codeInfo[0].equalsIgnoreCase(code)){
					//清空验证码
					cachService.delete(txtKey);
					cachService.delete(soundKey);
					result.put("code", ResultCodeContants.success);
					result.put("message", "success");
				}else{
					result.put("code", ResultCodeContants.failed);
					result.put("message", "验证码错误");
				}
			} else{
				result.put("code", ResultCodeContants.failed);
				result.put("message", "验证码已过期");
			}
		}else{
			result.put("code", ResultCodeContants.failed);
			result.put("message", "验证码已过期");
		}
		return result;
	}
}
