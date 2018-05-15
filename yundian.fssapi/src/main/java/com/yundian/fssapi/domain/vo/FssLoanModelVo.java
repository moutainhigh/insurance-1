package com.yundian.fssapi.domain.vo;

import com.yundian.fssapi.domain.FssLoanModel;
import com.yundian.fssapi.domain.vo.LoanDocumentVo;

import java.io.Serializable;
import java.util.List;

/**
 * 贷款信息
 *
 * @author jnx
 * @create 2018/4/18
 */
public class FssLoanModelVo extends FssLoanModel implements Serializable {


    /**
     * 贷款合同
     */
    private String loanContractPic;


    /**
     * 委托代扣协议
     */
    private String withholdingAgreementPic;


    /**
     * 身份证正面照片
     */
    private String idcardFrontPic;


    /**
     * 身份证反面照片
     */
    private String idcardBackPic;


    /**
     * 交强险保单
     */
    private String compulsoryInsurancePic;

    /**
     * 商业险保单
     */
    private String commercialInsurancePic;

    public String getLoanContractPic() {
        return this.loanContractPic;
    }

    public void setLoanContractPic(String loanContractPic) {
        this.loanContractPic = loanContractPic;
    }

    public String getWithholdingAgreementPic() {
        return this.withholdingAgreementPic;
    }

    public void setWithholdingAgreementPic(String withholdingAgreementPic) {
        this.withholdingAgreementPic = withholdingAgreementPic;
    }

    public String getIdcardFrontPic() {
        return this.idcardFrontPic;
    }

    public void setIdcardFrontPic(String idcardFrontPic) {
        this.idcardFrontPic = idcardFrontPic;
    }

    public String getIdcardBackPic() {
        return this.idcardBackPic;
    }

    public void setIdcardBackPic(String idcardBackPic) {
        this.idcardBackPic = idcardBackPic;
    }

    public String getCompulsoryInsurancePic() {
        return this.compulsoryInsurancePic;
    }

    public void setCompulsoryInsurancePic(String compulsoryInsurancePic) {
        this.compulsoryInsurancePic = compulsoryInsurancePic;
    }

    public String getCommercialInsurancePic() {
        return this.commercialInsurancePic;
    }

    public void setCommercialInsurancePic(String commercialInsurancePic) {
        this.commercialInsurancePic = commercialInsurancePic;
    }
}
