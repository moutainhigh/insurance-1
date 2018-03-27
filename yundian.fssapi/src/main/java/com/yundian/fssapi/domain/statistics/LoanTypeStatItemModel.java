package com.yundian.fssapi.domain.statistics;

import java.io.Serializable;
import java.util.List;

/**
 * 统计图：贷款类型分布数据
 * @author ningxia.jin
 *
 */
public class LoanTypeStatItemModel implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private String name;
	private int value;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
