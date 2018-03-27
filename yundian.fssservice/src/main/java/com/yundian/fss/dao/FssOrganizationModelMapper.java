package com.yundian.fss.dao;

import java.util.List;
import java.util.Map;

import com.yundian.fssapi.domain.FssOrganizationModel;

public interface FssOrganizationModelMapper {
    int deleteByPrimaryKey(Long organizationId);

    int insert(FssOrganizationModel record);

    FssOrganizationModel selectByPrimaryKey(Long organizationId);

    int updateByPrimaryKey(FssOrganizationModel record);

	List<FssOrganizationModel> getFssOrganizationPaging(Map<String, Object> param);

	Integer getFssOrganizationPagingCount(Map<String, Object> param);

    List<FssOrganizationModel> listAllOrganization();
}