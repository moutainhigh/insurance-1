package com.yundian.fss.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yundian.fss.exception.FssLoanBizException;
import com.yundian.fss.manager.FssBankAddedConfMananger;
import com.yundian.fssapi.domain.FssBankAddedConfModel;
import com.yundian.fssapi.service.FssBankAddedConfService;
import com.yundian.result.Result;
import com.yundian.result.ResultCodeContants;

/**
 * 银行相关配置服务实现
 * 
 * @author haibo.he
 * @version $Id: FssBankAddedConfServiceImpl.java, v 0.1 2016年7月26日 下午8:59:44
 *          haibo.he Exp $
 */
@Service("fssBankAddedConfService")
public class FssBankAddedConfServiceImpl implements FssBankAddedConfService {

	@Autowired
	private FssBankAddedConfMananger fssBankAddedConfMananger;

	public Result<Long> insertFssBankAddedConf(
			FssBankAddedConfModel fssBankAddedConfModel) {
		Result<Long> result = new Result<Long>();
		try {
			Long data = this.fssBankAddedConfMananger
					.insertFssBankAddedConf(fssBankAddedConfModel);
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

	public Result<Integer> updateFssBankAddedConf(
			FssBankAddedConfModel fssBankAddedConfModel) {
		Result<Integer> result = new Result<Integer>();

		try {
			Integer data = this.fssBankAddedConfMananger
					.updateFssBankAddedConf(fssBankAddedConfModel);
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

	public Result<Integer> deleteFssBankAddedConfById(Long id) {
		return null;
	}

	public Result<Integer> deleteFssBankAddedConfByBankId(Long bankId) {
		Result<Integer> result = new Result<Integer>();

		try {
			int count= this.fssBankAddedConfMananger
					.deleteFssBankAddedConfByBankId(bankId);
			result.setData(count);
			result.setCode(ResultCodeContants.success);
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
	public Result<FssBankAddedConfModel> getFssBankAddedConfById(Long id) {
		Result<FssBankAddedConfModel> result = new Result<FssBankAddedConfModel>();

		try {
			FssBankAddedConfModel data = this.fssBankAddedConfMananger
					.getFssBankAddedConfById(id);
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

	/* (non-Javadoc)
	 * @see com.yundian.fssapi.service.FssBankAddedConfService#getFssBankAddedConfByBankId(java.lang.Long)
	 */
	@Override
	public Result<FssBankAddedConfModel> getFssBankAddedConfByBankId(Long bankId) {
		Result<FssBankAddedConfModel> result = new Result<FssBankAddedConfModel>();

		try {
			FssBankAddedConfModel data = this.fssBankAddedConfMananger
					.getFssBankAddedConfByBankId(bankId);
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
