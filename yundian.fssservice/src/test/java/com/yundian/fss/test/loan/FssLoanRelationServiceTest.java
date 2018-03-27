package com.yundian.fss.test.loan;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.yundian.fss.test.AbstractJUnit;
import com.yundian.fssapi.domain.FssLoanDocumentModel;
import com.yundian.fssapi.domain.FssLoanRelationModel;
import com.yundian.fssapi.enums.FssLoanDocumentFileTypeEnum;
import com.yundian.fssapi.enums.FssLoanRelationIdTypeEnum;
import com.yundian.fssapi.enums.FssLoanRelationRelationTypeEnum;
import com.yundian.fssapi.enums.FssLoanRelationWithEnum;
import com.yundian.fssapi.enums.FssLoanSexEnum;
import com.yundian.fssapi.service.FssLoanRelationService;
import com.yundian.result.Result;

public class FssLoanRelationServiceTest extends AbstractJUnit {
	@Autowired
	private FssLoanRelationService fssLoanRelationService;
	
	private FssLoanRelationModel createFssLoanRelationModel(){
		FssLoanRelationModel obj=new FssLoanRelationModel();

//		obj.setRelationId (fss_loan_relation.getRelationId());// 
		obj.setLoanId (1L);// 贷款id
		obj.setRelationName ("李莉莉");// 关系人姓名
		obj.setRelationType (FssLoanRelationRelationTypeEnum.MAIN_LOAN_PERSON.code());// 关系人类型：主贷人，担保人，共同还款人
		obj.setRelationTypeName (FssLoanRelationRelationTypeEnum.MAIN_LOAN_PERSON.desc());// 关系人类型名称
		obj.setIdType (FssLoanRelationIdTypeEnum.ID.code());// 证件类型
		obj.setIdcard ("123456789067890");// 证件号码
		obj.setSex (FssLoanSexEnum.F.code());// 性别：1男，0女
		obj.setPhone ("139000101112");// 手机号码
		obj.setRelationWith (FssLoanRelationWithEnum.SPOUSE.code());// 与主贷人关系：兄弟、配偶、父母等
		obj.setRelationWithName (FssLoanRelationWithEnum.SPOUSE.desc());// 与主贷人关系名称
		obj.setRemark ("备注");//
		return obj;
	}
	private List<FssLoanDocumentModel> createDocumentModel(){
		List<FssLoanDocumentModel> documentModels=new ArrayList<FssLoanDocumentModel>();
		FssLoanDocumentModel documentModel=new FssLoanDocumentModel();
		documentModel.setLoanId (1L);// 贷款id
//		documentModel.setRelationId (fss_loan_document.getRelationId());// 关系人id
		documentModel.setDocumentType ("111");// 分类：身份证正面、身份证反面、征信授权书、人脸识别照片、面签照片、面签视频、公安网照片
		documentModel.setFileName ("测试文件名.png");// 文档显示名称
		documentModel.setFileType (FssLoanDocumentFileTypeEnum.IMAGE.code());// 文件类型：1图片，2视频，3其他文档
		documentModel.setFileUrl ("https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=1665048006,3017566722&fm=58");// 文件地址
		documentModel.setFileSize (10F);// 文件大小，单位KB
		documentModel.setRemark ("remark");// 
		documentModels.add(documentModel);
		return documentModels;
	}
	
	@Test
	public void insertFssLoanRelation(){
		FssLoanRelationModel fssLoanRelationModel=this.createFssLoanRelationModel();
		fssLoanRelationModel.setLoanDocumentList(this.createDocumentModel());
		Result<Integer> result=
				this.fssLoanRelationService.insertFssLoanRelation(fssLoanRelationModel);
		System.out.println(JSON.toJSON(result));
	}
	@Test
	public void testgetFssLoanRelationListByLoanId(){
		Result<List<FssLoanRelationModel>> result=
				this.fssLoanRelationService.getFssLoanRelationListByLoanId(1L);
		System.out.println(JSON.toJSON(result));
	}
	
	@Test
	public void testgetFssLoanRelationAndDocumentListByLoanId(){
		Result<List<FssLoanRelationModel>> result=
				this.fssLoanRelationService.getFssLoanRelationAndDocumentListByLoanId(1L);
		System.out.println(JSON.toJSON(result));
	}
	
	@Test
	public void testgetFssLoanRelationreAndCognitionByLoanId(){
		Result<List<FssLoanRelationModel>> result=
				this.fssLoanRelationService.getFssLoanRelationAndRecognitionByLoanId(135L);
		System.out.println(JSON.toJSON(result));
	}
}
