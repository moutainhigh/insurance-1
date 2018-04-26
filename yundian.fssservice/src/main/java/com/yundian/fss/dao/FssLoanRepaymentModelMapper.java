package com.yundian.fss.dao;

import com.yundian.fssapi.domain.FssLoanModel;
import com.yundian.fssapi.domain.FssLoanRepaymentModel;

import java.util.List;
import java.util.Map;

public interface FssLoanRepaymentModelMapper {
    int deleteByPrimaryKey(Long id);

    int insert(FssLoanRepaymentModel record);

    int insertSelective(FssLoanRepaymentModel record);

    FssLoanRepaymentModel selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FssLoanRepaymentModel record);

    int updateByPrimaryKey(FssLoanRepaymentModel record);

    /**
     * 分页查询还款数据
     * @param param
     * @return
     */
    List<FssLoanRepaymentModel> getFssLoanRepaymentPaging(
            Map<String, Object> param);

    Integer getFssLoanRepaymentPagingCount(Map<String, Object> param);
}