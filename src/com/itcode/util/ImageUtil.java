package com.itcode.util;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

/**     
 * @author: 成都码到功成学员 
 * @Description: 
 * 此工具类是加载图片位置的工具类
 */
public class ImageUtil {

	/**
	 * 创建一个新的实例 ImageUtil.
	 * 工具类最好私有化构造器，保证安全性。
	 */
	private ImageUtil() {
		// TODO Auto-generated constructor stub
	}
	
	public static Image getImage(String path) {
		BufferedImage bi = null;
		
		URL u = null;
		try {
			u = ImageUtil.class.getClassLoader().getResource(path);
			bi = ImageIO.read(u);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bi;
		
	}
}
