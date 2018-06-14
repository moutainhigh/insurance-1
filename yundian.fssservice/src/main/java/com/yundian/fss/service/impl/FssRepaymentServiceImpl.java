package com.yundian.fss.service.impl;

import com.yundian.fss.dao.FssLoanModelMapper;
import com.yundian.fss.dao.FssLoanRepaymentModelMapper;
import com.yundian.fss.dao.FssLoanRepaymentPlanModelMapper;
import com.yundian.fss.service.support.PaymentsUtils;
import com.yundian.fssapi.domain.FssLoanModel;
import com.yundian.fssapi.domain.FssLoanRepaymentModel;
import com.yundian.fssapi.domain.FssLoanRepaymentPlanModel;
import com.yundian.fssapi.enums.FssRepaymentStatusEnum;
import com.yundian.fssapi.exception.FssLoanException;
import com.yundian.fssapi.exception.FssRepaymentException;
import com.yundian.fssapi.service.FssRepaymentService;
import com.yundian.result.Page;
import com.yundian.result.PageProvider;
import com.yundian.result.Paginator;
import com.yundian.result.ResultCodeContants;
import com.yundian.toolkit.utils.BeanUtilsExt;
import com.yundian.toolkit.utils.BigDecimalUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
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
public class FssRepaymentServiceImpl implements FssRepaymentService {

    @Autowired
    FssLoanRepaymentModelMapper fssLoanRepaymentModelMapper;
    @Autowired
    FssLoanRepaymentPlanModelMapper fssLoanRepaymentPlanModelMapper;

    @Autowired
    FssLoanModelMapper fssLoanModelMapper;
    @Override
    public void initRepaymentPlan(Long loanId) {

        //月还款额=本金*月利率*(1+月利率)^n/[(1+月利率)^n-1]
        //月利率=年利率／12

        FssLoanModel fssLoanModel = fssLoanModelMapper.selectByPrimaryKey(loanId);
        if(fssLoanModel==null
                ||fssLoanModel.getAgreeRepaymentDate()==null
                ||fssLoanModel.getPlanLoanAmount()==null
                ||fssLoanModel.getLoanRate()==null
                ||fssLoanModel.getPlanPeriod()==null){
            throw new FssRepaymentException("","订单数据校验失败,约定还款日、贷款金额、贷款利率不能为空！");
        }
        try {
            LocalDate today = LocalDate.now();
            LocalDate agreepayment = LocalDate.of(today.getYear(), today.getMonthValue(), fssLoanModel.getAgreeRepaymentDate());

            List<FssLoanRepaymentPlanModel> fssLoanRepaymentPlanModelList = new ArrayList<>();
            for (int i = 1; i <= fssLoanModel.getPlanPeriod(); i++) {

                FssLoanRepaymentPlanModel planModel = new FssLoanRepaymentPlanModel();
                planModel.setLoanId(loanId);

                planModel.setAgreedRepaymentDate(agreepayment.plusMonths(i).toString());
                planModel.setPeriod(i);
                planModel.setPeriodCount(fssLoanModel.getPlanPeriod());


//                double monthRate = BigDecimalUtil.div(fssLoanModel.getLoanRate(), 12)/100;
//                //月供，单位 分
//                Integer paymentMonth = PaymentsUtils.getPaymentsForMonth(fssLoanModel.getPlanLoanAmount(),
//                        monthRate,
//                        fssLoanModel.getPlanPeriod());
//                Integer monthInterestMoney = PaymentsUtils.getMonthInterestMoney(fssLoanModel.getPlanLoanAmount(),
//                        monthRate,
//                        i,
//                        fssLoanModel.getPlanPeriod()
//                );
                //利息
                planModel.setPlanInterestAmount(0);
                //月供
                Integer monthAmout = PaymentsUtils.getMonthMoney(fssLoanModel.getPlanLoanAmount(),fssLoanModel.getPlanPeriod());
                planModel.setPlanAmount(monthAmout);

                //本金
                planModel.setPlanCaptialAmount(monthAmout);
                //实际要还款
                planModel.setPayAmount(monthAmout);

                planModel.setRepaymentStatus(FssRepaymentStatusEnum.PENDINGREPAYMENT.name());
                fssLoanRepaymentPlanModelList.add(planModel);
            }
            fssLoanRepaymentPlanModelList.stream().forEach((e) -> {
                e.setCtime(new Date());
                e.setMtime(new Date());
                fssLoanRepaymentPlanModelMapper.insert(e);
            });
        }catch(Exception e){
            log.error(
                    String.format("生成还款计划异常:loanId:%s",loanId), e);
            throw new FssRepaymentException(ResultCodeContants.FAILED,
                    "生成还款计划异常", e);
        }

    }

    @Override
    public void repayment(Long loanId, Integer period, Integer payAmount) {

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
                    getFssLoanRepaymentPlanPaging(param);
            Integer count = fssLoanRepaymentPlanModelMapper.getFssLoanRepaymentPlanPagingCount(param);
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
            Integer count = fssLoanRepaymentPlanModelMapper.getFssLoanRepaymentPlanPagingCount(param);
            return PageProvider.getPage(paginator,count,list,FssLoanRepaymentModel.class);

        } catch (Exception e) {
            log.error(
                    String.format("查询还款数据异常:%s",
                            ToStringBuilder.reflectionToString(paginator)), e);

            throw new FssRepaymentException(ResultCodeContants.FAILED,
                    "查询还款数据异常", e);
        }

    }
}
