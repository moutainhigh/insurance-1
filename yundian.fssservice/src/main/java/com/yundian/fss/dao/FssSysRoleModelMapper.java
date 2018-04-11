package com.yundian.fss.dao;

import com.yundian.fssapi.domain.FssSysRoleModel;

import java.util.List;
import java.util.Map;

public interface FssSysRoleModelMapper {
    int deleteByPrimaryKey(Long roleId);

    int insert(FssSysRoleModel record);

    int insertSelective(FssSysRoleModel record);

    FssSysRoleModel selectByPrimaryKey(Long roleId);

    int updateByPrimaryKeySelective(FssSysRoleModel record);

    int updateByPrimaryKey(FssSysRoleModel record);

	List<FssSysRoleModel> getFssSysRolePaging(Map<String, Object> param);

	Integer getFssSysRolePagingCount(Map<String, Object> param);

	List<FssSysRoleModel> getUsedRoleListByState(String state);
	
	
}