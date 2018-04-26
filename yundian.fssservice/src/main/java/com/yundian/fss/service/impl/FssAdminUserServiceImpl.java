package com.yundian.fss.service.impl;

import com.alibaba.fastjson.JSON;
import com.yundian.fss.dao.FssAdminUserModelMapper;
import com.yundian.fssapi.domain.FssAdminUserModel;
import com.yundian.fssapi.exception.FssAdminUserException;
import com.yundian.fssapi.service.FssAdminUserService;
import com.yundian.result.Page;
import com.yundian.result.PageProvider;
import com.yundian.result.Paginator;
import com.yundian.result.ResultCodeContants;
import com.yundian.toolkit.utils.BeanUtilsExt;
import com.yundian.toolkit.utils.MD5;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * 系统用户服务
 *
 * @author jnx
 * @create 2018/4/8
 */
@Slf4j
@Service("fssAdminUserService")
public class FssAdminUserServiceImpl implements FssAdminUserService{


    @Autowired
    FssAdminUserModelMapper fssAdminUserModelMapper;

    /**
     * 密码默认手机号码后6位
     */
    private int PWD_PHONE_R_6=6;

    @Override
    public Boolean resetPwd(Long userId, String userLoginName) {

        try {

            String newPwd = "";
            if(userLoginName.length()<=PWD_PHONE_R_6) {
                newPwd = userLoginName;
            }
            else {
                newPwd = userLoginName.substring(userLoginName.length() - PWD_PHONE_R_6, userLoginName.length());
            }
            Integer resetCount = fssAdminUserModelMapper
                    .resetPwd(userId, MD5.encodePassword(newPwd));

            return resetCount>0;
        } catch (Exception e) {
            log.error(String.format("重置密码失败:%s", userId+userLoginName), e);
            throw new FssAdminUserException(ResultCodeContants.FAILED, "重置密码失败", e);

        }
    }

    @Override
    public FssAdminUserModel getFssAdminUser(Long userId) {

        try {
            return fssAdminUserModelMapper.selectByPrimaryKey(userId);

        } catch (Exception e) {
            log.error(String.format("获取用户信息失败:%s", userId), e);
            throw new FssAdminUserException(ResultCodeContants.FAILED, "获取用户信息失败", e);

        }

    }

    @Override
    public Integer insertFssAdminUser(FssAdminUserModel fssAdminUserModel) {
        try {
            fssAdminUserModel.setUserPwd(MD5.encodePassword(fssAdminUserModel.getUserPwd()));
            fssAdminUserModel.setCtime(new Date());
            fssAdminUserModel.setMtime(new Date());
            return fssAdminUserModelMapper.insert(fssAdminUserModel);
        } catch (Exception e) {
            log.error(String.format("新增系统用户失败:%s", JSON.toJSONString(fssAdminUserModel)), e);
            throw new FssAdminUserException(ResultCodeContants.FAILED, "新增系统用户失败", e);
        }


    }

    @Override
    public Integer updateFssAdminUser(FssAdminUserModel fssAdminUserModel) {

        try {
            if(fssAdminUserModel==null||fssAdminUserModel.getUserId()==null) {
                throw new FssAdminUserException(ResultCodeContants.FAILED, "输入参数不能为空值", null);
            }
            return fssAdminUserModelMapper.updateByPrimaryKeySelective(fssAdminUserModel);
        } catch (Exception e) {
            log.error(String.format("修改用户失败:%s", JSON.toJSONString(fssAdminUserModel)), e);
            throw new FssAdminUserException(ResultCodeContants.FAILED, "修改用户信息失败", e);
        }

    }


    @Override
    public Page<FssAdminUserModel> getPaginatorFssAdminUser(
            Paginator<FssAdminUserModel> paginator) {
        try {
            HashMap<String, Object> param = new HashMap<String, Object>();
            param.put("_limit", paginator.getPageSize());
            param.put("_offset",
                    (paginator.getPage() - 1) * paginator.getPageSize());
            BeanUtilsExt.copyPropertiesToMap(paginator.getParam(), param);

            List<FssAdminUserModel> list = this.fssAdminUserModelMapper
                    .getFssAdminUserPaging(param);
            Integer count = fssAdminUserModelMapper.getFssAdminUserPagingCount(param);
            return PageProvider.getPage(paginator,count,list,FssAdminUserModel.class);
        } catch (Exception e) {
            log.error(
                    String.format("分页查询系统用户异常:%s",
                            ToStringBuilder.reflectionToString(paginator)), e);

            throw new FssAdminUserException(ResultCodeContants.FAILED,
                    "分页查询用户异常", e);
        }
    }

    @Override
    public FssAdminUserModel fssFssAdminUserLogin(String userName,String password) {
        String md5Password = MD5.encodePassword(password);
        log.info("md5:"+md5Password);
        FssAdminUserModel userModel = this.fssAdminUserModelMapper
                    .getFssAdminUserByUserAndPwd(userName, md5Password);
            if(userModel==null){
                throw new FssAdminUserException(ResultCodeContants.FAILED, "用户名或密码错误");
            }
            return userModel;

    }

}
