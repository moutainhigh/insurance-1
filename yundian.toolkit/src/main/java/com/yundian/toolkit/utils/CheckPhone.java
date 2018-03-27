package com.yundian.toolkit.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckPhone {

	public static boolean checkPhoneLayout(String phone) {
		 String regExp = "^((13)|(14)|(15)|(17)|(18))\\d{9}$";
		 Pattern p = Pattern.compile(regExp);
		 Matcher m = p.matcher(phone);
		 return m.find();
//		if (StringUtil.isNotBlank(phone) && phone.length() == 11) {
//			return true;
//		} else
//			return false;
	}
}
