package com.yundian.dealerweb.controller;

import com.yundian.fssapi.domain.FssLoanModel;
import com.yundian.fssapi.domain.FssLoanRepaymentModel;
import com.yundian.fssapi.domain.FssLoanRepaymentPlanModel;
import com.yundian.fssapi.enums.FssLoanStatusEnum;
import com.yundian.fssapi.enums.FssRepaymentStatusEnum;
import com.yundian.fssapi.service.FssDealerCustomerService;
import com.yundian.fssapi.service.FssRepaymentService;
import com.yundian.fssapi.service.FssRepaymentWithHoldService;
import com.yundian.result.Page;
import com.yundian.result.Paginator;
import com.yundian.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @author jnx
 * @create 2018/4/10
 */
@Slf4j
@Controller
public class RepaymentController {

    @Autowired
    FssRepaymentService fssRepaymentService;
    @Autowired
    FssRepaymentWithHoldService fssRepaymentWithHoldService;


    @ResponseBody
    @RequestMapping(value="/repayment/witholding",method= RequestMethod.POST)
    public Result withoding(@RequestParam("planId") long planId){

        try {
            fssRepaymentWithHoldService.tradeWithHolding(planId);
            return Result.success("");
        }catch (Exception e){
            return Result.fail("",e.getMessage());
        }
    }
    @ResponseBody
    @RequestMapping(value = "/repayment/getPlans")
    public Result listAjax	(
            @RequestParam(defaultValue = "0", value = "loanId") long loanId) {
        try {

            int page=1;
            int pageSize=36;
            Paginator<FssLoanRepaymentPlanModel> paginator = new Paginator<>();
            paginator.setPage(page);
            paginator.setPageSize(pageSize);
            FssLoanRepaymentPlanModel fssLoanQueryParam= new FssLoanRepaymentPlanModel();
            fssLoanQueryParam.setLoanId(loanId);
            paginator.setParam(fssLoanQueryParam);
            Page<FssLoanRepaymentPlanModel> paginatedResult = fssRepaymentService.getRepaymentPlan(paginator);

            if(paginatedResult.getItems().size()>0) {
                paginatedResult.getItems().stream().forEach(e -> {
                    try {
                        e.setRepaymentStatus(FssRepaymentStatusEnum.valueOf(e.getRepaymentStatus()).getDescription());
                    } catch (Exception ex) {
                        log.error(ex.getMessage());
                    }
                });
            }
            return Result.success(paginatedResult.getItems());

        } catch (Exception ex) {
            log.error(String.format("还款计划信息异常："), ex);
            System.out.printf(ex.getMessage());
            return Result.fail("","网络异常，请重试");
        }
    }
}
