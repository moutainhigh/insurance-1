package com.yundian.fss.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yundian.fssapi.domain.FssCreditRiskDetailModel;

public interface FssCreditRiskDetailModelMapper {
    int deleteByPrimaryKey(Long id);

    int insert(FssCreditRiskDetailModel record);

    FssCreditRiskDetailModel selectByPrimaryKey(Long id);

    int updateByPrimaryKey(FssCreditRiskDetailModel record);

	List<FssCreditRiskDetailModel> getFssCreditRiskDetailList(
			FssCreditRiskDetailModel fssCreditRiskDetailModel);

	List<FssCreditRiskDetailModel> getFssCreditRiskDetailByRiskId(@Param("riskId") Long riskId);
}