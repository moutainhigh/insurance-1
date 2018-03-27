package com.yundian.basic.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yundian.basic.domain.SmsTemplate;

public interface ISmsTemplateDao {

	/**
	 * 获取短信魔板
	 * @return
	 */
	List<SmsTemplate> getSmsTemplate();
	
	/**
	 * 根据类型获取短信模板
	 * @param templatetype
	 * @return
	 */
	SmsTemplate getSmsTemplateByType(@Param("templatetype")String templatetype);
}
