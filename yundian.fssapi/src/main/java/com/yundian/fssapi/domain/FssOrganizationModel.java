package com.yundian.fssapi.domain;

import java.io.Serializable;
import java.util.Date;

public class FssOrganizationModel implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * 机构ID
     */
    private Long organizationId;

    /**
     * 机构名称
     */
    private String organizationName;

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
     * 地址
     */
    private String street;

    /**
     * 联系人电话
     */
    private String phone;

    /**
     * 联系人
     */
    private String contactor;

    /**
     * 
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
    public Long getOrganizationId() {
        return organizationId;
    }

    /**
     * 设置
     *
     * @param organizationId the value for fss_organization.organization_id
     *
     * @cgw 2016-07-22 15:18:23
     */
    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    /**
     * 获取机构名称
     *
     * @cgw 2016-07-22 15:18:23
     */
    public String getOrganizationName() {
        return organizationName;
    }

    /**
     * 设置机构名称
     *
     * @param organizationName the value for fss_organization.organization_name
     *
     * @cgw 2016-07-22 15:18:23
     */
    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName == null ? null : organizationName.trim();
    }

    /**
     * 获取所在省份
     *
     * @cgw 2016-07-22 15:18:23
     */
    public Integer getProvince() {
        return province;
    }

    /**
     * 设置所在省份
     *
     * @param province the value for fss_organization.province
     *
     * @cgw 2016-07-22 15:18:23
     */
    public void setProvince(Integer province) {
        this.province = province;
    }

    /**
     * 获取所在城市
     *
     * @cgw 2016-07-22 15:18:23
     */
    public Integer getCity() {
        return city;
    }

    /**
     * 设置所在城市
     *
     * @param city the value for fss_organization.city
     *
     * @cgw 2016-07-22 15:18:23
     */
    public void setCity(Integer city) {
        this.city = city;
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
     * @param areaName the value for fss_organization.area_name
     *
     * @cgw 2016-07-22 15:18:23
     */
    public void setAreaName(String areaName) {
        this.areaName = areaName == null ? null : areaName.trim();
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
     * 获取地址
     *
     * @cgw 2016-07-22 15:18:23
     */
    public String getStreet() {
        return street;
    }

    /**
     * 设置地址
     *
     * @param street the value for fss_organization.street
     *
     * @cgw 2016-07-22 15:18:23
     */
    public void setStreet(String street) {
        this.street = street == null ? null : street.trim();
    }

    /**
     * 获取联系人电话
     *
     * @cgw 2016-07-22 15:18:23
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置联系人电话
     *
     * @param phone the value for fss_organization.phone
     *
     * @cgw 2016-07-22 15:18:23
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * 获取联系人
     *
     * @cgw 2016-07-22 15:18:23
     */
    public String getContactor() {
        return contactor;
    }

    /**
     * 设置联系人
     *
     * @param contactor the value for fss_organization.contactor
     *
     * @cgw 2016-07-22 15:18:23
     */
    public void setContactor(String contactor) {
        this.contactor = contactor == null ? null : contactor.trim();
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
     * @param ctime the value for fss_organization.ctime
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
     * @param mtime the value for fss_organization.mtime
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
     * @param remark the value for fss_organization.remark
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
		return "FssOrganizationModel [organizationId=" + organizationId
				+ ", organizationName=" + organizationName + ", province="
				+ province + ", city=" + city + ", area=" + area
				+ ", provinceName=" + provinceName + ", cityName=" + cityName
				+ ", areaName=" + areaName + ", street=" + street + ", phone="
				+ phone + ", contactor=" + contactor + ", ctime=" + ctime
				+ ", mtime=" + mtime + ", remark=" + remark + "]";
	}
    
    
}