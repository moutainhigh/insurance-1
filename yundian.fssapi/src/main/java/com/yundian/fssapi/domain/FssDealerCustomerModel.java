package com.yundian.fssapi.domain;

import com.yundian.tookit.excel.annotation.XLSValue;

import java.io.Serializable;
import java.util.Date;

/**
 * 客户表
 */
public class FssDealerCustomerModel implements Serializable{
    private Long id;

    private Long dealerId;

    private Long userId;

    @XLSValue("客户姓名")
    private String name;
    @XLSValue("手机号码")
    private String phone;
    @XLSValue("被保险人姓名")
    private String insuresName;
    @XLSValue("身份证")
    private String insuresIdcard;
    @XLSValue("手机号码")
    private String insuresPhone;
    @XLSValue("地址")
    private String insuresAddress;
    @XLSValue("投保类型")
    private String insuresType;


    private String insuresLinkName;

    private String insuresLinkPhone;

    private String carBrand;
    @XLSValue("汽车品牌")
    private String carBrandName;

    private String carVehicle;
    @XLSValue("汽车车系")
    private String carVehicleName;

    private String carModel;
    @XLSValue("车型")
    private String carModelName;
    @XLSValue("车牌号码")
    private String carPlateNumber;
    @XLSValue("车架号")
    private String carVin;

    @XLSValue("发动机号")
    private String carEngineNo;

    private Integer carType;

    private Integer carBuyType;

    private String carColor;

    private String carBuyDate;

    private Integer carSeatNumber;

    private String carDisplacement;

    private Integer carImports;

    /**
     * 保险购买方式：分期，全款
     */
    private String policyBuyType;
    private String policyType;

    @XLSValue("保险公司")
    private String policyInsuranceCompany;

    @XLSValue("保险总额")
    private Integer policyTotalAmount;
    @XLSValue("生效日期")
    private String policyEffectDate;

    @XLSValue("到期日期")
    private String policyExpireDate;

    private Integer policyCompulsoryInsurance;

    private Integer policyVehicleTax;

    private Integer policyThreePay;

    private Integer policyThreePayLevel;

    private Integer policyDamage;

    private Integer policyLost;

    private Integer policyAutoIgnition;

    private Integer policySeatPassenger;

    private Integer policyScratch;

    private Integer policyGlassBreakage;

    private Integer policyDisregardContributing;

    private Integer policySeatDriver;

    private Integer policyWading;

    private Date ctime;

    private Date mtime;

    private String remark;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDealerId() {
        return dealerId;
    }

    public void setDealerId(Long dealerId) {
        this.dealerId = dealerId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getInsuresName() {
        return insuresName;
    }

    public void setInsuresName(String insuresName) {
        this.insuresName = insuresName == null ? null : insuresName.trim();
    }

    public String getInsuresIdcard() {
        return insuresIdcard;
    }

    public void setInsuresIdcard(String insuresIdcard) {
        this.insuresIdcard = insuresIdcard == null ? null : insuresIdcard.trim();
    }

    public String getInsuresPhone() {
        return insuresPhone;
    }

    public void setInsuresPhone(String insuresPhone) {
        this.insuresPhone = insuresPhone == null ? null : insuresPhone.trim();
    }

    public String getInsuresAddress() {
        return insuresAddress;
    }

    public void setInsuresAddress(String insuresAddress) {
        this.insuresAddress = insuresAddress == null ? null : insuresAddress.trim();
    }

    public String getInsuresType() {
        return insuresType;
    }

    public void setInsuresType(String insuresType) {
        this.insuresType = insuresType == null ? null : insuresType.trim();
    }

    public String getInsuresLinkName() {
        return insuresLinkName;
    }

    public void setInsuresLinkName(String insuresLinkName) {
        this.insuresLinkName = insuresLinkName == null ? null : insuresLinkName.trim();
    }

    public String getInsuresLinkPhone() {
        return insuresLinkPhone;
    }

    public void setInsuresLinkPhone(String insuresLinkPhone) {
        this.insuresLinkPhone = insuresLinkPhone == null ? null : insuresLinkPhone.trim();
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand == null ? null : carBrand.trim();
    }

    public String getCarBrandName() {
        return carBrandName;
    }

    public void setCarBrandName(String carBrandName) {
        this.carBrandName = carBrandName == null ? null : carBrandName.trim();
    }

    public String getCarVehicle() {
        return carVehicle;
    }

    public void setCarVehicle(String carVehicle) {
        this.carVehicle = carVehicle == null ? null : carVehicle.trim();
    }

    public String getCarVehicleName() {
        return carVehicleName;
    }

    public void setCarVehicleName(String carVehicleName) {
        this.carVehicleName = carVehicleName == null ? null : carVehicleName.trim();
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel == null ? null : carModel.trim();
    }

    public String getCarModelName() {
        return carModelName;
    }

    public void setCarModelName(String carModelName) {
        this.carModelName = carModelName == null ? null : carModelName.trim();
    }

    public String getCarPlateNumber() {
        return carPlateNumber;
    }

    public void setCarPlateNumber(String carPlateNumber) {
        this.carPlateNumber = carPlateNumber == null ? null : carPlateNumber.trim();
    }

    public String getCarVin() {
        return carVin;
    }

    public void setCarVin(String carVin) {
        this.carVin = carVin == null ? null : carVin.trim();
    }

    public String getCarEngineNo() {
        return carEngineNo;
    }

    public void setCarEngineNo(String carEngineNo) {
        this.carEngineNo = carEngineNo == null ? null : carEngineNo.trim();
    }

    public Integer getCarType() {
        return carType;
    }

    public void setCarType(Integer carType) {
        this.carType = carType;
    }

    public Integer getCarBuyType() {
        return carBuyType;
    }

    public void setCarBuyType(Integer carBuyType) {
        this.carBuyType = carBuyType;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor == null ? null : carColor.trim();
    }

    public String getCarBuyDate() {
        return carBuyDate;
    }

    public void setCarBuyDate(String carBuyDate) {
        this.carBuyDate = carBuyDate == null ? null : carBuyDate.trim();
    }

    public Integer getCarSeatNumber() {
        return carSeatNumber;
    }

    public void setCarSeatNumber(Integer carSeatNumber) {
        this.carSeatNumber = carSeatNumber;
    }

    public String getCarDisplacement() {
        return carDisplacement;
    }

    public void setCarDisplacement(String carDisplacement) {
        this.carDisplacement = carDisplacement == null ? null : carDisplacement.trim();
    }

    public Integer getCarImports() {
        return carImports;
    }

    public void setCarImports(Integer carImports) {
        this.carImports = carImports;
    }

    public String getPolicyType() {
        return policyType;
    }

    public void setPolicyType(String policyType) {
        this.policyType = policyType == null ? null : policyType.trim();
    }

    public String getPolicyInsuranceCompany() {
        return policyInsuranceCompany;
    }

    public void setPolicyInsuranceCompany(String policyInsuranceCompany) {
        this.policyInsuranceCompany = policyInsuranceCompany == null ? null : policyInsuranceCompany.trim();
    }

    public Integer getPolicyTotalAmount() {
        return policyTotalAmount;
    }

    public void setPolicyTotalAmount(Integer policyTotalAmount) {
        this.policyTotalAmount = policyTotalAmount;
    }

    public String getPolicyEffectDate() {
        return policyEffectDate;
    }

    public void setPolicyEffectDate(String policyEffectDate) {
        this.policyEffectDate = policyEffectDate == null ? null : policyEffectDate.trim();
    }

    public String getPolicyExpireDate() {
        return policyExpireDate;
    }

    public void setPolicyExpireDate(String policyExpireDate) {
        this.policyExpireDate = policyExpireDate == null ? null : policyExpireDate.trim();
    }

    public Integer getPolicyCompulsoryInsurance() {
        return policyCompulsoryInsurance;
    }

    public void setPolicyCompulsoryInsurance(Integer policyCompulsoryInsurance) {
        this.policyCompulsoryInsurance = policyCompulsoryInsurance;
    }

    public Integer getPolicyVehicleTax() {
        return policyVehicleTax;
    }

    public void setPolicyVehicleTax(Integer policyVehicleTax) {
        this.policyVehicleTax = policyVehicleTax;
    }

    public Integer getPolicyThreePay() {
        return policyThreePay;
    }

    public void setPolicyThreePay(Integer policyThreePay) {
        this.policyThreePay = policyThreePay;
    }

    public Integer getPolicyThreePayLevel() {
        return policyThreePayLevel;
    }

    public void setPolicyThreePayLevel(Integer policyThreePayLevel) {
        this.policyThreePayLevel = policyThreePayLevel;
    }

    public Integer getPolicyDamage() {
        return policyDamage;
    }

    public void setPolicyDamage(Integer policyDamage) {
        this.policyDamage = policyDamage;
    }

    public Integer getPolicyLost() {
        return policyLost;
    }

    public void setPolicyLost(Integer policyLost) {
        this.policyLost = policyLost;
    }

    public Integer getPolicyAutoIgnition() {
        return policyAutoIgnition;
    }

    public void setPolicyAutoIgnition(Integer policyAutoIgnition) {
        this.policyAutoIgnition = policyAutoIgnition;
    }

    public Integer getPolicySeatPassenger() {
        return policySeatPassenger;
    }

    public void setPolicySeatPassenger(Integer policySeatPassenger) {
        this.policySeatPassenger = policySeatPassenger;
    }

    public Integer getPolicyScratch() {
        return policyScratch;
    }

    public void setPolicyScratch(Integer policyScratch) {
        this.policyScratch = policyScratch;
    }

    public Integer getPolicyGlassBreakage() {
        return policyGlassBreakage;
    }

    public void setPolicyGlassBreakage(Integer policyGlassBreakage) {
        this.policyGlassBreakage = policyGlassBreakage;
    }

    public Integer getPolicyDisregardContributing() {
        return policyDisregardContributing;
    }

    public void setPolicyDisregardContributing(Integer policyDisregardContributing) {
        this.policyDisregardContributing = policyDisregardContributing;
    }

    public Integer getPolicySeatDriver() {
        return policySeatDriver;
    }

    public void setPolicySeatDriver(Integer policySeatDriver) {
        this.policySeatDriver = policySeatDriver;
    }

    public Integer getPolicyWading() {
        return policyWading;
    }

    public void setPolicyWading(Integer policyWading) {
        this.policyWading = policyWading;
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

    public String getPolicyBuyType() {
        return this.policyBuyType;
    }

    public void setPolicyBuyType(String policyBuyType) {
        this.policyBuyType = policyBuyType;
    }
}