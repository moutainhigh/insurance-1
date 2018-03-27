package com.yundian.fss.service.impl;

import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.yundian.fss.exception.FssLoanBizException;
import com.yundian.fss.manager.FssOrganizationUserManager;
import com.yundian.fssapi.domain.FssOrganizationUserModel;
import com.yundian.fssapi.domain.query.FssOrganizationUserQueryModel;
import com.yundian.fssapi.service.FssOrganizationUserService;
import com.yundian.result.PaginatedResult;
import com.yundian.result.Paginator;
import com.yundian.result.Result;
import com.yundian.result.ResultCodeContants;

/**
 * 渠道机构用户服务实现
 * 
 * @author hehaibo
 * @version $Id: FssOrganizationUserServiceImpl.java, v 0.1 2016年7月26日 下午8:59:44
 *          hehaibo Exp $
 */
public class FssOrganizationUserServiceImpl implements
		FssOrganizationUserService {
	private static final Logger logger = LoggerFactory
			.getLogger(FssOrganizationUserServiceImpl.class);

	@Autowired
	private FssOrganizationUserManager fssOrganizationUserManager;

	public Result<Integer> insertFssOrganizationUser(
			FssOrganizationUserModel fssOrganizationUserModel) {
		Result<Integer> result = new Result<Integer>();
		try {
			Integer row = this.fssOrganizationUserManager
					.insertFssOrganizationUser(fssOrganizationUserModel);
			result.setData(row);
			result.setCode(ResultCodeContants.success);
		} catch (Exception e) {
			logger.error(String.format("添加审批机构用户信息异常:%s", ToStringBuilder
					.reflectionToString(fssOrganizationUserModel)), e);
			if(e instanceof FssLoanBizException){
				FssLoanBizException be=(FssLoanBizException)e;
				result.setCode(be.getCode());
				result.setMessage(be.getErrorMsg());
			}
			else{
				result.setCode(ResultCodeContants.failed);
				result.setMessage("系统异常");
			}
		}
		return result;
	}
	
	

	@Override
	public Result<Integer> initInsertFssOrganizationUser(
			FssOrganizationUserModel fssOrganizationUserModel) {
		Result<Integer> result = new Result<Integer>();
		try {
			Integer row = this.fssOrganizationUserManager
					.initInsertFssOrganizationUser(fssOrganizationUserModel);
			result.setData(row);
			result.setCode(ResultCodeContants.success);
		} catch (Exception e) {
			logger.error(String.format("添加审批机构用户信息异常:%s", ToStringBuilder
					.reflectionToString(fssOrganizationUserModel)), e);
			if(e instanceof FssLoanBizException){
				FssLoanBizException be=(FssLoanBizException)e;
				result.setCode(be.getCode());
				result.setMessage(be.getErrorMsg());
			}
			else{
				result.setCode(ResultCodeContants.failed);
				result.setMessage("系统错误");
			}
			
		}
		return result;
	}



	public Result<Integer> updateFssOrganizationUser(
			FssOrganizationUserModel fssOrganizationUserModel) {
		Result<Integer> result = new Result<Integer>();
		try {
			Integer row = this.fssOrganizationUserManager
					.updateFssOrganizationUser(fssOrganizationUserModel);
			result.setData(row);
			result.setCode(ResultCodeContants.success);
		} catch (Exception e) {
			logger.error(String.format("修改审批机构用户信息异常:%s", ToStringBuilder
					.reflectionToString(fssOrganizationUserModel)), e);
			if(e instanceof FssLoanBizException){
				FssLoanBizException be=(FssLoanBizException)e;
				result.setCode(be.getCode());
				result.setMessage(be.getErrorMsg());
			}
			else{
				result.setCode(ResultCodeContants.failed);
				result.setMessage("系统异常");
			}
		}
		return result;
	}

	public Result<Integer> deleteFssOrganizationUserByOrguserId(
			Long orguserId) {
		Result<Integer> result = new Result<Integer>();
		try {
			// TODO 要判断其他的数据是否有删除
			Integer row = this.fssOrganizationUserManager
					.deleteFssOrganizationUserByOrguserId(orguserId);
			result.setData(row);
			result.setCode(ResultCodeContants.success);
		} catch (Exception e) {
			logger.error(String.format("删除审批机构用户信息异常:%d", orguserId), e);
			if(e instanceof FssLoanBizException){
				FssLoanBizException be=(FssLoanBizException)e;
				result.setCode(be.getCode());
				result.setMessage(be.getErrorMsg());
			}
			else{
				result.setCode(ResultCodeContants.failed);
				result.setMessage("系统异常");
			}
		}
		return result;
	}

	public Result<FssOrganizationUserModel> getFssOrganizationUserById(
			Long id) {
		Result<FssOrganizationUserModel> result = new Result<FssOrganizationUserModel>();
		try {
			FssOrganizationUserModel row = this.fssOrganizationUserManager
					.getFssOrganizationUserById(id);
			result.setData(row);
			result.setCode(ResultCodeContants.success);
		} catch (Exception e) {
			logger.error(String.format("查询单个审批机构用户信息异常:%d", id), e);
			if(e instanceof FssLoanBizException){
				FssLoanBizException be=(FssLoanBizException)e;
				result.setCode(be.getCode());
				result.setMessage(be.getErrorMsg());
			}
			else{
				result.setCode(ResultCodeContants.failed);
				result.setMessage("系统异常");
			}
		}
		return result;
	}

	public Result<List<FssOrganizationUserModel>> getFssOrganizationUserList(
			FssOrganizationUserModel fssOrganizationUserModel) {
		Result<List<FssOrganizationUserModel>> result = new Result<List<FssOrganizationUserModel>>();
		try {
			List<FssOrganizationUserModel> row = this.fssOrganizationUserManager
					.getFssOrganizationUserList(fssOrganizationUserModel);
			result.setData(row);
			result.setCode(ResultCodeContants.success);
		} catch (Exception e) {
			logger.error(String.format("查询列表审批机构用户信息异常:%s", ToStringBuilder
					.reflectionToString(fssOrganizationUserModel)), e);
			if(e instanceof FssLoanBizException){
				FssLoanBizException be=(FssLoanBizException)e;
				result.setCode(be.getCode());
				result.setMessage(be.getErrorMsg());
			}
			else{
				result.setCode(ResultCodeContants.failed);
				result.setMessage("系统异常");
			}
		}
		return result;
	}

	public Result<PaginatedResult<FssOrganizationUserQueryModel>> getPaginatorFssOrganizationUser(
			Paginator<FssOrganizationUserQueryModel> paginator) {
		Result<PaginatedResult<FssOrganizationUserQueryModel>> result = new Result<PaginatedResult<FssOrganizationUserQueryModel>>();
		try {
			PaginatedResult<FssOrganizationUserQueryModel> data = this.fssOrganizationUserManager
					.getPaginatorFssOrganizationUser(paginator);
			result.setData(data);
			result.setCode(ResultCodeContants.success);
		} catch (Exception e) {
			logger.error(
					String.format("分页查询审批机构用户信息异常:%s",
							ToStringBuilder.reflectionToString(paginator)), e);
			if(e instanceof FssLoanBizException){
				FssLoanBizException be=(FssLoanBizException)e;
				result.setCode(be.getCode());
				result.setMessage(be.getErrorMsg());
			}
			else{
				result.setCode(ResultCodeContants.failed);
				result.setMessage("系统异常");
			}
		}
		return result;
	}

	@Override
	public Result<FssOrganizationUserModel> fssOrganizationUserLogin(
			String userName, String password) {
		Result<FssOrganizationUserModel> result = new Result<FssOrganizationUserModel>();
		try {
			FssOrganizationUserModel row = this.fssOrganizationUserManager
					.fssOrganizationUserLogin(userName,password);
			result.setData(row);
			result.setCode(ResultCodeContants.success);
		} catch (Exception e) {
			logger.error(String.format("查询单个审批机构用户信息异常:%s", userName), e);
			if(e instanceof FssLoanBizException){
				FssLoanBizException be=(FssLoanBizException)e;
				result.setCode(be.getCode());
				result.setMessage(be.getErrorMsg());
			}
			else{
				result.setCode(ResultCodeContants.failed);
				result.setMessage("系统异常");
			}
		}
		return result;
	}
	
	

}
