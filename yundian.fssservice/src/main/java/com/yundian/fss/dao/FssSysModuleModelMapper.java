package com.yundian.fss.dao;

import com.yundian.fssapi.domain.FssSysModuleModel;

import java.util.List;
import java.util.Map;

public interface FssSysModuleModelMapper {
	int deleteByPrimaryKey(Integer moduleId);

	int insert(FssSysModuleModel record);

	FssSysModuleModel selectByPrimaryKey(Long id);

	int updateByPrimaryKey(FssSysModuleModel record);

	List<FssSysModuleModel> getFssSysModulePaging(Map<String, Object> map);

	Integer getFssSysModulePagingCount(Map<String, Object> map);

	List<FssSysModuleModel> getAllFssSysModuleList();
}