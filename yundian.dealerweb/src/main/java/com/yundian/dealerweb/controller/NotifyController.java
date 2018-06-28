package com.yundian.dealerweb.controller;

import com.alibaba.fastjson.JSON;
import com.yundian.fssapi.haier.notify.param.RefundNotifyParam;
import com.yundian.fssapi.haier.notify.param.WitholdingNotifyParam;
import com.yundian.fssapi.service.FssRepaymentWithHoldService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.util.Map;

/**
 * 支付通知
 * @author jnx
 * @create 2018/6/22
 */
@Slf4j
@Controller
public class NotifyController {

    @Autowired
    FssRepaymentWithHoldService fssRepaymentWithHoldService;

    @RequestMapping("/notify/witholding")
    public void witholding(@ModelAttribute("witholdingNotifyParam") WitholdingNotifyParam witholdingNotifyParam,
                           HttpServletRequest request, HttpServletResponse response) {
        try {

            Enumeration em = request.getParameterNames();
            while (em.hasMoreElements()) {
                String name = (String) em.nextElement();
                String value = request.getParameter(name);
                log.info(String.format("代扣通知：name=%s,value=%s",name,value));
            }

            log.info(String.format("********代扣异步通知开始*****\n,request_param:%s", JSON.toJSONString(witholdingNotifyParam)));
            boolean isVerfiySignSuccess = fssRepaymentWithHoldService.verfiySign(witholdingNotifyParam.getSignMap(),witholdingNotifyParam.getSign());
            if(!isVerfiySignSuccess){
                log.error("代扣异步通知：验签失败！");
                reponseWrite(response,"verfiy sign failed!");
                return;
            }
            fssRepaymentWithHoldService.notifyWithHold(witholdingNotifyParam);
           reponseWrite(response,"success");
        } catch (Exception ex) {
            log.error(String.format("代扣异步通知处理失败：%s",ex));
            reponseWrite(response,"failed");
        }
    }


    @RequestMapping("/notify/refund")
    public void refund(@ModelAttribute("refundNotifyParam") RefundNotifyParam refundNotifyParam,
                       HttpServletRequest request, HttpServletResponse response) {

        try {
            log.info(String.format("********退款异步通知开始*****\n,request_param:%s", JSON.toJSONString(refundNotifyParam)));
            boolean isVerfiySignSuccess = fssRepaymentWithHoldService.verfiySign(refundNotifyParam.getSignMap(), refundNotifyParam.getSign());
            if(!isVerfiySignSuccess){
                log.error("退款异步通知：验签失败！");
                reponseWrite(response,"verfiy sign failed!");
                return;
            }
            fssRepaymentWithHoldService.notifyRefund(refundNotifyParam);
            reponseWrite(response,"success");

        } catch (Exception ex) {
            log.error(String.format("退款异步通知异常：%s",ex));
            reponseWrite(response,"failed");
        }
    }


    private void reponseWrite(HttpServletResponse response, String msg) {
        try {
            response.setContentType("text/html; charset=UTF-8");
            response.getWriter().write(msg);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

}
