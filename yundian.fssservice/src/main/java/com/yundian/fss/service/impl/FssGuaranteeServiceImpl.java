package com.yundian.fss.service.impl;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.yundian.fss.exception.FssLoanBizException;
import com.yundian.fss.manager.FssGuaranteeManager;
import com.yundian.fssapi.domain.FssGuaranteeModel;
import com.yundian.fssapi.service.FssGuaranteeService;
import com.yundian.result.PaginatedResult;
import com.yundian.result.Paginator;
import com.yundian.result.Result;
import com.yundian.result.ResultCodeContants;

/**
 * 
 * 担保服务
 * 
 * @author hehaibo
 *
 */
public class FssGuaranteeServiceImpl implements FssGuaranteeService {

	private static final Logger logger = LoggerFactory
			.getLogger(FssGuaranteeServiceImpl.class);
	@Autowired
	private FssGuaranteeManager fssGuaranteeModelMapper;

	@Override
	public Result<Integer> addGuarantee(FssGuaranteeModel fssGuaranteeModel) {
		Result<Integer> result = new Result<Integer>();
		try {
			Integer resultInt = fssGuaranteeModelMapper
					.addGuarantee(fssGuaranteeModel);
			result.setData(resultInt);
			result.setCode(ResultCodeContants.success);
		} catch (Exception e) {
			logger.error(String.format("添加担保机构信息异常：%s",
					ToStringBuilder.reflectionToString(fssGuaranteeModel)), e);
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
	public Result<Integer> modifyGuarantee(FssGuaranteeModel fssGuaranteeModel) {
		Result<Integer> result = new Result<Integer>();
		try {

			Integer resultInt = fssGuaranteeModelMapper
					.modifyGuarantee(fssGuaranteeModel);
			result.setData(resultInt);
			result.setCode(ResultCodeContants.success);
		} catch (Exception e) {
			logger.error(String.format("修改担保机构信息异常：%s",
					ToStringBuilder.reflectionToString(fssGuaranteeModel)), e);
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
	public Result<FssGuaranteeModel> getFssGuaranteeById(Long fssGuaranteeId) {
		Result<FssGuaranteeModel> result = new Result<FssGuaranteeModel>();
		try {
			FssGuaranteeModel fssGuaranteeModel = fssGuaranteeModelMapper
					.getFssGuaranteeById(fssGuaranteeId);
			result.setData(fssGuaranteeModel);
			result.setCode(ResultCodeContants.success);
		} catch (Exception e) {
			logger.error(String.format("获取单个担保机构信息异常：%d", fssGuaranteeId), e);
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
	public Result<PaginatedResult<FssGuaranteeModel>> getPaginatedResultFssGuarantee(
			Paginator<FssGuaranteeModel> paginator) {
		Result<PaginatedResult<FssGuaranteeModel>> result = new Result<PaginatedResult<FssGuaranteeModel>>();
		try {

			PaginatedResult<FssGuaranteeModel> paginatedResult = this.fssGuaranteeModelMapper
					.getPaginatedResult(paginator);
			result.setData(paginatedResult);
			result.setCode(ResultCodeContants.success);
		} catch (Exception e) {
			logger.error(
					String.format("分页查询担保机构异常：%s",
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

}
