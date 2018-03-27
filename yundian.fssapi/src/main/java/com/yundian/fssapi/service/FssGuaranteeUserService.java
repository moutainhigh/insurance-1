package com.yundian.fssapi.service;

import com.yundian.fssapi.domain.FssUserModel;
import com.yundian.fssapi.domain.query.FssUserQueryModel;
import com.yundian.fssapi.dto.param.FssGuaranteeUserParam;
import com.yundian.result.PaginatedResult;
import com.yundian.result.Paginator;
import com.yundian.result.Result;

/**
 * 
 * @author ningxia.jin
 * 担保公司用户服务
 */
public interface FssGuaranteeUserService {

	/**
	 * 新增担保公司业务员,返回创建的担保用户Id
	 */
	Result<Long> addGuaranteeUser(FssGuaranteeUserParam user);
	/**
	 * 修改担保公司业务员,返回创建的担保用户Id
	 */
	Result<Integer> updateGuaranteeUser(FssGuaranteeUserParam user);
	
	/**
	 * 
	 * 修改密码
	 * 
	 */
	Result<Integer> updateGuaranteeUserPwd(Long userId,String oldPwd,String newPwd);
	
	
	/**
	 * 初始化担保机构第一个用户，如果有则不行插入
	 * 
	 * @param user
	 * @return
	 */
	Result<Long> initAddGuaranteeUser(FssGuaranteeUserParam user);
	/**
	 * 担保用户登录
	 * 
	 * @param userName
	 * @param userPwd
	 * @return
	 */
	Result<FssUserModel> guaranteeUserLogin(String userName,String userPwd);
	
	
	/**
	 * 根据担保用户ID获取用户信息
	 * 
	 * @param fssUserId
	 * @return
	 */
	Result<FssUserModel> getGuaranteeUserByFssUserId(Long fssUserId);

	
	/**
	 * 分页查询担保用户信息
	 * @param paginator
	 * @return
	 */
	Result<PaginatedResult<FssUserQueryModel>> getPaginatedResult(
			Paginator<FssUserQueryModel> paginator);
}
