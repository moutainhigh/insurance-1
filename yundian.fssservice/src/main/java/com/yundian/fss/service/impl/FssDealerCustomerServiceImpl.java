package com.yundian.fss.service.impl;

import com.alibaba.fastjson.JSON;
import com.yundian.fss.dao.FssDealerCustomerModelMapper;
import com.yundian.fssapi.domain.FssDealerCustomerModel;
import com.yundian.fssapi.domain.FssDealerUserModel;
import com.yundian.fssapi.exception.FssDealerException;
import com.yundian.fssapi.service.FssDealerCustomerService;
import com.yundian.result.PaginatedResult;
import com.yundian.result.Paginator;
import com.yundian.result.ResultCodeContants;
import com.yundian.toolkit.utils.BeanUtilsExt;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * 经销商客户服务
 *
 * @author jnx
 * @create 2018/4/10
 */
@Slf4j
@Service
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

            return fssDealerCustomerModelMapper.insert(fssDealerCustomerModel);

        } catch (Exception e) {
            log.error(String.format("新增经销商客户信息失败:%s", JSON.toJSONString(fssDealerCustomerModel)), e);
            throw new FssDealerException(ResultCodeContants.FAILED, "新增经销商客户信息失败", e);

        }
    }

    @Override
    public Integer updateFssDealerCustomer(FssDealerCustomerModel fssDealerCustomerModel) {
        try {

            return fssDealerCustomerModelMapper.updateByPrimaryKey(fssDealerCustomerModel);

        } catch (Exception e) {
            log.error(String.format("修改经销商客户信息失败:%s", JSON.toJSONString(fssDealerCustomerModel)), e);
            throw new FssDealerException(ResultCodeContants.FAILED, "修改经销商客户信息失败", e);

        }
    }

    @Override
    public PaginatedResult<FssDealerCustomerModel> getPaginatorFssDealerCustomer(Paginator<FssDealerCustomerModel> paginator) {
        try {
            HashMap<String, Object> param = new HashMap<String, Object>();
            param.put("_limit", paginator.getPageSize());
            param.put("_offset",
                    (paginator.getCurrentPage() - 1) * paginator.getPageSize());
            BeanUtilsExt.copyPropertiesToMap(paginator.getParam(), param);

            List<FssDealerCustomerModel> list = this.fssDealerCustomerModelMapper
                    .getFssDealerCustomerPaging(param);

            Integer count = fssDealerCustomerModelMapper.getFssDealerCustomerPagingCount(param);
            PaginatedResult<FssDealerCustomerModel> paginatedResult = new PaginatedResult<FssDealerCustomerModel>();
            paginatedResult.setRows(list);
            paginatedResult.setTotal(count);
            return paginatedResult;
        } catch (Exception e) {
            log.error(
                    String.format("分页查询经销商客户异常:%s",
                            ToStringBuilder.reflectionToString(paginator)), e);

            throw new FssDealerException(ResultCodeContants.FAILED,
                    "分页查询经销商客户异常", e);
        }
    }
}
