package com.yundian.dealerweb.controller;

import com.yundian.fssapi.domain.FssLoanModel;
import com.yundian.fssapi.domain.FssLoanRepaymentModel;
import com.yundian.fssapi.service.FssDealerCustomerService;
import com.yundian.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @author jnx
 * @create 2018/4/10
 */
@Slf4j
@Controller
public class RepaymentController {

    @Autowired
    FssDealerCustomerService fssDealerCustomerService;

    @ResponseBody
    @RequestMapping(value = "/repayment/getList")
    public Result listAjax	(
            @RequestParam(defaultValue = "0", value = "page") int page,
            @RequestParam(defaultValue = "20", value = "pagesize") int pageSize,
            @ModelAttribute("fssLoanQueryParam") FssLoanRepaymentModel fssLoanQueryParam,
            HttpSession session) {
        try {

//            Paginator<FssDealerCustomerModel> paginator = new Paginator<>();
//            paginator.setCurrentPage(page);
//            paginator.setPageSize(pageSize);
//            FssDealerCustomerModel fssLoanQueryParam= JSON.parseObject(loanQueryParamJson,FssDealerCustomerModel.class);
//            FssDealerUserModel fssDealerUserModel =(FssDealerUserModel) session.getAttribute(DealerWebConstants.SYS.WEB_USER_SESSION);
//            fssLoanQueryParam.setDealerId(fssDealerUserModel.getDealerId());
//            paginator.setParam(fssLoanQueryParam);
//
//            Page<FssDealerCustomerModel> paginatedResult = fssDealerCustomerService.getPaginatorFssDealerCustomer(paginator);
//            return Result.success(paginatedResult);
            return Result.success("");

        } catch (Exception ex) {
            log.error(String.format("分页查询客户信息异常："), ex);
            System.out.printf(ex.getMessage());
            return Result.fail("","网络异常，请重试");
        }
    }
}
