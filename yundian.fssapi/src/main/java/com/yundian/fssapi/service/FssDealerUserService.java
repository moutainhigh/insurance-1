package com.yundian.fssapi.service;

import com.yundian.fssapi.domain.FssDealerUserModel;
import com.yundian.result.Page;
import com.yundian.result.PaginatedResult;
import com.yundian.result.Paginator;
import com.yundian.result.Result;

/**
 *经销商用户服务
 */
public interface FssDealerUserService {


	/**
	 * 修改密码
	 * @param userId
	 * @param oldPwd
	 * @param newPwd
	 * @return
	 */
	 Boolean modifyPwd(Long userId,String oldPwd, String newPwd);

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
	FssDealerUserModel getFssDealerUser(Long userId);

	/**
	 * 新增用户
	 * @param fssDealerUserModel
	 * @return
	 */
	Integer insertFssDealerUser(FssDealerUserModel fssDealerUserModel);

	/**
	 * 修改用户
	 * @param fssDealerUserModel
	 * @return
	 */
	Integer updateFssDealerUser(FssDealerUserModel fssDealerUserModel);

	/**
	 * 分页查询用户列表
	 * @param paginator
	 * @return
	 */
	Page<FssDealerUserModel> getPaginatorFssDealerUser(
			Paginator<FssDealerUserModel> paginator);
	/**
	 * 经销商用户登录
	 * @param userName
	 * @param password
	 * @return
	 */
	FssDealerUserModel fssFssDealerUserLogin(String userName,String password);

}
