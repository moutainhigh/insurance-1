package com.yundian.fss.service.impl;

import com.alibaba.fastjson.JSON;
import com.yundian.fss.dao.FssUserModelMapper;
import com.yundian.fssapi.domain.FssUserModel;
import com.yundian.fssapi.exception.FssAdminUserException;
import com.yundian.fssapi.exception.FssUserException;
import com.yundian.fssapi.service.FssUserService;
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
 * C用户登录服务
 *
 * @author jnx
 * @create 2018/6/23
 */
@Slf4j
@Service("fssUserService")
public class FssUserServiceImpl implements FssUserService {

    @Autowired
    FssUserModelMapper fssUserModelMapper;
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
            Integer resetCount = fssUserModelMapper
                    .resetPwd(userId, MD5.encodePassword(newPwd));

            return resetCount>0;
        } catch (Exception e) {
            log.error(String.format("C端用户重置密码失败:%s", userId+userLoginName), e);
            throw new FssUserException(ResultCodeContants.FAILED, "用户重置密码失败", e);

        }
    }

    @Override
    public FssUserModel getFssUser(Long userId) {
        try {
            return fssUserModelMapper.selectByPrimaryKey(userId);

        } catch (Exception e) {
            log.error(String.format("获取用户信息失败:%s", userId), e);
            throw new FssAdminUserException(ResultCodeContants.FAILED, "获取用户信息失败", e);

        }
    }

    @Override
    public Integer insertFssUser(FssUserModel fssUserModel) {
        try {
            fssUserModel.setUserPwd(MD5.encodePassword(fssUserModel.getUserPwd()));
            fssUserModel.setCtime(new Date());
            fssUserModel.setMtime(new Date());
            return fssUserModelMapper.insert(fssUserModel);
        } catch (Exception e) {
            log.error(String.format("新增用户失败:%s", JSON.toJSONString(fssUserModel)), e);
            throw new FssAdminUserException(ResultCodeContants.FAILED, "新增用户失败", e);
        }
    }

    @Override
    public Integer updateFssUser(FssUserModel fssUserModel) {
        try {
            if(fssUserModel==null||fssUserModel.getUserId()==null) {
                throw new FssUserException(ResultCodeContants.FAILED, "输入参数不能为空值", null);
            }
            return fssUserModelMapper.updateByPrimaryKeySelective(fssUserModel);
        } catch (Exception e) {
            log.error(String.format("修改用户信息失败:%s", JSON.toJSONString(fssUserModel)), e);
            throw new FssUserException(ResultCodeContants.FAILED, "修改用户信息失败", e);
        }
    }

    @Override
    public Page<FssUserModel> getPaginatorFssUser(Paginator<FssUserModel> paginator) {
        try {
            HashMap<String, Object> param = new HashMap<String, Object>();
            param.put("_limit", paginator.getPageSize());
            param.put("_offset",
                    (paginator.getPage() - 1) * paginator.getPageSize());
            BeanUtilsExt.copyPropertiesToMap(paginator.getParam(), param);

            List<FssUserModel> list = fssUserModelMapper
                    .getFssUserPaging(param);
            Integer count = fssUserModelMapper.getFssUserPagingCount(param);
            return PageProvider.getPage(paginator,count,list,FssUserModel.class);
        } catch (Exception e) {
            log.error(
                    String.format("分页查询用户异常:%s",
                            ToStringBuilder.reflectionToString(paginator)), e);

            throw new FssUserException(ResultCodeContants.FAILED,
                    "分页查询用户异常", e);
        }
    }

    @Override
    public FssUserModel fssFssUserLogin(String userName, String password) {
        String md5Password = MD5.encodePassword(password);
        log.info("md5:"+md5Password);
        FssUserModel userModel = this.fssUserModelMapper
                .getFssUserByUserAndPwd(userName, md5Password);
        if(userModel==null){
            throw new FssUserException(ResultCodeContants.FAILED, "用户名或密码错误");
        }
        return userModel;
    }
}
