package com.yundian.fss.dao;

import com.yundian.fssapi.domain.FssCarBrandModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FssCarBrandModelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FssCarBrandModel record);

    int insertSelective(FssCarBrandModel record);

    FssCarBrandModel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FssCarBrandModel record);

    int updateByPrimaryKey(FssCarBrandModel record);

    List<FssCarBrandModel> getFssCarBandList();

    FssCarBrandModel selectByBrandCode(@Param("brandCode") String brandCode);

}