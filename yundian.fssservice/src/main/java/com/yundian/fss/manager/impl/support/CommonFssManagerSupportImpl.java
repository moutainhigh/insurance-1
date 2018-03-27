package com.yundian.fss.manager.impl.support;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import com.yundian.fss.dao.FssLoanRelationModelMapper;
import com.yundian.fss.exception.FssLoanBizException;
import com.yundian.fss.manager.FssLoanDocumentManager;
import com.yundian.fss.manager.FssLoanRelationRecognitionManager;
import com.yundian.fss.manager.impl.FssLoanRelationManagerImpl;
import com.yundian.fssapi.domain.FssLoanDocumentModel;
import com.yundian.fssapi.domain.FssLoanModel;
import com.yundian.fssapi.domain.FssLoanRelationModel;
import com.yundian.fssapi.domain.FssLoanRelationRecognitionModel;
import com.yundian.result.ResultCodeContants;

public class CommonFssManagerSupportImpl {
	private static final Logger logger = LoggerFactory
			.getLogger(FssLoanRelationManagerImpl.class);
	@Autowired
	private FssLoanRelationModelMapper fssLoanRelationModelMapper;
	@Autowired
	protected FssLoanRelationRecognitionManager fssLoanRelationRecognitionManager;
	@Autowired
	protected FssLoanDocumentManager fssLoanDocumentManager;
	
	protected Integer insertFssLoanRelation(
			FssLoanRelationModel fssLoanRelationModel) {
		try {
			Integer row = this.fssLoanRelationModelMapper
					.insert(fssLoanRelationModel);
			if (!CollectionUtils.isEmpty(fssLoanRelationModel
					.getLoanDocumentList())) {
				fssLoanRelationModel.getLoanDocumentList().forEach(e -> {
					e.setLoanId(fssLoanRelationModel.getLoanId());
					e.setRelationId(fssLoanRelationModel.getRelationId());
				});
				fssLoanDocumentManager
						.batchInsertFssLoanDocument(fssLoanRelationModel
								.getLoanDocumentList());
			}
			return row;
		} catch (Exception e) {
			logger.error(String.format("添加贷款关系人异常:%s",
					ToStringBuilder.reflectionToString(fssLoanRelationModel)),
					e);
			if(e instanceof FssLoanBizException){
				throw e;
			}else{
				throw new FssLoanBizException(ResultCodeContants.failed, "系统异常", e);
			}
		}
	}
	/**
	 * 加载贷款其他信息 1 联系人，2照片资料 
	 * @param fssLoanModel
	 */
	protected void loadLoanOtherInfo(FssLoanModel fssLoanModel){
		
		
		List<FssLoanRelationModel> relationModels = this.fssLoanRelationModelMapper
				.getFssLoanRelationListByLoanId(fssLoanModel.getLoanId());
		fssLoanModel.setLoanRelationList(relationModels);
		
		List<FssLoanDocumentModel> documentModels=fssLoanDocumentManager
				.getFssLoanDocumentListByLoanId(fssLoanModel.getLoanId());
		fssLoanModel.setLoanAllDocumentList(documentModels);
		
		this.loanRelationDocumentGroup(relationModels, documentModels);
	}
	
	protected List<FssLoanRelationModel> getFssLoanRelationAndDocumentListByLoanId(
			Long loanId) {
		try {
			List<FssLoanRelationModel> relationModels = this.fssLoanRelationModelMapper
					.getFssLoanRelationListByLoanId(loanId);
			if (CollectionUtils.isEmpty(relationModels)) {
				return relationModels;
			}
			List<FssLoanDocumentModel> documentModels = fssLoanDocumentManager
					.getFssLoanDocumentListByLoanId(loanId);
			this.loanRelationDocumentGroup(relationModels, documentModels);
			return relationModels;
		} catch (Exception e) {
			logger.error(String.format("查询列表贷款关系人异常:%d", loanId), e);
			throw new FssLoanBizException(ResultCodeContants.failed,
					"查询列表贷款关系人异常", e);
		}
	}
	
	protected List<FssLoanRelationModel> getFssLoanRelationAndDocumentAndRecognitionByLoanId(
			Long loanId) {
		try {
			List<FssLoanRelationModel> relationModels = getFssLoanRelationAndDocumentListByLoanId(loanId);
			for(FssLoanRelationModel relation:relationModels)
			{
				FssLoanRelationRecognitionModel  recognitionModel =fssLoanRelationRecognitionManager.getFssLoanRelationRecognitionByRelationId(relation.getRelationId());
				relation.setRelationRecognition(recognitionModel);
			}
			
			return relationModels;
		} catch (Exception e) {
			logger.error(String.format("查询列表贷款关系人异常:%d", loanId), e);
			throw new FssLoanBizException(ResultCodeContants.failed,
					"查询列表贷款关系人异常", e);
		}
	}
	
	private void loanRelationDocumentGroup(List<FssLoanRelationModel> relationModels,
			List<FssLoanDocumentModel> documentModels) {
		if (CollectionUtils.isEmpty(relationModels)) {
			return;
		}
		Map<Long, FssLoanRelationModel> relationMap = relationModels.stream()
				.collect(
						Collectors.toMap(
								FssLoanRelationModel::getRelationId,
								(p) -> p));

		if (!CollectionUtils.isEmpty(documentModels)) {
			documentModels
					.forEach(e -> {
						FssLoanRelationModel fssLoanRelationModel = relationMap
								.get(e.getRelationId());
						if(fssLoanRelationModel==null){
							return ;
						}
						if (fssLoanRelationModel.getLoanDocumentList() == null) {
							fssLoanRelationModel
									.setLoanDocumentList(new ArrayList<FssLoanDocumentModel>());
						}
						fssLoanRelationModel.getLoanDocumentList().add(e);
					});
		}
	}
}
