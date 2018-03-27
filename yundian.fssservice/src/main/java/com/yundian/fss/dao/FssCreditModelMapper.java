package com.yundian.fss.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.yundian.fssapi.domain.FssCreditModel;

public interface FssCreditModelMapper {
    int deleteByPrimaryKey(Long creditId);

    int insert(FssCreditModel record);

    FssCreditModel selectByPrimaryKey(Long creditId);

    int updateByPrimaryKey(FssCreditModel record);
    int updateByPrimaryKeySelective(FssCreditModel record);
    
    
	Integer getPaginatorFssCreditCount(Map<String,Object> param);
	
	List<FssCreditModel> getPaginatorFssCredit(Map<String,Object> param);
	
	
	Map<String,Integer> getCreditStatusStat(@Param("guaranteeId") Long guaranteeId,@Param("bankId") Long bankId);
}