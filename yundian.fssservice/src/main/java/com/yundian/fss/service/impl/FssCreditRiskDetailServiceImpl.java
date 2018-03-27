package com.yundian.fss.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yundian.fss.exception.FssLoanBizException;
import com.yundian.fss.manager.FssCreditRiskDetailMananger;
import com.yundian.fssapi.domain.FssCreditRiskDetailModel;
import com.yundian.fssapi.service.FssCreditRiskDetailService;
import com.yundian.result.Result;
import com.yundian.result.ResultCodeContants;

/**
 * 征信风险详情服务实现
 * 
 * @author haibo.he
 * @version $Id: FssCreditRiskDetailServiceImpl.java, v 0.1 2016年7月26日 下午8:59:44
 *          haibo.he Exp $
 */
@Service("fssCreditRiskDetailService")
public class FssCreditRiskDetailServiceImpl implements
		FssCreditRiskDetailService {

	@Autowired
	private FssCreditRiskDetailMananger fssCreditRiskDetailMananger;

	public Result<Long> insertFssCreditRiskDetail(
			FssCreditRiskDetailModel fssCreditRiskDetailModel) {
		Result<Long> result = new Result<Long>();
		try {
			Long data = this.fssCreditRiskDetailMananger
					.insertFssCreditRiskDetail(fssCreditRiskDetailModel);
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

	public Result<Integer> updateFssCreditRiskDetail(
			FssCreditRiskDetailModel fssCreditRiskDetailModel) {
		Result<Integer> result = new Result<Integer>();

		try {
			Integer data = this.fssCreditRiskDetailMananger
					.updateFssCreditRiskDetail(fssCreditRiskDetailModel);
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

	public Result<Integer> deleteFssCreditRiskDetailById(Long id) {
		return null;
	}

	public Result<FssCreditRiskDetailModel> getFssCreditRiskDetailById(Long id) {
		Result<FssCreditRiskDetailModel> result = new Result<FssCreditRiskDetailModel>();

		try {
			FssCreditRiskDetailModel data = this.fssCreditRiskDetailMananger
					.getFssCreditRiskDetailById(id);
			result.setData(data);
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

	public Result<List<FssCreditRiskDetailModel>> getFssCreditRiskDetailByRiskId(
			Long riskId) {
		Result<List<FssCreditRiskDetailModel>> result = new Result<List<FssCreditRiskDetailModel>>();

		try {
			List<FssCreditRiskDetailModel> data = this.fssCreditRiskDetailMananger
					.getFssCreditRiskDetailByRiskId(riskId);
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
