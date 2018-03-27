package com.yundian.fss.manager;

import java.util.List;

import com.yundian.fssapi.domain.FssCreditRiskModel;
import com.yundian.result.PaginatedResult;
import com.yundian.result.Paginator;

/**
 * 征信风险信息服务
 * 
 * @author haibo.he
 * @version $Id: FssCreditRiskMananger.java, v 0.1 2016年7月26日 下午8:59:44 haibo.he Exp $
 */
public interface FssCreditRiskMananger {
	Long insertFssCreditRisk (FssCreditRiskModel fssCreditRiskModel);
	
	Integer updateFssCreditRisk(FssCreditRiskModel fssCreditRiskModel);

			
	Integer deleteFssCreditRiskByRiskId ( Long riskId );
																																				
	FssCreditRiskModel getFssCreditRiskById(Long id);

	List<FssCreditRiskModel> getFssCreditRiskList(FssCreditRiskModel fssCreditRiskModel);
	
	/**
	 * 根据征信ID获取风险信息以及详情
	 * @param creditId
	 * @return
	 */
	FssCreditRiskModel getFssCreditRiskAndDetailByCreditId(Long creditId);

	
	PaginatedResult<FssCreditRiskModel> getPaginatorFssCreditRisk(
            Paginator<FssCreditRiskModel> paginator);
}
