package com.yundian.fssapi.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.yundian.fssapi.service.dto.LoanStatisticsDaysSum;

public interface FssStatisticsService {

	/**
	 * 贷款类型分布统计图
	 * @param start
	 * @param end
	 * @param guaranteeId 合作机构id
	 * @param bankId 银行
	 * @return map {"PURCHASE_CAR_TERM":"10","PURCHASE_2CAR_TERM":"30","PURCHASE_MORTGAGECAR_TERM":"50"}
	 */
	Map<String,Integer> getStatisticsForLoanType(Date start,Date end,Long guaranteeId,Integer bankId);
	
	/**
	 * 业务量前后月对比
	 * @param year 2016
	 * @param month 10
	 * @param guaranteeId
	 * @param bankId
	 * @return {1:10010,2:100021,3:200191}
	 */
	 List<LoanStatisticsDaysSum> getStatisticsForBusinessContrast(int year,int month,Long guaranteeId,Integer bankId);

	
	/**
	 * 业务量走势
	 * @param start
	 * @param end
	 * @param guaranteeId 合作机构id
	 * @param bankId 银行
	 * @return {"201601":"21121","201602":""}
	 */
	 List<LoanStatisticsDaysSum> getStatisticsForBusinessTrend(Date start,Date end,Long guaranteeId,Integer bankId);
	
}
