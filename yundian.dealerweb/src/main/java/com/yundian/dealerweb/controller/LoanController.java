package com.yundian.dealerweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 保险分期
 *
 * @author jnx
 * @create 2018/4/10
 */
@Controller
public class LoanController {

    @RequestMapping(value="/loanList",method= RequestMethod.GET)
    public String loanList(@RequestParam("name") String name) {

        return "loanList";

    }

    @RequestMapping(value="/addLoanPage",method= RequestMethod.GET)
    public String addLoanPage() {

        return "addLoanPage";

    }

    @RequestMapping(value="/addLoan",method= RequestMethod.POST)
    public String addLoan() {

        return "";

    }
}
