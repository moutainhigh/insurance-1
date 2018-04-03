package com.yundian.fss.dao;

import com.yundian.fssapi.domain.FssDealerCustomerModel;

public interface FssDealerCustomerModelMapper {
    int deleteByPrimaryKey(Long id);

    int insert(FssDealerCustomerModel record);

    int insertSelective(FssDealerCustomerModel record);

    FssDealerCustomerModel selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FssDealerCustomerModel record);

    int updateByPrimaryKey(FssDealerCustomerModel record);
}