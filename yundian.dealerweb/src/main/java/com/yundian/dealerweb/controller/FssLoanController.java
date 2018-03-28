package com.yundian.dealerweb.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.yundian.fssapi.domain.FssLoanRelationModel;
import com.yundian.fssapi.domain.query.FssLoanAuditingLogQueryModel;
import com.yundian.fssapi.domain.query.FssLoanQueryModel;
import com.yundian.fssapi.dto.param.FssLoanQueryParam;
import com.yundian.fssapi.service.FssLoanAuditingLogService;
import com.yundian.fssapi.service.FssLoanRelationService;
import com.yundian.fssapi.service.FssLoanService;
import com.yundian.result.DataTablesPaginatedResult;
import com.yundian.result.PaginatedResult;
import com.yundian.result.Paginator;
import com.yundian.result.Result;
import com.yundian.result.ResultCodeContants;

@Controller
@RequestMapping("/fss/loan")
public class FssLoanController {
	private static final Logger logger = Logger
			.getLogger(FssLoanController.class);

	@Autowired
	private FssLoanService fssLoanService;
	
	@Autowired
	private FssLoanAuditingLogService fssLoanAuditingLogService;

	@Autowired
	private FssLoanRelationService fssLoanRelationService;

	
	@RequestMapping(value = "/loanList.html", method = RequestMethod.GET)
	public String loanList(HttpServletRequest httpRequest) {
		return "/loan/loanList";
	}

	//异步
	@RequestMapping(value = "/loanDetail.html", method = RequestMethod.GET)
	public String loanDetail( @RequestParam(defaultValue = "0", value = "loanId") Long loanId,
			ModelMap context) {
		context.put("loanId", loanId);
		Result<List<FssLoanRelationModel>> fssLoanRelationList=
				fssLoanRelationService.getFssLoanRelationListByLoanId(loanId);
		context.put("fssLoanRelationList",fssLoanRelationList);
		Result<List<FssLoanAuditingLogQueryModel>> auditingLogList = 
				fssLoanAuditingLogService.getFssLoanAuditingLogListByLoanId(loanId);
		context.put("auditingLogList",auditingLogList);
		return "/loan/loanDetail";
	}

	@ResponseBody
	@RequestMapping(value = "/listAjax", method = RequestMethod.POST)
	public DataTablesPaginatedResult<FssLoanQueryModel> listAjax(
			@RequestParam(defaultValue = "0", value = "start") int start,
			@RequestParam(defaultValue = "15", value = "length") int pageSize,
			@RequestParam(defaultValue = "{}", value = "queryJson") String loanQueryParamJson,
			HttpSession session) {
		DataTablesPaginatedResult<FssLoanQueryModel> dataTablesPaginatedResult = new DataTablesPaginatedResult<FssLoanQueryModel>();
		try {
			Paginator<FssLoanQueryParam> paginator = new Paginator<FssLoanQueryParam>();
			paginator.setCurrentPage(start / pageSize + 1);
			paginator.setPageSize(pageSize);
			
			//TODO 多个担保公司 一定要选择一个 前台控制
			FssLoanQueryParam fssLoanQueryParam= JSONObject.parseObject(loanQueryParamJson,
					FssLoanQueryParam.class);
			if(fssLoanQueryParam.getGuaranteeId()==null){
				return dataTablesPaginatedResult;
			}
			paginator.setParam(fssLoanQueryParam);
			Result<PaginatedResult<FssLoanQueryModel>> result = this.fssLoanService
					.getPaginatorFssLoan(paginator);

			if (result.getCode() == ResultCodeContants.success) {
				dataTablesPaginatedResult.setData(result.getData().getRows());
				dataTablesPaginatedResult.setRecordsTotal(result.getData()
						.getTotal());
				dataTablesPaginatedResult.setRecordsFiltered(result.getData()
						.getTotal());
			} else {
				dataTablesPaginatedResult.setErrorMsg(result.getMessage());
			}
		} catch (Exception ex) {
			logger.error(String.format("分页查询贷款信息异常："), ex);
			dataTablesPaginatedResult.setErrorMsg("网络异常，请重试");
		}
		return dataTablesPaginatedResult;
	}

}
