package com.yundian.fssapi.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class FssCarSeriesModel implements Serializable{
    private Integer id;

    private String brandCode;

    private String seriesCode;

    private String seriesName;

    private String logoUrl;

    private String seriesLevel;

    private String structure;

    private String engine;

    private String gearbox;

    private BigDecimal guidePriceStart;

    private BigDecimal guidePriceEnd;

    private Integer carImports;

    private Integer seriesScore;

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

    public String getSeriesCode() {
        return seriesCode;
    }

    public void setSeriesCode(String seriesCode) {
        this.seriesCode = seriesCode == null ? null : seriesCode.trim();
    }

    public String getSeriesName() {
        return seriesName;
    }

    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName == null ? null : seriesName.trim();
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl == null ? null : logoUrl.trim();
    }

    public String getSeriesLevel() {
        return seriesLevel;
    }

    public void setSeriesLevel(String seriesLevel) {
        this.seriesLevel = seriesLevel == null ? null : seriesLevel.trim();
    }

    public String getStructure() {
        return structure;
    }

    public void setStructure(String structure) {
        this.structure = structure == null ? null : structure.trim();
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine == null ? null : engine.trim();
    }

    public String getGearbox() {
        return gearbox;
    }

    public void setGearbox(String gearbox) {
        this.gearbox = gearbox == null ? null : gearbox.trim();
    }

    public BigDecimal getGuidePriceStart() {
        return guidePriceStart;
    }

    public void setGuidePriceStart(BigDecimal guidePriceStart) {
        this.guidePriceStart = guidePriceStart;
    }

    public BigDecimal getGuidePriceEnd() {
        return guidePriceEnd;
    }

    public void setGuidePriceEnd(BigDecimal guidePriceEnd) {
        this.guidePriceEnd = guidePriceEnd;
    }

    public Integer getCarImports() {
        return carImports;
    }

    public void setCarImports(Integer carImports) {
        this.carImports = carImports;
    }

    public Integer getSeriesScore() {
        return seriesScore;
    }

    public void setSeriesScore(Integer seriesScore) {
        this.seriesScore = seriesScore;
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