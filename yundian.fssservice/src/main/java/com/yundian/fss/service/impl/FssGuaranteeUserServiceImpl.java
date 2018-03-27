package com.yundian.fss.service.impl;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.yundian.fss.exception.FssLoanBizException;
import com.yundian.fss.manager.FssGuaranteeUserManager;
import com.yundian.fssapi.domain.FssUserModel;
import com.yundian.fssapi.domain.query.FssUserQueryModel;
import com.yundian.fssapi.dto.param.FssGuaranteeUserParam;
import com.yundian.fssapi.service.FssGuaranteeUserService;
import com.yundian.result.PaginatedResult;
import com.yundian.result.Paginator;
import com.yundian.result.Result;
import com.yundian.result.ResultCodeContants;

public class FssGuaranteeUserServiceImpl implements FssGuaranteeUserService {

	private static final Logger logger = LoggerFactory
			.getLogger(FssGuaranteeUserServiceImpl.class);
	@Autowired
	private FssGuaranteeUserManager fssGuaranteeUserManager;

	@Override
	public Result<Long> addGuaranteeUser(FssGuaranteeUserParam user) {
		Result<Long> result = new Result<Long>();
		try {
			Long userId = fssGuaranteeUserManager.addGuaranteeUser(user);
			result.setData(userId);
			result.setCode(ResultCodeContants.success);
		} catch (Exception e) {
			logger.error(
					String.format("新增担保机构用户异常：%s",
							ToStringBuilder.reflectionToString(user)), e);
			if (e instanceof FssLoanBizException) {
				FssLoanBizException fbe = (FssLoanBizException) e;
				result.setCode(fbe.getCode());
				result.setMessage(fbe.getMessage());
			}else{
				result.setCode(ResultCodeContants.failed);
				result.setMessage("添加担保用户信息异常");
			}
		}

		return result;
	}

	
	@Override
	public Result<Integer> updateGuaranteeUser(FssGuaranteeUserParam user) {
		Result<Integer> result = new Result<Integer>();
		try {
			Integer row = fssGuaranteeUserManager.updateGuaranteeUser(user);
			result.setData(row);
			result.setCode(ResultCodeContants.success);
		} catch (Exception e) {
			logger.error(
					String.format("新增担保机构用户异常：%s",
							ToStringBuilder.reflectionToString(user)), e);
			if (e instanceof FssLoanBizException) {
				FssLoanBizException fbe = (FssLoanBizException) e;
				result.setCode(fbe.getCode());
				result.setMessage(fbe.getMessage());
			}else{
				result.setCode(ResultCodeContants.failed);
				result.setMessage("添加担保用户信息异常");
			}
		}

		return result;
	}
	

	@Override
	public Result<Integer> updateGuaranteeUserPwd(Long userId, String oldPwd,
			String newPwd) {
		Result<Integer> result = new Result<Integer>();
		try {
			Integer row = fssGuaranteeUserManager.updateGuaranteeUserPwd(userId,oldPwd,newPwd);
			result.setData(row);
			result.setCode(ResultCodeContants.success);
		} catch (Exception e) {
			logger.error(
					String.format("担保机构用户修改密码异常：%d",
							userId), e);
			if (e instanceof FssLoanBizException) {
				FssLoanBizException fbe = (FssLoanBizException) e;
				result.setCode(fbe.getCode());
				result.setMessage(fbe.getMessage());
			}else{
				result.setCode(ResultCodeContants.failed);
				result.setMessage("系统异常");
			}
		}

		return result;
	}


	@Override
	public Result<Long> initAddGuaranteeUser(FssGuaranteeUserParam user) {
		Result<Long> result = new Result<Long>();
		try {
			Long userId = fssGuaranteeUserManager.initAddGuaranteeUser(user);
			result.setData(userId);
			result.setCode(ResultCodeContants.success);
		} catch (Exception e) {
			logger.error(
					String.format("新增担保机构用户异常：%s",
							ToStringBuilder.reflectionToString(user)), e);
			if (e instanceof FssLoanBizException) {
				FssLoanBizException fbe = (FssLoanBizException) e;
				result.setCode(fbe.getCode());
				result.setMessage(fbe.getErrorMsg());
			}else{
				result.setCode(ResultCodeContants.failed);
				result.setMessage("添加担保用户信息异常");
			}
		}

		return result;
	}


	@Override
	public Result<FssUserModel> guaranteeUserLogin(String userName,
			String userPwd) {
		Result<FssUserModel> result = new Result<FssUserModel>();
		try {
			FssUserModel guaranteeUser = this.fssGuaranteeUserManager
					.guaranteeUserLogin(userName, userPwd);
			result.setData(guaranteeUser);
			result.setCode(ResultCodeContants.success);
		} catch (Exception e) {
			logger.error(String.format("担保机构用户登录异常：userName=%s", userName), e);
			if (e instanceof FssLoanBizException) {
				FssLoanBizException fbe = (FssLoanBizException) e;
				result.setCode(fbe.getCode());
				result.setMessage(fbe.getMessage());
			}else{
				result.setCode(ResultCodeContants.failed);
				result.setMessage("登录失败,用户名或密码错误");
			}
		}
		return result;
	}

	@Override
	public Result<FssUserModel> getGuaranteeUserByFssUserId(Long fssUserId) {
		Result<FssUserModel> result = new Result<FssUserModel>();
		try {
			FssUserModel guaranteeUser = this.fssGuaranteeUserManager
					.getGuaranteeUserByFssUserId(fssUserId);
			result.setData(guaranteeUser);
			result.setCode(ResultCodeContants.success);
		} catch (Exception e) {
			logger.error(String.format("查询担保用户信息异常：fssUserId=%d", fssUserId), e);
			if (e instanceof FssLoanBizException) {
				FssLoanBizException fbe = (FssLoanBizException) e;
				result.setCode(fbe.getCode());
				result.setMessage(fbe.getMessage());
			}else{
				result.setCode(ResultCodeContants.failed);
				result.setMessage("查询担保用户信息服务器异常");
			}
		}
		return result;
	}

	@Override
	public Result<PaginatedResult<FssUserQueryModel>> getPaginatedResult(
			Paginator<FssUserQueryModel> paginator) {
		Result<PaginatedResult<FssUserQueryModel>> result = new Result<PaginatedResult<FssUserQueryModel>>();
		try {
			PaginatedResult<FssUserQueryModel> guaranteeUserResult = this.fssGuaranteeUserManager
					.getPaginatedResult(paginator);
			result.setData(guaranteeUserResult);
			result.setCode(ResultCodeContants.success);
		} catch (Exception e) {
			logger.error(
					String.format("分页查询担保机构用户异常：%s",
							ToStringBuilder.reflectionToString(paginator)), e);
			if (e instanceof FssLoanBizException) {
				FssLoanBizException fbe = (FssLoanBizException) e;
				result.setCode(fbe.getCode());
				result.setMessage(fbe.getMessage());
			}else{
				result.setCode(ResultCodeContants.failed);
				result.setMessage("分页查询担保机构用户异常");
			}
		}
		return result;
	}
	
	

}
