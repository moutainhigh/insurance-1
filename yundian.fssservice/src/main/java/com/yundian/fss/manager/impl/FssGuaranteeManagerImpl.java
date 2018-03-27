package com.yundian.fss.manager.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.yundian.fss.dao.FssGuaranteeModelMapper;
import com.yundian.fss.dao.FssGuaranteeUserModelMapper;
import com.yundian.fss.exception.FssLoanBizException;
import com.yundian.fss.manager.FssGuaranteeManager;
import com.yundian.fssapi.domain.FssGuaranteeModel;
import com.yundian.fssapi.enums.FssGuaranteeVerifyStatusEnum;
import com.yundian.result.PaginatedResult;
import com.yundian.result.Paginator;
import com.yundian.result.ResultCodeContants;
import com.yundian.toolkit.utils.BeanUtilsExt;

/**
 * 
 * 担保服务
 * 
 * @author hehaibo
 *
 */
@Transactional
public class FssGuaranteeManagerImpl implements FssGuaranteeManager {

	private static final Logger logger = LoggerFactory
			.getLogger(FssGuaranteeManagerImpl.class);
	@Autowired
	private FssGuaranteeModelMapper fssGuaranteeModelMapper;
	@Autowired
	private FssGuaranteeUserModelMapper fssGuaranteeUserModelMapper;

	@Override
	public Integer addGuarantee(FssGuaranteeModel fssGuaranteeModel) {
		try {
			if(StringUtils.isEmpty(fssGuaranteeModel.getVerifyStatus())){
				fssGuaranteeModel.setVerifyStatus(FssGuaranteeVerifyStatusEnum.NO_AUTH.code());
			}
			Integer resultInt = fssGuaranteeModelMapper
					.insert(fssGuaranteeModel);
			return resultInt;
		} catch (Exception e) {
			logger.error(String.format("添加担保机构信息异常：%s",
					ToStringBuilder.reflectionToString(fssGuaranteeModel)), e);
			throw new FssLoanBizException(ResultCodeContants.failed, "添加担保机构信息异常", e);
		}
	}

	@Override
	public Integer modifyGuarantee(FssGuaranteeModel fssGuaranteeModel) {
		try {
			FssGuaranteeModel fssGuaranteeModelDO = fssGuaranteeModelMapper
					.selectByPrimaryKey(fssGuaranteeModel.getGuaranteeId());

			fssGuaranteeModelDO.setGuaranteeName(fssGuaranteeModel
					.getGuaranteeName());
			fssGuaranteeModelDO.setGuaranteeCode(fssGuaranteeModel
					.getGuaranteeCode());
			fssGuaranteeModelDO.setLicenseCode(fssGuaranteeModel
					.getLicenseCode());
			fssGuaranteeModelDO.setOrganizeCode(fssGuaranteeModel
					.getOrganizeCode());
			fssGuaranteeModelDO.setBusinessentity(fssGuaranteeModel
					.getBusinessentity());

			fssGuaranteeModelDO.setProvince(fssGuaranteeModel.getProvince());
			fssGuaranteeModelDO.setCity(fssGuaranteeModel.getCity());
			fssGuaranteeModelDO.setArea(fssGuaranteeModel.getArea());
			fssGuaranteeModelDO.setProvinceName(fssGuaranteeModel.getProvinceName());
			fssGuaranteeModelDO.setCityName(fssGuaranteeModel.getCityName());
			fssGuaranteeModelDO.setAreaName(fssGuaranteeModel.getAreaName());
			fssGuaranteeModelDO.setStreet(fssGuaranteeModel.getStreet());

			fssGuaranteeModelDO.setRemark(fssGuaranteeModel.getRemark());
			fssGuaranteeModelDO.setContactor(fssGuaranteeModel.getContactor());
			fssGuaranteeModelDO.setPhone(fssGuaranteeModel.getPhone());
			fssGuaranteeModelDO.setMtime(new Date());
			
			//由前台进行验证动作 默认未验证
			fssGuaranteeModelDO.setVerifyStatus(FssGuaranteeVerifyStatusEnum.NO_AUTH.code());
			//fssGuaranteeModelDO.setVerifyTime(new Date());

			Integer resultInt = fssGuaranteeModelMapper
					.updateByPrimaryKey(fssGuaranteeModelDO);
			return resultInt;
		} catch (Exception e) {
			logger.error(String.format("修改担保机构信息异常：%s",
					ToStringBuilder.reflectionToString(fssGuaranteeModel)), e);
			throw new FssLoanBizException(ResultCodeContants.failed, "修改担保机构信息异常", e);
		}
	}

	@Override
	public FssGuaranteeModel getFssGuaranteeById(Long fssGuaranteeId) {
		try {
			FssGuaranteeModel fssGuaranteeModel = fssGuaranteeModelMapper
					.selectByPrimaryKey(fssGuaranteeId);
			return fssGuaranteeModel;
		} catch (Exception e) {
			logger.error(String.format("查询单个担保机构信息异常：%d", fssGuaranteeId), e);
			throw new FssLoanBizException(ResultCodeContants.failed, "查询单个担保机构信息异常", e);
		}
	}

	@Override
	public PaginatedResult<FssGuaranteeModel> getPaginatedResult(
			Paginator<FssGuaranteeModel> paginator) {
		try {
			HashMap<String, Object> param = new HashMap<String, Object>();
			param.put("_limit", paginator.getPageSize());
			param.put("_offset", (paginator.getCurrentPage()-1)*paginator.getPageSize());
			BeanUtilsExt.copyPropertiesToMap(paginator.getParam(), param);

			List<FssGuaranteeModel> list = this.fssGuaranteeModelMapper
					.getFssGuaranteePaging(param);
			Integer count = fssGuaranteeModelMapper
					.getFssGuaranteePagingCount(param);
			PaginatedResult<FssGuaranteeModel> paginatedResult = new PaginatedResult<FssGuaranteeModel>();
			paginatedResult.setRows(list);
			paginatedResult.setTotal(count);
			return paginatedResult;
		} catch (Exception e) {
			logger.error(
					String.format("分页查询担保机构异常：%s",
							ToStringBuilder.reflectionToString(paginator)), e);
			throw new FssLoanBizException(ResultCodeContants.failed, "系统错误", e);
		}
	}

}
