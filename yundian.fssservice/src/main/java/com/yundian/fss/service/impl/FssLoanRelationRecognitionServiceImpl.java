package com.yundian.fss.service.impl;

import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.yundian.fss.exception.FssLoanBizException;
import com.yundian.fss.manager.FssLoanRelationRecognitionManager;
import com.yundian.fssapi.domain.FssLoanRelationRecognitionModel;
import com.yundian.fssapi.service.FssLoanRelationRecognitionService;
import com.yundian.result.PaginatedResult;
import com.yundian.result.Paginator;
import com.yundian.result.Result;
import com.yundian.result.ResultCodeContants;

/**
 * 人脸识别结果服务实现
 * 
 * @author hehaibo
 * @version $Id: FssLoanRelationRecognitionServiceImpl.java, v 0.1 2016年7月26日
 *          下午8:59:44 hehaibo Exp $
 */
public class FssLoanRelationRecognitionServiceImpl implements
		FssLoanRelationRecognitionService {
	private static final Logger logger = LoggerFactory
			.getLogger(FssLoanRelationRecognitionServiceImpl.class);

	@Autowired
	private FssLoanRelationRecognitionManager fssLoanRelationRecognitionManager;

	public Result<Integer> insertFssLoanRelationRecognition(
			FssLoanRelationRecognitionModel fssLoanRelationRecognitionModel) {
		Result<Integer> result = new Result<Integer>();
		try {
			Integer row = this.fssLoanRelationRecognitionManager
					.insertFssLoanRelationRecognition(fssLoanRelationRecognitionModel);
			result.setData(row);
			result.setCode(ResultCodeContants.success);
		} catch (Exception e) {
			logger.error(String.format("添加人脸识别结果异常:%s", ToStringBuilder
					.reflectionToString(fssLoanRelationRecognitionModel)), e);
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

	public Result<Integer> updateFssLoanRelationRecognition(
			FssLoanRelationRecognitionModel fssLoanRelationRecognitionModel) {
		Result<Integer> result = new Result<Integer>();
		try {
			Integer row = this.fssLoanRelationRecognitionManager
					.updateFssLoanRelationRecognition(fssLoanRelationRecognitionModel);
			result.setData(row);
			result.setCode(ResultCodeContants.success);
		} catch (Exception e) {
			logger.error(String.format("修改人脸识别结果异常:%s", ToStringBuilder
					.reflectionToString(fssLoanRelationRecognitionModel)), e);
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

	public Result<Integer> deleteFssLoanRelationRecognitionById(Long id) {
		Result<Integer> result = new Result<Integer>();
		try {
			Integer row = this.fssLoanRelationRecognitionManager
					.deleteFssLoanRelationRecognitionById(id);
			result.setData(row);
			result.setCode(ResultCodeContants.success);
		} catch (Exception e) {
			logger.error(String.format("删除人脸识别结果异常:%d", id), e);
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

	public Result<FssLoanRelationRecognitionModel> getFssLoanRelationRecognitionById(
			Long id) {
		Result<FssLoanRelationRecognitionModel> result = new Result<FssLoanRelationRecognitionModel>();
		try {
			FssLoanRelationRecognitionModel row = this.fssLoanRelationRecognitionManager
					.getFssLoanRelationRecognitionById(id);
			result.setData(row);
			result.setCode(ResultCodeContants.success);
		} catch (Exception e) {
			logger.error(String.format("查询单个人脸识别结果异常:%s", id), e);
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

	public Result<List<FssLoanRelationRecognitionModel>> getFssLoanRelationRecognitionList(
			FssLoanRelationRecognitionModel fssLoanRelationRecognitionModel) {
		Result<List<FssLoanRelationRecognitionModel>> result = new Result<List<FssLoanRelationRecognitionModel>>();
		try {
			List<FssLoanRelationRecognitionModel> row = this.fssLoanRelationRecognitionManager
					.getFssLoanRelationRecognitionList(fssLoanRelationRecognitionModel);

			result.setData(row);
			result.setCode(ResultCodeContants.success);
		} catch (Exception e) {
			logger.error(String.format("查询人脸识别结果列表异常:%s",
					fssLoanRelationRecognitionModel), e);
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

	public Result<PaginatedResult<FssLoanRelationRecognitionModel>> getPaginatorFssLoanRelationRecognition(
			Paginator<FssLoanRelationRecognitionModel> paginator) {
		Result<PaginatedResult<FssLoanRelationRecognitionModel>> result = new Result<PaginatedResult<FssLoanRelationRecognitionModel>>();
		try {
			PaginatedResult<FssLoanRelationRecognitionModel> data = this.fssLoanRelationRecognitionManager
					.getPaginatorFssLoanRelationRecognition(paginator);

			result.setData(data);
			result.setCode(ResultCodeContants.success);
		} catch (Exception e) {
			logger.error(String.format("分页查查除人脸识别结果异常:%s", paginator), e);
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
