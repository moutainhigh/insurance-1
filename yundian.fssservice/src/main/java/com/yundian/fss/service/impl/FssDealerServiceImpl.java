package com.yundian.fss.service.impl;

import com.alibaba.fastjson.JSON;
import com.yundian.fss.dao.FssDealerModelMapper;
import com.yundian.fssapi.domain.FssDealerModel;
import com.yundian.fssapi.domain.FssLoanModel;
import com.yundian.fssapi.exception.FssLoanException;
import com.yundian.fssapi.service.FssDealerService;
import com.yundian.result.*;
import com.yundian.toolkit.utils.BeanUtilsExt;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * 经销商服务
 *
 * @author jnx
 * @create 2018/4/13
 */
@Service
@Slf4j
public class FssDealerServiceImpl implements FssDealerService {

    @Autowired
    FssDealerModelMapper fssDealerModelMapper;

    @Override
    public FssDealerModel getFssDealer(Long dealerId) {
        try {
            return fssDealerModelMapper.selectByPrimaryKey(dealerId);

        } catch (Exception e) {
            log.error(String.format("获取经销商信息失败:%s", dealerId), e);
            throw new FssLoanException(ResultCodeContants.FAILED, "获取经销商信息失败", e);
        }
    }

    @Override
    public Page<FssDealerModel> getPaginatorFssDealer(Paginator<FssDealerModel> paginator) {
        try {
            HashMap<String, Object> param = new HashMap<String, Object>();
            param.put("_limit", paginator.getPageSize());
            param.put("_offset",
                    (paginator.getCurrentPage() - 1) * paginator.getPageSize());
            BeanUtilsExt.copyPropertiesToMap(paginator.getParam(), param);

            List<FssDealerModel> list = this.fssDealerModelMapper.
                    getFssDealerPaging(param);
            Integer count = fssDealerModelMapper.getFssDealerPagingCount(param);
            return PageProvider.getPage(paginator,count,list,FssDealerModel.class);
        } catch (Exception e) {
            log.error(
                    String.format("分页查询经销商数据异常:%s",
                            ToStringBuilder.reflectionToString(paginator)), e);

            throw new FssLoanException(ResultCodeContants.FAILED,
                    "分页查询经销商数据异常", e);
        }
    }
}
