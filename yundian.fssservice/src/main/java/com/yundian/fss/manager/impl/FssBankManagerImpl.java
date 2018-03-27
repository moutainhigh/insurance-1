package com.yundian.fss.manager.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.yundian.fss.dao.FssBankModelMapper;
import com.yundian.fss.exception.FssLoanBizException;
import com.yundian.fss.manager.FssBankManager;
import com.yundian.fssapi.domain.FssBankModel;
import com.yundian.result.PaginatedResult;
import com.yundian.result.Paginator;
import com.yundian.result.ResultCodeContants;
import com.yundian.toolkit.utils.BeanUtilsExt;

/**
 * 银行服务实现
 * 
 * @author hehaibo
 * @version $Id: FssBankManagerImpl.java, v 0.1 2016年7月26日 下午8:59:44 hehaibo Exp
 *          $
 */
@Transactional
public class FssBankManagerImpl implements FssBankManager {

	private static final Logger logger = LoggerFactory
			.getLogger(FssBankManagerImpl.class);
	@Autowired
	private FssBankModelMapper fssBankModelMapper;

	public Integer insertFssBank(FssBankModel fssBankModel) {
		try {
			return this.fssBankModelMapper.insert(fssBankModel);
		} catch (Exception e) {
			logger.error(
					String.format("添加银行机构异常:%s",
							ToStringBuilder.reflectionToString(fssBankModel)),
					e);
			throw new FssLoanBizException(ResultCodeContants.failed, "添加失败", e);
		}
	}

	public Integer updateFssBankByBankId(FssBankModel fssBankModel) {
		try {
			return this.fssBankModelMapper.updateByPrimaryKey(fssBankModel);
		} catch (Exception e) {
			logger.error(
					String.format("修改银行机构异常:%s",
							ToStringBuilder.reflectionToString(fssBankModel)),
					e);
			throw new FssLoanBizException(ResultCodeContants.failed, "修改失败", e);
		}
	}

	public Integer deleteFssBankByBankId(Integer bankId) {
		try {
			// TODO 要判断其他的条件 关联数据要删除
			return this.fssBankModelMapper.deleteByPrimaryKey(bankId);
		} catch (Exception e) {
			logger.error(String.format("删除银行机构异常:%d", bankId), e);
			throw new FssLoanBizException(ResultCodeContants.failed,
					"删除银行机构失败", e);
		}
	}

	public FssBankModel getFssBankById(Integer id) {
		try {
			return fssBankModelMapper.selectByPrimaryKey(id);
		} catch (Exception e) {
			logger.error(String.format("查询银行机构异常:%d", id), e);
			throw new FssLoanBizException(ResultCodeContants.failed, "查询银行机构异常", e);
		}
	}

	public List<FssBankModel> getFssBankList(FssBankModel fssBankModel) {
		try {
			return this.fssBankModelMapper.getFssBankList(fssBankModel);
		} catch (Exception e) {
			logger.error(
					String.format("查询银行机构列表异常:%s",
							ToStringBuilder.reflectionToString(fssBankModel)),
					e);
			throw new FssLoanBizException(ResultCodeContants.failed, "查询银行机构列表异常", e);
		}
	}

	public PaginatedResult<FssBankModel> getPaginatorFssBank(
			Paginator<FssBankModel> paginator) {
		try {
			HashMap<String, Object> param = new HashMap<String, Object>();
			param.put("_limit", paginator.getPageSize());
			param.put("_offset",
					(paginator.getCurrentPage() - 1) * paginator.getPageSize());
			BeanUtilsExt.copyPropertiesToMap(paginator.getParam(), param);

			List<FssBankModel> list = this.fssBankModelMapper
					.getFssBankPaging(param);
			Integer count = fssBankModelMapper.getFssBankPagingCount(param);
			PaginatedResult<FssBankModel> paginatedResult = new PaginatedResult<FssBankModel>();
			paginatedResult.setRows(list);
			paginatedResult.setTotal(count);
			return paginatedResult;
		} catch (Exception e) {
			logger.error(
					String.format("分页查询银行信息异常:%s",
							ToStringBuilder.reflectionToString(paginator)), e);
			throw new FssLoanBizException(ResultCodeContants.failed,
					"分页查询银行信息异常", e);
		}
	}

	@Override
	public FssBankModel getFssBankFirst() {
		List<FssBankModel> bankModels=	this.fssBankModelMapper.getFssBankList(null);
		return CollectionUtils.isEmpty(bankModels)?null:bankModels.get(0);
	}

}
