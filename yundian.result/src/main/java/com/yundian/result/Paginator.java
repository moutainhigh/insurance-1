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
	private Integer page;
	/**
	 * 分页大小
	 */
	private Integer pageSize  ;
	
	
	private P param;

	public Paginator(){
	}
	/**
	 * @param _currentPage
	 * @param _pageSize
	 */
	public Paginator(Integer _currentPage, Integer _pageSize) {
		this.page = _currentPage;
		this.pageSize=_pageSize;
	}

	
	/**
	 * @param _currentPage
	 * @param _pageSize
	 * @param param
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

	public Integer getPage() {
		return this.page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	

}
