package com.yundian.fss.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.yundian.fss.exception.FssLoanBizException;
import com.yundian.fss.manager.FssSysAreaManager;
import com.yundian.fssapi.domain.FssSysAreaModel;
import com.yundian.fssapi.service.FssSysAreaService;
import com.yundian.result.PaginatedResult;
import com.yundian.result.Paginator;
import com.yundian.result.Result;
import com.yundian.result.ResultCodeContants;
import org.springframework.stereotype.Service;

/**
 * 系统地区服务实现
 * 
 * @author hehaibo
 * @version $Id: FssSysAreaServiceImpl.java, v 0.1 2016年7月26日 下午8:59:44 hehaibo Exp $
 */
@Service("fssSysAreaService")
public class FssSysAreaServiceImpl implements FssSysAreaService{
	private static final Logger logger=LoggerFactory.getLogger(FssSysAreaServiceImpl.class);

	@Autowired
	private FssSysAreaManager fssSysAreaManager;

	@Override
	public Result<Integer> insertFssSysArea (FssSysAreaModel fssSysAreaModel){

		Result<Integer> result = new Result<Integer>();
		try {
			Integer row= this.fssSysAreaManager.insertFssSysArea(fssSysAreaModel);
			result.setData(row);
			result.setCode(ResultCodeContants.SUCCESS);
		} catch (Exception e) {
			logger.error(String.format("添加系统地区异常:%s",
					ToStringBuilder.reflectionToString(fssSysAreaModel)),e);
			if(e instanceof FssLoanBizException){
				FssLoanBizException be=(FssLoanBizException)e;
				result.setCode(be.getCode());
				result.setMsg(be.getErrorMsg());
			}
			else{
				result.setCode(ResultCodeContants.FAILED);
				result.setMsg("系统异常");
			}
		}
		return result;
	}
	@Override
	public Result<Integer> updateFssSysArea(FssSysAreaModel fssSysAreaModel){
		Result<Integer> result = new Result<Integer>();
		try {
			Integer row= this.fssSysAreaManager.updateFssSysArea(fssSysAreaModel);
			result.setData(row);
			result.setCode(ResultCodeContants.SUCCESS);
		} catch (Exception e) {
			logger.error(String.format("修改系统地区异常:%s",
					ToStringBuilder.reflectionToString(fssSysAreaModel)),e);
			if(e instanceof FssLoanBizException){
				FssLoanBizException be=(FssLoanBizException)e;
				result.setCode(be.getCode());
				result.setMsg(be.getErrorMsg());
			}
			else{
				result.setCode(ResultCodeContants.FAILED);
				result.setMsg("系统异常");
			}
		}
		return result;
	}

	@Override
	public Result<Integer> deleteFssSysAreaById ( Long id )
	{
		Result<Integer> result = new Result<Integer>();
		try {
			Integer row= this.fssSysAreaManager.deleteFssSysAreaById(id);
			result.setData(row);
			result.setCode(ResultCodeContants.SUCCESS);
		} catch (Exception e) {
			logger.error(String.format("删除系统地区异常:%d",id),e);
			if(e instanceof FssLoanBizException){
				FssLoanBizException be=(FssLoanBizException)e;
				result.setCode(be.getCode());
				result.setMsg(be.getErrorMsg());
			}
			else{
				result.setCode(ResultCodeContants.FAILED);
				result.setMsg("系统异常");
			}
		}
		return result;
	}
	@Override
	public Result<FssSysAreaModel> getFssSysAreaById(Long id){
		Result<FssSysAreaModel> result = new Result<FssSysAreaModel>();
		try {
			FssSysAreaModel row= this.fssSysAreaManager.getFssSysAreaById(id);
			result.setData(row);
			result.setCode(ResultCodeContants.SUCCESS);
		} catch (Exception e) {
			logger.error(String.format("查询单个系统地区异常:%d",id),e);
			if(e instanceof FssLoanBizException){
				FssLoanBizException be=(FssLoanBizException)e;
				result.setCode(be.getCode());
				result.setMsg(be.getErrorMsg());
			}
			else{
				result.setCode(ResultCodeContants.FAILED);
				result.setMsg("系统异常");
			}
		}
		return result;
	}
@Override
	public Result<List<FssSysAreaModel>> getFssSysAreaList(FssSysAreaModel fssSysAreaModel){
		Result<List<FssSysAreaModel>> result = new Result<List<FssSysAreaModel>>();
		try {
			List<FssSysAreaModel> row= this.fssSysAreaManager
					.getFssSysAreaList(fssSysAreaModel);
			result.setData(row);
			result.setCode(ResultCodeContants.SUCCESS);
		} catch (Exception e) {
			logger.error(String.format("查询列表系统地区异常:%s",
					ToStringBuilder.reflectionToString(fssSysAreaModel)),e);
			if(e instanceof FssLoanBizException){
				FssLoanBizException be=(FssLoanBizException)e;
				result.setCode(be.getCode());
				result.setMsg(be.getErrorMsg());
			}
			else{
				result.setCode(ResultCodeContants.FAILED);
				result.setMsg("系统异常");
			}
		}
		return result;
	}

}
