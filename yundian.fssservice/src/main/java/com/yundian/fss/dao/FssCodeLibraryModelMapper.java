package com.yundian.fss.dao;

import com.yundian.fssapi.domain.FssCodeLibraryModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FssCodeLibraryModelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FssCodeLibraryModel record);

    FssCodeLibraryModel selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(FssCodeLibraryModel record);

    List<FssCodeLibraryModel> getCodes(@Param("codeType") String codeType);

    FssCodeLibraryModel selectByCode(@Param("codeType") String codeType,@Param("codeId") String code);

}