/**
 * 
 */
package com.yundian.fss.manager;

import com.yundian.fssapi.domain.FssGuaranteeModel;
import com.yundian.fssapi.domain.FssUserModel;
import com.yundian.result.PaginatedResult;
import com.yundian.result.Paginator;

/**
 * 担保机构
 * @author cheguo
 *
 */
public interface FssGuaranteeManager {
	
	/**
	 * 添加担保机构
	 * @param fssGuaranteeModel
	 * @return
	 */
	Integer addGuarantee(FssGuaranteeModel fssGuaranteeModel);
	
	/**
	 * 修改担保机构
	 * @param fssGuaranteeModel
	 * @return
	 */
	Integer modifyGuarantee(FssGuaranteeModel fssGuaranteeModel);
	
	/**
	 * 获取单个担保机构的信息
	 * @param fssGuaranteeId
	 * @return
	 */
	FssGuaranteeModel getFssGuaranteeById(Long fssGuaranteeId);
	
	/**
	 * 分页查询担保机构信息
	 * 
	 * @param paginator
	 * @return
	 */
	PaginatedResult<FssGuaranteeModel> getPaginatedResult(
			Paginator<FssGuaranteeModel> paginator);

}
