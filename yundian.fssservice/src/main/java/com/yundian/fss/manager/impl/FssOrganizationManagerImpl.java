/**
 * 
 */
package com.yundian.fss.manager.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.yundian.result.Result;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.yundian.fss.dao.FssOrganizationModelMapper;
import com.yundian.fss.exception.FssLoanBizException;
import com.yundian.fss.manager.FssOrganizationManager;
import com.yundian.fssapi.domain.FssOrganizationModel;
import com.yundian.result.PaginatedResult;
import com.yundian.result.Paginator;
import com.yundian.result.ResultCodeContants;
import com.yundian.toolkit.utils.BeanUtilsExt;

/**
 * @author hehaibo
 *
 */
@Transactional
public class FssOrganizationManagerImpl implements FssOrganizationManager {
	private static final Logger logger = LoggerFactory
			.getLogger(FssOrganizationManagerImpl.class);
	@Autowired
	private FssOrganizationModelMapper fssOrganizationModelMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.yundian.fssapi.user.service.FssOrganizationService#addFssOrganization
	 * (com.yundian.fssapi.domain.FssOrganizationModel)
	 */
	@Override
	public Integer addFssOrganization(
			FssOrganizationModel fssOrganizationModel) {
		logger.info(String.format("新增审批机构参数:%s",
				ToStringBuilder.reflectionToString(fssOrganizationModel)));
		try {
			int id = fssOrganizationModelMapper.insert(fssOrganizationModel);
			return id;
		} catch (Exception e) {
			logger.error(String.format("新增审批异常,参数：%s",
					ToStringBuilder.reflectionToString(fssOrganizationModel)),
					e);
			throw new FssLoanBizException(ResultCodeContants.failed,"",e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.yundian.fssapi.user.service.FssOrganizationService#modifyFssOrganization
	 * (com.yundian.fssapi.domain.FssOrganizationModel)
	 */
	@Override
	public Integer modifyFssOrganization(
			FssOrganizationModel fssOrganizationModel) {
		
		try {
			FssOrganizationModel fssOrganizationModelDO=
					this.fssOrganizationModelMapper.selectByPrimaryKey(fssOrganizationModel.getOrganizationId());
			//设置要修改的信息
			
			fssOrganizationModelDO.setProvince(fssOrganizationModel.getProvince());
			fssOrganizationModelDO.setCity(fssOrganizationModel.getCity());
			fssOrganizationModelDO.setArea(fssOrganizationModel.getArea());
			
			fssOrganizationModelDO.setProvinceName(fssOrganizationModel.getProvinceName());
			fssOrganizationModelDO.setCityName(fssOrganizationModel.getCityName());
			fssOrganizationModelDO.setAreaName(fssOrganizationModel.getAreaName());
			fssOrganizationModelDO.setStreet(fssOrganizationModel.getStreet());
			fssOrganizationModelDO.setContactor(fssOrganizationModel.getContactor());
			fssOrganizationModelDO.setMtime(new Date());
			fssOrganizationModelDO.setOrganizationName(fssOrganizationModel.getOrganizationName());
			fssOrganizationModelDO.setPhone(fssOrganizationModel.getPhone());
			Integer updateRow = this.fssOrganizationModelMapper.updateByPrimaryKey(fssOrganizationModelDO);
			return updateRow;
		} catch (Exception e) {
			logger.error(String.format("修改审批异常,参数：%s",
					ToStringBuilder.reflectionToString(fssOrganizationModel)),
					e);
			throw new FssLoanBizException(ResultCodeContants.failed,"",e);
		}
	}

	
	
	@Override
	public FssOrganizationModel getFssOrganizationById(Long organizationId) {
		try {
			FssOrganizationModel fssOrganizationModel=
					this.fssOrganizationModelMapper.selectByPrimaryKey(organizationId);
			return fssOrganizationModel;
		} catch (Exception e) {
			logger.error(String.format("查询审批异常,参数：%d",
					organizationId),
					e);
			throw new FssLoanBizException(ResultCodeContants.failed,"",e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.yundian.fssapi.user.service.FssOrganizationService#getPaginatedResult
	 * (com.yundian.result.Paginator)
	 */
	@Override
	public PaginatedResult<FssOrganizationModel> getPaginatedResult(
			Paginator<FssOrganizationModel> paginator) {
		try {
			
			HashMap<String, Object> param = new HashMap<String, Object>();
			param.put("_limit",paginator.getPageSize());
			param.put("_offset",(paginator.getCurrentPage()-1)*paginator.getPageSize());

			BeanUtilsExt.copyPropertiesToMap(paginator.getParam(),param);

			List<FssOrganizationModel> list = this.fssOrganizationModelMapper
					.getFssOrganizationPaging(param);
			Integer count = fssOrganizationModelMapper
					.getFssOrganizationPagingCount(param);
			PaginatedResult<FssOrganizationModel> paginatedResult=new PaginatedResult<FssOrganizationModel>();
			paginatedResult.setRows(list);
			paginatedResult.setTotal(count);
			return paginatedResult;
		} catch (Exception e) {
			logger.error(String.format("分页查询审批机构异常：%s", 
					ToStringBuilder.reflectionToString(paginator)),e);
			throw new FssLoanBizException(ResultCodeContants.failed,"",e);
		}
	}

	@Override
	public List<FssOrganizationModel> listAllOrganization() {
		return this.fssOrganizationModelMapper.listAllOrganization();
	}
}
