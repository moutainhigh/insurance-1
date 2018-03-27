/**
 * 
 */
package com.yundian.fss.manager.assignrule;

import com.yundian.fssapi.domain.FssLoanModel;

/**
 * 机构分配规则
 * @author cheguo
 *
 */
public interface FssLoanOrganizationAssignRule {
	
	Long assginToOrganization(FssLoanModel fssLoanModel);
}
