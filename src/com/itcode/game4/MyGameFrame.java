package com.itcode.game4;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

import com.itcode.game5.AirPlane;
import com.itcode.util.ImageUtil;

/**     
 * @author: 成都码到功成学员 
 * @Description: 
 * 项目名：J20飞机游戏
 * 作用：游戏窗口
 * 版本：多线程和内部类实现动画效果(0.4版)
 * 本节目标：让飞机动起来
 */
public class MyGameFrame extends JFrame{
	
	// 获取图片
	Image plane = ImageUtil.getImage("img/plane.png");
	Image bg = ImageUtil.getImage("img/bg.jpg");
	
	int aircraftX = 350;
	int aircraftY = 350;
	/**
	 * <p>Title: paint</p>  
	 * <p>Description: 加载图片</p>  
	 * @param g  
	 * @see java.awt.Window#paint(java.awt.Graphics)  
	 */
	@Override
	public void paint(Graphics g) {// 相当于一只画笔，系统自动调用
		// TODO Auto-generated method stub
		super.paint(g);
		g.drawImage(bg, 0, 0, null);		
		g.drawImage(plane, aircraftX, aircraftY, null);
		
		// 让飞机向右移动。
		aircraftX++;
		
	}
	
	// 反复重画窗口 利用while死循环的原理。
	class PaintThread extends Thread {
		
		/**
		 * <p>Title: run</p>  
		 * <p>Description: </p>    
		 * @see java.lang.Thread#run()  
		 */
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(true) {
				repaint();// 调用重载的repaint方法，作用是一直画图，不要停。
				try {
					System.out.println("窗口被画了一次");// 画一次输出一次
					Thread.sleep(40);// 1秒等于1000毫秒，这里单位是毫秒。表示线程每秒钟运行25次。
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	// 初始化窗口
	public void lauchWin() {
		
		this.setTitle("成都码到功成学员作品");
		this.setVisible(true); // 是否可见
		this.setSize(700, 700); // 窗口大小
		this.setLocation(300, 300); // 窗口位置，坐标轴。
		// 是否可见   java paint方法一执行就黑屏 2. 把可视化,移动到设置大小和位置的后面
//			this.setVisible(true); 
		
		// 添加窗口监听，目的：关闭窗口
		this.addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				System.out.println("游戏窗口关闭了");// 窗口关闭时在控制台输出
				System.exit(0);
			}
		});
		
		// 启动画窗口的线程
		new PaintThread().start();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyGameFrame f = new MyGameFrame();
		f.lauchWin();
	}

}
