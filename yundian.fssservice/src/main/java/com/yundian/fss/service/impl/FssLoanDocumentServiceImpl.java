package com.yundian.fss.service.impl;

import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.yundian.fss.exception.FssLoanBizException;
import com.yundian.fss.manager.FssLoanDocumentManager;
import com.yundian.fssapi.domain.FssLoanDocumentModel;
import com.yundian.fssapi.service.FssLoanDocumentService;
import com.yundian.result.PaginatedResult;
import com.yundian.result.Paginator;
import com.yundian.result.Result;
import com.yundian.result.ResultCodeContants;

/**
 * 贷款文档服务实现
 * 
 * @author hehaibo
 * @version $Id: FssLoanDocumentServiceImpl.java, v 0.1 2016年7月26日 下午8:59:44
 *          hehaibo Exp $
 */
public class FssLoanDocumentServiceImpl implements FssLoanDocumentService {
	private static final Logger logger = LoggerFactory
			.getLogger(FssLoanDocumentServiceImpl.class);
	@Autowired
	private FssLoanDocumentManager fssLoanDocumentManager;

	public Result<Integer> insertFssLoanDocument(
			FssLoanDocumentModel fssLoanDocumentModel) {
		Result<Integer> result = new Result<Integer>();
		try {
			Integer row = this.fssLoanDocumentManager
					.insertFssLoanDocument(fssLoanDocumentModel);
			result.setData(row);
			result.setCode(ResultCodeContants.success);
		} catch (Exception e) {
			logger.error(String.format("添加贷款文档异常:%s",
					ToStringBuilder.reflectionToString(fssLoanDocumentModel)),
					e);
			if (e instanceof FssLoanBizException) {
				FssLoanBizException be = (FssLoanBizException) e;
				result.setCode(be.getCode());
				result.setMessage(be.getErrorMsg());
			} else {
				result.setCode(ResultCodeContants.failed);
				result.setMessage("系统异常");
			}
		}
		return result;
	}

	public Result<Integer> updateFssLoanDocument(
			FssLoanDocumentModel fssLoanDocumentModel) {
		Result<Integer> result = new Result<Integer>();
		try {
			Integer row = this.fssLoanDocumentManager
					.updateFssLoanDocument(fssLoanDocumentModel);
			result.setData(row);
			result.setCode(ResultCodeContants.success);
		} catch (Exception e) {
			logger.error(String.format("修改贷款文档异常:%s",
					ToStringBuilder.reflectionToString(fssLoanDocumentModel)),
					e);
			if (e instanceof FssLoanBizException) {
				FssLoanBizException be = (FssLoanBizException) e;
				result.setCode(be.getCode());
				result.setMessage(be.getErrorMsg());
			} else {
				result.setCode(ResultCodeContants.failed);
				result.setMessage("系统异常");
			}
		}
		return result;
	}

	public Result<Integer> deleteFssLoanDocumentById(Long id) {
		Result<Integer> result = new Result<Integer>();
		try {
			Integer row = this.fssLoanDocumentManager
					.deleteFssLoanDocumentById(id);
			result.setData(row);
			result.setCode(ResultCodeContants.success);
		} catch (Exception e) {
			logger.error(String.format("删除贷款文档异常:%d", id), e);
			if (e instanceof FssLoanBizException) {
				FssLoanBizException be = (FssLoanBizException) e;
				result.setCode(be.getCode());
				result.setMessage(be.getErrorMsg());
			} else {
				result.setCode(ResultCodeContants.failed);
				result.setMessage("系统异常");
			}
		}
		return result;
	}

	public Result<FssLoanDocumentModel> getFssLoanDocumentById(Long id) {

		Result<FssLoanDocumentModel> result = new Result<FssLoanDocumentModel>();
		try {
			FssLoanDocumentModel row = this.fssLoanDocumentManager
					.getFssLoanDocumentById(id);
			result.setData(row);
			result.setCode(ResultCodeContants.success);
		} catch (Exception e) {
			logger.error(String.format("获得贷款文档异常:%d", id), e);
			if (e instanceof FssLoanBizException) {
				FssLoanBizException be = (FssLoanBizException) e;
				result.setCode(be.getCode());
				result.setMessage(be.getErrorMsg());
			} else {
				result.setCode(ResultCodeContants.failed);
				result.setMessage("系统异常");
			}
		}
		return result;

	}

	public Result<List<FssLoanDocumentModel>> getFssLoanDocumentListByLoanId(
			Long loanId) {
		Result<List<FssLoanDocumentModel>> result = new Result<List<FssLoanDocumentModel>>();
		try {
			List<FssLoanDocumentModel> row = fssLoanDocumentManager
					.getFssLoanDocumentListByLoanId(loanId);
			result.setData(row);
			result.setCode(ResultCodeContants.success);
		} catch (Exception e) {
			logger.error(String.format("获得贷款文档异常:%d", loanId), e);
			if (e instanceof FssLoanBizException) {
				FssLoanBizException be = (FssLoanBizException) e;
				result.setCode(be.getCode());
				result.setMessage(be.getErrorMsg());
			} else {
				result.setCode(ResultCodeContants.failed);
				result.setMessage("系统异常");
			}
		}
		return result;

	}

	public Result<PaginatedResult<FssLoanDocumentModel>> getPaginatorFssLoanDocument(
			Paginator<FssLoanDocumentModel> paginator) {
		Result<PaginatedResult<FssLoanDocumentModel>> result = new Result<PaginatedResult<FssLoanDocumentModel>>();
		try {
			PaginatedResult<FssLoanDocumentModel> row = null;
			// TODO
			result.setData(row);
			result.setCode(ResultCodeContants.success);
		} catch (Exception e) {
			logger.error(
					String.format("分页查询获得贷款文档异常:%s",
							ToStringBuilder.reflectionToString(paginator)), e);
			if (e instanceof FssLoanBizException) {
				FssLoanBizException be = (FssLoanBizException) e;
				result.setCode(be.getCode());
				result.setMessage(be.getErrorMsg());
			} else {
				result.setCode(ResultCodeContants.failed);
				result.setMessage("系统异常");
			}
		}
		return result;
	}

	@Override
	public Result<List<FssLoanDocumentModel>> getFssLoanDocumentListByLoanIdAndDocumentType(
			Long loanId, String documentType) {
		Result<List<FssLoanDocumentModel>> result = new Result<List<FssLoanDocumentModel>>();
		try {
			List<FssLoanDocumentModel> row = fssLoanDocumentManager
					.getFssLoanDocumentListByLoanIdAndDocumentType(loanId,
							documentType);
			result.setData(row);
			result.setCode(ResultCodeContants.success);
		} catch (Exception e) {
			logger.error(String.format("获得贷款文档异常:%d", loanId), e);
			if (e instanceof FssLoanBizException) {
				FssLoanBizException be = (FssLoanBizException) e;
				result.setCode(be.getCode());
				result.setMessage(be.getErrorMsg());
			} else {
				result.setCode(ResultCodeContants.failed);
				result.setMessage("系统异常");
			}
		}
		return result;
	}

}
