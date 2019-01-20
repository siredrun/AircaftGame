package com.itcode.game5;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;

/**     
 * @author: 成都码到功成学员 
 * @Description: 
 * 飞机类，继承BaseObject
 */
public class AirPlane extends BaseObject {
	
	/**
	 * <p>Title: paintSelt</p>  
	 * <p>Description: </p>  
	 * @param g  
	 * @see com.itcode.game5.BaseObject#paintSelt(java.awt.Graphics)  
	 */
	@Override
	public void paintSelt(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(img, (int)x, (int)y, null);
	}

	// 构造器
	public AirPlane(Image img, double x, double y) {
		this.img = img;
		this.x = x;
		this.y = y;
	}
	
}
