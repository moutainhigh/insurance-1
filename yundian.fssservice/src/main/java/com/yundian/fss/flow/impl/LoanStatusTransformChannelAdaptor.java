/**
 * Author: jiyanbin@zafh.com.cn
 * JDK: 1.8
 * Created on 16/8/9.
 */
package com.yundian.fss.flow.impl;


import com.yundian.fss.flow.AbstractLoanStatusTransformAdaptor;
import com.yundian.fssapi.domain.FssLoanAuditingLogModel;
import com.yundian.fssapi.domain.FssUserModel;
import com.yundian.fssapi.exception.FssLoanStatusTransformException;
import com.yundian.fssapi.flow.FssFlowNode;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 渠道端状态转换适配器
 * 修改历史
 * 修改日期         修改人          问题类型           说明
 */
@Service("loanStatusTransformChannelAdaptor")
@Transactional
public class LoanStatusTransformChannelAdaptor extends AbstractLoanStatusTransformAdaptor<FssUserModel>{

    @Override
    protected void handlePermission(FssUserModel operator) throws FssLoanStatusTransformException {

    }

    @Override
    protected void handleIndividualization(FssUserModel operator, FssLoanAuditingLogModel loanAuditingLogModel) {
        loanAuditingLogModel.setNode(FssFlowNode.FSS_LAUNCH.getNodeCode());
        loanAuditingLogModel.setNodeName(FssFlowNode.FSS_LAUNCH.getNodeName());
        if(StringUtils.isEmpty(loanAuditingLogModel.getAuditContent())){
            loanAuditingLogModel.setAuditContent("启动流程");
        }
        loanAuditingLogModel.setOrguserId(operator.getUserId());
        loanAuditingLogModel.setOrguserName(operator.getName());
    }
}
