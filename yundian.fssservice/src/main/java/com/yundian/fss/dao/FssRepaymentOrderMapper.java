package com.yundian.fss.dao;

import com.yundian.fssapi.domain.FssRepaymentOrderModel;

public interface FssRepaymentOrderMapper {
    int deleteByPrimaryKey(Long id);

    int insert(FssRepaymentOrderModel record);

    int insertSelective(FssRepaymentOrderModel record);

    FssRepaymentOrderModel selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FssRepaymentOrderModel record);

    int updateByPrimaryKey(FssRepaymentOrderModel record);

    FssRepaymentOrderModel selectByTradeCode(String  tradeNo);
}