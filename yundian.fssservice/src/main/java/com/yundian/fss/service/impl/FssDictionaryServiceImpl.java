package com.yundian.fss.service.impl;

import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.yundian.fss.manager.FssDictionaryManager;
import com.yundian.fssapi.domain.FssDictionaryModel;
import com.yundian.fssapi.service.FssDictionaryService;
import com.yundian.result.Result;
import com.yundian.result.ResultCodeContants;

public class FssDictionaryServiceImpl implements FssDictionaryService {
	private static final Logger logger = LoggerFactory
			.getLogger(FssDictionaryServiceImpl.class);
	@Autowired
	private FssDictionaryManager fssDictionaryManager;

	@Override
	public Result<FssDictionaryModel> getFssDictionaryById(Integer id) {
		Result<FssDictionaryModel> result = new Result<FssDictionaryModel>();
		try {
			FssDictionaryModel fssDictionaryModel = fssDictionaryManager
					.getFssDictionaryById(id);
			result.setData(fssDictionaryModel);
			result.setCode(ResultCodeContants.success);
		} catch (Exception e) {
			logger.error(String.format("获取单个数据字典信息异常:%d", id), e);
			result.setCode(ResultCodeContants.failed);
			result.setMessage("系统异常");
		}
		return result;
	}

	@Override
	public Result<FssDictionaryModel> getFssDictionaryByTypeAndItemCode(
			String dictTypeCode, String itemCode) {
		Result<FssDictionaryModel> result = new Result<FssDictionaryModel>();
		try {
			FssDictionaryModel fssDictionaryModel = fssDictionaryManager
					.getFssDictionaryByTypeAndItemCode(dictTypeCode, itemCode);
			result.setData(fssDictionaryModel);
			result.setCode(ResultCodeContants.success);
		} catch (Exception e) {
			logger.error(String.format(
					"获取单个数据字典信息异常:dictTypeCode=%s,itemCode=%s", dictTypeCode,
					itemCode), e);
			result.setCode(ResultCodeContants.failed);
			result.setMessage("系统异常");
		}
		return result;
	}

	@Override
	public Result<List<FssDictionaryModel>> getFssDictionaryList(
			FssDictionaryModel fssDictionaryModel) {
		Result<List<FssDictionaryModel>> result = new Result<List<FssDictionaryModel>>();
		try {
			List<FssDictionaryModel> fssDictionaryModels = fssDictionaryManager
					.getFssDictionaryList(fssDictionaryModel);
			result.setData(fssDictionaryModels);
			result.setCode(ResultCodeContants.success);
		} catch (Exception e) {
			logger.error(String.format("查询数据字典列表信息异常:%s",
					ToStringBuilder.reflectionToString(fssDictionaryModel)), e);
			result.setCode(ResultCodeContants.failed);
			result.setMessage("系统异常");
		}
		return result;
	}
}
