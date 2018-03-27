//package com.yundian.fss.service.impl;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import java.util.Map;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//import org.springframework.util.StringUtils;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONArray;
//import com.alibaba.fastjson.JSONObject;
//import com.cheguo.credit.model.TongdunResult;
//import com.cheguo.credit.model.TongdunResultReport;
//import com.cheguo.credit.model.TongdunResultReportDetail;
//import com.cheguo.credit.service.IPreLoanService;
//import com.yundian.fssapi.domain.FssCreditRiskDetailModel;
//import com.yundian.fssapi.domain.FssCreditRiskModel;
//import com.yundian.fssapi.service.FssTundunRiskService;
//import com.yundian.result.Result;
//import com.yundian.result.ResultCodeContants;
//
//@Service("fssTundunRiskService")
//public class FssTundunRiskServiceImpl implements FssTundunRiskService {
//	private static final Logger logger = LoggerFactory
//			.getLogger(FssFaceMatchingServiceImpl.class);
//
//	@Value("${dubbo.creditRisk.open}")
//	private String isCreditRiskOpen;
//
//	/**
//	 * 风险信息接口
//	 */
//	@Autowired
//	private IPreLoanService preLoanService;
//
//	@Override
//	public Result<String> apply(String name, String id_number, String mobile) {
//
//		Result<String> result = new Result<String>();
//		if(!isCreditRiskOpen.equals("true"))
//		{
//			logger.info(String.format("同盾风险信息查询接口关闭:%s", name+id_number));
//			result.setCode(ResultCodeContants.failed);
//			result.setMessage(String.format("同盾风险信息查询接口关闭:%s", name+id_number));
//			return result;
//		}
//		TongdunResult  tongdunResult =preLoanService.apply(name, id_number, mobile);
//		result.setCode(tongdunResult.getSuccess().equals("true")?ResultCodeContants.success:ResultCodeContants.failed);
//		result.setMessage(tongdunResult.getReason_code()+tongdunResult.getReason_desc());
//		result.setData(tongdunResult.getReport_id());
//		return result;
//	}
//
//	@Override
//	public Result<FssCreditRiskModel> report(String reportid) {
//
//		Result<FssCreditRiskModel> result = new Result<FssCreditRiskModel>();
//		if(StringUtils.isEmpty(reportid))
//		{
//			result.setCode(ResultCodeContants.failed);
//			result.setMessage("同盾风险信息查询接口reportid不能为空");
//			return result;
//		}
//		if(!isCreditRiskOpen.equals("true"))
//		{
//			logger.info(String.format("同盾风险信息查询接口关闭:%s", reportid));
//			result.setCode(ResultCodeContants.failed);
//			result.setMessage(String.format("同盾风险信息查询接口关闭:%s", reportid));
//			return result;
//		}
//
//		 TongdunResultReport  tondunReport = preLoanService.report(reportid);
//		 result.setCode(tondunReport.getSuccess().equals("true")?ResultCodeContants.success:ResultCodeContants.failed);
//
//		 if(tondunReport.getSuccess().equals("true"))
//		 {
//			 FssCreditRiskModel fssCreditRiskModel = new FssCreditRiskModel();
//			 fssCreditRiskModel.setRiskDecision(tondunReport.getFinal_decision());
//			 fssCreditRiskModel.setRistAbstract(tondunReport.getRist_abstract());
//			 fssCreditRiskModel.setRemark(tondunReport.getReport_id());
//			 List<FssCreditRiskDetailModel> creditRiskDetailList = new ArrayList<FssCreditRiskDetailModel>();
//			 for(TongdunResultReportDetail detail :tondunReport.getRisk_items())
//			 {
//				 FssCreditRiskDetailModel fssCreditRiskDetailModel = new FssCreditRiskDetailModel();
//				 fssCreditRiskDetailModel.setItemName(detail.getItem_name());
//				 fssCreditRiskDetailModel.setItemDetail(getCreditDetail(detail));
//				 creditRiskDetailList.add(fssCreditRiskDetailModel);
//			 }
//			 fssCreditRiskModel.setCreditRiskDetailList(creditRiskDetailList);
//			 result.setData(fssCreditRiskModel);
//		 }else
//			 result.setMessage(tondunReport.getReason_code()+tondunReport.getReason_desc());
//		return result;
//	}
//
//	@Override
//	public Result<FssCreditRiskModel> getReport(String name, String id_number,
//			String mobile) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	private String getCreditDetail(TongdunResultReportDetail detail)
//	{
//
//		 String result="";
//			JSONObject o = JSON.parseObject(detail.getItem_detail().toString()) ;
//
//			if(detail.getItem_name().equals("6个月内申请人在多个平台申请借款")||
//					detail.getItem_name().equals("1个月内申请人在多个平台申请借款")||
//					detail.getItem_name().equals("3个月内申请人在多个平台申请借款"))
//			{
//				JSONArray array = o.getJSONArray("platform_detail");
//				result =getJoinJSONArray(array);
//			}
//			else if(detail.getItem_name().equals("身份证命中信贷逾期名单"))//身份证命中网贷黑名单改成：身份证命中信贷逾期名单
//			{
//				JSONArray array = o.getJSONArray("overdue_details");
//				String joinStr="";
//				for(int i=0;i<array.size();i++)
//				{
//					JSONObject overdueJson = array.getJSONObject(i);
//
//					joinStr+=" 逾期次数："+overdueJson.getString("overdue_count");
//					joinStr+=" 逾期天数："+overdueJson.getString("overdue_day");
//					joinStr+=" 逾期金额："+overdueJson.getString("overdue_amount");
//					joinStr+="|";
//				}
//
//				result =joinStr;
//			}
//			else if(detail.getItem_name().equals("身份证命中失联名单"))
//			{
//				result ="失联";
//			}
//			else if(detail.getItem_name().equals("身份证命中高风险关注名单"))//身份证命中同盾欺诈高级灰名单改：身份证命中高风险关注名单
//			{
//				result =o.getString("fraud_type");
//			}
//			else if(detail.getItem_name().equals("身份证归属地位于高风险较为集中地区"))
//			{
//				result =getJoinJSONArray(o.getJSONArray("high_risk_areas"));
//			}
//
//			else if(detail.getItem_name().equals("身份证命中法院失信名单"))
//			{
//				result =getJoinJSONArray(o.getJSONArray("court_details"));
//			}
//			else if(detail.getItem_name().equals("身份证命中法院执行名单"))
//			{
//				result =getJoinJSONArray(o.getJSONArray("court_details"));
//			}else
//			{
//				result =getJoinJSONArray(o.getJSONArray("item_detail"));
//			}
//
//			return result;
//	}
//	/**
//	 * json数组串联成字符串
//	 * @param array
//	 * @return
//	 */
//	private   String getJoinJSONArray(JSONArray array)
//	{
//		if(array==null)
//			return "";
//		String joinStr ="";
//		for(Object s:array.toArray())
//		{
//			if(s instanceof JSONObject)
//			{
//				 for (Map.Entry<String, Object> entry : ((JSONObject) s).entrySet()) {
//			            joinStr+="||"+entry.getValue();
//			        }
//
//			}else
//			{
//			 joinStr+="||"+s.toString();
//			}
//		}
//		return joinStr;
//	}
//}
