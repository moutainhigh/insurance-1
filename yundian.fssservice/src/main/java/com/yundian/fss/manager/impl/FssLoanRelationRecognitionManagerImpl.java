package com.yundian.fss.manager.impl;

import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.yundian.fss.dao.FssLoanRelationRecognitionModelMapper;
import com.yundian.fss.exception.FssLoanBizException;
import com.yundian.fss.manager.FssLoanRelationRecognitionManager;
import com.yundian.fssapi.domain.FssLoanRelationRecognitionModel;
import com.yundian.result.PaginatedResult;
import com.yundian.result.Paginator;
import com.yundian.result.ResultCodeContants;

/**
 * 人脸识别结果服务实现
 * 
 * @author hehaibo
 * @version $Id: FssLoanRelationRecognitionManagerImpl.java, v 0.1 2016年7月26日
 *          下午8:59:44 hehaibo Exp $
 */
@Transactional
public class FssLoanRelationRecognitionManagerImpl implements
		FssLoanRelationRecognitionManager {
	private static final Logger logger = LoggerFactory
			.getLogger(FssLoanRelationRecognitionManagerImpl.class);

	@Autowired
	private FssLoanRelationRecognitionModelMapper fssLoanRelationRecognitionModelMapper;

	public Integer insertFssLoanRelationRecognition(
			FssLoanRelationRecognitionModel fssLoanRelationRecognitionModel) {
		try {
			Integer row = this.fssLoanRelationRecognitionModelMapper
					.insert(fssLoanRelationRecognitionModel);
			return row;
		} catch (Exception e) {
			logger.error(String.format("添加人脸识别结果异常:%s", ToStringBuilder
					.reflectionToString(fssLoanRelationRecognitionModel)), e);
			throw new FssLoanBizException(ResultCodeContants.failed, "添加人脸识别结果异常", e);
		}
		
	}

	public Integer updateFssLoanRelationRecognition(
			FssLoanRelationRecognitionModel fssLoanRelationRecognitionModel) {
		try {
			Integer row = this.fssLoanRelationRecognitionModelMapper
					.updateByPrimaryKey(fssLoanRelationRecognitionModel);
			return row;
		} catch (Exception e) {
			logger.error(String.format("修改人脸识别结果异常:%s", ToStringBuilder
					.reflectionToString(fssLoanRelationRecognitionModel)), e);
			throw new FssLoanBizException(ResultCodeContants.failed, "修改人脸识别结果异常", e);
		}
		
	}

	public Integer deleteFssLoanRelationRecognitionById(Long id) {
		try {
			Integer row = this.fssLoanRelationRecognitionModelMapper
					.deleteByPrimaryKey(id);
			return row;
		} catch (Exception e) {
			logger.error(String.format("删除人脸识别结果异常:%d", id), e);
			throw new FssLoanBizException(ResultCodeContants.failed, "删除人脸识别结果异常", e);
		}
		
	}

	public FssLoanRelationRecognitionModel getFssLoanRelationRecognitionById(
			Long id) {
		try {
			FssLoanRelationRecognitionModel row = this.fssLoanRelationRecognitionModelMapper
					.selectByPrimaryKey(id);
			return row;
		} catch (Exception e) {
			logger.error(String.format("查询单个人脸识别结果异常:%s", id), e);
			throw new FssLoanBizException(ResultCodeContants.failed, "查询单个人脸识别结果异常", e);
		}
		
	}

	public List<FssLoanRelationRecognitionModel> getFssLoanRelationRecognitionList(
			FssLoanRelationRecognitionModel fssLoanRelationRecognitionModel) {
		try {
			List<FssLoanRelationRecognitionModel> row = null;// TODO
			return row;
		} catch (Exception e) {
			logger.error(String.format("查询人脸识别结果列表异常:%s",
					fssLoanRelationRecognitionModel), e);
			throw new FssLoanBizException(ResultCodeContants.failed, "查询人脸识别结果列表异常", e);
		}
		
	}

	public PaginatedResult<FssLoanRelationRecognitionModel> getPaginatorFssLoanRelationRecognition(
			Paginator<FssLoanRelationRecognitionModel> paginator) {
		try {
			PaginatedResult<FssLoanRelationRecognitionModel> data = null;// TODO
			return data;
		} catch (Exception e) {
			logger.error(String.format("分页查询人脸识别结果异常:%s", paginator), e);
			throw new FssLoanBizException(ResultCodeContants.failed, "分页查询人脸识别结果异常", e);
		}
		
	}

	@Override
	public FssLoanRelationRecognitionModel getFssLoanRelationRecognitionByRelationId(
			Long relationId) {
		try {
			FssLoanRelationRecognitionModel row = this.fssLoanRelationRecognitionModelMapper
					.getFssLoanRelationRecognitionByRelationId(relationId);
			return row;
		} catch (Exception e) {
			logger.error(String.format("查询单个人脸识别结果异常:%s", relationId), e);
			throw new FssLoanBizException(ResultCodeContants.failed, "查询单个人脸识别结果异常", e);
		}
	}

}
