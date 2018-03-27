package com.yundian.basic.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.yundian.basic.service.SmsService;

public class SmsServiceTest extends AbstractJUnit{

	@Autowired
	SmsService smsService;
	@Test
	public void sendSms()
	{
		//smsService.sendSmsValidateCode("13758298275", 1, "");
	}
}
