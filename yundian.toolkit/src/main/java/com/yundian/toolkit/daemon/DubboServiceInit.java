package com.yundian.toolkit.daemon;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DubboServiceInit extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3822439804078545972L;
	
	private Logger logger = (Logger) LoggerFactory.getLogger(DubboServiceInit.class);

	/**
	 * 启动dubbo容器
	 */
	public void init() throws ServletException {
		try {
			startApplicationContext();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(ExceptionUtils.getFullStackTrace(e));
		}
	}

	public static ApplicationContext applicationContext = null;

	/**
	 * 启动spring容器
	 * @return
	 */
	public static ApplicationContext startApplicationContext() {
		if (applicationContext == null) {
			applicationContext = new ClassPathXmlApplicationContext("classpath*:conf/applicationContext*.xml");
		}
		return applicationContext;
	};
}
