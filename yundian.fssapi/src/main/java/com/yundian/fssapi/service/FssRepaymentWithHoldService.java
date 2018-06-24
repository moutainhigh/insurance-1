package com.yundian.fssapi.service;

import com.yundian.fssapi.haier.request.RefundNotifyRequest;
import com.yundian.fssapi.haier.request.WitholdingNotifyRequest;

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
 void tradeRefund();

 /**
  * 查询
  */
 void tradeQuery(String kjtTradeCode);

 /**
  * 通知代扣
  */
 void notifyWithHold(WitholdingNotifyRequest notifyRequest);

 /**
  * 通知退款
  */
 void notifyRefund(RefundNotifyRequest refundNotifyRequest);

}
