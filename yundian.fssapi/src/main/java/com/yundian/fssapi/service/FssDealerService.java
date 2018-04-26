package com.yundian.fssapi.service;

import com.yundian.fssapi.domain.FssDealerModel;
import com.yundian.fssapi.domain.FssDealerUserModel;
import com.yundian.result.Page;
import com.yundian.result.PaginatedResult;
import com.yundian.result.Paginator;

/**
 *经销商服务
 */
public interface FssDealerService {

	void updateFssDealer(FssDealerModel fssDealerModel);

	void addFssDealer(FssDealerModel fssDealerModel);
	/**
	 * 获取经销商信息信息
	 * @param dealerId
	 * @return
	 */
	FssDealerModel getFssDealer(Long dealerId);

	/**
	 * 分页查询经销商列表
	 * @param paginator
	 * @return
	 */
	Page<FssDealerModel> getPaginatorFssDealer(
            Paginator<FssDealerModel> paginator);

}
