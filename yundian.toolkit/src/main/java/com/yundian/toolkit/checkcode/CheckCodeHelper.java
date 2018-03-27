package com.yundian.toolkit.checkcode;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.yundian.toolkit.utils.RandomUtil;

public class CheckCodeHelper {
	static Logger logger = Logger.getLogger(CheckCodeHelper.class);
	
	
	//验证码Session字段KEY值
	private static String CHKCode = "CGWcheckword";
	//定义验证码的宽度
	private static final int WIDTH = 80;
	
	//定义验证码的高度
	private static final int HEIGHT = 20;	
	
	//定义验证码图片背景色的颜色最小值
	private static  final int BGCOLORMIN = 200;
	
	//定义验证码图片背景色的颜色最大值
	private static final int BGCOLORMAX = 250;
	
	//定义验证码图片干扰颜色的颜色最小值
	private static final int FORCOLORMIN = 160;
	
	//定义验证码图片干扰颜色的颜色最大值
	private static final int FORCOLORMAX = 200;
	
	//验证码位数
	private static final int CHECKCODENUM = 4;
	
	//颜色的最大值
	private static final int COLORMAXVALUE = 255;
	
	//验证码的字体大小
	private static final int CHECKCODEFONTSIZE = 18;
		
	public static Object GetCheckCode(HttpServletRequest httpRequest)
	{
		return  httpRequest.getSession().getAttribute(CHKCode);
	
	}
	public static void GenerateCheckCode(HttpServletRequest httpRequest,
			HttpServletResponse httpResponse)
	{
		
				ServletOutputStream out = null;
				try {
					// 取得一个4位随机字母数字字符串
					httpResponse.setContentType("images/jpeg");
					httpResponse.setHeader("Pragma", "No-cache");
					httpResponse.setHeader("Cache-Control", "no-cache");
					httpResponse.setDateHeader("Expires", 0);
					out = httpResponse.getOutputStream();
					BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
					Graphics g = image.getGraphics();
					// 设定背景色
					g.setColor(getRandColor(BGCOLORMIN, BGCOLORMAX));
					g.fillRect(0, 0, WIDTH, HEIGHT);

					// 设定字体
					Font mFont = new Font("Times New Roman", Font.BOLD, CHECKCODEFONTSIZE);// 设置字体
					g.setFont(mFont);

					// 随机产生干扰线，使图象中的认证码不易被其它程序探测到
					g.setColor(getRandColor(FORCOLORMIN, FORCOLORMAX));
					// 生成随机类
					Random random = new Random();
					for (int i = 0; i < 155; i++) {
						int x2 = random.nextInt(WIDTH);
						int y2 = random.nextInt(HEIGHT);
						int x3 = random.nextInt(12);
						int y3 = random.nextInt(12);
						g.drawLine(x2, y2, x2 + x3, y2 + y3);
					}
					// 随即产生的4位随即数
					String randomCode = RandomUtil.generateValidateCode(CHECKCODENUM);
					httpRequest.getSession().setAttribute(CHKCode, randomCode);
					// 将认证码显示到图象中
					int x = WIDTH / (CHECKCODENUM + 1);
					for (int i = 0; i < CHECKCODENUM; i++) {
						String rand = randomCode.substring(i, i + 1);
						// 将认证码显示到图象中
						//验证码颜色
						int checkcodeColor = 20 + random.nextInt(110); 
						
						g.setColor(new Color(checkcodeColor, checkcodeColor, checkcodeColor));
						// 调用函数出来的颜色相同，可能是因为种子太接近，所以只能直接生成
						g.drawString(rand, (i + 1) * x - 6, 17);
					}
					// 图象生效
					g.dispose();
					// 输出图象到页面
					ImageIO.write((BufferedImage) image, "JPEG", out);
				} 
				catch (Exception e) {
					e.printStackTrace();
					logger.error("验证码出错");
				}
				finally{
					if (null != out) {
						try {
							out.close();
						} catch (IOException e) {
							e.printStackTrace();
							logger.error(e.getMessage());
						}
					}
				}
			}
	/**
	 * @Description: 给定范围获得随机颜色
	 * @param @param fc 颜色数
	 * @param @param bc 颜色数
	 * @return Color 返回类型
	 * @throws
	 */
	private static Color getRandColor(int fc, int bc) { // 给定范围获得随机颜色
		Random random = new Random();
		if (fc > COLORMAXVALUE)
			fc = COLORMAXVALUE;
		if (bc > COLORMAXVALUE)
			bc = COLORMAXVALUE;
		int r = fc + random.nextInt(bc - fc);
		int g = fc + random.nextInt(bc - fc);
		int b = fc + random.nextInt(bc - fc);
		return new Color(r, g, b);
	}
	
	/**
	 * @Description: 判断验证码 注：不区分大小写
	 * @param @param checkCode1 前台页面输入的验证码
	 * @param @param checkCode2 后台随即生成的验证码
	 * @return boolean 返回类型 false:前后输入不一致； true：输入正确
	 * @throws
	 */
	public static boolean checkCodeCompare(String checkCode1, String checkCode2) {
		boolean flag = false;
		if (null != checkCode1 || null != checkCode2) {
			if (checkCode1.toLowerCase().equals(checkCode2.toLowerCase()))
				flag = true;
		}
		return flag;
	}
	
}
