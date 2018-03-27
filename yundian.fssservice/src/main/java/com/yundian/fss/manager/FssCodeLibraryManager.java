package com.yundian.fss.manager;

import java.util.List;

import com.yundian.fssapi.domain.FssCodeLibraryModel;
import com.yundian.result.PaginatedResult;
import com.yundian.result.Paginator;

/**
 * 人脸识别服务
 * 
 * @author hehaibo
 * @version $Id: FssCodeLibraryService.java, v 0.1 2016年7月26日 下午8:59:44 hehaibo
 *          Exp $
 */
public interface FssCodeLibraryManager {
	Integer insertFssCodeLibrary(FssCodeLibraryModel fssCodeLibraryModel);

	Integer updateFssCodeLibrary(FssCodeLibraryModel fssCodeLibraryModel);

	Integer deleteFssCodeLibraryById(Integer id);

	FssCodeLibraryModel getFssCodeLibraryById(Integer id);

	List<FssCodeLibraryModel> getFssCodeLibraryList(
			FssCodeLibraryModel fssCodeLibraryModel);

	PaginatedResult<FssCodeLibraryModel> getPaginatorFssCodeLibrary(
			Paginator<FssCodeLibraryModel> paginator);
}
