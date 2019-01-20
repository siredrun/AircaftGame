package com.itcode.game8;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

/**     
 * @author: 成都码到功成学员 
 * @Description: 
 * 基础父类
 */
public class BaseObject {
	
	// 图片
	Image img;
	// 坐标轴x,y
	double x;
	double y;
	// 速度
	int speed;
	// 宽高
	int weight;
	int height;
	
	// 构造方法
	/**
	 * 创建一个新的实例 BaseObject.
	 */
	public BaseObject() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 创建一个新的实例 BaseObject.
	 * @param img
	 * @param x
	 * @param y
	 */
	public BaseObject(Image img, double x, double y) {
		super();
		this.img = img;
		this.x = x;
		this.y = y;
	}
	
	/**
	 * 创建一个新的实例 BaseObject.
	 * @param img
	 * @param x
	 * @param y
	 * @param speed
	 * @param weight
	 * @param height
	 */
	public BaseObject(Image img, double x, double y, int speed, int weight, int height) {
		super();
		this.img = img;
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.weight = weight;
		this.height = height;
	}
	
	/**
	 * @Title: paintSelt  
	 * @Description: 画图方法
	 * @param     
	 * @return void   
	 * @throws 
	 */
	public void paintSelf(Graphics g) {
		// x,y的类型为double，所以我们要强转为int。
		g.drawImage(img, (int)x, (int)y, null);
	}

	// 获得矩形，用于碰撞检测，前面讲过游戏中任何物体都是矩形。
	public Rectangle getRec() {
		return new Rectangle((int)x, (int)y, weight, height);
	}
}
