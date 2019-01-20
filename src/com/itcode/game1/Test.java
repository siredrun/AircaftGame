package com.itcode.game1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

/**     
 * @author: 成都码到功成学员 
 * @Description: 
 * 
 */
public class Test extends JFrame{
	
	public void startWin() {
		// TODO Auto-generated method stub
		this.setTitle("练习");
		this.setVisible(true);
		this.setLocation(100, 100);
		this.setSize(500, 500);
		
		this.addWindowListener(new WindowAdapter() {
			
			/* (non-Javadoc)
			 * @see java.awt.event.WindowAdapter#windowClosing(java.awt.event.WindowEvent)
			 */
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				System.out.println("dfs");
				System.exit(0);
			}
		});
	}
	
	public static void main(String[] args) {
		Test t = new Test();
		t.startWin();
	}
}
