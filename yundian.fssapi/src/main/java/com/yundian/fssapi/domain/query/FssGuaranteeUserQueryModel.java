package com.yundian.fssapi.domain.query;

import java.io.Serializable;
import java.util.Date;


/**
 * 担保机构 用户 查询模型【多对多，关联信息用此模型表示】
 * 
 * @author hehaibo
 *
 */
public class FssGuaranteeUserQueryModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//******************担保机构部分************************
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
     * 联系人姓名
     */
    private String contactor;

    /**
     * 联系人手机号
     */
    private String phone;

    /**
     * 企业法人
     */
    private String businessentity;

    /**
     * 组织机构代码证号
     */
    private String organizeCode;

    /**
     * 营业执照号
     */
    private String licenseCode;

    /**
     * 省份
     */
    private Integer province;

    /**
     * 城市
     */
    private Integer city;
    
    /**
     * 县区
     */
    private Integer area;
    
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

    /**
     * 详细街道地址
     */
    private String street;

    /**
     * 认证状态 0 未认证，1 认证中，2 已认证，3 认证失败
     */
    private String verifyStatus;

    /**
     * 认证时间
     */
    private Date verifyTime;
    
    //****************************用户信息部分1
    
    /**
     * 担保公司业务员id
     */
    private Long userId;
    
    
    //****************************用户信息部分
    /**
	 * 是否是默认的担保机构
	 */
	private String isDefaultGuarantee;
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

	public String getContactor() {
		return contactor;
	}

	public void setContactor(String contactor) {
		this.contactor = contactor;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getBusinessentity() {
		return businessentity;
	}

	public void setBusinessentity(String businessentity) {
		this.businessentity = businessentity;
	}

	public String getOrganizeCode() {
		return organizeCode;
	}

	public void setOrganizeCode(String organizeCode) {
		this.organizeCode = organizeCode;
	}

	public String getLicenseCode() {
		return licenseCode;
	}

	public void setLicenseCode(String licenseCode) {
		this.licenseCode = licenseCode;
	}

	public Integer getProvince() {
		return province;
	}

	public void setProvince(Integer province) {
		this.province = province;
	}

	public Integer getCity() {
		return city;
	}

	public void setCity(Integer city) {
		this.city = city;
	}

	public Integer getArea() {
		return area;
	}

	public void setArea(Integer area) {
		this.area = area;
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

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getVerifyStatus() {
		return verifyStatus;
	}

	public void setVerifyStatus(String verifyStatus) {
		this.verifyStatus = verifyStatus;
	}

	public Date getVerifyTime() {
		return verifyTime;
	}

	public void setVerifyTime(Date verifyTime) {
		this.verifyTime = verifyTime;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	

	public String getIsDefaultGuarantee() {
		return isDefaultGuarantee;
	}

	public void setIsDefaultGuarantee(String isDefaultGuarantee) {
		this.isDefaultGuarantee = isDefaultGuarantee;
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
    
}
