package com.yundian.fss.manager;

import java.util.List;

import com.yundian.fssapi.domain.FssOrganizationUserModel;
import com.yundian.fssapi.domain.query.FssOrganizationUserQueryModel;
import com.yundian.result.PaginatedResult;
import com.yundian.result.Paginator;

/**
 * 渠道机构用户服务
 * 
 * @author hehaibo
 * @version $Id: FssOrganizationUserService.java, v 0.1 2016年7月26日 下午8:59:44 hehaibo Exp $
 */
public interface FssOrganizationUserManager {
	Integer insertFssOrganizationUser (FssOrganizationUserModel fssOrganizationUserService);
	
	Integer initInsertFssOrganizationUser(
			FssOrganizationUserModel fssOrganizationUserModel);
	
	Integer updateFssOrganizationUser(FssOrganizationUserModel fssOrganizationUserService);
			
	Integer deleteFssOrganizationUserByOrguserId ( Long orguserId );
																											
	FssOrganizationUserModel getFssOrganizationUserById(Long id);

	List<FssOrganizationUserModel> getFssOrganizationUserList(FssOrganizationUserModel fssOrganizationUserService);
	
	PaginatedResult<FssOrganizationUserQueryModel>  getPaginatorFssOrganizationUser(
            Paginator<FssOrganizationUserQueryModel> paginator);

	FssOrganizationUserModel fssOrganizationUserLogin(String userName,
			String password);

	
}
