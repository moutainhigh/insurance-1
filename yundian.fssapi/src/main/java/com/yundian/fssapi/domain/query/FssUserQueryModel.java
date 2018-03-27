package com.yundian.fssapi.domain.query;

import com.yundian.fssapi.domain.FssUserModel;

public class FssUserQueryModel extends FssUserModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 是否是默认的担保机构
	 */
	private String isDefaultGuarantee;
	/**
     * 
     */
    private Long guaranteeId;

    /**
     * 企业名称
     */
    private String guaranteeName;

    /**
     * 企业编号
     */
    private String guaranteeCode;
    

    /**
     * 角色,默认值：1管理员，2普通
     */
    private String roleId;
    
    
    /**
     * 岗位
     */
    private String station;

    /**
     * 区域
     */
    private String region;

	public Long getGuaranteeId() {
		return guaranteeId;
	}

	public void setGuaranteeId(Long guaranteeId) {
		this.guaranteeId = guaranteeId;
	}

	public String getGuaranteeName() {
		return guaranteeName;
	}

	public void setGuaranteeName(String guaranteeName) {
		this.guaranteeName = guaranteeName;
	}

	public String getGuaranteeCode() {
		return guaranteeCode;
	}

	public void setGuaranteeCode(String guaranteeCode) {
		this.guaranteeCode = guaranteeCode;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getStation() {
		return station;
	}

	public void setStation(String station) {
		this.station = station;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getIsDefaultGuarantee() {
		return isDefaultGuarantee;
	}

	public void setIsDefaultGuarantee(String isDefault) {
		this.isDefaultGuarantee = isDefault;
	}
    
    
    
}
