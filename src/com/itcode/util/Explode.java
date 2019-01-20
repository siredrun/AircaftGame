package com.itcode.util;

import java.awt.Graphics;
import java.awt.Image;

/**     
 * @author: 成都码到功成学员 
 * @Description: 
 * 
 */
public class Explode {

	// 建立两个变量，图片的位置定位。
	double x;
	double y;
	
	// 建立一个静态的大小照片数组，存储16张图片。一次性加载，无需多次运行。
	static Image[] imgs = new Image[16];
	
	// 循环找出16张图片
	static {
		for(int i=0; i< 16; i++) {
			imgs[i] = ImageUtil.getImage("img/explode/e" + (i+1) +".gif");
			imgs[i].getWidth(null);
			imgs[i].getHeight(null);
		}
	}
	// 画图的计数
	int count;
	
	public void draw(Graphics g) {
		if(count <= 15) {
			g.drawImage(imgs[count], (int)x, (int)y, null);
			count++;
		}
	}

	/**
	 * 创建一个新的实例 Explode.
	 * @param x
	 * @param y
	 */
	public Explode(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	
}
