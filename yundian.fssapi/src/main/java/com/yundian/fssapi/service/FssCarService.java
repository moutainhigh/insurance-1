package com.yundian.fssapi.service;

import com.yundian.fssapi.domain.FssCarBrandModel;
import com.yundian.fssapi.domain.FssCarModelsModel;
import com.yundian.fssapi.domain.FssCarSeriesModel;
import com.yundian.fssapi.domain.FssSysAreaModel;
import com.yundian.result.Result;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 车型服务
 * 
 * @author
 *
 */
public interface FssCarService {


	/**
	 * 获取所有品牌
	 * @return
	 */
	List<FssCarBrandModel> getBrandList();


	/**
	 * 根据品牌CODE获取品牌对象
	 * @param brandCode
	 * @return
	 */
	FssCarBrandModel getBrand(@Param("brandCode") String brandCode);


	FssCarSeriesModel getSerie(@Param("seriesCode") String seriesCode);
	/**
	 *根据品牌CODE获取 车系列表
	 * @param brandCode
	 * @return
	 */
	List<FssCarSeriesModel> getSeriesByBrand(@Param("brandCode") String brandCode);

	/**
	 * 根据车系获取车型列表
	 * @param seriesCode
	 * @return
	 */
	List<FssCarModelsModel> getModelsBySeries(@Param("seriesCode") String seriesCode);


	/**
	 * 获取车型对象
	 * @param modelsCode
	 * @return
	 */
	FssCarModelsModel getModel(@Param("modelsCode") String modelsCode);
}
