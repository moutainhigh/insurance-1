package com.yundian.fss.manager;

import java.util.List;

import com.yundian.fssapi.domain.FssDictionaryModel;
import com.yundian.result.PaginatedResult;
import com.yundian.result.Paginator;

/**
 * 数据字典服务
 * 
 * @author haibo.he
 * @version $Id: FssDictionaryService.java, v 0.1 2016年7月26日 下午8:59:44 haibo.he Exp $
 */
public interface FssDictionaryManager {
	Integer insertFssDictionary (FssDictionaryModel fssDictionaryModel);
	
	Integer updateFssDictionary(FssDictionaryModel fssDictionaryModel);
			
	Integer deleteFssDictionaryById ( Long id );
																																							
	FssDictionaryModel getFssDictionaryById(Integer id);

	List<FssDictionaryModel> getFssDictionaryList(FssDictionaryModel fssDictionaryModel);

	PaginatedResult<FssDictionaryModel> getPaginatorFssDictionary(
            Paginator<FssDictionaryModel> paginator);

	FssDictionaryModel getFssDictionaryByTypeAndItemCode(String dictTypeCode,
			String itemCode);
}
