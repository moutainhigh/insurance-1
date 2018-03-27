/**
 * Author: jiyanbin@zafh.com.cn
 * JDK: 1.8
 * Created on 16/8/2.
 */
package com.yundian.fss.flow;


import org.springframework.stereotype.Component;

import com.yundian.fssapi.domain.FssLoanModel;
import com.yundian.fssapi.enums.FssLoanAuditStatusEnum;
import com.yundian.fssapi.exception.FssLoanStatusTransformException;
import com.yundian.fssapi.service.FssLoanStatusTransform;

/**
 * 修改历史
 * 修改日期         修改人          问题类型           说明
 */
@Component("fssLoanStatusTransformProxy")
public class FssLoanStatusTransformProxy implements FssLoanStatusTransform {

    @Override
    public void submit(FssLoanModel model) throws FssLoanStatusTransformException {
        String status = model.getAuditStatus();
        FssLoanAuditStatusEnum.getInstance(status).submit(model);
    }

    @Override
    public void pass(FssLoanModel model) throws FssLoanStatusTransformException {
        String status = model.getAuditStatus();
        FssLoanAuditStatusEnum.getInstance(status).pass(model);
    }

    @Override
    public void reject(FssLoanModel model) throws FssLoanStatusTransformException {
        String status = model.getAuditStatus();
        FssLoanAuditStatusEnum.getInstance(status).reject(model);
    }
}
