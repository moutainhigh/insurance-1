package com.yundian.file.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.imageio.ImageIO;

import org.apache.log4j.Logger;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

public class WaterMarksUtils {

    private static final Logger LOGGER = Logger.getLogger(WaterMarksUtils.class);
   // private final static Font FONT;
    
//    
//    static {
//        ResourceLoader loader = new DefaultResourceLoader();
//        Resource resource = loader.getResource("classpath:/META-INF/SIMHEI.TTF");
//        URL url = null;
//        try {
//            url = resource.getURL();
//        } catch (IOException e) {
//            LOGGER.error("Error:加载字体文件失败", e);
//            //throw new RuntimeException(e);
//        }
//        //UploaderController.class.getResource("/META-INF/MSYH.TTC")
//        FONT = loadFont(url, 22);
//    }
    
	  /**
     * 给图片添加水印、可设置水印图片旋转角度
     *
     * @param iconPath
     *            水印图片路径
     * @param srcImgPath
     *            源图片路径
     * @param targerPath
     *            目标图片路径
     * @param degree
     *            水印图片旋转角度
     */
    static {
        ImageIO.setUseCache(false);
    }

    public static byte[] markImageByIcon(String[] waterMarks, InputStream srcImgIs, int alpha) {
        if (waterMarks == null) { // 不打水印
            return is2Byte(srcImgIs);
        }
        long start = System.currentTimeMillis();
        ByteArrayOutputStream os = null;
        try {
            Image srcImg = ImageIO.read(srcImgIs);
            if (srcImg == null) { // 非图片格式
                return is2Byte(srcImgIs);
            }
            BufferedImage buffImg = new BufferedImage(srcImg.getWidth(null), srcImg.getHeight(null),
                    BufferedImage.TYPE_INT_RGB);
            // 得到画笔对象
            // Graphics g= buffImg.getGraphics();
            Graphics2D g = buffImg.createGraphics();

            // 设置对线段的锯齿状边缘处理
            g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);

            g.drawImage(srcImg.getScaledInstance(srcImg.getWidth(null), srcImg.getHeight(null), Image.SCALE_SMOOTH), 0,
                    0, null);

			/*
			 * if (null != degree) { // 设置水印旋转 g.rotate(Math.toRadians(degree),
			 * (double) buffImg.getWidth() / 2, (double) buffImg.getHeight() /
			 * 2); }
			 */
			/*
			 * // 水印图象的路径 水印一般为gif或者png的，这样可设置透明度 ImageIcon imgIcon = new
			 * ImageIcon(iconPath); // 得到Image对象。 Image img =
			 * imgIcon.getImage(); float alpha = 0.2f; // 透明度
			 * g.setComposite(AlphaComposite.getInstance(AlphaComposite.
			 * SRC_ATOP, alpha)); // 表示水印图片的位置 g.drawImage(img, 150, 300, null);
			 * g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER
			 * ));
			 */

            g.setColor(new Color(0, 0, 0, alpha));
            // FontMetrics fm = sun.font.FontDesignMetrics.getMetrics(font);
           // g.setFont(FONT); // new
            // Font("微软雅黑",
            // java.awt.Font.PLAIN,
            // 22)
            g.fillRect(0, 0, buffImg.getWidth(), (g.getFontMetrics().getHeight() + 10) * waterMarks.length);
            g.setColor(Color.WHITE);
            for (int i = 0; i < waterMarks.length; i++) {
                g.drawString(waterMarks[i], 20, 30 + i * (g.getFontMetrics().getHeight()));
            }

            g.dispose();
            os = new ByteArrayOutputStream();
            // 生成图片
            ImageIO.write(buffImg, "JPG", os);
            return os.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != os)
                    os.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            LOGGER.debug("水印时间:" + (System.currentTimeMillis() - start));
        }
        return null;
    }

    private static byte[] is2Byte(InputStream is) {
        byte[] b = null;
        try {
            b = new byte[is.available()];
            is.read(b);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return b;
    }
    

    private static Font loadFont(URL fontUrl, float fontSize) { // 第一个参数是外部字体，第二个是字体大小
        try {
            File file = new File(fontUrl.getPath());
            FileInputStream aixing = new FileInputStream(file);
            Font dynamicFont = Font.createFont(Font.TRUETYPE_FONT, aixing);
            Font dynamicFontPt = dynamicFont.deriveFont(fontSize);
            aixing.close();
            return dynamicFontPt;
        } catch (Exception e) {// 异常处理
            LOGGER.error("Error", e);
            return new java.awt.Font("宋体", Font.PLAIN, 22);
        }
    }
}
