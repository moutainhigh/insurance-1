package com.yundian.fss.manager.assignrule.bank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yundian.fss.exception.FssLoanBizException;
import com.yundian.fss.manager.FssBankManager;
import com.yundian.fss.manager.assignrule.FssLoanBankAssignRule;
import com.yundian.fssapi.domain.FssBankModel;
import com.yundian.fssapi.domain.FssLoanModel;
import com.yundian.result.ResultCodeContants;

@Service("fssLoanBankOneBankAssignRule")
public class FssLoanBankOneBankAssignRuleImpl implements FssLoanBankAssignRule{
	@Autowired
	private FssBankManager fssBankManager;
	@Override
	public Long assginToBank(FssLoanModel fssLoanModel) {
		FssBankModel fssBankModel =fssBankManager.getFssBankFirst();
		if(fssBankModel==null){
			throw new FssLoanBizException(ResultCodeContants.failed, "分配失败，未能找到银行");
		}
		fssLoanModel.setBankId(fssBankModel.getBankId());
		return fssBankModel.getBankId();
	}

}
