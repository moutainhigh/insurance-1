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

    private int currentIndex;
    private int nextIndex;
    private int pageSize;
    private int preIndex;
    private int totalNumber;
    private int totalPage;

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

    public int getCurrentIndex() {
        return this.currentIndex;
    }

    public void setCurrentIndex(int currentIndex) {
        this.currentIndex = currentIndex;
    }

    public int getNextIndex() {
        return this.nextIndex;
    }

    public void setNextIndex(int nextIndex) {
        this.nextIndex = nextIndex;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPreIndex() {
        return this.preIndex;
    }

    public void setPreIndex(int preIndex) {
        this.preIndex = preIndex;
    }

    public int getTotalNumber() {
        return this.totalNumber;
    }

    public void setTotalNumber(int totalNumber) {
        this.totalNumber = totalNumber;
    }

    public int getTotalPage() {
        return this.totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }
}
