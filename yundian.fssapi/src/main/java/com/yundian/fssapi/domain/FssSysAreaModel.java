package com.yundian.fssapi.domain;

import java.io.Serializable;

public class FssSysAreaModel implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    /**
     *
     */
    private Long id;

    /**
     * 省市名称
     */
    private String name;

    /**
     * 上级id
     */
    private Long parentId;

    /**
     * 记录增加时间
     */
    private String timestr;

    /**
     * 省市英文
     */
    private String englishName;

    /**
     * 排序
     */
    private String sort;

    /**
     * 省市的地区编码
     */
    private String areaCode;

    /**
     * 省市的字母简称
     */
    private String firstPy;

    /**
     * 类型：1省份，2城市，3县
     */
    private Integer type;

    /**
     * 备注
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
     * @param id the value for fss_sys_area.id
     *
     * @cgw 2016-07-22 15:18:23
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取省市名称
     *
     * @cgw 2016-07-22 15:18:23
     */
    public String getName() {
        return name;
    }

    /**
     * 设置省市名称
     *
     * @param name the value for fss_sys_area.name
     *
     * @cgw 2016-07-22 15:18:23
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取上级id
     *
     * @cgw 2016-07-22 15:18:23
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * 设置上级id
     *
     * @param parentId the value for fss_sys_area.parent_id
     *
     * @cgw 2016-07-22 15:18:23
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取记录增加时间
     *
     * @cgw 2016-07-22 15:18:23
     */
    public String getTimestr() {
        return timestr;
    }

    /**
     * 设置记录增加时间
     *
     * @param timestr the value for fss_sys_area.timestr
     *
     * @cgw 2016-07-22 15:18:23
     */
    public void setTimestr(String timestr) {
        this.timestr = timestr == null ? null : timestr.trim();
    }

    /**
     * 获取省市英文
     *
     * @cgw 2016-07-22 15:18:23
     */
    public String getEnglishName() {
        return englishName;
    }

    /**
     * 设置省市英文
     *
     * @param englishName the value for fss_sys_area.english_name
     *
     * @cgw 2016-07-22 15:18:23
     */
    public void setEnglishName(String englishName) {
        this.englishName = englishName == null ? null : englishName.trim();
    }

    /**
     * 获取排序
     *
     * @cgw 2016-07-22 15:18:23
     */
    public String getSort() {
        return sort;
    }

    /**
     * 设置排序
     *
     * @param sort the value for fss_sys_area.sort
     *
     * @cgw 2016-07-22 15:18:23
     */
    public void setSort(String sort) {
        this.sort = sort == null ? null : sort.trim();
    }

    /**
     * 获取省市的地区编码
     *
     * @cgw 2016-07-22 15:18:23
     */
    public String getAreaCode() {
        return areaCode;
    }

    /**
     * 设置省市的地区编码
     *
     * @param areaCode the value for fss_sys_area.area_code
     *
     * @cgw 2016-07-22 15:18:23
     */
    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode == null ? null : areaCode.trim();
    }

    /**
     * 获取省市的字母简称
     *
     * @cgw 2016-07-22 15:18:23
     */
    public String getFirstPy() {
        return firstPy;
    }

    /**
     * 设置省市的字母简称
     *
     * @param firstPy the value for fss_sys_area.first_py
     *
     * @cgw 2016-07-22 15:18:23
     */
    public void setFirstPy(String firstPy) {
        this.firstPy = firstPy == null ? null : firstPy.trim();
    }

    /**
     * 获取类型：1省份，2城市，3县
     *
     * @cgw 2016-07-22 15:18:23
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置类型：1省份，2城市，3县
     *
     * @param type the value for fss_sys_area.type
     *
     * @cgw 2016-07-22 15:18:23
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取备注
     *
     * @cgw 2016-07-22 15:18:23
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark the value for fss_sys_area.remark
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
		return "FssSysAreaModel [id=" + id + ", name=" + name + ", parentId="
				+ parentId + ", timestr=" + timestr + ", englishName="
				+ englishName + ", sort=" + sort + ", areaCode=" + areaCode
				+ ", firstPy=" + firstPy + ", type=" + type + ", remark="
				+ remark + "]";
	}
    
    
}