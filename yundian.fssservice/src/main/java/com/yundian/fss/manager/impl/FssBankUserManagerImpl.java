package com.yundian.fss.manager.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.yundian.fss.dao.FssBankUserModelMapper;
import com.yundian.fss.exception.FssLoanBizException;
import com.yundian.fss.manager.FssBankUserManager;
import com.yundian.fssapi.domain.FssBankUserModel;
import com.yundian.fssapi.domain.query.FssBankUserQueryModel;
import com.yundian.result.PaginatedResult;
import com.yundian.result.Paginator;
import com.yundian.result.ResultCodeContants;
import com.yundian.toolkit.utils.BeanUtilsExt;

/**
 * 银行用户服务实现
 * 
 * @author hehaibo
 * @version $Id: FssBankUserManagerImpl.java, v 0.1 2016年7月26日 下午8:59:44 hehaibo
 *          Exp $
 */
@Transactional
public class FssBankUserManagerImpl implements FssBankUserManager {
	private static final Logger logger = LoggerFactory
			.getLogger(FssBankUserManagerImpl.class);

	@Autowired
	private FssBankUserModelMapper fssBankUserModelMapper;

	public Integer insertFssBankUser(FssBankUserModel fssBankUser) {
		try {
			// TODO 重复校验
			Integer row = this.fssBankUserModelMapper.insert(fssBankUser);
			return row;
		} catch (Exception e) {
			logger.error(
					String.format("添加银行用户异常:%s",
							ToStringBuilder.reflectionToString(fssBankUser)), e);
			throw new FssLoanBizException(ResultCodeContants.failed, "添加银行用户异常", e);

		}
	}

	public Integer initInsertFssBankUser(FssBankUserModel fssBankUser) {
		try {
			Integer count = 
						this.fssBankUserModelMapper.getFssBankUserCountByBankId(fssBankUser.getBankId());
			if(count>0){
				throw new FssLoanBizException(ResultCodeContants.failed, "用户已经初始化!");
			}
			return this.fssBankUserModelMapper.insert(fssBankUser);
		}catch(FssLoanBizException e){
			throw e ;
		} catch (Exception e) {
			logger.error(
					String.format("添加银行用户异常:%s",
							ToStringBuilder.reflectionToString(fssBankUser)), e);
			throw new FssLoanBizException(ResultCodeContants.failed, "添加银行用户异常", e);

		}
	}
	
	public Integer updateFssBankUser(FssBankUserModel fssBankUser) {
		try {
			Integer row = this.fssBankUserModelMapper
					.updateByPrimaryKey(fssBankUser);
			return row;
		} catch (Exception e) {
			logger.error(
					String.format("修改银行用户异常:%s",
							ToStringBuilder.reflectionToString(fssBankUser)), e);
			throw new FssLoanBizException(ResultCodeContants.failed, "修改银行用户", e);
		}
	}

	public Integer deleteFssBankUserByBkuserId(Long bkuserId) {
		try {
			// TODO 要判断关联数据 是否删除？
			Integer row = this.fssBankUserModelMapper
					.deleteByPrimaryKey(bkuserId);
			return row;
		} catch (Exception e) {
			logger.error(String.format("删除银行用户异常:%d", bkuserId), e);
			throw new FssLoanBizException(ResultCodeContants.failed, "删除银行用户异常", e);
		}
	}

	public FssBankUserModel getFssBankUserById(Long id) {
		try {
			FssBankUserModel data = this.fssBankUserModelMapper
					.selectByPrimaryKey(id);
			return data;
		} catch (Exception e) {
			logger.error(String.format("查询单个银行用户异常:%s", id), e);
			throw new FssLoanBizException(ResultCodeContants.failed, "查询单个银行用户异常", e);
		}

	}

	public List<FssBankUserModel> getFssBankUserList(
			FssBankUserModel fssBankUser) {
		try {
			List<FssBankUserModel> data = null;
			return data;
		} catch (Exception e) {
			logger.error(
					String.format("查询列表银行用户异常:%s",
							ToStringBuilder.reflectionToString(fssBankUser)), e);
			throw new FssLoanBizException(ResultCodeContants.failed, "查询列表银行用户异常", e);
		}
	}

	public PaginatedResult<FssBankUserQueryModel> getPaginatorFssBankUser(
			Paginator<FssBankUserQueryModel> paginator) {

		try {
			HashMap<String, Object> param = new HashMap<String, Object>();
			param.put("_limit", paginator.getPageSize());
			param.put("_offset",
					(paginator.getCurrentPage() - 1) * paginator.getPageSize());
			BeanUtilsExt.copyPropertiesToMap(paginator.getParam(), param);

			List<FssBankUserQueryModel> list = this.fssBankUserModelMapper
					.getFssBankUserPaging(param);
			Integer count = fssBankUserModelMapper
					.getFssBankUserPagingCount(param);
			PaginatedResult<FssBankUserQueryModel> paginatedResult = new PaginatedResult<FssBankUserQueryModel>();
			paginatedResult.setRows(list);
			paginatedResult.setTotal(count);
			return paginatedResult;
		} catch (Exception e) {
			logger.error(
					String.format("分页查询银行用户信息信息异常:%s",
							ToStringBuilder.reflectionToString(paginator)), e);
			throw new FssLoanBizException(ResultCodeContants.failed,
					"分页查询银行用户信息异常", e);
		}

	}

	@Override
	public FssBankUserModel getFssBankUserByUserAndPwd(String username,String password) {
		try {
			FssBankUserModel data = this.fssBankUserModelMapper
					.getFssBankUserByUserAndPwd(username, password);
			if(data==null){
				throw new FssLoanBizException(ResultCodeContants.failed, "用户名或密码错误");
			}
			return data;
		} catch (Exception e) {
			logger.error(String.format("银行用户异常:%s", username), e);

			if (e instanceof FssLoanBizException) {
				throw e;
			}
			else{
				throw new FssLoanBizException(ResultCodeContants.failed, "系统异常", e);
			}
		}
		
	}
	
	
	
	
}
