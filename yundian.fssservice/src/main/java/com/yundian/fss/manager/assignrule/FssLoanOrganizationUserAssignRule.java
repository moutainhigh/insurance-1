package com.yundian.fss.manager.assignrule;

import com.yundian.fssapi.domain.FssLoanModel;

/**
 * 分配到机构用户
 * 
 * @author hehaibo
 *
 */
public interface FssLoanOrganizationUserAssignRule {

	/**
	 * 分配到机构用户
	 * @param fssLoanModel
	 * @return
	 */
	Long assignToOrganizationUser(FssLoanModel fssLoanModel);
}
