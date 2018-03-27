package com.yundian.fss.test.credit;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.yundian.fss.manager.FssCreditRiskMananger;
import com.yundian.fss.test.AbstractJUnit;
import com.yundian.fssapi.domain.FssCreditRiskModel;

public class FssCreditRiskManangerTest extends AbstractJUnit {

	@Autowired
	private FssCreditRiskMananger fssCreditRiskMananger;
	
	@Test
	public void testgetFssCreditRiskAndDetailByCreditId(){
		FssCreditRiskModel fssCreditRiskModel= this.fssCreditRiskMananger.getFssCreditRiskAndDetailByCreditId(1l);
		System.out.println(fssCreditRiskModel);
	}
}
