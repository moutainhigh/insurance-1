package com.yundian.result;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * PaginatedResult 分页结果
 * @author hehaibo
 *
 */
public class PaginatedResult<T> implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 记录数
     */
    private int               total;
    /**
     * 返回的记录结果
     */
    private List<T>           rows             = new ArrayList<T>();

    
    /**
     * 默认构造函数
     */
    public PaginatedResult(){
    }
    /**
     * 
     * @param rowsParam 记录集合
     * @param totalParam 行总数
     */
    public PaginatedResult(List<T> rowsParam,int totalParam){
    	this.rows=rowsParam;
    	this.total=totalParam;
    }
    /**
     * @return the count
     */
    public int getTotal() {
        return total;
    }

    /**
     * @param count the count to set
     */
    public void setTotal(int count) {
        this.total = count;
    }

    /**
     * @return the data
     */
    public List<T> getRows() {
        return rows;
    }

    /**
     * @param data the data to set
     */
    public void setRows(List<T> data) {
        this.rows = data;
    }
    
}
