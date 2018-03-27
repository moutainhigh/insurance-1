package com.yundian.fss.dao;

import java.util.List;

import com.yundian.fssapi.domain.FssGuaranteeUserModel;
import com.yundian.fssapi.domain.query.FssGuaranteeUserQueryModel;

public interface FssGuaranteeUserModelMapper {
	int deleteByPrimaryKey(Long id);

	Integer insert(FssGuaranteeUserModel record);

	FssGuaranteeUserModel selectByPrimaryKey(Long id);

	int updateByPrimaryByUserIdAndGuaranteeId(FssGuaranteeUserModel record);

    
	/**
	 * 获取担保用户的所在机构信息
	 * @param userId
	 * @return
	 */
	List<FssGuaranteeUserQueryModel> getGuaranteeUserQueryListByUserId(
			Long userId);

	Integer getGuaranteeUserCountByGuaranteeId(Long guaranteeId);
}