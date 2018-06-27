package com.yundian.fss.biz.service.impl;

import com.yundian.fss.biz.service.FssLoanRepaymentPlanBizService;
import com.yundian.fss.dao.FssLoanRepaymentPlanModelMapper;
import com.yundian.fssapi.domain.FssLoanRepaymentPlanModel;
import com.yundian.fssapi.enums.FssRepaymentStatusEnum;
import com.yundian.toolkit.utils.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author jnx
 * @create 2018/6/22
 */
@Slf4j
@Component("fssLoanRepaymentPlanBizService")
public class FssLoanRepaymentPlanBizServiceImpl implements FssLoanRepaymentPlanBizService {

    @Autowired
    FssLoanRepaymentPlanModelMapper fssLoanRepaymentPlanModelMapper;


    @Override
    public int updateRepaymentPlanPaymenting(Long planId) {
        FssLoanRepaymentPlanModel fssLoanRepaymentPlanModel =new FssLoanRepaymentPlanModel();
        fssLoanRepaymentPlanModel.setId(planId);
        fssLoanRepaymentPlanModel.setInPayment(1);
        return fssLoanRepaymentPlanModelMapper.updateByPrimaryKeySelective(fssLoanRepaymentPlanModel);

    }

    @Override
    public int updateRepaymentPlanUnPayment(Long planId) {
        FssLoanRepaymentPlanModel fssLoanRepaymentPlanModel =new FssLoanRepaymentPlanModel();
        fssLoanRepaymentPlanModel.setId(planId);
        fssLoanRepaymentPlanModel.setInPayment(0);
        return fssLoanRepaymentPlanModelMapper.updateByPrimaryKeySelective(fssLoanRepaymentPlanModel);

    }

    @Override
    public void repaymentSuccess(Long planId, Integer payAmount, String repaymentDate, String repaymentTime) {

        FssLoanRepaymentPlanModel planModel = new FssLoanRepaymentPlanModel();
        planModel.setId(planId);
        planModel.setRepaymentStatus(FssRepaymentStatusEnum.HASREPAYMENT.name());
        planModel.setRepaymentDate(repaymentDate);
        planModel.setMtime(new Date());
        try {
            Date date = DateUtils.parseDate(repaymentTime,"yyyy-MM-dd hh:mm:ss");
            planModel.setRepaymentTime(date);
        }catch (Exception e){
            log.error("repaymentSuccess："+e.getMessage());
        }
        fssLoanRepaymentPlanModelMapper.updateByPrimaryKeySelective(planModel);

    }

    @Override
    public void repaymentFailed(Long planId) {
        //不处理
    }

    @Override
    public void repaymentRefund(Long planId) {

        //不处理
    }
}
