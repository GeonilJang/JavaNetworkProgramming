package MulChat;

import java.applet.Applet;
import java.awt.Graphics;

public class AppletLifeCycle extends Applet{
	
		/* ���ø��� 5�� �޼ҵ尡 �ֽ��ϴ�.
		
		init();  //�ʱ�ȭ ��ƾ
		
		��
		
		start();
		
		��
		
		stop();
		
		��
		
		destroy();
		
		��
		
		paint();
		
		
		*/
		
		public String state ="";
		
		public void init() {
			state += "init, ";
		}
		
		public void start() {
			state += "start, ";
		}
		
		public void stop() {
			state +="stop, ";
		}
		
		public void destroy() {
			state +="destroy, ";
		}
		
		public void paint(Graphics g) {
			state +="paint, ";
			g.drawString(state, 50, 50);
		}
		
		
		

}
