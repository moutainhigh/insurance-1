package com.yundian.fssapi.domain;

import java.io.Serializable;
import java.util.Date;

public class FssLoanModel implements Serializable {
    private Long loanId;

    private Integer fundId;

    private String fundName;

    private Long dealerId;

    private Long customerId;

    private String dealerName;

    private Long dealerUserId;

    private String dealerUserName;

    private String loanCode;

    private String loanType;

    private String insuresName;

    private String insuresIdcard;

    private String insuresPhone;

    private String insuresAddress;

    private String insuresType;

    private String insuresLinkName;

    private String insuresLinkPhone;

    private String carBrand;

    private String carBrandName;

    private String carVehicle;

    private String carVehicleName;

    private String carModel;

    private String carModelName;

    private String carPlateNumber;

    private String carVin;

    private String carEngineNo;

    private Integer carType;

    private Integer carBuyType;

    private String carColor;

    private String carBuyDate;

    private Integer carSeatNumber;

    private String carDisplacement;

    private Integer carImports;

    private String policyType;

    private String policyInsuranceCompany;

    private Integer policyTotalAmount;

    private String policyEffectDate;

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

    private Integer planId;

    private String planName;

    private Integer planPeriod;

    private String planFinancingType;

    private Integer planLoanAmount;

    private String repaymentBankCode;

    private String repaymentBankName;

    private String repaymentCard;

    private Date signTime;
    /**
     * 状态:INIT待提交、AUDITING审核中、APPLY_LOAN申请放款、WAITING_REVISED待资料修改、WAITING_LOAN待放款、HAVE_LOAN已放款、CLOSED已关闭
     */
    private String auditStatus;

    /**
     * 上一个状态
     */
    private String auditStatusPre;

    private  String closedReason;

    private Date auditTime;

    private String auditName;

    private Date loanTime;

    private String submitPerson;

    private Date ctime;

    private Date mtime;

    private String remark;


    public String getAuditStatusPre() {
        return this.auditStatusPre;
    }

    public void setAuditStatusPre(String auditStatusPre) {
        this.auditStatusPre = auditStatusPre;
    }

    public String getClosedReason() {
        return this.closedReason;
    }

    public void setClosedReason(String closedReason) {
        this.closedReason = closedReason;
    }

    public Long getLoanId() {
        return loanId;
    }

    public void setLoanId(Long loanId) {
        this.loanId = loanId;
    }

    public Integer getFundId() {
        return fundId;
    }

    public void setFundId(Integer fundId) {
        this.fundId = fundId;
    }

    public String getFundName() {
        return fundName;
    }

    public void setFundName(String fundName) {
        this.fundName = fundName == null ? null : fundName.trim();
    }

    public Long getDealerId() {
        return dealerId;
    }

    public void setDealerId(Long dealerId) {
        this.dealerId = dealerId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getDealerName() {
        return dealerName;
    }

    public void setDealerName(String dealerName) {
        this.dealerName = dealerName == null ? null : dealerName.trim();
    }

    public Long getDealerUserId() {
        return dealerUserId;
    }

    public void setDealerUserId(Long dealerUserId) {
        this.dealerUserId = dealerUserId;
    }

    public String getDealerUserName() {
        return dealerUserName;
    }

    public void setDealerUserName(String dealerUserName) {
        this.dealerUserName = dealerUserName == null ? null : dealerUserName.trim();
    }

    public String getLoanCode() {
        return loanCode;
    }

    public void setLoanCode(String loanCode) {
        this.loanCode = loanCode == null ? null : loanCode.trim();
    }

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType == null ? null : loanType.trim();
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

    public Integer getPlanId() {
        return planId;
    }

    public void setPlanId(Integer planId) {
        this.planId = planId;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName == null ? null : planName.trim();
    }

    public Integer getPlanPeriod() {
        return planPeriod;
    }

    public void setPlanPeriod(Integer planPeriod) {
        this.planPeriod = planPeriod;
    }

    public String getPlanFinancingType() {
        return planFinancingType;
    }

    public void setPlanFinancingType(String planFinancingType) {
        this.planFinancingType = planFinancingType == null ? null : planFinancingType.trim();
    }

    public Integer getPlanLoanAmount() {
        return planLoanAmount;
    }

    public void setPlanLoanAmount(Integer planLoanAmount) {
        this.planLoanAmount = planLoanAmount;
    }

    public String getRepaymentBankCode() {
        return repaymentBankCode;
    }

    public void setRepaymentBankCode(String repaymentBankCode) {
        this.repaymentBankCode = repaymentBankCode == null ? null : repaymentBankCode.trim();
    }

    public String getRepaymentBankName() {
        return repaymentBankName;
    }

    public void setRepaymentBankName(String repaymentBankName) {
        this.repaymentBankName = repaymentBankName == null ? null : repaymentBankName.trim();
    }

    public String getRepaymentCard() {
        return repaymentCard;
    }

    public void setRepaymentCard(String repaymentCard) {
        this.repaymentCard = repaymentCard == null ? null : repaymentCard.trim();
    }

    public Date getSignTime() {
        return signTime;
    }

    public void setSignTime(Date signTime) {
        this.signTime = signTime;
    }

    public String getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus == null ? null : auditStatus.trim();
    }

    public Date getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    public String getAuditName() {
        return auditName;
    }

    public void setAuditName(String auditName) {
        this.auditName = auditName == null ? null : auditName.trim();
    }

    public Date getLoanTime() {
        return loanTime;
    }

    public void setLoanTime(Date loanTime) {
        this.loanTime = loanTime;
    }

    public String getSubmitPerson() {
        return submitPerson;
    }

    public void setSubmitPerson(String submitPerson) {
        this.submitPerson = submitPerson == null ? null : submitPerson.trim();
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