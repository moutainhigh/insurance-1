package com.yundian.dealerweb.controller;

import com.yundian.fssapi.domain.FssAdminUserModel;
import com.yundian.fssapi.domain.FssDealerUserModel;
import com.yundian.fssapi.service.FssAdminUserService;
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
public class AdminUserController {

    @Autowired
    FssAdminUserService fssAdminUserService;

    static  String Default_PASSWORD="456123";

    @ResponseBody
    @RequestMapping(value="/adminUser/updateUser",method= RequestMethod.POST)
    public Result updateLoan(@ModelAttribute("fssAdminUserModel") FssAdminUserModel fssAdminUserModel) {

        try {
            fssAdminUserModel.setUserPwd(null);
            fssAdminUserService.updateFssAdminUser(fssAdminUserModel);
            return Result.success("");
        } catch (Exception ex) {
            log.error(String.format("修改客户信息异常："), ex);
            System.out.printf(ex.getMessage());
            return Result.fail("", "修改客户信息异常，请重试");
        }
    }

    @ResponseBody
    @RequestMapping(value="/adminUser/addUser",method= RequestMethod.POST)
    public Result addLoan(@ModelAttribute("fssAdminUserModel") FssAdminUserModel fssAdminUserModel,HttpSession session) {

        try {
            fssAdminUserModel.setUserPwd(Default_PASSWORD);
            fssAdminUserService.insertFssAdminUser(fssAdminUserModel);
            return Result.success("");
        } catch (Exception ex) {
            log.error(String.format("增加客户信息异常："), ex);
            System.out.printf(ex.getMessage());
            return Result.fail("", "增加客户信息异常，请重试");
        }
    }
    @ResponseBody
    @RequestMapping(value="/adminUser/resetPwd",method= RequestMethod.POST)
    public Result resetPwd(@RequestParam(value="userId") Long userId) {

        try {
            FssAdminUserModel fssAdminUserModel= fssAdminUserService.getFssAdminUser(userId);
            fssAdminUserService.resetPwd(userId,fssAdminUserModel.getUserName());
            return Result.success("");
        } catch (Exception ex) {
            log.error(String.format("重置密码成功："), ex);
            System.out.printf(ex.getMessage());
            return Result.fail("", "重置密码异常，请重试");
        }
    }

    @ResponseBody
    @RequestMapping(value="/adminUser/getInfo",method= RequestMethod.GET)
    public Result getInfo(@RequestParam(value="userId") Long userId) {

        try {
            if(userId==null||userId<=0)
            {
                return Result.fail("", "参数错误，请重试");
            }
            FssAdminUserModel fssAdminUserModel =fssAdminUserService.getFssAdminUser(userId);
            fssAdminUserModel.setUserPwd(null);
            return Result.success(fssAdminUserModel);
        } catch (Exception ex) {
            log.error(String.format("获取客户信息异常："), ex);
            System.out.printf(ex.getMessage());
            return Result.fail("", "获取客户信息异常，请重试");
        }
    }


    @ResponseBody
    @RequestMapping(value = "/adminUser/getList")
    public Result listAjax	(
            @RequestParam(defaultValue = "0", value = "page") int page,
            @RequestParam(defaultValue = "20", value = "pagesize") int pageSize,
            @ModelAttribute("fssLoanQueryParam") FssAdminUserModel fssLoanQueryParam,
            HttpSession session) {
        try {

            Paginator<FssAdminUserModel> paginator = new Paginator<>();
            paginator.setPage(page);
            paginator.setPageSize(pageSize);

            Page<FssAdminUserModel> paginatedResult = fssAdminUserService.getPaginatorFssAdminUser(paginator);
            return Result.success(paginatedResult);

        } catch (Exception ex) {
            log.error(String.format("分页查询客户信息异常："), ex);
            System.out.printf(ex.getMessage());
            return Result.fail("","网络异常，请重试");
        }
    }
}
