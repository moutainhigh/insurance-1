package com.yundian.fss.manager.assignrule;

import com.yundian.fssapi.domain.FssLoanModel;

/**
 * 
 * @author cheguo
 *
 */
public interface FssLoanBankAssignRule {
	/**
	 * 分配到银行
	 * @param fssLoanModel
	 * @return
	 */
	Long assginToBank(FssLoanModel fssLoanModel);
}
