package com.yundian.fss.test.credit;

import java.math.BigDecimal;
import java.util.Date;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.yundian.fss.test.AbstractJUnit;
import com.yundian.fssapi.domain.FssCreditModel;
import com.yundian.fssapi.domain.FssCreditRiskModel;
import com.yundian.fssapi.enums.FssCreditStatusEnum;
import com.yundian.fssapi.service.FssCreditRiskService;
import com.yundian.fssapi.service.FssCreditService;
import com.yundian.result.Result;

public class FssCreditServiceTest extends AbstractJUnit {

	@Autowired
	FssCreditService fssCreditService;
	@Autowired
	FssCreditRiskService fssCreditRiskService;
	
	public static FssCreditModel createFssCreditModel() {

		FssCreditModel obj = new FssCreditModel();

		// obj.setCreditId (fss_credit.getCreditId());// 主键ID
		obj.setGuaranteeId(100L);// 合作机构ID
		obj.setGuaranteeName("上海湖滨汽车销售服务有限公司");//
		obj.setGuaranteeUserId(100001L);// ID
		obj.setGuaranteeUserName("金宁夏");// 合作机构业务员姓名
		obj.setGuaranteeUserPhone("13758298275");// 合作机构业务员手机号码
		obj.setBankId(14L);// 银行id
		obj.setBankName("工商银行杭州支行");// 银行名称
		obj.setBankCode("ICBC");//
		obj.setName("方军");//
		obj.setSex("F");// 性别
		obj.setIdcard("330681198102230311");// 身份证号
		obj.setPhone("13555226644");// 手机号码
		obj.setBirthday("1987-08-08");// 出生年月
		obj.setCardFrontimg("http://imgditan2012.cang.com/201206/15/2012061506454362912764.jpg");// 身份证正面照片
		obj.setCardOppositeimg("http://hiphotos.baidu.com/exp/pic/item/c9bdddcec3fdfc039a27720ad63f8794a5c226e1.jpg");// 身份证反面照片
		obj.setRequisitionSignImg("http://www.wdw88.com/upload/project/original/201601/31/160131201910526.jpg");// 征信授权书亲签照片
		obj.setOriginalImg("http://www.wdw88.com/upload/project/original/201601/31/160131201910526.jpg");// 征信授权书原件照片
		obj.setCreditStatus(FssCreditStatusEnum.WAIT_ADUIT.code());// 征信状态
		obj.setCreditReportTime(new Date());// 银行征信报告日期
		obj.setLoanNum(0);// 贷款笔数
		obj.setLoanTotalAmount(BigDecimal.ZERO);// 总贷款金额
		obj.setOverduePeriods(0);// 当前累计逾期期数
		obj.setOverdueAmount(BigDecimal.ZERO);// 当前累计逾期金额
		obj.setDebitAccountNum(0);// 贷记卡总账户数
		obj.setDebitTotalPosition(BigDecimal.ZERO);// 贷记卡总授信额度
		obj.setDebitOverduePeriods(0);// 贷记卡当前累计逾期期数
		obj.setDebitOverdueAmount(BigDecimal.ZERO);// 贷记卡当前累计逾期金额
		obj.setSemiAccountNum(1);// 准贷记卡总账户数
		obj.setSemiTotalPosition(BigDecimal.ZERO);// 准贷记卡总授信额度
		obj.setSemiOverdrawnAmount180(BigDecimal.ZERO);// 准贷记卡透支180天以上累计金额
		obj.setSemiOverdrawnBalance(BigDecimal.ZERO);// 准贷记卡当前累计透支余额
		obj.setHousingFund("Y");// 有无住房公积金
		obj.setCreditReportRemark("银行征信报告备注");// 银行征信报告备注
		obj.setCreditApplyTime(new Date());// 征信申请时间
		obj.setCreditAuditTime(new Date());// 征信审核时间
		// obj.setCtime (fss_credit.getCtime());// 创建时间
		// obj.setMtime (fss_credit.getMtime());// 修改时间
		obj.setRemark("test");// 备注

		return obj;
	}
	
	

	@Test
	public void testInsert() {

		Result<Long> result=fssCreditService.insertFssCreditAndCreditSearching(createFssCreditModel());
		System.out.println(JSON.toJSONString(result));
	}
	@Test
	public void testfFssCreditRiskService()
	{
		Result<FssCreditRiskModel>  result = fssCreditRiskService.getFssCreditRiskAndDetailByCreditId(65L);
		System.out.println(JSON.toJSONString(result));
		Assert.assertTrue(true);
	}
	
}
