package com.yundian.fss.manager.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.yundian.fssapi.dto.MyTaskQueryCriterion;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.yundian.fss.dao.FssLoanAuditingLogModelMapper;
import com.yundian.fss.exception.FssLoanBizException;
import com.yundian.fss.manager.FssLoanAuditingLogManager;
import com.yundian.fssapi.domain.FssLoanAuditingLogModel;
import com.yundian.fssapi.domain.query.FssLoanAuditingLogQueryModel;
import com.yundian.result.PaginatedResult;
import com.yundian.result.Paginator;
import com.yundian.result.ResultCodeContants;
import com.yundian.toolkit.utils.BeanUtilsExt;

/**
 * 贷款审核服务实现
 * 
 * @author hehaibo
 * @version $Id: FssLoanAuditingLogManagerImpl.java, v 0.1 2016年7月26日 下午8:59:44
 *          hehaibo Exp $
 */
@Transactional
public class FssLoanAuditingLogManagerImpl implements FssLoanAuditingLogManager {
	private static final Logger logger = LoggerFactory
			.getLogger(FssLoanAuditingLogManagerImpl.class);

	@Autowired
	private FssLoanAuditingLogModelMapper fssLoanAuditingLogModelMapper;

	public Integer insertFssLoanAuditingLog(
			FssLoanAuditingLogModel fssLoanAuditingLogModel) {
		try {
			Integer row = this.fssLoanAuditingLogModelMapper
					.insert(fssLoanAuditingLogModel);
			return row;
		} catch (Exception e) {
			logger.error(
					String.format("添加审核日志异常:%s", ToStringBuilder
							.reflectionToString(fssLoanAuditingLogModel)), e);
			throw new FssLoanBizException(ResultCodeContants.failed, "添加审核日志失败", e);
		}

	}

	public Integer updateFssLoanAuditingLog(
			FssLoanAuditingLogModel fssLoanAuditingLogModel) {
		try {
			Integer row = this.fssLoanAuditingLogModelMapper
					.updateByPrimaryKey(fssLoanAuditingLogModel);
			return row;
		} catch (Exception e) {
			logger.error(
					String.format("修改审核日志异常:%s", ToStringBuilder
							.reflectionToString(fssLoanAuditingLogModel)), e);
			throw new FssLoanBizException(ResultCodeContants.failed, "修改审核日志异常", e);
		}
	}

	public Integer deleteFssLoanAuditingLogByLogId(Long logId) {
		try {
			Integer row = this.fssLoanAuditingLogModelMapper
					.deleteByPrimaryKey(logId);
			return row;
		} catch (Exception e) {
			logger.error(String.format("删除审核日志异常:%s", logId), e);
			throw new FssLoanBizException(ResultCodeContants.failed, "删除审核日志失败", e);
		}
	}

	public FssLoanAuditingLogModel getFssLoanAuditingLogById(Long logId) {
		try {
			FssLoanAuditingLogModel row = this.fssLoanAuditingLogModelMapper
					.selectByPrimaryKey(logId);
			return row;
		} catch (Exception e) {
			logger.error(String.format("查询审核日志异常:%s", logId), e);
			throw new FssLoanBizException(ResultCodeContants.failed, "查询异常", e);
		}
	}

	public List<FssLoanAuditingLogQueryModel> getFssLoanAuditingLogListByLoanId(Long loanId) {
		try {
			List<FssLoanAuditingLogQueryModel> data = this.fssLoanAuditingLogModelMapper.getFssLoanAuditingLogListByLoanId(loanId);
			return data;
		} catch (Exception e) {
			logger.error(
					String.format("查询贷款列表审核日志异常:%d", loanId), e);
			throw new FssLoanBizException(ResultCodeContants.failed, "查询贷款列表审核日志异常", e);
		}
	}

	public PaginatedResult<FssLoanAuditingLogQueryModel> getPaginatorFssLoanAuditingLog(
			Paginator<FssLoanAuditingLogModel> paginator) {
		try {
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("_limit", paginator.getPageSize());
			param.put("_offset",
					(paginator.getCurrentPage() - 1) * paginator.getPageSize());
			BeanUtilsExt.copyPropertiesToMap(paginator.getParam(), param);

			List<FssLoanAuditingLogQueryModel> list = this.fssLoanAuditingLogModelMapper
					.getFssLoanAuditingLogPaging(param);
			Integer count = fssLoanAuditingLogModelMapper
					.getFssLoanAuditingLogPagingCount(param);
			PaginatedResult<FssLoanAuditingLogQueryModel> paginatedResult = new PaginatedResult<FssLoanAuditingLogQueryModel>();
			paginatedResult.setRows(list);
			paginatedResult.setTotal(count);
			return paginatedResult;
		} catch (Exception e) {
			logger.error(
					String.format("分页查询审核日志异常:%s",
							ToStringBuilder.reflectionToString(paginator)), e);
			throw new FssLoanBizException(ResultCodeContants.failed, "", e);
		}

	}

	@Override
	public PaginatedResult<FssLoanAuditingLogQueryModel> queryPagingResult(MyTaskQueryCriterion queryCriterion) {
		try {
			List<FssLoanAuditingLogQueryModel> list;
			Integer count;
			PaginatedResult<FssLoanAuditingLogQueryModel> paginatedResult = new PaginatedResult<FssLoanAuditingLogQueryModel>();
			if(!queryCriterion.getProcessed()) {
				list = this.fssLoanAuditingLogModelMapper
						.queryUnprocessedPagingResult(queryCriterion);
				count = fssLoanAuditingLogModelMapper
						.queryUnprocessedPagingResultCount(queryCriterion);
			}
			else{
				list = this.fssLoanAuditingLogModelMapper
						.queryProcessedPagingResult(queryCriterion);
				count = fssLoanAuditingLogModelMapper
						.queryProcessedPagingResultCount(queryCriterion);
			}
			paginatedResult.setRows(list);
			paginatedResult.setTotal(count);
			return paginatedResult;
		} catch (Exception e) {
			logger.error(
					String.format("分页查询审核日志异常:%s",
							ToStringBuilder.reflectionToString(queryCriterion)), e);
			throw new FssLoanBizException(ResultCodeContants.failed, "", e);
		}
	}
}
