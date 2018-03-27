package com.yundian.fss.dao;

import java.util.List;
import java.util.Map;

import com.yundian.fssapi.domain.FssGuaranteeModel;

public interface FssGuaranteeModelMapper {
    int deleteByPrimaryKey(Long guaranteeId);

    int insert(FssGuaranteeModel record);

    FssGuaranteeModel selectByPrimaryKey(Long guaranteeId);

    int updateByPrimaryKey(FssGuaranteeModel record);

	List<FssGuaranteeModel> getFssGuaranteePaging(
			Map<String, Object> param);

	Integer getFssGuaranteePagingCount(Map<String, Object> param);

}