package com.yundian.fssapi.service;

import java.util.List;

import com.yundian.fssapi.domain.FssSysAreaModel;
import com.yundian.result.PaginatedResult;
import com.yundian.result.Paginator;
import com.yundian.result.Result;

/**
 * 系统地区服务
 * 
 * @author hehaibo
 * @version $Id: FssSysAreaService.java, v 0.1 2016年7月26日 下午8:59:44 hehaibo Exp
 *          $
 */
public interface FssSysAreaService {
	Result<Integer> insertFssSysArea(FssSysAreaModel fssSysAreaModel);

	Result<Integer> updateFssSysArea(FssSysAreaModel fssSysAreaModel);

	Result<Integer> deleteFssSysAreaById(Long id);

	Result<FssSysAreaModel> getFssSysAreaById(Long id);

	Result<List<FssSysAreaModel>> getFssSysAreaList(
			FssSysAreaModel fssSysAreaModel);

	Result<PaginatedResult<FssSysAreaModel>> getPaginatorFssSysArea(
			Paginator<FssSysAreaModel> paginator);
}
