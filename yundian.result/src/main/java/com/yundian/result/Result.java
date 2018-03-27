/**
 * 
 */
package com.yundian.result;

import java.io.Serializable;

/**
 * @author ningxia.jin 结果
 */
public class Result<T> implements Serializable {

	public Result() {
	}

	public Result(T data, int code, String message) {
		this.data = data;
		this.code = code;
		this.message = message;
	}

	/**
	 * 
	 */


	private static final long serialVersionUID = 1L;
	
	private T data;
	
	private int code=ResultCodeContants.success;
	
	private String message;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public boolean isSuccess(){
		return (ResultCodeContants.success==this.code);
	}

}
