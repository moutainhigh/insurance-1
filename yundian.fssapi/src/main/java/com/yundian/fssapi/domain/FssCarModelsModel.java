package com.yundian.fssapi.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class FssCarModelsModel implements Serializable{
    private Integer id;

    private String seriesCode;

    private String modelsCode;

    private String modelsName;

    private BigDecimal guidePrice;

    private String engine;

    private Integer seats;

    private Date ctime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSeriesCode() {
        return seriesCode;
    }

    public void setSeriesCode(String seriesCode) {
        this.seriesCode = seriesCode == null ? null : seriesCode.trim();
    }

    public String getModelsCode() {
        return modelsCode;
    }

    public void setModelsCode(String modelsCode) {
        this.modelsCode = modelsCode == null ? null : modelsCode.trim();
    }

    public String getModelsName() {
        return modelsName;
    }

    public void setModelsName(String modelsName) {
        this.modelsName = modelsName == null ? null : modelsName.trim();
    }

    public BigDecimal getGuidePrice() {
        return guidePrice;
    }

    public void setGuidePrice(BigDecimal guidePrice) {
        this.guidePrice = guidePrice;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine == null ? null : engine.trim();
    }

    public Integer getSeats() {
        return seats;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }
}