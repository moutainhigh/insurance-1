package com.yundian.fss.dao;

import com.yundian.fssapi.domain.FssAdminUserModel;
import com.yundian.fssapi.domain.FssUserModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface FssUserModelMapper {
    int deleteByPrimaryKey(Long userId);

    int insert(FssUserModel record);

    int insertSelective(FssUserModel record);

    FssUserModel selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(FssUserModel record);

    int updateByPrimaryKey(FssUserModel record);


    /**
     * 通过账号密码查询信息
     * @param userName 用户名
     * @param password 密码（MD5后）
     * @return
     */
    FssUserModel getFssUserByUserAndPwd(@Param("userName") String userName, @Param("userPwd") String password);

    /**
     * 密码
     * @param userId 用户userid
     * @param userPwd 用户pwd(md5后)
     * @return
     */
    Integer resetPwd(@Param("userId") Long userId, @Param("userPwd") String userPwd) ;

    /**
     * 分页查询用户
     * @param param
     * @return
     */
    List<FssUserModel> getFssUserPaging(
            Map<String, Object> param);

    Integer getFssUserPagingCount(Map<String, Object> param);

}