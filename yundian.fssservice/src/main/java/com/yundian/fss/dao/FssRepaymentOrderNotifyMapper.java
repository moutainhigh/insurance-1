package com.yundian.fss.dao;

import com.yundian.fssapi.domain.FssRepaymentOrderNotify;

public interface FssRepaymentOrderNotifyMapper {
    int deleteByPrimaryKey(Long id);

    int insert(FssRepaymentOrderNotify record);

    int insertSelective(FssRepaymentOrderNotify record);

    FssRepaymentOrderNotify selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FssRepaymentOrderNotify record);

    int updateByPrimaryKeyWithBLOBs(FssRepaymentOrderNotify record);

    int updateByPrimaryKey(FssRepaymentOrderNotify record);
}