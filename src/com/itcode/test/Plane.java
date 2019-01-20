package com.itcode.test;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;

/**     
 * @author: 成都码到功成学员 
 * @Description: 
 * 
 */
public class Plane extends BaseO {
	int speed=5;
	boolean left,up,right,down;
	public boolean live=true;
	
	/**
	 * 创建一个新的实例 Plane.
	 * @param img
	 * @param x
	 * @param y
	 */
	public Plane(Image img, double x, double y) {
		this.x=x;
		this.y=y;
		this.img=img;
		this.weight=img.getWidth(null);
		this.height =img.getHeight(null);
	}
	@Override
	public void paintSelf(Graphics g) {
		// TODO Auto-generated method stub
		if(live) {
			g.drawImage(img, (int)x, (int)y, null);
			if(left) {
				x-=speed;
			}
			if(right) {
				x+=speed;
			}
			if(up) {
				y-=speed;
			}
			if(down) {
				y+=speed;
			}
		}
	}
	public void yes(KeyEvent e) {
		switch(e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			left=true;
			break;
		case KeyEvent.VK_UP:
			up=true;
			break;
		case KeyEvent.VK_RIGHT:
			right=true;
			break;
		case KeyEvent.VK_DOWN:
			down=true;
			break;
		}
	}
	public void no(KeyEvent e) {
		switch(e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			left=false;
			break;
		case KeyEvent.VK_UP:
			up=false;
			break;
		case KeyEvent.VK_RIGHT:
			right=false;
			break;
		case KeyEvent.VK_DOWN:
			down=false;
			break;
		}
	}
	
}
