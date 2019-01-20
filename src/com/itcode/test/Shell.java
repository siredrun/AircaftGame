package com.itcode.test;

import java.awt.Color;
import java.awt.Graphics;

import com.itcode.util.Constant;

/**     
 * @author: 成都码到功成学员 
 * @Description: 
 * 角度 画自己  构造
 */
public class Shell extends BaseO{

	double e;
	public Shell() {
		x=200;
		y=200;
		speed=5;
		weight=15;
		height=15;
		e=Math.random()*Math.PI*2;
	}
	public void paintShell(Graphics g) {
		Color c = g.getColor();
		g.setColor(Color.blue);
		g.fillOval((int)x, (int)y, weight, height);
		x+=speed*Math.cos(e);
		y+=speed*Math.sin(e);
		if(x<0||x>Constant.WIN_WIDTH-weight) {
			e=Math.PI-e;
		}
		if(y<40||y>Constant.WIN_HEIGHT-height) {
			e=-e;
		}
		g.setColor(c);
	}
}
