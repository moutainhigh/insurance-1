package com.yundian.fss.manager;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.yundian.fssapi.domain.FssCreditModel;
import com.yundian.fssapi.dto.param.FssCreditQueryParam;
import com.yundian.result.PaginatedResult;
import com.yundian.result.Paginator;

/**
 * 征信查询表服务
 * 
 * @author haibo.he
 * @version $Id: FssCreditMananger.java, v 0.1 2016年7月26日 下午8:59:44 haibo.he Exp
 *          $
 */
public interface FssCreditMananger {
	Long insertFssCredit(FssCreditModel fssCreditModel);

	Integer updateFssCredit(FssCreditModel fssCreditModel);
	Integer updateFssCreditSelective(FssCreditModel fssCreditModel);
	Integer deleteFssCreditByCreditId(Long creditId);

	FssCreditModel getFssCreditAndCreditLogById(Long id);

	PaginatedResult<FssCreditModel> getPaginatorFssCredit(
			Paginator<FssCreditQueryParam> paginator);
	Map<String,Integer> getCreditStatusStat(@Param("guaranteeId") Long guaranteeId,@Param("bankId") Long bankId);

}
