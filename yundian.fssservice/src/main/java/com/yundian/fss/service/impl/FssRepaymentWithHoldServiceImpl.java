//package com.yundian.fss.service.impl;
//
//import com.yundian.fss.dao.FssLoanRepaymentPlanModelMapper;
//import com.yundian.fss.pay.withhold.haier.HaierTradeBankWitholdingRequest;
//import com.yundian.fss.pay.withhold.haier.WithHoldHaierBizService;
//import com.yundian.fssapi.domain.FssLoanRepaymentPlanModel;
//import com.yundian.fssapi.enums.FssRepaymentStatusEnum;
//import com.yundian.fssapi.service.FssRepaymentWithHoldService;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.util.StringUtils;
//
//import java.util.Map;
//
///**
// * 代扣服务
// *
// * @author jnx
// * @create 2018/6/1
// */
//@Slf4j
//@Service("fssRepaymentWithHoldService")
//public class FssRepaymentWithHoldServiceImpl implements FssRepaymentWithHoldService{
//
////    @Autowired
////    WithHoldHaierBizService withHoldHaierBizService;
////
////    @Autowired
////    HaierTradeBankWitholdingRequest haierTradeBankWitholdingRequest;
//
//    @Autowired
//    FssLoanRepaymentPlanModelMapper fssLoanRepaymentPlanModelMapper;
//
//    @Override
//    public Boolean verfiySign(Map<String, String> param, String sign) {
//
//        return withHoldHaierBizService.verify(param,sign);
//    }
//
//    @Override
//    public void tradeWithHolding(Long planId) {
//
//          FssLoanRepaymentPlanModel fssLoanRepaymentPlanModel = fssLoanRepaymentPlanModelMapper.selectByPrimaryKey(planId);
//          if(StringUtils.isEmpty(fssLoanRepaymentPlanModel.getRepaymentStatus())){
//              log.error("代扣的还款计划状态为空，不发起扣款申请！loanId:"+fssLoanRepaymentPlanModel.getLoanId());
//              return ;
//          }
//          FssRepaymentStatusEnum fssRepaymentStatusEnum = Enum.valueOf(FssRepaymentStatusEnum.class,fssLoanRepaymentPlanModel.getRepaymentStatus());
//
//        if(fssRepaymentStatusEnum == FssRepaymentStatusEnum.OVERDUE||
//                fssRepaymentStatusEnum == FssRepaymentStatusEnum.PENDINGREPAYMENT){
//
//        }
//        //生成扣款订单
//        //提交代扣申请
//        //haierTradeBankWitholdingRequest.invoke()
//    }
//
//    @Override
//    public void batchTradeWithHolding() {
//
//    }
//
//    @Override
//    public void tradeRefund() {
//
//    }
//
//    @Override
//    public void tradeQuery() {
//
//    }
//
//    @Override
//    public void notifyWithHold() {
//
//    }
//
//    @Override
//    public void notifyRefund() {
//
//    }
//}
