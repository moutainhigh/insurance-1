package com.yundian.basic.service;

import java.util.List;

import com.yundian.basic.domain.SysConfigModel;

/**
* 
*/

public interface SysConfigService {
	
	List<SysConfigModel> getList();

	SysConfigModel getModel(int id);
	
	SysConfigModel getModel(String nid);

 
 

}
