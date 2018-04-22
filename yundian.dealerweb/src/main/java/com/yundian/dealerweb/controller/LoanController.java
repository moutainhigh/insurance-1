package com.yundian.dealerweb.controller;

import com.alibaba.fastjson.JSON;
import com.yundian.dealerweb.controller.vo.FssLoanModelVo;
import com.yundian.dealerweb.util.DealerWebConstants;
import com.yundian.fssapi.domain.FssDealerUserModel;
import com.yundian.fssapi.domain.FssLoanModel;
import com.yundian.fssapi.domain.statistics.LoanInfoModel;
import com.yundian.fssapi.service.FssLoanService;
import com.yundian.result.Page;
import com.yundian.result.Paginator;
import com.yundian.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

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


    @RequestMapping(value="/loan/loanList",method= RequestMethod.GET)
    public String loanList() {

        return "/loan/loanList";

    }

    @ResponseBody
    @RequestMapping(value="/loan/submitLoan",method= RequestMethod.POST)
    public Result submitLoan(@ModelAttribute("fssLoanModelVo") FssLoanModelVo fssLoanModel) {

        try {
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
            fssLoanService.updateFssLoan(fssLoanModel);
            return Result.success("");
        } catch (Exception ex) {
            log.error(String.format("增加贷款信息异常："), ex);
            System.out.printf(ex.getMessage());
            return Result.fail("", "增加贷款信息异常，请重试");
        }
    }

    @ResponseBody
    @RequestMapping(value="/loan/addLoan",method= RequestMethod.POST)
    public Result addLoan(@ModelAttribute("fssLoanModelVo") FssLoanModelVo fssLoanModel) {

        try {
            LoanInfoModel loanInfoModel = new LoanInfoModel();
            loanInfoModel.setFssLoanModel(fssLoanModel);
            loanInfoModel.setLoanId(fssLoanModel.getLoanId());

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
//            JSONObject resultJson = new JSONObject();
//            resultJson.put("fssLoanModel", BeanPropFieldUtil.toPropField(loanInfoModel.getFssLoanModel()));
//            resultJson.put("fssLoanDocumentModels",loanInfoModel.getFssLoanDocumentModels());
            return Result.success(loanInfoModel);
        } catch (Exception ex) {
            log.error(String.format("增加贷款信息异常："), ex);
            System.out.printf(ex.getMessage());
            return Result.fail("", "增加贷款信息异常，请重试");
        }
    }


    @ResponseBody
    @RequestMapping(value = "/loan/getList")
    public Result listAjax	(
            @RequestParam(defaultValue = "0", value = "page") int page,
            @RequestParam(defaultValue = "20", value = "pagesize") int pageSize,
            @RequestParam(defaultValue = "{}", value = "queryJson") String loanQueryParamJson,
            HttpSession session) {
        try {

            Paginator<FssLoanModel> paginator = new Paginator<>();
            paginator.setCurrentPage(page);
            paginator.setPageSize(pageSize);
            FssLoanModel fssLoanQueryParam= JSON.parseObject(loanQueryParamJson,FssLoanModel.class);
            FssDealerUserModel fssDealerUserModel =(FssDealerUserModel) session.getAttribute(DealerWebConstants.SYS.WEB_USER_SESSION);
            fssLoanQueryParam.setDealerId(fssDealerUserModel.getDealerId());
            paginator.setParam(fssLoanQueryParam);
            Page<FssLoanModel> paginatedResult = fssLoanService.getPaginatorFssLoan(paginator);
            return Result.success(paginatedResult);

        } catch (Exception ex) {
            log.error(String.format("分页查询贷款信息异常："), ex);
            System.out.printf(ex.getMessage());
            return Result.fail("","网络异常，请重试");
        }
    }

}
