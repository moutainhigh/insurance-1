package com.yundian.fssapi.domain;

import java.io.Serializable;
import java.util.Date;

public class FssOrganizationUserModel implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * 
     */
    private Long orguserId;

    /**
     * 审核机构id
     */
    private Long organizationId;

    /**
     * 审核机构用户名
     */
    private String orguserName;

    /**
     * 审核机构用户名密码
     */
    private String orguserPwd;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 审核机构用户姓名
     */
    private String name;

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
    public Long getOrguserId() {
        return orguserId;
    }

    /**
     * 设置
     *
     * @param orguserId the value for fss_organization_user.orguser_id
     *
     * @cgw 2016-07-22 15:18:23
     */
    public void setOrguserId(Long orguserId) {
        this.orguserId = orguserId;
    }

    /**
     * 获取审核机构id
     *
     * @cgw 2016-07-22 15:18:23
     */
    public Long getOrganizationId() {
        return organizationId;
    }

    /**
     * 设置审核机构id
     *
     * @param organizationId the value for fss_organization_user.organization_id
     *
     * @cgw 2016-07-22 15:18:23
     */
    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    /**
     * 获取审核机构用户名
     *
     * @cgw 2016-07-22 15:18:23
     */
    public String getOrguserName() {
        return orguserName;
    }

    /**
     * 设置审核机构用户名
     *
     * @param orguserName the value for fss_organization_user.orguser_name
     *
     * @cgw 2016-07-22 15:18:23
     */
    public void setOrguserName(String orguserName) {
        this.orguserName = orguserName == null ? null : orguserName.trim();
    }

    /**
     * 获取审核机构用户名密码
     *
     * @cgw 2016-07-22 15:18:23
     */
    public String getOrguserPwd() {
        return orguserPwd;
    }

    /**
     * 设置审核机构用户名密码
     *
     * @param orguserPwd the value for fss_organization_user.orguser_pwd
     *
     * @cgw 2016-07-22 15:18:23
     */
    public void setOrguserPwd(String orguserPwd) {
        this.orguserPwd = orguserPwd == null ? null : orguserPwd.trim();
    }

    /**
     * 获取手机号码
     *
     * @cgw 2016-07-22 15:18:23
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置手机号码
     *
     * @param phone the value for fss_organization_user.phone
     *
     * @cgw 2016-07-22 15:18:23
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * 获取审核机构用户姓名
     *
     * @cgw 2016-07-22 15:18:23
     */
    public String getName() {
        return name;
    }

    /**
     * 设置审核机构用户姓名
     *
     * @param name the value for fss_organization_user.name
     *
     * @cgw 2016-07-22 15:18:23
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
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
     * @param ctime the value for fss_organization_user.ctime
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
     * @param mtime the value for fss_organization_user.mtime
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
     * @param remark the value for fss_organization_user.remark
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
		return "FssOrganizationUserModel [orguserId=" + orguserId
				+ ", organizationId=" + organizationId + ", orguserName="
				+ orguserName + ", orguserPwd=" + orguserPwd + ", phone="
				+ phone + ", name=" + name + ", ctime=" + ctime + ", mtime="
				+ mtime + ", remark=" + remark + "]";
	}
    
    
}