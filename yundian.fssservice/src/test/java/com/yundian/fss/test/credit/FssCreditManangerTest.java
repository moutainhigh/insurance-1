package com.yundian.fss.test.credit;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONObject;
import com.yundian.fss.manager.FssCreditLogMananger;
import com.yundian.fss.manager.FssCreditMananger;
import com.yundian.fss.test.AbstractJUnit;
import com.yundian.fssapi.domain.FssCreditLogModel;
import com.yundian.fssapi.domain.FssCreditModel;
import com.yundian.fssapi.dto.param.FssCreditQueryParam;
import com.yundian.fssapi.enums.FssCreditStatusEnum;
import com.yundian.result.PaginatedResult;
import com.yundian.result.Paginator;

public class FssCreditManangerTest extends AbstractJUnit {

	@Autowired
	FssCreditMananger fssCreditMananger;
	@Autowired
	FssCreditLogMananger fssCreditLogMananger;
	
	public static FssCreditModel createFssCreditModel() {

		FssCreditModel obj = new FssCreditModel();

		// obj.setCreditId (fss_credit.getCreditId());// 主键ID
		obj.setGuaranteeId(1L);// 合作机构ID
		obj.setGuaranteeName("合作机构名称");//
		obj.setGuaranteeUserId(1L);// ID
		obj.setGuaranteeUserName("张三");// 合作机构业务员姓名
		obj.setGuaranteeUserPhone("13555226644");// 合作机构业务员手机号码
		obj.setBankId(1L);// 银行id
		obj.setBankName("银行名称");// 银行名称
		obj.setBankCode("银行编号");//
		obj.setName("姓名");//
		obj.setSex("F");// 性别
		obj.setIdcard("130323197211294224");// 身份证号
		obj.setPhone("13555226644");// 手机号码
		obj.setBirthday("1987-08-08");// 出生年月
		obj.setCardFrontimg("http://imgditan2012.cang.com/201206/15/2012061506454362912764.jpg");// 身份证正面照片
		obj.setCardOppositeimg("http://hiphotos.baidu.com/exp/pic/item/c9bdddcec3fdfc039a27720ad63f8794a5c226e1.jpg");// 身份证反面照片
		obj.setRequisitionSignImg("http://www.wdw88.com/upload/project/original/201601/31/160131201910526.jpg");// 征信授权书亲签照片
		obj.setOriginalImg("http://www.wdw88.com/upload/project/original/201601/31/160131201910526.jpg");// 征信授权书原件照片
		obj.setCreditStatus(FssCreditStatusEnum.SUBMITED.code());// 征信状态
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
	
	public static FssCreditLogModel createFssCreditLogModel(){
		FssCreditLogModel obj=new FssCreditLogModel();

//		obj.setId (fss_credit_log.getId());// 主键ID
//		obj.setCreditId (fss_credit_log.getCreditId());// 征信申请id
		obj.setNode (FssCreditStatusEnum.SUBMITED.code());// 节点编号
		obj.setNodeName (FssCreditStatusEnum.SUBMITED.name());// 节点名称
		obj.setBankId (1L);// 银行id
		obj.setBankName ("银行名称");// 银行名称
		obj.setBankUserId (1L);// 银行审核人id
		obj.setBankUserName ("张三");// 银行审核人姓名
		obj.setAuditStatus (FssCreditStatusEnum.SUBMITED.code());// 审核状态
		obj.setAuditContent ("审核内容");// 审核内容
		obj.setAuditTime (null);// 审核时间
//		obj.setCtime (fss_credit_log.getCtime());// 创建时间
//		obj.setMtime (fss_credit_log.getMtime());// 修改时间
		obj.setRemark ("备注");// 备注
		
		return obj;
	}
	

	@Test
	public void testInsert() {
		for(int i=0;i<30;i++){
			Long creditId=fssCreditMananger.insertFssCredit(createFssCreditModel());
//			FssCreditLogModel creditLogModel=createFssCreditLogModel();
			/*creditLogModel.setCreditId(creditId);
			this.fssCreditLogMananger.insertFssCreditLog(creditLogModel);*/
			System.out.println(creditId);
		}
	}
	
	@Test
	public void testgetPaginatorFssCredit(){
		Paginator<FssCreditQueryParam> paginator=new Paginator<FssCreditQueryParam>(1,10);
		FssCreditQueryParam obj=new FssCreditQueryParam();
		obj.setGuaranteeId(1L);// 合作机构ID
		obj.setGuaranteeName("合作机构名称");//
		obj.setGuaranteeUserId(1L);// ID
		obj.setGuaranteeUserName("张三");// 合作机构业务员姓名
		obj.setGuaranteeUserPhone("13555226644");// 合作机构业务员手机号码
		obj.setBankId(1L);// 银行id
		obj.setBankName("银行名称");// 银行名称
		obj.setBankCode("银行编号");//
		obj.setName("姓名");//
		obj.setSex("F");// 性别
		obj.setIdcard("130323197211294224");// 身份证号
		obj.setPhone("13555226644");// 手机号码
		obj.setBirthday("1987-08-08");// 出生年月
		obj.setCardFrontimg("http://imgditan2012.cang.com/201206/15/2012061506454362912764.jpg");// 身份证正面照片
		obj.setCardOppositeimg("http://hiphotos.baidu.com/exp/pic/item/c9bdddcec3fdfc039a27720ad63f8794a5c226e1.jpg");// 身份证反面照片
		obj.setRequisitionSignImg("http://www.wdw88.com/upload/project/original/201601/31/160131201910526.jpg");// 征信授权书亲签照片
		obj.setOriginalImg("http://www.wdw88.com/upload/project/original/201601/31/160131201910526.jpg");// 征信授权书原件照片
		obj.setCreditStatus(FssCreditStatusEnum.SUBMITED.code());// 征信状态
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
		obj.setCreditApplyTimeStart("2014-01-10");// 征信申请时间
		obj.setCreditApplyTimeEnd("2017-01-10");// 征信申请时间

		obj.setCreditAuditTime(new Date());// 征信审核时间
		// obj.setCtime (fss_credit.getCtime());// 创建时间
		// obj.setMtime (fss_credit.getMtime());// 修改时间
		obj.setRemark("test");// 备注

		paginator.setParam(obj);
		PaginatedResult<FssCreditModel>  paginatedResult= fssCreditMananger.getPaginatorFssCredit(paginator);	
		System.out.println(JSONObject.toJSON(paginatedResult));
	}
	
	@Test
	public void testgetFssCreditLogListByCreditId(){
		List<FssCreditLogModel> list = fssCreditLogMananger.getFssCreditLogListByCreditId(1L);
		System.out.println(list);
	}
}
