 /** Author: jiyanbin@zafh.com.cn
 * JDK: 1.8
 * Created on 16/8/9.
 */
 package com.yundian.fss.flow.impl;


import com.yundian.fss.flow.AbstractLoanStatusTransformAdaptor;
import com.yundian.fssapi.domain.FssLoanAuditingLogModel;
import com.yundian.fssapi.domain.FssOrganizationUserModel;
import com.yundian.fssapi.exception.FssLoanStatusTransformException;
import com.yundian.fssapi.flow.FssFlowNode;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 审核端状态转换适配器
 * 修改历史
 * 修改日期         修改人          问题类型           说明
 */
@Service("loanStatusTransformApproveAdaptor")
@Transactional
public class LoanStatusTransformApproveAdaptor extends AbstractLoanStatusTransformAdaptor<FssOrganizationUserModel>{

    @Override
    protected void handlePermission(FssOrganizationUserModel operator) throws FssLoanStatusTransformException {

    }

    @Override
    protected void handleIndividualization(FssOrganizationUserModel operator, FssLoanAuditingLogModel loanAuditingLogModel) {
        loanAuditingLogModel.setNode(FssFlowNode.FSS_APPROVE.getNodeCode());
        loanAuditingLogModel.setNodeName(FssFlowNode.FSS_APPROVE.getNodeName());
//        loanAuditingLogModel.setOrganizationId(operator.getOrganizationId());
        loanAuditingLogModel.setOrguserId(operator.getOrguserId());
        loanAuditingLogModel.setOrguserName(operator.getName());
    }
}
