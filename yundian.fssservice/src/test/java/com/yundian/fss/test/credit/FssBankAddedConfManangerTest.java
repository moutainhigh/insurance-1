package com.yundian.fss.test.credit;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.yundian.fss.manager.FssBankAddedConfMananger;
import com.yundian.fss.test.AbstractJUnit;
import com.yundian.fssapi.domain.FssBankAddedConfModel;

public class FssBankAddedConfManangerTest extends AbstractJUnit {

	@Autowired
	private FssBankAddedConfMananger fssBankAddedConfMananger;
	
	public static FssBankAddedConfModel createFssBankAddedConf(){
		FssBankAddedConfModel obj=new FssBankAddedConfModel();

//		obj.setId (fss_bank_added_conf.getId());// 主键ID
		obj.setBankId (1L);// 银行id
		obj.setBankName ("银行名称");// 银行名称
		obj.setHaveCreditCollect ("Y");// 征信申请采集
		obj.setCreditCollectPrice (12);// 征信申请采集价格
		obj.setHaveRiskSearching ("Y");// 风险信息查询
		obj.setRiskSearchingPrice (23);// 风险信息查询价格
		obj.setHaveFaceMatching ("Y");// 人脸识别功能
		obj.setFaceMatchingPrice (32);// 人脸识别功能价格
		obj.setHaveIdentityVerification ("Y");// 公安身份核验
		obj.setIdentityVerificationPrice (21);// 公安身份核验价格
//		obj.setCtime (fss_bank_added_conf.getCtime());// 创建时间
//		obj.setMtime (fss_bank_added_conf.getMtime());// 修改时间
		obj.setRemark ("remark");// 备注
		
		return obj;
	}
	
	
	@Test
	public void testinsertFssBankAddedConf(){
		Long id=fssBankAddedConfMananger.insertFssBankAddedConf(createFssBankAddedConf());
		System.out.println(id);
	}
	
	@Test
	public void testgetFssBankAddedConfByBankId(){
		FssBankAddedConfModel fssBankAddedConfModel=this.fssBankAddedConfMananger.getFssBankAddedConfByBankId(1L);
		System.out.println(fssBankAddedConfModel);
	}
}
