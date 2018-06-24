package com.yundian.fss.biz.service.impl;

import com.yundian.fss.biz.service.FssLoanRepaymentPlanBizService;
import com.yundian.fss.dao.FssLoanRepaymentPlanModelMapper;
import com.yundian.fssapi.domain.FssLoanRepaymentPlanModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author jnx
 * @create 2018/6/22
 */
@Component("fssLoanRepaymentPlanBizService")
public class FssLoanRepaymentPlanBizServiceImpl implements FssLoanRepaymentPlanBizService {

    @Autowired
    FssLoanRepaymentPlanModelMapper fssLoanRepaymentPlanModelMapper;


    @Override
    public int updateRepaymentPlanPaymenting(Long planId) {
        FssLoanRepaymentPlanModel fssLoanRepaymentPlanModel =new FssLoanRepaymentPlanModel();
        fssLoanRepaymentPlanModel.setId(planId);
        fssLoanRepaymentPlanModel.setInPaymnet(1);
        return fssLoanRepaymentPlanModelMapper.updateByPrimaryKeySelective(fssLoanRepaymentPlanModel);

    }

    @Override
    public int updateRepaymentPlanUnPayment(Long planId) {
        FssLoanRepaymentPlanModel fssLoanRepaymentPlanModel =new FssLoanRepaymentPlanModel();
        fssLoanRepaymentPlanModel.setId(planId);
        fssLoanRepaymentPlanModel.setInPaymnet(0);
        return fssLoanRepaymentPlanModelMapper.updateByPrimaryKeySelective(fssLoanRepaymentPlanModel);

    }
}
