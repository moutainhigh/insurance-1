package com.yundian.fss.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yundian.fssapi.domain.FssCreditRiskModel;
import com.yundian.result.PaginatedResult;
import com.yundian.result.Paginator;

public interface FssCreditRiskModelMapper {
    int deleteByPrimaryKey(Long riskId);

    int insert(FssCreditRiskModel record);

    FssCreditRiskModel selectByPrimaryKey(Long riskId);

    int updateByPrimaryKey(FssCreditRiskModel record);

	List<FssCreditRiskModel> getFssCreditRiskList(
			FssCreditRiskModel fssCreditRiskModel);

	PaginatedResult<FssCreditRiskModel> getPaginatorFssCreditRisk(
			Paginator<FssCreditRiskModel> paginator);

	FssCreditRiskModel getFssCreditRiskByCreditId(@Param("creditId") Long creditId);
}