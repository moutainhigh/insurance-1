/**
 * Author: jiyanbin@zafh.com.cn
 * JDK: 1.8
 * Created on 16/8/9.
 */
package com.yundian.fss.flow.impl;


import com.yundian.fss.flow.AbstractLoanStatusTransformAdaptor;
import com.yundian.fssapi.domain.FssBankUserModel;
import com.yundian.fssapi.domain.FssLoanAuditingLogModel;
import com.yundian.fssapi.exception.FssLoanStatusTransformException;
import com.yundian.fssapi.flow.FssFlowNode;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 资金端状态转换适配器
 * 修改历史
 * 修改日期         修改人          问题类型           说明
 */
@Service("loanStatusTransformBankAdaptor")
@Transactional
public class LoanStatusTransformBankAdaptor extends AbstractLoanStatusTransformAdaptor<FssBankUserModel>{

    @Override
    protected void handlePermission(FssBankUserModel operator) throws FssLoanStatusTransformException {

    }

    @Override
    protected void handleIndividualization(FssBankUserModel operator, FssLoanAuditingLogModel loanAuditingLogModel) {
        loanAuditingLogModel.setNode(FssFlowNode.BANK_CONFIRMATION.getNodeCode());
        loanAuditingLogModel.setNodeName(FssFlowNode.BANK_CONFIRMATION.getNodeName());
        loanAuditingLogModel.setOrganizationId(operator.getBankId());
        loanAuditingLogModel.setOrguserId(operator.getBkuserId());
        loanAuditingLogModel.setOrguserName(operator.getName());
    }
}
