package com.yundian.fssapi.service;

import com.yundian.fssapi.domain.FssOrganizationModel;
import com.yundian.result.PaginatedResult;
import com.yundian.result.Paginator;
import com.yundian.result.Result;

import java.util.List;

/**
 * 
 * @author hehaibo 审批机构
 */
public interface FssOrganizationService {

	/**
	 * 新增审批机构
	 */
	Result<Integer> addFssOrganization(FssOrganizationModel fssOrganizationModel);

	/**
	 * 修改审批机构
	 */
	Result<Integer> modifyFssOrganization(FssOrganizationModel fssOrganizationModel);

	//---------------------------------------查询部分
	
	/**
	 * 查询机构信息
	 * @param organizationId
	 * @return
	 */
	Result<FssOrganizationModel> getFssOrganizationById(Long organizationId);
	
	/**
	 * 分页查询审批机构信息
	 * 
	 * @param paginator
	 * @return
	 */
	Result<PaginatedResult<FssOrganizationModel>> getPaginatedResultFssOrganization(
			Paginator<FssOrganizationModel> paginator);

	/**
	 * 查询所有机构信息
	 * @return
	 */
	Result<List<FssOrganizationModel>> listAllOrganization();

}
