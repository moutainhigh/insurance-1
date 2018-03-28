package com.yundian.dealerweb.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.yundian.fssapi.domain.FssUserModel;
import com.yundian.fssapi.domain.query.FssUserQueryModel;
import com.yundian.fssapi.dto.param.FssGuaranteeUserParam;
import com.yundian.fssapi.service.FssGuaranteeService;
import com.yundian.fssapi.service.FssGuaranteeUserService;
import com.yundian.dealerweb.util.GuaranteeWebConstants;
import com.yundian.result.DataTablesPaginatedResult;
import com.yundian.result.PaginatedResult;
import com.yundian.result.Paginator;
import com.yundian.result.Result;
import com.yundian.result.ResultCodeContants;
import com.yundian.toolkit.utils.MD5;
import com.yundian.toolkit.utils.WebUtil;

@Controller
@RequestMapping("/fss/guaranteeuser")
public class FssGuaranteeUserController {
	private static final Logger logger = Logger
			.getLogger(FssGuaranteeUserController.class);

	@Autowired
	private FssGuaranteeService fssGuaranteeService;
	@Autowired
	private FssGuaranteeUserService fssGuaranteeUserService;

	@RequestMapping(value = "/guaranteeUserList.html", method = RequestMethod.GET)
	public String guaranteeUserList(HttpServletRequest httpRequest) {
		return "guarantee/guaranteeUserList";
	}


	@ResponseBody
	@RequestMapping(value = "/addGuaranteeUser", method = RequestMethod.POST)
	public String addGuarantee(
			@RequestParam(value = "userinfo") String userinfo,
			HttpSession session) {
		try {
			FssGuaranteeUserParam fssUserModel=JSONObject.parseObject(userinfo,FssGuaranteeUserParam.class);
			fssUserModel.setUserPwd(MD5.encodePassword(fssUserModel.getUserPwd()));
			Result<Long> result = fssGuaranteeUserService
					.addGuaranteeUser(fssUserModel);
			
			if (result.getCode() == ResultCodeContants.success) {
				return WebUtil.getSuccessJson("添加成功");
			} else {
				return WebUtil.getFailureJson(result.getMessage());
			}
		} catch (Exception ex) {
			logger.error(String.format("添加担保机构用户信息异常："),ex);
			return WebUtil.getFailureJson("添加失败，请重试");
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/updateGuaranteeUser", method = RequestMethod.POST)
	public String updateGuarantee(
			@RequestParam(value = "userinfo") String guaranteeJson,
			HttpServletRequest httpRequest) {
		try {
			FssGuaranteeUserParam fssUserModel=JSONObject.parseObject(guaranteeJson,FssGuaranteeUserParam.class);
			Result<Integer> result= this.fssGuaranteeUserService.updateGuaranteeUser(fssUserModel);
			if (result.getCode() == ResultCodeContants.success) {
				return WebUtil.getSuccessJson("修改成功");
			} else {
				return WebUtil.getFailureJson(result.getMessage());
			}
		} catch (Exception ex) {
			logger.error(String.format("修改担保机构用户异常："),ex);
			return WebUtil.getFailureJson("系统错误");
		}
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/listAjax", method = RequestMethod.POST)
	public DataTablesPaginatedResult<FssUserQueryModel> listAjax(
			@RequestParam(defaultValue = "0", value = "start") int start,
			@RequestParam(defaultValue = "15", value = "length") int pageSize,
			@RequestParam(defaultValue = "{}", value = "queryJson") String fssUserQueryModelJson,
			HttpSession session) {
		DataTablesPaginatedResult<FssUserQueryModel> dataTablesPaginatedResult=new DataTablesPaginatedResult<FssUserQueryModel>();
		try {
			Paginator<FssUserQueryModel> paginator = new Paginator<FssUserQueryModel>();
			paginator.setCurrentPage(start/pageSize+1);
			paginator.setPageSize(pageSize);
			FssUserQueryModel fssUserQueryModel=
					JSONObject.parseObject(fssUserQueryModelJson, FssUserQueryModel.class);
			if(fssUserQueryModel.getGuaranteeId()==null){
				FssUserModel loginUser=(FssUserModel) session.getAttribute(GuaranteeWebConstants.SYS.WEB_USER_SESSION);
				fssUserQueryModel.setGuaranteeId(loginUser.getGuaranteeUserQueryList().get(0).getGuaranteeId());
			}
			paginator.setParam(fssUserQueryModel);
			Result<PaginatedResult<FssUserQueryModel>> result = fssGuaranteeUserService
					.getPaginatedResult(paginator);
			
			if (result.getCode() == ResultCodeContants.success) {
				dataTablesPaginatedResult.setData(result.getData().getRows());
				dataTablesPaginatedResult.setRecordsTotal(result.getData().getTotal());
				dataTablesPaginatedResult.setRecordsFiltered(result.getData().getTotal());
			} else {
				dataTablesPaginatedResult.setErrorMsg(result.getMessage());
			}
		} catch (Exception ex) {
			logger.error(String.format("查询担保机构用户信息异常："),ex);
			dataTablesPaginatedResult.setErrorMsg("网络异常，请重试");
		}
		return dataTablesPaginatedResult;
	}
	
}
