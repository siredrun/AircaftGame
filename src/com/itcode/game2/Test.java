package com.itcode.game2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import com.itcode.util.ImageUtil;

/**     
 * @author: 成都码到功成学员 
 * @Description: 
 * 
 */
public class Test extends JFrame{
	
	Image bg = ImageUtil.getImage("img/bg.jpg");
	Image plane = ImageUtil.getImage("img/plane.png");
	
	int planeX = 350;
	int planeY = 350;
	
	/**
	 * <p>Title: paint</p>  
	 * <p>Description: </p>  
	 * @param g  
	 * @see java.awt.Window#paint(java.awt.Graphics)  
	 */
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		g.drawImage(bg, 0, 0, null);
		g.drawImage(plane, planeX, planeY,null);
		planeX--;
	}
	
	class PaintThread extends Thread{
		/**
		 * <p>Title: run</p>  
		 * <p>Description: </p>    
		 * @see java.lang.Thread#run()  
		 */
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while (true) {
				System.out.println("重画");
				repaint();
				try {
					Thread.sleep(40);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	/**
	 * @Title: start  
	 * @Description: TODO(这里用一句话描述这个方法的作用)  
	 * @param     
	 * @return void   
	 * @throws 
	 */
	public void start() {
		// TODO Auto-generated method stub
		this.setTitle("234");
		this.setSize(700, 700);
		this.setLocation(300, 300);
		this.setVisible(true);
		
		this.addWindowListener(new WindowAdapter() {
			
			/**
			 * <p>Title: windowClosing</p>  
			 * <p>Description: </p>  
			 * @param e  
			 * @see java.awt.event.WindowAdapter#windowClosing(java.awt.event.WindowEvent)  
			 */
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				System.out.println("close");
				System.exit(0);
			}
		});
		
		new PaintThread().start();
	}
	
	public static void main(String[] args) {
		Test t = new Test();
		t.start();
	}
}
