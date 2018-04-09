/**
 * 
 */
package com.yundian.result;

/**
 * @author ningxia.jin
 *
 */
public class  ResultProvider {

	public static <T> Result<T> getsSuccessResult(T data)
	{
		Result<T> result = new Result<T>();
		result.setData(data);
		result.setCode(ResultCodeContants.SUCCESS);
		return result;
	}
	
	public static  Result getsSuccessResult()
	{
		Result result = new Result();
		result.setCode(ResultCodeContants.SUCCESS);
		return result;
	}
	public static  Result getsSuccessResult(String message)
	{
		Result result = new Result();
		result.setCode(ResultCodeContants.SUCCESS);
		result.setMessage(message);
		return result;
	}
	public static Result<Object> getsFailedResult(String message)
	{
		Result<Object> result = new Result<Object>();
		result.setCode(ResultCodeContants.FAILED);
		result.setMessage(message);
		return result;
	}
 
}
