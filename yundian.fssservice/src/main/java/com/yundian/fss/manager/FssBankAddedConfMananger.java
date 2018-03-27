package com.yundian.fss.manager;

import com.yundian.fssapi.domain.FssBankAddedConfModel;

/**
 * 银行相关配置服务
 * 
 * @author haibo.he
 * @version $Id: FssBankAddedConfMananger.java, v 0.1 2016年7月26日 下午8:59:44
 *          haibo.he Exp $
 */
public interface FssBankAddedConfMananger {
	Long insertFssBankAddedConf(FssBankAddedConfModel fssBankAddedConfModel);

	Integer updateFssBankAddedConf(FssBankAddedConfModel fssBankAddedConfModel);

	Integer deleteFssBankAddedConfById(Long id);
	Integer deleteFssBankAddedConfByBankId(Long bankId);
	FssBankAddedConfModel getFssBankAddedConfById(Long id);

	FssBankAddedConfModel getFssBankAddedConfByBankId(Long bankId);

}
