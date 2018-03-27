package com.yundian.fssapi.domain.statistics;

import java.io.Serializable;
import java.util.List;

public class LoanCompareStatModel implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer intervalDays;
	
	private List<String> dateStingList;
	
	private List<Long> thisMonthLoanDataList;
	
	private List<Long> preMonthLoanDataList;

	/**
	 * @return the intervalDays
	 */
	public Integer getIntervalDays() {
		return intervalDays;
	}

	/**
	 * @param intervalDays the intervalDays to set
	 */
	public void setIntervalDays(Integer intervalDays) {
		this.intervalDays = intervalDays;
	}

	/**
	 * @return the thisMonthLoanDataList
	 */
	public List<Long> getThisMonthLoanDataList() {
		return thisMonthLoanDataList;
	}

	/**
	 * @param thisMonthLoanDataList the thisMonthLoanDataList to set
	 */
	public void setThisMonthLoanDataList(List<Long> thisMonthLoanDataList) {
		this.thisMonthLoanDataList = thisMonthLoanDataList;
	}

	/**
	 * @return the preMonthLoanDataList
	 */
	public List<Long> getPreMonthLoanDataList() {
		return preMonthLoanDataList;
	}

	/**
	 * @param preMonthLoanDataList the preMonthLoanDataList to set
	 */
	public void setPreMonthLoanDataList(List<Long> preMonthLoanDataList) {
		this.preMonthLoanDataList = preMonthLoanDataList;
	}

	/**
	 * @return the dateStingList
	 */
	public List<String> getDateStingList() {
		return dateStingList;
	}

	/**
	 * @param dateStingList the dateStingList to set
	 */
	public void setDateStingList(List<String> dateStingList) {
		this.dateStingList = dateStingList;
	}
	
	
}
