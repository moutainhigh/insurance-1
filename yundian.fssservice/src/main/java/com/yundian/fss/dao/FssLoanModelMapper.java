package com.yundian.fss.dao;

import com.yundian.fssapi.domain.FssDealerUserModel;
import com.yundian.fssapi.domain.FssLoanModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface FssLoanModelMapper {
    int deleteByPrimaryKey(Long loanId);

    int insert(FssLoanModel record);

    int insertSelective(FssLoanModel record);

    FssLoanModel selectByPrimaryKey(Long loanId);

    int updateByPrimaryKeySelective(FssLoanModel record);

    int updateByPrimaryKey(FssLoanModel record);
    /**
     * 分页查询用户
     * @param param
     * @return
     */
    List<FssLoanModel> getFssLoanPaging(
            Map<String, Object> param);

    Integer getFssLoanPagingCount(Map<String, Object> param);


    List<FssLoanModel> getFssLoanListByIdCardNo(@Param("idCardNo") String  idCardNo);
}