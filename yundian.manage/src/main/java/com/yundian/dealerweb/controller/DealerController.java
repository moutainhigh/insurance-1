package com.yundian.dealerweb.controller;

import com.alibaba.fastjson.JSON;
import com.yundian.fssapi.domain.FssDealerModel;
import com.yundian.fssapi.domain.FssDealerUserModel;
import com.yundian.fssapi.service.FssDealerService;
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
public class DealerController {

    @Autowired
    FssDealerService fssDealerService;



    @ResponseBody
    @RequestMapping(value="/dealer/updateDealer",method= RequestMethod.POST)
    public Result updateLoan(@ModelAttribute("fssDealerModel") FssDealerModel fssDealerModel) {

        try {

            fssDealerService.updateFssDealer(fssDealerModel);
            return Result.success("");
        } catch (Exception ex) {
            log.error(String.format("修改客户信息异常："), ex);
            System.out.printf(ex.getMessage());
            return Result.fail("", "修改客户信息异常，请重试");
        }
    }

    @ResponseBody
    @RequestMapping(value="/dealer/addDealer",method= RequestMethod.POST)
    public Result addLoan(@ModelAttribute("fssDealerModel") FssDealerModel fssDealerModel,HttpSession session) {

        try {
            fssDealerService.addFssDealer(fssDealerModel);
            return Result.success("");
        } catch (Exception ex) {
            log.error(String.format("增加经销商信息异常："), ex);
            System.out.printf(ex.getMessage());
            return Result.fail("", "增加客户信息异常，请重试");
        }
    }


    @ResponseBody
    @RequestMapping(value="/dealer/getInfo",method= RequestMethod.GET)
    public Result getInfo(@RequestParam(value="dealerId") Long dealerId) {

        try {
            if(dealerId==null||dealerId<=0)
            {
                return Result.fail("", "参数错误，请重试");
            }
            FssDealerModel fssDealerModel =fssDealerService.getFssDealer(dealerId);
            return Result.success(fssDealerModel);
        } catch (Exception ex) {
            log.error(String.format("获取经销商信息异常："), ex);
            System.out.printf(ex.getMessage());
            return Result.fail("", "获取经销商信息异常，请重试");
        }
    }


    @ResponseBody
    @RequestMapping(value = "/dealer/getList")
    public Result listAjax	(
            @RequestParam(defaultValue = "0", value = "page") int page,
            @RequestParam(defaultValue = "20", value = "pagesize") int pageSize,
            @ModelAttribute("fssLoanQueryParam") FssDealerModel fssLoanQueryParam,
            HttpSession session) {
        try {

            Paginator<FssDealerModel> paginator = new Paginator<>();
            paginator.setPage(page);
            paginator.setPageSize(pageSize);
            paginator.setParam(fssLoanQueryParam);

            Page<FssDealerModel> paginatedResult = fssDealerService.getPaginatorFssDealer(paginator);
            return Result.success(paginatedResult);

        } catch (Exception ex) {
            log.error(String.format("分页查询客户信息异常："), ex);
            System.out.printf(ex.getMessage());
            return Result.fail("","网络异常，请重试");
        }
    }
}
