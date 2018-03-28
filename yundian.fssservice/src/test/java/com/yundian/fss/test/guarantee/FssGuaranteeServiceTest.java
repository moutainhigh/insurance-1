package com.yundian.fss.test.guarantee;

import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.yundian.fss.test.AbstractJUnit;
import com.yundian.fssapi.domain.FssGuaranteeModel;
import com.yundian.fssapi.enums.FssGuaranteeVerifyStatusEnum;
import com.yundian.fssapi.service.FssGuaranteeService;
import com.yundian.result.PaginatedResult;
import com.yundian.result.Paginator;
import com.yundian.result.Result;

public class FssGuaranteeServiceTest extends AbstractJUnit {

	@Autowired
	private FssGuaranteeService fssGuaranteeService;

	@Test
	public void addGuarantee(){
		FssGuaranteeModel fssGuaranteeModel=new FssGuaranteeModel();
		fssGuaranteeModel.setGuaranteeName("XX担保");
		fssGuaranteeModel.setGuaranteeCode("XXX0001");
		fssGuaranteeModel.setLicenseCode("1111111111111111");
		fssGuaranteeModel.setOrganizeCode("XXX0001");
		fssGuaranteeModel.setBusinessentity("企业法人");

		fssGuaranteeModel.setProvince(2);
		fssGuaranteeModel.setCity(1);
		fssGuaranteeModel.setAreaName("杭州");
		fssGuaranteeModel.setStreet("杭州财富中心");

		fssGuaranteeModel.setRemark("remark");
		fssGuaranteeModel.setContactor("zhangsan");
		fssGuaranteeModel.setPhone("0755-112121212");

		fssGuaranteeModel.setVerifyStatus(FssGuaranteeVerifyStatusEnum.NO_AUTH.code());
		fssGuaranteeModel.setVerifyTime(new Date());
		
		fssGuaranteeModel.setCtime(new Date());
		
		Result<Integer> result=fssGuaranteeService.addGuarantee(fssGuaranteeModel);
		System.out.println(ToStringBuilder.reflectionToString(result));
	}
	/**
	 * 分页查询审批机构信息
	 * 
	 *
	 * @return
	 */
	@Test
	public void getPaginatedResult() {

		Paginator<FssGuaranteeModel> paginator = new Paginator<FssGuaranteeModel>();
		paginator.setCurrentPage(1);
		paginator.setPageSize(10);
		FssGuaranteeModel param =new FssGuaranteeModel();
		paginator.setParam(param);
		Result<PaginatedResult<FssGuaranteeModel>> result = fssGuaranteeService
				.getPaginatedResultFssGuarantee(paginator);
		System.out.println(ToStringBuilder.reflectionToString(result.getData()));

	}
}
