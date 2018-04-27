package com.yundian.dealerweb.controller;

import com.alibaba.fastjson.JSON;
import com.yundian.fssapi.domain.FssDealerModel;
import com.yundian.fssapi.domain.FssDealerUserModel;
import com.yundian.fssapi.domain.FssLoanModel;
import com.yundian.fssapi.domain.statistics.LoanInfoModel;
import com.yundian.fssapi.domain.vo.LoanDocumentVo;
import com.yundian.fssapi.domain.vo.LoanInfoVo;
import com.yundian.fssapi.domain.vo.match.LoanDocumentVoMatch;
import com.yundian.fssapi.service.FssLoanService;
import com.yundian.result.Page;
import com.yundian.result.Paginator;
import com.yundian.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
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
    @RequestMapping(value="/loan/audit",method= RequestMethod.POST)
    public Result submitLoan(@RequestParam("loanId") Long loanId,
                             @RequestParam("type") String auditType,
                             @RequestParam("reason") String reason) {

        try {
            switch (auditType)
            {
                case "auditOk":
                    fssLoanService.auditPass(loanId,"");
                    break;
                case "auditReject":
                    fssLoanService.auditReject(loanId,reason,"");
                    break;
                case "auditReturn":
                    fssLoanService.returnLoan(loanId,"");
                    break;
            }
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

            LoanInfoVo loanInfoVo= new LoanInfoVo();
            loanInfoVo.setFssLoanModel(loanInfoModel.getFssLoanModel());
            List<LoanDocumentVo> loanDocumentVoList = LoanDocumentVoMatch.matchList(loanInfoModel.getFssLoanDocumentModels());
            Map<String,List<LoanDocumentVo>> listMap = loanDocumentVoList.stream()
                        .collect(Collectors.groupingBy(LoanDocumentVo::getDocumentType));
            loanInfoVo.setFssLoanDocs(listMap);

            return Result.success(loanInfoVo);
        } catch (Exception ex) {
            log.error(String.format("换取贷款信息异常："), ex);
            System.out.printf(ex.getMessage());
            return Result.fail("", "换取贷款信息异常，请重试");
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
