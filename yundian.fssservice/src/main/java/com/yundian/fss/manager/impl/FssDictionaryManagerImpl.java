package com.yundian.fss.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.yundian.fss.dao.FssDictionaryModelMapper;
import com.yundian.fss.manager.FssDictionaryManager;
import com.yundian.fssapi.domain.FssDictionaryModel;
import com.yundian.result.PaginatedResult;
import com.yundian.result.Paginator;

/**
 * 数据字典服务实现
 * 
 * @author haibo.he
 * @version $Id: FssDictionaryServiceImpl.java, v 0.1 2016年7月26日 下午8:59:44
 *          haibo.he Exp $
 */
@Transactional
public class FssDictionaryManagerImpl implements FssDictionaryManager {

	@Autowired
	private FssDictionaryModelMapper fssDictionaryModelMapper;

	public Integer insertFssDictionary(FssDictionaryModel fssDictionaryModel) {
		return this.fssDictionaryModelMapper.insert(fssDictionaryModel);
	}

	public Integer updateFssDictionary(FssDictionaryModel fssDictionaryModel) {
		return this.fssDictionaryModelMapper
				.updateByPrimaryKey(fssDictionaryModel);
	}

	public Integer deleteFssDictionaryById(Long id) {
		return 0;
	}

	public FssDictionaryModel getFssDictionaryById(Integer id) {
		return this.fssDictionaryModelMapper.selectByPrimaryKey(id);
	}

	public List<FssDictionaryModel> getFssDictionaryList(
			FssDictionaryModel fssDictionaryModel) {
		return this.fssDictionaryModelMapper.getFssDictionaryList(fssDictionaryModel);
	}

	public PaginatedResult<FssDictionaryModel> getPaginatorFssDictionary(
			Paginator<FssDictionaryModel> paginator) {
		return null;
	}

	@Override
	public FssDictionaryModel getFssDictionaryByTypeAndItemCode(
			String dictTypeCode, String itemCode) {
		return fssDictionaryModelMapper.getFssDictionaryByTypeAndItemCode(
				dictTypeCode, itemCode);
	}

}
