package com.yundian.basic.domain;

import java.io.Serializable;

/**
* 
*/

public class SmsTemplate implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2960622628471406653L;

	/**
	 * ID
	 */
	private Integer id;

	/**
	 * 模板分类
	 */
	private String templatetype;

	/**
	 * 短信模板内容
	 */
	private String template;
	
	/**
	 * 状态 0：启用 1：停用
	 */
	private Integer status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTemplatetype() {
		return templatetype;
	}

	public void setTemplatetype(String templatetype) {
		this.templatetype = templatetype;
	}

	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
