package com.yundian.fss.service.impl;

import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.yundian.fss.exception.FssLoanBizException;
import com.yundian.fss.manager.FssBankUserManager;
import com.yundian.fssapi.domain.FssBankUserModel;
import com.yundian.fssapi.domain.query.FssBankUserQueryModel;
import com.yundian.fssapi.service.FssBankUserService;
import com.yundian.result.PaginatedResult;
import com.yundian.result.Paginator;
import com.yundian.result.Result;
import com.yundian.result.ResultCodeContants;

/**
 * 银行用户服务实现
 * 
 * @author hehaibo
 * @version $Id: FssBankUserServiceImpl.java, v 0.1 2016年7月26日 下午8:59:44 hehaibo Exp $
 */
public class FssBankUserServiceImpl implements FssBankUserService{
	private static final Logger logger=LoggerFactory.getLogger(FssBankUserServiceImpl.class);

	@Autowired
	private FssBankUserManager  bankUserManager;
	
	public Result<Integer> insertFssBankUser (FssBankUserModel fssBankUser){
		Result<Integer> result = new Result<Integer>();
		try {
			//TODO 重复校验
			Integer row= this.bankUserManager.insertFssBankUser(fssBankUser);
			result.setData(row);
			result.setCode(ResultCodeContants.success);
		} catch (Exception e) {
			logger.error(String.format("添加银行用户异常:%s",
					ToStringBuilder.reflectionToString(fssBankUser)),e);
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
	public Result<Integer> initInsertFssBankUser(FssBankUserModel bankUserModel) {
		Result<Integer> result = new Result<Integer>();
		try {
			//TODO 重复校验
			Integer row= this.bankUserManager.initInsertFssBankUser(bankUserModel);
			result.setData(row);
			result.setCode(ResultCodeContants.success);
		} catch (Exception e) {
			logger.error(String.format("添加银行用户异常:%s",
					ToStringBuilder.reflectionToString(bankUserModel)),e);
			if (e instanceof FssLoanBizException) {
				FssLoanBizException be = (FssLoanBizException) e;
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



	public Result<Integer> updateFssBankUser(FssBankUserModel fssBankUser){
		Result<Integer> result = new Result<Integer>();
		try {
			Integer row= this.bankUserManager.updateFssBankUser(fssBankUser);
			result.setData(row);
			result.setCode(ResultCodeContants.success);
		} catch (Exception e) {
			logger.error(String.format("修改银行用户异常:%s",
					ToStringBuilder.reflectionToString(fssBankUser)),e);
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

			
	public Result<Integer> deleteFssBankUserByBkuserId ( Long bkuserId )
	{
		Result<Integer> result = new Result<Integer>();
		try {
			//TODO 要判断关联数据 是否删除？
			Integer row =this.bankUserManager.deleteFssBankUserByBkuserId(bkuserId);
			result.setData(row);
			result.setCode(ResultCodeContants.success);
		} catch (Exception e) {
			logger.error(String.format("删除银行用户异常:%d",bkuserId),e);
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
																											
	public Result<FssBankUserModel> getFssBankUserById(Long id){
		Result<FssBankUserModel> result = new Result<FssBankUserModel>();
		try {
			FssBankUserModel data =this.bankUserManager.getFssBankUserById(id);
			result.setData(data);
			result.setCode(ResultCodeContants.success);
		} catch (Exception e) {
			logger.error(String.format("查询单个银行用户异常:%d",id),e);
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

	public Result<List<FssBankUserModel>> getFssBankUserList(FssBankUserModel fssBankUser){
		Result<List<FssBankUserModel>> result = new Result<List<FssBankUserModel>>();
		try {
			List<FssBankUserModel> data =this.bankUserManager.getFssBankUserList(fssBankUser);
			result.setData(data);
			result.setCode(ResultCodeContants.success);
		} catch (Exception e) {
			logger.error(String.format("查询列表银行用户异常:%s",
					ToStringBuilder.reflectionToString(fssBankUser)),e);
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
	

	public Result<PaginatedResult<FssBankUserQueryModel>> getPaginatorFssBankUser(
            Paginator<FssBankUserQueryModel> paginator){
		
		Result<PaginatedResult<FssBankUserQueryModel>> result = new Result<PaginatedResult<FssBankUserQueryModel>>();
		try {
			PaginatedResult<FssBankUserQueryModel> paginatedResult=this.bankUserManager.getPaginatorFssBankUser(paginator);
			result.setData(paginatedResult);
			result.setCode(ResultCodeContants.success);
		} catch (Exception e) {
			logger.error(String.format("分页查询银行用户异常:%s",
					ToStringBuilder.reflectionToString(paginator)),e);
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
	public Result<FssBankUserModel> fssBankUserLogin(String username, String password) {
		Result<FssBankUserModel> result = new Result<FssBankUserModel>();
		try {
			FssBankUserModel data =this.bankUserManager.getFssBankUserByUserAndPwd(username, password);
			result.setData(data);
			result.setCode(ResultCodeContants.success);
		} catch (Exception e) {
			logger.error(String.format("银行用户登录异常:%s",username),e);
			if (e instanceof FssLoanBizException) {
				FssLoanBizException be = (FssLoanBizException) e;
				result.setCode(be.getCode());
				result.setMessage(be.getMessage());
			}else{
				result.setCode(ResultCodeContants.failed);
				result.setMessage("用户名或密码错误");
			}
		}
		return result;
	}

}
