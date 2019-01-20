package com.itcode.test;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;

import com.itcode.util.Constant;
/**     
 * @author: 成都码到功成学员 
 * @Description: 
 * 
 */
public class Test extends Frame{
	private Image buffer;
	public void update(Graphics g) {
		if(buffer==null) {
			buffer=this.createImage(Constant.WIN_WIDTH, Constant.WIN_HEIGHT);
		}
		paint(buffer.getGraphics());
		g.drawImage(buffer, 0, 0, null);
	}
	Image planeI = ImgU.getImg("img/plane.png");
	Image bg = ImgU.getImg("img/bg.jpg");
	Plane plane = new Plane(planeI, 350, 350);
	Shell[] s = new Shell[60];
	Explode boom;
	Date a =new Date();
	Date b;
	int ab;
	public void paint(Graphics g) {
		Color c = g.getColor();
		g.drawImage(bg, 0, 0, null);
		plane.paintSelf(g);
		for(int i=0;i<s.length;i++) {
			s[i].paintShell(g);
			boolean touch = plane.getRec().intersects(s[i].getRec());
			if(touch) {
				plane.live = false;
				if(boom==null) {
					boom=new Explode(plane.x, plane.y);
					b=new Date();
					ab=(int)((b.getTime()-a.getTime()))/1000;
				}
				boom.draw(g);
			}
			if(!plane.live) {
				g.setColor(Color.red);
				g.setFont(new Font("黑体", Font.BOLD, 60));
				g.drawString("存活："+ab+"秒", Constant.WIN_WIDTH/2, Constant.WIN_HEIGHT/2);
			}
		}
		g.setColor(c);
	};
	class PaintThread extends Thread{
		@Override
		public void run() {
			while(true) {
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
	class KeyMoniter extends KeyAdapter{
		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			plane.yes(e);
		}
		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			plane.no(e);
		}
	}
	public void startW() {
		this.setTitle("32");
		this.setVisible(true);
		this.setLocation(300, 300);
		this.setSize(Constant.WIN_WIDTH, Constant.WIN_HEIGHT);
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		
		for(int i=0;i<s.length;i++) {
			s[i]=new Shell();
		}
		new PaintThread().start();
		this.addKeyListener(new KeyMoniter());
	}
	public static void main(String[] args) {
		new Test().startW();
	}
}
