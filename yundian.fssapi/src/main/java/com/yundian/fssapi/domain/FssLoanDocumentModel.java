package com.yundian.fssapi.domain;

import java.io.Serializable;
import java.util.Date;

public class FssLoanDocumentModel implements Serializable {
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
     * 关系人id
     */
    private Long relationId;

    /**
     * 分类：身份证正面、身份证反面、征信授权书、人脸识别照片、面签照片、面签视频
     */
    private String documentType;

    /**
     * 文档显示名称
     */
    private String fileName;

    /**
     * 文件类型：1图片，2视频，3其他文档
     */
    private String fileType;

    /**
     * 文件地址
     */
    private String fileUrl;

    /**
     * 文件大小，单位KB
     */
    private Float fileSize;

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
     * @cgw 2016-07-22 15:18:23
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置
     *
     * @param id the value for fss_loan_document.id
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
     * @param loanId the value for fss_loan_document.loan_id
     *
     * @cgw 2016-07-22 15:18:23
     */
    public void setLoanId(Long loanId) {
        this.loanId = loanId;
    }

    /**
     * 获取关系人id
     *
     * @cgw 2016-07-22 15:18:23
     */
    public Long getRelationId() {
        return relationId;
    }

    /**
     * 设置关系人id
     *
     * @param relationId the value for fss_loan_document.relation_id
     *
     * @cgw 2016-07-22 15:18:23
     */
    public void setRelationId(Long relationId) {
        this.relationId = relationId;
    }

    /**
     * 获取分类：身份证正面、身份证反面、征信授权书、人脸识别照片、面签照片、面签视频
     *
     * @cgw 2016-07-22 15:18:23
     */
    public String getDocumentType() {
        return documentType;
    }

    /**
     * 设置分类：身份证正面、身份证反面、征信授权书、人脸识别照片、面签照片、面签视频
     *
     * @param documentType the value for fss_loan_document.document_type
     *
     * @cgw 2016-07-22 15:18:23
     */
    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    /**
     * 获取文档显示名称
     *
     * @cgw 2016-07-22 15:18:23
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * 设置文档显示名称
     *
     * @param fileName the value for fss_loan_document.file_name
     *
     * @cgw 2016-07-22 15:18:23
     */
    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
    }

    /**
     * 获取文件类型：1图片，2视频，3其他文档
     *
     * @cgw 2016-07-22 15:18:23
     */
    public String getFileType() {
        return fileType;
    }

    /**
     * 设置文件类型：1图片，2视频，3其他文档
     *
     * @param fileType the value for fss_loan_document.file_type
     *
     * @cgw 2016-07-22 15:18:23
     */
    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    /**
     * 获取文件地址
     *
     * @cgw 2016-07-22 15:18:23
     */
    public String getFileUrl() {
        return fileUrl;
    }

    /**
     * 设置文件地址
     *
     * @param fileUrl the value for fss_loan_document.file_url
     *
     * @cgw 2016-07-22 15:18:23
     */
    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl == null ? null : fileUrl.trim();
    }

    /**
     * 获取文件大小，单位KB
     *
     * @cgw 2016-07-22 15:18:23
     */
    public Float getFileSize() {
        return fileSize;
    }

    /**
     * 设置文件大小，单位KB
     *
     * @param fileSize the value for fss_loan_document.file_size
     *
     * @cgw 2016-07-22 15:18:23
     */
    public void setFileSize(Float fileSize) {
        this.fileSize = fileSize;
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
     * @param ctme the value for fss_loan_document.ctme
     *
     * @cgw 2016-07-22 15:18:23
     */
    public void setCtime(Date ctme) {
        this.ctime = ctme;
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
     * @param mtime the value for fss_loan_document.mtime
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
     * @param remark the value for fss_loan_document.remark
     *
     * @cgw 2016-07-22 15:18:23
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FssLoanDocumentModel [id=" + id + ", loanId=" + loanId
				+ ", relationId=" + relationId + ", documentType="
				+ documentType + ", fileName=" + fileName + ", fileType="
				+ fileType + ", fileUrl=" + fileUrl + ", fileSize=" + fileSize
				+ ", ctime=" + ctime + ", mtime=" + mtime + ", remark="
				+ remark + "]";
	}
    
    
}