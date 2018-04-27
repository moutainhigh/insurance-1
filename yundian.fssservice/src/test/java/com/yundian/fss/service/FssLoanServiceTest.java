package com.yundian.fss.service;

import com.alibaba.fastjson.JSON;
import com.yundian.fss.test.AbstractJUnit;
import com.yundian.fssapi.domain.FssLoanDocumentModel;
import com.yundian.fssapi.domain.FssLoanModel;
import com.yundian.fssapi.domain.statistics.LoanInfoModel;
import com.yundian.fssapi.service.FssLoanService;
import com.yundian.result.Page;
import com.yundian.result.Paginator;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 分期测试
 *
 * @author jnx
 * @create 2018/4/13
 */
public class FssLoanServiceTest extends AbstractJUnit{

    @Autowired
    FssLoanService fssLoanService;

    @Test
    public void getFssLoan()
    {
        Long loanId=37L;
        LoanInfoModel loanInfoModel = fssLoanService.getFssLoan(loanId);
        System.out.printf(JSON.toJSONString(loanInfoModel));
        Assert.assertTrue(true);
    }

    @Test
    public void insertFssLoan()
    {
        FssLoanModel  fssLoanModel = new FssLoanModel();
        fssLoanModel.setDealerId(100L);
        fssLoanModel.setDealerName("上海湖滨汽车销售服务有限公司");
        fssLoanModel.setLoanCode("10100201010101000");
        fssLoanModel.setDealerUserName("Jnx");
        //fssLoanModel.setLoanId(1L);

        fssLoanService.insertFssLoan(fssLoanModel);
        System.out.printf(JSON.toJSONString(fssLoanModel));
        Assert.assertTrue(true);
    }
    @Test
    public void insertFssLoanDocument()
    {
        List<FssLoanDocumentModel> fssLoanDocumentModels = new ArrayList<>();
        FssLoanDocumentModel fssLoanDocumentModel = new FssLoanDocumentModel();
        fssLoanDocumentModel.setLoanId(137L);
        fssLoanDocumentModel.setFileUrl("http://cdn-file.cheguo.com/files/2016-08-29/201608290904011559647.png");
        fssLoanDocumentModel.setCtime(new Date());
        fssLoanDocumentModels.add(fssLoanDocumentModel);
        fssLoanService.insertFssLoanDocument(fssLoanDocumentModel.getLoanId(),fssLoanDocumentModels);
        System.out.printf(JSON.toJSONString(fssLoanDocumentModels));
        Assert.assertTrue(true);
    }

    @Test
    public void getPaginatorFssLoan()
    {
        Paginator<FssLoanModel> paginator = new Paginator<>();
        paginator.setPage(1);
        paginator.setPageSize(20);
        FssLoanModel fssLoanModel = new FssLoanModel();
        fssLoanModel.setDealerId(100L);
        fssLoanModel.setInsuresIdcard("411122198411078126");


        Page<FssLoanModel> paginatedResult = fssLoanService.getPaginatorFssLoan(paginator);
        System.out.printf("列表"+JSON.toJSONString(paginatedResult));
        Assert.assertTrue(true);
    }

    @Test
    public void submitLoan()
    {
        LoanInfoModel loanInfoModel=new LoanInfoModel();

        String operater="jnx";
        fssLoanService.submitLoan(loanInfoModel,operater);
        System.out.printf(JSON.toJSONString(loanInfoModel));
        Assert.assertTrue(true);
    }
}
