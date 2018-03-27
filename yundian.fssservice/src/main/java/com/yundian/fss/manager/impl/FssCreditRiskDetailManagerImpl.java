package com.yundian.fss.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.yundian.fss.dao.FssCreditRiskDetailModelMapper;
import com.yundian.fss.manager.FssCreditRiskDetailMananger;
import com.yundian.fssapi.domain.FssCreditRiskDetailModel;

/**
 * 征信风险详情服务实现
 * 
 * @author haibo.he
 * @version $Id: FssCreditRiskDetailManagerImpl.java, v 0.1 2016年7月26日 下午8:59:44 haibo.he Exp $
 */
@Transactional
public class FssCreditRiskDetailManagerImpl implements FssCreditRiskDetailMananger{
	
	@Autowired
	private FssCreditRiskDetailModelMapper  fssCreditRiskDetailMapper;
	
	public Long insertFssCreditRiskDetail (FssCreditRiskDetailModel fssCreditRiskDetailModel){
		this.fssCreditRiskDetailMapper.insert ( fssCreditRiskDetailModel);
		return 0L;
	}
	
	public Integer updateFssCreditRiskDetail(FssCreditRiskDetailModel fssCreditRiskDetailModel){
		return this.fssCreditRiskDetailMapper.updateByPrimaryKey( fssCreditRiskDetailModel);
	}

			
	public Integer deleteFssCreditRiskDetailById ( Long id )
	{
				return 0;
	}
																		
	public FssCreditRiskDetailModel getFssCreditRiskDetailById(Long id){
		return this.fssCreditRiskDetailMapper.selectByPrimaryKey(id);
	}

	public List<FssCreditRiskDetailModel> getFssCreditRiskDetailList(FssCreditRiskDetailModel fssCreditRiskDetailModel){
		return this.fssCreditRiskDetailMapper.getFssCreditRiskDetailList (fssCreditRiskDetailModel);
	}

	/* (non-Javadoc)
	 * @see com.yundian.fss.manager.FssCreditRiskDetailMananger#getFssCreditRiskDetailByRiskId(java.lang.Long)
	 */
	@Override
	public List<FssCreditRiskDetailModel> getFssCreditRiskDetailByRiskId(
			Long riskId) {
		return fssCreditRiskDetailMapper.getFssCreditRiskDetailByRiskId(riskId);
	}
	

	
}
