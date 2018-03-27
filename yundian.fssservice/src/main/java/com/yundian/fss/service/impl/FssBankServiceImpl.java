package com.yundian.fss.service.impl;

import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.yundian.fss.exception.FssLoanBizException;
import com.yundian.fss.manager.FssBankAddedConfMananger;
import com.yundian.fss.manager.FssBankManager;
import com.yundian.fssapi.domain.FssBankAddedConfModel;
import com.yundian.fssapi.domain.FssBankModel;
import com.yundian.fssapi.service.FssBankService;
import com.yundian.result.PaginatedResult;
import com.yundian.result.Paginator;
import com.yundian.result.Result;
import com.yundian.result.ResultCodeContants;

/**
 * 银行服务实现
 * 
 * @author hehaibo
 * @version $Id: FssBankServiceImpl.java, v 0.1 2016年7月26日 下午8:59:44 hehaibo Exp
 *          $
 */
public class FssBankServiceImpl implements FssBankService {

	private static final Logger logger = LoggerFactory
			.getLogger(FssBankServiceImpl.class);
	@Autowired
	private FssBankManager fssBankManager;
	@Autowired
	private FssBankAddedConfMananger fssBankAddedConfMananger;
	public Result<Integer> insertFssBank(FssBankModel fssBankModel) {
		Result<Integer> result = new Result<Integer>();
		try {
			Integer row = this.fssBankManager.insertFssBank(fssBankModel);
			result.setData(row);
			result.setCode(ResultCodeContants.success);
		} catch (Exception e) {
			logger.error(
					String.format("添加银行机构异常:%s",
							ToStringBuilder.reflectionToString(fssBankModel)),
					e);
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

	public Result<Integer> updateFssBankByBankId(FssBankModel fssBankModel) {
		Result<Integer> result = new Result<Integer>();
		try {
			Integer row = this.fssBankManager
					.updateFssBankByBankId(fssBankModel);
			result.setCode(ResultCodeContants.success);
			result.setData(row);
		} catch (Exception e) {
			logger.error(
					String.format("修改银行机构异常:%s",
							ToStringBuilder.reflectionToString(fssBankModel)),
					e);
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

	public Result<Integer> deleteFssBankByBankId(Integer bankId) {
		Result<Integer> result = new Result<Integer>();
		try {
			// TODO 要判断其他的条件 关联数据要删除
			Integer row = this.fssBankManager.deleteFssBankByBankId(bankId);
			result.setData(row);
			result.setCode(ResultCodeContants.success);
		} catch (Exception e) {
			logger.error(
					String.format("删除银行机构异常:%s",bankId), e);
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

	public Result<FssBankModel> getFssBankById(Integer id) {
		Result<FssBankModel> result = new Result<FssBankModel>();
		try {
			FssBankModel bankModel = fssBankManager.getFssBankById(id);
			
			FssBankAddedConfModel fssBankAddedConfModel =
					fssBankAddedConfMananger.getFssBankAddedConfByBankId(Long.valueOf(id.toString()));
			bankModel.setFssBankAddedConfModel(fssBankAddedConfModel);
			result.setData(bankModel);
			result.setCode(ResultCodeContants.success);
		} catch (Exception e) {
			logger.error(String.format("查询银行机构异常:%d", id), e);
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

	public Result<List<FssBankModel>> getFssBankList(FssBankModel fssBankModel) {
		Result<List<FssBankModel>> result = new Result<List<FssBankModel>>();
		try {
			List<FssBankModel> data = this.fssBankManager
					.getFssBankList(fssBankModel);
			result.setData(data);
			result.setCode(ResultCodeContants.success);
		} catch (Exception e) {
			logger.error(
					String.format("获取银行机构列表异常:%s",
							ToStringBuilder.reflectionToString(fssBankModel)),
					e);
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

	public Result<PaginatedResult<FssBankModel>> getPaginatorFssBank(
			Paginator<FssBankModel> paginator) {
		Result<PaginatedResult<FssBankModel>> result = new Result<PaginatedResult<FssBankModel>>();
		try {
			PaginatedResult<FssBankModel> data = fssBankManager
					.getPaginatorFssBank(paginator);
			result.setData(data);
			result.setCode(ResultCodeContants.success);
		} catch (Exception e) {
			logger.error(
					String.format("获取银行机构列表异常:%s",
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
