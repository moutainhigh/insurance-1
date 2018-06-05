package com.yundian.fss.dao;

import com.yundian.fssapi.domain.FssApiCallLog;

public interface FssApiCallLogMapper {
    int deleteByPrimaryKey(Long serialId);

    int insert(FssApiCallLog record);

    int insertSelective(FssApiCallLog record);

    FssApiCallLog selectByPrimaryKey(Long serialId);

    int updateByPrimaryKeySelective(FssApiCallLog record);

    int updateByPrimaryKey(FssApiCallLog record);
}