package com.yundian.fss.manager;

import java.util.List;

import com.yundian.fssapi.domain.FssCreditRiskDetailModel;

/**
 * 征信风险详情服务
 * 
 * @author haibo.he
 * @version $Id: FssCreditRiskDetailMananger.java, v 0.1 2016年7月26日 下午8:59:44
 *          haibo.he Exp $
 */
public interface FssCreditRiskDetailMananger {
	Long insertFssCreditRiskDetail(
			FssCreditRiskDetailModel fssCreditRiskDetailModel);

	Integer updateFssCreditRiskDetail(
			FssCreditRiskDetailModel fssCreditRiskDetailModel);

	Integer deleteFssCreditRiskDetailById(Long id);

	FssCreditRiskDetailModel getFssCreditRiskDetailById(Long id);

	List<FssCreditRiskDetailModel> getFssCreditRiskDetailByRiskId(Long riskId);

}
