package com.yundian.fssapi.service;

import java.util.Map;

import com.yundian.fssapi.domain.FssCreditModel;
import com.yundian.fssapi.dto.param.FssCreditQueryParam;
import com.yundian.result.PaginatedResult;
import com.yundian.result.Paginator;
import com.yundian.result.Result;

/**
 * 征信查询表服务
 * 
 * @author haibo.he
 * @version $Id: FssCreditService.java, v 0.1 2016年7月26日 下午8:59:44 haibo.he Exp
 *          $
 */
public interface FssCreditService {
	
	/**
	 * 新增征信查询并且根据银行配置决定是否查询同盾风险信息
	 * @param fssCreditModel
	 * @return
	 */
	Result<Long> insertFssCreditAndCreditSearching(FssCreditModel fssCreditModel);
	
	Result<Long> insertFssCredit(FssCreditModel fssCreditModel);

	Result<Integer> updateFssCredit(FssCreditModel fssCreditModel);

	Result<Integer> deleteFssCreditByCreditId(Long creditId);

	Result<FssCreditModel> getFssCreditAndCreditLogById(Long id);

	Result<PaginatedResult<FssCreditModel>> getPaginatorFssCredit(
			Paginator<FssCreditQueryParam> paginator);

	Result<String> submitAuditFssCredit(FssCreditModel fssCreditModel,
			Long bankUserId, String bankUserName);
	
	Result<Map<String,Integer>> getCreditStatusStat(Long guaranteeId,Long bankId);
}
