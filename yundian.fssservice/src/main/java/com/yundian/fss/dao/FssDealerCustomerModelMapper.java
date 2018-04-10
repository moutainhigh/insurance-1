package com.yundian.fss.dao;

import com.yundian.fssapi.domain.FssDealerCustomerModel;
import com.yundian.fssapi.domain.FssLoanModel;
import com.yundian.result.PaginatedResult;

import java.util.List;
import java.util.Map;

public interface FssDealerCustomerModelMapper {
    int deleteByPrimaryKey(Long id);

    int insert(FssDealerCustomerModel record);

    int insertSelective(FssDealerCustomerModel record);

    FssDealerCustomerModel selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FssDealerCustomerModel record);

    int updateByPrimaryKey(FssDealerCustomerModel record);

    List<FssDealerCustomerModel> getFssDealerCustomerPaging(
            Map<String, Object> param);

    Integer getFssDealerCustomerPagingCount(Map<String, Object> param);


}