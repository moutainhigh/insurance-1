package com.yundian.fssapi.service;

import com.yundian.fssapi.domain.FssBankAddedConfModel;
import com.yundian.result.Result;

/**
 * 银行相关配置服务
 * 
 * @author haibo.he
 * @version $Id: FssBankAddedConfService.java, v 0.1 2016年7月26日 下午8:59:44
 *          haibo.he Exp $
 */
public interface FssBankAddedConfService {
	Result<Long> insertFssBankAddedConf(
			FssBankAddedConfModel fssBankAddedConfModel);

	Result<Integer> updateFssBankAddedConf(
			FssBankAddedConfModel fssBankAddedConfModel);

	Result<Integer> deleteFssBankAddedConfById(Long id);
	Result<Integer> deleteFssBankAddedConfByBankId(Long bankId);
	Result<FssBankAddedConfModel> getFssBankAddedConfByBankId(Long bankId);

	Result<FssBankAddedConfModel> getFssBankAddedConfById(Long id);

}
