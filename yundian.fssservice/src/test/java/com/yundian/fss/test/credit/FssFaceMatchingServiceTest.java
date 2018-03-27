package com.yundian.fss.test.credit;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.yundian.fss.test.AbstractJUnit;
import com.yundian.fssapi.service.FssFaceMatchingService;
import com.yundian.fssapi.service.dto.FaceMatchingResult;
import com.yundian.result.Result;

public class FssFaceMatchingServiceTest extends AbstractJUnit{

	@Autowired
	FssFaceMatchingService fssFaceMatchingService;
	
	@Test
	public void testFaceMathing()
	{
		String name="金宁夏";
		String cardId="330327198312251714";
		byte[] photoData=null;
		Long relationId=184L;
		File file2 = new File("E:\\work\\IMG_0089_new_fixed.jpg");
		 try {
		    FileInputStream fis = new FileInputStream(file2);
		    photoData = new byte[(int) file2.length()];
			fis.read(photoData);
			fis.close();
	    } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Result<FaceMatchingResult>  result =fssFaceMatchingService.checkFaceMatching(relationId,name, cardId, photoData);
		
		System.out.println(JSON.toJSONString(result));
		//{"code":10000,"data":{"cardId":"330327198312251714","isNameValid":"姓名和证件号码一致 ","isPhotoCompared":"已比对","name":"金宁夏","similarity":59,"validateResult":"建议通过 "},"success":true}
	}
}
