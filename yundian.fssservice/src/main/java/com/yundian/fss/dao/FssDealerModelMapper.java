package com.yundian.fss.dao;

import com.yundian.fssapi.domain.FssDealerModel;
import com.yundian.fssapi.domain.FssLoanModel;

import java.util.List;
import java.util.Map;

public interface FssDealerModelMapper {
    int deleteByPrimaryKey(Long dealerId);

    int insert(FssDealerModel record);

    int insertSelective(FssDealerModel record);

    FssDealerModel selectByPrimaryKey(Long dealerId);

    int updateByPrimaryKeySelective(FssDealerModel record);

    int updateByPrimaryKey(FssDealerModel record);


    List<FssDealerModel> getFssDealerPaging(Map<String, Object> param);
    Integer getFssDealerPagingCount(Map<String, Object> param);
}