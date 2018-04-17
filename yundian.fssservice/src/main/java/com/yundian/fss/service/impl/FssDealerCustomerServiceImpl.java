package com.yundian.fss.service.impl;

import com.alibaba.fastjson.JSON;
import com.yundian.fss.dao.FssDealerCustomerModelMapper;
import com.yundian.fssapi.domain.FssDealerCustomerModel;
import com.yundian.fssapi.domain.FssDealerUserModel;
import com.yundian.fssapi.domain.FssLoanModel;
import com.yundian.fssapi.exception.FssDealerException;
import com.yundian.fssapi.service.FssDealerCustomerService;
import com.yundian.result.*;
import com.yundian.toolkit.utils.BeanUtilsExt;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.util.resources.et.CalendarData_et;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * 经销商客户服务
 *
 * @author jnx
 * @create 2018/4/10
 */
@Slf4j
@Service("fssDealerCustomerService")
public class FssDealerCustomerServiceImpl implements FssDealerCustomerService{

    @Autowired
    FssDealerCustomerModelMapper fssDealerCustomerModelMapper;

    @Override
    public FssDealerCustomerModel getFssDealerCustomer(Long customerId) {
        try {
            return fssDealerCustomerModelMapper.selectByPrimaryKey(customerId);

        } catch (Exception e) {
            log.error(String.format("获取经销商客户信息失败:%s", customerId), e);
            throw new FssDealerException(ResultCodeContants.FAILED, "获取经销商客户信息失败", e);

        }
    }

    @Override
    public Integer insertFssDealerCustomer(FssDealerCustomerModel fssDealerCustomerModel) {
        try {
            fssDealerCustomerModel.setCtime(new Date());
            fssDealerCustomerModel.setMtime(new Date());

            return fssDealerCustomerModelMapper.insert(fssDealerCustomerModel);

        } catch (Exception e) {
            log.error(String.format("新增经销商客户信息失败:%s", JSON.toJSONString(fssDealerCustomerModel)), e);
            throw new FssDealerException(ResultCodeContants.FAILED, "新增经销商客户信息失败", e);

        }
    }

    @Override
    public Integer updateFssDealerCustomer(FssDealerCustomerModel fssDealerCustomerModel) {
        try {
            fssDealerCustomerModel.setMtime(new Date());
            return fssDealerCustomerModelMapper.updateByPrimaryKey(fssDealerCustomerModel);

        } catch (Exception e) {
            log.error(String.format("修改经销商客户信息失败:%s", JSON.toJSONString(fssDealerCustomerModel)), e);
            throw new FssDealerException(ResultCodeContants.FAILED, "修改经销商客户信息失败", e);

        }
    }

    @Override
    public Page<FssDealerCustomerModel> getPaginatorFssDealerCustomer(Paginator<FssDealerCustomerModel> paginator) {
        try {
            HashMap<String, Object> param = new HashMap<String, Object>();
            param.put("_limit", paginator.getPageSize());
            param.put("_offset",
                    (paginator.getCurrentPage() - 1) * paginator.getPageSize());
            BeanUtilsExt.copyPropertiesToMap(paginator.getParam(), param);
            List<FssDealerCustomerModel> list = this.fssDealerCustomerModelMapper
                    .getFssDealerCustomerPaging(param);
            Integer count = fssDealerCustomerModelMapper.getFssDealerCustomerPagingCount(param);
            return PageProvider.getPage(paginator,count,list,FssDealerCustomerModel.class);

        } catch (Exception e) {
            log.error(
                    String.format("分页查询经销商客户异常:%s",
                            ToStringBuilder.reflectionToString(paginator)), e);

            throw new FssDealerException(ResultCodeContants.FAILED,
                    "分页查询经销商客户异常", e);
        }
    }
}
