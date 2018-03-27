package com.yundian.basic.domain;

import java.io.Serializable;

public class SmsTemplateValue implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 姓名
	private String name;
	// 手机号码
	private String phone;
	// 密码
	private String password;
	// 验证码
	private String code;
	// 性别
	private String sex;
	// 企业id
	private String companycode;

	public SmsTemplateValue(String phone, String password, String name, String code, String sex, String companycode) {
		this.name = name;
		this.phone = phone;
		this.password = password;
		this.code = code;
		this.sex = sex;
		this.companycode = companycode;
	}

	/**
	 * 模板内变量替换
	 * 
	 * @param template
	 * @return
	 */
	public String analyzeTemplate(String template) {
		if (this.name!=null&&!this.name.equals(""))
			template = template.replaceAll("\\{name}", name);
		if (this.phone!=null&&!this.phone.equals(""))
			template = template.replaceAll("\\{phone}", phone);
		if (this.password!=null&&!this.password.equals(""))
			template = template.replaceAll("\\{password}", password);
		if (this.code!=null&&!this.code.equals(""))
			template = template.replaceAll("\\{code}", code);
		if (this.sex!=null&&!this.sex.equals("")){
			template = template.replaceAll("\\{sex}", sex);
		}else if((this.sex == null||this.sex.length()==0) && template.contains("{sex}")){
			template = template.replaceAll("\\{sex}", "");
		}
		return template;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getCompanycode() {
		return companycode;
	}

	public void setCompanycode(String companycode) {
		this.companycode = companycode;
	}

	public static void main(String[] args) {
		String template = "你的验证码为{code}";
		template = template.replaceAll("\\{name}", "姓名");
		template = template.replaceAll("\\{code}", "2578");
		System.out.println(template);
	}
}
