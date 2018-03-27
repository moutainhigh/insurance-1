package com.yundian.fssapi.domain;

import java.io.Serializable;
import java.util.Date;

public class FssDictionaryModel implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * 
     */
    private Long id;

    /**
     * 字典编码
     */
    private String itemCode;

    /**
     * 字典项值
     */
    private String itemValue;

    /**
     * 备注
     */
    private String remark;

    /**
     * 上级ID
     */
    private Long parentId;

    /**
     * 等级
     */
    private Integer level;

    /**
     * 是否可用
     */
    private String isEnable;

    /**
     * 类型编号
     */
    private String dictTypeCode;

    /**
     * 字典项目序号
     */
    private Integer sortNo;

    /**
     * 创建人
     */
    private String creator;

    /**
     * 创建时间
     */
    private Date ctime;

    /**
     * 修改人
     */
    private String modifier;

    /**
     * 修改时间
     */
    private Date mtime;

    /**
     * 获取
     *
     * @cgw 2016-07-29 13:50:15
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置
     *
     * @param id the value for fss_dictionary.id
     *
     * @cgw 2016-07-29 13:50:15
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取字典编码
     *
     * @cgw 2016-07-29 13:50:15
     */
    public String getItemCode() {
        return itemCode;
    }

    /**
     * 设置字典编码
     *
     * @param itemCode the value for fss_dictionary.item_code
     *
     * @cgw 2016-07-29 13:50:15
     */
    public void setItemCode(String itemCode) {
        this.itemCode = itemCode == null ? null : itemCode.trim();
    }

    /**
     * 获取字典项值
     *
     * @cgw 2016-07-29 13:50:15
     */
    public String getItemValue() {
        return itemValue;
    }

    /**
     * 设置字典项值
     *
     * @param itemValue the value for fss_dictionary.item_value
     *
     * @cgw 2016-07-29 13:50:15
     */
    public void setItemValue(String itemValue) {
        this.itemValue = itemValue == null ? null : itemValue.trim();
    }

    /**
     * 获取备注
     *
     * @cgw 2016-07-29 13:50:15
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark the value for fss_dictionary.remark
     *
     * @cgw 2016-07-29 13:50:15
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 获取上级ID
     *
     * @cgw 2016-07-29 13:50:15
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * 设置上级ID
     *
     * @param parentId the value for fss_dictionary.parent_id
     *
     * @cgw 2016-07-29 13:50:15
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取等级
     *
     * @cgw 2016-07-29 13:50:15
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * 设置等级
     *
     * @param level the value for fss_dictionary.level
     *
     * @cgw 2016-07-29 13:50:15
     */
    public void setLevel(Integer level) {
        this.level = level;
    }

    /**
     * 获取是否可用
     *
     * @cgw 2016-07-29 13:50:15
     */
    public String getIsEnable() {
        return isEnable;
    }

    /**
     * 设置是否可用
     *
     * @param isEnable the value for fss_dictionary.is_enable
     *
     * @cgw 2016-07-29 13:50:15
     */
    public void setIsEnable(String isEnable) {
        this.isEnable = isEnable == null ? null : isEnable.trim();
    }

    /**
     * 获取类型编号
     *
     * @cgw 2016-07-29 13:50:15
     */
    public String getDictTypeCode() {
        return dictTypeCode;
    }

    /**
     * 设置类型编号
     *
     * @param dictTypeCode the value for fss_dictionary.dict_type_code
     *
     * @cgw 2016-07-29 13:50:15
     */
    public void setDictTypeCode(String dictTypeCode) {
        this.dictTypeCode = dictTypeCode == null ? null : dictTypeCode.trim();
    }

    /**
     * 获取字典项目序号
     *
     * @cgw 2016-07-29 13:50:15
     */
    public Integer getSortNo() {
        return sortNo;
    }

    /**
     * 设置字典项目序号
     *
     * @param sortNo the value for fss_dictionary.sort_no
     *
     * @cgw 2016-07-29 13:50:15
     */
    public void setSortNo(Integer sortNo) {
        this.sortNo = sortNo;
    }

    /**
     * 获取创建人
     *
     * @cgw 2016-07-29 13:50:15
     */
    public String getCreator() {
        return creator;
    }

    /**
     * 设置创建人
     *
     * @param creator the value for fss_dictionary.creator
     *
     * @cgw 2016-07-29 13:50:15
     */
    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    /**
     * 获取创建时间
     *
     * @cgw 2016-07-29 13:50:15
     */
    public Date getCtime() {
        return ctime;
    }

    /**
     * 设置创建时间
     *
     * @param ctime the value for fss_dictionary.ctime
     *
     * @cgw 2016-07-29 13:50:15
     */
    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    /**
     * 获取修改人
     *
     * @cgw 2016-07-29 13:50:15
     */
    public String getModifier() {
        return modifier;
    }

    /**
     * 设置修改人
     *
     * @param modifier the value for fss_dictionary.modifier
     *
     * @cgw 2016-07-29 13:50:15
     */
    public void setModifier(String modifier) {
        this.modifier = modifier == null ? null : modifier.trim();
    }

    /**
     * 获取修改时间
     *
     * @cgw 2016-07-29 13:50:15
     */
    public Date getMtime() {
        return mtime;
    }

    /**
     * 设置修改时间
     *
     * @param mtime the value for fss_dictionary.mtime
     *
     * @cgw 2016-07-29 13:50:15
     */
    public void setMtime(Date mtime) {
        this.mtime = mtime;
    }

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FssDictionaryModel [id=" + id + ", itemCode=" + itemCode
				+ ", itemValue=" + itemValue + ", remark=" + remark
				+ ", parentId=" + parentId + ", level=" + level + ", isEnable="
				+ isEnable + ", dictTypeCode=" + dictTypeCode + ", sortNo="
				+ sortNo + ", creator=" + creator + ", ctime=" + ctime
				+ ", modifier=" + modifier + ", mtime=" + mtime + "]";
	}
    
    
}