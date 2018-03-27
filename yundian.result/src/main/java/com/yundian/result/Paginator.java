package com.yundian.result;

import java.io.Serializable;

/**
 * 
 * @author hehaibo
 *
 * @param <P>
 */
public class Paginator<P> implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static Integer DEFAULT_LIMTI = 15;
	/**
	 * 当前页
	 */
	private Integer currentPage;
	/**
	 * 分页大小
	 */
	private Integer pageSize  ;
	
	
	private P param;

	public Paginator(){
	}
	/**
	 * @param limit
	 * @param offset
	 * @param paramMap
	 */
	public Paginator(Integer _currentPage, Integer _pageSize) {
		this.currentPage = _currentPage;
		this.pageSize=_pageSize;
	}

	
	/**
	 * @param limit
	 * @param offset
	 * @param paramMap
	 */
	public Paginator(Integer _currentPage, Integer _pageSize,P param) {
		this(_currentPage,_pageSize);
		this.param=param;
	}
	
	public P getParam() {
		return param;
	}

	public void setParam(P param) {
		this.param = param;
	}
	
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	

}
