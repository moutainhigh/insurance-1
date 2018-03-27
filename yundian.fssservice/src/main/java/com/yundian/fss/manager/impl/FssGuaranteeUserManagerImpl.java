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

import com.yundian.fss.dao.FssGuaranteeUserModelMapper;
import com.yundian.fss.dao.FssUserModelMapper;
import com.yundian.fss.exception.FssLoanBizException;
import com.yundian.fss.manager.FssGuaranteeManager;
import com.yundian.fss.manager.FssGuaranteeUserManager;
import com.yundian.fssapi.domain.FssGuaranteeUserModel;
import com.yundian.fssapi.domain.FssUserModel;
import com.yundian.fssapi.domain.query.FssGuaranteeUserQueryModel;
import com.yundian.fssapi.domain.query.FssUserQueryModel;
import com.yundian.fssapi.dto.param.FssGuaranteeUserParam;
import com.yundian.fssapi.enums.FssGuaranteeUserRoleIdEnum;
import com.yundian.fssapi.enums.FssYesOrNoEnum;
import com.yundian.result.PaginatedResult;
import com.yundian.result.Paginator;
import com.yundian.result.ResultCodeContants;
import com.yundian.toolkit.utils.BeanUtilsExt;

@Transactional
public class FssGuaranteeUserManagerImpl implements FssGuaranteeUserManager {

	private static final Logger logger = LoggerFactory
			.getLogger(FssGuaranteeUserManagerImpl.class);
	@Autowired
	private FssUserModelMapper fssUserModelMapper;
	@Autowired
	private FssGuaranteeUserModelMapper fssGuaranteeUserModelMapper;
	@Autowired
	private FssGuaranteeManager fssGuaranteeManager;

	@Override
	public Long addGuaranteeUser(FssGuaranteeUserParam user) {
		try {
			// TODO 判断重复 和用户存在判断

			FssUserModel fssUserModel = new FssUserModel();
			fssUserModel.setName(user.getName());
			fssUserModel.setPhone(user.getPhone());
			fssUserModel.setRegisterTime(new Date());
			fssUserModel.setUserName(user.getUserName());
			fssUserModel.setUserPwd(user.getUserPwd());
			fssUserModel.setSex(user.getSex());

			fssUserModelMapper.insert(fssUserModel);

			FssGuaranteeUserModel fssGuaranteeUserModel = new FssGuaranteeUserModel();
			fssGuaranteeUserModel.setGuaranteeId(user.getGuaranteeId());
			fssGuaranteeUserModel
					.setIsDefaultGuarantee(FssYesOrNoEnum.Y.code());
			fssGuaranteeUserModel.setRegion(user.getRegion());
			fssGuaranteeUserModel.setRoleId(user.getRoleId());
			fssGuaranteeUserModel.setTel(user.getPhone());
			fssGuaranteeUserModel.setStation(user.getStation());
			fssGuaranteeUserModel.setUserId(fssUserModel.getUserId());
			fssGuaranteeUserModelMapper.insert(fssGuaranteeUserModel);

			return fssUserModel.getUserId();
		} catch (Exception e) {
			logger.error(
					String.format("新增担保机构用户异常：%s",
							ToStringBuilder.reflectionToString(user)), e);
			if (e instanceof FssLoanBizException) {
				throw e;
			} else {
				throw new FssLoanBizException(ResultCodeContants.failed,
						"新增担保机构用户", e);
			}
		}
	}

	@Override
	public Long initAddGuaranteeUser(FssGuaranteeUserParam user) {
		try {
			// 1 判断用户名是否存在

			// 2 判断担保机构是否已存在用户
			Integer userCount = this.fssGuaranteeUserModelMapper
					.getGuaranteeUserCountByGuaranteeId(user.getGuaranteeId());
			if (userCount > 0) {
				throw new FssLoanBizException(ResultCodeContants.failed,
						"已经初始化该机构的用户");
			}
			user.setRoleId(FssGuaranteeUserRoleIdEnum.ADMIN.code());
			return this.addGuaranteeUser(user);
		} catch (FssLoanBizException e) {
			throw e;
		} catch (Exception e) {
			throw new FssLoanBizException(ResultCodeContants.failed, "系统异常");
		}

	}

	
	@Override
	public Integer updateGuaranteeUser(FssGuaranteeUserParam user) {
		try {
			FssUserModel fssUserModel = new FssUserModel();
			fssUserModel.setUserId(user.getUserId());
			fssUserModel.setName(user.getName());
			fssUserModel.setPhone(user.getPhone());
			fssUserModel.setSex(user.getSex());

			int row1 = fssUserModelMapper.updateByPrimaryKey(fssUserModel);
			if(row1<1){
				throw new FssLoanBizException(ResultCodeContants.failed,
						"修改担保用户失败");
			}

			FssGuaranteeUserModel fssGuaranteeUserModel = new FssGuaranteeUserModel();
			fssGuaranteeUserModel.setGuaranteeId(user.getGuaranteeId());
			fssGuaranteeUserModel.setUserId(user.getUserId());
			fssGuaranteeUserModel
					.setIsDefaultGuarantee(FssYesOrNoEnum.Y.code());
			fssGuaranteeUserModel.setRegion(user.getRegion());
			fssGuaranteeUserModel.setRoleId(user.getRoleId());
			fssGuaranteeUserModel.setTel(user.getPhone());
			fssGuaranteeUserModel.setSex(user.getSex());
			fssGuaranteeUserModel.setName(user.getName());
			fssGuaranteeUserModel.setStation(user.getStation());
			int row2 = this.fssGuaranteeUserModelMapper.updateByPrimaryByUserIdAndGuaranteeId(fssGuaranteeUserModel);
			if(row2<1){
				throw new FssLoanBizException(ResultCodeContants.failed,
						"修改担保用户失败");
			}
			return 1;
		}catch (Exception e) {
			if (e instanceof FssLoanBizException) {
				throw e;
			} else {
				throw new FssLoanBizException(ResultCodeContants.failed,
						"修改担保用户失败", e);
			}
		}
	}

	@Override
	public FssUserModel guaranteeUserLogin(String userName, String userPwd) {
		try {
			FssUserModel fssUserModel = this.fssUserModelMapper
					.getFssGuaranteeUserByUserNameAndPwd(userName, userPwd);

			if (fssUserModel != null) {
				List<FssGuaranteeUserQueryModel> guaranteeUserList = this.fssGuaranteeUserModelMapper
						.getGuaranteeUserQueryListByUserId(fssUserModel
								.getUserId());
				fssUserModel.setGuaranteeUserQueryList(guaranteeUserList);
			} else {
				throw new FssLoanBizException(ResultCodeContants.failed,
						"登录失败,用户名或密码错误");
			}
			return fssUserModel;
		} catch (Exception e) {
			logger.error(String.format("担保机构用户登录异常：userName=%s", userName), e);
			if (e instanceof FssLoanBizException) {
				throw e;
			} else {
				throw new FssLoanBizException(ResultCodeContants.failed,
						"登录失败,用户名或密码错误", e);
			}
		}
	}

	@Override
	public FssUserModel getGuaranteeUserByFssUserId(Long fssUserId) {
		try {
			FssUserModel fssUserModel = this.fssUserModelMapper
					.selectByPrimaryKey(fssUserId);

			if (fssUserModel != null) {
				List<FssGuaranteeUserQueryModel> guaranteeUserList = this.fssGuaranteeUserModelMapper
						.getGuaranteeUserQueryListByUserId(fssUserModel
								.getUserId());
				fssUserModel.setGuaranteeUserQueryList(guaranteeUserList);
			} else {
				throw new FssLoanBizException(ResultCodeContants.failed,
						"用户不存在");
			}
			return fssUserModel;
		} catch (Exception e) {
			logger.error(String.format("查询担保用户信息异常：fssUserId=%d", fssUserId), e);
			if (e instanceof FssLoanBizException) {
				throw e;
			} else {
				throw new FssLoanBizException(ResultCodeContants.failed,
						"用户不存在", e);
			}
		}
	}

	@Override
	public PaginatedResult<FssUserQueryModel> getPaginatedResult(
			Paginator<FssUserQueryModel> paginator) {
		try {

			HashMap<String, Object> param = new HashMap<String, Object>();
			param.put("_limit", paginator.getPageSize());
			param.put("_offset",
					(paginator.getCurrentPage() - 1) * paginator.getPageSize());
			if (paginator.getParam() == null) {
				paginator.setParam(new FssUserQueryModel());
			}
			FssUserQueryModel fssUserQueryParam= paginator.getParam();

			// 分页列表只查询默认 默认的担保机构只有一个
			if(fssUserQueryParam.getGuaranteeId()==null && 
					StringUtils.isEmpty(fssUserQueryParam.getIsDefaultGuarantee())){
				fssUserQueryParam.setIsDefaultGuarantee(FssYesOrNoEnum.Y.code());
			}
			BeanUtilsExt.copyPropertiesToMap(fssUserQueryParam, param);

			List<FssUserQueryModel> list = this.fssUserModelMapper
					.getFssUserPaging(param);
			Integer count = fssUserModelMapper.getFssUserPagingCount(param);
			PaginatedResult<FssUserQueryModel> paginatedResult = new PaginatedResult<FssUserQueryModel>();
			paginatedResult.setRows(list);
			paginatedResult.setTotal(count);
			return paginatedResult;
		} catch (Exception e) {
			logger.error(
					String.format("分页查询担保机构用户异常：%s",
							ToStringBuilder.reflectionToString(paginator)), e);
			throw new FssLoanBizException(ResultCodeContants.failed,
					"查询担保机构用户异常", e);
		}
	}

	@Override
	public Integer updateGuaranteeUserPwd(Long userId, String oldPwd,
			String newPwd) {
		try {
			FssUserModel fssUserModel= this.fssUserModelMapper.selectByPrimaryKey(userId);
			if(!StringUtils.equals(fssUserModel.getUserPwd(), oldPwd)){
				throw new FssLoanBizException(ResultCodeContants.failed, "原密码错误");
			}
			fssUserModel.setUserPwd(newPwd);
			return this.fssUserModelMapper.updateGuaranteeUserPwd(fssUserModel);
		} catch (Exception e) {
			if(e instanceof FssLoanBizException){
				throw e;
			}
			else {
				throw new FssLoanBizException(ResultCodeContants.failed,
						"系统异常", e);	
			}
		}
	}
	
	

}
