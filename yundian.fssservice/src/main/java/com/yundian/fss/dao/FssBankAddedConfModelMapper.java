package com.yundian.fss.dao;

import org.apache.ibatis.annotations.Param;

import com.yundian.fssapi.domain.FssBankAddedConfModel;

public interface FssBankAddedConfModelMapper {
	int deleteByPrimaryKey(Long id);
	int deleteByBankId(Long bankId);
	
	int insert(FssBankAddedConfModel record);

	FssBankAddedConfModel selectByPrimaryKey(Long id);

	int updateByPrimaryKey(FssBankAddedConfModel record);

	FssBankAddedConfModel getFssBankAddedConfByBankId(@Param("bankId") Long bankId);

}