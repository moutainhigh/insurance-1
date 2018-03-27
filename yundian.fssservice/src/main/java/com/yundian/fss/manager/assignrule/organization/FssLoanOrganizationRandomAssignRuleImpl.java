package com.yundian.fss.manager.assignrule.organization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yundian.fss.exception.FssLoanBizException;
import com.yundian.fss.manager.FssOrganizationManager;
import com.yundian.fss.manager.assignrule.FssLoanOrganizationAssignRule;
import com.yundian.fssapi.domain.FssLoanModel;
import com.yundian.fssapi.domain.FssOrganizationModel;
import com.yundian.result.ResultCodeContants;

/**
 * 随机分配到机构规则
 * 
 * @author hehaibo
 *
 */
@Service("fssLoanOrganizationRandomAssignRule")
public class FssLoanOrganizationRandomAssignRuleImpl implements
		FssLoanOrganizationAssignRule {

	@Autowired
	private FssOrganizationManager fssOrganizationManager;

	@Override
	public Long assginToOrganization(FssLoanModel fssLoanModel) {
		FssOrganizationModel fssOrganizationModel = this.fssOrganizationManager
				.listAllOrganization().stream().findAny().orElseGet(null);
		if (fssOrganizationModel == null) {
			throw new FssLoanBizException(ResultCodeContants.failed,
					"分配到机构失败，没有找到相关机构");
		}
		fssLoanModel
				.setOrganizationId(fssOrganizationModel.getOrganizationId());
		return fssOrganizationModel.getOrganizationId();
	}

}
