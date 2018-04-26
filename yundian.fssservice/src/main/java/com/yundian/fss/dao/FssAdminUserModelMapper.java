package com.yundian.fss.dao;

import com.yundian.fssapi.domain.FssAdminUserModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * fss_admin_user
 */
public interface FssAdminUserModelMapper {
    int deleteByPrimaryKey(Long id);

    int insert(FssAdminUserModel record);

    int insertSelective(FssAdminUserModel record);

    FssAdminUserModel selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FssAdminUserModel record);



    /**
     * 通过账号密码查询信息
     * @param userName 用户名
     * @param password 密码（MD5后）
     * @return
     */
    FssAdminUserModel getFssAdminUserByUserAndPwd(@Param("userName") String userName, @Param("userPwd") String password);

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
    List<FssAdminUserModel> getFssAdminUserPaging(
            Map<String, Object> param);

    Integer getFssAdminUserPagingCount(Map<String, Object> param);

}