package com.yundian.fss.test.loan;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yundian.fss.manager.FssLoanManager;
import com.yundian.fss.test.AbstractJUnit;
import com.yundian.fssapi.domain.FssLoanAuditingLogModel;
import com.yundian.fssapi.domain.FssLoanDocumentModel;
import com.yundian.fssapi.domain.FssLoanModel;
import com.yundian.fssapi.domain.FssLoanRelationModel;
import com.yundian.fssapi.domain.FssOrganizationUserModel;
import com.yundian.fssapi.domain.FssUserModel;
import com.yundian.fssapi.domain.query.FssLoanQueryModel;
import com.yundian.fssapi.domain.statistics.LoanCompareStatModel;
import com.yundian.fssapi.domain.statistics.LoanTypeMonthTrendStatModel;
import com.yundian.fssapi.domain.statistics.LoanTypeStatItemModel;
import com.yundian.fssapi.dto.FssLoanAuditStatusStatisticsResult;
import com.yundian.fssapi.dto.param.FssLoanQueryParam;
import com.yundian.fssapi.enums.FssLoanAuditStatusEnum;
import com.yundian.fssapi.enums.FssLoanDealwithStatusEnum;
import com.yundian.fssapi.enums.FssLoanDocumentFileTypeEnum;
import com.yundian.fssapi.enums.FssLoanLoanTypeEnum;
import com.yundian.fssapi.enums.FssLoanRelationIdTypeEnum;
import com.yundian.fssapi.enums.FssLoanRelationRelationTypeEnum;
import com.yundian.fssapi.enums.FssLoanRelationWithEnum;
import com.yundian.fssapi.enums.FssLoanSexEnum;
import com.yundian.fssapi.service.FssLoanService;
import com.yundian.result.PaginatedResult;
import com.yundian.result.Paginator;
import com.yundian.result.Result;
import com.yundian.toolkit.utils.DateUtils;

public class FssLoanServiceTest extends AbstractJUnit {

	@Autowired
	private FssLoanManager fssLoanManager;

	@Autowired
	private FssLoanService fssLoanService;
	@Test
	public void testgetPaginatorFssLoan(){
		FssLoanQueryParam obj=new FssLoanQueryParam();
		obj.setBankId(1L);
//		obj.setGuaranteeId(1);
//		obj.setLoanCode ("L00000000000000001");// 贷款编号
//		obj.setLoanType (FssLoanLoanTypeEnum.PURCHASE_CAR_TERM.code());// 贷款类型:1购车分期
//		obj.setName ("借款人");// 借款人
//		obj.setIdcard ("469002198702126584");// 借款人身份证
//		obj.setPhone ("13800000000");// 借款人手机号码
//		obj.setSex (FssLoanSexEnum.F.name());// 性别
//		obj.setDealwithStatus(FssLoanDealwithStatusEnum.HAVE_TODO.code());
		obj.setSignTimeStart("2016-07-08");
		Paginator<FssLoanQueryParam> paginator=new Paginator<FssLoanQueryParam>(1,10,obj);
		PaginatedResult<FssLoanQueryModel> paginatedResult=this.fssLoanManager.getPaginatorFssLoan(paginator);
		String result =JSON.toJSONString(paginatedResult);
		System.out.println(result);
	}
	@Test
	public void testInsertFssLoan(){
		FssLoanModel obj=new FssLoanModel();
//		obj.setLoanId (fss_loan.getLoanId());// 
//		obj.setBankId (fss_loan.getBankId());// 银行id
		obj.setGuaranteeId (1L);// 担保公司id
//		obj.setGuaranteeName (fss_loan.getGuaranteeName());// 担保机构名称
		obj.setGuaranteeUserId (1L);// 担保机构业务员id
//		obj.setGuaranteeUserName (fss_loan.getGuaranteeUserName());// 担保机构业务员姓名
		obj.setLoanCode ("L"+DateUtils.format(new Date(), "yyyyMMddHHmmssSSS"));// 贷款编号
		obj.setLoanType (FssLoanLoanTypeEnum.PURCHASE_CAR_TERM.code());// 贷款类型:1购车分期
		obj.setName ("借款人");// 借款人
		obj.setIdcard ("469002198702126584");// 借款人身份证
		obj.setPhone ("13800000000");// 借款人手机号码
		obj.setSex (FssLoanSexEnum.F.name());// 性别
		obj.setCommonRepaymentCount (0);// 共同还款人数
		obj.setGuaranteeCount (0);// 担保人数
		obj.setSignTime (new Date());// 签约时间
		obj.setAuditStatus (FssLoanAuditStatusEnum.UNSUBMIT.code());// 审核状态:0未提交，1待审核，2通过，3不通过，4退回
		obj.setDealwithStatus(FssLoanDealwithStatusEnum.UN_TODO.code());
//		obj.setAuditTime (fss_loan.getAuditTime());// 审核时间
//		obj.setCtime (fss_loan.getCtime());// 
//		obj.setMtime (fss_loan.getMtime());// 
//		obj.setRemark (fss_loan.getRemark());// 
		
		obj.setLoanRelationList(this.createFssLoanRelationModel());
		obj.setLoanAllDocumentList(this.createDocumentModel2());
		Long result=fssLoanManager.insertFssLoan(obj);
		
		System.out.println(result);
		
		FssLoanModel fssLoanModel=fssLoanManager.getFssLoanById(result);
		
		System.out.println(JSON.toJSON(fssLoanModel));
		try {
			Thread.sleep(2000l);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	private List<FssLoanRelationModel> createFssLoanRelationModel(){
		List<FssLoanRelationModel> fssLoanRelationModels=new ArrayList<FssLoanRelationModel>();
		FssLoanRelationModel obj=new FssLoanRelationModel();

//		obj.setRelationId (fss_loan_relation.getRelationId());// 
//		obj.setLoanId (fss_loan_relation.getLoanId());// 贷款id
		obj.setRelationName ("李莉莉");// 关系人姓名
		obj.setRelationType (FssLoanRelationRelationTypeEnum.MAIN_LOAN_PERSON.code());// 关系人类型：主贷人，担保人，共同还款人
		obj.setRelationTypeName (FssLoanRelationRelationTypeEnum.MAIN_LOAN_PERSON.desc());// 关系人类型名称
		obj.setIdType (FssLoanRelationIdTypeEnum.ID.code());// 证件类型
		obj.setIdcard ("123456789067890");// 证件号码
		obj.setSex (FssLoanSexEnum.F.code());// 性别：1男，0女
		obj.setPhone ("13900010112");// 手机号码
		obj.setRelationWith (FssLoanRelationWithEnum.SPOUSE.code());// 与主贷人关系：兄弟、配偶、父母等
		obj.setRelationWithName (FssLoanRelationWithEnum.SPOUSE.desc());// 与主贷人关系名称
		obj.setRemark ("备注");//
		obj.setLoanDocumentList(this.createDocumentModel());
		fssLoanRelationModels.add(obj);
		return fssLoanRelationModels;
	}
	private List<FssLoanDocumentModel> createDocumentModel(){
		List<FssLoanDocumentModel> documentModels=new ArrayList<FssLoanDocumentModel>();
		FssLoanDocumentModel documentModel=new FssLoanDocumentModel();
//		documentModel.setLoanId (fss_loan_document.getLoanId());// 贷款id
//		documentModel.setRelationId (fss_loan_document.getRelationId());// 关系人id
		documentModel.setDocumentType ("faceRrecognitionPic");// 分类：身份证正面、身份证反面、征信授权书、人脸识别照片、面签照片、面签视频、公安网照片
		documentModel.setFileName ("测试文件名.png");// 文档显示名称
		documentModel.setFileType (FssLoanDocumentFileTypeEnum.IMAGE.code());// 文件类型：1图片，2视频，3其他文档
		documentModel.setFileUrl ("https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=1665048006,3017566722&fm=58");// 文件地址
		documentModel.setFileSize (10F);// 文件大小，单位KB
		documentModel.setRemark ("remark");// 
		documentModels.add(documentModel);
		return documentModels;
	}
	
	private List<FssLoanDocumentModel> createDocumentModel2(){
		List<FssLoanDocumentModel> documentModels=new ArrayList<FssLoanDocumentModel>();
		FssLoanDocumentModel documentModel=new FssLoanDocumentModel();
//		documentModel.setLoanId (fss_loan_document.getLoanId());// 贷款id
//		documentModel.setRelationId (fss_loan_document.getRelationId());// 关系人id
		documentModel.setDocumentType ("faceSignVideo");// 分类：身份证正面、身份证反面、征信授权书、人脸识别照片、面签照片、面签视频、公安网照片
		documentModel.setFileName ("测试文件名.png");// 文档显示名称
		documentModel.setFileType (FssLoanDocumentFileTypeEnum.IMAGE.code());// 文件类型：1图片，2视频，3其他文档
		documentModel.setFileUrl ("https://player.vimeo.com/video/1132937?title=0&amp;byline=0&amp;portrait=0");// 文件地址
		documentModel.setFileSize (10F);// 文件大小，单位KB
		documentModel.setRemark ("remark");// 
		documentModels.add(documentModel);
	

		FssLoanDocumentModel doc=new FssLoanDocumentModel();
//		documentModel.setLoanId (fss_loan_document.getLoanId());// 贷款id
//		documentModel.setRelationId (fss_loan_document.getRelationId());// 关系人id
		doc.setDocumentType ("faceSignVideo");// 分类：身份证正面、身份证反面、征信授权书、人脸识别照片、面签照片、面签视频、公安网照片
		doc.setFileName ("测试文件名.png");// 文档显示名称
		doc.setFileType (FssLoanDocumentFileTypeEnum.IMAGE.code());// 文件类型：1图片，2视频，3其他文档
		doc.setFileUrl ("https://player.vimeo.com/video/1132937?title=0&amp;byline=0&amp;portrait=0");// 文件地址
		doc.setFileSize (10F);// 文件大小，单位KB
		doc.setRemark ("remark");// 
		documentModels.add(doc);

		
		FssLoanDocumentModel documentModel2=new FssLoanDocumentModel();
//		documentModel.setLoanId (fss_loan_document.getLoanId());// 贷款id
//		documentModel.setRelationId (fss_loan_document.getRelationId());// 关系人id
		documentModel2.setDocumentType ("faceSignVideo");// 分类：身份证正面、身份证反面、征信授权书、人脸识别照片、面签照片、面签视频、公安网照片
		documentModel2.setFileName ("测试文件名.png");// 文档显示名称
		documentModel2.setFileType (FssLoanDocumentFileTypeEnum.VIDEO.code());// 文件类型：1图片，2视频，3其他文档
		documentModel2.setFileUrl ("https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=1665048006,3017566722&fm=58");// 文件地址
		documentModel2.setFileSize (10F);// 文件大小，单位KB
		documentModel2.setRemark ("remark");// 
		documentModels.add(documentModel2);
		return documentModels;
	}
	
	@Test
	public void testSubmitLoan(){
		FssLoanAuditingLogModel fssLoanAuditingLogModel=new FssLoanAuditingLogModel();
		fssLoanAuditingLogModel.setLoanId(34L);
		fssLoanAuditingLogModel.setAuditContent("请审核");
		FssUserModel fssUserModel=new FssUserModel();
		fssUserModel.setUserId(1L);
		fssUserModel.setName("金宁夏");
	    Integer result = fssLoanManager.submitLoanApprove(fssUserModel, fssLoanAuditingLogModel);
	    System.out.println(result);
	}

	
	@Test
	public void testApprovePass(){
		FssLoanAuditingLogModel fssLoanAuditingLogModel=new FssLoanAuditingLogModel();
		fssLoanAuditingLogModel.setLoanId(34L);
		fssLoanAuditingLogModel.setAuditContent("审核通过");
		FssOrganizationUserModel fssOrganizationUserModel=new FssOrganizationUserModel();
		fssOrganizationUserModel.setOrguserId(1L);
		fssOrganizationUserModel.setName("金宁夏");
	    Integer result = fssLoanManager.approvePass(fssOrganizationUserModel, fssLoanAuditingLogModel);
	    System.out.println(result);
	}
	
	@Test
	public void testApproveReject(){
		FssLoanAuditingLogModel fssLoanAuditingLogModel=new FssLoanAuditingLogModel();
		fssLoanAuditingLogModel.setLoanId(33l);
		fssLoanAuditingLogModel.setAuditContent("审核不通过");
		FssOrganizationUserModel fssOrganizationUserModel=new FssOrganizationUserModel();
		fssOrganizationUserModel.setOrguserId(1L);
		fssOrganizationUserModel.setName("金宁夏");
	    Integer result = fssLoanManager.approveReject(fssOrganizationUserModel, fssLoanAuditingLogModel);
	    System.out.println(result);
	}
	
	@Test
	public void testgetFssLoanStatisticsCountByAuditStatus(){

		FssLoanQueryParam fssLoanQueryParam =new FssLoanQueryParam();
		fssLoanQueryParam.setBankId(1L);
		fssLoanQueryParam.setGuaranteeId(1L);
		fssLoanQueryParam.setGuaranteeUserId(1L);
		fssLoanQueryParam.setSignTimeStart("2016-6-1");
		fssLoanQueryParam.setSignTimeEnd("2016-9-1");
		
		FssLoanAuditStatusStatisticsResult result=
				this.fssLoanManager.getFssLoanStatisticsCountByAuditStatus(fssLoanQueryParam);
		System.out.println(JSON.toJSONString( result));
	}
	
	@Test
	public void testloanTypeStat(){
		
		Result<List<LoanTypeStatItemModel>> result= this.fssLoanService.loanTypeStat(100L,1L,"2016-07-04", "2016-10-30");
		System.out.println(JSONObject.toJSON(result));
	}
	
	@Test
	public void testloanCompareStat(){
		Result<LoanCompareStatModel> result= this.fssLoanService.loanCompareStat(100L,1L,"2016-11-01");
		System.out.println(JSONObject.toJSON(result));
	}
	
	@Test
	public void testloanTypeCompareStat(){
		Result<LoanTypeMonthTrendStatModel> result= this.fssLoanService.loanTypeCompareStat(100L,1L,"2016-09-01", "2016-9-30");
		System.out.println(JSONObject.toJSON(result));
	}
}
