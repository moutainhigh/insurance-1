package com.yundian.fss.service.impl;

import java.util.Date;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.yundian.fss.exception.FssLoanBizException;
import com.yundian.fss.manager.FssBankAddedConfMananger;
import com.yundian.fss.manager.FssCreditLogMananger;
import com.yundian.fss.manager.FssCreditMananger;
import com.yundian.fssapi.domain.FssBankAddedConfModel;
import com.yundian.fssapi.domain.FssCreditLogModel;
import com.yundian.fssapi.domain.FssCreditModel;
import com.yundian.fssapi.dto.param.FssCreditQueryParam;
import com.yundian.fssapi.enums.FssCreditAuditStatusEnum;
import com.yundian.fssapi.service.FssCreditService;
import com.yundian.fssapi.service.FssTundunRiskService;
import com.yundian.result.PaginatedResult;
import com.yundian.result.Paginator;
import com.yundian.result.Result;
import com.yundian.result.ResultCodeContants;

/**
 * 征信查询表服务实现
 * 
 * @author haibo.he
 * @version $Id: FssCreditServiceImpl.java, v 0.1 2016年7月26日 下午8:59:44 haibo.he
 *          Exp $
 */
@Service("fssCreditService")
public class FssCreditServiceImpl implements FssCreditService {

	Logger logger = Logger.getLogger(FssCreditServiceImpl.class);
	@Autowired
	private FssCreditMananger fssCreditMananger;
	@Autowired
	private FssCreditLogMananger fssCreditLogMananger;
	@Autowired
	private FssBankAddedConfMananger fssBankAddedConfMananger;
	@Autowired
	private FssTundunRiskService fssTundunRiskService;
	
	@Override
	public Result<Long> insertFssCreditAndCreditSearching(FssCreditModel fssCreditModel) {
		Result<Long> result = new Result<Long>();
		if(fssCreditModel!=null&&fssCreditModel.getBankId()>0)
		{
			FssBankAddedConfModel  fssBankConfModel = fssBankAddedConfMananger.getFssBankAddedConfByBankId(fssCreditModel.getBankId());
			if(fssBankConfModel!=null&&fssBankConfModel.getHaveCreditCollect().equals("Y"))
			{
				Result<String>  tongdunResult = fssTundunRiskService.apply(fssCreditModel.getName(), fssCreditModel.getIdcard(), 
						StringUtils.isEmpty(fssCreditModel.getPhone())?"N/A":fssCreditModel.getPhone());
				if(tongdunResult.getCode()==ResultCodeContants.success)
					fssCreditModel.setRemark(tongdunResult.getData());
				else
				{
					logger.info("提交征信申请时，外部征信调用失败!"+tongdunResult.getMessage());
				}
			}
		}
		
		try {
			Long data = this.fssCreditMananger.insertFssCredit(fssCreditModel);
			result.setData(data);
		} catch (Exception e) {
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
	public Result<String> submitAuditFssCredit(FssCreditModel fssCreditModel,Long bankUserId,String bankUserName) {
		Result<String> result = new Result<String>();

		try {
			
			fssCreditModel.setCreditReportTime(new Date());
			  this.fssCreditMananger
					.updateFssCreditSelective(fssCreditModel);
			  FssCreditLogModel fssCreditLogModel = new FssCreditLogModel();
			  FssCreditModel tempFssCreditModel = this.fssCreditMananger.getFssCreditAndCreditLogById(fssCreditModel.getCreditId());
			  fssCreditLogModel.setBankId(tempFssCreditModel.getBankId());
			  fssCreditLogModel.setBankName(tempFssCreditModel.getBankName());
			  fssCreditLogModel.setBankUserId(bankUserId);
			  fssCreditLogModel.setBankUserName(bankUserName);
			  fssCreditLogModel.setMtime(new Date());
			  fssCreditLogModel.setAuditStatus(fssCreditModel.getCreditStatus());
			  fssCreditLogModel.setAuditTime(new Date());
			  fssCreditLogModel.setAuditContent(fssCreditModel.getCreditReportRemark());
			  fssCreditLogModel.setCreditId(fssCreditModel.getCreditId());
			  fssCreditLogModel.setNode(fssCreditModel.getCreditStatus());
			  try{
				  FssCreditAuditStatusEnum fssCreditAuditStatusEnum=FssCreditAuditStatusEnum.getInstance(fssCreditModel.getCreditStatus());
				  fssCreditLogModel.setNodeName(fssCreditAuditStatusEnum.desc());
			  }catch(Exception e){   
				  logger.error("无相关枚举项");
				  result.setCode(ResultCodeContants.failed);
				  result.setMessage("征信状态错误，无相关枚举项");
				  return result;
			  }  
			  
			  fssCreditLogMananger.insertFssCreditLog(fssCreditLogModel);
			result.setData("");
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
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
	public Result<Long> insertFssCredit(FssCreditModel fssCreditModel) {
		Result<Long> result = new Result<Long>();
		try {
			Long data = this.fssCreditMananger.insertFssCredit(fssCreditModel);
			result.setData(data);
		} catch (Exception e) {
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
	public Result<Integer> updateFssCredit(FssCreditModel fssCreditModel) {
		Result<Integer> result = new Result<Integer>();

		try {
			Integer data = this.fssCreditMananger
					.updateFssCredit(fssCreditModel);
			result.setData(data);
		} catch (Exception e) {
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
	public Result<Integer> deleteFssCreditByCreditId(Long creditId) {
		return null;
	}
	@Override
	public Result<FssCreditModel> getFssCreditAndCreditLogById(Long id) {
		Result<FssCreditModel> result = new Result<FssCreditModel>();

		try {
			FssCreditModel data = this.fssCreditMananger.getFssCreditAndCreditLogById(id);
			result.setData(data);
		} catch (Exception e) {
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
	public Result<PaginatedResult<FssCreditModel>> getPaginatorFssCredit(
			Paginator<FssCreditQueryParam> paginator) {
		Result<PaginatedResult<FssCreditModel>> result = new Result<PaginatedResult<FssCreditModel>>();
		try {
			PaginatedResult<FssCreditModel> data = this.fssCreditMananger
					.getPaginatorFssCredit(paginator);
			result.setData(data);
		} catch (Exception e) {
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
	public Result<Map<String,Integer>> getCreditStatusStat(Long guaranteeId,Long bankId)
	{
		Result<Map<String,Integer>> result = new Result<Map<String,Integer>>();
		try {
			Map<String,Integer> creditStatusMap= this.fssCreditMananger.getCreditStatusStat(guaranteeId, bankId);
			result.setData(creditStatusMap);
		} catch (Exception e) {
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
