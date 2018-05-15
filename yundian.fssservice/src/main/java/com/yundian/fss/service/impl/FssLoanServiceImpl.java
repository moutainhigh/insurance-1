package com.yundian.fss.service.impl;

import com.alibaba.fastjson.JSON;
import com.yundian.fss.dao.*;
import com.yundian.fss.manager.FssFlowManage;
import com.yundian.fssapi.domain.*;
import com.yundian.fssapi.domain.statistics.FlowDataModel;
import com.yundian.fssapi.domain.statistics.LoanInfoModel;
import com.yundian.fssapi.enums.FssLoanStatusEnum;
import com.yundian.fssapi.exception.FssLoanException;
import com.yundian.fssapi.service.FssCarService;
import com.yundian.fssapi.service.FssLoanService;
import com.yundian.result.*;
import com.yundian.toolkit.utils.BeanUtilsExt;
import com.yundian.toolkit.utils.RandomUtil;
import com.yundian.toolkit.utils.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
    FssCarBrandModelMapper fssCarBrandModelMapper;
    @Autowired
    FssCarSeriesModelMapper fssCarSeriesModelMapper;
    @Autowired
    FssCarModelsModelMapper fssCarModelsModelMapper;
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
            fssLoanModel.setAuditStatus(FssLoanStatusEnum.INIT.code());
            fssLoanModel.setAuditStatusPre(FssLoanStatusEnum.INIT.code());
            fssLoanModel.setLoanCode("L"+ RandomUtil.getRandomCode());
             fssLoanModelMapper.insert(fssLoanModel);
            return fssLoanModel.getLoanId();
        } catch (Exception e) {
            log.error(String.format("新增保险分期失败:%s", JSON.toJSONString(fssLoanModel)), e);
            throw new FssLoanException(ResultCodeContants.FAILED, "新增保险分期失败", e);
        }
    }

    @Override
    public void updateFssLoan(FssLoanModel fssLoanModel) {

        try {
            fssLoanModelMapper.updateByPrimaryKeySelective(fssLoanModel);
        } catch (Exception e) {
            log.error(String.format("修改保险分期失败:%s", JSON.toJSONString(fssLoanModel)), e);
            throw new FssLoanException(ResultCodeContants.FAILED, "新增保险分期失败", e);
        }
    }

    @Override
    public Integer insertFssLoanDocument(Long loanId,List<FssLoanDocumentModel> fssLoanDocumentModels) {

        try {

            //按照文档类型删除图谱
            Map<String,List<FssLoanDocumentModel>> mapGroupby =  fssLoanDocumentModels.stream().collect(Collectors.groupingBy(FssLoanDocumentModel::getDocumentType));
            for(String key:mapGroupby.keySet()) {
                if(StringUtil.isNotBlank(key)) {
                    fssLoanDocumentModelMapper.deleteByDocmentType(loanId, key);
                }
            }
            //新增文档
            fssLoanDocumentModels.stream().forEach(
                    e ->{
                        e.setLoanId(loanId);
                        fssLoanDocumentModelMapper.insert(e);
                    }
            );
        } catch (Exception e) {
            log.error(String.format("新增保险分期失败:%s", JSON.toJSONString(fssLoanDocumentModels)), e);
            throw new FssLoanException(ResultCodeContants.FAILED, "新增保险分期失败", e);
        }

        return null;
    }

    @Override
    public Integer updateFssLoanDocment(Long loanId,List<FssLoanDocumentModel> fssLoanDocumentModels) {


        return null;
    }

    @Override
    public Page<FssLoanModel> getPaginatorFssLoan(Paginator<FssLoanModel> paginator) {
        try {
            HashMap<String, Object> param = new HashMap<String, Object>();
            param.put("_limit", paginator.getPageSize());
            param.put("_offset",
                    (paginator.getPage() - 1) * paginator.getPageSize());
            BeanUtilsExt.copyPropertiesToMap(paginator.getParam(), param);
            List<FssLoanModel> list = this.fssLoanModelMapper.
                    getFssLoanPaging(param);
            Integer count = fssLoanModelMapper.getFssLoanPagingCount(param);
            return PageProvider.getPage(paginator,count,list,FssLoanModel.class);

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
            FssLoanModel fssLoanModel = loanInfoModel.getFssLoanModel();
            if(fssLoanModel!=null&& StringUtil.isNotBlank(fssLoanModel.getCarBrand())){
               FssCarBrandModel fssCarBrandModel= fssCarBrandModelMapper.selectByBrandCode(fssLoanModel.getCarBrand());
               fssLoanModel.setCarBrandName(fssCarBrandModel.getBrandName());
            }
            if(fssLoanModel!=null&& StringUtil.isNotBlank(fssLoanModel.getCarVehicle())){
                FssCarSeriesModel fssCarSeriesModel= fssCarSeriesModelMapper.selectBySeriesCode(fssLoanModel.getCarVehicle());
                fssLoanModel.setCarVehicleName(fssCarSeriesModel.getSeriesName());
            }
            if(fssLoanModel!=null&& StringUtil.isNotBlank(fssLoanModel.getCarModel())){
                FssCarModelsModel fssCarModelsModel= fssCarModelsModelMapper.selectByModelsCode(fssLoanModel.getCarModel());
                fssLoanModel.setCarModelName(fssCarModelsModel.getModelsName());
            }
            if (loanInfoModel.getLoanId() == null) {
                loanId = insertFssLoan(loanInfoModel.getFssLoanModel());
                loanInfoModel.setLoanId(loanId);
                if(loanInfoModel.getFssLoanDocumentModels()!=null) {
                    loanInfoModel.getFssLoanDocumentModels().stream().forEach(
                            e -> e.setLoanId(loanInfoModel.getLoanId()));
                    insertFssLoanDocument(loanId,loanInfoModel.getFssLoanDocumentModels());
                }

            } else {
                fssLoanModelMapper.updateByPrimaryKeySelective(loanInfoModel.getFssLoanModel());
                if(loanInfoModel.getFssLoanDocumentModels()!=null) {
                    loanInfoModel.getFssLoanDocumentModels().stream().forEach(
                            e -> fssLoanDocumentModelMapper.updateByPrimaryKeySelective(e));
                }
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
        flowDataModel.setFlowPreStatus(FssLoanStatusEnum.INIT);
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
            insertFssLoanDocument(loanId,fssLoanDocumentModelList);
        }
        FlowDataModel flowDataModel = new FlowDataModel();
        flowDataModel.setLoanId(loanId);
        flowDataModel.setFlowToStatus(FssLoanStatusEnum.WAITING_LOAN);
        flowDataModel.setOperater(operater);
        flowDataModel.setContent(FssLoanStatusEnum.WAITING_LOAN.desc());
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
    /**
     * 审核拒绝
     */
    @Override
    public  void auditReject(Long loanId,String reason,String operater){
        FlowDataModel flowDataModel = new FlowDataModel();
        flowDataModel.setLoanId(loanId);
        flowDataModel.setFlowToStatus(FssLoanStatusEnum.CLOSED);
        flowDataModel.setOperater(operater);
        flowDataModel.setContent(FssLoanStatusEnum.CLOSED.desc());
        fssFlowManage.flow(flowDataModel);
    }

}
