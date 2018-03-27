package com.yundian.fss.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.yundian.fssapi.service.FssStatisticsService;
import com.yundian.fssapi.service.dto.LoanStatisticsDaysSum;
@Service
public class FssStatisticsServiceImpl implements FssStatisticsService {

	
	@Override
	public Map<String, Integer> getStatisticsForLoanType(Date start, Date end,
			Long guaranteeId, Integer bankId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LoanStatisticsDaysSum> getStatisticsForBusinessContrast(
			int year, int month, Long guaranteeId, Integer bankId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LoanStatisticsDaysSum> getStatisticsForBusinessTrend(
			Date start, Date end, Long guaranteeId, Integer bankId) {
		// TODO Auto-generated method stub
		return null;
	}

}
