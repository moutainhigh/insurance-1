package com.yundian.fssapi.domain;

import java.io.Serializable;
import java.util.Date;

public class FssGuaranteeModel implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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

    /**
     * 创建时间
     */
    private Date ctime;

    /**
     * 
     */
    private Date mtime;

    /**
     * 
     */
    private String remark;

    /**
     * 获取
     *
     * @cgw 2016-07-22 15:18:23
     */
    public Long getGuaranteeId() {
        return guaranteeId;
    }

    /**
     * 设置
     *
     * @param guaranteeId the value for fss_guarantee.guarantee_id
     *
     * @cgw 2016-07-22 15:18:23
     */
    public void setGuaranteeId(Long guaranteeId) {
        this.guaranteeId = guaranteeId;
    }

    /**
     * 获取企业名称
     *
     * @cgw 2016-07-22 15:18:23
     */
    public String getGuaranteeName() {
        return guaranteeName;
    }

    /**
     * 设置企业名称
     *
     * @param guaranteeName the value for fss_guarantee.guarantee_name
     *
     * @cgw 2016-07-22 15:18:23
     */
    public void setGuaranteeName(String guaranteeName) {
        this.guaranteeName = guaranteeName == null ? null : guaranteeName.trim();
    }

    /**
     * 获取企业编号
     *
     * @cgw 2016-07-22 15:18:23
     */
    public String getGuaranteeCode() {
        return guaranteeCode;
    }

    /**
     * 设置企业编号
     *
     * @param guaranteeCode the value for fss_guarantee.guarantee_code
     *
     * @cgw 2016-07-22 15:18:23
     */
    public void setGuaranteeCode(String guaranteeCode) {
        this.guaranteeCode = guaranteeCode == null ? null : guaranteeCode.trim();
    }

    /**
     * 获取联系人姓名
     *
     * @cgw 2016-07-22 15:18:23
     */
    public String getContactor() {
        return contactor;
    }

    /**
     * 设置联系人姓名
     *
     * @param contactor the value for fss_guarantee.contactor
     *
     * @cgw 2016-07-22 15:18:23
     */
    public void setContactor(String contactor) {
        this.contactor = contactor == null ? null : contactor.trim();
    }

    /**
     * 获取联系人手机号
     *
     * @cgw 2016-07-22 15:18:23
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置联系人手机号
     *
     * @param phone the value for fss_guarantee.phone
     *
     * @cgw 2016-07-22 15:18:23
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * 获取企业法人
     *
     * @cgw 2016-07-22 15:18:23
     */
    public String getBusinessentity() {
        return businessentity;
    }

    /**
     * 设置企业法人
     *
     * @param businessentity the value for fss_guarantee.businessentity
     *
     * @cgw 2016-07-22 15:18:23
     */
    public void setBusinessentity(String businessentity) {
        this.businessentity = businessentity == null ? null : businessentity.trim();
    }

    /**
     * 获取组织机构代码证号
     *
     * @cgw 2016-07-22 15:18:23
     */
    public String getOrganizeCode() {
        return organizeCode;
    }

    /**
     * 设置组织机构代码证号
     *
     * @param organizeCode the value for fss_guarantee.organize_code
     *
     * @cgw 2016-07-22 15:18:23
     */
    public void setOrganizeCode(String organizeCode) {
        this.organizeCode = organizeCode == null ? null : organizeCode.trim();
    }

    /**
     * 获取营业执照号
     *
     * @cgw 2016-07-22 15:18:23
     */
    public String getLicenseCode() {
        return licenseCode;
    }

    /**
     * 设置营业执照号
     *
     * @param licenseCode the value for fss_guarantee.license_code
     *
     * @cgw 2016-07-22 15:18:23
     */
    public void setLicenseCode(String licenseCode) {
        this.licenseCode = licenseCode == null ? null : licenseCode.trim();
    }

    /**
     * 获取省份
     *
     * @cgw 2016-07-22 15:18:23
     */
    public Integer getProvince() {
        return province;
    }

    /**
     * 设置省份
     *
     * @param province the value for fss_guarantee.province
     *
     * @cgw 2016-07-22 15:18:23
     */
    public void setProvince(Integer province) {
        this.province = province;
    }

    /**
     * 获取城市
     *
     * @cgw 2016-07-22 15:18:23
     */
    public Integer getCity() {
        return city;
    }

    /**
     * 设置城市
     *
     * @param city the value for fss_guarantee.city
     *
     * @cgw 2016-07-22 15:18:23
     */
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

	/**
     * 获取所在省市名称
     *
     * @cgw 2016-07-22 15:18:23
     */
    public String getAreaName() {
        return areaName;
    }

    /**
     * 设置所在省市名称
     *
     * @param areaName the value for fss_guarantee.area_name
     *
     * @cgw 2016-07-22 15:18:23
     */
    public void setAreaName(String areaName) {
        this.areaName = areaName == null ? null : areaName.trim();
    }

    /**
     * 获取详细街道地址
     *
     * @cgw 2016-07-22 15:18:23
     */
    public String getStreet() {
        return street;
    }

    /**
     * 设置详细街道地址
     *
     * @param street the value for fss_guarantee.street
     *
     * @cgw 2016-07-22 15:18:23
     */
    public void setStreet(String street) {
        this.street = street == null ? null : street.trim();
    }

    /**
     * 获取0 未认证，1 认证中，2 已认证，3 认证失败
     *
     * @cgw 2016-07-22 15:18:23
     */
    public String getVerifyStatus() {
        return verifyStatus;
    }

    /**
     * 设置0 未认证，1 认证中，2 已认证，3 认证失败
     *
     * @param verifyStatus the value for fss_guarantee.verify_status
     *
     * @cgw 2016-07-22 15:18:23
     */
    public void setVerifyStatus(String verifyStatus) {
        this.verifyStatus = verifyStatus;
    }

    /**
     * 获取认证时间
     *
     * @cgw 2016-07-22 15:18:23
     */
    public Date getVerifyTime() {
        return verifyTime;
    }

    /**
     * 设置认证时间
     *
     * @param verifyTime the value for fss_guarantee.verify_time
     *
     * @cgw 2016-07-22 15:18:23
     */
    public void setVerifyTime(Date verifyTime) {
        this.verifyTime = verifyTime;
    }

    /**
     * 获取
     *
     * @cgw 2016-07-22 15:18:23
     */
    public Date getCtime() {
        return ctime;
    }

    /**
     * 设置
     *
     * @param ctime the value for fss_guarantee.ctime
     *
     * @cgw 2016-07-22 15:18:23
     */
    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    /**
     * 获取
     *
     * @cgw 2016-07-22 15:18:23
     */
    public Date getMtime() {
        return mtime;
    }

    /**
     * 设置
     *
     * @param mtime the value for fss_guarantee.mtime
     *
     * @cgw 2016-07-22 15:18:23
     */
    public void setMtime(Date mtime) {
        this.mtime = mtime;
    }

    /**
     * 获取
     *
     * @cgw 2016-07-22 15:18:23
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置
     *
     * @param remark the value for fss_guarantee.remark
     *
     * @cgw 2016-07-22 15:18:23
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FssGuaranteeModel [guaranteeId=" + guaranteeId
				+ ", guaranteeName=" + guaranteeName + ", guaranteeCode="
				+ guaranteeCode + ", contactor=" + contactor + ", phone="
				+ phone + ", businessentity=" + businessentity
				+ ", organizeCode=" + organizeCode + ", licenseCode="
				+ licenseCode + ", province=" + province + ", city=" + city
				+ ", area=" + area + ", provinceName=" + provinceName
				+ ", cityName=" + cityName + ", areaName=" + areaName
				+ ", street=" + street + ", verifyStatus=" + verifyStatus
				+ ", verifyTime=" + verifyTime + ", ctime=" + ctime
				+ ", mtime=" + mtime + ", remark=" + remark + "]";
	}
    
    
}