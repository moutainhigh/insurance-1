package com.yundian.fssapi.service;

import com.yundian.fssapi.domain.FssDealerCustomerModel;
import com.yundian.fssapi.domain.FssDealerUserModel;
import com.yundian.result.PaginatedResult;
import com.yundian.result.Paginator;

/**
 * 经销商客户服务
 */
public interface FssDealerCustomerService {



	/**
	 *获取经销商客户信息
	 * @param customerId
	 * @return
	 */
	FssDealerCustomerModel getFssDealerCustomer(Long customerId);


    /**
     * 新增经销商客户
     * @param fssDealerCustomerModel
     * @return
     */
	Integer insertFssDealerCustomer(FssDealerCustomerModel fssDealerCustomerModel);


    /**
     * 修改经销商客户
     * @param fssDealerCustomerModel
     * @return
     */
	Integer updateFssDealerCustomer(FssDealerCustomerModel fssDealerCustomerModel);

	/**
	 * 分页查询客户列表
	 * @param paginator
	 * @return
	 */
	PaginatedResult<FssDealerCustomerModel> getPaginatorFssDealerCustomer(
            Paginator<FssDealerCustomerModel> paginator);


}
