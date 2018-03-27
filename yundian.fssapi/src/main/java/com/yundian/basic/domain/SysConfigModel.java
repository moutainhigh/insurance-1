package com.yundian.basic.domain;

import java.io.Serializable;


	
/**
* 
*/

public class SysConfigModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 440267436759226553L;

	/**
	* 
	*/
	private int id;

	/**
	 * 配置项
	 */
	private String name;

	/**
	 * 字段标识
	 */
	private String nid;

	/**
	 * 值
	 */
	private String value;

	/**
	 * 类型
	 */
	private int type;

	/**
	 * 状态
	 */
	private int status;

	/**
	* 
	*/
	public int getId() {
		return id;
	}

	/**
	* 
	*/
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * 配置项
	 */
	public String getName() {
		return name;
	}

	/**
	 * 配置项
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 字段标识
	 */
	public String getNid() {
		return nid;
	}

	/**
	 * 字段标识
	 */
	public void setNid(String nid) {
		this.nid = nid;
	}

	/**
	 * 值
	 */
	public String getValue() {
		return value;
	}

	/**
	 * 值
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * 类型
	 */
	public int getType() {
		return type;
	}

	/**
	 * 类型
	 */
	public void setType(int type) {
		this.type = type;
	}

	/**
	 * 状态
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * 状态
	 */
	public void setStatus(int status) {
		this.status = status;
	}

}


