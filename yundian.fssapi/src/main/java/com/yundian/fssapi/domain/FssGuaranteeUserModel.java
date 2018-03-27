package com.yundian.fssapi.domain;

import java.io.Serializable;
import java.util.Date;

public class FssGuaranteeUserModel implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * 
     */
    private Long id;

    /**
     * 担保公司业务员id
     */
    private Long userId;

    /**
     * 担保公司id
     */
    private Long guaranteeId;
    
	/**
	 * 是否是默认的担保机构
	 */
	private String isDefaultGuarantee;

    /**
     * 角色,默认值：1管理员，2普通
     */
    private String roleId;

    /**
     * 姓名
     */
    private String name;

    /**
     * 性别
     */
    private String sex;

    /**
     * 联系方式
     */
    private String tel;

    /**
     * 岗位
     */
    private String station;

    /**
     * 区域
     */
    private String region;

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
    public Long getId() {
        return id;
    }

    /**
     * 设置
     *
     * @param id the value for fss_guarantee_user.id
     *
     * @cgw 2016-07-22 15:18:23
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取担保公司业务员id
     *
     * @cgw 2016-07-22 15:18:23
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置担保公司业务员id
     *
     * @param userId the value for fss_guarantee_user.user_id
     *
     * @cgw 2016-07-22 15:18:23
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取担保公司id
     *
     * @cgw 2016-07-22 15:18:23
     */
    public Long getGuaranteeId() {
        return guaranteeId;
    }

    /**
     * 设置担保公司id
     *
     * @param guaranteeId the value for fss_guarantee_user.guarantee_id
     *
     * @cgw 2016-07-22 15:18:23
     */
    public void setGuaranteeId(Long guaranteeId) {
        this.guaranteeId = guaranteeId;
    }
    

    public String getIsDefaultGuarantee() {
		return isDefaultGuarantee;
	}

	public void setIsDefaultGuarantee(String isDefaultGuarantee) {
		this.isDefaultGuarantee = isDefaultGuarantee;
	}

	/**
     * 获取角色,默认值：1管理员，2普通
     *
     * @cgw 2016-07-22 15:18:23
     */
    public String getRoleId() {
        return roleId;
    }

    /**
     * 设置角色,默认值：1管理员，2普通
     *
     * @param roleId the value for fss_guarantee_user.role_id
     *
     * @cgw 2016-07-22 15:18:23
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    /**
     * 获取姓名
     *
     * @cgw 2016-07-22 15:18:23
     */
    public String getName() {
        return name;
    }

    /**
     * 设置姓名
     *
     * @param name the value for fss_guarantee_user.name
     *
     * @cgw 2016-07-22 15:18:23
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取性别
     *
     * @cgw 2016-07-22 15:18:23
     */
    public String getSex() {
        return sex;
    }

    /**
     * 设置性别
     *
     * @param sex the value for fss_guarantee_user.sex
     *
     * @cgw 2016-07-22 15:18:23
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * 获取联系方式
     *
     * @cgw 2016-07-22 15:18:23
     */
    public String getTel() {
        return tel;
    }

    /**
     * 设置联系方式
     *
     * @param tel the value for fss_guarantee_user.tel
     *
     * @cgw 2016-07-22 15:18:23
     */
    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    /**
     * 获取岗位
     *
     * @cgw 2016-07-22 15:18:23
     */
    public String getStation() {
        return station;
    }

    /**
     * 设置岗位
     *
     * @param station the value for fss_guarantee_user.station
     *
     * @cgw 2016-07-22 15:18:23
     */
    public void setStation(String station) {
        this.station = station == null ? null : station.trim();
    }

    /**
     * 获取区域
     *
     * @cgw 2016-07-22 15:18:23
     */
    public String getRegion() {
        return region;
    }

    /**
     * 设置区域
     *
     * @param region the value for fss_guarantee_user.region
     *
     * @cgw 2016-07-22 15:18:23
     */
    public void setRegion(String region) {
        this.region = region == null ? null : region.trim();
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
     * @param ctime the value for fss_guarantee_user.ctime
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
     * @param mtime the value for fss_guarantee_user.mtime
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
     * @param remark the value for fss_guarantee_user.remark
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
		return "FssGuaranteeUserModel [id=" + id + ", userId=" + userId
				+ ", guaranteeId=" + guaranteeId + ", isDefaultGuarantee="
				+ isDefaultGuarantee + ", roleId=" + roleId + ", name=" + name
				+ ", sex=" + sex + ", tel=" + tel + ", station=" + station
				+ ", region=" + region + ", ctime=" + ctime + ", mtime="
				+ mtime + ", remark=" + remark + "]";
	}
    
    
}