package com.yundian.fss.dao;

import com.yundian.fssapi.domain.FssCarModelsModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FssCarModelsModelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FssCarModelsModel record);

    int insertSelective(FssCarModelsModel record);

    FssCarModelsModel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FssCarModelsModel record);

    int updateByPrimaryKey(FssCarModelsModel record);


    List<FssCarModelsModel> getModelsListBySeriesCode(@Param("seriesCode") String seriesCode);

    FssCarModelsModel selectByModelsCode(@Param("modelsCode") String modelsCode);
}