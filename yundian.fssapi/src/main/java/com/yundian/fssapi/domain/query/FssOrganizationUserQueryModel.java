package com.yundian.fssapi.domain.query;

import com.yundian.fssapi.domain.FssOrganizationUserModel;


public class FssOrganizationUserQueryModel extends FssOrganizationUserModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * 机构名称
     */
    private String organizationName;
    
    /**
     * 省份
     */
    private String provinceName;

    /**
     * 城市
     */
    private String cityName;
    

    /**
     * 所在省市名称
     */
    private String areaName;


	public String getOrganizationName() {
		return organizationName;
	}


	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}


	public String getProvinceName() {
		return provinceName;
	}


	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}


	public String getCityName() {
		return cityName;
	}


	public void setCityName(String cityName) {
		this.cityName = cityName;
	}


	public String getAreaName() {
		return areaName;
	}


	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

    
}