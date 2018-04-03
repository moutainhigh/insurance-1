package com.yundian.fss.dao;

import com.yundian.fssapi.domain.FssFundModel;

public interface FssFundModelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FssFundModel record);

    int insertSelective(FssFundModel record);

    FssFundModel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FssFundModel record);

    int updateByPrimaryKey(FssFundModel record);
}