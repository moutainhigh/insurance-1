package com.yundian.fss.dao;

import com.yundian.fssapi.domain.FssRepaymentOrder;

public interface FssRepaymentOrderMapper {
    int deleteByPrimaryKey(Long id);

    int insert(FssRepaymentOrder record);

    int insertSelective(FssRepaymentOrder record);

    FssRepaymentOrder selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FssRepaymentOrder record);

    int updateByPrimaryKey(FssRepaymentOrder record);
}