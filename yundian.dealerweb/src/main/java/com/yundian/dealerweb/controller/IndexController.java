package com.yundian.dealerweb.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {

	Logger logger = Logger.getLogger(IndexController.class);
//	@Autowired
////	private FssLoanService fssLoanService;
//	@Autowired
////	private FssCreditService fssCreditService;
	
	@RequestMapping(value = { "/index.html" }, method = RequestMethod.GET)
	public String index(ModelMap context,HttpSession session) {


//			Long bankId=0L;
//			Map<String,Object> map = new HashMap<String, Object>();
//			FssDealerCustomerModel userinfo = (FssDealerCustomerModel)session.getAttribute(DealerWebConstants.SYS.WEB_USER_SESSION);
//			List<FssGuaranteeUserQueryModel>  listGuarantee= userinfo.getGuaranteeUserQueryList();
//			if(listGuarantee!=null&&listGuarantee.size()>0)
//			{
//				Result<Map<String, Integer>>  resultCreditStatus=  fssCreditService.getCreditStatusStat(listGuarantee.get(0).getGuaranteeId(),bankId);
//				Result<Map<String, Integer>>  resultLoanStatus = fssLoanService.loanStatusStat(listGuarantee.get(0).getGuaranteeId(),bankId);
//				map.put("creditStatus", resultCreditStatus.getData());
//				map.put("loanStatus", resultLoanStatus.getData());
//				result.setCode(resultCreditStatus.getCode());
//				result.setMessage(resultCreditStatus.getMessage()+resultLoanStatus.getMessage());
//				context.put("","");
//			}
			return "index";
		
	}
	
	@RequestMapping(value = "/404.html", method = RequestMethod.GET)
	public String notFound404() {
		return "404";
	}

}
