package SocketTest;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;


public class BarThreadEx extends JFrame{
	
	MyBar bar = new MyBar(100);
	
	public BarThreadEx(String title) {
		super(title);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container cp = getContentPane();
		cp.setLayout(null);
		
		bar.setBackground(Color.yellow);
		bar.setOpaque(true);
		bar.setLocation(20,50);
		bar.setSize(300,20);
		cp.add(bar);
		
		cp.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent ke) {
				bar.fill();
			}
		});
		
		
		
		
		setSize(350,200);
		setVisible(true);
		
		cp.requestFocus();
		EraserThread th = new EraserThread(bar);
		th.start();
		
		
	}
	
	
	class EraserThread extends Thread{
		MyBar bar;
		public EraserThread(MyBar bar) {
			this.bar = bar;
		}
		
		public void run() {
			while(true) {
				try {
					sleep(200);
					bar.erase();
				} catch (InterruptedException e) {
					return;
				}
			}
		}
		
	}
	
	
	
	
	
	public static void main(String[] args) {
		new BarThreadEx("키보드 누르기.");
	}
}





//내가 공부하지 않은 부분입니다.
class MyBar extends JLabel{
	int barSize = 0;
	int maxBarSize;
	
	public MyBar(int maxBarSize) {
		this.maxBarSize = maxBarSize;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.RED);
		int width = (int)(((double)(this.getWidth()))/maxBarSize*barSize);
		
		if(width==0) {
			return;
		}
		
		g.fillRect(0, 0, width, this.getHeight());
	}
	
	synchronized public void fill() {
		if(barSize == maxBarSize) {
			try {
				wait(); // 이벤트 쓰레드를 대기
			} catch (InterruptedException e) {
				return;
			} 
		}
		barSize++;
		repaint();
		notify();
	}
	
	synchronized public void erase() {
		if(barSize == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				return;
			}
		}
		barSize--;
		repaint();
		notify();
	}
	
	
}
