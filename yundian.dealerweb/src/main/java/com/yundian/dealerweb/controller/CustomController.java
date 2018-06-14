package com.yundian.dealerweb.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yundian.dealerweb.util.DealerWebConstants;
import com.yundian.fssapi.domain.FssDealerCustomerModel;
import com.yundian.fssapi.domain.FssDealerUserModel;
import com.yundian.fssapi.service.FssDealerCustomerService;
import com.yundian.result.Page;
import com.yundian.result.Paginator;
import com.yundian.result.Result;
import com.yundian.toolkit.excel.ExcelUtil;
import com.yundian.toolkit.utils.RandomUtil;
import com.yundian.toolkit.utils.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author jnx
 * @create 2018/4/10
 */
@Slf4j
@Controller
public class CustomController {

    @Autowired
    FssDealerCustomerService fssDealerCustomerService;
    //临时缓存大小
    public static final int SIZE_THRESHOLD=10240000;
    @ResponseBody
    @RequestMapping(value = "/customer/importXls", method = RequestMethod.POST)
    public Result aoAliyunImgServer(HttpServletRequest request, HttpServletResponse response,HttpSession session) {


        try {
            FssDealerUserModel fssDealerUserModel =(FssDealerUserModel) session.getAttribute(DealerWebConstants.SYS.WEB_USER_SESSION);

            DiskFileItemFactory factory = new DiskFileItemFactory();
            // 设置内存缓冲区，超过后写入临时文件
            factory.setSizeThreshold(SIZE_THRESHOLD);
            ServletFileUpload upload = new ServletFileUpload(factory);
            List<?> items = upload.parseRequest(request);
            FileItem item = null;
            if(items.size()==0){
                return getFailedResult("文件不存在");
            }
            int successCount=0;
            for (int i = 0; i < items.size(); i++) {
                item = (FileItem) items.get(i);
                List<FssDealerCustomerModel> list = ExcelUtil.xlsToModel(item.getInputStream(), FssDealerCustomerModel.class);
                log.info("导入对象:" + JSON.toJSONString(list));
                if (list != null && list.size() > 0) {
                    for(FssDealerCustomerModel e:list){
                        e.setDealerId(fssDealerUserModel.getDealerId());
                        e.setCtime(new Date());
                        e.setMtime(new Date());
                        fssDealerCustomerService.insertFssDealerCustomer(e);
                        successCount++;
                    }
                }
            }
            return getSuccessResult(successCount);
        }catch (Exception e){
            log.error(String.format("导入客户数据异常："), e);
            return getFailedResult("导入客户数据异常,"+e.getMessage());
        }

    }
    private Result<?> getFailedResult(String message){
        return Result.fail("",message);
    }
    private Result<JSONObject> getSuccessResult(Integer count){
        JSONObject jsonData = new JSONObject();
        jsonData.put("successCount", count);
        return Result.success(jsonData);

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
