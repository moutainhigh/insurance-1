package com.yundian.fssapi.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.yundian.fssapi.domain.query.FssGuaranteeUserQueryModel;

public class FssUserModel implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * 
     */
    private Long userId;

    /**
     * 登录名
     */
    private String userName;

    /**
     * 登录密码
     */
    private String userPwd;

    /**
     * 手机
     */
    private String phone;

    /**
     * 姓名
     */
    private String name;

    /**
     * 性别
     */
    private String sex;

    /**
     * 注册时间
     */
    private Date registerTime;

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
     * 用户所有担保机构列表
     */
    private List<FssGuaranteeUserQueryModel> guaranteeUserQueryList;

    /**
     * 获取
     *
     * @cgw 2016-07-22 15:18:23
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置
     *
     * @param userId the value for fss_user.user_id
     *
     * @cgw 2016-07-22 15:18:23
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取登录名
     *
     * @cgw 2016-07-22 15:18:23
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置登录名
     *
     * @param userName the value for fss_user.user_name
     *
     * @cgw 2016-07-22 15:18:23
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * 获取登录密码
     *
     * @cgw 2016-07-22 15:18:23
     */
    public String getUserPwd() {
        return userPwd;
    }

    /**
     * 设置登录密码
     *
     * @param userPwd the value for fss_user.user_pwd
     *
     * @cgw 2016-07-22 15:18:23
     */
    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd == null ? null : userPwd.trim();
    }

    /**
     * 获取手机
     *
     * @cgw 2016-07-22 15:18:23
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置手机
     *
     * @param phone the value for fss_user.phone
     *
     * @cgw 2016-07-22 15:18:23
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
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
     * @param name the value for fss_user.name
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
     * @param sex the value for fss_user.sex
     *
     * @cgw 2016-07-22 15:18:23
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * 获取注册时间
     *
     * @cgw 2016-07-22 15:18:23
     */
    public Date getRegisterTime() {
        return registerTime;
    }

    /**
     * 设置注册时间
     *
     * @param registerTime the value for fss_user.register_time
     *
     * @cgw 2016-07-22 15:18:23
     */
    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
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
     * @param ctime the value for fss_user.ctime
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
     * @param mtime the value for fss_user.mtime
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
     * @param remark the value for fss_user.remark
     *
     * @cgw 2016-07-22 15:18:23
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

	public List<FssGuaranteeUserQueryModel> getGuaranteeUserQueryList() {
		return guaranteeUserQueryList;
	}

	public void setGuaranteeUserQueryList(
			List<FssGuaranteeUserQueryModel> guaranteeUserList) {
		this.guaranteeUserQueryList = guaranteeUserList;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FssUserModel [userId=" + userId + ", userName=" + userName
				+ ", userPwd=" + userPwd + ", phone=" + phone + ", name="
				+ name + ", sex=" + sex + ", registerTime=" + registerTime
				+ ", ctime=" + ctime + ", mtime=" + mtime + ", remark="
				+ remark + ", guaranteeUserQueryList=" + guaranteeUserQueryList
				+ "]";
	}

	
}