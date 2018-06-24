package com.yundian.fss.dao;

import com.yundian.fssapi.domain.FssRepaymentOrderNotifyModel;

public interface FssRepaymentOrderNotifyMapper {
    int deleteByPrimaryKey(Long id);

    int insert(FssRepaymentOrderNotifyModel record);

    int insertSelective(FssRepaymentOrderNotifyModel record);

    FssRepaymentOrderNotifyModel selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FssRepaymentOrderNotifyModel record);

    int updateByPrimaryKeyWithBLOBs(FssRepaymentOrderNotifyModel record);

    int updateByPrimaryKey(FssRepaymentOrderNotifyModel record);
}