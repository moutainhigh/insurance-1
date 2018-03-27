package com.yundian.basic.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yundian.basic.enums.BasicSmsInvokeTypeEnum;
import com.yundian.basic.service.SmsService;

public class TestSms {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("file:E:/work/cheguo/cheguo_service/cheguo.basicservice/src/main/resources/conf/applicationContext.xml");
		SmsService smsService= (SmsService )context.getBean("smsServiceImpl");
		smsService.sendSmsValidateCode("13758298275", BasicSmsInvokeTypeEnum.FINDPASSWORD.code(), "");//sendSmsValidateCode("13758298275", 1, "125260", "");
		
//		//smsService.smsReport("1001210191537884600", "13758298275", "DELIVRD");
//		
//		//smsService.smsReport("201512101912014874", "13758298275", "1");
		System.out.println(String.valueOf(true));
	}

}
