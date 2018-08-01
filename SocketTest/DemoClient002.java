package SocketTest;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class DemoClient002 {
	public static void main(String[] args) throws Exception {
		
		//연결시에 소켓이 생성이 된다. 연결이 안될경우에는 예외 발생한다.
		Socket sk = new Socket("183.99.6.38",5052);
		System.out.println("서버와 접속 : 5050");
		
	}
}
