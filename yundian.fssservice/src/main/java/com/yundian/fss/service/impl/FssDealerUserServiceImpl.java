package com.yundian.fss.service.impl;

import com.alibaba.fastjson.JSON;
import com.yundian.fss.dao.FssDealerUserModelMapper;
import com.yundian.fssapi.domain.FssDealerModel;
import com.yundian.fssapi.domain.FssDealerUserModel;
import com.yundian.fssapi.exception.FssDealerException;
import com.yundian.fssapi.service.FssDealerUserService;
import com.yundian.result.*;
import com.yundian.toolkit.utils.BeanUtilsExt;
import com.yundian.toolkit.utils.MD5;
import com.yundian.toolkit.utils.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * 经销商用户服务
 *
 * @author jnx
 * @create 2018/4/8
 */
@Slf4j
@Service("fssDealerUserService")
public class FssDealerUserServiceImpl implements FssDealerUserService{


    @Autowired
    FssDealerUserModelMapper fssDealerUserModelMapper;

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
            Integer resetCount = fssDealerUserModelMapper
                    .resetPwd(userId, MD5.encodePassword(newPwd));

            return resetCount>0;
        } catch (Exception e) {
            log.error(String.format("重置密码失败:%s", userId+userLoginName), e);
            throw new FssDealerException(ResultCodeContants.FAILED, "重置密码失败", e);

        }
    }

    @Override
    public FssDealerUserModel getFssDealerUser(Long userId) {

        try {
            return fssDealerUserModelMapper.selectByPrimaryKey(userId);

        } catch (Exception e) {
            log.error(String.format("获取经销商用户信息失败:%s", userId), e);
            throw new FssDealerException(ResultCodeContants.FAILED, "获取经销商用户信息失败", e);

        }

    }

    @Override
    public Integer insertFssDealerUser(FssDealerUserModel fssDealerUserModel) {
        try {
            fssDealerUserModel.setUserPwd(MD5.encodePassword(fssDealerUserModel.getUserPwd()));
            fssDealerUserModel.setCtime(new Date());
            fssDealerUserModel.setMtime(new Date());
            return fssDealerUserModelMapper.insert(fssDealerUserModel);
        } catch (Exception e) {
            log.error(String.format("新增经销商用户失败:%s", JSON.toJSONString(fssDealerUserModel)), e);
            throw new FssDealerException(ResultCodeContants.FAILED, "新增经销商用户失败", e);
        }


    }

    @Override
    public Integer updateFssDealerUser(FssDealerUserModel fssDealerUserModel) {

        try {
            if(fssDealerUserModel==null||fssDealerUserModel.getUserId()==null) {
                throw new FssDealerException(ResultCodeContants.FAILED, "输入参数不能为空值", null);
            }
            return fssDealerUserModelMapper.updateByPrimaryKeySelective(fssDealerUserModel);
        } catch (Exception e) {
            log.error(String.format("修改经销商用户失败:%s", JSON.toJSONString(fssDealerUserModel)), e);
            throw new FssDealerException(ResultCodeContants.FAILED, "修改经销商用户信息失败", e);
        }

    }


    @Override
    public Page<FssDealerUserModel> getPaginatorFssDealerUser(
            Paginator<FssDealerUserModel> paginator) {
        try {
            HashMap<String, Object> param = new HashMap<String, Object>();
            param.put("_limit", paginator.getPageSize());
            param.put("_offset",
                    (paginator.getPage() - 1) * paginator.getPageSize());
            BeanUtilsExt.copyPropertiesToMap(paginator.getParam(), param);

            List<FssDealerUserModel> list = this.fssDealerUserModelMapper
                    .getFssDealerUserPaging(param);
            Integer count = fssDealerUserModelMapper.getFssDealerUserPagingCount(param);
            return PageProvider.getPage(paginator,count,list,FssDealerUserModel.class);
        } catch (Exception e) {
            log.error(
                    String.format("分页查询经销商用户异常:%s",
                            ToStringBuilder.reflectionToString(paginator)), e);

            throw new FssDealerException(ResultCodeContants.FAILED,
                    "分页查询经销商用户异常", e);
        }
    }

    @Override
    public FssDealerUserModel fssFssDealerUserLogin(String userName,String password) {
        System.out.println("userName = [" + userName + "], password = [" + password + "]");
        String md5Password = MD5.encodePassword(password);
        log.info("md5:"+md5Password);
            FssDealerUserModel userModel = this.fssDealerUserModelMapper
                    .getFssDealerUserByUserAndPwd(userName, md5Password);
            if(userModel==null){
                log.info("result:[]");
            }
            return userModel;

    }

}
