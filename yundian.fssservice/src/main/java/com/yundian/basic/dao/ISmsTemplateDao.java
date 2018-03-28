package com.yundian.basic.dao;

import com.yundian.basic.domain.SmsTemplate;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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
	SmsTemplate getSmsTemplateByType(@Param("templatetype") String templatetype);
}
