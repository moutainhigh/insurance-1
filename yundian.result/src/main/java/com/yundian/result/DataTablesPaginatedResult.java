package com.yundian.result;

import java.io.Serializable;
import java.util.List;

/**
 * DataTablesPaginatedResult 分页结果
 * @author hehaibo
 *
 */
public class DataTablesPaginatedResult<V> implements Serializable {

    private static final long serialVersionUID = 1L;
    private int  draw;
    private int  recordsTotal;
    private int  recordsFiltered;
    private List<V> data;
    /**
     * 错误消息
     */
    private String errorMsg;
    /**
     * 错误编码
     */
    private String errorCode;
    
    private String timeout="no";
    
	public int getDraw() {
		return draw;
	}
	public void setDraw(int draw) {
		this.draw = draw;
	}
	public int getRecordsTotal() {
		return recordsTotal;
	}
	public void setRecordsTotal(int recordsTotal) {
		this.recordsTotal = recordsTotal;
	}
	public int getRecordsFiltered() {
		return recordsFiltered;
	}
	public void setRecordsFiltered(int recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}
	public List<V> getData() {
		return data;
	}
	public void setData(List<V> data) {
		this.data = data;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	/**
	 * Getter method for property <tt>errorCode</tt>.
	 * 
	 * @return property value of errorCode
	 */
	public String getErrorCode() {
		return errorCode;
	}
	/**
	 * Setter method for property <tt>errorCode</tt>.
	 * 
	 * @param errorCode value to be assigned to property errorCode
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getTimeout() {
		return timeout;
	}
	public void setTimeout(String timeout) {
		this.timeout = timeout;
	}
	
}
