package com.yundian.fssapi.domain.vo;

import java.io.Serializable;

/**
 * 文档VO
 *
 * @author jnx
 * @create 2018/4/24
 */
public class LoanDocumentVo implements Serializable{

    private String uid;
    private String name;
    private String url;
    private String documentType;
    private Long loanId;

    public String getUid() {
        return this.uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDocumentType() {
        return this.documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public Long getLoanId() {
        return this.loanId;
    }

    public void setLoanId(Long loanId) {
        this.loanId = loanId;
    }
}
