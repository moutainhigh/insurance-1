package com.yundian.fssapi.domain.query;

import java.io.Serializable;
import java.util.Date;

/**
 * 贷款分配记录
 * 
 * @author hehaibo
 *
 */
public class FssLoanDistributeQueryModel implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * 
     */
    private Long id;

    /**
     * 贷款id
     */
    private Long loanId;

    /**
     * 审核机构id
     */
    private Integer organizationId;

    /**
     * 担保公司id
     */
    private Integer guaranteeId;

    /**
     * 
     */
    private Date ctime;

    /**
     * 
     */
    private Date mtime;

    /**
     * 
     */
    private String remark;

    /**
     * 审批机构名称
     */
    private String organizationName;

    /**
     * 担保机构名称
     */
    private String guaranteeName;
    
    /**
     * 获取
     *
     * @cgw 2016-07-22 15:18:23
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置
     *
     * @param id the value for fss_loan_distribute.id
     *
     * @cgw 2016-07-22 15:18:23
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取贷款id
     *
     * @cgw 2016-07-22 15:18:23
     */
    public Long getLoanId() {
        return loanId;
    }

    /**
     * 设置贷款id
     *
     * @param loanId the value for fss_loan_distribute.loan_id
     *
     * @cgw 2016-07-22 15:18:23
     */
    public void setLoanId(Long loanId) {
        this.loanId = loanId;
    }

    /**
     * 获取审核机构id
     *
     * @cgw 2016-07-22 15:18:23
     */
    public Integer getOrganizationId() {
        return organizationId;
    }

    /**
     * 设置审核机构id
     *
     * @param organizationId the value for fss_loan_distribute.organization_id
     *
     * @cgw 2016-07-22 15:18:23
     */
    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }

    /**
     * 获取担保公司id
     *
     * @cgw 2016-07-22 15:18:23
     */
    public Integer getGuaranteeId() {
        return guaranteeId;
    }

    /**
     * 设置担保公司id
     *
     * @param guaranteeId the value for fss_loan_distribute.guarantee_id
     *
     * @cgw 2016-07-22 15:18:23
     */
    public void setGuaranteeId(Integer guaranteeId) {
        this.guaranteeId = guaranteeId;
    }

    /**
     * 获取
     *
     * @cgw 2016-07-22 15:18:23
     */
    public Date getCtime() {
        return ctime;
    }

    /**
     * 设置
     *
     * @param ctime the value for fss_loan_distribute.ctime
     *
     * @cgw 2016-07-22 15:18:23
     */
    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    /**
     * 获取
     *
     * @cgw 2016-07-22 15:18:23
     */
    public Date getMtime() {
        return mtime;
    }

    /**
     * 设置
     *
     * @param mtime the value for fss_loan_distribute.mtime
     *
     * @cgw 2016-07-22 15:18:23
     */
    public void setMtime(Date mtime) {
        this.mtime = mtime;
    }

    /**
     * 获取
     *
     * @cgw 2016-07-22 15:18:23
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置
     *
     * @param remark the value for fss_loan_distribute.remark
     *
     * @cgw 2016-07-22 15:18:23
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public String getGuaranteeName() {
		return guaranteeName;
	}

	public void setGuaranteeName(String guaranteeName) {
		this.guaranteeName = guaranteeName;
	}
    
}