package com.yundian.fssapi.service;

import com.yundian.fssapi.domain.FssAdminUserModel;
import com.yundian.fssapi.domain.FssUserModel;
import com.yundian.result.Page;
import com.yundian.result.Paginator;

/**
 *C用户服务
 */
public interface FssUserService {


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
	FssUserModel getFssUser(Long userId);

	/**
	 * 新增用户
	 * @param fssUserModel
	 * @return
	 */
	Integer insertFssUser(FssUserModel fssUserModel);

	/**
	 * 修改用户
	 * @param fssUserModel
	 * @return
	 */
	Integer updateFssUser(FssUserModel fssUserModel);

	/**
	 * 分页查询用户列表
	 * @param paginator
	 * @return
	 */
	Page<FssUserModel> getPaginatorFssUser(
            Paginator<FssUserModel> paginator);
	/**
	 * 用户登录
	 * @param userName
	 * @param password
	 * @return
	 */
	FssUserModel fssFssUserLogin(String userName, String password);

}
