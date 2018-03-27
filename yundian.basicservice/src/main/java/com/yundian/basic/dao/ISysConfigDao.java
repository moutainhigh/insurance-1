package com.yundian.basic.dao;

import java.util.List;

import com.yundian.basic.domain.SysConfigModel;

public interface ISysConfigDao {
	List<SysConfigModel> getList();

	SysConfigModel getModel(int id);
	
	SysConfigModel getModelByNid(String nid);
	
}