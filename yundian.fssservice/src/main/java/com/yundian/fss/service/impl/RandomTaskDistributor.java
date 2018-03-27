package com.yundian.fss.service.impl;/**
 * Author: jiyanbin@zafh.com.cn
 * JDK: 1.8
 * Created on 16/8/19.
 */


import com.yundian.fssapi.domain.FssLoanModel;
import com.yundian.fssapi.domain.FssOrganizationModel;
import com.yundian.fssapi.service.FssOrganizationService;
import com.yundian.fssapi.service.TaskDistributor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 修改历史
 * 修改日期         修改人          问题类型           说明
 */

/**
 * 随机挑选审批机构的分配测略
 */
@Deprecated
@Component("randomTaskDistributor")
public class RandomTaskDistributor implements TaskDistributor {
    @Autowired
    private FssOrganizationService organizationService;

    @Override
    public FssOrganizationModel pickupOrg(FssLoanModel fssLoanModel) {
        return organizationService.listAllOrganization().getData().stream().findAny().orElseGet(null);
    }
}
