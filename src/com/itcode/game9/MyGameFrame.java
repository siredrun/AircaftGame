package com.itcode.game9;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import com.itcode.test.Explode;
import com.itcode.test.Plane;
import com.itcode.util.Constant;
import com.itcode.util.ImageUtil;

/**     
 * @author: 成都码到功成学员 
 * @Description: 
 * 项目名：J20飞机游戏
 * 作用：游戏窗口
 * 版本：碰撞爆炸(0.9版)
 * 本节目标：
 * 飞机爆炸效果
 */
public class MyGameFrame extends Frame{
	/*
	 * 双缓冲解决闪烁
	 *	双缓冲：
	 *	1.在内存中定义与画布一致的缓冲区。
	 *	2.在缓冲区中画画。
	 *	3.把缓冲区的话复制到画布中。
	 *	4.清空缓冲区。
	 * */
	private Image bufferedImg;
	public void update(Graphics g) {
		if(bufferedImg == null) {
			bufferedImg = this.createImage(Constant.WIN_WIDTH, Constant.WIN_WIDTH);
		}
		paint(bufferedImg.getGraphics());
		g.drawImage(bufferedImg, 0, 0, null);
	}
	// 获取图片
	Image planeImg= ImageUtil.getImage("img/plane.png");
	Image bg = ImageUtil.getImage("img/bg.jpg");
	Plane plane = new Plane(planeImg, 350, 350);
	Shell[] shells = new Shell[60];
	Explode boom;
	
	@Override
	public void paint(Graphics g) {// 相当于一只画笔，系统自动调用
		// TODO Auto-generated method stub
		super.paint(g);
		g.drawImage(bg, 0, 0, null);
		// 画飞机 任意个
		plane.paintSelf(g);
		// 画出所有的炮弹
		for(int i=0; i<shells.length; i++) {
			shells[i].paintShell(g);
			// 飞机炮弹碰撞检测，intersects方法
			boolean touch = plane.getRec().intersects(shells[i].getRec());
			if(touch) {
				// 如果碰撞，飞机生命状态为空，
				plane.live = false;
				// 这儿先判断为空的原因是我们只要第一次飞机和炮弹碰撞发生爆炸
				// 如果不加，就会每次炮弹碰到飞机生命状态为空的位置都会发生爆炸。
				if(boom == null) {
					// 如果为空，就把飞机生命状态变为空的位置记下来
					boom = new Explode(plane.x, plane.y);
				}
				// 在此位置出画出爆炸效果。
				boom.draw(g);
			}
		}
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
					Thread.sleep(40);// 1秒等于1000毫秒，这里单位是毫秒。表示线程每秒钟运行25次。
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	// 监听键盘按下与松开
	class KeyMoniter extends KeyAdapter{
		// 监听键盘按下
		public void keyPressed(KeyEvent e) {
			plane.yes(e);
		}
		// 监听键盘松开
		public void keyReleased(KeyEvent e) {
			plane.no(e);
		}
	}
	
	// 初始化窗口
	public void lauchWin() {
		
		this.setTitle("成都码到功成学员作品");
		this.setVisible(true); // 是否可见
		this.setSize(Constant.WIN_WIDTH, Constant.WIN_HEIGHT); // 窗口大小
		this.setLocation(300, 300); // 窗口位置，坐标轴。
		// 是否可见   java paint方法一执行就黑屏 2. 把可视化,移动到设置大小和位置的后面
//			this.setVisible(true); 
		
		// 添加窗口监听，目的：关闭窗口
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		for(int i=0; i<shells.length;i++) {
			shells[i] = new Shell();
		}
		
		// 启动画窗口的线程
		new PaintThread().start();
		this.addKeyListener(new KeyMoniter());// 给窗口增加键盘监听
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyGameFrame f = new MyGameFrame();
		f.lauchWin();
	}

}
