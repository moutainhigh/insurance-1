package com.yundian.fssapi.domain.statistics;

import java.io.Serializable;
import java.util.List;

public class LoanTypeMonthTrendStatModel implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<LoanTypeMonthTrendSeriesModel> series;
	
	private List<String> intervalDateList;
	
	private Integer intervalDays;
	/**
	 * @return the series
	 */
	public List<LoanTypeMonthTrendSeriesModel> getSeries() {
		return series;
	}
	/**
	 * @param series the series to set
	 */
	public void setSeries(List<LoanTypeMonthTrendSeriesModel> series) {
		this.series = series;
	}
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
	 * @return the intervalDateList
	 */
	public List<String> getIntervalDateList() {
		return intervalDateList;
	}
	/**
	 * @param intervalDateList the intervalDateList to set
	 */
	public void setIntervalDateList(List<String> intervalDateList) {
		this.intervalDateList = intervalDateList;
	}

	
}
