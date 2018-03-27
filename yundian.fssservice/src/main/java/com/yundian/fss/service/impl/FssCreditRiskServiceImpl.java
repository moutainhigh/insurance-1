//package com.yundian.fss.service.impl;
//
//
//import java.util.Date;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.util.StringUtils;
//
//import com.cheguo.credit.model.TongdunResultReport;
//import com.cheguo.credit.model.TongdunResultReportDetail;
//import com.yundian.fss.exception.FssLoanBizException;
//import com.yundian.fss.manager.FssCreditMananger;
//import com.yundian.fss.manager.FssCreditRiskDetailMananger;
//import com.yundian.fss.manager.FssCreditRiskMananger;
//import com.yundian.fssapi.domain.FssCreditModel;
//import com.yundian.fssapi.domain.FssCreditRiskDetailModel;
//import com.yundian.fssapi.domain.FssCreditRiskModel;
//import com.yundian.fssapi.service.FssCreditRiskService;
//import com.yundian.fssapi.service.FssTundunRiskService;
//import com.yundian.result.PaginatedResult;
//import com.yundian.result.Paginator;
//import com.yundian.result.Result;
//import com.yundian.result.ResultCodeContants;
//
///**
// * 征信风险信息服务实现
// *
// * @author haibo.he
// * @version $Id: FssCreditRiskServiceImpl.java, v 0.1 2016年7月26日 下午8:59:44
// *          haibo.he Exp $
// */
//@Service("fssCreditRiskService")
//public class FssCreditRiskServiceImpl implements FssCreditRiskService {
//
//	@Autowired
//	private FssCreditRiskMananger fssCreditRiskMananger;
//	@Autowired
//	private FssCreditRiskDetailMananger fssCreditRiskDetailMananger;
//
//	@Autowired
//	private FssCreditMananger fssCreditMananger;
//
//	/**
//	 * 风险信息接口
//	 */
//	@Autowired
//	private FssTundunRiskService fssTundunRiskService;
//
//	public Result<Long> insertFssCreditRisk(
//			FssCreditRiskModel fssCreditRiskModel) {
//		Result<Long> result = new Result<Long>();
//		try {
//			Long data = this.fssCreditRiskMananger
//					.insertFssCreditRisk(fssCreditRiskModel);
//			result.setData(data);
//		} catch (Exception e) {
//			if (e instanceof FssLoanBizException) {
//				FssLoanBizException be = (FssLoanBizException) e;
//				result.setCode(be.getCode());
//				result.setMessage(be.getErrorMsg());
//			} else {
//				result.setCode(ResultCodeContants.failed);
//				result.setMessage("系统异常");
//			}
//		}
//		return result;
//	}
//
//	public Result<Integer> updateFssCreditRisk(
//			FssCreditRiskModel fssCreditRiskModel) {
//		Result<Integer> result = new Result<Integer>();
//
//		try {
//			Integer data = this.fssCreditRiskMananger
//					.updateFssCreditRisk(fssCreditRiskModel);
//			result.setData(data);
//		} catch (Exception e) {
//			if (e instanceof FssLoanBizException) {
//				FssLoanBizException be = (FssLoanBizException) e;
//				result.setCode(be.getCode());
//				result.setMessage(be.getErrorMsg());
//			} else {
//				result.setCode(ResultCodeContants.failed);
//				result.setMessage("系统异常");
//			}
//		}
//		return result;
//	}
//
//	public Result<Integer> deleteFssCreditRiskByRiskId(Long riskId) {
//		return null;
//	}
//
//	public Result<FssCreditRiskModel> getFssCreditRiskById(Long id) {
//		Result<FssCreditRiskModel> result = new Result<FssCreditRiskModel>();
//
//		try {
//			FssCreditRiskModel data = this.fssCreditRiskMananger
//					.getFssCreditRiskById(id);
//			result.setData(data);
//		} catch (Exception e) {
//			if (e instanceof FssLoanBizException) {
//				FssLoanBizException be = (FssLoanBizException) e;
//				result.setCode(be.getCode());
//				result.setMessage(be.getErrorMsg());
//			} else {
//				result.setCode(ResultCodeContants.failed);
//				result.setMessage("系统异常");
//			}
//		}
//
//		return result;
//
//	}
//
//	public Result<List<FssCreditRiskModel>> getFssCreditRiskList(
//			FssCreditRiskModel fssCreditRiskModel) {
//		Result<List<FssCreditRiskModel>> result = new Result<List<FssCreditRiskModel>>();
//
//		try {
//			List<FssCreditRiskModel> data = this.fssCreditRiskMananger
//					.getFssCreditRiskList(fssCreditRiskModel);
//			result.setData(data);
//		} catch (Exception e) {
//			if (e instanceof FssLoanBizException) {
//				FssLoanBizException be = (FssLoanBizException) e;
//				result.setCode(be.getCode());
//				result.setMessage(be.getErrorMsg());
//			} else {
//				result.setCode(ResultCodeContants.failed);
//				result.setMessage("系统异常");
//			}
//		}
//		return result;
//	}
//
//
//
//	/* (non-Javadoc)
//	 * @see com.yundian.fssapi.service.FssCreditRiskService#getFssCreditRiskAndDetailByCreditId(java.lang.Long)
//	 */
//	@Override
//	public Result<FssCreditRiskModel> getFssCreditRiskAndDetailByCreditId(
//			Long creditId) {
//		Result<FssCreditRiskModel> result = new Result<FssCreditRiskModel>();
//
//		try {
//			FssCreditRiskModel data = this.fssCreditRiskMananger
//					.getFssCreditRiskAndDetailByCreditId(creditId);
//			if(data==null)
//			{
//				FssCreditModel  fssCreditModel = fssCreditMananger.getFssCreditAndCreditLogById(creditId);
//				Result<FssCreditRiskModel>  fssCreditRiskModelResult= fssTundunRiskService.report(fssCreditModel.getRemark());
//					if(fssCreditRiskModelResult.getCode()==ResultCodeContants.success)
//					 {
//					 	FssCreditRiskModel fssCreditRiskModel = fssCreditRiskModelResult.getData();
//						 fssCreditRiskModel.setCreditId(creditId);
//						 fssCreditRiskModel.setIdcard(fssCreditModel.getIdcard());
//						 fssCreditRiskModel.setName(fssCreditModel.getName());
//						 fssCreditRiskModel.setMobile(fssCreditModel.getPhone());
//						 fssCreditRiskModel.setCtime(new Date());
//						 Long riskId =this.fssCreditRiskMananger
//									.insertFssCreditRisk(fssCreditRiskModel);
//
//							 for(FssCreditRiskDetailModel detail :fssCreditRiskModel.getCreditRiskDetailList())
//							 {
//
//								 detail.setRiskId(riskId);
//								 fssCreditRiskDetailMananger.insertFssCreditRiskDetail(detail);
//							 }
//						 }
//					 	return fssCreditRiskModelResult;
//
//				 }else
//				 {
//					 result.setData(data);
//				 }
//
//		} catch (Exception e) {
//			if (e instanceof FssLoanBizException) {
//				FssLoanBizException be = (FssLoanBizException) e;
//				result.setCode(be.getCode());
//				result.setMessage(be.getErrorMsg());
//			} else {
//				result.setCode(ResultCodeContants.failed);
//				result.setMessage("系统异常");
//			}
//		}
//		return result;
//	}
//
//	public Result<PaginatedResult<FssCreditRiskModel>> getPaginatorFssCreditRisk(
//			Paginator<FssCreditRiskModel> paginator) {
//		Result<PaginatedResult<FssCreditRiskModel>> result = new Result<PaginatedResult<FssCreditRiskModel>>();
//
//		try {
//			PaginatedResult<FssCreditRiskModel> data = this.fssCreditRiskMananger
//					.getPaginatorFssCreditRisk(paginator);
//			result.setData(data);
//		} catch (Exception e) {
//			if (e instanceof FssLoanBizException) {
//				FssLoanBizException be = (FssLoanBizException) e;
//				result.setCode(be.getCode());
//				result.setMessage(be.getErrorMsg());
//			} else {
//				result.setCode(ResultCodeContants.failed);
//				result.setMessage("系统异常");
//			}
//		}
//		return result;
//	}
//
//
//}
