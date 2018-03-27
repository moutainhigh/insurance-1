package com.yundian.fss.test.bank;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.yundian.fss.test.AbstractJUnit;
import com.yundian.fssapi.domain.FssBankUserModel;
import com.yundian.fssapi.domain.query.FssBankUserQueryModel;
import com.yundian.fssapi.service.FssBankUserService;
import com.yundian.result.PaginatedResult;
import com.yundian.result.Paginator;
import com.yundian.result.Result;

public class FssBankUserServiceTest extends AbstractJUnit {

	@Autowired
	private FssBankUserService fssBankUserService;
	
	@Test
	public void testinsertFssOrganizationUser(){
		FssBankUserModel obj=new FssBankUserModel();

//		obj.setBkuserId (fss_bank_user.getBkuserId());// 
		obj.setBkuserName ("hehaibo");// 银行用户名
		obj.setBkuserPwd ("123456");// 银行用户名密码
		obj.setBankId (1L);// 所在银行机构id
		obj.setPhone ("1308888888");// 手机号码
		obj.setName ("hehaibo");// 姓名
//		obj.setCtime (fss_bank_user.getCtime());// 
//		obj.setMtime (fss_bank_user.getMtime());// 
		obj.setRemark ("单元测试");// 
		
		Result<Integer>	result =this.fssBankUserService.insertFssBankUser(obj);
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

		Paginator<FssBankUserQueryModel> paginator = new Paginator<FssBankUserQueryModel>();
		paginator.setCurrentPage(1);
		paginator.setPageSize(10);
		FssBankUserQueryModel obj=new FssBankUserQueryModel();

//		obj.setBkuserId (fss_bank_user.getBkuserId());// 
		obj.setBkuserName ("hehaibo");// 银行用户名
		obj.setBkuserPwd ("123456");// 银行用户名密码
		obj.setBankId (1L);// 所在银行机构id
		obj.setPhone ("1308888888");// 手机号码
		obj.setName ("hehaibo");// 姓名
//		obj.setCtime (fss_bank_user.getCtime());// 
//		obj.setMtime (fss_bank_user.getMtime());// 
		obj.setRemark ("单元测试");// 
		paginator.setParam(obj);
		Result<PaginatedResult<FssBankUserQueryModel>> result 
		= fssBankUserService.getPaginatorFssBankUser(paginator);
		System.out.println(JSON.toJSON(result));

	}
	@Test
	public void testfssBankUserLogin(){
		Result<FssBankUserModel> result=
				fssBankUserService.fssBankUserLogin("hehaibo","e10adc3949ba59abbe56e057f20f883e");
		System.out.println(JSON.toJSON(result));
	}
}
