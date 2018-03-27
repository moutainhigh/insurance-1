package com.yundian.fss.manager;

import java.util.List;

import com.yundian.fssapi.domain.FssCreditLogModel;

/**
 * 征信日志表服务
 * 
 * @author haibo.he
 * @version $Id: FssCreditLogMananger.java, v 0.1 2016年7月26日 下午8:59:44 haibo.he
 *          Exp $
 */
public interface FssCreditLogMananger {
	Long insertFssCreditLog(FssCreditLogModel fssCreditLogModel);

	Integer updateFssCreditLog(FssCreditLogModel fssCreditLogModel);

	Integer deleteFssCreditLogById(Long id);

	FssCreditLogModel getFssCreditLogById(Long id);

	List<FssCreditLogModel> getFssCreditLogListByCreditId(Long creditId);

}
