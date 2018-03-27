package com.yundian.fss.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.yundian.fssapi.domain.FssUserModel;
import com.yundian.fssapi.domain.query.FssUserQueryModel;
import com.yundian.fssapi.dto.param.FssGuaranteeUserParam;
import com.yundian.fssapi.enums.FssLoanSexEnum;
import com.yundian.fssapi.service.FssGuaranteeUserService;
import com.yundian.result.PaginatedResult;
import com.yundian.result.Paginator;
import com.yundian.result.Result;

public class GuaranteeUserTest extends AbstractJUnit {

	@Autowired
	private FssGuaranteeUserService guaranteeUserService;
	@Test
	public void addGuaranteeUser()
	{
		FssGuaranteeUserParam user=new FssGuaranteeUserParam();
		user.setName("金宁夏");
		user.setSex(FssLoanSexEnum.M.name());
		user.setPhone("1852222222");
		user.setUserName("jinningxia");
		user.setUserPwd("123456");
		user.setGuaranteeId(1L);
		Result<Long> result =guaranteeUserService.addGuaranteeUser(user);
		System.out.println(JSON.toJSONString(result));
	}
	@Test
	public void guaranteeUserLogin(){
		Result<FssUserModel>  result=
				guaranteeUserService.guaranteeUserLogin("hehaibo", "123456");
		System.out.println(JSON.toJSON(result));
	}
	@Test
	public void testgetPaginatedResult(){
		Paginator<FssUserQueryModel> paginator = new Paginator<FssUserQueryModel>();
		paginator.setCurrentPage(1);
		paginator.setPageSize(10);
		FssUserQueryModel param =new FssUserQueryModel();
		paginator.setParam(param);
		param.setGuaranteeId(1L);
		param.setUserName("hehaibo");
		param.setName("金");
		param.setRoleId("roleId");
		param.setStation("station");
		param.setRegion("region");
		Result<PaginatedResult<FssUserQueryModel>> result = guaranteeUserService
				.getPaginatedResult(paginator);
		System.out.println(JSON.toJSON(result));
		
	}
}
