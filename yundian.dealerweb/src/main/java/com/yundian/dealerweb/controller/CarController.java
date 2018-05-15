package com.yundian.dealerweb.controller;

import com.yundian.fssapi.domain.FssCarBrandModel;
import com.yundian.fssapi.domain.FssCarModelsModel;
import com.yundian.fssapi.domain.FssCarSeriesModel;
import com.yundian.fssapi.service.FssCarService;
import com.yundian.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author jnx
 * @create 2018/4/10
 */
@Slf4j
@Controller
public class CarController {

    @Autowired
    FssCarService fssCarService;


    @ResponseBody
    @RequestMapping(value="/car/getCarBrands",method= RequestMethod.GET)
    public Result getBrands() {

        try {
            List<FssCarBrandModel> brandModelList = fssCarService.getBrandList();
            return Result.success(brandModelList);
        } catch (Exception ex) {
            log.error(String.format("获取汽车品牌异常："), ex);
            System.out.printf(ex.getMessage());
            return Result.fail("", "获取汽车品牌异常，请重试");
        }
    }

    @ResponseBody
    @RequestMapping(value="/car/getCarSeries",method= RequestMethod.GET)
    public Result getSeries(@RequestParam("brandCode") String brandCode) {

        try {
            List<FssCarSeriesModel> carSeriesModelList = fssCarService.getSeriesByBrand(brandCode);
            return Result.success(carSeriesModelList);
        } catch (Exception ex) {
            log.error(String.format("获取车系信息异常："), ex);
            System.out.printf(ex.getMessage());
            return Result.fail("", "获取车系信息异常，请重试");
        }
    }


    @ResponseBody
    @RequestMapping(value="/car/getCarModels",method= RequestMethod.GET)
    public Result getModels(@RequestParam("seriesCode") String seriesCode) {

        try {

            List<FssCarModelsModel> carModelsModelList =fssCarService.getModelsBySeries(seriesCode);
            return Result.success(carModelsModelList);
        } catch (Exception ex) {
            log.error(String.format("获取汽车车型列表异常："), ex);
            System.out.printf(ex.getMessage());
            return Result.fail("", "获取汽车车型列表异常，请重试");
        }
    }


    @ResponseBody
    @RequestMapping(value = "/car/getCarModel",method= RequestMethod.GET)
    public Result getCarModel(@RequestParam("modelCode") String modelCode) {
        try {
            FssCarModelsModel fssCarModelsModel =fssCarService.getModel(modelCode);
            return Result.success(fssCarModelsModel);

        } catch (Exception ex) {
            log.error(String.format("获取汽车车型信息异常："), ex);
            System.out.printf(ex.getMessage());
            return Result.fail("","获取汽车车型信息异常，请重试");
        }
    }

    @ResponseBody
    @RequestMapping(value = "/car/getCarModelTree",method= RequestMethod.GET)
    public Result getCarModelTree(@RequestParam("brandCode") String brandCode,
            @RequestParam("seriesCode") String seriesCode,
            @RequestParam("modelCode") String modelCode) {
        try {
            FssCarSeriesModel fssCarSeriesModel= fssCarService.getSerie(seriesCode);
            FssCarModelsModel fssCarModelsModel =fssCarService.getModel(modelCode);


            return Result.success(fssCarModelsModel);

        } catch (Exception ex) {
            log.error(String.format("获取汽车车型信息异常："), ex);
            System.out.printf(ex.getMessage());
            return Result.fail("","获取汽车车型信息异常，请重试");
        }
    }
}
