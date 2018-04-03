package com.yundian.fss.dao;

import com.yundian.fssapi.domain.FssUserModel;

public interface FssUserModelMapper {
    int deleteByPrimaryKey(Long userId);

    int insert(FssUserModel record);

    int insertSelective(FssUserModel record);

    FssUserModel selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(FssUserModel record);

    int updateByPrimaryKey(FssUserModel record);
}