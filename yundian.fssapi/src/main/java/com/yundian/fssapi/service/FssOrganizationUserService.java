package com.yundian.fssapi.service;

import java.util.List;

import com.yundian.fssapi.domain.FssOrganizationUserModel;
import com.yundian.fssapi.domain.query.FssOrganizationUserQueryModel;
import com.yundian.result.PaginatedResult;
import com.yundian.result.Paginator;
import com.yundian.result.Result;

/**
 * 渠道机构用户服务
 * 
 * @author hehaibo
 * @version $Id: FssOrganizationUserService.java, v 0.1 2016年7月26日 下午8:59:44 hehaibo Exp $
 */
public interface FssOrganizationUserService {
	/**
	 * 新增一个银行用户
	 * @param fssOrganizationUserModel
	 * @return
	 */
	Result<Integer> insertFssOrganizationUser (FssOrganizationUserModel fssOrganizationUserModel);
	
	/**
	 * 初始化一个银行用户，如果已经有用户，则不进行初始化
	 * 
	 * @param fssOrganizationUserModel
	 * @return
	 */
	Result<Integer> initInsertFssOrganizationUser(
			FssOrganizationUserModel fssOrganizationUserModel);
	
	Result<Integer> updateFssOrganizationUser(FssOrganizationUserModel fssOrganizationUserModel);
			
	Result<Integer> deleteFssOrganizationUserByOrguserId ( Long orguserId );
																											
	Result<FssOrganizationUserModel> getFssOrganizationUserById(Long id);

	Result<List<FssOrganizationUserModel>> getFssOrganizationUserList(FssOrganizationUserModel fssOrganizationUserModel);
	
	Result<PaginatedResult<FssOrganizationUserQueryModel>>  getPaginatorFssOrganizationUser(
            Paginator<FssOrganizationUserQueryModel> paginator);
	/**
	 * 用户登录
	 * @param userName
	 * @param password
	 * @return
	 */
	Result<FssOrganizationUserModel> fssOrganizationUserLogin(String userName,String password);



}
