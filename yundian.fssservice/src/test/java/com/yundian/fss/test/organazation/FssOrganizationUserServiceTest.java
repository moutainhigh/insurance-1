package com.yundian.fss.test.organazation;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.yundian.fss.test.AbstractJUnit;
import com.yundian.fssapi.domain.FssOrganizationUserModel;
import com.yundian.fssapi.domain.query.FssOrganizationUserQueryModel;
import com.yundian.fssapi.service.FssOrganizationUserService;
import com.yundian.result.PaginatedResult;
import com.yundian.result.Paginator;
import com.yundian.result.Result;

public class FssOrganizationUserServiceTest extends AbstractJUnit {

	@Autowired
	private FssOrganizationUserService fssOrganizationUserService;
	
	@Test
	public void testinsertFssOrganizationUser(){
		FssOrganizationUserModel obj=new FssOrganizationUserModel();

//		obj.setOrguserId (fss_organization_user.getOrguserId());// 
		obj.setOrganizationId (1L);// 审核机构id
		obj.setOrguserName ("hehaibo");// 审核机构用户名
		obj.setOrguserPwd ("123456");// 审核机构用户名密码
		obj.setPhone ("1308585222");// 手机号码
		obj.setName ("何海波");// 审核机构用户姓名
//		obj.setCtime (fss_organization_user.getCtime());// 
//		obj.setMtime (fss_organization_user.getMtime());// 
		obj.setRemark ("remark");// 
		Result<Integer>	result =this.fssOrganizationUserService.insertFssOrganizationUser(obj);
		System.out.println(JSON.toJSONString(result));
	}

	/**
	 * 分页查询审批机构信息
	 * 
	 * @param paginator
	 * @return
	 */
	@Test
	public void testgetPaginatorFssOrganizationUser() {

		Paginator<FssOrganizationUserQueryModel> paginator = new Paginator<FssOrganizationUserQueryModel>();
		paginator.setCurrentPage(1);
		paginator.setPageSize(10);
		FssOrganizationUserQueryModel param =new FssOrganizationUserQueryModel();
		paginator.setParam(param);
		Result<PaginatedResult<FssOrganizationUserQueryModel>> result = fssOrganizationUserService
				.getPaginatorFssOrganizationUser(paginator);
		System.out.println(JSON.toJSON(result));

	}
	@Test
	public void testfssOrganizationUserLogin(){
		Result<FssOrganizationUserModel> result =this.fssOrganizationUserService.
				fssOrganizationUserLogin("hehaibo", "123456");
		System.out.println(JSON.toJSON(result));

	}
}
