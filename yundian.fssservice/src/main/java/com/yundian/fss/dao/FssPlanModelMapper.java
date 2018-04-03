package com.yundian.fss.dao;

import com.yundian.fssapi.domain.FssPlanModel;

public interface FssPlanModelMapper {
    int deleteByPrimaryKey(Long id);

    int insert(FssPlanModel record);

    int insertSelective(FssPlanModel record);

    FssPlanModel selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FssPlanModel record);

    int updateByPrimaryKey(FssPlanModel record);
}