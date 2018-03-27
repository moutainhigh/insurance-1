package com.yundian.fssapi.service.dto;

import java.io.Serializable;
import java.util.Date;

public class FaceMatchingResult implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5369918405911853609L;

	/**
	 * 被查询者姓名
	 */
	private String name;

	/**
	 * 被查询者证件号码。
	 */
	private String cardId;
	
	/**
	 * 姓名与证件号码比对结果，可能为空 返回值：姓名和证件号码一致/不一致（不显示照片比对结果）
	 */
	private String isNameValid;
	/**
	 * 是否成功比对照片 返回值：已比对/未比对
	 */
	private String isPhotoCompared;
	/**
	 * 相似度，采用百分制（0-100），可能为空，当照片成功比对时才有值返回
	 */
	private Integer similarity;
	/**
	 * 比对结果建议信息，如：建议通过/建议拒绝，可能为空，当照片成功比对时才有值返回
	 */
	private String validateResult;
	
	private Date ctime;
	
	
	
	public Date getCtime() {
		return ctime;
	}
	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCardId() {
		return cardId;
	}
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
	public String getIsNameValid() {
		return isNameValid;
	}
	public void setIsNameValid(String isNameValid) {
		this.isNameValid = isNameValid;
	}
	public String getIsPhotoCompared() {
		return isPhotoCompared;
	}
	public void setIsPhotoCompared(String isPhotoCompared) {
		this.isPhotoCompared = isPhotoCompared;
	}
	public Integer getSimilarity() {
		return similarity;
	}
	public void setSimilarity(Integer similarity) {
		this.similarity = similarity;
	}
	public String getValidateResult() {
		return validateResult;
	}
	public void setValidateResult(String validateResult) {
		this.validateResult = validateResult;
	}
	
	
	
	
}
