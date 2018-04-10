package com.yundian.fss.service.impl;

import com.yundian.fss.dao.FssCodeLibraryModelMapper;
import com.yundian.fssapi.domain.FssCodeLibraryModel;
import com.yundian.fssapi.service.FssCodeLibraryService;
import com.yundian.result.PaginatedResult;
import com.yundian.result.Paginator;
import com.yundian.result.Result;
import com.yundian.result.ResultCodeContants;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 代码配置字典项表
 * 
 *
 * */
@Service("fssCodeLibraryService")
public class FssCodeLibraryServiceImpl implements FssCodeLibraryService{
	private static final Logger logger =LoggerFactory.getLogger(FssCodeLibraryServiceImpl.class);
	@Autowired
	private FssCodeLibraryModelMapper  fssCodeLibraryModelMapper;

	@Override
	public Result<Integer> insertFssCodeLibrary (FssCodeLibraryModel fssCodeLibraryModel){
		
		Result<Integer> result = new Result<Integer>();
		try {
			Integer row= this.fssCodeLibraryModelMapper.insert(fssCodeLibraryModel);
			result.setData(row);
			result.setCode(ResultCodeContants.SUCCESS);
		} catch (Exception e) {
			logger.error(String.format("添加代码配置字典项异常:%s",
					ToStringBuilder.reflectionToString(fssCodeLibraryModel)),e);
			result.setCode(ResultCodeContants.FAILED);
		}
		return result;
		
	}
	@Override
	public Result<Integer> updateFssCodeLibrary(FssCodeLibraryModel fssCodeLibraryModel){
		Result<Integer> result = new Result<Integer>();
		try {
			Integer row= this.fssCodeLibraryModelMapper.updateByPrimaryKey(fssCodeLibraryModel);
			result.setData(row);
			result.setCode(ResultCodeContants.SUCCESS);
		} catch (Exception e) {
			logger.error(String.format("修改代码配置字典项异常:%s",
					ToStringBuilder.reflectionToString(fssCodeLibraryModel)),e);
			result.setCode(ResultCodeContants.FAILED);
		}
		return result;
	}

	@Override
	public Result<Integer> deleteFssCodeLibraryById ( Integer id )
	{
		Result<Integer> result = new Result<Integer>();
		try {
			Integer row= this.fssCodeLibraryModelMapper.deleteByPrimaryKey(id);
			result.setData(row);
			result.setCode(ResultCodeContants.SUCCESS);
		} catch (Exception e) {
			logger.error(String.format("删除代码配置字典项异常:%s",
					id),e);
			result.setCode(ResultCodeContants.FAILED);
		}
		return result;
	}
	@Override
	public Result<FssCodeLibraryModel> getFssCodeLibraryById(Integer id){
		Result<FssCodeLibraryModel> result = new Result<FssCodeLibraryModel>();
		try {
			FssCodeLibraryModel row= this.fssCodeLibraryModelMapper.selectByPrimaryKey(id);
			result.setData(row);
			result.setCode(ResultCodeContants.SUCCESS);
		} catch (Exception e) {
			logger.error(String.format("删除代码配置字典项异常:%s",
					id),e);
			result.setCode(ResultCodeContants.FAILED);
		}
		return result;
		
	}
	@Override
	public Result<List<FssCodeLibraryModel>> getFssCodeLibraryList(FssCodeLibraryModel fssCodeLibraryModel){
		Result<List<FssCodeLibraryModel>> result = new Result<List<FssCodeLibraryModel>>();
		try {
			List<FssCodeLibraryModel> data =fssCodeLibraryModelMapper.getCodes(fssCodeLibraryModel.getCodeType());
			result.setData(data);
			result.setCode(ResultCodeContants.SUCCESS);
		} catch (Exception e) {
			logger.error(String.format("查询列表代码配置字典项异常:%s",
					ToStringBuilder.reflectionToString(fssCodeLibraryModel)),e);
			result.setCode(ResultCodeContants.FAILED);
		}
		return result;
	}

	@Override
	public Result<PaginatedResult<FssCodeLibraryModel>> getPaginatorFssCodeLibrary(
            Paginator<FssCodeLibraryModel> paginator){
		Result<PaginatedResult<FssCodeLibraryModel>> result = new Result<PaginatedResult<FssCodeLibraryModel>>();
		try {
			PaginatedResult<FssCodeLibraryModel> data =null;//TODO
			result.setData(data);
			result.setCode(ResultCodeContants.SUCCESS);
		} catch (Exception e) {
			logger.error(String.format("分页查询列表代码配置字典项异常:%s",
					ToStringBuilder.reflectionToString(paginator)),e);
			result.setCode(ResultCodeContants.FAILED);
		}
		return result;
    }

}
