package com.yundian.fss.exception;

/**
 * 业务异常
 * 
 * @author hehaibo
 *
 */
public class FssLoanBizException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String code;
	
	private String errorMsg;

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public FssLoanBizException(String code,String message, Throwable cause) {
		super("[code:"+code+",message:"+message+"]", cause);
		this.code=code;
		this.errorMsg=message;
	}

	/**
	 * @param message
	 * @param cause
	 */
	public FssLoanBizException(String code,String message) {
		super("[code:"+code+",message:"+message+"]");
		this.code=code;
		this.errorMsg=message;
	}


	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String messsage) {
		this.errorMsg = messsage;
	}

}
