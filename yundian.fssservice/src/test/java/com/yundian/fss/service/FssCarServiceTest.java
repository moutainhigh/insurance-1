package com.yundian.fss.service;

import com.alibaba.fastjson.JSON;
import com.yundian.fss.test.AbstractJUnit;
import com.yundian.fssapi.domain.FssCarBrandModel;
import com.yundian.fssapi.domain.FssCarModelsModel;
import com.yundian.fssapi.domain.FssCarSeriesModel;
import com.yundian.fssapi.service.FssCarService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 车型服务测试
 *
 * @author jnx
 * @create 2018/4/3
 */
public class FssCarServiceTest extends AbstractJUnit{

    @Autowired
    FssCarService fssCarService;

    @Test
    public void getBrandListTest() {
        List<FssCarBrandModel> listResult = fssCarService.getBrandList();
        System.out.printf("getbrand:"+JSON.toJSONString(listResult));
        Assert.assertTrue(true);
    }

    @Test
    public void getBrandTest(){
        String brandCode="1001";
        FssCarBrandModel brandModel = fssCarService.getBrand(brandCode);
        System.out.printf(JSON.toJSONString(brandModel));
        Assert.assertTrue(true);
    }

    @Test
    public void getSeriesByBrandTest(){
        String brandCode="1001";
        List<FssCarSeriesModel> fssCarSeriesModels = fssCarService.getSeriesByBrand(brandCode);
        System.out.printf(JSON.toJSONString(fssCarSeriesModels));
        Assert.assertTrue(true);
    }

    @Test
    public void getModelsBySeriesTest(){
        String seriesCode="1001002";
        List<FssCarModelsModel> carModelsModelList = fssCarService.getModelsBySeries(seriesCode);
        System.out.printf(JSON.toJSONString(carModelsModelList));
        Assert.assertTrue(true);
    }

}
