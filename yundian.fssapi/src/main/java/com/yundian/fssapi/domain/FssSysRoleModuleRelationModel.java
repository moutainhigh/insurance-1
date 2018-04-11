package com.yundian.fssapi.domain;

import java.io.Serializable;
import java.util.Date;

public class FssSysRoleModuleRelationModel implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * 表ID
     */
    private Long id;

    /**
     * 功能模块ID
     */
    private Long moduleId;

    /**
     * 角色ID
     */
    private Long roleId;

    /**
     * 权限编码
     */
    private String permissionCode;

    /**
     * 创建时间
     */
    private Date ctime;

    /**
     * 修改时间
     */
    private Date mtime;

    /**
     * 备注
     */
    private String remark;

    /**
     * 获取表ID
     *
     * @cgw 2016-08-11 14:12:17
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置表ID
     *
     * @param id the value for tp_role_module_relation.id
     *
     * @cgw 2016-08-11 14:12:17
     */
    public void setId(Long id) {
        this.id = id;
    }

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
     * @param moduleId the value for tp_role_module_relation.module_id
     *
     * @cgw 2016-08-11 14:12:17
     */
    public void setModuleId(Long moduleId) {
        this.moduleId = moduleId;
    }

    /**
     * 获取角色ID
     *
     * @cgw 2016-08-11 14:12:17
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * 设置角色ID
     *
     * @param roleId the value for tp_role_module_relation.role_id
     *
     * @cgw 2016-08-11 14:12:17
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    /**
     * 获取权限编码
     *
     * @cgw 2016-08-11 14:12:17
     */
    public String getPermissionCode() {
        return permissionCode;
    }

    /**
     * 设置权限编码
     *
     * @param permissionCode the value for tp_role_module_relation.permission_code
     *
     * @cgw 2016-08-11 14:12:17
     */
    public void setPermissionCode(String permissionCode) {
        this.permissionCode = permissionCode == null ? null : permissionCode.trim();
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
     * @param ctime the value for tp_role_module_relation.ctime
     *
     * @cgw 2016-08-11 14:12:17
     */
    public void setCtime(Date ctime) {
        this.ctime = ctime;
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
     * @param mtime the value for tp_role_module_relation.mtime
     *
     * @cgw 2016-08-11 14:12:17
     */
    public void setMtime(Date mtime) {
        this.mtime = mtime;
    }

    /**
     * 获取备注
     *
     * @cgw 2016-08-11 14:12:17
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark the value for tp_role_module_relation.remark
     *
     * @cgw 2016-08-11 14:12:17
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}