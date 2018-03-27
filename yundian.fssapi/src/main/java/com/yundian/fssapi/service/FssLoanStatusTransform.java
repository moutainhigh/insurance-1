/**
 * Author: jiyanbin@zafh.com.cn
 * JDK: 1.8
 * Created on 16/8/2.
 */
package com.yundian.fssapi.service;



import com.yundian.fssapi.domain.FssLoanModel;
import com.yundian.fssapi.exception.FssLoanStatusTransformException;

/**
 * 修改历史
 * 修改日期         修改人          问题类型           说明
 *
 * 贷款业务状态转换接口,每一个接口方法抽像应对一种贷款业务操作。
 */
public interface FssLoanStatusTransform {

    /**
     * 创建贷款
     * </p>
     * 贷款项目创建时,调用此接口,此时贷款对应的状态为{@link com.yundian.fssapi.enums.FssLoanAuditStatusEnum#UNSUBMIT}
     * @param model
     * @throws FssLoanStatusTransformException
     */
    //public void initAuditLog(FssLoanModel model) throws FssLoanStatusTransformException;

    /**
     * 提交
     * </p>
     * 贷款项目提交时,调用此接口,此时贷款对应的状态为{@link com.yundian.fssapi.enums.FssLoanAuditStatusEnum#WAIT_ADUIT}
     * @param model
     * @throws FssLoanStatusTransformException
     */
    public void submit(FssLoanModel model) throws FssLoanStatusTransformException;

    /**
     * 审核通过
     * </p>
     * 贷款项目审核通过时,调用此接口,此时贷款对应的状态为{@link com.yundian.fssapi.enums.FssLoanAuditStatusEnum#ADUIT_PASS}
     * @param model
     * @throws FssLoanStatusTransformException
     */
    public void pass(FssLoanModel model) throws FssLoanStatusTransformException;

    /**
     * 审核不通过
     * </p>
     * 贷款项目审核不通过时,调用此接口,此时贷款对应的状态为{@link com.yundian.fssapi.enums.FssLoanAuditStatusEnum#ADUIT_PASS}
     * @param model
     * @throws FssLoanStatusTransformException
     */
    public void reject(FssLoanModel model) throws FssLoanStatusTransformException;

}
