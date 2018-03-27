package com.yundian.fss.dao;

import com.yundian.fssapi.domain.FssCodeLibraryModel;

public interface FssCodeLibraryModelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FssCodeLibraryModel record);

    FssCodeLibraryModel selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(FssCodeLibraryModel record);
}