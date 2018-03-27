package com.yundian.toolkit.constant;

public class Constants {

	/**
	 * 系统管理模块常量
	 */
	public static interface SYS {

		/**
		 * 分页大小设置
		 */
		public static final int PAGESIZE = 10;

		/**
		 * 密码长度
		 */
		public static final int PASSWORDLENGTH = 8;

	}

	// 异常描述
	public static final String EXCEPTION_STACK_TRACE = "exception_stack_trace";

	// 反/
	public static final String FILE_SEPARATOR = "/";

	public static final String JSON_RESULT_API_NAME = "api";
	public static final String JSON_RESULT_MESSAGE = "message";
	public static final String JSON_RESULT_ValidFORM_STATUS = "status";
	public static final String JSON_RESULT_STATUS_CODE = "statuscode";
	public static final String JSON_RESULT_DATA = "data";
	public static final String JSON_RESULT_PAGING = "paging";
	// 调用spring result返回的json中的结果描述value，成功
	public static final String JSON_RESULT_MESSAGE_SUCCESS = "successful";
	// 调用spring result返回的json中的结果描述value，失败
	public static final String JSON_RESULT_MESSAGE_FAILURE = "failure";
	/**
	 * 成功标识
	 */
	public static final int OK = 10000;

	/**
	 * 错误标识
	 * 
	 * 20001:验证码错误
	 * 
	 * 211** 用户模块 21101:用户名密码错误 21102:帐号被禁用 21103:
	 */
	public static final int ERROR = 20000;

	public static final String UTF8_CODE = "utf-8";

	// 压缩图片的尺寸
	public static final double IMG_WIDTH = 640;

}
