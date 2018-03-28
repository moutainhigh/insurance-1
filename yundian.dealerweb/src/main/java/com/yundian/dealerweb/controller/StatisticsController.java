package com.yundian.dealerweb.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.yundian.fssapi.domain.FssUserModel;
import com.yundian.fssapi.domain.query.FssGuaranteeUserQueryModel;
import com.yundian.fssapi.domain.statistics.LoanCompareStatModel;
import com.yundian.fssapi.domain.statistics.LoanTypeMonthTrendStatModel;
import com.yundian.fssapi.domain.statistics.LoanTypeStatItemModel;
import com.yundian.fssapi.service.FssCreditService;
import com.yundian.fssapi.service.FssLoanService;
import com.yundian.dealerweb.util.GuaranteeWebConstants;
import com.yundian.result.Result;
import com.yundian.result.ResultProvider;
import com.yundian.toolkit.utils.DateUtils;
import com.yundian.toolkit.utils.WebUtil;

@Controller
@RequestMapping("/statistics")
public class StatisticsController {
	
	Logger logger = Logger.getLogger(StatisticsController.class);
	@Autowired
	private FssLoanService fssLoanService;
	@Autowired
	private FssCreditService fssCreditService;
	/**
	 * 贷款类型分布
	 * @param httpRequest
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/loantype", method = RequestMethod.GET)
	public String loantype(@RequestParam(defaultValue = "", value = "startDate") String startDate,
			@RequestParam(defaultValue = "", value = "endDate") String endDate,
			@RequestParam(defaultValue = "", value = "bankId") Long bankId,
			HttpSession session) {
		try
		{
			Result<List<LoanTypeStatItemModel>>  result=  new Result<List<LoanTypeStatItemModel>>();
			FssUserModel userinfo = (FssUserModel)session.getAttribute(GuaranteeWebConstants.SYS.WEB_USER_SESSION);
			List<FssGuaranteeUserQueryModel>  listGuarantee= userinfo.getGuaranteeUserQueryList();
			if(listGuarantee!=null&&listGuarantee.size()>0)
			{
				result=  fssLoanService.loanTypeStat(listGuarantee.get(0).getGuaranteeId(),bankId, startDate, endDate);
			}
			else
			{
				return ResultProvider.getsFailedResult("当前用户的合作机构为空").toString();
			}
			return JSON.toJSONString(result);
		
		} catch (Exception ex) {
			logger.error(String.format("获取贷款类型分布图失败："),ex);
			return WebUtil.getFailureJson("获取贷款类型分布图失败。");
		}
	}
	/**
	 * 业务量按月对比
	 * @param httpRequest
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/businesscontrast", method = RequestMethod.GET)
	public String businesscontrast(@RequestParam(defaultValue = "", value = "bankId") Long bankId,
			HttpSession session) {

		try
		{
			Result<LoanCompareStatModel>  result=  new Result<LoanCompareStatModel>();
			FssUserModel userinfo = (FssUserModel)session.getAttribute(GuaranteeWebConstants.SYS.WEB_USER_SESSION);
			List<FssGuaranteeUserQueryModel>  listGuarantee= userinfo.getGuaranteeUserQueryList();
			if(listGuarantee!=null&&listGuarantee.size()>0)
			{
				String startDate=DateUtils.format(DateUtils.getStartOfMonth(new Date()),"yyyy-MM-dd");
				result=  fssLoanService.loanCompareStat(listGuarantee.get(0).getGuaranteeId(),bankId,startDate);
			}
			else
			{
				return ResultProvider.getsFailedResult("当前用户的合作机构为空").toString();
			}
			return JSON.toJSONString(result);
		
		} catch (Exception ex) {
			
			logger.error(String.format("获取贷款业务量前后对比图标失败："),ex);
			return WebUtil.getFailureJson("获取贷款类型分布图标失败。");
		}
	}
 
	/**
	 * 征信和见证状态汇总
	 * @param bankId
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/statusstatistics", method = RequestMethod.GET)
	public String statusStatistics(@RequestParam(defaultValue = "", value = "bankId") Long bankId,
			HttpSession session) {
		try
		{
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
			}
			else
			{
				return ResultProvider.getsFailedResult("当前用户的合作机构为空").toString();

			}
			result.setData(map);
			return JSON.toJSONString(result);
		
		} catch (Exception ex) {
			
			logger.error(String.format("获取业务量走势图数据失败："),ex);
			return WebUtil.getFailureJson("获取业务量走势图数据失败。");
		}
		
	}
	/**
	 * 业务量走势图数据
	 * @param httpRequest
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/businesstrend", method = RequestMethod.GET)
	public String businesstrend(@RequestParam(defaultValue = "", value = "startDate") String startDate,
			@RequestParam(defaultValue = "", value = "endDate") String endDate,
			@RequestParam(defaultValue = "", value = "bankId") Long bankId,
			HttpSession session) {
		try
		{
			Result<LoanTypeMonthTrendStatModel>  result=  new Result<LoanTypeMonthTrendStatModel>();
			FssUserModel userinfo = (FssUserModel)session.getAttribute(GuaranteeWebConstants.SYS.WEB_USER_SESSION);
			List<FssGuaranteeUserQueryModel>  listGuarantee= userinfo.getGuaranteeUserQueryList();
			if(listGuarantee!=null&&listGuarantee.size()>0)
			{
				result=  fssLoanService.loanTypeCompareStat(listGuarantee.get(0).getGuaranteeId(),bankId,startDate,endDate);
			}
			else
			{
				return ResultProvider.getsFailedResult("当前用户的合作机构为空").toString();
			}
			return JSON.toJSONString(result);
		
		} catch (Exception ex) {
			
			logger.error(String.format("获取业务量走势图数据失败："),ex);
			return WebUtil.getFailureJson("获取业务量走势图数据失败。");
		}
		
	}
}
