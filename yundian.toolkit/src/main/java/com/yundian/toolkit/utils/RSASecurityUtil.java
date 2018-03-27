package com.yundian.toolkit.utils;

import java.io.ByteArrayOutputStream;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.Cipher;

/**
 * RSA加密算法
 */
public class RSASecurityUtil {
	
	/**
	 * 加密最大长度
	 */
	private final static Integer encrypt_data_length = 117;
	
	/**
	 * 解密最大长度
	 */
	private final static Integer decrypt_data_length = 64;
	
	/**
	 * 读取私钥
	 * @param privateKey
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("restriction")
	private static RSAPrivateKey getPrivateKey(String privateKey)throws Exception {
		sun.misc.BASE64Decoder decoder = new sun.misc.BASE64Decoder();
		PKCS8EncodedKeySpec priPKCS8 = new PKCS8EncodedKeySpec(decoder.decodeBuffer(privateKey));
		KeyFactory keyf = KeyFactory.getInstance("RSA");
		return (RSAPrivateKey) keyf.generatePrivate(priPKCS8);
	} 
	
	/**
	 * 私钥解密
	 * @param encryptedData
	 * @param privateKeyStr
	 * @return
	 * @throws Exception
	 */
	 @SuppressWarnings("restriction")
	public static String decrypt(String encryptedData, String privateKeyStr) throws Exception {
		if (privateKeyStr == null || privateKeyStr.length() == 0) {
			throw new Exception("no private key found");
		}
		if(encryptedData == null || encryptedData.length() == 0){
			throw new Exception("解密数据为空");
		}
		RSAPrivateKey privateKey = getPrivateKey(privateKeyStr);
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.DECRYPT_MODE, privateKey);
		sun.misc.BASE64Decoder decoder = new sun.misc.BASE64Decoder();
		byte[] encryptByte = decoder.decodeBuffer(encryptedData);
        byte[] output;
        //分段解密
  		if (encryptByte.length > decrypt_data_length) {
  			ByteArrayOutputStream out = new ByteArrayOutputStream();
  			int iCnt = encryptByte.length / decrypt_data_length;
  			byte[] cache;
  			for(int i = 0; i < iCnt + 1; i++){
  				if(i == iCnt){
  					cache = cipher.doFinal(encryptByte, decrypt_data_length * i, encryptByte.length - decrypt_data_length * i);
  				}else{
  					cache = cipher.doFinal(encryptByte, decrypt_data_length * i, decrypt_data_length);
  				}
  	            out.write(cache, 0, cache.length);
  			}
  			output = out.toByteArray();
  		} else {
  			output = cipher.doFinal(encryptByte); 
  		}
        String outputStr = new String(output, "UTF-8");
        return outputStr;
	}
	
	/**
	 * 读取公钥
	 * @param publicKey
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("restriction")
	private static RSAPublicKey getPublicKey(String publicKey) throws Exception{ 
		sun.misc.BASE64Decoder decoder = new sun.misc.BASE64Decoder();
		byte[] keyBytes = decoder.decodeBuffer(publicKey);
	    X509EncodedKeySpec spec = new X509EncodedKeySpec(keyBytes);  
	    KeyFactory keyFactory = KeyFactory.getInstance("RSA");  
	    return (RSAPublicKey) keyFactory.generatePublic(spec);  
	} 
	
	/**
	 * RSA数据加密
	 * @param encryptData 待加密数据
 	 * @param publicKeyStr 加密公钥
	 * @return
	 * @throws Exception 
	 */
	@SuppressWarnings("restriction")
	public static String encrypt(String encryptData, String publicKeyStr) throws Exception {
		if (publicKeyStr == null || publicKeyStr.length() == 0) {
			throw new Exception("no public key found");
		}
		RSAPublicKey publicKey = getPublicKey(publicKeyStr);
		Cipher cipher = null;  
		// 使用默认RSA  
    	cipher = Cipher.getInstance("RSA");  
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);  
        byte[] encryptByte = encryptData.getBytes("UTF-8");
        byte[] output;
        //分段加密
		if (encryptByte.length > encrypt_data_length) {
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			int iCnt = encryptByte.length / encrypt_data_length;
			byte[] cache;
			for(int i = 0; i < iCnt + 1; i++){
				if(i == iCnt){
					cache = cipher.doFinal(encryptByte, encrypt_data_length * i, encryptByte.length - encrypt_data_length * i);
				}else{
					cache = cipher.doFinal(encryptByte, encrypt_data_length * i, encrypt_data_length);
				}
	            out.write(cache, 0, cache.length);
			}
			output = out.toByteArray();
		} else {
			output = cipher.doFinal(encryptByte); 
		}
		sun.misc.BASE64Encoder encoder = new sun.misc.BASE64Encoder();
		return encoder.encode(output);
	}

	private final static String publickey = "xs8GFdmgST42%2B3gLRryOycTKUchdf4otMjkMPmvg9af5QMb2IhAYhBeyDK5WLvQn%2Bq0owLwY1%2FJW%0Atgnxw84kDbzibC8DbUVIs6VanFrQSG85Zd5yENp6akHV0yt6UX%2BH9msjgjLvkljcGTWOLJz6LKPZ%0ABDLy6vCDGnqa00ZyhqQ%3D";
//	
//	private final static String privateKey = "MIIBVQIBADANBgkqhkiG9w0BAQEFAASCAT8wggE7AgEAAkEAxHfGAefBnnACf+1YOixGPtjCMWZfShI4Uxk9FmobKtdqlCDAjxP6EgcMnHvbo37Su+NGJZqq63naqBvaOfkKBQIDAQABAkEAkLUjm92mx9r6jF02AcsAhmPDTP15LCaVY+eQDgVjMz6i4G8YfrsZBejOuQvNpHnQUoDawpdPeTbm7JIVwjOR1QIhAOYH9H+UeTUMnJqFaBO0sv4ej0e8o3c0My5eAmhOY1yzAiEA2qXR+X15JGGjKtm4NCRHS2dOi7ok7s0F9dWZiTuBSmcCIQC7OUxSLqk8eUhZKC3epBtvY7YgoDO4CP+DRLbW6L5MqwIgU+7vyfx2spagkmR9p9Z9X97Kci0E3H7r2NEkXV/wY+UCIEcOxuzPJ+Jg0fEX/gopCM3mzd0u0ZaTzj/nwdPBjTve";
//	private final static String cheguoPublickey="MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAMR3xgHnwZ5wAn/tWDosRj7YwjFmX0oSOFMZPRZqGyrXapQgwI8T+hIHDJx726N+0rvjRiWaqut52qgb2jn5CgUCAwEAAQ==";
	
	public static void main(String[] args) throws Exception{
		Map<String,String> param = new HashMap<String,String>();
		param.put("userID", "1001");
//		param.put("cellPhone", "15200000000");
//		param.put("ownerName", "张三");
//		param.put("certificateNo", "41302719520203125X");
//		param.put("vehicleLicencePlateNo", "浙A12254");//车辆号牌
//		param.put("vehicleFrameNo", "xxxx");//车辆发动机号
//		param.put("vehicleEngineNo", "#####");//车辆品牌型号
//		
//		System.out.println(com.alibaba.fastjson.JSON.toJSONString(param));
//		String encryptData = encrypt(com.alibaba.fastjson.JSON.toJSONString(param), publickey);
//		System.out.println(encryptData);
//		System.out.println(URLEncoder.encode(encryptData, "UTF-8"));
//		String url="http://c.itest3.zhongan.com/open/activity/GoAuto";
//		String paramStr = "business_id=100003&bizContent=";
//		paramStr += URLEncoder.encode(encryptData, "UTF-8");
//		
//		System.out.println(url+"?"+paramStr);
		
		
//		String bizContent = "n%252Fj3o7uqMP3fZLK%252Frwu03%252F5iBp2N7zK0xPAYWQYgx4f9u2V7XnenCIou8waTi6mrBYY1OWRnm1pH%250A251ZfzqhpV7JE7PzjVfZcz1Kf6btPkifFoElBm8hpHaKOrrgE262a8RQZxSX92LRZ7Ik0eEFz%252F7N%250A5NH%252FHL%252FFczfQLUNTOXY%253D";
//		System.out.println(URLDecoder.decode(bizContent, "utf-8"));
		
//		System.out.println(HttpClientUtil.sendGet(url, paramStr, "UTF-8"));
//		String result = "{\"recipienterPhone\":\"WnPOURioEbuI5sW4RL23NhMmBGFDpfAMBeV7+Hbt4QDX5UYODX1SCn89wyufHUdc9XH8wCCve1i8tBDPsDnB8g==\",\"userID\":\"ZY1TU7pV1iIio318dOvOWoFF0Hr5l70e8p9P5du4dDXbO9Qj/ki8wNSgEn6adl7T8FNKT5TIRevmXTudkBirsw==\",\"compelPremiumInterval\":\"AKFta/84kIjnJrbpKuXAzZl7hjpKS5hxP8AJ9lUV/wmHtJNvVEGWcbTjKVcw4x08hpxVznyvj96zdkRJSWLBVg==\",\"businessPolicyNo\":\"qqLsmHxehoXXaYDDNnPfKluMEhIzwfyxduE6SxRRmF2upQfH77U10i1ecQWhHkDnMNFBOvuy2Ie+CzniPL4gxQ==\",\"recipienterName\":\"QJL65S8v+wto8sC94FZOi/btLKJq/fiRkLca9G2R5Q/AUJhaBQHlI5Fmu/KelqMEfhbU1fJnftSLW8Al7crUTw==\",\"businessPremiumInterval\":\"tiFp04mUEp26k9PHvQQXG+HBmJmPkmuLYccfsmQnabvh5zvav9q85HDYpCJ3+arDYpIVlV6FjUQUEvSDLQLNFA==\",\"compelPolicyNo\":\"vs5c7KNczokp6dvkJXXnTMN5qjZ9ThDNlSEXnDBjY6SuoH7gWmAPgTT1QVmcu530MOzZesfhMcqzliwP+9+ryg==\",\"recipienterAddress\":\"ovyybeklry8Km2wtVchuBDc/tMVql9zLe4huiVgZGpEVps5Mbn8+wUABBpLGxFc845o+uW0YOOCMBtVmPz7Efw==\"}";
//		JSONObject callbackData = JSONObject.parseObject(result);
//		System.out.println("userID:" + decrypt(callbackData.getString("userID"), privateKey));
//		System.out.println("businessPremiumInterval:" + decrypt(callbackData.getString("businessPremiumInterval"), privateKey));
//		System.out.println("compelPolicyNo:" + decrypt(callbackData.getString("compelPolicyNo"), privateKey));
//		System.out.println("businessPolicyNo:" + decrypt(callbackData.getString("businessPolicyNo"), privateKey));
//		System.out.println("compelPremiumInterval:" + decrypt(callbackData.getString("compelPremiumInterval"), privateKey));
//		System.out.println("recipienterName:" + decrypt(callbackData.getString("recipienterName"), privateKey));
//		System.out.println("recipienterPhone:" + decrypt(callbackData.getString("recipienterPhone"), privateKey));
//		System.out.println("recipienterAddress:" + decrypt(callbackData.getString("recipienterAddress"), privateKey));
//		System.out.println(HttpClientUtil.sendPostForStream("http://10.10.14.251:8084/carinsurance/callback", result, "utf-8"));
		
		
	    KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");  
	    generator.initialize(512, new SecureRandom());  
	    KeyPair pair = generator.generateKeyPair();  
	    PublicKey pubKey = pair.getPublic();  
	    PrivateKey privKey = pair.getPrivate();  
	    byte[] pk = pubKey.getEncoded();  
	    byte[] privk = privKey.getEncoded();
		sun.misc.BASE64Encoder encoder = new sun.misc.BASE64Encoder();
	    String strpk = new String(encoder.encode(pk)); 
	    String strprivk = new String(encoder.encode(privk));  
//	    
	    System.out.println("公钥:" + strpk);  
	    System.out.println("私钥:" + strprivk); 
//	    sun.misc.BASE64Decoder decoder = new sun.misc.BASE64Decoder();
//	    
//	    X509EncodedKeySpec pubX509 = new X509EncodedKeySpec(decoder.decodeBuffer(strpk));  
//	    PKCS8EncodedKeySpec priPKCS8 = new PKCS8EncodedKeySpec(decoder.decodeBuffer(strprivk));  
//	  
//	    KeyFactory keyf = KeyFactory.getInstance("RSA");  
//	    PublicKey pubkey2 = keyf.generatePublic(pubX509);  
//	    PrivateKey privkey2 = keyf.generatePrivate(priPKCS8);  
//	  
//	    System.out.println(pubKey.equals(pubkey2));  
//	    System.out.println(privKey.equals(privkey2));  
	}
}
