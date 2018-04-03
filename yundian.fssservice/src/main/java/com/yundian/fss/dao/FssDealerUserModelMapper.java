package com.yundian.fss.dao;

import com.yundian.fssapi.domain.FssDealerUserModel;

public interface FssDealerUserModelMapper {
    int deleteByPrimaryKey(Long id);

    int insert(FssDealerUserModel record);

    int insertSelective(FssDealerUserModel record);

    FssDealerUserModel selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FssDealerUserModel record);

    int updateByPrimaryKey(FssDealerUserModel record);
}