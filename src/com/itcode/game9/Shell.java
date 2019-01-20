package com.itcode.game9;

import java.awt.Color;
import java.awt.Graphics;

import com.itcode.util.Constant;

/**     
 * @author: 成都码到功成学员 
 * @Description: 
 * 炮弹类
 */
public class Shell extends BaseObject {

	// 角度是degrees，不是degree
	double degrees;

	/**
	 * 创建一个新的实例 Shell.
	 */
	public Shell() {
		// 炮弹初始位置，大小，速度设定
		x = 200;
		y = 200;
		weight = 15;
		height = 15;
		speed = 4;
		//随机角度 360= 2π，不太明白的去看初中数学。以后一般不是游戏开发的话用到的数学知识不多，没必要去深究。
		degrees = Math.random()*Math.PI*2;
	}
	
	public void paintShell(Graphics g) {
		// 设置炮弹颜色，之前讲过颜色改变用完之后要还原颜色。
		Color c = g.getColor();
		g.setColor(Color.CYAN);
		// 画实心圆
		g.fillOval((int)x, (int)y, weight, height);
		// 炮弹随机角度移动。X轴的值等于速度乘角度，Y轴也一样。X轴加Y轴的值就构成炮弹的新位置。
		x += speed*Math.cos(degrees);
		y += speed*Math.sin(degrees);
		
		
		/*
		 *  关于顶边标题栏也算游戏窗口内，所以我们要减去它的高度，
		 *  高度是多少请自己运行慢慢调试，这里是40左右。
		 *  还有其它三边要减去球的宽高度。
		 */		
		if(x < 0 || x >Constant.WIN_WIDTH-weight) {// 边界检测
			degrees = Math.PI - degrees; // 碰到边界反转。
		}
		if(y < 40 || y >Constant.WIN_HEIGHT-height) {// 边界检测
			degrees = - degrees; // 碰到边界反转。
		}
		
		g.setColor(c);
	}	
	
}
