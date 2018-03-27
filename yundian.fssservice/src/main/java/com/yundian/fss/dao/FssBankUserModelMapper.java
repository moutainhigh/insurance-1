package com.yundian.fss.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.yundian.fssapi.domain.FssBankUserModel;
import com.yundian.fssapi.domain.query.FssBankUserQueryModel;

public interface FssBankUserModelMapper {
    int deleteByPrimaryKey(Long bkuserId);

    int insert(FssBankUserModel record);

    FssBankUserModel selectByPrimaryKey(Long bkuserId);

    int updateByPrimaryKey(FssBankUserModel record);
    
	List<FssBankUserQueryModel> getFssBankUserPaging(
			Map<String, Object> param);

	Integer getFssBankUserPagingCount(Map<String, Object> param);

	FssBankUserModel getFssBankUserByUserAndPwd(@Param("bkUsername") String userName,
			@Param("bkuserPwd")  String password);

	Integer getFssBankUserCountByBankId(Long bankId);
}