package com.yundian.fss.manager;

import java.util.List;

import com.yundian.fssapi.domain.FssBankUserModel;
import com.yundian.fssapi.domain.query.FssBankUserQueryModel;
import com.yundian.result.PaginatedResult;
import com.yundian.result.Paginator;

/**
 * 银行用户服务
 * 
 * @author hehaibo
 * @version $Id: FssBankUserService.java, v 0.1 2016年7月26日 下午8:59:44 hehaibo Exp $
 */
public interface FssBankUserManager {
	Integer insertFssBankUser (FssBankUserModel fssBankUserModel);
	
	Integer initInsertFssBankUser(FssBankUserModel bankUserModel);

	Integer updateFssBankUser(FssBankUserModel fssBankUserModel);
			
	Integer deleteFssBankUserByBkuserId ( Long bkuserId );
																											
	FssBankUserModel getFssBankUserById(Long id);

	List<FssBankUserModel> getFssBankUserList(FssBankUserModel fssBankUserModel);

	PaginatedResult<FssBankUserQueryModel> getPaginatorFssBankUser(
            Paginator<FssBankUserQueryModel> paginator);
	
	FssBankUserModel getFssBankUserByUserAndPwd(String username,String password);

	
}
