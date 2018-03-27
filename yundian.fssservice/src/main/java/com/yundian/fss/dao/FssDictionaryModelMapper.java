package com.yundian.fss.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yundian.fssapi.domain.FssDictionaryModel;

public interface FssDictionaryModelMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(FssDictionaryModel record);

	int insertSelective(FssDictionaryModel record);

	FssDictionaryModel selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(FssDictionaryModel record);

	int updateByPrimaryKey(FssDictionaryModel record);

	FssDictionaryModel getFssDictionaryByTypeAndItemCode(
			@Param("dictTypeCode") String dictTypeCode,
			@Param("itemCode") String itemCode);

	List<FssDictionaryModel> getFssDictionaryList(
			FssDictionaryModel fssDictionaryModel);
}