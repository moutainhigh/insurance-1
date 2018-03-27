package com.yundian.fss.manager.impl;

import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.yundian.fss.dao.FssSysAreaModelMapper;
import com.yundian.fss.exception.FssLoanBizException;
import com.yundian.fss.manager.FssSysAreaManager;
import com.yundian.fssapi.domain.FssSysAreaModel;
import com.yundian.result.PaginatedResult;
import com.yundian.result.Paginator;
import com.yundian.result.ResultCodeContants;

/**
 * 系统地区服务实现
 * 
 * @author hehaibo
 * @version $Id: FssSysAreaManagerImpl.java, v 0.1 2016年7月26日 下午8:59:44 hehaibo Exp $
 */
@Transactional
public class FssSysAreaManagerImpl implements FssSysAreaManager{
	private static final Logger logger=LoggerFactory.getLogger(FssSysAreaManagerImpl.class);

	@Autowired
	private FssSysAreaModelMapper  fssSysAreaModelMapper;
	
	public Integer insertFssSysArea (FssSysAreaModel fssSysAreaModel){
		try {
			Integer row= this.fssSysAreaModelMapper.insert(fssSysAreaModel);
			return row;
		} catch (Exception e) {
			logger.error(String.format("添加系统地区异常:%s",
					ToStringBuilder.reflectionToString(fssSysAreaModel)),e);
			throw new FssLoanBizException(ResultCodeContants.failed,"",e);
		}
	}
	
	public Integer updateFssSysArea(FssSysAreaModel fssSysAreaModel){
		try {
			Integer row= this.fssSysAreaModelMapper.insert(fssSysAreaModel);
			return row;
		} catch (Exception e) {
			logger.error(String.format("修改系统地区异常:%s",
					ToStringBuilder.reflectionToString(fssSysAreaModel)),e);
			throw new FssLoanBizException(ResultCodeContants.failed,"",e);
		}
	}

			
	public Integer deleteFssSysAreaById ( Long id )
	{
		try {
			Integer row= this.fssSysAreaModelMapper.deleteByPrimaryKey(id);
			return row;
		} catch (Exception e) {
			logger.error(String.format("删除系统地区异常:%d",id),e);
			throw new FssLoanBizException(ResultCodeContants.failed,"",e);
		}
	}
																														
	public FssSysAreaModel getFssSysAreaById(Long id){
		try {
			FssSysAreaModel row= this.fssSysAreaModelMapper.selectByPrimaryKey(id);
			return row;
		} catch (Exception e) {
			logger.error(String.format("查询单个系统地区异常:%d",id),e);
			throw new FssLoanBizException(ResultCodeContants.failed,"",e);
		}
	}

	public List<FssSysAreaModel> getFssSysAreaList(FssSysAreaModel fssSysAreaModel){
		try {
			List<FssSysAreaModel> row= null;//TODO
			return row;
		} catch (Exception e) {
			logger.error(String.format("查询列表系统地区异常:%s",
					ToStringBuilder.reflectionToString(fssSysAreaModel)),e);
			throw new FssLoanBizException(ResultCodeContants.failed,"",e);
		}
	}
	

	public PaginatedResult<FssSysAreaModel> getPaginatorFssSysArea(
            Paginator<FssSysAreaModel> paginator){
		try {
			PaginatedResult<FssSysAreaModel> data= null;//TODO
			return data;
		} catch (Exception e) {
			logger.error(String.format("分页查询系统地区异常:%s",
					ToStringBuilder.reflectionToString(paginator)),e);
			throw new FssLoanBizException(ResultCodeContants.failed,"",e);
		}
    }

}
