package com.yundian.fssapi.service;

import com.yundian.fssapi.service.dto.FaceMatchingResult;
import com.yundian.result.Result;

public interface FssFaceMatchingService {

	/**
	 * 人脸匹配接口，上传的头像图片与公安网身份证头像匹配
	 * @param relationId 面签人id
	 * @param name 姓名
	 * @param cardId 身份证号码
	 * @param photoData 上传的头像图片
	 * @return FaceMatchingResult
	 */
	public Result<FaceMatchingResult> checkFaceMatching(Long relationId, String name,
			String cardId, byte[] photoData);
}
