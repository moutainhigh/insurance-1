package com.yundian.fss.manager;

import java.util.List;

import com.yundian.fssapi.domain.FssBankModel;
import com.yundian.result.PaginatedResult;
import com.yundian.result.Paginator;

/**
 * 银行服务
 * 
 * @author hehaibo
 * @version $Id: FssBankService.java, v 0.1 2016年7月26日 下午8:59:44 hehaibo Exp $
 */
public interface FssBankManager {
	Integer insertFssBank(FssBankModel fssBankModel);

	Integer updateFssBankByBankId(FssBankModel fssBankModel);

	Integer deleteFssBankByBankId(Integer bankId);

	FssBankModel getFssBankById(Integer id);

	/**
	 * 根据获取银行列表
	 * 
	 * @param fssBankModel
	 * @return
	 */
	List<FssBankModel> getFssBankList(FssBankModel fssBankModel);

	PaginatedResult<FssBankModel> getPaginatorFssBank(
			Paginator<FssBankModel> paginator);

	FssBankModel getFssBankFirst();
}
