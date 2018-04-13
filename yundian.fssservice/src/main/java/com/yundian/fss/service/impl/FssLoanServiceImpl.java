package com.yundian.fss.service.impl;

import com.alibaba.fastjson.JSON;
import com.yundian.fss.dao.FssLoanDocumentModelMapper;
import com.yundian.fss.dao.FssLoanModelMapper;
import com.yundian.fss.manager.FssFlowManage;
import com.yundian.fssapi.domain.FssLoanDocumentModel;
import com.yundian.fssapi.domain.FssLoanModel;
import com.yundian.fssapi.domain.statistics.FlowDataModel;
import com.yundian.fssapi.domain.statistics.LoanInfoModel;
import com.yundian.fssapi.enums.FssLoanStatusEnum;
import com.yundian.fssapi.exception.FssLoanException;
import com.yundian.fssapi.service.FssLoanService;
import com.yundian.result.PaginatedResult;
import com.yundian.result.Paginator;
import com.yundian.result.ResultCodeContants;
import com.yundian.toolkit.utils.BeanUtilsExt;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * 保险分期
 *
 * @author jnx
 * @create 2018/4/9
 */
@Slf4j
@Service("fssLoanService")
public class FssLoanServiceImpl implements FssLoanService {

    @Autowired
    FssFlowManage fssFlowManage;

    @Autowired
    FssLoanModelMapper fssLoanModelMapper;
    @Autowired
    FssLoanDocumentModelMapper fssLoanDocumentModelMapper;

    @Override
    public LoanInfoModel getFssLoan(Long loanId) {

        try {
            FssLoanModel fssLoanModel = fssLoanModelMapper.selectByPrimaryKey(loanId);
            if (fssLoanModel == null) {
                throw new FssLoanException(ResultCodeContants.FAILED, "获取保险分期数据失败", null);
            }
            LoanInfoModel loanInfoModel = new LoanInfoModel();
            loanInfoModel.setFssLoanModel(fssLoanModel);
            List<FssLoanDocumentModel> fssLoanDocumentModels = fssLoanDocumentModelMapper.selectByLoanId(loanId);
            loanInfoModel.setFssLoanDocumentModels(fssLoanDocumentModels);
            return loanInfoModel;
        } catch (Exception e) {
            log.error(String.format("新增保险分期失败:%s", loanId), e);
            throw new FssLoanException(ResultCodeContants.FAILED, "新增保险分期失败", e);
        }

    }

    @Override
    public Long insertFssLoan(FssLoanModel fssLoanModel) {

        try {
             fssLoanModelMapper.insert(fssLoanModel);
            return fssLoanModel.getLoanId();
        } catch (Exception e) {
            log.error(String.format("新增保险分期失败:%s", JSON.toJSONString(fssLoanModel)), e);
            throw new FssLoanException(ResultCodeContants.FAILED, "新增保险分期失败", e);
        }
    }

    @Override
    public Integer insertFssLoanDocument(List<FssLoanDocumentModel> fssLoanDocumentModels) {

        try {
            fssLoanDocumentModels.stream().forEach(
                    e -> fssLoanDocumentModelMapper.insert(e)
            );
        } catch (Exception e) {
            log.error(String.format("新增保险分期失败:%s", JSON.toJSONString(fssLoanDocumentModels)), e);
            throw new FssLoanException(ResultCodeContants.FAILED, "新增保险分期失败", e);
        }

        return null;
    }


    @Override
    public PaginatedResult<FssLoanModel> getPaginatorFssLoan(Paginator<FssLoanModel> paginator) {
        try {
            HashMap<String, Object> param = new HashMap<String, Object>();
            param.put("_limit", paginator.getPageSize());
            param.put("_offset",
                    (paginator.getCurrentPage() - 1) * paginator.getPageSize());
            BeanUtilsExt.copyPropertiesToMap(paginator.getParam(), param);

            List<FssLoanModel> list = this.fssLoanModelMapper.
                    getFssLoanPaging(param);
            Integer count = fssLoanModelMapper.getFssLoanPagingCount(param);
            PaginatedResult<FssLoanModel> paginatedResult = new PaginatedResult<FssLoanModel>();
            paginatedResult.setRows(list);
            paginatedResult.setTotal(count);
            return paginatedResult;
        } catch (Exception e) {
            log.error(
                    String.format("分页查询分期数据异常:%s",
                            ToStringBuilder.reflectionToString(paginator)), e);

            throw new FssLoanException(ResultCodeContants.FAILED,
                    "分页查询分期数据异常", e);
        }
    }


    @Override
    public Long saveLoan(LoanInfoModel loanInfoModel) {
        Long loanId = loanInfoModel.getLoanId();
        try {

            if (loanInfoModel.getLoanId() == null) {
                loanId = insertFssLoan(loanInfoModel.getFssLoanModel());
                loanInfoModel.setLoanId(loanId);
                if(loanInfoModel.getFssLoanDocumentModels()!=null) {
                    loanInfoModel.getFssLoanDocumentModels().stream().forEach(
                            e -> e.setLoanId(loanInfoModel.getLoanId()));
                    insertFssLoanDocument(loanInfoModel.getFssLoanDocumentModels());
                }

            } else {
                fssLoanModelMapper.updateByPrimaryKey(loanInfoModel.getFssLoanModel());
                loanInfoModel.getFssLoanDocumentModels().stream().forEach(
                        e -> fssLoanDocumentModelMapper.updateByPrimaryKey(e));

            }
        } catch (Exception e) {
            log.error(
                    String.format("报错分期数据失败:%s",
                            JSON.toJSONString(loanInfoModel)), e);

            throw new FssLoanException(ResultCodeContants.FAILED,
                    "保存分期数据失败", e);
        }
        return loanId;
    }

    @Override
    public void submitLoan(LoanInfoModel loanInfoModel,String operater) {
        Long loanId = saveLoan(loanInfoModel);
        FlowDataModel flowDataModel = new FlowDataModel();
        flowDataModel.setLoanId(loanId);
        flowDataModel.setFlowToStatus(FssLoanStatusEnum.AUDITING);
        flowDataModel.setOperater(operater);
        flowDataModel.setContent(FssLoanStatusEnum.AUDITING.desc());
        fssFlowManage.flow(flowDataModel);
    }

    @Override
    public void returnLoan(Long loanId,String operater) {
        FlowDataModel flowDataModel = new FlowDataModel();
        flowDataModel.setLoanId(loanId);
        flowDataModel.setFlowToStatus(FssLoanStatusEnum.WAITING_REVISED);
        flowDataModel.setOperater(operater);
        flowDataModel.setContent(FssLoanStatusEnum.WAITING_REVISED.desc());
        fssFlowManage.flow(flowDataModel);
    }

    @Override
    public void applyLoan(Long loanId,List<FssLoanDocumentModel> fssLoanDocumentModelList,String operater) {
        if(fssLoanDocumentModelList!=null&&fssLoanDocumentModelList.size()>0) {
            insertFssLoanDocument(fssLoanDocumentModelList);
        }
        FlowDataModel flowDataModel = new FlowDataModel();
        flowDataModel.setLoanId(loanId);
        flowDataModel.setFlowToStatus(FssLoanStatusEnum.APPLY_LOAN);
        flowDataModel.setOperater(operater);
        flowDataModel.setContent(FssLoanStatusEnum.APPLY_LOAN.desc());
        fssFlowManage.flow(flowDataModel);
    }

    @Override
    public void auditPass(Long loanId,String operater) {
        FlowDataModel flowDataModel = new FlowDataModel();
        flowDataModel.setLoanId(loanId);
        flowDataModel.setFlowToStatus(FssLoanStatusEnum.WAITING_LOAN);
        flowDataModel.setOperater(operater);
        flowDataModel.setContent(FssLoanStatusEnum.WAITING_LOAN.desc());
        fssFlowManage.flow(flowDataModel);
    }
    @Override
    public void makeloan(Long loanId,String operater) {
        FlowDataModel flowDataModel = new FlowDataModel();
        flowDataModel.setLoanId(loanId);
        flowDataModel.setFlowToStatus(FssLoanStatusEnum.HAVE_LOAN);
        flowDataModel.setOperater(operater);
        flowDataModel.setContent(FssLoanStatusEnum.HAVE_LOAN.desc());
        fssFlowManage.flow(flowDataModel);
    }

}
