package com.yundian.fssapi.service;/**
 * Author: jiyanbin@zafh.com.cn
 * JDK: 1.8
 * Created on 16/8/19.
 */


import com.yundian.fssapi.domain.FssLoanModel;
import com.yundian.fssapi.domain.FssOrganizationModel;

/**
 * 修改历史
 * 修改日期         修改人          问题类型           说明
 */
public interface TaskDistributor {

    /**
     * 挑选审批机构
     * @param fssLoanModel
     * @return
     */
    FssOrganizationModel pickupOrg(FssLoanModel fssLoanModel);
}
