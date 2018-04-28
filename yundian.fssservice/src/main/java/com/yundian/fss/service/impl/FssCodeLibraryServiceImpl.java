package com.yundian.fss.service.impl;

import com.yundian.fss.dao.FssCodeLibraryModelMapper;
import com.yundian.fssapi.domain.FssCodeLibraryModel;
import com.yundian.fssapi.service.FssCodeLibraryService;
import com.yundian.result.PaginatedResult;
import com.yundian.result.Paginator;
import com.yundian.result.Result;
import com.yundian.result.ResultCodeContants;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@Service("fssCodeLibraryService")
public class FssCodeLibraryServiceImpl implements FssCodeLibraryService{

	@Autowired
	private FssCodeLibraryModelMapper  fssCodeLibraryModelMapper;

	@Override
	public FssCodeLibraryModel getFssCodeLibraryByCode(String codeType, String code) {
		try {
			FssCodeLibraryModel row= fssCodeLibraryModelMapper.selectByCode(codeType, code);
			return row;
		} catch (Exception e) {
			log.error(String.format("查询代码配置字典项异常:%s",
					codeType+code),e);
		}
		return null;
	}

	@Override
	public List<FssCodeLibraryModel> getFssCodeLibraryListByType(String codeType) {
		try {
			return  fssCodeLibraryModelMapper.getCodes(codeType);
		} catch (Exception e) {
			log.error(String.format("查询列表代码配置字典项异常:%s",
					ToStringBuilder.reflectionToString(codeType)),e);
		}
		return null;
	}
}
