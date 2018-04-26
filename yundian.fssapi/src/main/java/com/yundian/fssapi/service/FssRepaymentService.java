package com.yundian.fssapi.service;

import com.yundian.fssapi.domain.FssDealerModel;
import com.yundian.fssapi.domain.FssLoanRepaymentModel;
import com.yundian.fssapi.domain.FssLoanRepaymentPlanModel;
import com.yundian.result.Page;
import com.yundian.result.PaginatedResult;
import com.yundian.result.Paginator;

import java.util.List;

/**
 *还款服务
 */
public interface FssRepaymentService {


 /**
  *生成还款计划
  * @param loanId
  */
   void initRepaymentPlan(Long loanId);


 /**
  * 还款计划
  * @param paginator
  * @return
  */
 Page<FssLoanRepaymentPlanModel> getRepaymentPlan(Paginator<FssLoanRepaymentPlanModel> paginator);


  /**
   * 还款明细
   * @param paginator
   * @return
   */
  Page<FssLoanRepaymentModel> getRepaymentDetail(Paginator<FssLoanRepaymentModel> paginator) ;


}
