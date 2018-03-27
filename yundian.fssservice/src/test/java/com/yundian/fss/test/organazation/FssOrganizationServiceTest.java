package com.yundian.fss.test.organazation;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.yundian.fss.test.AbstractJUnit;
import com.yundian.fssapi.domain.FssOrganizationModel;
import com.yundian.fssapi.service.FssOrganizationService;
import com.yundian.result.PaginatedResult;
import com.yundian.result.Paginator;
import com.yundian.result.Result;

public class FssOrganizationServiceTest extends AbstractJUnit {

	@Autowired
	private FssOrganizationService fssOrganizationService;
	
	@Test
	public void testAddFssOrganization(){
		FssOrganizationModel obj=new FssOrganizationModel();

//		obj.setOrganizationId (fss_organization.getOrganizationId());// 
		obj.setOrganizationName ("机构名称");// 机构名称
		obj.setProvince (1);// 所在省份
		obj.setCity (2);// 所在城市
		obj.setAreaName ("县");// 所在省市名称
		obj.setStreet ("详细地址");// 
		obj.setPhone ("13800000000");// 联系人电话
		obj.setContactor ("联系人");// 联系人
//		obj.setCtime (fss_organization.getCtime());// 
//		obj.setMtime (fss_organization.getMtime());// 
		obj.setRemark ("备注");// 
		Result<Integer>	result =this.fssOrganizationService.addFssOrganization(obj);
		System.out.println(JSON.toJSONString(result));
	}

	/**
	 * 分页查询审批机构信息
	 * 
	 * @param paginator
	 * @return
	 */
	@Test
	public void getPaginatedResult() {

		Paginator<FssOrganizationModel> paginator = new Paginator<FssOrganizationModel>();
		paginator.setCurrentPage(1);
		paginator.setPageSize(10);
		FssOrganizationModel param =new FssOrganizationModel();
		paginator.setParam(param);
		Result<PaginatedResult<FssOrganizationModel>> result = fssOrganizationService
				.getPaginatedResultFssOrganization(paginator);
		System.out.println("Total:"+result.getData().getTotal());
		System.out.println(result.getData().getRows() == null ? 0 : result.getData()
				.getRows().size());

	}
}
