package com.yundian.fssapi.domain;

import java.io.Serializable;
import java.util.Date;
/**
 * 代码配置字典项表
 * @author cheguo
 *
 */
public class FssCodeLibraryModel implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
     * 主键
     */
    private Long id;

    /**
     * 代码编号
     */
    private String codeId;

    /**
     * 代码名称
     */
    private String codeName;

    /**
     * 类型
     */
    private String codeType;

    /**
     * 排序号
     */
    private String sortNo;

    /**
     * 描述
     */
    private String describe;

    /**
     * 是否启用
     */
    private Boolean isInuse;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date modifyTime;

    /**
     * 获取主键
     *
     * @cgw 2016-07-26 11:23:26
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id the value for fss_code_library.id
     *
     * @cgw 2016-07-26 11:23:26
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取代码编号
     *
     * @cgw 2016-07-26 11:23:26
     */
    public String getCodeId() {
        return codeId;
    }

    /**
     * 设置代码编号
     *
     * @param codeId the value for fss_code_library.code_id
     *
     * @cgw 2016-07-26 11:23:26
     */
    public void setCodeId(String codeId) {
        this.codeId = codeId == null ? null : codeId.trim();
    }

    /**
     * 获取代码名称
     *
     * @cgw 2016-07-26 11:23:26
     */
    public String getCodeName() {
        return codeName;
    }

    /**
     * 设置代码名称
     *
     * @param codeName the value for fss_code_library.code_name
     *
     * @cgw 2016-07-26 11:23:26
     */
    public void setCodeName(String codeName) {
        this.codeName = codeName == null ? null : codeName.trim();
    }

    /**
     * 获取类型
     *
     * @cgw 2016-07-26 11:23:26
     */
    public String getCodeType() {
        return codeType;
    }

    /**
     * 设置类型
     *
     * @param codeType the value for fss_code_library.code_type
     *
     * @cgw 2016-07-26 11:23:26
     */
    public void setCodeType(String codeType) {
        this.codeType = codeType == null ? null : codeType.trim();
    }

    /**
     * 获取排序号
     *
     * @cgw 2016-07-26 11:23:26
     */
    public String getSortNo() {
        return sortNo;
    }

    /**
     * 设置排序号
     *
     * @param sortNo the value for fss_code_library.sort_no
     *
     * @cgw 2016-07-26 11:23:26
     */
    public void setSortNo(String sortNo) {
        this.sortNo = sortNo == null ? null : sortNo.trim();
    }

    /**
     * 获取描述
     *
     * @cgw 2016-07-26 11:23:26
     */
    public String getDescribe() {
        return describe;
    }

    /**
     * 设置描述
     *
     * @param describe the value for fss_code_library.describe
     *
     * @cgw 2016-07-26 11:23:26
     */
    public void setDescribe(String describe) {
        this.describe = describe == null ? null : describe.trim();
    }

    /**
     * 获取是否启用
     *
     * @cgw 2016-07-26 11:23:26
     */
    public Boolean getIsInuse() {
        return isInuse;
    }

    /**
     * 设置是否启用
     *
     * @param isInuse the value for fss_code_library.is_inuse
     *
     * @cgw 2016-07-26 11:23:26
     */
    public void setIsInuse(Boolean isInuse) {
        this.isInuse = isInuse;
    }

    /**
     * 获取创建时间
     *
     * @cgw 2016-07-26 11:23:26
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime the value for fss_code_library.create_time
     *
     * @cgw 2016-07-26 11:23:26
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取更新时间
     *
     * @cgw 2016-07-26 11:23:26
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 设置更新时间
     *
     * @param modifyTime the value for fss_code_library.modify_time
     *
     * @cgw 2016-07-26 11:23:26
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FssCodeLibraryModel [id=" + id + ", codeId=" + codeId
				+ ", codeName=" + codeName + ", codeType=" + codeType
				+ ", sortNo=" + sortNo + ", describe=" + describe
				+ ", isInuse=" + isInuse + ", createTime=" + createTime
				+ ", modifyTime=" + modifyTime + "]";
	}
    
    
    
    
}