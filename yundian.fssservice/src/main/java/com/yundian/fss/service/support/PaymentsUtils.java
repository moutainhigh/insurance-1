package com.yundian.fss.service.support;

import com.yundian.toolkit.utils.BigDecimalUtil;
import com.yundian.toolkit.utils.NumberUtil;

/**
 * 还款月供计算
 *
 * @author jnx
 * @create 2018/5/23
 */
public class PaymentsUtils {
    /**
     * 计算月还款额(单位：分）,向上取整
     * @param principal 总本金，贷款金额
     * @param rateMonth 月利率
     * @param periodCount 期数
     * @return
     */
    public static Integer  getPaymentsForMonth(int principal,double rateMonth,int periodCount){
        //月还款额=本金*月利率*(1+月利率)^n/[(1+月利率)^n-1]
        double principalRateMonth = BigDecimalUtil.mul(principal,rateMonth);
        System.out.println("principalRateMonth:"+principalRateMonth);
        double rateMonthExponent = BigDecimalUtil.pow((1+rateMonth),periodCount);
        System.out.println("rateMonthExponent:"+rateMonthExponent);
        Double paymentsMonth = BigDecimalUtil.div(BigDecimalUtil.mul(principalRateMonth,rateMonthExponent),(rateMonthExponent-1));
        //向上取整
        paymentsMonth = Math.floor(paymentsMonth/100)*100;
        return paymentsMonth.intValue();
    }

    /**
     * 计算分期，每月利息
     * @param totalmoney 单位：分
     * @param rateMonth
     * @param period
     * @param periodCount
     * @return
     */
    public static Integer getMonthInterestMoney(int totalmoney,double rateMonth,int period,int periodCount) {
        //每月利息额
        Double monthinterestmoney=totalmoney*rateMonth*(Math.pow((1+rateMonth),periodCount)-Math.pow((1+rateMonth),(period-1)))/(Math.pow((1+rateMonth),periodCount)-1);
        //向上取整
        monthinterestmoney = Math.floor(monthinterestmoney/100)*100;
        return monthinterestmoney.intValue();

    }

    /**
     * 计算月供，total/periodCount,向上取整
     * @param totalMoney
     * @param periodCount
     * @return
     */
    public static Integer getMonthMoney(int totalMoney,int periodCount){
        double monthDouble =totalMoney/periodCount;
        //向上取整
        Double monthDoubleObj = Math.floor(totalMoney/100)*100;

        return monthDoubleObj.intValue();
    }

    /**
     * 分为单位的金额，转换为元，保留小时2位
     * @param money
     * @return
     */
    public static String moneyFormat(Integer money){

        double f = money/100;
        return NumberUtil.format2Str(f);
    }
    public static void main(String[] args){

        Integer amount = getPaymentsForMonth(400000,0.01,12);
        System.out.println("月供："+amount);
//
//        Integer monthinterestmoney = getMonthInterestMoney(700000,0.01,1,12);
//        System.out.println("每月利息："+monthinterestmoney);
    }
}
