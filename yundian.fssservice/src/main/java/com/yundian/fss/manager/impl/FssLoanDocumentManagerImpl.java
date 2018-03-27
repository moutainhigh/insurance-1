package com.yundian.fss.manager.impl;

import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.yundian.fss.dao.FssLoanDocumentModelMapper;
import com.yundian.fss.exception.FssLoanBizException;
import com.yundian.fss.manager.FssLoanDocumentManager;
import com.yundian.fssapi.domain.FssLoanDocumentModel;
import com.yundian.result.PaginatedResult;
import com.yundian.result.Paginator;
import com.yundian.result.ResultCodeContants;

/**
 * 贷款文档服务实现
 * 
 * @author hehaibo
 * @version $Id: FssLoanDocumentManagerImpl.java, v 0.1 2016年7月26日 下午8:59:44
 *          hehaibo Exp $
 */
@Transactional
public class FssLoanDocumentManagerImpl implements FssLoanDocumentManager {
	private static final Logger logger = LoggerFactory
			.getLogger(FssLoanDocumentManagerImpl.class);
	@Autowired
	private FssLoanDocumentModelMapper fssLoanDocumentModelMapper;

	public Integer insertFssLoanDocument(
			FssLoanDocumentModel fssLoanDocumentModel) {
		try {
			Integer row = this.fssLoanDocumentModelMapper
					.insert(fssLoanDocumentModel);
			return row;
		} catch (Exception e) {
			logger.error(String.format("添加贷款文档异常:%s",
					ToStringBuilder.reflectionToString(fssLoanDocumentModel)),
					e);
			throw new FssLoanBizException(ResultCodeContants.failed, "", e);
		}
	}

	@Override
	public Integer batchInsertFssLoanDocument(
			List<FssLoanDocumentModel> loanDocumentList) {
		try {
			Integer row = this.fssLoanDocumentModelMapper
					.batchInsert(loanDocumentList);
			return row;
		} catch (Exception e) {
			logger.error(String.format("批量添加贷款文档异常:%s",
					ToStringBuilder.reflectionToString(loanDocumentList)),
					e);
			throw new FssLoanBizException(ResultCodeContants.failed, "批量添加贷款文档异常", e);
		}
	}



	public Integer updateFssLoanDocument(
			FssLoanDocumentModel fssLoanDocumentModel) {
		try {
			Integer row = this.fssLoanDocumentModelMapper
					.updateByPrimaryKey(fssLoanDocumentModel);
			return row;
		} catch (Exception e) {
			logger.error(String.format("修改贷款文档异常:%s",
					ToStringBuilder.reflectionToString(fssLoanDocumentModel)),
					e);
			throw new FssLoanBizException(ResultCodeContants.failed, "", e);
		}
		
	}

	public Integer deleteFssLoanDocumentById(Long id) {
		try {
			Integer row = this.fssLoanDocumentModelMapper
					.deleteByPrimaryKey(id);
			return row;
		} catch (Exception e) {
			logger.error(String.format("删除贷款文档异常:%d", id), e);
			throw new FssLoanBizException(ResultCodeContants.failed, "", e);
		}
		
	}

	public FssLoanDocumentModel getFssLoanDocumentById(Long id) {

		try {
			FssLoanDocumentModel row = this.fssLoanDocumentModelMapper
					.selectByPrimaryKey(id);
			return row;
		} catch (Exception e) {
			logger.error(String.format("获得贷款文档异常:%d", id), e);
			throw new FssLoanBizException(ResultCodeContants.failed, "", e);
		}

	}

	public List<FssLoanDocumentModel> getFssLoanDocumentListByLoanId(Long loanId) {
		try {
			List<FssLoanDocumentModel> row = 
					this.fssLoanDocumentModelMapper.
					getFssLoanDocumentListByLoanId(loanId);
			return row;
		} catch (Exception e) {
			logger.error(String.format("获得贷款文档异常:%d",loanId),
					e);
			throw new FssLoanBizException(ResultCodeContants.failed, "", e);
		}

	}

	public PaginatedResult<FssLoanDocumentModel> getPaginatorFssLoanDocument(
			Paginator<FssLoanDocumentModel> paginator) {
		try {
			PaginatedResult<FssLoanDocumentModel> row = null;
			return row;
		} catch (Exception e) {
			logger.error(
					String.format("分页查询获得贷款文档异常:%d",
							ToStringBuilder.reflectionToString(paginator)), e);
			throw new FssLoanBizException(ResultCodeContants.failed, "", e);
		}
	}

	@Override
	public List<FssLoanDocumentModel> getFssLoanDocumentListByLoanIdAndDocumentType(
			Long loanId, String documentType) {
		try {
			return this.fssLoanDocumentModelMapper.getFssLoanDocumentListByLoanIdAndDocumentType(loanId,documentType);
		} catch (Exception e) {
			logger.error(
					String.format("查询获得贷款文档异常:loanId=%d,documentType=%s",
							loanId,documentType), e);
			throw new FssLoanBizException(ResultCodeContants.failed, "系统异常", e);
		}
	}
	
	

}
