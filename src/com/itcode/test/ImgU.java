package com.itcode.test;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

/**     
 * @author: 成都码到功成学员 
 * @Description: 
 * 
 */
public class ImgU {
	private ImgU() {
		
	}
	public static Image getImg(String path) {
		BufferedImage bi = null;
		URL u =null;
		try {
			u= ImgU.class.getClassLoader().getResource(path);
			bi = ImageIO.read(u);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bi;
	}
}
