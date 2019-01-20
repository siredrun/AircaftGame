package com.itcode.game1;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

/**     
 * @author: 成都码到功成学员 
 * @Description: 
 * 项目名：J20飞机游戏
 * 作用：游戏窗口
 * 版本：AWT技术画出游戏主窗口 0.1版
 * 本节目标：AWT技术画出游戏主窗口并关闭
 */
public class MyGameFrame extends JFrame {

	// 初始化窗口
	public void lauchWin() {
		
		this.setTitle("成都码到功成学员作品");
		this.setVisible(true); // 是否可见
		this.setSize(500, 500); // 窗口大小
		this.setLocation(300, 300); // 窗口位置，坐标轴。
		
		// 添加窗口监听，目的：关闭窗口
		this.addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				System.out.println("游戏窗口关闭了");// 窗口关闭在控制台输出
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
