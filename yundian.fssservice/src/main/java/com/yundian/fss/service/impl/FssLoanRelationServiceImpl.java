package com.yundian.fss.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import com.yundian.fss.exception.FssLoanBizException;
import com.yundian.fss.manager.FssLoanRelationManager;
import com.yundian.fssapi.domain.FssLoanDocumentModel;
import com.yundian.fssapi.domain.FssLoanRelationModel;
import com.yundian.fssapi.service.FssLoanRelationService;
import com.yundian.result.Result;
import com.yundian.result.ResultCodeContants;

/**
 * 贷款关系人服务实现
 * 
 * @author hehaibo
 * @version $Id: FssLoanRelationServiceImpl.java, v 0.1 2016年7月26日 下午8:59:44
 *          hehaibo Exp $
 */
public class FssLoanRelationServiceImpl implements FssLoanRelationService {
	private static final Logger logger = LoggerFactory
			.getLogger(FssLoanRelationServiceImpl.class);

	@Autowired
	private FssLoanRelationManager fssLoanRelationManager;

	public Result<Integer> insertFssLoanRelation(
			FssLoanRelationModel fssLoanRelationModel) {
		Result<Integer> result = new Result<Integer>();
		try {
			Integer row = this.fssLoanRelationManager
					.insertFssLoanRelation(fssLoanRelationModel);
			result.setData(row);
			result.setCode(ResultCodeContants.success);
		} catch (Exception e) {
			logger.error(String.format("添加贷款关系人异常:%s",
					ToStringBuilder.reflectionToString(fssLoanRelationModel)),
					e);
			if(e instanceof FssLoanBizException){
				FssLoanBizException be=(FssLoanBizException)e;
				result.setCode(be.getCode());
				result.setMessage(be.getMessage());
			}
			else{
				result.setCode(ResultCodeContants.failed);
				result.setMessage("系统异常");
			}
		}
		return result;
	}

	public Result<Integer> updateFssLoanRelation(
			FssLoanRelationModel fssLoanRelationModel) {
		Result<Integer> result = new Result<Integer>();
		try {
			Integer row = this.fssLoanRelationManager
					.updateFssLoanRelation(fssLoanRelationModel);
			result.setData(row);
			result.setCode(ResultCodeContants.success);
		} catch (Exception e) {
			logger.error(String.format("修改贷款关系人异常:%s",
					ToStringBuilder.reflectionToString(fssLoanRelationModel)),
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

	public Result<Integer> deleteFssLoanRelationByRelationId(Long relationId) {
		Result<Integer> result = new Result<Integer>();
		try {
			Integer row = this.fssLoanRelationManager
					.deleteFssLoanRelationByRelationId(relationId);
			result.setData(row);
			result.setCode(ResultCodeContants.success);
		} catch (Exception e) {
			logger.error(String.format("删除贷款关系人异常:%d", relationId), e);
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

	public Result<FssLoanRelationModel> getFssLoanRelationById(Long relationId) {
		Result<FssLoanRelationModel> result = new Result<FssLoanRelationModel>();
		try {
			FssLoanRelationModel row = this.fssLoanRelationManager
					.getFssLoanRelationById(relationId);
			result.setData(row);
			result.setCode(ResultCodeContants.success);
		} catch (Exception e) {
			logger.error(String.format("查询单个贷款关系人异常:%d", relationId), e);
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

	public Result<List<FssLoanRelationModel>> getFssLoanRelationListByLoanId(Long loanId) {
		Result<List<FssLoanRelationModel>> result = new Result<List<FssLoanRelationModel>>();
		try {
			List<FssLoanRelationModel> row = fssLoanRelationManager
					.getFssLoanRelationListByLoanId(loanId);
			result.setData(row);
			result.setCode(ResultCodeContants.success);
		} catch (Exception e) {
			logger.error(String.format("查询列表贷款关系人异常:%d",
					loanId),
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
	
	

	@Override
	public Result<List<FssLoanRelationModel>> getFssLoanRelationAndDocumentListByLoanId(
			Long loanId) {
		Result<List<FssLoanRelationModel>> result = new Result<List<FssLoanRelationModel>>();
		try {
			List<FssLoanRelationModel> rows = fssLoanRelationManager
					.getFssLoanRelationAndDocumentListByLoanId(loanId);
			result.setData(rows);
			result.setCode(ResultCodeContants.success);
		} catch (Exception e) {
			logger.error(String.format("查询列表贷款关系人异常:%d",
					loanId),
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
	@Override
	public Result<List<FssLoanRelationModel>> getFssLoanRelationAndRecognitionByLoanId(Long loanId) {
		Result<List<FssLoanRelationModel>> result = new Result<List<FssLoanRelationModel>>();
		try {
			List<FssLoanRelationModel> row = fssLoanRelationManager
					.getFssLoanRelationAndRecognitionByLoanId(loanId);
			
			for(FssLoanRelationModel relation:row)
			{
				List<FssLoanDocumentModel>  listDoc = relation.getLoanDocumentList();
				relation.setLoanDocumentList(listDoc.stream().filter(doc -> doc.getDocumentType().contains("faceRrecognitionPic"))
		        .collect(Collectors.toList()));
			}
			result.setData(row);
			result.setCode(ResultCodeContants.success);
		} catch (Exception e) {
			logger.error(String.format("查询列表贷款关系人异常:%d",
					loanId),
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
	
	
}
