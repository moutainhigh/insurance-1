/**
 * 
 */
package com.yundian.fssapi.service;

import com.yundian.fssapi.domain.FssGuaranteeModel;
import com.yundian.result.PaginatedResult;
import com.yundian.result.Paginator;
import com.yundian.result.Result;

/**
 * 担保机构
 * @author cheguo
 *
 */
public interface FssGuaranteeService {
	
	/**
	 * 添加担保机构
	 * @param fssGuaranteeModel
	 * @return
	 */
	Result<Integer> addGuarantee(FssGuaranteeModel fssGuaranteeModel);
	
	/**
	 * 修改担保机构
	 * @param fssGuaranteeModel
	 * @return
	 */
	Result<Integer> modifyGuarantee(FssGuaranteeModel fssGuaranteeModel);
	
	/**
	 * 获取单个担保机构的信息
	 * @param fssGuaranteeId
	 * @return
	 */
	Result<FssGuaranteeModel> getFssGuaranteeById(Long fssGuaranteeId);
	
	/**
	 * 分页查询担保机构信息
	 * 
	 * @param paginator
	 * @return
	 */
	Result<PaginatedResult<FssGuaranteeModel>> getPaginatedResultFssGuarantee(
			Paginator<FssGuaranteeModel> paginator);
}
