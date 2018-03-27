package com.yundian.fss.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.yundian.fssapi.domain.FssOrganizationUserModel;
import com.yundian.fssapi.domain.query.FssOrganizationUserQueryModel;

public interface FssOrganizationUserModelMapper {
    int deleteByPrimaryKey(Long orguserId);

    int insert(FssOrganizationUserModel record);

    FssOrganizationUserModel selectByPrimaryKey(Long orguserId);

    int updateByPrimaryKey(FssOrganizationUserModel record);
    
	List<FssOrganizationUserQueryModel> getFssOrganizationUserPaging(
			Map<String, Object> param);

	Integer getFssOrganizationUserPagingCount(Map<String, Object> param);

	FssOrganizationUserModel getFssOrganizationUserByUserAndPwd(@Param("orguserName") String userName,
			@Param("orguserPwd")  String password);

	Integer getFssOrganizationUserCountByOrgId(Long organizationId);

}