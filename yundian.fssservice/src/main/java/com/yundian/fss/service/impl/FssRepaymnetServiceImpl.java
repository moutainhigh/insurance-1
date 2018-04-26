package com.yundian.fss.service.impl;

import com.yundian.fss.dao.FssLoanRepaymentModelMapper;
import com.yundian.fss.dao.FssLoanRepaymentPlanModelMapper;
import com.yundian.fssapi.domain.FssLoanDocumentModel;
import com.yundian.fssapi.domain.FssLoanModel;
import com.yundian.fssapi.domain.FssLoanRepaymentModel;
import com.yundian.fssapi.domain.FssLoanRepaymentPlanModel;
import com.yundian.fssapi.domain.statistics.LoanInfoModel;
import com.yundian.fssapi.exception.FssLoanException;
import com.yundian.fssapi.service.FssRepaymentService;
import com.yundian.result.Page;
import com.yundian.result.PageProvider;
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
 * 还款服务
 *
 * @author jnx
 * @create 2018/4/13
 */
@Slf4j
@Service("fssRepaymentService")
public class FssRepaymnetServiceImpl implements FssRepaymentService {

    @Autowired
    FssLoanRepaymentModelMapper fssLoanRepaymentModelMapper;
    @Autowired
    FssLoanRepaymentPlanModelMapper fssLoanRepaymentPlanModelMapper;

    @Override
    public void initRepaymentPlan(Long loanId) {

    }

    @Override
    public Page<FssLoanRepaymentPlanModel> getRepaymentPlan(Paginator<FssLoanRepaymentPlanModel> paginator) {

        try {
            HashMap<String, Object> param = new HashMap<String, Object>();
            param.put("_limit", paginator.getPageSize());
            param.put("_offset",
                    (paginator.getPage() - 1) * paginator.getPageSize());
            BeanUtilsExt.copyPropertiesToMap(paginator.getParam(), param);
            List<FssLoanRepaymentPlanModel> list = fssLoanRepaymentPlanModelMapper.
                    getFssLoanRepaymentPlaPaging(param);
            Integer count = fssLoanRepaymentPlanModelMapper.getFssLoanPagingCount(param);
            return PageProvider.getPage(paginator,count,list,FssLoanRepaymentPlanModel.class);

        } catch (Exception e) {
            log.error(
                    String.format("分页查询还款计划数据异常:%s",
                            ToStringBuilder.reflectionToString(paginator)), e);

            throw new FssLoanException(ResultCodeContants.FAILED,
                    "查询还款计划数据异常", e);
        }
    }

    @Override
    public Page<FssLoanRepaymentModel> getRepaymentDetail(Paginator<FssLoanRepaymentModel> paginator) {

        try {
            HashMap<String, Object> param = new HashMap<String, Object>();
            param.put("_limit", paginator.getPageSize());
            param.put("_offset",
                    (paginator.getPage() - 1) * paginator.getPageSize());
            BeanUtilsExt.copyPropertiesToMap(paginator.getParam(), param);
            List<FssLoanRepaymentModel> list = fssLoanRepaymentModelMapper.getFssLoanRepaymentPaging(param);
            Integer count = fssLoanRepaymentPlanModelMapper.getFssLoanPagingCount(param);
            return PageProvider.getPage(paginator,count,list,FssLoanRepaymentModel.class);

        } catch (Exception e) {
            log.error(
                    String.format("查询还款数据异常:%s",
                            ToStringBuilder.reflectionToString(paginator)), e);

            throw new FssLoanException(ResultCodeContants.FAILED,
                    "查询还款数据异常", e);
        }

    }
}
