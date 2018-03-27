package com.yundian.fssapi.service;

import java.util.List;

import com.yundian.fssapi.domain.FssCreditLogModel;
import com.yundian.result.Result;

/**
 * 征信日志表服务
 * 
 * @author haibo.he
 * @version $Id: FssCreditLogService.java, v 0.1 2016年7月26日 下午8:59:44 haibo.he
 *          Exp $
 */
public interface FssCreditLogService {
	Result<Long> insertFssCreditLog(FssCreditLogModel fssCreditLogModel);

	Result<Integer> deleteFssCreditLogById(Long id);

	Result<FssCreditLogModel> getFssCreditLogById(Long id);

	Result<List<FssCreditLogModel>> getFssCreditLogListByCreditId(Long creditId);

}
