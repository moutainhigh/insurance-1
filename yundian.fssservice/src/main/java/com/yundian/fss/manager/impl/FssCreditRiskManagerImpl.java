package com.yundian.fss.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.yundian.fss.dao.FssCreditRiskDetailModelMapper;
import com.yundian.fss.dao.FssCreditRiskModelMapper;
import com.yundian.fss.manager.FssCreditRiskMananger;
import com.yundian.fssapi.domain.FssCreditRiskDetailModel;
import com.yundian.fssapi.domain.FssCreditRiskModel;
import com.yundian.result.PaginatedResult;
import com.yundian.result.Paginator;

/**
 * 征信风险信息服务实现
 * 
 * @author haibo.he
 * @version $Id: FssCreditRiskManagerImpl.java, v 0.1 2016年7月26日 下午8:59:44
 *          haibo.he Exp $
 */
@Transactional
public class FssCreditRiskManagerImpl implements FssCreditRiskMananger {

	@Autowired
	private FssCreditRiskModelMapper fssCreditRiskModelMapper;

	@Autowired
	private FssCreditRiskDetailModelMapper fssCreditRiskDetailModelMapper;

	public Long insertFssCreditRisk(FssCreditRiskModel fssCreditRiskModel) {
		this.fssCreditRiskModelMapper.insert(fssCreditRiskModel);
		return fssCreditRiskModel.getRiskId();

	}

	public Integer updateFssCreditRisk(FssCreditRiskModel fssCreditRiskModel) {
		return this.fssCreditRiskModelMapper
				.updateByPrimaryKey(fssCreditRiskModel);
	}

	public Integer deleteFssCreditRiskByRiskId(Long riskId) {
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.yundian.fss.manager.FssCreditRiskMananger#
	 * getFssCreditRiskAndDetailByCreditId(java.lang.Long)
	 */
	@Override
	public FssCreditRiskModel getFssCreditRiskAndDetailByCreditId(Long creditId) {
		FssCreditRiskModel fssCreditRiskModel = this.fssCreditRiskModelMapper
				.getFssCreditRiskByCreditId(creditId);
		if(fssCreditRiskModel==null){
			return null;
		}
		List<FssCreditRiskDetailModel> creditRiskDetailModels = fssCreditRiskDetailModelMapper
				.getFssCreditRiskDetailByRiskId(fssCreditRiskModel.getRiskId());
		fssCreditRiskModel.setCreditRiskDetailList(creditRiskDetailModels);
		return fssCreditRiskModel;
	}

	public FssCreditRiskModel getFssCreditRiskById(Long id) {
		return this.fssCreditRiskModelMapper.selectByPrimaryKey(id);
	}

	public List<FssCreditRiskModel> getFssCreditRiskList(
			FssCreditRiskModel fssCreditRiskModel) {
		return this.fssCreditRiskModelMapper
				.getFssCreditRiskList(fssCreditRiskModel);
	}

	public PaginatedResult<FssCreditRiskModel> getPaginatorFssCreditRisk(
			Paginator<FssCreditRiskModel> paginator) {
		return this.fssCreditRiskModelMapper
				.getPaginatorFssCreditRisk(paginator);
	}

}
