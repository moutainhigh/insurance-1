package com.yundian.fss.dao;

import com.yundian.fssapi.domain.FssDealerUserModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface FssDealerUserModelMapper {
    int deleteByPrimaryKey(Long id);

    int insert(FssDealerUserModel record);

    int insertSelective(FssDealerUserModel record);

    FssDealerUserModel selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FssDealerUserModel record);



    /**
     * 通过账号密码查询客户信息
     * @param userName 用户名
     * @param password 密码（MD5后）
     * @return
     */
    FssDealerUserModel getFssDealerUserByUserAndPwd(@Param("userName") String userName,@Param("userPwd")  String password);

    /**
     * 密码
     * @param userId 用户userid
     * @param userPwd 用户pwd(md5后)
     * @return
     */
    Integer resetPwd(@Param("userId") Long userId,@Param("userPwd") String userPwd) ;

    /**
     * 分页查询用户
     * @param param
     * @return
     */
    List<FssDealerUserModel> getFssDealerUserPaging(
            Map<String, Object> param);


}