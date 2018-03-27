package com.yundian.basic.domain;

import java.io.Serializable;
import java.util.Date;

public class Sms implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3817462178560963231L;

	/**
	* 
	*/
	private Integer id;

	/**
	 * 手机号码
	 */
	private String phone;

	/**
	 * 验证码
	 */
	private String code;

	/**
	 * 短信内容
	 */
	private String sms;

	/**
	 * 短信分类
	 */
	private String smstype;
	
	/**
	 * 入库时间
	 */
	private Date ctime;

	/**
	 * 状态：1成功，-1失败，0未发送
	 */
	private Integer status;

	/**
	 * 接口返回数据
	 */
	private String result;

	/**
	 * 短信发送时间
	 */
	private Date sendtime;

	/**
	 * 访问者IP
	 */
	private String ip;
	
	
	/**
	 * 消息编号
	 */
	private String msgid;

	/**
	 * 短信通道：ZT,CL
	 */
	private String channel;
	/**
	 * 短信状态报告
	 */
	private String report;
	
	/**
	 * 短信状态报告时间
	 */
	private Date reporttime;
	
	
	public String getMsgid() {
		return msgid;
	}

	public void setMsgid(String msgid) {
		this.msgid = msgid;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getReport() {
		return report;
	}

	public void setReport(String report) {
		this.report = report;
	}

	public Date getReporttime() {
		return reporttime;
	}

	public void setReporttime(Date reporttime) {
		this.reporttime = reporttime;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getSms() {
		return sms;
	}

	public void setSms(String sms) {
		this.sms = sms;
	}

	public String getSmstype() {
		return smstype;
	}

	public void setSmstype(String smstype) {
		this.smstype = smstype;
	}

	public Date getCtime() {
		return ctime;
	}

	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Date getSendtime() {
		return sendtime;
	}

	public void setSendtime(Date sendtime) {
		this.sendtime = sendtime;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
}
