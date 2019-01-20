package com.itcode.game9;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;

/**     
 * @author: 成都码到功成学员 
 * @Description: 
 * 飞机类，继承BaseObject
 */
public class AirPlane extends BaseObject {
	// 移动距离
	int speed = 5;
	
	boolean left;
	boolean up;
	boolean right;
	boolean down;
	
	// 检测飞机是否活着。
	public boolean live = true;
	
	@Override
	public void paintSelf(Graphics g) {
		// 判断生命状态活着才画，没有活则打印“dead”
		if(live) {
			g.drawImage(img, (int)x, (int)y, null);
			// 判断方向并移动
			if(left) {
				x -= speed;
			}
			if(right) {
				x += speed;
			}
			if(up) {
				y -= speed;
			}
			if(down) {
				y += speed;
			}
		}else {
			
		}
	}

	// 构造器
	public AirPlane(Image img, double x, double y) {
		this.img = img;
		this.x = x;
		this.y = y;
		// 获取图片宽高
		this.weight = img.getWidth(null);
		this.height = img.getHeight(null);
	}
	
	// 按下某个键，确定方向
	public void confirmDirection(KeyEvent e) {
		
		switch(e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			left = true;
			break;
		case KeyEvent.VK_UP:
			up = true;
			break;
		case KeyEvent.VK_RIGHT:
			right = true;
			break;
		case KeyEvent.VK_DOWN:
			down = true;
			break;
		}
	}
	
	// 按下某个键，取消/改变方向
	public void cancelDirection(KeyEvent e) {
		System.out.println(e.getKeyCode());
		switch(e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			left = false;
			break;
		case KeyEvent.VK_UP:
			up = false;
			break;
		case KeyEvent.VK_RIGHT:
			right = false;
			break;
		case KeyEvent.VK_DOWN:
			down = false;
			break;
		}
	}
}
