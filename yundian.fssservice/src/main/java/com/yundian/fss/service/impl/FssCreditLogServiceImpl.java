package com.yundian.fss.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yundian.fss.exception.FssLoanBizException;
import com.yundian.fss.manager.FssCreditLogMananger;
import com.yundian.fssapi.domain.FssCreditLogModel;
import com.yundian.fssapi.service.FssCreditLogService;
import com.yundian.result.Result;
import com.yundian.result.ResultCodeContants;

/**
 * 征信日志表服务实现
 * 
 * @author haibo.he
 * @version $Id: FssCreditLogServiceImpl.java, v 0.1 2016年7月26日 下午8:59:44
 *          haibo.he Exp $
 */
@Service("fssCreditLogService")
public class FssCreditLogServiceImpl implements FssCreditLogService {

	@Autowired
	private FssCreditLogMananger fssCreditLogMananger;

	public Result<Long> insertFssCreditLog(FssCreditLogModel fssCreditLogModel) {
		Result<Long> result = new Result<Long>();
		try {
			Long data = this.fssCreditLogMananger
					.insertFssCreditLog(fssCreditLogModel);
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

	public Result<Integer> deleteFssCreditLogById(Long id) {
		return null;
	}

	public Result<FssCreditLogModel> getFssCreditLogById(Long id) {
		Result<FssCreditLogModel> result = new Result<FssCreditLogModel>();

		try {
			FssCreditLogModel data = this.fssCreditLogMananger
					.getFssCreditLogById(id);
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

	public Result<List<FssCreditLogModel>> getFssCreditLogListByCreditId(
			Long creditId) {
		Result<List<FssCreditLogModel>> result = new Result<List<FssCreditLogModel>>();

		try {
			List<FssCreditLogModel> data = this.fssCreditLogMananger
					.getFssCreditLogListByCreditId(creditId);
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

}
