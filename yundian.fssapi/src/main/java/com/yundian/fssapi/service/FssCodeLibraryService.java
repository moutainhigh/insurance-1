package com.yundian.fssapi.service;

import java.util.List;

import com.yundian.fssapi.domain.FssCodeLibraryModel;
import com.yundian.result.PaginatedResult;
import com.yundian.result.Paginator;
import com.yundian.result.Result;

/**
 *
 *字典服务
 */
public interface FssCodeLibraryService {


	/**
	 * 获取指定类别和code的字典
	 * @param codeType 类别
	 * @param code
	 * @return
	 */
	FssCodeLibraryModel getFssCodeLibraryByCode(String codeType,String code);

	/**
	 * 获取指定类别的字典列表
	 * @param codeType
	 * @return
	 */
	List<FssCodeLibraryModel> getFssCodeLibraryListByType(String codeType);

}
