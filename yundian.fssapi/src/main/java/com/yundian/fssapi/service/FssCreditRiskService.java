package com.yundian.fssapi.service;

import java.util.List;

import com.yundian.fssapi.domain.FssCreditRiskModel;
import com.yundian.result.PaginatedResult;
import com.yundian.result.Paginator;
import com.yundian.result.Result;

/**
 * 征信风险信息服务
 * 
 * @author haibo.he
 * @version $Id: FssCreditRiskService.java, v 0.1 2016年7月26日 下午8:59:44 haibo.he
 *          Exp $
 */
public interface FssCreditRiskService {
	Result<Long> insertFssCreditRisk(FssCreditRiskModel fssCreditRiskModel);

	Result<Integer> updateFssCreditRisk(FssCreditRiskModel fssCreditRiskModel);

	Result<Integer> deleteFssCreditRiskByRiskId(Long riskId);

	Result<FssCreditRiskModel> getFssCreditRiskById(Long id);

	Result<List<FssCreditRiskModel>> getFssCreditRiskList(
			FssCreditRiskModel fssCreditRiskModel);

	Result<PaginatedResult<FssCreditRiskModel>> getPaginatorFssCreditRisk(
			Paginator<FssCreditRiskModel> paginator);
	
	/**
	 * 根据征信ID获取风险信息以及详情
	 * @param creditId
	 * @return
	 */
	Result<FssCreditRiskModel> getFssCreditRiskAndDetailByCreditId(Long creditId);
}
