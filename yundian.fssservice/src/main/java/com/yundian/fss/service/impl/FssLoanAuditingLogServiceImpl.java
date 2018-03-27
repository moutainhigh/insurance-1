package com.yundian.fss.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.yundian.fssapi.dto.MyTaskQueryCriterion;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.yundian.fss.exception.FssLoanBizException;
import com.yundian.fss.manager.FssLoanAuditingLogManager;
import com.yundian.fssapi.domain.FssLoanAuditingLogModel;
import com.yundian.fssapi.domain.query.FssLoanAuditingLogQueryModel;
import com.yundian.fssapi.service.FssLoanAuditingLogService;
import com.yundian.result.PaginatedResult;
import com.yundian.result.Paginator;
import com.yundian.result.Result;
import com.yundian.result.ResultCodeContants;

/**
 * 贷款审核服务实现
 * 
 * @author hehaibo
 * @version $Id: FssLoanAuditingLogServiceImpl.java, v 0.1 2016年7月26日 下午8:59:44
 *          hehaibo Exp $
 */
public class FssLoanAuditingLogServiceImpl implements FssLoanAuditingLogService {
	private static final Logger logger = LoggerFactory
			.getLogger(FssLoanAuditingLogServiceImpl.class);

	@Autowired
	private FssLoanAuditingLogManager fssLoanAuditingLogManager;

	public Result<Integer> insertFssLoanAuditingLog(
			FssLoanAuditingLogModel fssLoanAuditingLogModel) {
		Result<Integer> result = new Result<Integer>();
		try {
			Integer row = this.fssLoanAuditingLogManager
					.insertFssLoanAuditingLog(fssLoanAuditingLogModel);
			result.setData(row);
			result.setCode(ResultCodeContants.success);
		} catch (Exception e) {
			logger.error(
					String.format("添加审核日志异常:%s", ToStringBuilder
							.reflectionToString(fssLoanAuditingLogModel)), e);
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

	public Result<Integer> updateFssLoanAuditingLog(
			FssLoanAuditingLogModel fssLoanAuditingLogModel) {
		Result<Integer> result = new Result<Integer>();
		try {
			Integer row = this.fssLoanAuditingLogManager
					.updateFssLoanAuditingLog(fssLoanAuditingLogModel);
			result.setData(row);
			result.setCode(ResultCodeContants.success);
		} catch (Exception e) {
			logger.error(
					String.format("修改审核日志异常:%s", ToStringBuilder
							.reflectionToString(fssLoanAuditingLogModel)), e);
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

	public Result<Integer> deleteFssLoanAuditingLogByLogId(Long logId) {
		Result<Integer> result = new Result<Integer>();
		try {
			Integer row = this.fssLoanAuditingLogManager
					.deleteFssLoanAuditingLogByLogId(logId);
			result.setData(row);
			result.setCode(ResultCodeContants.success);
		} catch (Exception e) {
			logger.error(String.format("删除审核日志异常:%s", logId), e);
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

	public Result<FssLoanAuditingLogModel> getFssLoanAuditingLogById(Long logId) {
		Result<FssLoanAuditingLogModel> result = new Result<FssLoanAuditingLogModel>();
		try {
			FssLoanAuditingLogModel row = this.fssLoanAuditingLogManager
					.getFssLoanAuditingLogById(logId);
			result.setData(row);
			result.setCode(ResultCodeContants.success);
		} catch (Exception e) {
			logger.error(String.format("查询审核日志异常:%d", logId), e);
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

	public Result<List<FssLoanAuditingLogQueryModel>> getFssLoanAuditingLogListByLoanId(Long loanId) {
		Result<List<FssLoanAuditingLogQueryModel>> result = new Result<List<FssLoanAuditingLogQueryModel>>();
		try {
			List<FssLoanAuditingLogQueryModel> data = this.fssLoanAuditingLogManager
					.getFssLoanAuditingLogListByLoanId(loanId);
			result.setData(data);
			result.setCode(ResultCodeContants.success);
		} catch (Exception e) {
			logger.error(
					String.format("查询列表审核日志异常:%d", loanId), e);
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

	public Result<PaginatedResult<FssLoanAuditingLogQueryModel>> getPaginatorFssLoanAuditingLog(
			Paginator<FssLoanAuditingLogModel> paginator) {
		Result<PaginatedResult<FssLoanAuditingLogQueryModel>> result = new Result<PaginatedResult<FssLoanAuditingLogQueryModel>>();
		try {
			PaginatedResult<FssLoanAuditingLogQueryModel> data = this.fssLoanAuditingLogManager
					.getPaginatorFssLoanAuditingLog(paginator);
			result.setData(data);
			result.setCode(ResultCodeContants.success);
		} catch (Exception e) {
			logger.error(
					String.format("分页查询审核日志异常:%s",
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
	public Result<List<FssLoanAuditingLogModel>> _getFssLoanAuditingLogListByLoanId(Long loanId) {
		Result<List<FssLoanAuditingLogQueryModel>> result = getFssLoanAuditingLogListByLoanId(loanId);
		return new Result<List<FssLoanAuditingLogModel>>(result.getData().stream().map(query->{
			FssLoanAuditingLogModel model = new FssLoanAuditingLogModel();
			model.setOrguserName(query.getOrguserName());
			model.setRemark(query.getRemark());
			model.setNodeName(query.getNodeName());
			model.setMtime(query.getMtime());
			model.setAuditContent(query.getAuditContent());
			model.setAuditStatus(query.getAuditStatus());
			model.setAuditTime(query.getAuditTime());
			model.setCtime(query.getCtime());
			model.setGuaranteeId(query.getGuaranteeId());
			model.setNode(query.getNode());
			model.setLoanId(query.getLoanId());
			model.setLoanId(query.getLogId());
			model.setOrguserId(query.getOrguserId());
			model.setOrganizationId(query.getOrganizationId());
			return model;
		}).collect(Collectors.toList()),ResultCodeContants.success,"");
	}

	@Override
	public Result<PaginatedResult<FssLoanAuditingLogQueryModel>> queryPagingResult(MyTaskQueryCriterion queryCriterion) {
		Result<PaginatedResult<FssLoanAuditingLogQueryModel>> result = new Result<PaginatedResult<FssLoanAuditingLogQueryModel>>();
		try {
			PaginatedResult<FssLoanAuditingLogQueryModel> data = this.fssLoanAuditingLogManager
					.queryPagingResult(queryCriterion);
			result.setData(data);
			result.setCode(ResultCodeContants.success);
		} catch (Exception e) {
			logger.error(
					String.format("分页查询审核日志异常:%s",
							ToStringBuilder.reflectionToString(queryCriterion)), e);
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
