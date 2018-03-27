package com.yundian.fss.manager;

import com.yundian.fssapi.domain.FssOrganizationModel;
import com.yundian.result.PaginatedResult;
import com.yundian.result.Paginator;
import com.yundian.result.Result;

import java.util.List;

/**
 * 
 * @author hehaibo 审批机构
 */
public interface FssOrganizationManager {

	/**
	 * 新增审批机构
	 */
	Integer addFssOrganization(FssOrganizationModel fssOrganizationModel);

	/**
	 * 修改审批机构
	 */
	Integer modifyFssOrganization(FssOrganizationModel fssOrganizationModel);

	//---------------------------------------查询部分
	
	/**
	 * 查询机构信息
	 * @param organizationId
	 * @return
	 */
	FssOrganizationModel getFssOrganizationById(Long organizationId);
	
	/**
	 * 分页查询审批机构信息
	 * 
	 * @param paginator
	 * @return
	 */
	PaginatedResult<FssOrganizationModel> getPaginatedResult(
			Paginator<FssOrganizationModel> paginator);

	/**
	 * 查询所有机构信息
	 * @return
	 */
	List<FssOrganizationModel> listAllOrganization();

}
