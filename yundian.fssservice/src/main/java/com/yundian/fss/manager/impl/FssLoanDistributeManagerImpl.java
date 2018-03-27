package com.yundian.fss.manager.impl;

import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.yundian.fss.dao.FssLoanDistributeModelMapper;
import com.yundian.fss.exception.FssLoanBizException;
import com.yundian.fss.manager.FssLoanDistributeManager;
import com.yundian.fssapi.domain.FssLoanDistributeModel;
import com.yundian.fssapi.domain.query.FssLoanDistributeQueryModel;
import com.yundian.result.PaginatedResult;
import com.yundian.result.Paginator;
import com.yundian.result.ResultCodeContants;

/**
 * 贷款分配服务实现
 * 
 * @author hehaibo
 * @version $Id: FssLoanDistributeManagerImpl.java, v 0.1 2016年7月26日 下午8:59:44
 *          hehaibo Exp $
 */
@Transactional
public class FssLoanDistributeManagerImpl implements FssLoanDistributeManager {
	private static final Logger logger = LoggerFactory
			.getLogger(FssLoanDistributeManagerImpl.class);
	@Autowired
	private FssLoanDistributeModelMapper fssLoanDistributeModelMapper;

	public Integer insertFssLoanDistribute(
			FssLoanDistributeModel fssLoanDistributeModel) {
		try {
			//TODO 贷款业务分配逻辑
			Integer row = this.fssLoanDistributeModelMapper
					.insert(fssLoanDistributeModel);
			return row;
		} catch (Exception e) {
			logger.error(
					String.format("添加贷款分配异常:%s", ToStringBuilder
							.reflectionToString(fssLoanDistributeModel)), e);
			throw new FssLoanBizException(ResultCodeContants.failed, "添加贷款分配异常", e);
		}
	}

	public Integer updateFssLoanDistribute(
			FssLoanDistributeModel fssLoanDistributeModel) {
		try {
			Integer row = this.fssLoanDistributeModelMapper
					.updateByPrimaryKey(fssLoanDistributeModel);
			return row;
		} catch (Exception e) {
			logger.error(
					String.format("修改贷款分配异常:%s", ToStringBuilder
							.reflectionToString(fssLoanDistributeModel)), e);
			throw new FssLoanBizException(ResultCodeContants.failed, "修改贷款分配异常", e);
		}
	}

	public Integer deleteFssLoanDistributeById(Long id) {
		try {
			Integer row = this.fssLoanDistributeModelMapper
					.deleteByPrimaryKey(id);
			return row;
		} catch (Exception e) {
			logger.error(String.format("删除贷款分配异常:%s", id), e);
			throw new FssLoanBizException(ResultCodeContants.failed, "删除贷款分配异常", e);
		}
	}

	public FssLoanDistributeModel getFssLoanDistributeById(Long id) {
		try {
			FssLoanDistributeModel row = this.fssLoanDistributeModelMapper
					.selectByPrimaryKey(id);
			return row;
		} catch (Exception e) {
			logger.error(String.format("查询贷款分配异常:%s", id), e);
			throw new FssLoanBizException(ResultCodeContants.failed, "查询贷款分配异常", e);
		}
	}

	public List<FssLoanDistributeQueryModel> getFssLoanDistributeListByLoanId(Long loanId) {
		try {
			List<FssLoanDistributeQueryModel> row = this.fssLoanDistributeModelMapper
					.getFssLoanDistributeListByLoanId(loanId);
			return row;
		} catch (Exception e) {
			logger.error(
					String.format("根据LoanId查询贷款分配异常:%d", loanId), e);
			throw new FssLoanBizException(ResultCodeContants.failed, "根据LoanId查询贷款分配异常", e);
		}
	}

	public PaginatedResult<FssLoanDistributeModel> getPaginatorFssLoanDistribute(
			Paginator<FssLoanDistributeModel> paginator) {
		try {
			PaginatedResult<FssLoanDistributeModel> data = null;
			// TODO
			return data;
		} catch (Exception e) {
			logger.error(
					String.format("分页查询贷款分配异常:%s",
							ToStringBuilder.reflectionToString(paginator)), e);
			throw new FssLoanBizException(ResultCodeContants.failed, "", e);
		}
	}

}
