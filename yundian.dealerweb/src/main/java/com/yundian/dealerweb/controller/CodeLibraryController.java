package com.yundian.dealerweb.controller;

import com.yundian.dealerweb.util.DealerWebConstants;
import com.yundian.fssapi.domain.FssCodeLibraryModel;
import com.yundian.fssapi.domain.FssDealerCustomerModel;
import com.yundian.fssapi.domain.FssDealerUserModel;
import com.yundian.fssapi.service.FssCodeLibraryService;
import com.yundian.fssapi.service.FssDealerCustomerService;
import com.yundian.result.Page;
import com.yundian.result.Paginator;
import com.yundian.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 字典
 * @author jnx
 * @create 2018/4/10
 */
@Slf4j
@Controller
public class CodeLibraryController {

    @Autowired
    FssCodeLibraryService fssCodeLibraryService;

    @ResponseBody
    @RequestMapping(value="/library/getTypeList",method= RequestMethod.GET)
    public Result updateLoan(@RequestParam("codeType") String codeType) {

        try {
            List<FssCodeLibraryModel> fssCodeLibraryModel= fssCodeLibraryService.getFssCodeLibraryListByType(codeType);
            return Result.success(fssCodeLibraryModel);
        } catch (Exception ex) {
            log.error(String.format("获取字典表失败："), ex);
            System.out.printf(ex.getMessage());
            return Result.fail("", "获取字典表异常，请重试");
        }
    }


    @ResponseBody
    @RequestMapping(value="/library/getInfo",method= RequestMethod.GET)
    public Result getInfo(@RequestParam("codeType") String codeType,
            @RequestParam(value="codeId") String codeId) {

        try {

            FssCodeLibraryModel fssCodeLibraryModel =fssCodeLibraryService.getFssCodeLibraryByCode(codeType,codeId);
            return Result.success(fssCodeLibraryModel);
        } catch (Exception ex) {
            log.error(String.format("获取字典信息异常："), ex);
            System.out.printf(ex.getMessage());
            return Result.fail("", "获取字典信息异常，请重试");
        }
    }


}
