package com.yundian.fss.manager.impl;

import com.alibaba.fastjson.JSON;
import com.yundian.fss.dao.FssLoanLogModelMapper;
import com.yundian.fss.dao.FssLoanModelMapper;
import com.yundian.fss.manager.FssFlowManage;
import com.yundian.fssapi.domain.FssLoanLogModel;
import com.yundian.fssapi.domain.FssLoanModel;
import com.yundian.fssapi.domain.statistics.FlowDataModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 流程状态
 *
 * @author jnx
 * @create 2018/4/10
 */
@Slf4j
@Service
public class FssFlowManageImpl implements FssFlowManage {

    @Autowired
    FssLoanModelMapper fssLoanModelMapper;

    @Autowired
    FssLoanLogModelMapper fssLoanLogModelMapper;
    @Override
    public void flow(FlowDataModel flowDataModel) {
        log.info("流程变动："+ JSON.toJSONString(flowDataModel));
        FssLoanModel fssLoanModel = new FssLoanModel();
        fssLoanModel.setLoanId(flowDataModel.getLoanId());
        fssLoanModel.setAuditStatus(flowDataModel.getFlowToStatus().code());
        if(flowDataModel.getFlowPreStatus()!=null) {
            fssLoanModel.setAuditStatusPre(flowDataModel.getFlowPreStatus().code());
        }
        fssLoanModel.setMtime(new Date());
        fssLoanModelMapper.updateByPrimaryKeySelective(fssLoanModel);


        FssLoanLogModel fssLoanLogModel = new FssLoanLogModel();
        fssLoanLogModel.setLoanId(flowDataModel.getLoanId());
        fssLoanLogModel.setNode(flowDataModel.getFlowToStatus().code());
        fssLoanLogModel.setNodeName(flowDataModel.getFlowToStatus().desc());
        fssLoanLogModel.setContent(flowDataModel.getContent());
        fssLoanLogModel.setCtime(new  Date());
        fssLoanLogModel.setMtime(new Date());
        fssLoanLogModelMapper.insert(fssLoanLogModel);


    }
}
