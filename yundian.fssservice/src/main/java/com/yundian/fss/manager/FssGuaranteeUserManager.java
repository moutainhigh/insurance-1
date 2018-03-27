package com.yundian.fss.manager;

import com.yundian.fssapi.domain.FssUserModel;
import com.yundian.fssapi.domain.query.FssUserQueryModel;
import com.yundian.fssapi.dto.param.FssGuaranteeUserParam;
import com.yundian.result.PaginatedResult;
import com.yundian.result.Paginator;

/**
 * 
 * @author ningxia.jin
 * 担保公司用户服务
 */
public interface FssGuaranteeUserManager {

	/**
	 * 新增担保公司业务员,返回创建的担保用户Id
	 */
	Long addGuaranteeUser(FssGuaranteeUserParam user);
	
	/**
	 * 初始化担保机构第一个用户,如果已经初始化，则不进行插入
	 * 
	 * @param user
	 * @return
	 */
	Long initAddGuaranteeUser(FssGuaranteeUserParam user);
	/**
	 * 
	 * @param user
	 * @return
	 */
	Integer updateGuaranteeUser(FssGuaranteeUserParam user);

	/**
	 * 担保用户登录
	 * 
	 * @param userName
	 * @param userPwd
	 * @return
	 */
	FssUserModel guaranteeUserLogin(String userName,String userPwd);
	
	/**
	 * 根据担保用户ID获取用户信息
	 * 
	 * @param fssUserId
	 * @return
	 */
	FssUserModel getGuaranteeUserByFssUserId(Long fssUserId);
	
	
	/**
	 * 分页查询担保机构用户的信息
	 * 
	 * @param paginator
	 * @return
	 */
	PaginatedResult<FssUserQueryModel> getPaginatedResult(
			Paginator<FssUserQueryModel> paginator);

	/**
	 * 
	 * @param userId
	 * @param oldPwd
	 * @param newPwd
	 * @return
	 */
	Integer updateGuaranteeUserPwd(Long userId, String oldPwd, String newPwd);


}
