package com.yundian.fss.manager.impl;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.yundian.fss.dao.FssGuaranteeModelMapper;
import com.yundian.fss.dao.FssLoanModelMapper;
import com.yundian.fss.dao.FssOrganizationUserModelMapper;
import com.yundian.fss.exception.FssLoanBizException;
import com.yundian.fss.manager.FssBankManager;
import com.yundian.fss.manager.FssGuaranteeUserManager;
import com.yundian.fss.manager.FssLoanAuditingLogManager;
import com.yundian.fss.manager.FssLoanManager;
import com.yundian.fss.manager.assignrule.FssLoanBankAssignRule;
import com.yundian.fss.manager.impl.support.CommonFssManagerSupportImpl;
import com.yundian.fssapi.domain.FssGuaranteeModel;
import com.yundian.fssapi.domain.FssLoanAuditingLogModel;
import com.yundian.fssapi.domain.FssLoanDocumentModel;
import com.yundian.fssapi.domain.FssLoanModel;
import com.yundian.fssapi.domain.FssLoanRelationModel;
import com.yundian.fssapi.domain.FssOrganizationUserModel;
import com.yundian.fssapi.domain.FssUserModel;
import com.yundian.fssapi.domain.query.FssLoanAuditingLogQueryModel;
import com.yundian.fssapi.domain.query.FssLoanQueryModel;
import com.yundian.fssapi.domain.statistics.LoanCompareStatModel;
import com.yundian.fssapi.domain.statistics.LoanTypeMonthTrendSeriesModel;
import com.yundian.fssapi.domain.statistics.LoanTypeMonthTrendStatModel;
import com.yundian.fssapi.domain.statistics.LoanTypeStatItemModel;
import com.yundian.fssapi.dto.FssLoanAuditStatusStatistics;
import com.yundian.fssapi.dto.FssLoanAuditStatusStatisticsResult;
import com.yundian.fssapi.dto.param.FssLoanQueryParam;
import com.yundian.fssapi.enums.FssLoanAuditStatusEnum;
import com.yundian.fssapi.enums.FssLoanLoanTypeEnum;
import com.yundian.fssapi.enums.FssLoanRelationRelationTypeEnum;
import com.yundian.fssapi.enums.FssYesOrNoEnum;
import com.yundian.fssapi.exception.FssLoanStatusTransformException;
import com.yundian.fssapi.service.FssLoanStatusTransformAdaptor;
import com.yundian.result.PaginatedResult;
import com.yundian.result.Paginator;
import com.yundian.result.Result;
import com.yundian.result.ResultCodeContants;
import com.yundian.toolkit.utils.BeanUtilsExt;
import com.yundian.toolkit.utils.DateUtils;

/**
 * 贷款服务实现
 * 
 * @author hehaibo
 * @version $Id: FssLoanManagerImpl.java, v 0.1 2016年7月26日 下午8:59:44 hehaibo Exp
 *          $
 */
@Transactional
public class FssLoanManagerImpl extends CommonFssManagerSupportImpl implements
		FssLoanManager {
	private static final Logger logger = LoggerFactory
			.getLogger(FssLoanManagerImpl.class);

	@Autowired
	private FssLoanModelMapper fssLoanModelMapper;

	@Autowired
	private FssBankManager fssBankManager;
	@Autowired
	private FssOrganizationUserModelMapper fssOrganizationUserModelMapper;
	@Autowired
	private FssGuaranteeModelMapper fssGuaranteeModelMapper;
	@Autowired
	private FssLoanAuditingLogManager fssLoanAuditingLogManager;

	@Autowired
	private FssGuaranteeUserManager fssGuaranteeUserManager;

	@Autowired
	@Qualifier("loanStatusTransformChannelAdaptor")
	private FssLoanStatusTransformAdaptor<FssUserModel> loanStatusTransformChannelAdaptor;

	@Autowired
	@Qualifier("fssLoanBankOneBankAssignRule")
	private FssLoanBankAssignRule fssLoanBankAssignRule;

	public Long insertFssLoan(FssLoanModel fssLoanModel) {
		try {
			FssUserModel fssUserModel = this.fssGuaranteeUserManager
					.getGuaranteeUserByFssUserId(fssLoanModel
							.getGuaranteeUserId());
			fssLoanModel.setGuaranteeUserName(fssUserModel.getName());
			fssLoanModel.setIsFinish(FssYesOrNoEnum.N.code());
			fssLoanModel.setCommonRepaymentCount(0);
			fssLoanModel.setGuaranteeCount(0);
			fssLoanModel.setAuditStatus(FssLoanAuditStatusEnum.UNSUBMIT.code());
			List<FssLoanRelationModel> fssLoanRelationModels = fssLoanModel
					.getLoanRelationList();
			if (!CollectionUtils.isEmpty(fssLoanRelationModels)) {
				fssLoanRelationModels
						.stream()
						.forEach(
								loanRelation -> {
									if (StringUtils.equals(
											loanRelation.getRelationType(),
											FssLoanRelationRelationTypeEnum.COMMON_REPAYMENT_PERSON
													.code())) {
										fssLoanModel
												.setCommonRepaymentCount(fssLoanModel
														.getCommonRepaymentCount() + 1);
									} else if (StringUtils.equals(
											loanRelation.getRelationType(),
											FssLoanRelationRelationTypeEnum.GUARANTEE_PERSON
													.code())) {
										fssLoanModel.setGuaranteeCount(fssLoanModel
												.getGuaranteeCount() + 1);
									}
								});
			}
			// 1 TODO 选择银行机构，目前只有一家银行机构，获取银行表的第一条记录即可
			//银行在app端选择，this.fssLoanBankAssignRule.assginToBank(fssLoanModel);
			// 2 TODO 设置担保机构
			FssGuaranteeModel fssGuaranteeModel = this.fssGuaranteeModelMapper
					.selectByPrimaryKey(fssLoanModel.getGuaranteeId());
			fssLoanModel.setGuaranteeName(fssGuaranteeModel.getGuaranteeName());
			// 3 TODO 插入贷款信息
			Integer row = this.fssLoanModelMapper.insert(fssLoanModel);
			if (row < 1) {
				throw new FssLoanBizException(ResultCodeContants.failed, "业务异常");
			}
			List<FssLoanDocumentModel> relatePersonLoanDocument = new ArrayList<FssLoanDocumentModel>();
			Long loanId = fssLoanModel.getLoanId();
			fssLoanModel.setLoanCode("L"
					+ DateUtils.format(new Date(), "yyyyMMddHHmmssSSS")
					+ fixedLengthId(loanId));
			// 4 TODO 插入贷款相关人
			if (!CollectionUtils.isEmpty(fssLoanRelationModels)) {
				fssLoanRelationModels.stream().forEach(
						loanRelation -> {
							if (!CollectionUtils.isEmpty(loanRelation
									.getLoanDocumentList())) {
								relatePersonLoanDocument.addAll(loanRelation
										.getLoanDocumentList());
							}
							loanRelation.setLoanId(loanId);
							this.insertFssLoanRelation(loanRelation);
						});
			}
			List<FssLoanDocumentModel> loanAllDocumentList = fssLoanModel
					.getLoanAllDocumentList();
			// 初始化其他贷款文档信息
			this.insertOtherFssLoanDocument(loanId, loanAllDocumentList,
					relatePersonLoanDocument);
			// 5 TODO 插入流程信息
			Result<Void> result = loanStatusTransformChannelAdaptor
					.initAuditLog(fssUserModel, fssLoanModel);
			if (result.getCode() != ResultCodeContants.success) {
				throw new FssLoanBizException(result.getCode(),
						result.getMessage());
			}
			this.fssLoanModelMapper.updateLoanCode(fssLoanModel);
			FssLoanAuditingLogModel loanAuditingLogModel = new FssLoanAuditingLogModel();
			loanAuditingLogModel.setLoanId(loanId);
			// 同时提交审批 后续可能分开
			this.loanStatusTransformSubmitApproveAdaptor.submit(fssUserModel,
					loanAuditingLogModel);
			return loanId;
		} catch (Exception e) {
			logger.error(
					String.format("添加贷款信息异常:%s",
							ToStringBuilder.reflectionToString(fssLoanModel)),
					e);
			if (e instanceof FssLoanBizException) {
				throw e;
			} else {
				throw new FssLoanBizException(ResultCodeContants.failed,
						"添加贷款信息失败", e);
			}
		}
	}

	private static String fixedLengthId(Long id) {
		if (id < 9999) {
			DecimalFormat df = new DecimalFormat("#0000");
			return df.format(id);
		} else {
			return fixedLengthId(id % 10000);
		}
	}

	private void insertOtherFssLoanDocument(Long loanId,
			List<FssLoanDocumentModel> loanAllDocumentList,
			List<FssLoanDocumentModel> insertedPersonLoanDocument) {
		if (CollectionUtils.isEmpty(loanAllDocumentList)) {
			return;
		}

		if (!CollectionUtils.isEmpty(insertedPersonLoanDocument)) {

			List<FssLoanDocumentModel> otherList = new ArrayList<FssLoanDocumentModel>();
			List<String> fileUrlList = new ArrayList<String>(
					insertedPersonLoanDocument.size());
			insertedPersonLoanDocument.forEach(e -> {
				fileUrlList.add(e.getFileUrl());
			});

			// Exception in thread "main" java.lang.IllegalStateException:
			// Duplicate key
			// at
			// java.util.stream.Collectors.lambda$throwingMerger$0(Collectors.java:133)
			//
			// Map<String, String>
			// map=insertedPersonLoanDocument.stream().collect(
			// Collectors.toMap(FssLoanDocumentModel::getFileUrl,FssLoanDocumentModel::getFileUrl));
			loanAllDocumentList.forEach(e -> {
				if (fileUrlList.contains(e.getFileUrl())) {
					return;
				}
				e.setLoanId(loanId);
				otherList.add(e);
			});
			if (!CollectionUtils.isEmpty(otherList)) {
				this.fssLoanDocumentManager
						.batchInsertFssLoanDocument(otherList);
			}
		} else {
			loanAllDocumentList.forEach(e -> {
				e.setLoanId(loanId);
			});
			this.fssLoanDocumentManager
					.batchInsertFssLoanDocument(loanAllDocumentList);
		}

	}

	public Integer updateFssLoan(FssLoanModel fssLoanModel) {
		try {
			Integer row = this.fssLoanModelMapper
					.updateByPrimaryKey(fssLoanModel);
			return row;
		} catch (Exception e) {
			logger.error(
					String.format("修改贷款信息异常:%s",
							ToStringBuilder.reflectionToString(fssLoanModel)),
					e);
			throw new FssLoanBizException(ResultCodeContants.failed, "", e);
		}

	}

	public Integer deleteFssLoanByLoanId(Long loanId) {
		try {
			// TODO 要判断其他的数据是否有删除
			Integer row = this.fssLoanModelMapper.deleteByPrimaryKey(loanId);
			return row;
		} catch (Exception e) {
			logger.error(String.format("删除贷款信息异常:%d", loanId), e);
			throw new FssLoanBizException(ResultCodeContants.failed, "", e);
		}

	}

	public FssLoanModel getFssLoanById(Long id) {
		try {
			FssLoanModel fssLoanModel = this.fssLoanModelMapper
					.selectByPrimaryKey(id);
			this.loadLoanOtherInfo(fssLoanModel);
			return fssLoanModel;
		} catch (Exception e) {
			logger.error(String.format("查询单个贷款信息异常:%d", id), e);
			throw new FssLoanBizException(ResultCodeContants.failed, "", e);
		}

	}

	@Override
	public FssLoanModel getFssLoanByLoanCode(String loanCode) {
		try {
			FssLoanModel fssLoanModel = this.fssLoanModelMapper
					.getFssLoanByLoanCode(loanCode);
			this.loadLoanOtherInfo(fssLoanModel);
			return fssLoanModel;
		} catch (Exception e) {
			logger.error(String.format("查询单个贷款信息异常:%d", loanCode), e);
			throw new FssLoanBizException(ResultCodeContants.failed, "", e);
		}
	}

	public List<FssLoanModel> getFssLoanList(FssLoanModel fssLoanModel) {
		try {
			List<FssLoanModel> row = null;// TODO
			return row;
		} catch (Exception e) {
			logger.error(
					String.format("查询列表贷款信息异常:%s",
							ToStringBuilder.reflectionToString(fssLoanModel)),
					e);
			throw new FssLoanBizException(ResultCodeContants.failed, "", e);
		}

	}

	public PaginatedResult<FssLoanQueryModel> getPaginatorFssLoan(
			Paginator<FssLoanQueryParam> paginator) {
		try {
			HashMap<String, Object> param = new HashMap<String, Object>();
			param.put("_limit", paginator.getPageSize());
			param.put("_offset",
					(paginator.getCurrentPage() - 1) * paginator.getPageSize());

			BeanUtilsExt.copyPropertiesToMap(paginator.getParam(), param);

			List<FssLoanQueryModel> list = this.fssLoanModelMapper
					.getFssLoanPaging(param);
			Integer count = fssLoanModelMapper.getFssLoanPagingCount(param);
			PaginatedResult<FssLoanQueryModel> paginatedResult = new PaginatedResult<FssLoanQueryModel>();
			paginatedResult.setRows(list);
			paginatedResult.setTotal(count);
			return paginatedResult;
		} catch (Exception e) {
			logger.error(
					String.format("分页查询贷款信息异常:%s",
							ToStringBuilder.reflectionToString(paginator)), e);
			throw new FssLoanBizException(ResultCodeContants.failed, "", e);
		}

	}

	@Override
	public FssLoanAuditStatusStatisticsResult getFssLoanStatisticsCountByAuditStatus(
			FssLoanQueryParam fssLoanQueryParam) {
		try {
			FssLoanAuditStatusStatisticsResult result = new FssLoanAuditStatusStatisticsResult();
			result.setFinishSignCount(0);
			result.setOnTheWayCount(0);
			List<FssLoanAuditStatusStatistics> list = this.fssLoanModelMapper
					.getFssLoanStatisticsCountByAuditStatus(fssLoanQueryParam);
			if (CollectionUtils.isEmpty(list)) {
				return result;
			}
			result.setAuditStatusStatisticsList(list);
			list.stream().forEach(
					e -> {
						if (StringUtils.equals(e.getAuditStatus(),
								FssLoanAuditStatusEnum.ADUIT_PASS.code())) {
							result.setFinishSignCount(result
									.getFinishSignCount()
									+ e.getAuditStatusCount());
						} else {
							result.setOnTheWayCount(result.getOnTheWayCount()
									+ e.getAuditStatusCount());
						}
					});
			return result;
		} catch (Exception e) {
			logger.error(String.format("根据贷款状态统计查询信息异常:%s",
					ToStringBuilder.reflectionToString(fssLoanQueryParam)), e);
			throw new FssLoanBizException(ResultCodeContants.failed,
					"根据贷款状态统计查询信息异常", e);
		}
	}

	@Autowired
	@Qualifier("loanStatusTransformSubmitApproveAdaptor")
	private FssLoanStatusTransformAdaptor<FssUserModel> loanStatusTransformSubmitApproveAdaptor;

	@Override
	public Integer submitLoanApprove(FssUserModel fssUserModel,
			FssLoanAuditingLogModel fssLoanAuditingLogModel) {

		FssLoanAuditingLogQueryModel logModel = fssLoanAuditingLogManager
				.getFssLoanAuditingLogListByLoanId(
						fssLoanAuditingLogModel.getLoanId())
				.stream()
				.sorted(Comparator.comparingLong(
						FssLoanAuditingLogQueryModel::getLogId).reversed())
				.findFirst()
				.orElseThrow(
						() -> new FssLoanStatusTransformException("未找到流程记录!"));
		logModel.setAuditContent(fssLoanAuditingLogModel.getAuditContent());
		Result<Void> result = loanStatusTransformSubmitApproveAdaptor.submit(
				fssUserModel, fssLoanAuditingLogModel);
		if (result.getCode() == ResultCodeContants.success) {
			return 1;
		} else {
			throw new FssLoanBizException(result.getCode(), result.getMessage());
		}
	}

	@Autowired
	@Qualifier("loanStatusTransformApproveAdaptor")
	private FssLoanStatusTransformAdaptor<FssOrganizationUserModel> loanStatusTransformApproveAdaptor;

	@Override
	public Integer approvePass(FssOrganizationUserModel organizationUser,
			FssLoanAuditingLogModel fssLoanAuditingLogModel) {

		FssLoanAuditingLogQueryModel logModel = fssLoanAuditingLogManager
				.getFssLoanAuditingLogListByLoanId(
						fssLoanAuditingLogModel.getLoanId())
				.stream()
				.sorted(Comparator.comparingLong(
						FssLoanAuditingLogQueryModel::getLogId).reversed())
				.findFirst()
				.orElseThrow(
						() -> new FssLoanStatusTransformException("未找到流程记录!"));
		logModel.setAuditContent(fssLoanAuditingLogModel.getAuditContent());
		Result<Void> result = loanStatusTransformApproveAdaptor.pass(
				organizationUser, fssLoanAuditingLogModel);
		if (result.getCode() == ResultCodeContants.success) {
			return 1;
		} else {
			throw new FssLoanBizException(result.getCode(), result.getMessage());
		}
	}

	@Override
	public Integer approveReject(FssOrganizationUserModel organizationUser,
			FssLoanAuditingLogModel fssLoanAuditingLogModel) {
		FssLoanAuditingLogQueryModel logModel = fssLoanAuditingLogManager
				.getFssLoanAuditingLogListByLoanId(
						fssLoanAuditingLogModel.getLoanId())
				.stream()
				.sorted(Comparator.comparingLong(
						FssLoanAuditingLogQueryModel::getLogId).reversed())
				.findFirst()
				.orElseThrow(
						() -> new FssLoanStatusTransformException("未找到流程记录!"));
		logModel.setAuditContent(fssLoanAuditingLogModel.getAuditContent());
		Result<Void> result = loanStatusTransformApproveAdaptor.reject(
				organizationUser, fssLoanAuditingLogModel);
		if (result.getCode() == ResultCodeContants.success) {
			return 1;
		} else {
			throw new FssLoanBizException(result.getCode(), result.getMessage());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.yundian.fss.manager.FssLoanManager#loanTypeStat(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public List<LoanTypeStatItemModel> loanTypeStat(Long guaranteeId,Long bankId,String startDate, String endDate) {

		
		List<LoanTypeStatItemModel> list = this.fssLoanModelMapper.selectLoanTypeStat(guaranteeId,bankId,startDate, endDate);
		
		for(LoanTypeStatItemModel item:list)
		{
			try
			{
				if(!StringUtils.isEmpty(item.getName()))
					item.setName(FssLoanLoanTypeEnum.getDesc(item.getName()));
			}catch(Exception e)
			{
				throw new FssLoanBizException(ResultCodeContants.failed, "贷款类型分布统计异常");
			}
		}
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.yundian.fss.manager.FssLoanManager#loanCompareStat(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public LoanCompareStatModel loanCompareStat(Long guaranteeId,Long bankId,String startDateStr) {
		LoanCompareStatModel compareStatModel=new LoanCompareStatModel();
		try {
			Date startDate = null;
			
			if (StringUtils.isEmpty(startDateStr)) {
				startDate = DateUtils.getStartOfMonth(DateUtils.getCurDate());
			} else {
				startDate = DateUtils.getStartOfMonth(DateUtils
						.strToDate(startDateStr));
			}
			Date endDate = DateUtils.getEndOfMonth(new Date());
			
			Date preStartDate =DateUtils.addMonth(startDate, -1);
			Date preEndDate = DateUtils.addMonth(endDate, -1);
			
			List<String> dateStingList=new ArrayList<String>();
			int intervalDays=this.intervalDaysOfTwoMonth(startDate, endDate);
			
			
			
			
			Map<String,Long> thisDateCountMap=new LinkedHashMap<String, Long>();
			Map<String,Long> preDateCountMap=new LinkedHashMap<String, Long>();

			for (int i=0;i<=intervalDays;i++) {
				String dateString=DateUtils.format(DateUtils.addDays(startDate, i));
				dateStingList.add(DateUtils.format(DateUtils.addDays(startDate, i),"dd"));
				thisDateCountMap.put(dateString, 0L);
				preDateCountMap.put(DateUtils.format(DateUtils.addDays(preStartDate, i)), 0L);
			}
			compareStatModel.setDateStingList(dateStingList);
			compareStatModel.setIntervalDays(intervalDays);
			
			//这个月的统计数据
			Map<String,Long> thisMonthDataMap=this.getStatDataOfDate(guaranteeId,bankId,startDate,endDate,thisDateCountMap);
			compareStatModel.setThisMonthLoanDataList(new ArrayList<Long>(thisMonthDataMap.values()));
			//前一个月的统计数据
			Map<String,Long> preMonthDataMap=this.getStatDataOfDate(guaranteeId,bankId,preStartDate,preEndDate,preDateCountMap);
			compareStatModel.setPreMonthLoanDataList(new ArrayList<Long>(preMonthDataMap.values()));
			
		} catch (Exception e) {
			throw new FssLoanBizException(ResultCodeContants.failed, "月份比较统计异常");
		}
		return compareStatModel;
	}
	private Map<String,Long> getStatDataOfDate(Long guaranteeId,Long bankId,Date startDate,Date endDate,Map<String,Long> dateCountMap) {
		
		Map<String,Long> thisMonthDataMap=new TreeMap<String, Long>(dateComparator);

		List<Map<String,Object>> thisMonth=
				this.fssLoanModelMapper.selectLoanCompareStat(guaranteeId,bankId,DateUtils.format(startDate), DateUtils.format(endDate));
		for (Map<String, Object> map : thisMonth) {
			String ctime=null;
			Long loanCount=0L;
			for (Map.Entry<String, Object> entry : map.entrySet()) {
				if ("ctime".equals(entry.getKey())) {
					ctime=entry.getValue().toString();
				} else if ("loanCount".equals(entry.getKey())) {
					loanCount = Long.valueOf(entry.getValue().toString());
				}
			}
			thisMonthDataMap.put(ctime, loanCount);
		}
		for (Map.Entry<String,Long> dateCount:dateCountMap.entrySet()) {
			Long value=thisMonthDataMap.get(dateCount.getKey());
			if(value==null){//判断某日是否有数据，没有则插入0
				thisMonthDataMap.put(dateCount.getKey(), 0L);
			}
		}
		
		return thisMonthDataMap;
		
	}

	private int intervalDaysOfTwoMonth(Date fDate, Date oDate) {
		Calendar aCalendar = Calendar.getInstance();
		aCalendar.setTime(fDate);
		int day1 = aCalendar.get(Calendar.DAY_OF_YEAR);
		aCalendar.setTime(oDate);
		int day2 = aCalendar.get(Calendar.DAY_OF_YEAR);
		return day2 - day1;
	}

	/* (non-Javadoc)
	 * @see com.yundian.fss.manager.FssLoanManager#loanTypeCompareStat(java.lang.String, java.lang.String)
	 */
	@Override
	public LoanTypeMonthTrendStatModel loanTypeCompareStat(Long guaranteeId,Long bankId,String startDateStr,
			String endDateStr) {
		LoanTypeMonthTrendStatModel loanTypeMonthTrendStatModel=new LoanTypeMonthTrendStatModel();
		try {
			//转换日期
			Date startDate = DateUtils.strToDate(startDateStr);
			Date endDate = DateUtils.strToDate(endDateStr);
			
			List<String> dateStingList=new ArrayList<String>();
			int intervalDays=this.intervalDaysOfTwoMonth(startDate, endDate);
			
			Map<String,Long> thisDateCountMap=new TreeMap<String, Long>(dateComparator);
			for (int i=0;i<=intervalDays;i++) {
				String dateString=DateUtils.format(DateUtils.addDays(startDate, i));
				dateStingList.add(dateString);
				thisDateCountMap.put(dateString, 0L);
			}
			
			List<Map<String,Object>> mapList=this.fssLoanModelMapper.selectLoanTypeCompareStat(guaranteeId,bankId,startDateStr, endDateStr);
			//贷款类型：日期：数据
			Map<String,Map<String,Long>> loanTypeDateDataListMap=new HashMap<String, Map<String,Long>>();
		
			for (Map<String, Object> map : mapList) {
				String ctime=null;
				Long loanCount=0L;
				String loanType=null;
				for (Map.Entry<String, Object> entry : map.entrySet()) {
					if ("ctime".equals(entry.getKey())) {
						ctime=entry.getValue().toString();
					} else if ("loanCount".equals(entry.getKey())) {
						loanCount = Long.valueOf(entry.getValue().toString());
					} else if ("loanType".equals(entry.getKey())) {
						loanType = entry.getValue().toString();
					}
				}
				Map<String,Long> listDataMap= loanTypeDateDataListMap.get(loanType);
				if(listDataMap==null){
					listDataMap=new TreeMap<String,Long>(dateComparator);
					listDataMap.putAll(thisDateCountMap);
					loanTypeDateDataListMap.put(loanType, listDataMap);
				}
				listDataMap.put(ctime, loanCount);
			}
			List<LoanTypeMonthTrendSeriesModel> series=new ArrayList<LoanTypeMonthTrendSeriesModel>();
			
			for (Map.Entry<String, Map<String,Long>> e : loanTypeDateDataListMap.entrySet()) {
				LoanTypeMonthTrendSeriesModel model=new LoanTypeMonthTrendSeriesModel();
				model.setName(FssLoanLoanTypeEnum.getDesc(e.getKey()));
				model.setType(LoanTypeMonthTrendSeriesModel.type_column);
				List<Long> thisMonthLoanDataList=new ArrayList<Long>();

				for (Map.Entry<String, Long> se : e.getValue().entrySet()) {
					thisMonthLoanDataList.add(se.getValue());
					thisDateCountMap.put(se.getKey(), 
							thisDateCountMap.get(se.getKey())+se.getValue());
				}
				model.setData(thisMonthLoanDataList);
				series.add(model);
			}
			List<Long> avgData=new ArrayList<Long>();
			LoanTypeMonthTrendSeriesModel avgModel=new LoanTypeMonthTrendSeriesModel();
			avgModel.setName("平均值");
			avgModel.setType(LoanTypeMonthTrendSeriesModel.type_spline);
			
			for (Map.Entry<String, Long> se :thisDateCountMap.entrySet()) {
				avgData.add(Double.valueOf(Math.round(se.getValue()/series.size())).longValue());
//				thisDateCountMap.put(se.getKey(), 
//						thisDateCountMap.get(se.getKey())+se.getValue());
			}
			avgModel.setData(avgData);
			series.add(avgModel);
			loanTypeMonthTrendStatModel.setIntervalDays(thisDateCountMap.size());
			loanTypeMonthTrendStatModel.setSeries(series);
			loanTypeMonthTrendStatModel.setIntervalDateList(new 
					ArrayList<String>(thisDateCountMap.keySet()));
			
		} catch (Exception e) {
			throw new FssLoanBizException(ResultCodeContants.failed, "按日期统计贷款类型数据异常",e);
		}
		return loanTypeMonthTrendStatModel;
	}
	
	private static Comparator<String> dateComparator= new Comparator<String>() {
        public int compare(String obj1, String obj2) {
				try {
				return DateUtils.strToDate(obj1).compareTo(DateUtils.strToDate(obj2));
			} catch (ParseException e) {
				return 0;
			}
        }
    };

	@Override
	public Map<String, Integer> loanStatusStat(Long guaranteeId, Long bankId) {
		
		return this.fssLoanModelMapper.selectLoanStatusStat(guaranteeId, bankId);
	}
}
