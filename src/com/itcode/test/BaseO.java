package com.itcode.test;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

/**     
 * @author: 成都码到功成学员 
 * @Description: 
 * 
 */
public class BaseO {

	Image img;
	public double x,y;
	int speed;
	int weight,height;
	/**
	 * 创建一个新的实例 BaseO.
	 * @param img
	 * @param x
	 * @param y
	 * @param speed
	 * @param weight
	 * @param height
	 */
	public BaseO(Image img, double x, double y, int speed, int weight, int height) {
		super();
		this.img = img;
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.weight = weight;
		this.height = height;
	}
	/**
	 * 创建一个新的实例 BaseO.
	 * @param img
	 * @param x
	 * @param y
	 */
	public BaseO(Image img, double x, double y) {
		super();
		this.img = img;
		this.x = x;
		this.y = y;
	}
	/**
	 * 创建一个新的实例 BaseO.
	 */
	public BaseO() {
		super();
	}
	public void paintSelf(Graphics g) {
		g.drawImage(img, (int)x, (int)y, null);
	}
	public Rectangle getRec() {
		return new Rectangle((int)x, (int)y, weight,height);
	}
}
