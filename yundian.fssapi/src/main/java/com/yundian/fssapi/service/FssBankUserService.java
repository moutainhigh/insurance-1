package com.yundian.fssapi.service;

import java.util.List;

import com.yundian.fssapi.domain.FssBankUserModel;
import com.yundian.fssapi.domain.query.FssBankUserQueryModel;
import com.yundian.result.PaginatedResult;
import com.yundian.result.Paginator;
import com.yundian.result.Result;

/**
 * 银行用户服务
 * 
 * @author hehaibo
 * @version $Id: FssBankUserService.java, v 0.1 2016年7月26日 下午8:59:44 hehaibo Exp
 *          $
 */
public interface FssBankUserService {
	/**
	 * 新增一个银行用户
	 * 
	 * @param fssBankUserModel
	 * @return
	 */
	Result<Integer> insertFssBankUser(FssBankUserModel fssBankUserModel);

	/**
	 * 初始化银行用户，如果该银行下面有用户，则不能添加用户
	 * 
	 * @param bankUserModel
	 * @return
	 */
	Result<Integer> initInsertFssBankUser(FssBankUserModel bankUserModel);

	Result<Integer> updateFssBankUser(FssBankUserModel fssBankUserModel);

	Result<Integer> deleteFssBankUserByBkuserId(Long bkuserId);

	Result<FssBankUserModel> getFssBankUserById(Long id);

	Result<List<FssBankUserModel>> getFssBankUserList(
			FssBankUserModel fssBankUserModel);

	Result<PaginatedResult<FssBankUserQueryModel>> getPaginatorFssBankUser(
			Paginator<FssBankUserQueryModel> paginator);

	/**
	 * 银行用户登录
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	Result<FssBankUserModel> fssBankUserLogin(String username, String password);

}
