package com.yundian.dealerweb.controller;

import com.alibaba.fastjson.JSON;
import com.yundian.fssapi.domain.FssCodeLibraryModel;
import com.yundian.fssapi.domain.FssDealerCustomerModel;
import com.yundian.fssapi.haier.request.RefundNotifyRequest;
import com.yundian.fssapi.haier.request.WitholdingNotifyRequest;
import com.yundian.fssapi.service.FssCodeLibraryService;
import com.yundian.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 支付通知
 * @author jnx
 * @create 2018/6/22
 */
@Slf4j
@Controller
public class NotifyController {

    @Autowired
    FssCodeLibraryService fssCodeLibraryService;

    @RequestMapping("/notify/witholding")
    public void witholding(@ModelAttribute("witholdingNotifyRequest") WitholdingNotifyRequest  witholdingNotifyRequest) {

        try {

            log.info(String.format("********代扣异步通知开始*****\n,request_param:%s", JSON.toJSONString(witholdingNotifyRequest)));


        } catch (Exception ex) {
            log.error(String.format("代扣异步通知处理失败：%s",ex));
        }
    }


    @RequestMapping("/notify/refund")
    public void refund(@ModelAttribute("refundNotifyRequest") RefundNotifyRequest refundNotifyRequest) {

        try {
            log.info(String.format("********退款异步通知开始*****\n,request_param:%s", JSON.toJSONString(refundNotifyRequest)));


        } catch (Exception ex) {
            log.error(String.format("退款异步通知开始：%s",ex));
        }
    }


}
