package com.yundian.fssapi.service;

import java.util.List;

import com.yundian.fssapi.domain.FssBankModel;
import com.yundian.result.PaginatedResult;
import com.yundian.result.Paginator;
import com.yundian.result.Result;

/**
 * 银行服务
 * 
 * @author hehaibo
 * @version $Id: FssBankService.java, v 0.1 2016年7月26日 下午8:59:44 hehaibo Exp $
 */
public interface FssBankService {
	Result<Integer> insertFssBank (FssBankModel fssBankModel);
	
	Result<Integer> updateFssBankByBankId(FssBankModel fssBankModel);
			
	Result<Integer> deleteFssBankByBankId ( Integer bankId );
																														
	Result<FssBankModel> getFssBankById(Integer id);

	Result<List<FssBankModel>> getFssBankList(FssBankModel fssBankModel);
	
	Result<PaginatedResult<FssBankModel>> getPaginatorFssBank(
            Paginator<FssBankModel> paginator);
}
