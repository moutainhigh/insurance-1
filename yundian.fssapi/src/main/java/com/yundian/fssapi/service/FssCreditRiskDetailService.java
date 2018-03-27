package com.yundian.fssapi.service;

import java.util.List;

import com.yundian.fssapi.domain.FssCreditRiskDetailModel;
import com.yundian.result.Result;

/**
 * 征信风险详情服务
 * 
 * @author haibo.he
 * @version $Id: FssCreditRiskDetailService.java, v 0.1 2016年7月26日 下午8:59:44
 *          haibo.he Exp $
 */
public interface FssCreditRiskDetailService {
	Result<Long> insertFssCreditRiskDetail(
			FssCreditRiskDetailModel fssCreditRiskDetailModel);

	Result<Integer> updateFssCreditRiskDetail(
			FssCreditRiskDetailModel fssCreditRiskDetailModel);

	Result<Integer> deleteFssCreditRiskDetailById(Long id);

	Result<FssCreditRiskDetailModel> getFssCreditRiskDetailById(Long id);

	Result<List<FssCreditRiskDetailModel>> getFssCreditRiskDetailByRiskId(Long riskId);

}
