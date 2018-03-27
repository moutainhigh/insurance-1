package com.yundian.fss.manager.impl;

import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.yundian.fss.dao.FssLoanRelationModelMapper;
import com.yundian.fss.exception.FssLoanBizException;
import com.yundian.fss.manager.FssLoanRelationManager;
import com.yundian.fss.manager.impl.support.CommonFssManagerSupportImpl;
import com.yundian.fssapi.domain.FssLoanRelationModel;
import com.yundian.result.Result;
import com.yundian.result.ResultCodeContants;

/**
 * 贷款关系人服务实现
 * 
 * @author hehaibo
 * @version $Id: FssLoanRelationManagerImpl.java, v 0.1 2016年7月26日 下午8:59:44
 *          hehaibo Exp $
 */
@Transactional
public class FssLoanRelationManagerImpl extends CommonFssManagerSupportImpl implements FssLoanRelationManager {
	private static final Logger logger = LoggerFactory
			.getLogger(FssLoanRelationManagerImpl.class);

	@Autowired
	private FssLoanRelationModelMapper fssLoanRelationModelMapper;

	public Integer insertFssLoanRelation(
			FssLoanRelationModel fssLoanRelationModel) {
		return super.insertFssLoanRelation(fssLoanRelationModel);
	}

	public Integer updateFssLoanRelation(
			FssLoanRelationModel fssLoanRelationModel) {
		Result<Integer> result = new Result<Integer>();
		try {
			Integer row = this.fssLoanRelationModelMapper
					.updateByPrimaryKey(fssLoanRelationModel);
			result.setData(row);
			return row;
		} catch (Exception e) {
			logger.error(String.format("修改贷款关系人异常:%s",
					ToStringBuilder.reflectionToString(fssLoanRelationModel)),
					e);
			throw new FssLoanBizException(ResultCodeContants.failed, "修改贷款关系人异常", e);
		}

	}

	public Integer deleteFssLoanRelationByRelationId(Long relationId) {
		Result<Integer> result = new Result<Integer>();
		try {
			Integer row = this.fssLoanRelationModelMapper
					.deleteByPrimaryKey(relationId);
			result.setData(row);
			return row;
		} catch (Exception e) {
			logger.error(String.format("删除贷款关系人异常:%d", relationId), e);
			throw new FssLoanBizException(ResultCodeContants.failed, "删除贷款关系人异常", e);
		}

	}

	public FssLoanRelationModel getFssLoanRelationById(Long relationId) {
		try {
			FssLoanRelationModel row = this.fssLoanRelationModelMapper
					.selectByPrimaryKey(relationId);
			return row;
		} catch (Exception e) {
			logger.error(String.format("查询单个贷款关系人异常:%d", relationId), e);
			throw new FssLoanBizException(ResultCodeContants.failed, "查询单个贷款关系人异常", e);
		}

	}

	public List<FssLoanRelationModel> getFssLoanRelationListByLoanId(Long loanId) {
		try {
			List<FssLoanRelationModel> row = this.fssLoanRelationModelMapper
					.getFssLoanRelationListByLoanId(loanId);
			return row;
		} catch (Exception e) {
			logger.error(String.format("查询列表贷款关系人异常:%d", loanId), e);
			throw new FssLoanBizException(ResultCodeContants.failed,
					"查询列表贷款关系人异常", e);
		}
	}

	@Override
	public List<FssLoanRelationModel> getFssLoanRelationAndDocumentListByLoanId(
			Long loanId) {
		return super.getFssLoanRelationAndDocumentListByLoanId(loanId);
	}
	
	@Override
	public List<FssLoanRelationModel> getFssLoanRelationAndRecognitionByLoanId(
			Long loanId) {
		return super.getFssLoanRelationAndDocumentAndRecognitionByLoanId(loanId);
	}

}
