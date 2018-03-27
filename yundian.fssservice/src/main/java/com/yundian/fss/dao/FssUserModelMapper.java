package com.yundian.fss.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.yundian.fssapi.domain.FssUserModel;
import com.yundian.fssapi.domain.query.FssUserQueryModel;

public interface FssUserModelMapper {
    int deleteByPrimaryKey(Long userId);

    Integer insert(FssUserModel record);

    FssUserModel selectByPrimaryKey(Long userId);

    int updateByPrimaryKey(FssUserModel record);

    FssUserModel getFssGuaranteeUserByUserNameAndPwd(@Param("userName") String userName,
			@Param("userPwd") String userPwd);

	List<FssUserQueryModel> getFssUserPaging(Map<String, Object> param);

	Integer getFssUserPagingCount(Map<String, Object> param);

	Integer updateGuaranteeUserPwd(FssUserModel record);
}