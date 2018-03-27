package com.yundian.fssapi.service;

import com.yundian.fssapi.domain.FssCreditRiskModel;
import com.yundian.result.Result;

/**
 * 同盾个人风险查询
 * @author ningxia.jin
 *
 */
public interface FssTundunRiskService {

	/**
	 * 申请件提交
	 * @param name 姓名
	 * @param id_number 身份证
	 * @param mobile 手机号码
	 */
	public Result<String> apply(String name,String id_number,String mobile);
	
	/**
	 * 报告查询
	 * @param reportid 报告编号
	 */
	public Result<FssCreditRiskModel> report(String reportid);
	/**
	 * 数据库中读取报告
	 */
	public Result<FssCreditRiskModel> getReport(String name,String id_number, String mobile);
}
