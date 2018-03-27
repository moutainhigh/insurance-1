package com.yundian.fss.service.impl;

import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.yundian.fss.exception.FssLoanBizException;
import com.yundian.fss.manager.FssLoanDistributeManager;
import com.yundian.fssapi.domain.FssLoanDistributeModel;
import com.yundian.fssapi.domain.query.FssLoanDistributeQueryModel;
import com.yundian.fssapi.service.FssLoanDistributeService;
import com.yundian.result.PaginatedResult;
import com.yundian.result.Paginator;
import com.yundian.result.Result;
import com.yundian.result.ResultCodeContants;

/**
 * 贷款分配服务实现
 * 
 * @author hehaibo
 * @version $Id: FssLoanDistributeServiceImpl.java, v 0.1 2016年7月26日 下午8:59:44
 *          hehaibo Exp $
 */
public class FssLoanDistributeServiceImpl implements FssLoanDistributeService {
	private static final Logger logger = LoggerFactory
			.getLogger(FssLoanDistributeServiceImpl.class);
	@Autowired
	private FssLoanDistributeManager fssLoanDistributeManager;

	public Result<Integer> insertFssLoanDistribute(
			FssLoanDistributeModel fssLoanDistributeModel) {
		Result<Integer> result = new Result<Integer>();
		try {
			Integer row = this.fssLoanDistributeManager
					.insertFssLoanDistribute(fssLoanDistributeModel);
			result.setData(row);
			result.setCode(ResultCodeContants.success);
		} catch (Exception e) {
			logger.error(
					String.format("添加贷款分配异常:%s", ToStringBuilder
							.reflectionToString(fssLoanDistributeModel)), e);
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

	public Result<Integer> updateFssLoanDistribute(
			FssLoanDistributeModel fssLoanDistributeModel) {
		Result<Integer> result = new Result<Integer>();
		try {
			Integer row = this.fssLoanDistributeManager
					.updateFssLoanDistribute(fssLoanDistributeModel);
			result.setData(row);
			result.setCode(ResultCodeContants.success);
		} catch (Exception e) {
			logger.error(
					String.format("添加贷款分配异常:%s", ToStringBuilder
							.reflectionToString(fssLoanDistributeModel)), e);
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

	public Result<Integer> deleteFssLoanDistributeById(Long id) {
		Result<Integer> result = new Result<Integer>();
		try {
			Integer row = this.fssLoanDistributeManager
					.deleteFssLoanDistributeById(id);
			result.setData(row);
			result.setCode(ResultCodeContants.success);
		} catch (Exception e) {
			logger.error(String.format("删除贷款分配异常:%s", id), e);
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

	public Result<FssLoanDistributeModel> getFssLoanDistributeById(Long id) {
		Result<FssLoanDistributeModel> result = new Result<FssLoanDistributeModel>();
		try {
			FssLoanDistributeModel row = this.fssLoanDistributeManager
					.getFssLoanDistributeById(id);
			result.setData(row);
			result.setCode(ResultCodeContants.success);
		} catch (Exception e) {
			logger.error(String.format("查询贷款分配异常:%s", id), e);
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

	public Result<List<FssLoanDistributeQueryModel>> getFssLoanDistributeListByLoanId(Long loanId) {
		Result<List<FssLoanDistributeQueryModel>> result = new Result<List<FssLoanDistributeQueryModel>>();
		try {
			List<FssLoanDistributeQueryModel> row = this.fssLoanDistributeManager
					.getFssLoanDistributeListByLoanId(loanId);
			result.setData(row);
			result.setCode(ResultCodeContants.success);
		} catch (Exception e) {
			logger.error(
					String.format("根据LoanId查询贷款分配异常:%d", loanId), e);
			result.setCode(ResultCodeContants.failed);
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

	public Result<PaginatedResult<FssLoanDistributeModel>> getPaginatorFssLoanDistribute(
			Paginator<FssLoanDistributeModel> paginator) {
		Result<PaginatedResult<FssLoanDistributeModel>> result = new Result<PaginatedResult<FssLoanDistributeModel>>();
		try {
			PaginatedResult<FssLoanDistributeModel> data = fssLoanDistributeManager
					.getPaginatorFssLoanDistribute(paginator);
			result.setData(data);
			result.setCode(ResultCodeContants.success);
		} catch (Exception e) {
			logger.error(
					String.format("分页查询贷款分配异常:%s",
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

}
