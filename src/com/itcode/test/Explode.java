package com.itcode.test;

import java.awt.Graphics;
import java.awt.Image;

/**     
 * @author: 成都码到功成学员 
 * @Description: 
 * 
 */
public class Explode {

	double x,y;

	/**
	 * 创建一个新的实例 Explode.
	 * @param x
	 * @param y
	 */
	public Explode(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}
	static Image[] m = new Image[16];
	static {
		for(int i=0; i<16; i++) {
			m[i] = ImgU.getImg("img/explode/e" +(i+1) + ".gif");
			m[i].getHeight(null);
			m[i].getWidth(null);
		}
	}
	int count;
	public void draw(Graphics g) {
		if(count<16) {
			g.drawImage(m[count], (int)x, (int)y, null);
		}
		count++;
	}
}
