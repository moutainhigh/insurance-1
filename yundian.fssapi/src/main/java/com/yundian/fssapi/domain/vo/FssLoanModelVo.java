package com.yundian.fssapi.domain.vo;

import com.yundian.fssapi.domain.FssLoanModel;
import com.yundian.fssapi.domain.vo.LoanDocumentVo;

import java.io.Serializable;

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
    private LoanDocumentVo loanContractPic;


    /**
     * 委托代扣协议
     */
    private LoanDocumentVo withholdingAgreementPic;


    /**
     * 身份证正面照片
     */
    private LoanDocumentVo idcardFrontPic;


    /**
     * 身份证反面照片
     */
    private LoanDocumentVo idcardBackPic;


    /**
     * 交强险保单
     */
    private LoanDocumentVo compulsoryInsurancePic;

    /**
     * 商业险保单
     */
    private LoanDocumentVo commercialInsurancePic;


    public LoanDocumentVo getIdcardFrontPic() {
        return this.idcardFrontPic;
    }

    public void setIdcardFrontPic(LoanDocumentVo idcardFrontPic) {
        this.idcardFrontPic = idcardFrontPic;
    }

    public LoanDocumentVo getIdcardBackPic() {
        return this.idcardBackPic;
    }

    public void setIdcardBackPic(LoanDocumentVo idcardBackPic) {
        this.idcardBackPic = idcardBackPic;
    }

    public LoanDocumentVo getCompulsoryInsurancePic() {
        return this.compulsoryInsurancePic;
    }

    public void setCompulsoryInsurancePic(LoanDocumentVo compulsoryInsurancePic) {
        this.compulsoryInsurancePic = compulsoryInsurancePic;
    }

    public LoanDocumentVo getCommercialInsurancePic() {
        return this.commercialInsurancePic;
    }

    public void setCommercialInsurancePic(LoanDocumentVo commercialInsurancePic) {
        this.commercialInsurancePic = commercialInsurancePic;
    }

    public LoanDocumentVo getLoanContractPic() {
        return this.loanContractPic;
    }

    public void setLoanContractPic(LoanDocumentVo loanContractPic) {
        this.loanContractPic = loanContractPic;
    }

    public LoanDocumentVo getWithholdingAgreementPic() {
        return this.withholdingAgreementPic;
    }

    public void setWithholdingAgreementPic(LoanDocumentVo withholdingAgreementPic) {
        this.withholdingAgreementPic = withholdingAgreementPic;
    }
}
