package com.yundian.fssapi.domain;

import java.io.Serializable;
import java.util.Date;

public class FssCarBrandModel implements Serializable{
    private Integer id;

    private String brandCode;

    private String brandName;

    private String spell;

    private String logoUrl;

    private String status;

    private String hit;

    private Integer orderBy;

    private Date ctime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrandCode() {
        return brandCode;
    }

    public void setBrandCode(String brandCode) {
        this.brandCode = brandCode == null ? null : brandCode.trim();
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName == null ? null : brandName.trim();
    }

    public String getSpell() {
        return spell;
    }

    public void setSpell(String spell) {
        this.spell = spell == null ? null : spell.trim();
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl == null ? null : logoUrl.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getHit() {
        return hit;
    }

    public void setHit(String hit) {
        this.hit = hit == null ? null : hit.trim();
    }

    public Integer getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(Integer orderBy) {
        this.orderBy = orderBy;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }
}