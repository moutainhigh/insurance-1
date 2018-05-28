package com.yundian.dealerweb.controller;

import com.alibaba.fastjson.JSON;
import com.yundian.dealerweb.util.DealerWebConstants;
import com.yundian.fssapi.domain.FssDealerCustomerModel;
import com.yundian.fssapi.domain.FssDealerUserModel;
import com.yundian.fssapi.service.FssDealerCustomerService;
import com.yundian.fssapi.service.FssDealerUserService;
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
public class DealerUserController {

    @Autowired
    FssDealerUserService fssDealerUserService;



    @ResponseBody
    @RequestMapping(value="/dealerUser/updateUser",method= RequestMethod.POST)
    public Result updateLoan(@ModelAttribute("fssDealerUserModel") FssDealerUserModel fssDealerUserModel) {

        try {

            fssDealerUserService.updateFssDealerUser(fssDealerUserModel);
            return Result.success("");
        } catch (Exception ex) {
            log.error(String.format("修改客户信息异常："), ex);
            System.out.printf(ex.getMessage());
            return Result.fail("", "修改客户信息异常，请重试");
        }
    }
    @ResponseBody
    @RequestMapping(value="/dealerUser/resetPwd",method= RequestMethod.POST)
    public Result resetPwd(@RequestParam(value="userId") Long userId) {

        try {
            FssDealerUserModel fssDealerUserModel= fssDealerUserService.getFssDealerUser(userId);
            fssDealerUserService.resetPwd(userId,fssDealerUserModel.getUserName());
            return Result.success("");
        } catch (Exception ex) {
            log.error(String.format("重置密码成功："), ex);
            System.out.printf(ex.getMessage());
            return Result.fail("", "重置密码异常，请重试");
        }
    }


    @ResponseBody
    @RequestMapping(value="/dealerUser/addUser",method= RequestMethod.POST)
    public Result addLoan(@ModelAttribute("fssDealerUserModel") FssDealerUserModel fssDealerUserModel,HttpSession session) {

        try {
            FssDealerUserModel fssDealerUserModelManage =(FssDealerUserModel) session.getAttribute(DealerWebConstants.SYS.WEB_USER_SESSION);
            fssDealerUserModelManage.setDealerId(fssDealerUserModel.getDealerId());

            fssDealerUserService.insertFssDealerUser(fssDealerUserModel);
            return Result.success("");
        } catch (Exception ex) {
            log.error(String.format("增加客户信息异常："), ex);
            System.out.printf(ex.getMessage());
            return Result.fail("", "增加客户信息异常，请重试");
        }
    }


    @ResponseBody
    @RequestMapping(value="/dealerUser/getInfo",method= RequestMethod.GET)
    public Result getInfo(@RequestParam(value="userId") Long userId) {

        try {
            if(userId==null||userId<=0)
            {
                return Result.fail("", "参数错误，请重试");
            }
            FssDealerUserModel fssDealerUserModel =fssDealerUserService.getFssDealerUser(userId);
            return Result.success(fssDealerUserModel);
        } catch (Exception ex) {
            log.error(String.format("获取客户信息异常："), ex);
            System.out.printf(ex.getMessage());
            return Result.fail("", "获取客户信息异常，请重试");
        }
    }


    @ResponseBody
    @RequestMapping(value = "/dealerUser/getList")
    public Result listAjax	(
            @RequestParam(defaultValue = "0", value = "page") int page,
            @RequestParam(defaultValue = "20", value = "pagesize") int pageSize,
            @ModelAttribute("fssLoanQueryParam") FssDealerUserModel fssLoanQueryParam,
            HttpSession session) {
        try {

            Paginator<FssDealerUserModel> paginator = new Paginator<>();
            paginator.setPage(page);
            paginator.setPageSize(pageSize);
            FssDealerUserModel fssDealerUserModel =(FssDealerUserModel) session.getAttribute(DealerWebConstants.SYS.WEB_USER_SESSION);
            fssLoanQueryParam.setDealerId(fssDealerUserModel.getDealerId());
            paginator.setParam(fssLoanQueryParam);

            Page<FssDealerUserModel> paginatedResult = fssDealerUserService.getPaginatorFssDealerUser(paginator);
            return Result.success(paginatedResult);

        } catch (Exception ex) {
            log.error(String.format("分页查询客户信息异常："), ex);
            System.out.printf(ex.getMessage());
            return Result.fail("","网络异常，请重试");
        }
    }
}
