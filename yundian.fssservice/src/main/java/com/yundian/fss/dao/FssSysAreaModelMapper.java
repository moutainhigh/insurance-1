package com.yundian.fss.dao;

import com.yundian.fssapi.domain.FssSysAreaModel;

public interface FssSysAreaModelMapper {
    int deleteByPrimaryKey(Long id);

    int insert(FssSysAreaModel record);

    FssSysAreaModel selectByPrimaryKey(Long id);

    int updateByPrimaryKey(FssSysAreaModel record);
}