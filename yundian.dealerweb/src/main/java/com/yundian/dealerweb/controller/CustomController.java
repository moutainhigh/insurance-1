package com.yundian.dealerweb.controller;

import com.alibaba.fastjson.JSON;
import com.yundian.dealerweb.util.DealerWebConstants;
import com.yundian.fssapi.domain.FssDealerCustomerModel;
import com.yundian.fssapi.domain.FssDealerUserModel;
import com.yundian.fssapi.service.FssDealerCustomerService;
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
public class CustomController {

    @Autowired
    FssDealerCustomerService fssDealerCustomerService;


    @RequestMapping(value="/customer/customerList",method= RequestMethod.GET)
    public String loanList() {

        return "/customer/customerList";

    }

    @ResponseBody
    @RequestMapping(value="/customer/updateCustomer",method= RequestMethod.POST)
    public Result updateLoan(@ModelAttribute("fssDealerCustomerModel") FssDealerCustomerModel fssDealerCustomerModel) {

        try {
            fssDealerCustomerService.updateFssDealerCustomer(fssDealerCustomerModel);
            return Result.success("");
        } catch (Exception ex) {
            log.error(String.format("修改客户信息异常："), ex);
            System.out.printf(ex.getMessage());
            return Result.fail("", "修改客户信息异常，请重试");
        }
    }

    @ResponseBody
    @RequestMapping(value="/customer/addCustomer",method= RequestMethod.POST)
    public Result addLoan(@ModelAttribute("fssDealerCustomerModel") FssDealerCustomerModel fssDealerCustomerModel,HttpSession session) {

        try {
            FssDealerUserModel fssDealerUserModel =(FssDealerUserModel) session.getAttribute(DealerWebConstants.SYS.WEB_USER_SESSION);
            fssDealerCustomerModel.setDealerId(fssDealerUserModel.getDealerId());
            fssDealerCustomerService.insertFssDealerCustomer(fssDealerCustomerModel);
            return Result.success("");
        } catch (Exception ex) {
            log.error(String.format("增加客户信息异常："), ex);
            System.out.printf(ex.getMessage());
            return Result.fail("", "增加客户信息异常，请重试");
        }
    }


    @ResponseBody
    @RequestMapping(value="/customer/getInfo",method= RequestMethod.GET)
    public Result getInfo(@RequestParam(value="id") Long id) {

        try {
            if(id==null||id<=0)
            {
                return Result.fail("", "参数错误，请重试");
            }
            FssDealerCustomerModel fssDealerCustomerModel =fssDealerCustomerService.getFssDealerCustomer(id);
            return Result.success(fssDealerCustomerModel);
        } catch (Exception ex) {
            log.error(String.format("获取客户信息异常："), ex);
            System.out.printf(ex.getMessage());
            return Result.fail("", "获取客户信息异常，请重试");
        }
    }


    @ResponseBody
    @RequestMapping(value = "/customer/getList")
    public Result listAjax	(
            @RequestParam(defaultValue = "0", value = "page") int page,
            @RequestParam(defaultValue = "20", value = "pagesize") int pageSize,
            @ModelAttribute("fssDealerCustomerModel") FssDealerCustomerModel fssLoanQueryParam,
            HttpSession session) {
        try {

            Paginator<FssDealerCustomerModel> paginator = new Paginator<>();
            paginator.setPage(page);
            paginator.setPageSize(pageSize);
            FssDealerUserModel fssDealerUserModel =(FssDealerUserModel) session.getAttribute(DealerWebConstants.SYS.WEB_USER_SESSION);
            fssLoanQueryParam.setDealerId(fssDealerUserModel.getDealerId());
            paginator.setParam(fssLoanQueryParam);

            Page<FssDealerCustomerModel> paginatedResult = fssDealerCustomerService.getPaginatorFssDealerCustomer(paginator);
            return Result.success(paginatedResult);

        } catch (Exception ex) {
            log.error(String.format("分页查询客户信息异常："), ex);
            System.out.printf(ex.getMessage());
            return Result.fail("","网络异常，请重试");
        }
    }
}
