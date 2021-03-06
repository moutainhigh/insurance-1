package com.yundian.fss.service;

import com.alibaba.fastjson.JSON;
import com.yundian.fss.test.AbstractJUnit;
import com.yundian.fssapi.domain.FssDealerCustomerModel;
import com.yundian.fssapi.service.FssDealerCustomerService;
import com.yundian.result.Page;
import com.yundian.result.PaginatedResult;
import com.yundian.result.Paginator;
import com.yundian.toolkit.excel.ExcelUtil;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * aa
 *
 * @author jnx
 * @create 2018/4/13
 */
public class FssDealerCustomerServiceTest extends AbstractJUnit {

    @Autowired
    FssDealerCustomerService fssDealerCustomerService;


    @Test
    public void getFssDealerCustomerTest()
    {
        Long customerId =100L;
        FssDealerCustomerModel fssDealerCustomerModel = fssDealerCustomerService.getFssDealerCustomer(customerId);
        System.out.printf(JSON.toJSONString(fssDealerCustomerModel));
        Assert.assertTrue(true);
    }

    @Test
    public void insertFssDealerCustomerTest()
    {

        FssDealerCustomerModel fssDealerCustomerModel = new FssDealerCustomerModel();
        fssDealerCustomerModel.setDealerId(100L);
        fssDealerCustomerModel.setName("陈丽");
        fssDealerCustomerModel.setPhone("137582928191");
        fssDealerCustomerModel.setInsuresName("陈丽");
        fssDealerCustomerService.insertFssDealerCustomer(fssDealerCustomerModel);
        System.out.printf(JSON.toJSONString(fssDealerCustomerModel));
        Assert.assertTrue(true);
    }


    @Test
    public void getPaginatorFssDealerCustomerTest()
    {
        Paginator<FssDealerCustomerModel> paginator = new Paginator<>();
        paginator.setPageSize(20);
        paginator.setPage(1);
        FssDealerCustomerModel fssDealerCustomerModel = new FssDealerCustomerModel();
        fssDealerCustomerModel.setDealerId(100L);
        Page<FssDealerCustomerModel> pa= fssDealerCustomerService.getPaginatorFssDealerCustomer(paginator);
        System.out.printf(JSON.toJSONString(pa));
        Assert.assertTrue(true);

    }
    @Test
    public void importXlsDealerCustom(){
//        String xlsPath="http://luoyioss.oss-cn-hangzhou.aliyuncs.com/files/2018-06-14/20180614174920775cTnQ.xls";
//        long dealerId=100;
//        fssDealerCustomerService.importXlsDealerCustomer(xlsPath,dealerId);

    }


}
