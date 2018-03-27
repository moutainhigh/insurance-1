/**
 * Author: jiyanbin@zafh.com.cn
 * JDK: 1.8
 * Created on 16/8/9.
 */

package com.yundian.fss.flow;

import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.yundian.fss.manager.FssLoanAuditingLogManager;
import com.yundian.fss.manager.FssLoanManager;
import com.yundian.fss.manager.assignrule.FssLoanOrganizationAssignRule;
import com.yundian.fss.manager.assignrule.FssLoanOrganizationUserAssignRule;
import com.yundian.fssapi.domain.FssLoanAuditingLogModel;
import com.yundian.fssapi.domain.FssLoanModel;
import com.yundian.fssapi.enums.FssLoanDealwithStatusEnum;
import com.yundian.fssapi.enums.FssYesOrNoEnum;
import com.yundian.fssapi.exception.FssLoanStatusTransformException;
import com.yundian.fssapi.service.FssLoanStatusTransform;
import com.yundian.fssapi.service.FssLoanStatusTransformAdaptor;
import com.yundian.result.Result;
import com.yundian.result.ResultCodeContants;

/**
 * 抽像状态转换适配器
 * 修改历史
 * 修改日期         修改人          问题类型           说明
 */
public abstract class AbstractLoanStatusTransformAdaptor<U> implements FssLoanStatusTransformAdaptor<U> {
    
	protected static Logger logger = LoggerFactory.getLogger(FssLoanStatusTransformAdaptor.class);

    @Autowired
    @Qualifier("fssLoanStatusTransformProxy")
    private FssLoanStatusTransform transform;

    @Autowired
    private FssLoanManager fssLoanManager;

    @Autowired
    private FssLoanAuditingLogManager fssLoanAuditingLogManager;

    @Autowired
    @Qualifier("fssLoanOrganizationRandomAssignRule")
    private FssLoanOrganizationAssignRule fssLoanOrganizationRandomAssignRule;

    @Autowired
    @Qualifier("fssLoanOrganizationUserAverageAssignRule")
    private FssLoanOrganizationUserAssignRule fssLoanOrganizationUserAverageAssignRule;

    
    @Override
    public Result<Void> initAuditLog(U operator, FssLoanModel fssLoanModel) {
        Result<Void> result = new Result<Void>();
        try {
            handlePermission(operator);
            FssLoanModel model = fssLoanManager.getFssLoanById(fssLoanModel.getLoanId());
            FssLoanAuditingLogModel fssLoanAuditingLogModel = new FssLoanAuditingLogModel();
            fssLoanAuditingLogModel.setAuditStatus(model.getAuditStatus());
            fssLoanAuditingLogModel.setAuditTime(new Date());
            fssLoanAuditingLogModel.setGuaranteeId(model.getGuaranteeId());
            fssLoanAuditingLogModel.setLoanId(model.getLoanId());
            this.handleIndividualization(operator, fssLoanAuditingLogModel);
            fssLoanAuditingLogManager.insertFssLoanAuditingLog(fssLoanAuditingLogModel);
            result.setCode(ResultCodeContants.success);
        } catch (Exception e) {
            logger.error(
                    String.format("添加审核日志异常:%s", ToStringBuilder
                            .reflectionToString(fssLoanModel)), e);
            if (e instanceof FssLoanStatusTransformException) {
                FssLoanStatusTransformException be = (FssLoanStatusTransformException) e;
                result.setCode(ResultCodeContants.failed);
                result.setMessage(be.getMessage());
            } else {
                result.setCode(ResultCodeContants.failed);
                result.setMessage("系统异常");
            }
        }
        return result;
    }

    @Override
    public Result<Void> submit(U operator, FssLoanAuditingLogModel loanAuditingLogModel) {
        Result<Void> result = new Result<Void>();
        try {
            this.handlePermission(operator);
            FssLoanModel model = fssLoanManager.getFssLoanById(loanAuditingLogModel.getLoanId());
            //状态改为已办
            model.setDealwithStatus(FssLoanDealwithStatusEnum.HAVE_TODO.code());
            transform.submit(model);
            //TODO-1 设置审批机构 如果是退回的，则无需分配机构
            if(model.getOrganizationId()==null){
                this.fssLoanOrganizationRandomAssignRule.assginToOrganization(model);
            }
            //TODO-2 设置审批机构用户-目前是按照任务量均分
            this.fssLoanOrganizationUserAverageAssignRule.assignToOrganizationUser(model);
            
            fssLoanManager.updateFssLoan(model);
            FssLoanAuditingLogModel fssLoanAuditingLogModel = new FssLoanAuditingLogModel();
            fssLoanAuditingLogModel.setAuditStatus(model.getAuditStatus());
            fssLoanAuditingLogModel.setAuditContent(loanAuditingLogModel.getAuditContent());
            fssLoanAuditingLogModel.setAuditTime(new Date());
            fssLoanAuditingLogModel.setGuaranteeId(model.getGuaranteeId());
            fssLoanAuditingLogModel.setOrganizationId(model.getOrganizationId());
            fssLoanAuditingLogModel.setLoanId(model.getLoanId());
            fssLoanAuditingLogModel.setRemark("");
            
            this.handleIndividualization(operator, fssLoanAuditingLogModel);
            fssLoanAuditingLogManager.insertFssLoanAuditingLog(fssLoanAuditingLogModel);
            result.setCode(ResultCodeContants.success);
        } catch (Exception e) {
            logger.error(
                    String.format("添加审核日志异常:%s", ToStringBuilder
                            .reflectionToString(loanAuditingLogModel)), e);
            if (e instanceof FssLoanStatusTransformException) {
                FssLoanStatusTransformException be = (FssLoanStatusTransformException) e;
                result.setCode(ResultCodeContants.failed);
                result.setMessage(be.getMessage());
            } else {
                result.setCode(ResultCodeContants.failed);
                result.setMessage("系统异常");
            }
        }
        return result;
    }

    @Override
    public Result<Void> pass(U operator, FssLoanAuditingLogModel loanAuditingLogModel) {
        Result<Void> result = new Result<Void>();
        try {
            this.handlePermission(operator);
            this.bindOperator(operator, loanAuditingLogModel);
            FssLoanModel model = fssLoanManager.getFssLoanById(loanAuditingLogModel.getLoanId());
            model.setIsFinish(FssYesOrNoEnum.Y.code());
            transform.pass(model);
            model.setAuditTime(new Date());
            fssLoanManager.updateFssLoan(model);
            loanAuditingLogModel.setAuditStatus(model.getAuditStatus());
            loanAuditingLogModel.setOrganizationId(model.getOrganizationId());
            loanAuditingLogModel.setGuaranteeId(loanAuditingLogModel.getGuaranteeId());
            loanAuditingLogModel.setLoanId(model.getLoanId());
//            loanAuditingLogModel.setGuaranteeId(model.getGuaranteeId());
            fssLoanAuditingLogManager.insertFssLoanAuditingLog(loanAuditingLogModel);
            result.setCode(ResultCodeContants.success);
        } catch (Exception e) {
            logger.error(
                    String.format("添加审核日志异常:%s", ToStringBuilder
                            .reflectionToString(loanAuditingLogModel)), e);
            if (e instanceof FssLoanStatusTransformException) {
                FssLoanStatusTransformException be = (FssLoanStatusTransformException) e;
                result.setCode(ResultCodeContants.failed);
                result.setMessage(be.getMessage());
            } else {
                result.setCode(ResultCodeContants.failed);
                result.setMessage("系统异常");
            }
        }
        return result;
    }

    @Override
    public Result<Void> reject(U operator, FssLoanAuditingLogModel loanAuditingLogModel) throws FssLoanStatusTransformException {
        Result<Void> result = new Result<Void>();
        try {
            this.handlePermission(operator);
            this.bindOperator(operator, loanAuditingLogModel);
            FssLoanModel model = fssLoanManager.getFssLoanById(loanAuditingLogModel.getLoanId());
            //状态改为未办 审核时间为空，机构的审核用户ID 为空
            model.setDealwithStatus(FssLoanDealwithStatusEnum.UN_TODO.code());
            model.setAuditTime(null);
            model.setOrguserId(null);
            model.setOrguserName(null);
            transform.reject(model);
            loanAuditingLogModel.setAuditStatus(model.getAuditStatus());
            fssLoanManager.updateFssLoan(model);
            loanAuditingLogModel.setOrganizationId(model.getOrganizationId());
            fssLoanAuditingLogManager.insertFssLoanAuditingLog(loanAuditingLogModel);
            result.setCode(ResultCodeContants.success);
        } catch (Exception e) {
            logger.error(
                    String.format("添加审核日志异常:%s", ToStringBuilder
                            .reflectionToString(loanAuditingLogModel)), e);
            if (e instanceof FssLoanStatusTransformException) {
                FssLoanStatusTransformException be = (FssLoanStatusTransformException) e;
                result.setCode(ResultCodeContants.failed);
                result.setMessage(be.getMessage());
            } else {
                result.setCode(ResultCodeContants.failed);
                result.setMessage("系统异常");
            }
        }
        return result;
    }

    protected abstract void handlePermission(U operator) throws FssLoanStatusTransformException;

    /**
     * 个性化流程信息
     * </p>
     * 不同的业务个性化信息不同.
     *
     * @param operator
     * @param loanAuditingLogModel
     * @return
     */
    protected abstract void handleIndividualization(U operator, FssLoanAuditingLogModel loanAuditingLogModel);

    /**
     * 绑定当前流程记录操作者
     *
     * @param operator
     * @param loanAuditingLogModel
     */
    protected void bindOperator(U operator, FssLoanAuditingLogModel loanAuditingLogModel) {
        handleIndividualization(operator, loanAuditingLogModel);
    }
}
