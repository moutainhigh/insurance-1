package com.yundian.fssapi.domain.query;

import com.yundian.fssapi.domain.FssBankUserModel;


public class FssBankUserQueryModel extends FssBankUserModel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	 /**
     * 银行名称
     */
    private String bankName;

    /**
     * 分行名称
     */
    private String branchName;

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


	public String getBankName() {
		return bankName;
	}


	public void setBankName(String bankName) {
		this.bankName = bankName;
	}


	public String getBranchName() {
		return branchName;
	}


	public void setBranchName(String branchName) {
		this.branchName = branchName;
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