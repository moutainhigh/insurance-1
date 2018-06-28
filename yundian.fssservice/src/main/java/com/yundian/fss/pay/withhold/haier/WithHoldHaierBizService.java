package com.yundian.fss.pay.withhold.haier;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.kjtpay.gateway.common.domain.VerifyResult;
import com.kjtpay.gateway.common.util.security.SecurityService;
import com.yundian.fss.biz.service.FssLoanRepaymentPlanBizService;
import com.yundian.fss.biz.service.FssRepaymentOrderBizService;
import com.yundian.fss.dao.FssLoanModelMapper;
import com.yundian.fss.service.support.PaymentsUtils;
import com.yundian.fss.service.support.TradeNoUtils;
import com.yundian.fssapi.domain.FssLoanModel;
import com.yundian.fssapi.domain.FssLoanRepaymentPlanModel;
import com.yundian.fssapi.domain.FssRepaymentOrderModel;
import com.yundian.fssapi.enums.FssRepaymentOrderStatusEnum;
import com.yundian.fssapi.enums.FssRepaymentOrderTradeTypeEnum;
import com.yundian.fssapi.exception.FssRepaymentException;
import com.yundian.fssapi.haier.response.HaierResult;
import com.yundian.fssapi.haier.response.HaierTradeBankWitholdingResponse;
import com.yundian.fssapi.haier.response.HaierTradeQueryResponse;
import com.yundian.fssapi.haier.response.HaierTradeRefundResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

/**
 * 快捷通代扣
 *
 * @author jnx
 * @create 2018/5/31
 */
@Slf4j
@Component("withHoldHaierBizService")
public class WithHoldHaierBizService {

    @Autowired
    SecurityService securityService;

    public static final String BIZ_CONTENT_KEY="biz_content";

    public static final String SIGN_TYPE_KEY="sign_type";

    public static final String CHARSET_KEY="charset";
    @Autowired
    HaierTradeBankWitholdingRequest haierTradeBankWitholdingRequest;

    @Autowired
    HaierTradeQueryRequest haierTradeQueryRequest;


    @Autowired
    HaierTradeRefundRequest haierTradeRefundRequest;


    @Autowired
    FssRepaymentOrderBizService fssRepaymentOrderBizService;

    @Autowired
    FssLoanRepaymentPlanBizService fssLoanRepaymentPlanBizService;
    @Autowired
    FssLoanModelMapper fssLoanModelMapper;

    /**
     *提交代扣网关
     */
    public void tradeBankWithHolding(FssLoanRepaymentPlanModel planModel){

        if(planModel.getInPayment()!=null&&planModel.getInPayment()==1){
            String infoMessage = String.format("还款计划代扣中，忽略，订单%s，期数%s",
                    planModel.getLoanId(),planModel.getPeriod());
            log.info(infoMessage);
            return ;
        }

        FssLoanModel fssLoanModel= fssLoanModelMapper.selectByPrimaryKey(planModel.getLoanId());

        FssRepaymentOrderModel repaymentOrderModel = new FssRepaymentOrderModel();
        repaymentOrderModel.setPlanId(planModel.getId());
        repaymentOrderModel.setLoanId(planModel.getLoanId());
        repaymentOrderModel.setPeriod(planModel.getPeriod());
        repaymentOrderModel.setBankAccountName(fssLoanModel.getInsuresName());
        repaymentOrderModel.setBankCardNo(fssLoanModel.getRepaymentCard());
        repaymentOrderModel.setBankCode(fssLoanModel.getRepaymentBankCode());
        repaymentOrderModel.setCertificatesNumber(fssLoanModel.getInsuresIdcard());
        repaymentOrderModel.setPayAmount(planModel.getPayAmount());
        repaymentOrderModel.setTradeType(FssRepaymentOrderTradeTypeEnum.WITHOLDING.name());
        repaymentOrderModel.setTradeNo(TradeNoUtils.generateWitholdingTradeNo());
        repaymentOrderModel.setRequestNo(TradeNoUtils.generateRequestNo());
        repaymentOrderModel.setPayTime(new Date());
        repaymentOrderModel.setCtime(new Date());
        repaymentOrderModel.setMtime(new Date());
        repaymentOrderModel.setTradeStatus(FssRepaymentOrderStatusEnum.INIT.name());
        try {
            HaierResult<HaierTradeBankWitholdingResponse> responseHaierResult =
                    haierTradeBankWitholdingRequest.invoke(repaymentOrderModel.getRequestNo(), repaymentOrderModel.getTradeNo(), repaymentOrderModel.getBankAccountName()
                            , repaymentOrderModel.getBankCardNo(), repaymentOrderModel.getBankCode(), repaymentOrderModel.getCertificatesNumber()
                            , PaymentsUtils.moneyFormat(repaymentOrderModel.getPayAmount()));

            if (HaierStatusCode.S10000.name().equals(responseHaierResult.getCode())) {
                // 调用成功

                HaierTradeBankWitholdingResponse witholdingResponse = responseHaierResult.getBiz_content();
                FssRepaymentOrderStatusEnum orderStatusEnum = Enum.valueOf(FssRepaymentOrderStatusEnum.class, witholdingResponse.getStatus());
                repaymentOrderModel.setTradeStatus(orderStatusEnum.name());
                repaymentOrderModel.setBankTradeNo(witholdingResponse.getTrade_no());
                if(orderStatusEnum ==FssRepaymentOrderStatusEnum.P||
                        orderStatusEnum ==FssRepaymentOrderStatusEnum.S){
                    //受理成功，设置还款计划 扣款中
                    fssLoanRepaymentPlanBizService.updateRepaymentPlanPaymenting(planModel.getId());
                }
            } else {
                repaymentOrderModel.setTradeStatus(FssRepaymentOrderStatusEnum.FAILED.name());
                String remark = String.format("subCode:%s,msg:%s", responseHaierResult.getSub_code(), responseHaierResult.getSub_msg());
                repaymentOrderModel.setTradeRemark(remark);
            }
        }catch (Exception e){
            String errorMessage =String.format("调用代扣接口失败，原因：%s",e.getMessage());
            log.error(errorMessage);
            repaymentOrderModel.setTradeRemark(errorMessage);
        }
        fssRepaymentOrderBizService.initRepaymentOrder(repaymentOrderModel);

    }

    /**
     * 批量提交
     */
    public void batchTradeBankWithHolding(){


    }


    /**
     * 退款网关
     */
    public void tradeRefund(Long repaymentOrderId){
        FssRepaymentOrderModel orgOrderModel =fssRepaymentOrderBizService.getRepaymentOrderById(repaymentOrderId);
        if(!orgOrderModel.getTradeStatus().equals(FssRepaymentOrderStatusEnum.TRADE_FINISHED.name())&&
                !orgOrderModel.getTradeStatus().equals(FssRepaymentOrderStatusEnum.TRADE_SUCCESS.name())){
            String errorMessage =String.format("原始代扣订单状态[%s],不能退款！",orgOrderModel.getTradeStatus());
            throw new FssRepaymentException("tradeRefund",errorMessage);
        }
        FssRepaymentOrderModel repaymentOrderModel = new FssRepaymentOrderModel();
        repaymentOrderModel.setPlanId(orgOrderModel.getPlanId());
        repaymentOrderModel.setLoanId(orgOrderModel.getLoanId());
        repaymentOrderModel.setPeriod(orgOrderModel.getPeriod());
        repaymentOrderModel.setBankAccountName(orgOrderModel.getBankAccountName());
        repaymentOrderModel.setBankCardNo(orgOrderModel.getBankCardNo());
        repaymentOrderModel.setBankCode(orgOrderModel.getBankCode());
        repaymentOrderModel.setCertificatesNumber(orgOrderModel.getCertificatesNumber());
        repaymentOrderModel.setPayAmount(orgOrderModel.getPayAmount());
        repaymentOrderModel.setTradeNo(TradeNoUtils.generateRefundTradeNo());
        repaymentOrderModel.setOrgTradeNo(orgOrderModel.getTradeNo());
        repaymentOrderModel.setTradeType(FssRepaymentOrderTradeTypeEnum.REFUND.name());
        repaymentOrderModel.setRequestNo(TradeNoUtils.generateRequestNo());
        repaymentOrderModel.setPayTime(new Date());
        repaymentOrderModel.setCtime(new Date());
        repaymentOrderModel.setMtime(new Date());
        repaymentOrderModel.setTradeStatus(FssRepaymentOrderStatusEnum.INIT.name());

        try {
            HaierResult<HaierTradeRefundResponse> responseHaierResult =
                    haierTradeRefundRequest.invoke(repaymentOrderModel.getRequestNo(),
                            repaymentOrderModel.getTradeNo(),repaymentOrderModel.getOrgTradeNo(),PaymentsUtils.moneyFormat(repaymentOrderModel.getPayAmount()));

            if (HaierStatusCode.S10000.name().equals(responseHaierResult.getCode())) {
                // 调用成功
                HaierTradeRefundResponse tradeRefundResponse = responseHaierResult.getBiz_content();
                FssRepaymentOrderStatusEnum orderStatusEnum = Enum.valueOf(FssRepaymentOrderStatusEnum.class, tradeRefundResponse.getStatus());
                repaymentOrderModel.setTradeStatus(orderStatusEnum.name());
                repaymentOrderModel.setBankTradeNo(tradeRefundResponse.getTrade_no());
            } else {
                repaymentOrderModel.setTradeStatus(FssRepaymentOrderStatusEnum.FAILED.name());
                String remark = String.format("subCode:%s,msg:%s", responseHaierResult.getSub_code(), responseHaierResult.getSub_msg());
                repaymentOrderModel.setTradeRemark(remark);
            }
        }catch (Exception e){
            String errorMessage =String.format("调用代扣接口失败，原因：%s",e.getMessage());
            log.error(errorMessage);
            repaymentOrderModel.setTradeRemark(errorMessage);
        }
        fssRepaymentOrderBizService.initRepaymentOrder(repaymentOrderModel);

    }

    /**
     * 交易查询
     */
    public HaierResult<HaierTradeQueryResponse>   tradeQuery(String kjtTradeNo){

        try {
            return haierTradeQueryRequest.invoke(kjtTradeNo);
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return null;

    }

    /**
     * 验签
     */
    public Boolean verify(Map<String, String> param, String sign,String signType){

        VerifyResult verifyResult =null;

        String charset = "utf-8";

        try {
            if ("RSA".equals(signType)) {
                //RSA验签
                verifyResult = securityService.verify(param, sign, charset);
            } else if ("ITRUS".equals(signType)) {
                verifyResult = securityService.verify(param, sign, charset);
            }
            return verifyResult.isSuccess();
        }catch (Exception e )
        {
            log.error("快捷通验签失败!,param:"+ JSON.toJSONString(param)+",sign:"+sign);
            throw new FssRepaymentException("","快捷通验签失败！");
        }

    }

}
