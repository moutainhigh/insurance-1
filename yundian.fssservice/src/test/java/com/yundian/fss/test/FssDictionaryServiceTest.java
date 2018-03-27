package com.yundian.fss.test;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.yundian.fss.manager.FssDictionaryManager;
import com.yundian.fssapi.domain.FssDictionaryModel;
import com.yundian.fssapi.service.FssDictionaryService;
import com.yundian.result.Result;

public class FssDictionaryServiceTest extends AbstractJUnit {

	@Autowired
	private FssDictionaryManager fssDictionaryManager;

	@Test
	public void testgetFssDictionaryList() {
		
		FssDictionaryModel fssDictionaryModel = new FssDictionaryModel();
		fssDictionaryModel.setDictTypeCode("test");
		
		List<FssDictionaryModel> result = this.fssDictionaryManager
				.getFssDictionaryList(fssDictionaryModel);
		System.out.println(JSON.toJSONString(result));
	}
}
