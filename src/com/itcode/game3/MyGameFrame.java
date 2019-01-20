package com.itcode.game3;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import com.itcode.util.ImageUtil;

/**     
 * @author: 成都码到功成学员 
 * @Description: 
 * 项目名：J20飞机游戏
 * 作用：游戏窗口
 * 版本：ImageIO实现图片加载技术(0.3版)
 * 本节目标：加载图片
 */
public class MyGameFrame extends JFrame {
	
	/*
	 *  画出整个窗口及内部内容。被系统自动调用。
	 *  相当于画笔，可以一直画。
	 *  记住是在我们执行打开的标题为"成都码到功成学员作品"的窗口里面画。
	 * 
	 * 问题：
	 * 			1.java paint方法一执行就黑屏
	 * 			原因：setVisible(true) 窗口可见. 这个时候已经自动调用了paint函数
	 * ,setSize()改变了窗口的大小,. 又回自动调用paint函数, paint函数会默认清空之前的绘制. 所以全黑了。
	 * 			解决：
	 * 			1.paint方法里添加上这行代码"super.paint(g);", 表示再原有基础上重绘。
	 * 			2.把可视化,移动到设置大小和位置的后面
	 * 				this.setSize(500, 500); // 窗口大小
	 *				this.setLocation(300, 300); // 窗口位置，坐标轴。
	 *			//		this.setVisible(true); 
	 * 
	 *         
	 */
	
	// 加载图片
	Image aircraft = ImageUtil.getImage("img/plane.png");
	
	
	public void paint(Graphics g) {// 相当于一只画笔，系统自动调用
		super.paint(g);
		// 获老颜色
		Color c = g.getColor();
		// 改变画笔颜色 这里注意：如果我们想在不同的操作使用不同颜色的画笔，请在修改颜色之前保存老颜色。操作完之后记得改回原来的颜色。
		g.setColor(Color.RED);
		// 字体设置也类似就不用讲了。
		Font f = g.getFont();
		// java paint方法一执行就黑屏 1.添加上这行代码, 表示再原有基础上重绘
		// 画直线 以窗口左上角为原点，画一条从(100,100)到(400, 400)直接的直线。
		g.drawLine(100, 100, 400, 400);
		// 画矩形 在窗口的(100,100)位置，画一个长宽都为300大小的矩形。
		g.drawRect(100, 100, 300, 300);
		// 画椭圆 在窗口的(100,100)位置，画一个以圆的外切矩形长宽都为300的椭圆
		g.drawOval(100, 100, 300, 300);
		// 画实心矩形 在窗口的(100,100)位置，画一个长宽都为45大小的实心矩形。
		g.fillRect(100, 100, 45, 45);
		// 宋体 加粗 50大小
		g.setFont(new Font("宋体", Font.BOLD, 50));
		// 任意位置显示字 在窗口的(250,250)位置，显示"码到功成"。
		g.drawString("码到功成", 250, 250);
		// 第一个位置是图片路径，第三第四个值为坐标轴x,y值，最后一个不用管它，直接为空。
		g.drawImage(aircraft, 250, 250, null);
		
		// 还原老颜色
		g.setColor(c);
		g.setFont(f);
	}

	// 初始化窗口
	public void lauchWin() {
		
		this.setTitle("成都码到功成学员作品");
		this.setVisible(true); // 是否可见
		this.setSize(500, 500); // 窗口大小
		this.setLocation(300, 300); // 窗口位置，坐标轴。
		// 是否可见   java paint方法一执行就黑屏 2. 把可视化,移动到设置大小和位置的后面
//		this.setVisible(true); 
		
		// 添加窗口监听，目的：关闭窗口
		this.addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				System.out.println("游戏窗口关闭了");// 窗口关闭时在控制台输出
				System.exit(0);
			}
		});
	}
	public static void main(String[] args) {
		// 启动窗口
		MyGameFrame f = new MyGameFrame();
		f.lauchWin();
	}

}
