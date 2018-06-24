package com.yundian.weixin.controller;

import com.yundian.fssapi.domain.FssDealerModel;
import com.yundian.fssapi.domain.FssLoanModel;
import com.yundian.fssapi.domain.FssLoanRepaymentPlanModel;
import com.yundian.fssapi.domain.FssUserModel;
import com.yundian.fssapi.enums.FssLoanStatusEnum;
import com.yundian.fssapi.service.FssDealerService;
import com.yundian.fssapi.service.FssLoanService;
import com.yundian.fssapi.service.FssRepaymentService;
import com.yundian.result.Page;
import com.yundian.result.Paginator;
import com.yundian.weixin.util.WeixinWebConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Slf4j
@Controller
public class LoanController {

	@Autowired
	FssLoanService fssLoanService;

	@Autowired
	FssDealerService fssDealerService;

	@Autowired
	FssRepaymentService fssRepaymentService;
	
	@RequestMapping(value ="/loan.html", method = RequestMethod.GET)
	public String Loan(Model model, HttpSession session) {
		FssUserModel fssUserModel =(FssUserModel) session.getAttribute(WeixinWebConstants.SYS.WEB_USER_SESSION);
		List<FssLoanModel> fssLoanModelList = fssLoanService.getFssLoanListByIdCardNo(fssUserModel.getIdCardNo());
		if(fssLoanModelList.size()>0) {
			fssLoanModelList.stream().forEach(e -> {
				try {
					e.setAuditStatusName(FssLoanStatusEnum.valueOf(e.getAuditStatus()).desc());
					e.setPlanLoanAmount(e.getPlanLoanAmount()/100);
				} catch (Exception ex) {
					log.error(ex.getMessage());
				}
			});
		}
		model.addAttribute("loanList",fssLoanModelList);
		return "Loan";
		
	}
	
	@RequestMapping(value = "/loanDetail.html", method = RequestMethod.GET)
	public String LoanDetail(@RequestParam("loanId") Long loanId,Model model) {

		FssLoanModel fssLoanModel = fssLoanService.getFssLoanModel(loanId);
		try {
			fssLoanModel.setAuditStatusName(FssLoanStatusEnum.valueOf(fssLoanModel.getAuditStatus()).desc());
			fssLoanModel.setPlanLoanAmount(fssLoanModel.getPlanLoanAmount()/100);
		} catch (Exception ex) {
			log.error(ex.getMessage());
		}
		model.addAttribute("loanInfo",fssLoanModel);
		return "LoanDetail";
	}

	@RequestMapping(value = "/loanPlan.html", method = RequestMethod.GET)
	public String LoanPlan(@RequestParam("loanId") Long loanId,Model model) {

		Paginator<FssLoanRepaymentPlanModel> paginator = new Paginator<>();
		paginator.setPage(1);
		paginator.setPageSize(48);
		FssLoanRepaymentPlanModel planModel = new FssLoanRepaymentPlanModel();
		planModel.setLoanId(loanId);
		paginator.setParam(planModel);
		Page<FssLoanRepaymentPlanModel> pagePlanModel = fssRepaymentService.getRepaymentPlan(paginator);
		if(pagePlanModel.getItems().size()>0) {
			pagePlanModel.getItems().stream().forEach(e -> {
				try {
					e.setPayAmount(e.getPayAmount()/100);
					e.setPlanAmount(e.getPlanAmount()/100);
				} catch (Exception ex) {
					log.error(ex.getMessage());
				}
			});
		}
		model.addAttribute("planList",pagePlanModel.getItems());
		FssLoanModel fssLoanModel = fssLoanService.getFssLoanModel(loanId);
		model.addAttribute("loanAmount",fssLoanModel.getPlanLoanAmount()/100);
		return "LoanPlan";
	}

	@RequestMapping(value = "/dealer.html", method = RequestMethod.GET)
	public String dealer(@RequestParam("dealerId") Long dealerId,Model model,HttpSession session) {

		FssDealerModel fssDealerModel = fssDealerService.getFssDealer(dealerId);
		model.addAttribute("dealer",fssDealerModel);
		return "DealerService";
	}

}
