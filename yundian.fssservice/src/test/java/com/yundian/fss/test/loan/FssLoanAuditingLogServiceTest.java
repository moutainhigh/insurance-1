package com.yundian.fss.test.loan;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.yundian.fss.test.AbstractJUnit;
import com.yundian.fssapi.domain.FssLoanAuditingLogModel;
import com.yundian.fssapi.domain.query.FssLoanAuditingLogQueryModel;
import com.yundian.fssapi.service.FssLoanAuditingLogService;
import com.yundian.result.PaginatedResult;
import com.yundian.result.Paginator;
import com.yundian.result.Result;

public class FssLoanAuditingLogServiceTest extends AbstractJUnit {
	@Autowired
	private FssLoanAuditingLogService fssLoanAuditingLogService;

	@Test
	public void testinsertFssLoanAuditingLog(){
		FssLoanAuditingLogModel obj=new FssLoanAuditingLogModel();
		
//		obj.setLogId (fss_loan_auditing_log.getLogId());// 
		obj.setLoanId (1L);// 贷款id
		obj.setNode ("node");// 审核节点编号
		obj.setNodeName ("节点名称");// 审核节点名称
		obj.setOrganizationId (1L);// 审核机构id
		obj.setGuaranteeId (1L);// 担保机构id
		obj.setOrguserId (1L);// 审核人id
		obj.setOrguserName ("hehaibo");// 审核人姓名
		obj.setAuditStatus ("hhh");// 审核状态:通过，不通过，退回
		obj.setAuditTime (new Date());// 审核时间
		obj.setAuditContent ("111");// 审核内容
//		obj.setCtime (fss_loan_auditing_log.getCtime());// 
//		obj.setMtime (fss_loan_auditing_log.getMtime());// 
		obj.setRemark ("remark");// 
		Result<Integer>  result=
				this.fssLoanAuditingLogService.insertFssLoanAuditingLog(obj);
		System.out.println(JSON.toJSON(result));
	}
	@Test
	public void testgetPaginatorFssLoanAuditingLog() {
		Paginator<FssLoanAuditingLogModel> paginator = new Paginator<FssLoanAuditingLogModel>();
		paginator.setCurrentPage(1);
		paginator.setPageSize(10);
		FssLoanAuditingLogModel obj=new FssLoanAuditingLogModel();
		
//		obj.setLogId (fss_loan_auditing_log.getLogId());// 
		obj.setLoanId (1L);// 贷款id
		obj.setNode ("node");// 审核节点编号
		obj.setNodeName ("节点名称");// 审核节点名称
		obj.setOrganizationId (1L);// 审核机构id
		obj.setGuaranteeId (1L);// 担保机构id
		obj.setOrguserId (1L);// 审核人id
		obj.setOrguserName ("hehaibo");// 审核人姓名
		obj.setAuditStatus ("hhh");// 审核状态:通过，不通过，退回
		obj.setAuditTime (new Date());// 审核时间
		paginator.setParam(obj);
		
		
		Result<PaginatedResult<FssLoanAuditingLogQueryModel>> result = fssLoanAuditingLogService
				.getPaginatorFssLoanAuditingLog(paginator);
		System.out.println(JSON.toJSON(result));
	}
}
