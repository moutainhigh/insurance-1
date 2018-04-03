package com.yundian.fss.dao;

import com.yundian.fssapi.domain.FssDealerModel;

public interface FssDealerModelMapper {
    int deleteByPrimaryKey(Long dealerId);

    int insert(FssDealerModel record);

    int insertSelective(FssDealerModel record);

    FssDealerModel selectByPrimaryKey(Long dealerId);

    int updateByPrimaryKeySelective(FssDealerModel record);

    int updateByPrimaryKey(FssDealerModel record);
}