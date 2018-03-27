package com.yundian.fss.test.loan;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.yundian.fss.test.AbstractJUnit;
import com.yundian.fssapi.domain.FssLoanAuditingLogModel;
import com.yundian.fssapi.domain.FssLoanDocumentModel;
import com.yundian.fssapi.service.FssLoanDocumentService;
import com.yundian.result.PaginatedResult;
import com.yundian.result.Paginator;
import com.yundian.result.Result;

public class FssLoanDocumentServiceTest extends AbstractJUnit {
	@Autowired
	private FssLoanDocumentService fssLoanDocumentService;

	@Test
	public void testinsertFssLoanAuditingLog(){
		FssLoanDocumentModel obj=new FssLoanDocumentModel();
		
//		FssLoanDocumentDO obj=new FssLoanDocumentDO();

//		obj.setId (fss_loan_document.getId());// 
		obj.setLoanId (1L);// 贷款id
		obj.setRelationId (1L);// 关系人id
		obj.setDocumentType ("test");// 分类：身份证正面、身份证反面、征信授权书、人脸识别照片、面签照片、面签视频、公安网照片
		obj.setFileName ("test");// 文档显示名称
		obj.setFileType ("IMAGE");// 文件类型：1图片，2视频，3其他文档
		obj.setFileUrl ("localhost");// 文件地址
		obj.setFileSize (10.5f);// 文件大小，单位KB
//		obj.setCtime (fss_loan_document.getCtme());// 
//		obj.setMtime (fss_loan_document.getMtime());// 
//		obj.setRemark (fss_loan_document.getRemark());// 
		Result<Integer>  result=
				this.fssLoanDocumentService.insertFssLoanDocument(obj);
		System.out.println(JSON.toJSON(result));
	}
	@Test
	public void testgetFssLoanDocumentListByLoanId(){
		Result<List<FssLoanDocumentModel>> result=
				this.fssLoanDocumentService.getFssLoanDocumentListByLoanId(1L);
		System.out.println(JSON.toJSON(result));
	}
//	@Test
//	public void testgetPaginatorFssLoanAuditingLog() {
//		Paginator<FssLoanAuditingLogModel> paginator = new Paginator<FssLoanAuditingLogModel>();
//		paginator.setCurrentPage(1);
//		paginator.setPageSize(10);
//		FssLoanAuditingLogModel obj=new FssLoanAuditingLogModel();
//		
////		obj.setLogId (fss_loan_auditing_log.getLogId());// 
//		obj.setLoanId (1L);// 贷款id
//		obj.setNode ("node");// 审核节点编号
//		obj.setNodeName ("节点名称");// 审核节点名称
//		obj.setOrganizationId (1);// 审核机构id
//		obj.setGuaranteeId (1);// 担保机构id
//		obj.setOrguserId (1);// 审核人id
//		obj.setOrguserName ("hehaibo");// 审核人姓名
//		obj.setAuditStatus ("hhh");// 审核状态:通过，不通过，退回
//		obj.setAuditTime (new Date());// 审核时间
//		paginator.setParam(obj);
//		
//		
//		Result<PaginatedResult<FssLoanAuditingLogModel>> result = fssLoanAuditingLogService
//				.getPaginatorFssLoanAuditingLog(paginator);
//		System.out.println(JSON.toJSON(result));
//	}
}
