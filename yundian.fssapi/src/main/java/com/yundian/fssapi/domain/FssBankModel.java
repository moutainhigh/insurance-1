package com.yundian.fssapi.domain;

import java.io.Serializable;
import java.util.Date;

public class FssBankModel implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
     * 
     */
    private Long bankId;

    /**
     * 银行编码：ICBC、CCB等
     */
    private String bankCode;

    /**
     * 银行名称
     */
    private String bankName;

    /**
     * 分行名称
     */
    private String branchName;

    /**
     * 所在省份
     */
    private Integer province;

    /**
     * 所在城市
     */
    private Integer city;
    
    /**
     * 所在城市
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
     * 详细地址
     */
    private String street;

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

    private FssBankAddedConfModel fssBankAddedConfModel;
    /**
     * 获取
     *
     * @cgw 2016-07-26 16:32:37
     */
    public Long getBankId() {
        return bankId;
    }

    /**
     * 设置
     *
     * @param bankId the value for fss_bank.bank_id
     *
     * @cgw 2016-07-26 16:32:37
     */
    public void setBankId(Long bankId) {
        this.bankId = bankId;
    }

    /**
     * 获取银行编码：ICBC、CCB等
     *
     * @cgw 2016-07-26 16:32:37
     */
    public String getBankCode() {
        return bankCode;
    }

    /**
     * 设置银行编码：ICBC、CCB等
     *
     * @param bankCode the value for fss_bank.bank_code
     *
     * @cgw 2016-07-26 16:32:37
     */
    public void setBankCode(String bankCode) {
        this.bankCode = bankCode == null ? null : bankCode.trim();
    }

    /**
     * 获取银行名称
     *
     * @cgw 2016-07-26 16:32:37
     */
    public String getBankName() {
        return bankName;
    }

    /**
     * 设置银行名称
     *
     * @param bankName the value for fss_bank.bank_name
     *
     * @cgw 2016-07-26 16:32:37
     */
    public void setBankName(String bankName) {
        this.bankName = bankName == null ? null : bankName.trim();
    }

    /**
     * 获取分行名称
     *
     * @cgw 2016-07-26 16:32:37
     */
    public String getBranchName() {
        return branchName;
    }

    /**
     * 设置分行名称
     *
     * @param branchName the value for fss_bank.branch_name
     *
     * @cgw 2016-07-26 16:32:37
     */
    public void setBranchName(String branchName) {
        this.branchName = branchName == null ? null : branchName.trim();
    }

    /**
     * 获取所在省份
     *
     * @cgw 2016-07-26 16:32:37
     */
    public Integer getProvince() {
        return province;
    }

    /**
     * 设置所在省份
     *
     * @param province the value for fss_bank.province
     *
     * @cgw 2016-07-26 16:32:37
     */
    public void setProvince(Integer province) {
        this.province = province;
    }

    /**
     * 获取所在城市
     *
     * @cgw 2016-07-26 16:32:37
     */
    public Integer getCity() {
        return city;
    }

    /**
     * 设置所在城市
     *
     * @param city the value for fss_bank.city
     *
     * @cgw 2016-07-26 16:32:37
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

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	/**
     * 获取详细地址
     *
     * @cgw 2016-07-26 16:32:37
     */
    public String getStreet() {
        return street;
    }

    /**
     * 设置详细地址
     *
     * @param street the value for fss_bank.street
     *
     * @cgw 2016-07-26 16:32:37
     */
    public void setStreet(String street) {
        this.street = street == null ? null : street.trim();
    }

    /**
     * 获取
     *
     * @cgw 2016-07-26 16:32:37
     */
    public Date getCtime() {
        return ctime;
    }

    /**
     * 设置
     *
     * @param ctime the value for fss_bank.ctime
     *
     * @cgw 2016-07-26 16:32:37
     */
    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    /**
     * 获取
     *
     * @cgw 2016-07-26 16:32:37
     */
    public Date getMtime() {
        return mtime;
    }

    /**
     * 设置
     *
     * @param mtime the value for fss_bank.mtime
     *
     * @cgw 2016-07-26 16:32:37
     */
    public void setMtime(Date mtime) {
        this.mtime = mtime;
    }

    /**
     * 获取
     *
     * @cgw 2016-07-26 16:32:37
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置
     *
     * @param remark the value for fss_bank.remark
     *
     * @cgw 2016-07-26 16:32:37
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

	public FssBankAddedConfModel getFssBankAddedConfModel() {
		return fssBankAddedConfModel;
	}

	public void setFssBankAddedConfModel(FssBankAddedConfModel fssBankAddedConfModel) {
		this.fssBankAddedConfModel = fssBankAddedConfModel;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FssBankModel [bankId=" + bankId + ", bankCode=" + bankCode
				+ ", bankName=" + bankName + ", branchName=" + branchName
				+ ", province=" + province + ", city=" + city + ", area="
				+ area + ", provinceName=" + provinceName + ", cityName="
				+ cityName + ", areaName=" + areaName + ", street=" + street
				+ ", ctime=" + ctime + ", mtime=" + mtime + ", remark="
				+ remark + "]";
	}
    
    
}