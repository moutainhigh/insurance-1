package com.yundian.fss.manager.impl;

import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.yundian.fss.dao.FssCodeLibraryModelMapper;
import com.yundian.fss.exception.FssLoanBizException;
import com.yundian.fss.manager.FssCodeLibraryManager;
import com.yundian.fssapi.domain.FssCodeLibraryModel;
import com.yundian.result.PaginatedResult;
import com.yundian.result.Paginator;
import com.yundian.result.ResultCodeContants;

/**
 * 代码配置字典项表
 * 
 * @author hehaibo
 * @version $Id: FssCodeLibraryManagerImpl.java, v 0.1 2016年7月26日 下午8:59:44
 *          hehaibo Exp $
 */
@Transactional
public class FssCodeLibraryManagerImpl implements FssCodeLibraryManager {
	private static final Logger logger = LoggerFactory
			.getLogger(FssCodeLibraryManagerImpl.class);
	@Autowired
	private FssCodeLibraryModelMapper fssCodeLibraryModelMapper;

	public Integer insertFssCodeLibrary(FssCodeLibraryModel fssCodeLibraryModel) {

		try {
			Integer row = this.fssCodeLibraryModelMapper
					.insert(fssCodeLibraryModel);
			return row;
		} catch (Exception e) {
			logger.error(String.format("添加代码配置字典项异常:%s",
					ToStringBuilder.reflectionToString(fssCodeLibraryModel)), e);
			throw new FssLoanBizException(ResultCodeContants.failed, "", e);
		}

	}

	public Integer updateFssCodeLibrary(FssCodeLibraryModel fssCodeLibraryModel) {
		try {
			Integer row = this.fssCodeLibraryModelMapper
					.updateByPrimaryKey(fssCodeLibraryModel);
			return row;
		} catch (Exception e) {
			logger.error(String.format("修改代码配置字典项异常:%s",
					ToStringBuilder.reflectionToString(fssCodeLibraryModel)), e);
			throw new FssLoanBizException(ResultCodeContants.failed, "", e);
		}
	}

	public Integer deleteFssCodeLibraryById(Integer id) {
		try {
			Integer row = this.fssCodeLibraryModelMapper.deleteByPrimaryKey(id);
			return row;
		} catch (Exception e) {
			logger.error(String.format("删除代码配置字典项异常:%d", id), e);
			throw new FssLoanBizException(ResultCodeContants.failed, "删除代码配置字典项异常", e);
		}
	}

	public FssCodeLibraryModel getFssCodeLibraryById(Integer id) {
		try {
			FssCodeLibraryModel row = this.fssCodeLibraryModelMapper
					.selectByPrimaryKey(id);
			return row;
		} catch (Exception e) {
			logger.error(String.format("删除代码配置字典项异常:%s", id), e);
			throw new FssLoanBizException(ResultCodeContants.failed, "", e);
		}

	}

	public List<FssCodeLibraryModel> getFssCodeLibraryList(
			FssCodeLibraryModel fssCodeLibraryModel) {
		try {
			List<FssCodeLibraryModel> data = null;// TODO
			return data;
		} catch (Exception e) {
			logger.error(String.format("查询列表代码配置字典项异常:%s",
					ToStringBuilder.reflectionToString(fssCodeLibraryModel)), e);
			throw new FssLoanBizException(ResultCodeContants.failed, "", e);
		}
	}

	public PaginatedResult<FssCodeLibraryModel> getPaginatorFssCodeLibrary(
			Paginator<FssCodeLibraryModel> paginator) {
		try {
			PaginatedResult<FssCodeLibraryModel> data = null;// TODO
			return data;
		} catch (Exception e) {
			logger.error(
					String.format("分页查询列表代码配置字典项异常:%s",
							ToStringBuilder.reflectionToString(paginator)), e);
			throw new FssLoanBizException(ResultCodeContants.failed, "", e);
		}
	}

}
