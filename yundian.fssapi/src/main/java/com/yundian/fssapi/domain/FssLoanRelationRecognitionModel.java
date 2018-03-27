package com.yundian.fssapi.domain;

import java.io.Serializable;
import java.util.Date;
/**
 * 人脸识别结果
 * @author cheguo
 *
 */
public class FssLoanRelationRecognitionModel implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
     * 
     */
    private Long id;

    /**
     * 关系人id
     */
    private Long relationId;

    /**
     * 对比相似度
     */
    private Integer similarity;

    /**
     * 对比结论
     */
    private String result;

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
     * 获取
     *
     * @cgw 2016-07-26 11:23:26
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置
     *
     * @param id the value for fss_loan_relation_recognition.id
     *
     * @cgw 2016-07-26 11:23:26
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取关系人id
     *
     * @cgw 2016-07-26 11:23:26
     */
    public Long getRelationId() {
        return relationId;
    }

    /**
     * 设置关系人id
     *
     * @param relationId the value for fss_loan_relation_recognition.relation_id
     *
     * @cgw 2016-07-26 11:23:26
     */
    public void setRelationId(Long relationId) {
        this.relationId = relationId;
    }

    /**
     * 获取对比相似度
     *
     * @cgw 2016-07-26 11:23:26
     */
    public Integer getSimilarity() {
        return similarity;
    }

    /**
     * 设置对比相似度
     *
     * @param similarity the value for fss_loan_relation_recognition.similarity
     *
     * @cgw 2016-07-26 11:23:26
     */
    public void setSimilarity(Integer similarity) {
        this.similarity = similarity;
    }

    /**
     * 获取对比结论
     *
     * @cgw 2016-07-26 11:23:26
     */
    public String getResult() {
        return result;
    }

    /**
     * 设置对比结论
     *
     * @param result the value for fss_loan_relation_recognition.result
     *
     * @cgw 2016-07-26 11:23:26
     */
    public void setResult(String result) {
        this.result = result == null ? null : result.trim();
    }

    /**
     * 获取
     *
     * @cgw 2016-07-26 11:23:26
     */
    public Date getCtime() {
        return ctime;
    }

    /**
     * 设置
     *
     * @param ctime the value for fss_loan_relation_recognition.ctime
     *
     * @cgw 2016-07-26 11:23:26
     */
    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    /**
     * 获取
     *
     * @cgw 2016-07-26 11:23:26
     */
    public Date getMtime() {
        return mtime;
    }

    /**
     * 设置
     *
     * @param mtime the value for fss_loan_relation_recognition.mtime
     *
     * @cgw 2016-07-26 11:23:26
     */
    public void setMtime(Date mtime) {
        this.mtime = mtime;
    }

    /**
     * 获取
     *
     * @cgw 2016-07-26 11:23:26
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置
     *
     * @param remark the value for fss_loan_relation_recognition.remark
     *
     * @cgw 2016-07-26 11:23:26
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FssLoanRelationRecognitionModel [id=" + id + ", relationId="
				+ relationId + ", similarity=" + similarity + ", result="
				+ result + ", ctime=" + ctime + ", mtime=" + mtime
				+ ", remark=" + remark + "]";
	}
    
    
}