package com.yundian.fss.manager.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.yundian.fss.dao.FssBankAddedConfModelMapper;
import com.yundian.fss.manager.FssBankAddedConfMananger;
import com.yundian.fssapi.domain.FssBankAddedConfModel;

/**
 * 银行相关配置服务实现
 * 
 * @author haibo.he
 * @version $Id: FssBankAddedConfManagerImpl.java, v 0.1 2016年7月26日 下午8:59:44
 *          haibo.he Exp $
 */
@Transactional
public class FssBankAddedConfManagerImpl implements FssBankAddedConfMananger {

	@Autowired
	private FssBankAddedConfModelMapper fssBankAddedConfModelMapper;

	public Long insertFssBankAddedConf(
			FssBankAddedConfModel fssBankAddedConfModel) {
		this.fssBankAddedConfModelMapper.insert(fssBankAddedConfModel);
		return fssBankAddedConfModel.getId();
	}

	public Integer updateFssBankAddedConf(
			FssBankAddedConfModel fssBankAddedConfModel) {
		return this.fssBankAddedConfModelMapper
				.updateByPrimaryKey(fssBankAddedConfModel);
	}

	public Integer deleteFssBankAddedConfById(Long id) {
		return 0;
	}

	public Integer deleteFssBankAddedConfByBankId(Long bankId) {
		return this.fssBankAddedConfModelMapper.deleteByBankId(bankId);
	}
	public FssBankAddedConfModel getFssBankAddedConfById(Long id) {
		return this.fssBankAddedConfModelMapper.selectByPrimaryKey(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.yundian.fss.manager.FssBankAddedConfMananger#getFssBankAddedConfByBankId
	 * (java.lang.Long)
	 */
	@Override
	public FssBankAddedConfModel getFssBankAddedConfByBankId(Long bankId) {
		return this.fssBankAddedConfModelMapper
				.getFssBankAddedConfByBankId(bankId);
	}

}
