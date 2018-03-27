package com.cheguo.basic.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cheguo.basic.service.ISmsService;

public class TestSms {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "dubbo-customer.xml" });
		ISmsService smsService = (ISmsService) context.getBean("smsService");
		String ret = smsService.sendSoundSmsValidateCode("18506822699", 1, "10.10.14.241");
		System.out.println(ret);
	}

}
