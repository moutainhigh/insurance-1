package com.yundian.fssapi.domain.vo;

import com.yundian.fssapi.domain.FssLoanDocumentModel;
import com.yundian.fssapi.domain.FssLoanModel;
import com.yundian.fssapi.domain.statistics.LoanInfoModel;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 分期数据VO
 *
 * @author jnx
 * @create 2018/4/24
 */
public class LoanInfoVo implements Serializable{
    private Long loanId;

    /**
     * 保险分期对象
     */
    private FssLoanModel fssLoanModel;

    /**
     * doc文件集合，Key:为文档类型
     */
    private Map<String,List<LoanDocumentVo>> fssLoanDocs;


    public Long getLoanId() {
        return this.loanId;
    }

    public void setLoanId(Long loanId) {
        this.loanId = loanId;
    }

    public FssLoanModel getFssLoanModel() {
        return this.fssLoanModel;
    }

    public void setFssLoanModel(FssLoanModel fssLoanModel) {
        this.fssLoanModel = fssLoanModel;
    }

    public Map<String, List<LoanDocumentVo>> getFssLoanDocs() {
        return this.fssLoanDocs;
    }

    public void setFssLoanDocs(Map<String, List<LoanDocumentVo>> fssLoanDocs) {
        this.fssLoanDocs = fssLoanDocs;
    }
}
