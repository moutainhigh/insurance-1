package com.yundian.basic.service.impl;

import com.yundian.fss.dao.ISysConfigDao;
import com.yundian.basic.domain.SysConfigModel;
import com.yundian.basic.service.SysConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* 
*/
@Service
public class SysConfigServiceImpl implements SysConfigService {
	@Autowired
	ISysConfigDao service;

 

	@Override
	public List<SysConfigModel> getList() {
		return service.getList();
	}

	@Override
	public SysConfigModel getModel(int id) {
		return service.getModel(id);
	}
	
	@Override
	public SysConfigModel getModel(String nid) {
		return service.getModelByNid(nid);
	}

 
 
}
