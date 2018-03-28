package com.yundian.dealerweb.controller;

/**
 * Author: jiyanbin@zafh.com.cn
 * JDK: 1.8
 * Created on 16/8/10.
 */

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yundian.fssapi.domain.FssLoanAuditingLogModel;
import com.yundian.fssapi.domain.FssUserModel;
import com.yundian.fssapi.service.FssLoanService;
import com.yundian.dealerweb.util.GuaranteeWebConstants;
import com.yundian.result.Result;
import com.yundian.result.ResultCodeContants;
import com.yundian.toolkit.utils.WebUtil;

/**
 * 修改历史 修改日期 修改人 问题类型 说明
 */
@Controller
@RequestMapping("/fss/loan/process")
public class LoanProcessController {
	private static final Logger logger = LoggerFactory
			.getLogger(LoanProcessController.class);
	@Autowired
	private FssLoanService fssLoanService;

	@ResponseBody
	@RequestMapping(value = "/submit")
	public String submit(@RequestParam("loanId") Long loanId,
			@RequestParam("auditContent") String auditContent,
			HttpSession session) {
		try {
			FssUserModel fssUser = (FssUserModel) session
					.getAttribute(GuaranteeWebConstants.SYS.WEB_USER_SESSION);
			FssLoanAuditingLogModel fssLoanAuditingLogModel = new FssLoanAuditingLogModel();
			fssLoanAuditingLogModel.setAuditContent(auditContent);
			fssLoanAuditingLogModel.setLoanId(loanId);
			Result<Integer> result = fssLoanService.submitLoanApprove(fssUser,
					fssLoanAuditingLogModel);
			if (result.getCode() == ResultCodeContants.success) {
				return WebUtil.getSuccessJson("提交成功");
			} else {
				return WebUtil.getFailureJson(result.getMessage());
			}
		} catch (Exception e) {
			logger.error(String.format("提交贷款审批失败：%d", loanId));
			return WebUtil.getFailureJson("系统异常");
		}
	}
}
