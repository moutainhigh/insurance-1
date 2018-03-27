/**
 * 
 */
package com.yundian.fss.service.impl;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.yundian.fss.exception.FssLoanBizException;
import com.yundian.fss.manager.FssOrganizationManager;
import com.yundian.fssapi.domain.FssOrganizationModel;
import com.yundian.fssapi.service.FssOrganizationService;
import com.yundian.result.PaginatedResult;
import com.yundian.result.Paginator;
import com.yundian.result.Result;
import com.yundian.result.ResultCodeContants;

import java.util.List;

/**
 * @author hehaibo
 *
 */

public class FssOrganizationServiceImpl implements FssOrganizationService {
	private static final Logger logger = LoggerFactory
			.getLogger(FssOrganizationServiceImpl.class);
	@Autowired
	private FssOrganizationManager fssOrganizationManager;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.yundian.fssapi.user.service.FssOrganizationService#addFssOrganization
	 * (com.yundian.fssapi.domain.FssOrganizationModel)
	 */
	@Override
	public Result<Integer> addFssOrganization(
			FssOrganizationModel fssOrganizationModel) {
		logger.info(String.format("新增审批机构参数:%s",
				ToStringBuilder.reflectionToString(fssOrganizationModel)));
		Result<Integer> result = new Result<Integer>();
		try {
			int id = fssOrganizationManager
					.addFssOrganization(fssOrganizationModel);
			result.setCode(ResultCodeContants.success);
			result.setMessage("添加成功");
			result.setData(id);
		} catch (Exception e) {
			logger.error(String.format("新增审批异常,参数：%s",
					ToStringBuilder.reflectionToString(fssOrganizationModel)),
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.yundian.fssapi.user.service.FssOrganizationService#modifyFssOrganization
	 * (com.yundian.fssapi.domain.FssOrganizationModel)
	 */
	@Override
	public Result<Integer> modifyFssOrganization(
			FssOrganizationModel fssOrganizationModel) {
		Result<Integer> result = new Result<Integer>();

		try {
			Integer updateRow = this.fssOrganizationManager
					.modifyFssOrganization(fssOrganizationModel);
			result.setData(updateRow);
			result.setCode(ResultCodeContants.success);
		} catch (Exception e) {
			logger.error(String.format("修改审批异常,参数：%s",
					ToStringBuilder.reflectionToString(fssOrganizationModel)),
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
	public Result<FssOrganizationModel> getFssOrganizationById(
			Long organizationId) {
		Result<FssOrganizationModel> result = new Result<FssOrganizationModel>();
		try {
			FssOrganizationModel fssOrganizationModel = this.fssOrganizationManager
					.getFssOrganizationById(organizationId);
			result.setCode(ResultCodeContants.success);
			result.setData(fssOrganizationModel);
		} catch (Exception e) {
			logger.error(String.format("查询审批异常,参数：%d", organizationId), e);
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.yundian.fssapi.user.service.FssOrganizationService#getPaginatedResult
	 * (com.yundian.result.Paginator)
	 */
	@Override
	public Result<PaginatedResult<FssOrganizationModel>> getPaginatedResultFssOrganization(
			Paginator<FssOrganizationModel> paginator) {
		Result<PaginatedResult<FssOrganizationModel>> result = new Result<PaginatedResult<FssOrganizationModel>>();
		try {

			PaginatedResult<FssOrganizationModel> paginatedResult = this.fssOrganizationManager
					.getPaginatedResult(paginator);
			result.setData(paginatedResult);
			result.setCode(ResultCodeContants.success);
		} catch (Exception e) {
			logger.error(
					String.format("分页查询审批机构异常：%s",
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
	public Result<List<FssOrganizationModel>> listAllOrganization() {
		Result<List<FssOrganizationModel>> result = new Result<List<FssOrganizationModel>>();
		try {

			List<FssOrganizationModel> paginatedResult = this.fssOrganizationManager
					.listAllOrganization();
			result.setData(paginatedResult);
			result.setCode(ResultCodeContants.success);
		} catch (Exception e) {
			logger.error(
					String.format("查询审批机构异常"), e);
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
