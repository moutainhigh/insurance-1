package com.yundian.fss.dao;

import java.util.List;
import java.util.Map;

import com.yundian.fssapi.domain.FssBankModel;


public interface FssBankModelMapper {
    int deleteByPrimaryKey(Integer bankId);

    int insert(FssBankModel record);

    FssBankModel selectByPrimaryKey(Integer bankId);

    int updateByPrimaryKey(FssBankModel record);
    
    List<FssBankModel> getFssBankPaging(
			Map<String, Object> param);

	Integer getFssBankPagingCount(Map<String, Object> param);

	List<FssBankModel> getFssBankList(FssBankModel fssBankModel);
}