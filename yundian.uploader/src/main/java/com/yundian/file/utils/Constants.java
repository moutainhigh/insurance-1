package com.yundian.file.utils;

public class Constants {

	// 调用spring result返回的json中的结果代码key
	public static final String RESULT_CODE = "result_code";

	// 调用spring result返回的json中的结果信息key
	public static final String RESULT_MESSAGE = "result_message";

	// 调用spring result返回的json中的结果代码value，代表成功
	public static final String RESULT_CODE_SUCCESS = "0";
	
	// 调用spring result返回的json中的结果代码value，代表失败
	public static final String RESULT_CODE_FAILURE = "1";

	// 调用spring result返回的json中的结果描述value，成功
	public static final String RESULT_MESSAGE_SUCCESS = "successful";

	// 调用spring result返回的json中的结果描述value，失败
	public static final String RESULT_MESSAGE_FAILURE = "failure";
	
	// 异常描述
	public static final String EXCEPTION_STACK_TRACE = "exception_stack_trace";
	
	// 反/
	public static final String FILE_SEPARATOR = "/";
	
	
	//压缩图片的尺寸
	public static final double IMG_WIDTH = 640;
}
