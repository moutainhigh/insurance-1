package com.yundian.fss.service.impl;

import com.yundian.fssapi.domain.FssLoanRepaymentModel;
import com.yundian.fssapi.domain.FssLoanRepaymentPlanModel;
import com.yundian.fssapi.service.FssRepaymentService;

import java.util.List;

/**
 * 还款服务
 *
 * @author jnx
 * @create 2018/4/13
 */
public class FssRepaymnetServiceImpl implements FssRepaymentService {

    @Override
    public void initRepaymentPlan(Long loanId) {

    }

    @Override
    public List<FssLoanRepaymentPlanModel> getRepaymentPlan(Long loanId) {
        return null;
    }

    @Override
    public List<FssLoanRepaymentModel> getRepaymentDetail(Long loanId) {
        return null;
    }
}
