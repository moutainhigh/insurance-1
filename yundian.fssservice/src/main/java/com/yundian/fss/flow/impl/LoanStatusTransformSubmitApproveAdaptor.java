 /** Author: jiyanbin@zafh.com.cn
 * JDK: 1.8
 * Created on 16/8/9.
 */
 package com.yundian.fss.flow.impl;


import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yundian.fss.flow.AbstractLoanStatusTransformAdaptor;
import com.yundian.fssapi.domain.FssLoanAuditingLogModel;
import com.yundian.fssapi.domain.FssUserModel;
import com.yundian.fssapi.exception.FssLoanStatusTransformException;
import com.yundian.fssapi.flow.FssFlowNode;

/**
 * 审核端状态转换适配器
 * 修改历史
 * 修改日期         修改人          问题类型           说明
 */
@Service("loanStatusTransformSubmitApproveAdaptor")
@Transactional
public class LoanStatusTransformSubmitApproveAdaptor extends AbstractLoanStatusTransformAdaptor<FssUserModel>{

    @Override
    protected void handlePermission(FssUserModel operator) throws FssLoanStatusTransformException {

    }

    @Override
    protected void handleIndividualization(FssUserModel operator, FssLoanAuditingLogModel loanAuditingLogModel) {
        loanAuditingLogModel.setNode(FssFlowNode.FSS_SUBMIT_APPROVE.getNodeCode());
        loanAuditingLogModel.setNodeName(FssFlowNode.FSS_SUBMIT_APPROVE.getNodeName());
        if(StringUtils.isEmpty(loanAuditingLogModel.getAuditContent())){
            loanAuditingLogModel.setAuditContent("提交审批");
        }
        loanAuditingLogModel.setOrguserId(operator.getUserId());
        loanAuditingLogModel.setOrguserName(operator.getName());
    }
}
