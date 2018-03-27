package com.yundian.fssapi.domain;

import java.io.Serializable;
import java.util.Date;

public class FssBankUserModel implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * 
     */
    private Long bkuserId;

    /**
     * 银行用户名
     */
    private String bkuserName;

    /**
     * 银行用户名密码
     */
    private String bkuserPwd;

    /**
     * 所在银行机构id
     */
    private Long bankId;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 姓名
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
    public Long getBkuserId() {
        return bkuserId;
    }

    /**
     * 设置
     *
     * @param bkuserId the value for fss_bank_user.bkuser_id
     *
     * @cgw 2016-07-22 15:18:23
     */
    public void setBkuserId(Long bkuserId) {
        this.bkuserId = bkuserId;
    }

    /**
     * 获取银行用户名
     *
     * @cgw 2016-07-22 15:18:23
     */
    public String getBkuserName() {
        return bkuserName;
    }

    /**
     * 设置银行用户名
     *
     * @param bkuserName the value for fss_bank_user.bkuser_name
     *
     * @cgw 2016-07-22 15:18:23
     */
    public void setBkuserName(String bkuserName) {
        this.bkuserName = bkuserName == null ? null : bkuserName.trim();
    }

    /**
     * 获取银行用户名密码
     *
     * @cgw 2016-07-22 15:18:23
     */
    public String getBkuserPwd() {
        return bkuserPwd;
    }

    /**
     * 设置银行用户名密码
     *
     * @param bkuserPwd the value for fss_bank_user.bkuser_pwd
     *
     * @cgw 2016-07-22 15:18:23
     */
    public void setBkuserPwd(String bkuserPwd) {
        this.bkuserPwd = bkuserPwd == null ? null : bkuserPwd.trim();
    }

    /**
     * 获取所在银行机构id
     *
     * @cgw 2016-07-22 15:18:23
     */
    public Long getBankId() {
        return bankId;
    }

    /**
     * 设置所在银行机构id
     *
     * @param bankId the value for fss_bank_user.bank_id
     *
     * @cgw 2016-07-22 15:18:23
     */
    public void setBankId(Long bankId) {
        this.bankId = bankId;
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
     * @param phone the value for fss_bank_user.phone
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
     * @param name the value for fss_bank_user.name
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
     * @param ctime the value for fss_bank_user.ctime
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
     * @param mtime the value for fss_bank_user.mtime
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
     * @param remark the value for fss_bank_user.remark
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
		return "FssBankUserModel [bkuserId=" + bkuserId + ", bkuserName="
				+ bkuserName + ", bkuserPwd=" + bkuserPwd + ", bankId="
				+ bankId + ", phone=" + phone + ", name=" + name + ", ctime="
				+ ctime + ", mtime=" + mtime + ", remark=" + remark + "]";
	}
    
    
}