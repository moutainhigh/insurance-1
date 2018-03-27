package com.yundian.fss.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yundian.fssapi.domain.FssCreditLogModel;

public interface FssCreditLogModelMapper {
    int deleteByPrimaryKey(Long id);

    int insert(FssCreditLogModel record);

    FssCreditLogModel selectByPrimaryKey(Long id);

    int updateByPrimaryKey(FssCreditLogModel record);

	List<FssCreditLogModel> getFssCreditLogListByCreditId(@Param("creditId") Long creditId);

}