package com.yundian.fss.service.impl;

import com.yundian.fss.dao.FssCarBrandModelMapper;
import com.yundian.fss.dao.FssCarModelsModelMapper;
import com.yundian.fss.dao.FssCarSeriesModelMapper;
import com.yundian.fssapi.domain.FssCarBrandModel;
import com.yundian.fssapi.domain.FssCarModelsModel;
import com.yundian.fssapi.domain.FssCarSeriesModel;
import com.yundian.fssapi.exception.FssCarException;
import com.yundian.fssapi.service.FssCarService;
import com.yundian.result.ResultCodeContants;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 汽车品牌、车系、车型 基础服务
 * 
 * @author
 * @version
 */
@Slf4j
@Service("fssCarService")
public class FssCarServiceImpl implements FssCarService {

	@Autowired
	FssCarBrandModelMapper fssCarBrandModelMapper;
	@Autowired
	FssCarSeriesModelMapper fssCarSeriesModelMapper;
	@Autowired
	FssCarModelsModelMapper fssCarModelsModelMapper;


	@Override
	public List<FssCarBrandModel> getBrandList() {

		try {
			return fssCarBrandModelMapper.getFssCarBandList();
		} catch (Exception e) {
			log.error(String.format("获取汽车品牌列表异常:%s"), e);
			throw new FssCarException(ResultCodeContants.FAILED, "获取汽车品牌列表异常", e);
		}
	}

	@Override
	public FssCarBrandModel getBrand(@Param("brandCode") String brandCode) {

		try {
			return fssCarBrandModelMapper.selectByBrandCode(brandCode);
		} catch (Exception e) {
			log.error(String.format("获取汽车品牌异常:%s"), e);
			throw new FssCarException(ResultCodeContants.FAILED, "获取汽车品牌异常", e);
		}
	}

	@Override
	public FssCarSeriesModel getSerie(@Param("seriesCode") String seriesCode) {

		try {
			return fssCarSeriesModelMapper.selectBySeriesCode(seriesCode);
		} catch (Exception e) {
			log.error(String.format("获取汽车品牌异常:%s"), e);
			throw new FssCarException(ResultCodeContants.FAILED, "获取汽车品牌异常", e);
		}
	}

	@Override
	public List<FssCarSeriesModel> getSeriesByBrand(@Param("brandCode") String brandCode) {

		try {
			return fssCarSeriesModelMapper.getSeriesListByBrandCode(brandCode);
		} catch (Exception e) {
			log.error(String.format("获取汽车车系列表异常:%s"), e);
			throw new FssCarException(ResultCodeContants.FAILED, "获取汽车车系列表异常", e);
		}

	}

	@Override
	public List<FssCarModelsModel> getModelsBySeries(@Param("seriesCode") String seriesCode) {

		try {
			return fssCarModelsModelMapper.getModelsListBySeriesCode(seriesCode);
		} catch (Exception e) {
			log.error(String.format("获取汽车车型列表异常:%s"), e);
			throw new FssCarException(ResultCodeContants.FAILED, "获取汽车车型列表异常", e);
		}
	}

	@Override
	public FssCarModelsModel getModel(@Param("modelsCode") String modelsCode) {

		try {
			return fssCarModelsModelMapper.selectByModelsCode(modelsCode);
		} catch (Exception e) {
			log.error(String.format("获取汽车车型详细异常:%s"), e);
			throw new FssCarException(ResultCodeContants.FAILED, "获取汽车车型详细异常", e);
		}

	}
}
