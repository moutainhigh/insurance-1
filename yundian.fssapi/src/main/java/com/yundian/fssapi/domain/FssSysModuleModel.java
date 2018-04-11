package com.yundian.fssapi.domain;

import java.io.Serializable;
import java.util.Date;

public class FssSysModuleModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * 功能模块ID
     */
    private Long moduleId;

    /**
     * 功能模块名称
     */
    private String moduleName;

    /**
     * 父模块ID
     */
    private Long parentId;

    /**
     * 使用状态
     */
    private String state;

    /**
     * 业务编码
     */
    private String businessCode;

    /**
     * 链接地址
     */
    private String linkAddress;

    /**
     * 描述
     */
    private String description;

    /**
     * 创建时间
     */
    private Date ctime;

    /**
     * 创建人
     */
    private String creator;

    /**
     * 修改时间
     */
    private Date mtime;

    /**
     * 修改人
     */
    private String updateMan;

    /**
     * 排序
     */
    private Integer sorting;

    /**
     * 小图标
     */
    private String icon;

    /**
     * 操作码
     */
    private String operatorCode;

    /**
     * 获取功能模块ID
     *
     * @cgw 2016-08-11 14:12:17
     */
    public Long getModuleId() {
        return moduleId;
    }

    /**
     * 设置功能模块ID
     *
     * @param moduleId the value for tp_module.module_id
     *
     * @cgw 2016-08-11 14:12:17
     */
    public void setModuleId(Long moduleId) {
        this.moduleId = moduleId;
    }

    /**
     * 获取功能模块名称
     *
     * @cgw 2016-08-11 14:12:17
     */
    public String getModuleName() {
        return moduleName;
    }

    /**
     * 设置功能模块名称
     *
     * @param moduleName the value for tp_module.module_name
     *
     * @cgw 2016-08-11 14:12:17
     */
    public void setModuleName(String moduleName) {
        this.moduleName = moduleName == null ? null : moduleName.trim();
    }

    /**
     * 获取父模块ID
     *
     * @cgw 2016-08-11 14:12:17
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * 设置父模块ID
     *
     * @param parentId the value for tp_module.parent_id
     *
     * @cgw 2016-08-11 14:12:17
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取使用状态
     *
     * @cgw 2016-08-11 14:12:17
     */
    public String getState() {
        return state;
    }

    /**
     * 设置使用状态
     *
     * @param state the value for tp_module.state
     *
     * @cgw 2016-08-11 14:12:17
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * 获取业务编码
     *
     * @cgw 2016-08-11 14:12:17
     */
    public String getBusinessCode() {
        return businessCode;
    }

    /**
     * 设置业务编码
     *
     * @param businessCode the value for tp_module.business_code
     *
     * @cgw 2016-08-11 14:12:17
     */
    public void setBusinessCode(String businessCode) {
        this.businessCode = businessCode == null ? null : businessCode.trim();
    }

    /**
     * 获取链接地址
     *
     * @cgw 2016-08-11 14:12:17
     */
    public String getLinkAddress() {
        return linkAddress;
    }

    /**
     * 设置链接地址
     *
     * @param linkAddress the value for tp_module.link_address
     *
     * @cgw 2016-08-11 14:12:17
     */
    public void setLinkAddress(String linkAddress) {
        this.linkAddress = linkAddress == null ? null : linkAddress.trim();
    }

    /**
     * 获取描述
     *
     * @cgw 2016-08-11 14:12:17
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置描述
     *
     * @param description the value for tp_module.description
     *
     * @cgw 2016-08-11 14:12:17
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * 获取创建时间
     *
     * @cgw 2016-08-11 14:12:17
     */
    public Date getCtime() {
        return ctime;
    }

    /**
     * 设置创建时间
     *
     * @param ctime the value for tp_module.ctime
     *
     * @cgw 2016-08-11 14:12:17
     */
    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    /**
     * 获取创建人
     *
     * @cgw 2016-08-11 14:12:17
     */
    public String getCreator() {
        return creator;
    }

    /**
     * 设置创建人
     *
     * @param creator the value for tp_module.creator
     *
     * @cgw 2016-08-11 14:12:17
     */
    public void setCreator(String creator) {
        this.creator = creator;
    }

    /**
     * 获取修改时间
     *
     * @cgw 2016-08-11 14:12:17
     */
    public Date getMtime() {
        return mtime;
    }

    /**
     * 设置修改时间
     *
     * @param mtime the value for tp_module.mtime
     *
     * @cgw 2016-08-11 14:12:17
     */
    public void setMtime(Date mtime) {
        this.mtime = mtime;
    }

    /**
     * 获取修改人
     *
     * @cgw 2016-08-11 14:12:17
     */
    public String getUpdateMan() {
        return updateMan;
    }

    /**
     * 设置修改人
     *
     * @param updateMan the value for tp_module.update_man
     *
     * @cgw 2016-08-11 14:12:17
     */
    public void setUpdateMan(String updateMan) {
        this.updateMan = updateMan;
    }

    /**
     * 获取排序
     *
     * @cgw 2016-08-11 14:12:17
     */
    public Integer getSorting() {
        return sorting;
    }

    /**
     * 设置排序
     *
     * @param sorting the value for tp_module.sorting
     *
     * @cgw 2016-08-11 14:12:17
     */
    public void setSorting(Integer sorting) {
        this.sorting = sorting;
    }

    /**
     * 获取小图标
     *
     * @cgw 2016-08-11 14:12:17
     */
    public String getIcon() {
        return icon;
    }

    /**
     * 设置小图标
     *
     * @param icon the value for tp_module.icon
     *
     * @cgw 2016-08-11 14:12:17
     */
    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    /**
     * 获取操作码
     *
     * @cgw 2016-08-11 14:12:17
     */
    public String getOperatorCode() {
        return operatorCode;
    }

    /**
     * 设置操作码
     *
     * @param operatorCode the value for tp_module.operator_code
     *
     * @cgw 2016-08-11 14:12:17
     */
    public void setOperatorCode(String operatorCode) {
        this.operatorCode = operatorCode == null ? null : operatorCode.trim();
    }
}