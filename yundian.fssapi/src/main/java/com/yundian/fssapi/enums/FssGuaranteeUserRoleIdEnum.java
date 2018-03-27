package com.yundian.fssapi.enums;

/**
 * 角色枚举
 * 
 * @author hehaibo
 *
 */
public enum FssGuaranteeUserRoleIdEnum {
	
	/**
	 * 未认证
	 */
	ADMIN("ADMIN","管理员角色"),
	/**
	 * 认证中
	 */
	GENERAL("GENERAL","普通角色");
	
	private String code;
	private String desc;
	private FssGuaranteeUserRoleIdEnum(String code,String desc){
		this.code=code;
		this.desc=desc;
	}
	public String code() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String desc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	
}
