/**
 * Author: jiyanbin@zafh.com.cn
 * JDK: 1.8
 * Created on 16/8/2.
 */

package com.yundian.fssapi.service;

import com.yundian.fssapi.domain.FssLoanAuditingLogModel;
import com.yundian.fssapi.domain.FssLoanModel;
import com.yundian.result.Result;

/**
 * 修改历史
 * 修改日期         修改人          问题类型           说明
 *
 * 贷款业务状态转换适配接口,每一个接口方法抽像应对一种贷款业务操作。
 */
public interface FssLoanStatusTransformAdaptor<U> {

    /**
     * 创建贷款适配接口
     * </p>
     *
     * @param fssLoanModel
     */
    public Result<Void> initAuditLog(U operator, FssLoanModel fssLoanModel);

    /**
     * 提交适配接口
     * </p>
     *
     * @param loanAuditingLogModel
     * @see com.yundian.fssapi.service.FssLoanStatusTransform#submit(FssLoanModel)
     */
    public Result<Void> submit(U operator, FssLoanAuditingLogModel loanAuditingLogModel);

    /**
     * 审核通过适配接口
     * </p>
     *
     * @param loanAuditingLogModel
     * @see com.yundian.fssapi.service.FssLoanStatusTransform#pass(FssLoanModel)
     */
    public Result<Void> pass(U operator, FssLoanAuditingLogModel loanAuditingLogModel);

    /**
     * 审核不通过适配接口
     * </p>
     *
     * @param loanAuditingLogModel
     * @see com.yundian.fssapi.service.FssLoanStatusTransform#reject(FssLoanModel)
     */
    public Result<Void> reject(U operator, FssLoanAuditingLogModel loanAuditingLogModel);

}
