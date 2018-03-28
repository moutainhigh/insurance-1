package com.yundian.basic.dao;

import com.yundian.basic.domain.Sms;
import org.apache.ibatis.annotations.Param;

public interface ISmsDao {
	/**
	 * 添加验证码到数据库
	 * @param sms
	 * @return
	 */
	Integer addSmsInfo(Sms sms);

	/**
	 * 修改状态
	 * @param sms
	 * @return
	 */
	Integer updateSmsInfo(Sms sms);
	
	
	
	Integer updateSmsReport(Sms sms);
	
	Sms getSmsInfo(String msgid);

	int getValidateCodeSendNum(@Param("date") String date, @Param("phone") String phone, @Param("smsType") String smsType);
}