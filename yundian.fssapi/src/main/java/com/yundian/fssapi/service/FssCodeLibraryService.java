package com.yundian.fssapi.service;

import java.util.List;

import com.yundian.fssapi.domain.FssCodeLibraryModel;
import com.yundian.result.PaginatedResult;
import com.yundian.result.Paginator;
import com.yundian.result.Result;

/**
 *
 * 
 * @author hehaibo
 * @version $Id: FssCodeLibraryService.java, v 0.1 2016年7月26日 下午8:59:44 hehaibo
 *          Exp $
 */
public interface FssCodeLibraryService {
	Result<Integer> insertFssCodeLibrary(FssCodeLibraryModel fssCodeLibraryModel);

	Result<Integer> updateFssCodeLibrary(FssCodeLibraryModel fssCodeLibraryModel);

	Result<Integer> deleteFssCodeLibraryById(Integer id);

	Result<FssCodeLibraryModel> getFssCodeLibraryById(Integer id);

	Result<List<FssCodeLibraryModel>> getFssCodeLibraryList(
			FssCodeLibraryModel fssCodeLibraryModel);

	Result<PaginatedResult<FssCodeLibraryModel>> getPaginatorFssCodeLibrary(
			Paginator<FssCodeLibraryModel> paginator);
}
