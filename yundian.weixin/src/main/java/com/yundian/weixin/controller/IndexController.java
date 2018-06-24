package com.yundian.weixin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {

	
	@RequestMapping(value = "/index.html", method = RequestMethod.GET)
	public String index() {

			return "Loan";
		
	}
	
	@RequestMapping(value = "/404.html", method = RequestMethod.GET)
	public String notFound404() {
		return "404";
	}

}
