package com.yundian.fss.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.yundian.fss.dao.FssCreditLogModelMapper;
import com.yundian.fss.manager.FssCreditLogMananger;
import com.yundian.fssapi.domain.FssCreditLogModel;

/**
 * 征信日志表服务实现
 * 
 * @author haibo.he
 * @version $Id: FssCreditLogManagerImpl.java, v 0.1 2016年7月26日 下午8:59:44
 *          haibo.he Exp $
 */
@Transactional
public class FssCreditLogManagerImpl implements FssCreditLogMananger {

	@Autowired
	private FssCreditLogModelMapper fssCreditLogMapper;
	
	public Long insertFssCreditLog(FssCreditLogModel fssCreditLogModel) {
		this.fssCreditLogMapper.insert(fssCreditLogModel);
		return fssCreditLogModel.getId();
	}

	public Integer updateFssCreditLog(FssCreditLogModel fssCreditLogModel) {
		return this.fssCreditLogMapper.updateByPrimaryKey(fssCreditLogModel);
	}

	public Integer deleteFssCreditLogById(Long id) {
		return 0;
	}

	public FssCreditLogModel getFssCreditLogById(Long id) {
		return this.fssCreditLogMapper.selectByPrimaryKey(id);
	}

	public List<FssCreditLogModel> getFssCreditLogListByCreditId(Long creditId) {
		return this.fssCreditLogMapper.getFssCreditLogListByCreditId(creditId);
	}

}
