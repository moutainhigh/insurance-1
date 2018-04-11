package com.yundian.fss.dao;

import com.yundian.fssapi.domain.FssSysRoleModuleRelationModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FssSysRoleModuleRelationModelMapper {

	int deleteRoleModuleRelationByRoleId(Long roleId);

	int deleteByPrimaryKey(Integer id);

	int insert(FssSysRoleModuleRelationModel record);

	int batchInsert(
            @Param("roleModuleRelationList") List<FssSysRoleModuleRelationModel> roleModuleRelationList);

	FssSysRoleModuleRelationModel selectByPrimaryKey(Long id);

	int updateByPrimaryKey(FssSysRoleModuleRelationModel record);

	List<Long> getRoleRelModuleIdList(Long roleId);
}