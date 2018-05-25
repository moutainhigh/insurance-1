package com.yundian.dealerweb.controller;

import com.alibaba.fastjson.JSON;
import com.yundian.dealerweb.util.DealerWebConstants;
import com.yundian.fssapi.domain.FssDealerUserModel;
import com.yundian.fssapi.domain.FssLoanDocumentModel;
import com.yundian.fssapi.domain.FssLoanModel;
import com.yundian.fssapi.domain.FssPlanModel;
import com.yundian.fssapi.domain.statistics.LoanInfoModel;
import com.yundian.fssapi.domain.vo.FssLoanModelVo;
import com.yundian.fssapi.domain.vo.LoanDocumentVo;
import com.yundian.fssapi.domain.vo.LoanInfoVo;
import com.yundian.fssapi.domain.vo.match.LoanDocumentVoMatch;
import com.yundian.fssapi.enums.FssLoanDocumentTypeEnum;
import com.yundian.fssapi.enums.FssLoanStatusEnum;
import com.yundian.fssapi.service.FssLoanService;
import com.yundian.result.Page;
import com.yundian.result.Paginator;
import com.yundian.result.Result;
import com.yundian.toolkit.utils.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 保险分期
 *
 * @author jnx
 * @create 2018/4/10
 */
@Slf4j
@Controller
public class LoanController {

    @Autowired
    FssLoanService fssLoanService;

    @ResponseBody
    @RequestMapping(value="/loan/applyLoan",method= RequestMethod.POST)
    public Result applyLoan(@ModelAttribute("fssLoanModelVo") FssLoanModelVo fssLoanModel) {

        try {
            List<LoanDocumentVo> loanDocumentVoList = getUploadDocumentVos(fssLoanModel);
            List<FssLoanDocumentModel> fssLoanDocumentModelList =LoanDocumentVoMatch.reverseMatchList(loanDocumentVoList);

            fssLoanService.applyLoan(fssLoanModel.getLoanId(),fssLoanDocumentModelList,"operater");
            return Result.success("");
        } catch (Exception ex) {
            log.error(String.format("申请放款信息异常："), ex);
            System.out.printf(ex.getMessage());
            return Result.fail("", "申请放款信息异常，请重试");
        }
    }


    @ResponseBody
    @RequestMapping(value="/loan/submitLoan",method= RequestMethod.POST)
    public Result submitLoan(@ModelAttribute("fssLoanModelVo") FssLoanModelVo fssLoanModel,HttpSession session) {

        try {
            FssDealerUserModel fssDealerUserModel =(FssDealerUserModel) session.getAttribute(DealerWebConstants.SYS.WEB_USER_SESSION);
            fssLoanModel.setDealerId(fssDealerUserModel.getDealerId());
            fssLoanModel.setDealerName(fssDealerUserModel.getDealerName());
            fssLoanModel.setDealerUserId(fssDealerUserModel.getUserId());
            fssLoanModel.setDealerUserName(fssDealerUserModel.getUserName());
            fssLoanModel.setSubmitPerson(fssDealerUserModel.getName());
            if(fssLoanModel.getPlanLoanAmount()!=null){
                //金额元——>分
                fssLoanModel.setPlanLoanAmount(fssLoanModel.getPlanLoanAmount()*100);
            }
            if(fssLoanModel.getPolicyTotalAmount()!=null){
                //金额元——>分
                fssLoanModel.setPolicyTotalAmount(fssLoanModel.getPolicyTotalAmount()*100);
            }

            LoanInfoModel loanInfoModel = new LoanInfoModel();
            loanInfoModel.setFssLoanModel(fssLoanModel);
            loanInfoModel.setLoanId(fssLoanModel.getLoanId());

            fssLoanService.submitLoan(loanInfoModel,"操作人");
            return Result.success("");
        } catch (Exception ex) {
            log.error(String.format("增加贷款信息异常："), ex);
            System.out.printf(ex.getMessage());
            return Result.fail("", "增加贷款信息异常，请重试");
        }
    }

    @ResponseBody
    @RequestMapping(value="/loan/updateLoan",method= RequestMethod.POST)
    public Result updateLoan(@ModelAttribute("fssLoanModelVo") FssLoanModelVo fssLoanModel) {

        try {

            List<LoanDocumentVo> loanDocumentVoList = getUploadDocumentVos(fssLoanModel);
            List<FssLoanDocumentModel> fssLoanDocumentModelList =LoanDocumentVoMatch.reverseMatchList(loanDocumentVoList);
            if(fssLoanModel.getPlanLoanAmount()!=null){
                //金额元——>分
                fssLoanModel.setPlanLoanAmount(fssLoanModel.getPlanLoanAmount()*100);
            }
            if(fssLoanModel.getPolicyTotalAmount()!=null){
                //金额元——>分
                fssLoanModel.setPolicyTotalAmount(fssLoanModel.getPolicyTotalAmount()*100);
            }
            fssLoanService.insertFssLoanDocument(fssLoanModel.getLoanId(),fssLoanDocumentModelList);
            fssLoanService.updateFssLoan(fssLoanModel);
            return Result.success("");
        } catch (Exception ex) {
            log.error(String.format("增加贷款信息异常："), ex);
            System.out.printf(ex.getMessage());
            return Result.fail("", "增加贷款信息异常，请重试");
        }
    }

    @ResponseBody
    @RequestMapping(value="/loan/addLoan",method = RequestMethod.POST)
    public Result addLoan(@ModelAttribute("fssLoanModelVo") FssLoanModelVo fssLoanModel,HttpSession session) {

        try {

            FssDealerUserModel fssDealerUserModel =(FssDealerUserModel) session.getAttribute(DealerWebConstants.SYS.WEB_USER_SESSION);
            fssLoanModel.setDealerId(fssDealerUserModel.getDealerId());
            fssLoanModel.setDealerName(fssDealerUserModel.getDealerName());
            fssLoanModel.setDealerUserId(fssDealerUserModel.getUserId());
            fssLoanModel.setDealerUserName(fssDealerUserModel.getUserName());
            fssLoanModel.setSubmitPerson(fssDealerUserModel.getName());
            if(fssLoanModel.getPlanLoanAmount()!=null){
                //金额元——>分
                fssLoanModel.setPlanLoanAmount(fssLoanModel.getPlanLoanAmount()*100);
            }
            if(fssLoanModel.getPolicyTotalAmount()!=null){
                //金额元——>分
                fssLoanModel.setPolicyTotalAmount(fssLoanModel.getPolicyTotalAmount()*100);
            }
            List<LoanDocumentVo> loanDocumentVoList = getUploadDocumentVos(fssLoanModel);
            List<FssLoanDocumentModel> fssLoanDocumentModelList =LoanDocumentVoMatch.reverseMatchList(loanDocumentVoList);
            LoanInfoModel loanInfoModel = new LoanInfoModel();
            loanInfoModel.setFssLoanModel(fssLoanModel);
            loanInfoModel.setLoanId(fssLoanModel.getLoanId());
            loanInfoModel.setFssLoanDocumentModels(fssLoanDocumentModelList);
            fssLoanService.saveLoan(loanInfoModel);
            return Result.success("");
        } catch (Exception ex) {
            log.error(String.format("增加贷款信息异常："), ex);
            System.out.printf(ex.getMessage());
            return Result.fail("", "增加贷款信息异常，请重试");
        }
    }


    @ResponseBody
    @RequestMapping(value="/loan/getInfo",method= RequestMethod.GET)
    public Result getInfo(@RequestParam(value="loanId") Long loanId) {

        try {
            if(loanId==null||loanId<=0)
            {
                return Result.fail("", "参数错误，请重试");
            }
            LoanInfoModel loanInfoModel= fssLoanService.getFssLoan(loanId);
            if(loanInfoModel.getFssLoanModel().getPlanLoanAmount()!=null){
                //金额分——>元
                loanInfoModel.getFssLoanModel().setPlanLoanAmount(loanInfoModel.getFssLoanModel().getPlanLoanAmount()/100);
            }
            if(loanInfoModel.getFssLoanModel().getPolicyTotalAmount()!=null){
                //金额分——>元
                loanInfoModel.getFssLoanModel().setPolicyTotalAmount(loanInfoModel.getFssLoanModel().getPolicyTotalAmount()/100);
            }
            LoanInfoVo loanInfoVo= new LoanInfoVo();
            loanInfoVo.setFssLoanModel(loanInfoModel.getFssLoanModel());
            List<LoanDocumentVo> loanDocumentVoList = LoanDocumentVoMatch.matchList(loanInfoModel.getFssLoanDocumentModels());
            if(loanDocumentVoList!=null&&loanDocumentVoList.size()>0) {
                Map<String, List<LoanDocumentVo>> listMap = loanDocumentVoList.stream()
                        .collect(Collectors.groupingBy(LoanDocumentVo::getDocumentType));
                loanInfoVo.setFssLoanDocs(listMap);
            }
            return Result.success(loanInfoVo);
        } catch (Exception ex) {
            log.error(String.format("贷款信息异常："), ex);
            System.out.printf(ex.getMessage());
            return Result.fail("", "贷款信息异常，请重试");
        }
    }
    @ResponseBody
    @RequestMapping(value="/loan/getPlan",method= RequestMethod.GET)
    public Result getPlans() {

        try {
            List<FssPlanModel> fssPlanList= fssLoanService.getFssPlanList();
            return Result.success(fssPlanList);
        } catch (Exception ex) {
            log.error(String.format("获取金融方案失败："), ex);
            System.out.printf(ex.getMessage());
            return Result.fail("", "获取金融方案，请重试");
        }
    }

    @ResponseBody
    @RequestMapping(value = "/loan/getList")
    public Result listAjax	(
            @RequestParam(defaultValue = "0", value = "page") int page,
            @RequestParam(defaultValue = "20", value = "pagesize") int pageSize,
            @ModelAttribute("fssLoanQueryParam") FssLoanModel fssLoanQueryParam,
            HttpSession session) {
        try {

            Paginator<FssLoanModel> paginator = new Paginator<>();
            paginator.setPage(page);
            paginator.setPageSize(pageSize);
            FssDealerUserModel fssDealerUserModel =(FssDealerUserModel) session.getAttribute(DealerWebConstants.SYS.WEB_USER_SESSION);
            fssLoanQueryParam.setDealerId(fssDealerUserModel.getDealerId());
            paginator.setParam(fssLoanQueryParam);
            Page<FssLoanModel> paginatedResult = fssLoanService.getPaginatorFssLoan(paginator);
            if(paginatedResult.getItems().size()>0) {
                paginatedResult.getItems().stream().forEach(e -> {
                    try {
                        e.setAuditStatus(FssLoanStatusEnum.valueOf(e.getAuditStatus()).desc());
                    } catch (Exception ex) {
                        log.error(ex.getMessage());
                    }
                });
            }
            return Result.success(paginatedResult);

        } catch (Exception ex) {
            log.error(String.format("分页查询贷款信息异常："), ex);
            System.out.printf(ex.getMessage());
            return Result.fail("","网络异常，请重试");
        }
    }

    private List<LoanDocumentVo> getUploadDocumentVos(FssLoanModelVo fssLoanModel){
        List<LoanDocumentVo> loanDocumentVoList =  new ArrayList<>();
        if(StringUtil.isNotBlank(fssLoanModel.getIdcardFrontPic())){
            List<LoanDocumentVo> idcardFrontPic = JSON.parseArray(fssLoanModel.getIdcardFrontPic(),LoanDocumentVo.class);
            idcardFrontPic.stream().forEach((e)->e.setDocumentType(FssLoanDocumentTypeEnum.IDCARD_FRONT.code()));
            loanDocumentVoList.addAll(idcardFrontPic);
        }
        if(StringUtil.isNotBlank(fssLoanModel.getIdcardBackPic())){
            List<LoanDocumentVo> idcardBackPic = JSON.parseArray(fssLoanModel.getIdcardBackPic(),LoanDocumentVo.class);
            idcardBackPic.stream().forEach((e)->e.setDocumentType(FssLoanDocumentTypeEnum.IDCARD_BACK.code()));
            loanDocumentVoList.addAll(idcardBackPic);
        }
        if(StringUtil.isNotBlank(fssLoanModel.getCommercialInsurancePic())){
            List<LoanDocumentVo> commercialInsurancePic = JSON.parseArray(fssLoanModel.getCommercialInsurancePic(),LoanDocumentVo.class);
            commercialInsurancePic.stream().forEach((e)->e.setDocumentType(FssLoanDocumentTypeEnum.COMMERCIAL_INSURANCE.code()));

            loanDocumentVoList.addAll(commercialInsurancePic);
        }
        if(StringUtil.isNotBlank(fssLoanModel.getCompulsoryInsurancePic())){
            List<LoanDocumentVo> compulsoryInsurancePic = JSON.parseArray(fssLoanModel.getCompulsoryInsurancePic(),LoanDocumentVo.class);
            compulsoryInsurancePic.stream().forEach((e)->e.setDocumentType(FssLoanDocumentTypeEnum.COMPULSORY_INSURANCE.code()));
            loanDocumentVoList.addAll(compulsoryInsurancePic);
        }
        if(StringUtil.isNotBlank(fssLoanModel.getLoanContractPic())){
            List<LoanDocumentVo> loanContractPic = JSON.parseArray(fssLoanModel.getLoanContractPic(),LoanDocumentVo.class);
            loanContractPic.stream().forEach((e)->e.setDocumentType(FssLoanDocumentTypeEnum.LOAN_CONTRACT.code()));
            loanDocumentVoList.addAll(loanContractPic);
        }
        if(StringUtil.isNotBlank(fssLoanModel.getWithholdingAgreementPic())){
            List<LoanDocumentVo> withholdingAgreementPic = JSON.parseArray(fssLoanModel.getWithholdingAgreementPic(),LoanDocumentVo.class);
            withholdingAgreementPic.stream().forEach((e)->e.setDocumentType(FssLoanDocumentTypeEnum.WITHHOLDING_AGREEMENT.code()));

            loanDocumentVoList.addAll(withholdingAgreementPic);
        }
        return loanDocumentVoList;
    }

}
