package com.yundian.fssapi.service;

import java.util.List;

import com.yundian.fssapi.domain.FssDictionaryModel;
import com.yundian.result.Result;

/**
 * 数据字典服务
 * 
 * @author haibo.he
 * @version $Id: FssDictionaryService.java, v 0.1 2016年7月26日 下午8:59:44 haibo.he Exp $
 */
public interface FssDictionaryService {
	
	Result<FssDictionaryModel> getFssDictionaryById(Integer id);

	/**
	 * 获取某个数据字典
	 * @param dictTypeCode
	 * @param itemCode
	 * @return
	 */
	Result<FssDictionaryModel> getFssDictionaryByTypeAndItemCode(String dictTypeCode,String itemCode);

	/**
	 * FssDictionaryModel #dictTypeCode 字段不能为空
	 * @see FssDictionaryModel#setDictTypeCode(String) 
	 * @param fssDictionaryModel
	 * @return
	 */
	
	Result<List<FssDictionaryModel>> getFssDictionaryList(FssDictionaryModel fssDictionaryModel);
	
}
