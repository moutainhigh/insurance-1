package com.yundian.fss.dao;

import com.yundian.fssapi.domain.FssCarSeriesModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FssCarSeriesModelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FssCarSeriesModel record);

    FssCarSeriesModel selectBySeriesCode(@Param("seriesCode") String seriesCode);

    int insertSelective(FssCarSeriesModel record);

    FssCarSeriesModel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FssCarSeriesModel record);

    int updateByPrimaryKey(FssCarSeriesModel record);

    List<FssCarSeriesModel> getSeriesListByBrandCode(@Param("brandCode") String brandCode);
}