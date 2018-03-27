package com.yundian.fss.test.bank;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.yundian.fss.test.AbstractJUnit;
import com.yundian.fssapi.domain.FssBankModel;
import com.yundian.fssapi.service.FssBankService;
import com.yundian.result.PaginatedResult;
import com.yundian.result.Paginator;
import com.yundian.result.Result;

public class FssBankServiceTest extends AbstractJUnit {

	@Autowired
	private FssBankService fssBankService;
	
	@Test
	public void testinsertFssOrganizationUser(){
		FssBankModel obj=new FssBankModel();

//		obj.setBankId (fss_bank.getBankId());// 
		obj.setBankCode ("icbc");// 银行编码：ICBC、CCB等
		obj.setBankName ("工商银行");// 银行名称
		obj.setBranchName ("杭州支行");// 分行名称
		obj.setProvince (1);// 所在省份
		obj.setCity (1);// 所在城市
		obj.setArea(1);
		obj.setProvinceName("浙江省");
		obj.setCityName("杭州市");
		obj.setAreaName("西湖区");
		obj.setStreet ("浙商财富中心");// 详细地址
//		obj.setCtime (fss_bank.getCtime());// 
//		obj.setMtime (fss_bank.getMtime());// 
//		obj.setRemark (fss_bank.getRemark());// 
		Result<Integer>	result =this.fssBankService.insertFssBank(obj);
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

		Paginator<FssBankModel> paginator = new Paginator<FssBankModel>();
		paginator.setCurrentPage(1);
		paginator.setPageSize(10);
		FssBankModel obj=new FssBankModel();

		obj.setBankCode ("icbc");// 银行编码：ICBC、CCB等
		obj.setBankName ("工商银行");// 银行名称
		obj.setBranchName ("杭州支行");// 分行名称
		obj.setProvince (1);// 所在省份
		obj.setCity (1);// 所在城市
		obj.setArea(1);
		paginator.setParam(obj);
		Result<PaginatedResult<FssBankModel>> result = fssBankService.getPaginatorFssBank(paginator);
		System.out.println(JSON.toJSON(result));

	}
	
}
