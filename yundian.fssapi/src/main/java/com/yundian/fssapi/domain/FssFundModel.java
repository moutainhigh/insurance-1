package com.yundian.fssapi.domain;

import java.io.Serializable;
import java.util.Date;

public class FssFundModel implements Serializable {
    private Integer id;

    private String fundCode;

    private String fundName;

    private Integer interesteRat;

    private String supportPeriods;

    private String description;

    private Date ctime;

    private Date mtime;

    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFundCode() {
        return fundCode;
    }

    public void setFundCode(String fundCode) {
        this.fundCode = fundCode == null ? null : fundCode.trim();
    }

    public String getFundName() {
        return fundName;
    }

    public void setFundName(String fundName) {
        this.fundName = fundName == null ? null : fundName.trim();
    }

    public Integer getInteresteRat() {
        return interesteRat;
    }

    public void setInteresteRat(Integer interesteRat) {
        this.interesteRat = interesteRat;
    }

    public String getSupportPeriods() {
        return supportPeriods;
    }

    public void setSupportPeriods(String supportPeriods) {
        this.supportPeriods = supportPeriods == null ? null : supportPeriods.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public Date getMtime() {
        return mtime;
    }

    public void setMtime(Date mtime) {
        this.mtime = mtime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}