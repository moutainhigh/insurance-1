package com.yundian.fss.service;

import com.alibaba.fastjson.JSON;
import com.yundian.fss.test.AbstractJUnit;
import com.yundian.fssapi.domain.FssCodeLibraryModel;
import com.yundian.fssapi.service.FssCodeLibraryService;
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
public class FssCodeLibrayServiceTest extends AbstractJUnit{

    @Autowired
    FssCodeLibraryService fssCodeLibraryService;

    @Test
    public void getList()
    {
            List<FssCodeLibraryModel> listResult = fssCodeLibraryService.getFssCodeLibraryListByType("FSS_FILE_CATEGORY");
        System.out.printf("test_result:");
            System.out.printf(JSON.toJSONString(listResult));
            Assert.assertTrue(true);


    }
}
