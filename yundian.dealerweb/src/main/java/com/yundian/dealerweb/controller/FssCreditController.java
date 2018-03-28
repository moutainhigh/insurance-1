package com.yundian.dealerweb.controller;

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
import com.yundian.fssapi.domain.FssCreditModel;
import com.yundian.fssapi.domain.FssCreditRiskModel;
import com.yundian.fssapi.domain.FssUserModel;
import com.yundian.fssapi.dto.param.FssCreditQueryParam;
import com.yundian.fssapi.service.FssBankService;
import com.yundian.fssapi.service.FssCreditRiskService;
import com.yundian.fssapi.service.FssCreditService;
import com.yundian.fssapi.service.FssLoanService;
import com.yundian.dealerweb.util.GuaranteeWebConstants;
import com.yundian.result.DataTablesPaginatedResult;
import com.yundian.result.PaginatedResult;
import com.yundian.result.Paginator;
import com.yundian.result.Result;
import com.yundian.result.ResultCodeContants;

@Controller
@RequestMapping("/fss/credit")
public class FssCreditController {
	private static final Logger logger = Logger
			.getLogger(FssCreditController.class);

	@Autowired
	private FssLoanService fssLoanService;

	@Autowired
	private FssCreditService fssCreditService;
	@Autowired
	private FssCreditRiskService fssCreditRiskService;
	@Autowired
	private FssBankService fssBankService;
	@RequestMapping(value = "/creditList.html", method = RequestMethod.GET)
	public String creditList(HttpServletRequest httpRequest) {
		 
		return "/credit/creditList";
	}

	//异步
	@RequestMapping(value = "/creditDetail.html", method = RequestMethod.GET)
	public String loanDetail( @RequestParam(defaultValue = "0", value = "creditId") Long creditId,
			ModelMap context) {
		context.put("creditId", creditId);
		Result<FssCreditModel> fssCreditModelResult=
				fssCreditService.getFssCreditAndCreditLogById(creditId);
		context.put("fssCredit",fssCreditModelResult.getData());
		
		Result<FssCreditRiskModel> fssCreditRiskModel  = fssCreditRiskService.getFssCreditRiskAndDetailByCreditId(creditId);
		context.put("fssCreditRisk",fssCreditRiskModel.getData());
		
		
		return "/credit/creditDetail";
	}

	 
	
	 
	@ResponseBody
	@RequestMapping(value = "/listAjax", method = {RequestMethod.POST,RequestMethod.GET})
	public DataTablesPaginatedResult<FssCreditModel> listAjax(
			@RequestParam(defaultValue = "0", value = "start") int start,
			@RequestParam(defaultValue = "15", value = "length") int pageSize,
			@RequestParam(defaultValue = "{}", value = "queryJson") String loanQueryParamJson,
			HttpSession session) {
		DataTablesPaginatedResult<FssCreditModel> dataTablesPaginatedResult = new DataTablesPaginatedResult<FssCreditModel>();
		try {
			Paginator<FssCreditQueryParam> paginator = new Paginator<FssCreditQueryParam>();
			paginator.setCurrentPage(start / pageSize + 1);
			paginator.setPageSize(pageSize);
			 
			//TODO 多个担保公司 一定要选择一个 前台控制
			FssCreditQueryParam fssLoanQueryParam= JSONObject.parseObject(loanQueryParamJson,
					FssCreditQueryParam.class);
			Object objUserInfo = session.getAttribute(
					GuaranteeWebConstants.SYS.WEB_USER_SESSION);
			FssUserModel userInfo = (FssUserModel)objUserInfo;;
			
			fssLoanQueryParam.setGuaranteeUserId(userInfo.getUserId());
			/*if(fssLoanQueryParam.getGuaranteeId()==null){
				return dataTablesPaginatedResult;
			}*/
			paginator.setParam(fssLoanQueryParam);
			Result<PaginatedResult<FssCreditModel>> result = this.fssCreditService
					.getPaginatorFssCredit(paginator);

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
			logger.error(String.format("分页查询征信信息异常："), ex);
			dataTablesPaginatedResult.setErrorMsg("网络异常，请重试");
		}
		return dataTablesPaginatedResult;
	}

}