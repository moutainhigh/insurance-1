package com.yundian.fss.service.support;

/**
 * @author jnx
 * @create 2018/6/24
 */
public class PasswordUtils {

    /**
     * 密码默认手机号码后6位
     */
    private static int PWD_PHONE_R_6=6;
    public static String getPhone6Pwd(String userLoginName){

        String newPwd = "";
        if(userLoginName.length()<=PWD_PHONE_R_6) {
            newPwd = userLoginName;
        }
        else {
            newPwd = userLoginName.substring(userLoginName.length() - PWD_PHONE_R_6, userLoginName.length());
        }
        return newPwd;
    }
}
