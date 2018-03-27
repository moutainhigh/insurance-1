//package com.yundian.fss.service.impl;
//
//
//import java.util.Date;
//
//import org.apache.commons.beanutils.PropertyUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//
//import com.cheguo.credit.py.model.FaceComparisionModel;
//import com.cheguo.credit.py.model.PyFaceComparisionResult;
//import com.cheguo.credit.py.service.IPyService;
//import com.yundian.fss.manager.FssLoanRelationRecognitionManager;
//import com.yundian.fssapi.domain.FssLoanRelationRecognitionModel;
//import com.yundian.fssapi.service.FssFaceMatchingService;
//import com.yundian.fssapi.service.dto.FaceMatchingResult;
//import com.yundian.result.Result;
//import com.yundian.result.ResultCodeContants;
//
//@Service("fssFaceMatchingService")
//public class FssFaceMatchingServiceImpl implements FssFaceMatchingService {
//	private static final Logger logger = LoggerFactory
//			.getLogger(FssFaceMatchingServiceImpl.class);
//	@Autowired
//	IPyService pyService;
//
//	@Autowired
//	private FssLoanRelationRecognitionManager fssLoanRelationRecognitionManager;
//
//	@Value("${dubbo.credit.open}")
//	private String isCreditOpen;
//
//
//
//
//	private Result<FaceMatchingResult> checkFaceMatching(String name, String cardId,
//			byte[] photoData) {
//
//		Result<FaceMatchingResult> result = new Result<FaceMatchingResult>();
//		FaceMatchingResult faceMatingResult = new FaceMatchingResult();
//		if(!isCreditOpen.equals("true"))
//		{
//			logger.info(String.format("人脸识别接口关闭:%s", name+cardId));
//			//接口关闭时，伪造通过数据
//			faceMatingResult.setCardId(cardId);
//			faceMatingResult.setName(name);
//			faceMatingResult.setIsNameValid("姓名和证件号码一致 ");
//			faceMatingResult.setIsPhotoCompared("已比对");
//			faceMatingResult.setSimilarity(89);
//			faceMatingResult.setValidateResult("建议通过");
//			faceMatingResult.setCtime(new Date());
//			result.setData(faceMatingResult);
//			result.setCode(ResultCodeContants.success);
//			result.setMessage("接口关闭");
//			return result;
//		}
//
//		FaceComparisionModel faceModel = new FaceComparisionModel();
//		faceModel.setDocumentNo(cardId);
//		faceModel.setName(name);
//		faceModel.setPhotoData(photoData);
//
//
//		try {
//			PyFaceComparisionResult pyFaceResult = pyService.checkFaceMatching(faceModel);
//			PropertyUtils.copyProperties(faceMatingResult, pyFaceResult);
//			faceMatingResult.setCtime(new Date());
//			result.setData(faceMatingResult);
//			result.setCode(ResultCodeContants.success);
//
//
//
//		} catch (Exception e) {
//			logger.error(String.format("人脸识别头像比对失败:%s", cardId), e);
//			result.setCode(ResultCodeContants.failed);
//			result.setMessage("人脸识别头像比对失败.");
//		}
//
//		return result;
//	}
//
//	@Override
//	public Result<FaceMatchingResult> checkFaceMatching(Long relationId, String name, String cardId,
//			byte[] photoData) {
//		Result<FaceMatchingResult> result = checkFaceMatching(name, cardId,photoData);
//		if(result.getCode()==ResultCodeContants.success&&result.getData()!=null)
//		{
//			FssLoanRelationRecognitionModel recognitionModel = new FssLoanRelationRecognitionModel();
//			recognitionModel.setRelationId(relationId);
//			recognitionModel.setCtime(new Date());
//			recognitionModel.setMtime(new Date());
//			recognitionModel.setResult(result.getData().getValidateResult());
//			recognitionModel.setSimilarity(result.getData().getSimilarity());
//			fssLoanRelationRecognitionManager.deleteFssLoanRelationRecognitionById(relationId);
//			fssLoanRelationRecognitionManager.insertFssLoanRelationRecognition(recognitionModel);
//		}
//		return result;
//	}
//
//}
