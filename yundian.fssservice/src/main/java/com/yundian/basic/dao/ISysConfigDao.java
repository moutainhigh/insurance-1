package com.yundian.basic.dao;

import com.yundian.basic.domain.SysConfigModel;

import java.util.List;

public interface ISysConfigDao {
	List<SysConfigModel> getList();

	SysConfigModel getModel(int id);
	
	SysConfigModel getModelByNid(String nid);
	
}