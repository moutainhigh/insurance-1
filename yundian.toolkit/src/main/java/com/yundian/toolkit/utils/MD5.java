package com.yundian.toolkit.utils;

import java.math.BigInteger;
import java.security.MessageDigest;

public class MD5 {
	private final static  String[] hexDigits = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };
	public  static String encodePassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            return byteArray2HexString(md.digest(password.getBytes()));
        } catch (Exception e) {
            return password;
        }
    }
	
	 /**
     * 转换字节数组为16进制字串
     * 
     * @param b 字节数组
     * @return  16进制字串
     */
    private static  String byteArray2HexString(byte[] b) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < b.length; i++) {
            sb.append(byte2HexString(b[i]));
        }
        return sb.toString();
    }
    /**
     * byte转String
     * @param b
     * @return
     */
    private static  String byte2HexString(byte b) {
        int n = b;
        if (n < 0)
            n = 256 + n;
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }
    
    public static String binary(byte[] bytes, int radix){  
        return new BigInteger(1, bytes).toString(radix);// 这里的1代表正数  
    }  
    
    public static void main(String[] args)
    {//730d4f266067b012749bcb4c2dab57e8
    	String s="221201\u202C";

    	String iphone="\u202D189 2122 1201\u202C";
        System.out.printf(encodePassword(s));
    }
}
