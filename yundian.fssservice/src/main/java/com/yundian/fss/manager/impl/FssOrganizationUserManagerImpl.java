package com.yundian.fss.manager.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.yundian.fss.dao.FssOrganizationUserModelMapper;
import com.yundian.fss.exception.FssLoanBizException;
import com.yundian.fss.manager.FssOrganizationUserManager;
import com.yundian.fssapi.domain.FssOrganizationUserModel;
import com.yundian.fssapi.domain.query.FssOrganizationUserQueryModel;
import com.yundian.result.PaginatedResult;
import com.yundian.result.Paginator;
import com.yundian.result.ResultCodeContants;
import com.yundian.toolkit.utils.BeanUtilsExt;

/**
 * 渠道机构用户服务实现
 * 
 * @author hehaibo
 * @version $Id: FssOrganizationUserManagerImpl.java, v 0.1 2016年7月26日 下午8:59:44
 *          hehaibo Exp $
 */
@Transactional
public class FssOrganizationUserManagerImpl implements
		FssOrganizationUserManager {
	private static final Logger logger = LoggerFactory
			.getLogger(FssOrganizationUserManagerImpl.class);

	@Autowired
	private FssOrganizationUserModelMapper fssOrganizationUserModelMapper;

	public Integer insertFssOrganizationUser(
			FssOrganizationUserModel fssOrganizationUserModel) {
		try {
			Integer row = this.fssOrganizationUserModelMapper
					.insert(fssOrganizationUserModel);
			return row;
		} catch (Exception e) {
			logger.error(String.format("添加贷款信息异常:%s", ToStringBuilder
					.reflectionToString(fssOrganizationUserModel)), e);
			throw new FssLoanBizException(ResultCodeContants.failed, "", e);

		}
	}
	

	@Override
	public Integer initInsertFssOrganizationUser(
			FssOrganizationUserModel fssOrganizationUserModel) {
		try {
			Integer count =
					this.fssOrganizationUserModelMapper
					.getFssOrganizationUserCountByOrgId(fssOrganizationUserModel.getOrganizationId());
			if(count>0){
				throw new FssLoanBizException(ResultCodeContants.failed, "该机构已经初始化过用户");
			}
			return this.insertFssOrganizationUser(fssOrganizationUserModel);
		}catch (FssLoanBizException e){
			throw e;
		}
		catch (Exception e) {
			logger.error(String.format("添加贷款信息异常:%s", ToStringBuilder
					.reflectionToString(fssOrganizationUserModel)), e);
			throw new FssLoanBizException(ResultCodeContants.failed, "", e);

		}
	}


	public Integer updateFssOrganizationUser(
			FssOrganizationUserModel fssOrganizationUserModel) {
		try {
			Integer row = this.fssOrganizationUserModelMapper
					.updateByPrimaryKey(fssOrganizationUserModel);
			return row;
		} catch (Exception e) {
			logger.error(String.format("修改贷款信息异常:%s", ToStringBuilder
					.reflectionToString(fssOrganizationUserModel)), e);
			throw new FssLoanBizException(ResultCodeContants.failed, "", e);
		}
	}

	public Integer deleteFssOrganizationUserByOrguserId(Long orguserId) {
		try {
			// TODO 要判断其他的数据是否有删除
			Integer row = this.fssOrganizationUserModelMapper
					.deleteByPrimaryKey(orguserId);
			return row;
		} catch (Exception e) {
			logger.error(String.format("删除贷款信息异常:%d", orguserId), e);
			throw new FssLoanBizException(ResultCodeContants.failed, "", e);
		}
	}

	public FssOrganizationUserModel getFssOrganizationUserById(Long id) {
		try {
			FssOrganizationUserModel row = this.fssOrganizationUserModelMapper
					.selectByPrimaryKey(id);
			return row;
		} catch (Exception e) {
			logger.error(String.format("查询单个贷款信息异常:%d", id), e);
			throw new FssLoanBizException(ResultCodeContants.failed, "", e);
		}
	}

	public List<FssOrganizationUserModel> getFssOrganizationUserList(
			FssOrganizationUserModel fssOrganizationUserModel) {
		try {
			List<FssOrganizationUserModel> row = null;// TODO
			return row;
		} catch (Exception e) {
			logger.error(String.format("查询列表贷款信息异常:%s", ToStringBuilder
					.reflectionToString(fssOrganizationUserModel)), e);
			throw new FssLoanBizException(ResultCodeContants.failed, "", e);
		}
	}

	public PaginatedResult<FssOrganizationUserQueryModel> getPaginatorFssOrganizationUser(
			Paginator<FssOrganizationUserQueryModel> paginator) {
		try {
			HashMap<String, Object> param = new HashMap<String, Object>();
			param.put("_limit", paginator.getPageSize());
			param.put("_offset",
					(paginator.getCurrentPage() - 1) * paginator.getPageSize());
			BeanUtilsExt.copyPropertiesToMap(paginator.getParam(), param);

			List<FssOrganizationUserQueryModel> list = this.fssOrganizationUserModelMapper
					.getFssOrganizationUserPaging(param);
			Integer count = fssOrganizationUserModelMapper
					.getFssOrganizationUserPagingCount(param);
			PaginatedResult<FssOrganizationUserQueryModel> paginatedResult = new PaginatedResult<FssOrganizationUserQueryModel>();
			paginatedResult.setRows(list);
			paginatedResult.setTotal(count);
			return paginatedResult;
		} catch (Exception e) {
			logger.error(
					String.format("分页查询审批机构信息异常:%s",
							ToStringBuilder.reflectionToString(paginator)), e);
			throw new FssLoanBizException(ResultCodeContants.failed,
					"分页查询审批机构信息异常", e);
		}
	}

	@Override
	public FssOrganizationUserModel fssOrganizationUserLogin(String userName,
			String password) {
		try {
			FssOrganizationUserModel userModel = this.fssOrganizationUserModelMapper
					.getFssOrganizationUserByUserAndPwd(userName, password);
			if(userModel==null){
				throw new FssLoanBizException(ResultCodeContants.failed, "用户名或密码错误");
			}
			return userModel;
		} catch (Exception e) {
			logger.error(String.format("查询单个贷款信息异常:%s", userName), e);
			if (e instanceof FssLoanBizException) {
				throw e;
			}
			else{
				throw new FssLoanBizException(ResultCodeContants.failed, "系统错误", e);
			}
		}
	}

}
