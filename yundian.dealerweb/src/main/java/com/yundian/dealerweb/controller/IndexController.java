package com.yundian.dealerweb.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yundian.fssapi.domain.FssUserModel;
import com.yundian.fssapi.domain.query.FssGuaranteeUserQueryModel;
import com.yundian.fssapi.service.FssCreditService;
import com.yundian.fssapi.service.FssLoanService;
import com.yundian.dealerweb.util.GuaranteeWebConstants;
import com.yundian.result.Result;

@Controller
public class IndexController {

	Logger logger = Logger.getLogger(IndexController.class);
	@Autowired
	private FssLoanService fssLoanService;
	@Autowired
	private FssCreditService fssCreditService;
	
	@RequestMapping(value = { "/index.html" }, method = RequestMethod.GET)
	public String index(ModelMap context,HttpSession session) {
		
			Long bankId=0L;
			Result<Map<String,Object>> result =new Result<Map<String,Object>>();
			Map<String,Object> map = new HashMap<String, Object>();
			FssUserModel userinfo = (FssUserModel)session.getAttribute(GuaranteeWebConstants.SYS.WEB_USER_SESSION);
			List<FssGuaranteeUserQueryModel>  listGuarantee= userinfo.getGuaranteeUserQueryList();
			if(listGuarantee!=null&&listGuarantee.size()>0)
			{
				Result<Map<String, Integer>>  resultCreditStatus=  fssCreditService.getCreditStatusStat(listGuarantee.get(0).getGuaranteeId(),bankId);
				Result<Map<String, Integer>>  resultLoanStatus = fssLoanService.loanStatusStat(listGuarantee.get(0).getGuaranteeId(),bankId);
				map.put("creditStatus", resultCreditStatus.getData());
				map.put("loanStatus", resultLoanStatus.getData());
				result.setCode(resultCreditStatus.getCode());
				result.setMessage(resultCreditStatus.getMessage()+resultLoanStatus.getMessage());
				context.put("","");
			}
			return "index";
		
	}
	
	@RequestMapping(value = "/404.html", method = RequestMethod.GET)
	public String notFound404() {
		return "404";
	}

}
