package com.yundian.fssapi.domain;

import java.io.Serializable;
import java.util.Date;

public class FssSysRoleModel implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * 角色ID
     */
    private Long roleId;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 描述
     */
    private String description;

    /**
     * 使用状态
     */
    private String state;

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
     * @param roleId the value for tp_role.role_id
     *
     * @cgw 2016-08-11 14:12:17
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    /**
     * 获取角色名称
     *
     * @cgw 2016-08-11 14:12:17
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * 设置角色名称
     *
     * @param roleName the value for tp_role.role_name
     *
     * @cgw 2016-08-11 14:12:17
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
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
     * @param description the value for tp_role.description
     *
     * @cgw 2016-08-11 14:12:17
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
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
     * @param state the value for tp_role.state
     *
     * @cgw 2016-08-11 14:12:17
     */
    public void setState(String state) {
        this.state = state == null ? null : state.trim();
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
     * @param ctime the value for tp_role.ctime
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
     * @param creator the value for tp_role.creator
     *
     * @cgw 2016-08-11 14:12:17
     */
    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
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
     * @param mtime the value for tp_role.mtime
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
     * @param updateMan the value for tp_role.update_man
     *
     * @cgw 2016-08-11 14:12:17
     */
    public void setUpdateMan(String updateMan) {
        this.updateMan = updateMan == null ? null : updateMan.trim();
    }
    
    
}