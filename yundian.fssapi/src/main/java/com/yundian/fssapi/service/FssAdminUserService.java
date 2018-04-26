package com.yundian.fssapi.service;

import com.yundian.fssapi.domain.FssAdminUserModel;
import com.yundian.result.Page;
import com.yundian.result.Paginator;

/**
 *系统管理用户服务
 */
public interface FssAdminUserService {


	/**
	 * 密码重置
	 * @param userId
	 * @param userLoginName
	 * @return
	 */
	Boolean resetPwd(Long userId, String userLoginName);

	/**
	 *获取用户信息
	 * @param userId
	 * @return
	 */
	FssAdminUserModel getFssAdminUser(Long userId);

	/**
	 * 新增用户
	 * @param fssAdminUserModel
	 * @return
	 */
	Integer insertFssAdminUser(FssAdminUserModel fssAdminUserModel);

	/**
	 * 修改用户
	 * @param fssAdminUserModel
	 * @return
	 */
	Integer updateFssAdminUser(FssAdminUserModel fssAdminUserModel);

	/**
	 * 分页查询用户列表
	 * @param paginator
	 * @return
	 */
	Page<FssAdminUserModel> getPaginatorFssAdminUser(
            Paginator<FssAdminUserModel> paginator);
	/**
	 * 经销商用户登录
	 * @param userName
	 * @param password
	 * @return
	 */
	FssAdminUserModel fssFssAdminUserLogin(String userName, String password);

}
