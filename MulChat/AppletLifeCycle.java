package MulChat;

import java.applet.Applet;
import java.awt.Graphics;

public class AppletLifeCycle extends Applet{
	
		/* 에플릿의 5개 메소드가 있습니다.
		
		init();  //초기화 루틴
		
		↓
		
		start();
		
		↓
		
		stop();
		
		↓
		
		destroy();
		
		↓
		
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
