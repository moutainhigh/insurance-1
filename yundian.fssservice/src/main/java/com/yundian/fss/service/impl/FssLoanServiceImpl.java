
package com.yundian.fss.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.yundian.fss.exception.FssLoanBizException;
import com.yundian.fss.manager.FssLoanManager;
import com.yundian.fssapi.domain.FssLoanAuditingLogModel;
import com.yundian.fssapi.domain.FssLoanModel;
import com.yundian.fssapi.domain.FssOrganizationUserModel;
import com.yundian.fssapi.domain.FssUserModel;
import com.yundian.fssapi.domain.query.FssLoanQueryModel;
import com.yundian.fssapi.domain.statistics.LoanCompareStatModel;
import com.yundian.fssapi.domain.statistics.LoanTypeMonthTrendStatModel;
import com.yundian.fssapi.domain.statistics.LoanTypeStatItemModel;
import com.yundian.fssapi.dto.FssLoanAuditStatusStatisticsResult;
import com.yundian.fssapi.dto.param.FssLoanQueryParam;
import com.yundian.fssapi.service.FssLoanService;
import com.yundian.result.PaginatedResult;
import com.yundian.result.Paginator;
import com.yundian.result.Result;
import com.yundian.result.ResultCodeContants;

/**
 * 贷款服务实现
 * 
 * @author hehaibo
 * @version $Id: FssLoanServiceImpl.java, v 0.1 2016年7月26日 下午8:59:44 hehaibo Exp $
 */
public class FssLoanServiceImpl implements FssLoanService{
	private static final Logger logger=LoggerFactory.getLogger(FssLoanServiceImpl.class);

	@Autowired
	private FssLoanManager fssLoanManager;
	
	public Result<Long> insertFssLoan (FssLoanModel fssLoanModel){
		Result<Long> result = new Result<Long>();
		try {
			Long loanId=this.fssLoanManager.insertFssLoan(fssLoanModel);
			result.setData(loanId);
			result.setCode(ResultCodeContants.success);
		} catch (Exception e) {
			logger.error(String.format("添加贷款信息异常:%s",
					ToStringBuilder.reflectionToString(fssLoanModel)),e);
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
	
	public Result<Integer> updateFssLoan(FssLoanModel fssLoanModel){
		Result<Integer> result = new Result<Integer>();
		try {
			Integer row= this.fssLoanManager.updateFssLoan(fssLoanModel);
			result.setData(row);
			result.setCode(ResultCodeContants.success);
		} catch (Exception e) {
			logger.error(String.format("修改贷款信息异常:%s",
					ToStringBuilder.reflectionToString(fssLoanModel)),e);
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

			
	public Result<Integer> deleteFssLoanByLoanId ( Long loanId )
	{
		Result<Integer> result = new Result<Integer>();
		try {
			//TODO 要判断其他的数据是否有删除
			Integer row= this.fssLoanManager.deleteFssLoanByLoanId(loanId);
			result.setData(row);
			result.setCode(ResultCodeContants.success);
		} catch (Exception e) {
			logger.error(String.format("删除贷款信息异常:%d",loanId),e);
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
																																																												
	public Result<FssLoanModel> getFssLoanById(Long id){
		Result<FssLoanModel> result = new Result<FssLoanModel>();
		try {
			FssLoanModel row= this.fssLoanManager.getFssLoanById(id);
			result.setData(row);
			result.setCode(ResultCodeContants.success);
		} catch (Exception e) {
			logger.error(String.format("查询单个贷款信息异常:%d",id),e);
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
	public Result<FssLoanModel> getFssLoanByLoanCode(String loanCode) {
		Result<FssLoanModel> result = new Result<FssLoanModel>();
		try {
			FssLoanModel row= this.fssLoanManager.getFssLoanByLoanCode(loanCode);
			result.setData(row);
			result.setCode(ResultCodeContants.success);
		} catch (Exception e) {
			logger.error(String.format("查询单个贷款信息异常:%s",loanCode),e);
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

	public Result<List<FssLoanModel>> getFssLoanList(FssLoanModel fssLoanModel){
		Result<List<FssLoanModel>> result = new Result<List<FssLoanModel>>();
		try {
			List<FssLoanModel> row= this.fssLoanManager.getFssLoanList(fssLoanModel);
			result.setData(row);
			result.setCode(ResultCodeContants.success);
			
		} catch (Exception e) {
			logger.error(String.format("查询列表贷款信息异常:%s",
					ToStringBuilder.reflectionToString(fssLoanModel)),e);
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
	

	public Result<PaginatedResult<FssLoanQueryModel>> getPaginatorFssLoan(
            Paginator<FssLoanQueryParam> paginator){
		Result<PaginatedResult<FssLoanQueryModel>> result = new Result<PaginatedResult<FssLoanQueryModel>>();
		try {
			PaginatedResult<FssLoanQueryModel> data=this.fssLoanManager.getPaginatorFssLoan(paginator);
			result.setData(data);
			result.setCode(ResultCodeContants.success);
		} catch (Exception e) {
			logger.error(String.format("分页查询贷款信息异常:%s",
					ToStringBuilder.reflectionToString(paginator)),e);
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
	public Result<FssLoanAuditStatusStatisticsResult> getFssLoanStatisticsCountByAuditStatus(
			FssLoanQueryParam fssLoanQueryParam) {
		Result<FssLoanAuditStatusStatisticsResult> result = new Result<FssLoanAuditStatusStatisticsResult>();
		try {
			FssLoanAuditStatusStatisticsResult data=this.fssLoanManager.getFssLoanStatisticsCountByAuditStatus(fssLoanQueryParam);
			result.setData(data);
			result.setCode(ResultCodeContants.success);
		} catch (Exception e) {
			logger.error(String.format("根据贷款状态统计查询信息异常:%s",
					ToStringBuilder.reflectionToString(fssLoanQueryParam)),e);
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
	public Result<Integer> submitLoanApprove(FssUserModel fssUserModel,
			FssLoanAuditingLogModel fssLoanAuditingLogModel) {
		Result<Integer> result=new Result<Integer>();
		try {
			Integer row=this.fssLoanManager.submitLoanApprove(fssUserModel,fssLoanAuditingLogModel);
			result.setData(row);
		} catch (Exception e) {
			logger.error(String.format("提交审批异常:fssUserModel=%s",
					fssLoanAuditingLogModel,
					ToStringBuilder.reflectionToString(fssUserModel),
					ToStringBuilder.reflectionToString(fssLoanAuditingLogModel)),e);
			if(e instanceof FssLoanBizException){
				FssLoanBizException be=(FssLoanBizException)e;
				result.setCode(be.getCode());
				result.setMessage(be.getMessage());
			}else{
				result.setCode(ResultCodeContants.failed);
				result.setMessage("系统错误");
			}
		}
		return result;
	}

	@Override
	public Result<Integer> approvePass(
			FssOrganizationUserModel organizationUser,
			FssLoanAuditingLogModel fssLoanAuditingLogModel) {
		Result<Integer> result=new Result<Integer>();
		try {
			Integer row=this.fssLoanManager.approvePass(organizationUser,fssLoanAuditingLogModel);
			result.setData(row);
		} catch (Exception e) {
			logger.error(String.format("提交审批异常:organizationUser=%s",
					fssLoanAuditingLogModel,
					ToStringBuilder.reflectionToString(organizationUser),
					ToStringBuilder.reflectionToString(organizationUser)),e);
			if(e instanceof FssLoanBizException){
				FssLoanBizException be=(FssLoanBizException)e;
				result.setCode(be.getCode());
				result.setMessage(be.getMessage());
			}else{
				result.setCode(ResultCodeContants.failed);
				result.setMessage("系统错误");
			}
		}
		return result;
	}

	@Override
	public Result<Integer> approveNotPass(
			FssOrganizationUserModel organizationUser,
			FssLoanAuditingLogModel fssLoanAuditingLogModel) {
		Result<Integer> result=new Result<Integer>();
		try {
			Integer row=this.fssLoanManager.approveReject(organizationUser,fssLoanAuditingLogModel);
			result.setData(row);
		} catch (Exception e) {
			logger.error(String.format("提交审批异常:organizationUser=%s",
					fssLoanAuditingLogModel,
					ToStringBuilder.reflectionToString(organizationUser),
					ToStringBuilder.reflectionToString(fssLoanAuditingLogModel)),e);
			if(e instanceof FssLoanBizException){
				FssLoanBizException be=(FssLoanBizException)e;
				result.setCode(be.getCode());
				result.setMessage(be.getMessage());
			}else{
				result.setCode(ResultCodeContants.failed);
				result.setMessage("系统错误");
			}
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.yundian.fssapi.service.FssLoanService#loanTypeStat(java.lang.String, java.lang.String)
	 */
	@Override
	public Result<List<LoanTypeStatItemModel>> loanTypeStat(Long guaranteeId ,Long bankId,String startDate,
			String endDate) {
		Result<List<LoanTypeStatItemModel>> result=new Result<List<LoanTypeStatItemModel>>();
		try {
			List<LoanTypeStatItemModel> loanTypeStatItemModel=this.fssLoanManager.loanTypeStat(guaranteeId,bankId,startDate,endDate);
			result.setData(loanTypeStatItemModel);
		} catch (Exception e) {
			logger.error(String.format("按日期查询贷款统计异常:startDate=%s,endDate=%s", startDate,endDate),e);
			if(e instanceof FssLoanBizException){
				FssLoanBizException be=(FssLoanBizException)e;
				result.setCode(be.getCode());
				result.setMessage(be.getMessage());
			}else{
				result.setCode(ResultCodeContants.failed);
				result.setMessage("系统错误");
			}
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.yundian.fssapi.service.FssLoanService#loanCompareStat(java.lang.String, java.lang.String)
	 */
	@Override
	public Result<LoanCompareStatModel> loanCompareStat(Long guaranteeId ,Long bankId,String startDate) {
		Result<LoanCompareStatModel> result=new Result<LoanCompareStatModel>();
		try {
			LoanCompareStatModel result2=this.fssLoanManager.loanCompareStat(guaranteeId,bankId,startDate);
			result.setData(result2);
		} catch (Exception e) {
			logger.error(String.format("按日期查询贷款统计异常:startDate=%s", startDate),e);
			if(e instanceof FssLoanBizException){
				FssLoanBizException be=(FssLoanBizException)e;
				result.setCode(be.getCode());
				result.setMessage(be.getMessage());
			}else{
				result.setCode(ResultCodeContants.failed);
				result.setMessage("系统错误");
			}
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.yundian.fssapi.service.FssLoanService#loanTypeCompareStat(java.lang.String, java.lang.String)
	 */
	@Override
	public Result<LoanTypeMonthTrendStatModel> loanTypeCompareStat(Long guaranteeId ,Long bankId,
			String startDate, String endDate) {
		Result<LoanTypeMonthTrendStatModel> result=new Result<LoanTypeMonthTrendStatModel>();
		try {
			LoanTypeMonthTrendStatModel result2=this.fssLoanManager.loanTypeCompareStat(guaranteeId,bankId,startDate,endDate);
			result.setData(result2);
		} catch (Exception e) {
			logger.error(String.format("按日期查询贷款统计异常:startDate=%s", startDate),e);
			if(e instanceof FssLoanBizException){
				FssLoanBizException be=(FssLoanBizException)e;
				result.setCode(be.getCode());
				result.setMessage(be.getMessage());
			}else{
				result.setCode(ResultCodeContants.failed);
				result.setMessage("系统错误");
			}
		}
		return result;
	}
	@Override
	public Result<Map<String,Integer>> loanStatusStat(Long guaranteeId ,Long bankId) {
		Result<Map<String,Integer>> result=new Result<Map<String,Integer>>();
		try {
			Map<String,Integer> result2=this.fssLoanManager.loanStatusStat(guaranteeId, bankId);
			result.setData(result2);
		} catch (Exception e) {
			logger.error(String.format("按审核状态统计异常:guaranteeId=%s", guaranteeId),e);
			if(e instanceof FssLoanBizException){
				FssLoanBizException be=(FssLoanBizException)e;
				result.setCode(be.getCode());
				result.setMessage(be.getMessage());
			}else{
				result.setCode(ResultCodeContants.failed);
				result.setMessage("系统错误");
			}
		}
		return result;
	}
	

}
