package com.yundian.fssapi.service;

import com.yundian.fssapi.domain.FssDealerModel;
import com.yundian.fssapi.domain.FssLoanRepaymentModel;
import com.yundian.fssapi.domain.FssLoanRepaymentPlanModel;
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
  * @param loanId
  * @return
  */
 List<FssLoanRepaymentPlanModel> getRepaymentPlan(Long loanId);

  /**
   * 还款明细
   * @param loanId
   * @return
   */
    List<FssLoanRepaymentModel> getRepaymentDetail(Long loanId);

}
