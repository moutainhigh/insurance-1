package com.yundian.fss.service;

import com.alibaba.fastjson.JSON;
import com.yundian.fss.test.AbstractJUnit;
import com.yundian.fssapi.domain.FssCodeLibraryModel;
import com.yundian.fssapi.domain.FssDealerUserModel;
import com.yundian.fssapi.enums.FssDealerUserStatusEnum;
import com.yundian.fssapi.service.FssCodeLibraryService;
import com.yundian.fssapi.service.FssDealerUserService;
import com.yundian.result.PaginatedResult;
import com.yundian.result.Paginator;
import com.yundian.result.Result;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 代码字典配置表
 *
 * @author jnx
 * @create 2018/4/3
 */
public class FssDealerUserServiceTest extends AbstractJUnit{

    @Autowired
    FssDealerUserService fssDealerUserService;

    @Test
    public void fssFssDealerUserLoginTest()
    {
        FssDealerUserModel fssDealerUserModel =
                fssDealerUserService.fssFssDealerUserLogin("13758298275","298275");
        System.out.printf(JSON.toJSONString(fssDealerUserModel));
        Assert.assertTrue(true);
    }

    @Test
    public void getFssDealerUserTest()
    {
        FssDealerUserModel fssDealerUserModel =
                fssDealerUserService.getFssDealerUser(17L);
        System.out.printf(JSON.toJSONString(fssDealerUserModel));
        Assert.assertTrue(true);
    }

    @Test
    public void resetPwdTest()
    {
        Boolean result =fssDealerUserService.resetPwd(17L,"13758298275");
        Assert.assertTrue(true);
    }

    @Test
    public void insertFssDealerUserTest()
    {

        FssDealerUserModel fssDealerUserModel = new FssDealerUserModel();
        fssDealerUserModel.setDealerId(100L);
        fssDealerUserModel.setUserName("jnx");
        fssDealerUserModel.setRoleId("ADMIN");
        fssDealerUserModel.setName("jnx");
        fssDealerUserModel.setUserPwd("123456");
        fssDealerUserModel.setStatus(FssDealerUserStatusEnum.NORMAL.code());
                fssDealerUserService.insertFssDealerUser(fssDealerUserModel);

        System.out.printf(JSON.toJSONString(fssDealerUserModel));
        Assert.assertTrue(true);
    }


    @Test
    public void updateFssDealerUserTest()
    {
                FssDealerUserModel fssDealerUserModel = new FssDealerUserModel();
        fssDealerUserModel.setUserId(100004L);
        fssDealerUserModel.setDealerId(100L);
        fssDealerUserModel.setUserName("jnx1");
        fssDealerUserModel.setRoleId("ADMIN");
        fssDealerUserModel.setName("jnx1");

        fssDealerUserModel.setStatus(FssDealerUserStatusEnum.DISABLE.code());


                fssDealerUserService.updateFssDealerUser(fssDealerUserModel);
        System.out.printf(JSON.toJSONString(fssDealerUserModel));
        Assert.assertTrue(true);
    }

    @Test
    public void getPaginatorFssDealerUserTest()
    {
        Paginator<FssDealerUserModel> paginator= new Paginator<FssDealerUserModel>();
        paginator.setCurrentPage(1);
        paginator.setPageSize(20);
        FssDealerUserModel fssDealerUserModel = new FssDealerUserModel();
        fssDealerUserModel.setDealerId(100L);
        fssDealerUserModel.setUserName("13758298275");
        paginator.setParam(fssDealerUserModel);

        PaginatedResult<FssDealerUserModel> paginatorFssDealerUser =
                fssDealerUserService.getPaginatorFssDealerUser(paginator);
        System.out.printf("列表："+JSON.toJSONString(paginatorFssDealerUser));
        Assert.assertTrue(true);
    }



}
