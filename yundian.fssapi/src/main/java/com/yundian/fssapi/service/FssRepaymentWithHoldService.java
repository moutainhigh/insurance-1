package com.yundian.fssapi.service;

import com.yundian.fssapi.haier.notify.param.RefundNotifyParam;
import com.yundian.fssapi.haier.notify.param.WitholdingNotifyParam;
import com.yundian.fssapi.haier.response.HaierResult;
import com.yundian.fssapi.haier.response.HaierTradeQueryResponse;

import java.util.Map;

/**
 *代扣服务
 */
public interface FssRepaymentWithHoldService {

 /**
  * 验签
  * @param param 所有参数
  * @param sign 签名字段
  * @return
  */
  Boolean verfiySign(Map<String, String> param,String sign);


 /**
  * 提交代扣
  */
 void tradeWithHolding(Long planId);

 /**
  * 批量提交代扣
  *
  */
 void batchTradeWithHolding();

 /**
  * 提交退款
  */
 void tradeRefund(Long repaymentOrderId);

 /**
  * 查询
  */
 HaierResult<HaierTradeQueryResponse> tradeQuery(String kjtTradeCode);

 /**
  * 通知代扣
  */
 void notifyWithHold(WitholdingNotifyParam notifyRequest);

 /**
  * 通知退款
  */
 void notifyRefund(RefundNotifyParam refundNotifyParam);

}
