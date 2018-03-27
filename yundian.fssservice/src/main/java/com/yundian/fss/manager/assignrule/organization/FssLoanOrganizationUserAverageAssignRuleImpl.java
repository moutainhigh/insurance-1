package com.yundian.fss.manager.assignrule.organization;

import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.yundian.fss.dao.FssLoanModelMapper;
import com.yundian.fss.dao.vo.StatisticsGenericResult;
import com.yundian.fss.exception.FssLoanBizException;
import com.yundian.fss.manager.FssOrganizationUserManager;
import com.yundian.fss.manager.assignrule.FssLoanOrganizationUserAssignRule;
import com.yundian.fssapi.domain.FssLoanModel;
import com.yundian.fssapi.domain.FssOrganizationUserModel;
import com.yundian.result.ResultCodeContants;

/**
 * 
 * @author hehaibo
 *
 */
@Service("fssLoanOrganizationUserAverageAssignRule")
public class FssLoanOrganizationUserAverageAssignRuleImpl implements FssLoanOrganizationUserAssignRule{

	@Autowired
	private FssLoanModelMapper fssLoanModelMapper;
	@Autowired
	
	private FssOrganizationUserManager fssOrganizationUserManager;
	@Override
	public Long assignToOrganizationUser(FssLoanModel fssLoanModel) {
		Long orguserId= this.getLoanCountMinOrguserIdByOrgId(fssLoanModel.getOrganizationId());
		fssLoanModel.setOrguserId(orguserId);
		FssOrganizationUserModel fssOrganizationUserModel=
				fssOrganizationUserManager.getFssOrganizationUserById(orguserId);
		fssLoanModel.setOrguserName(fssOrganizationUserModel.getName());
		return orguserId;
	}
	
	private Long getLoanCountMinOrguserIdByOrgId(Long organizationId) {
		List<StatisticsGenericResult> statisticsGenericResults =fssLoanModelMapper.getFssLoanStatisticsOrgUserIdByOrganizationId(organizationId);
		if(CollectionUtils.isEmpty(statisticsGenericResults)){
			throw new FssLoanBizException(ResultCodeContants.failed, "机构用户设置异常,无法分配到机构用户");
		}
		Map<Long, Long> map = statisticsGenericResults.stream().collect(
				Collectors.toMap(StatisticsGenericResult::getKey,
						StatisticsGenericResult::getValue));
		return this.getMinValueByValueFromMap(map);
	}
	/*private Long getLoanCountMinOrganizationId() {
		List<StatisticsGenericResult> statisticsGenericResults = this.fssLoanModelMapper
				.getFssLoanStatisticsByOrganization();
		Map<Long, Long> map = statisticsGenericResults.stream().collect(
				Collectors.toMap(StatisticsGenericResult::getKey,
						StatisticsGenericResult::getValue));
		return this.getMinValueByValueFromMap(map);
	}*/

	private Long getMinValueByValueFromMap(Map<Long, Long> map) {

		LongSummaryStatistics longSummaryStatistics = map.values().stream()
				.mapToLong((x) -> x).summaryStatistics();
		return map
				.entrySet()
				.stream()
				.filter(entry -> Objects.equals(entry.getValue(),
						longSummaryStatistics.getMin())).map(Map.Entry::getKey)
				.collect(Collectors.toList()).get(0);

	}
}
