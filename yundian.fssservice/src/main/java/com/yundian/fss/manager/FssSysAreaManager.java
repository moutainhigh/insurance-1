package com.yundian.fss.manager;

import java.util.List;

import com.yundian.fssapi.domain.FssSysAreaModel;
import com.yundian.result.PaginatedResult;
import com.yundian.result.Paginator;

/**
 * 系统地区服务
 * 
 * @author hehaibo
 * @version $Id: FssSysAreaService.java, v 0.1 2016年7月26日 下午8:59:44 hehaibo Exp
 *          $
 */
public interface FssSysAreaManager {
	Integer insertFssSysArea(FssSysAreaModel fssSysAreaModel);

	Integer updateFssSysArea(FssSysAreaModel fssSysAreaModel);

	Integer deleteFssSysAreaById(Long id);

	FssSysAreaModel getFssSysAreaById(Long id);

	List<FssSysAreaModel> getFssSysAreaList(FssSysAreaModel fssSysAreaModel);

	PaginatedResult<FssSysAreaModel> getPaginatorFssSysArea(
			Paginator<FssSysAreaModel> paginator);
}
