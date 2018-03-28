package com.yundian.dealerweb.controller;

/**
 * Author: jiyanbin@zafh.com.cn
 * JDK: 1.8
 * Created on 16/8/10.
 */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.yundian.fssapi.domain.FssLoanModel;
import com.yundian.fssapi.domain.FssLoanRelationModel;
import com.yundian.fssapi.domain.query.FssLoanAuditingLogQueryModel;
import com.yundian.fssapi.service.FssLoanAuditingLogService;
import com.yundian.fssapi.service.FssLoanRelationService;
import com.yundian.fssapi.service.FssLoanService;
import com.yundian.result.Result;

/**
 * 修改历史 修改日期 修改人 问题类型 说明
 */
@Controller
@RequestMapping("/fss/loan")
public class ApproveProcessController {

	@Autowired
	private FssLoanService fssLoanService;
	@Autowired
	private FssLoanRelationService fssLoanRelationService;
	@Autowired
	private FssLoanAuditingLogService fssLoanAuditingLogService;
	
	@RequestMapping(value = "/loanApprove.html", method = RequestMethod.GET)
	public String loanApprove(@RequestParam(value = "loanId") Long loanId,
			ModelMap context) {
		try {
			context.put("loanId", loanId);
			
			Result<FssLoanModel> result=this.fssLoanService.getFssLoanById(loanId);
			context.put("fssLoan",result.getData());
			
			Result<List<FssLoanRelationModel>> fssLoanRelationList=
					fssLoanRelationService.getFssLoanRelationListByLoanId(loanId);
			
			context.put("fssLoanRelationList",fssLoanRelationList);
			Result<List<FssLoanAuditingLogQueryModel>> auditingLogList = 
					fssLoanAuditingLogService.getFssLoanAuditingLogListByLoanId(loanId);
			context.put("auditingLogList",auditingLogList);
		} catch (Exception e) {
			context.put("errorMsg", "系统异常");
		}
		return "/loan/loanApprove";
	}
	
}
