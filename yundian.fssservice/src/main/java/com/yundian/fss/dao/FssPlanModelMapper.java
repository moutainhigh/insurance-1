package com.yundian.fss.dao;

import com.yundian.fssapi.domain.FssPlanModel;

import java.util.List;
import java.util.Map;

public interface FssPlanModelMapper {
    int deleteByPrimaryKey(Long id);

    int insert(FssPlanModel record);

    int insertSelective(FssPlanModel record);

    FssPlanModel selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FssPlanModel record);

    int updateByPrimaryKey(FssPlanModel record);

    /**
     * 分页查询用户
     * @param param
     * @return
     */
    List<FssPlanModel> getFssPlanPaging(
            Map<String, Object> param);

    Integer getFssPlanPagingCount(Map<String, Object> param);

    List<FssPlanModel> getFssPlanList();
}