package com.yundian.dealerweb.util;

public class AdminWebConstants {

	
	/**
     * 系统管理模块常量
     */
    public static interface SYS {
    	
    	//超级管理员常量字符串
    	public static final String SYS_ADMIN = "sysadmin";
    	
    	//用来保存当前登录用户信息的常量字符串
    	public static final String WEB_ADMIN_USER_SESSION = "sysadminSessionLoginObject";
    	
    	//用来保存当前登录用户权限的常量字符串
    	public static final String WEB_ADMIN_USERALLRIGHTS_SESSION = "userPermissions";
    	
    	/**
    	 * 登录页面的路�?
    	 */
    	public static final String LOGINLOCATON = "login";
    	
    	/**
    	 * 跳转到错误页�?
    	 */
    	public static final String ERRORPAGE = "redirect:/login/error";
    	
    	
    	/**
		 * 分页大小设置
		 */
		public static final int PAGESIZE = 10;
		
		/**
		 * wcf接口的数据部分节点名 
		 */
		public static final String DATAKEY = "Data";
		
		/**
		 * 密码长度
		 */
		public static final int PASSWORDLENGTH = 8;
		
		/**
		 * 系统消息
		 */
		public static final String ERRORMSG = "errorMsg";
    }
    
	// 调用spring result返回的json中的结果代码key
	public static final String RESULT_CODE = "result_code";

	// 调用spring result返回的json中的结果信息key
	public static final String RESULT_MESSAGE = "result_message";

	// 调用spring result返回的json中的结果代码value，代表成�?
	public static final String RESULT_CODE_SUCCESS = "0";
	
	// 调用spring result返回的json中的结果代码value，代表失�?
	public static final String RESULT_CODE_FAILURE = "1";

	// 调用spring result返回的json中的结果描述value，成�?
	public static final String RESULT_MESSAGE_SUCCESS = "successful";

	// 调用spring result返回的json中的结果描述value，失�?
	public static final String RESULT_MESSAGE_FAILURE = "failure";
	
	// 异常描述
	public static final String EXCEPTION_STACK_TRACE = "exception_stack_trace";
	
	// �?/
	public static final String FILE_SEPARATOR = "/";
	

 	public static final String JSON_RESULT_API_NAME = "api";
	public static final String JSON_RESULT_MESSAGE = "message";
	public static final String JSON_RESULT_ValidFORM_STATUS = "status";
	public static final String JSON_RESULT_STATUS_CODE = "statuscode";
	public static final String JSON_RESULT_DATA = "data";
	public static final String JSON_RESULT_PAGING = "paging";
	
 	// 调用spring result返回的json中的结果描述value，成�?
 	public static final String JSON_RESULT_MESSAGE_SUCCESS = "successful";

 	// 调用spring result返回的json中的结果描述value，失�?
 	public static final String JSON_RESULT_MESSAGE_FAILURE = "failure";
	 	
 	/**
	 * 成功标识
	 */
	public static final int OK = 10000;
	
	/**
	 * 错误标识
	 * 
	 * 20001:验证码错�?
	 * 
	 * 211** 用户模块
	 * 21101:用户名密码错�?
	 * 21102:帐号被禁�?
	 * 21103:
	 */
	public static final int ERROR = 20000;
	

	
	
	public static final String UTF8_CODE="utf-8";
	
	//压缩图片的尺�?
	public static final double IMG_WIDTH = 640;
	
	public static final String USER_PASSWORD = "ac@123";//暂时：ac@123
	
	
	
}
