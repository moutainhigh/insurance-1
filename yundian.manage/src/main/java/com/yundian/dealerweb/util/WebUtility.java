package com.yundian.dealerweb.util;

import com.alibaba.fastjson.JSONObject;
import com.yundian.fssapi.domain.FssLoanModel;
import com.yundian.toolkit.utils.BeanPropFieldUtil;
import com.yundian.toolkit.utils.PropertiesUtil;

public class WebUtility {
	
	@Deprecated
	public static String ContextPath = PropertiesUtil.readValue("car.contextpath");

	public static String LOGIN_LOCATION = PropertiesUtil.readValue("car.login_location");

	public static String File_Server= PropertiesUtil.readValue("car.fileserver");
	
	public static String FileUploadUrl= PropertiesUtil.readValue("car.fileuploadurl");
	
	
	/**
	 * 重置密码时的默认密码
	 */
	public static String RESET_PASSWORD_STR = PropertiesUtil.readValue("car.reset_password");
	
//	public static String chkPermission(HttpServletRequest httpRequest,String permissionCode)
//	{
//		if(permissionCode!=null&&!permissionCode.equals(""))
//		{
//			String[] array = permissionCode.split("@");
//			
//			boolean chk =  Session.checkPermission(httpRequest, array[0], array.length>1?array[1]:"");
//			if(!chk)
//			{
//				return "style='display: none;'";
//			}
//			
//		}
//		return "";
//	}

	public static void main(String[] arg)
	{
		FssLoanModel fssLoanModel = new FssLoanModel();
		fssLoanModel.setInsuresName("金宁夏");
		fssLoanModel.setInsuresPhone("1378891002");
		fssLoanModel.setInsuresIdcard("330327198312251714");

		JSONObject jsonObject =    BeanPropFieldUtil.toPropField(fssLoanModel);

		System.out.printf(jsonObject.toString());
	}
}
