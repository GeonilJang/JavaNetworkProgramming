package SocketTest;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class DemoServer001 {
	public static void main(String[] args) throws IOException {
		//서버입니다.
		int port = 5052;
		
		//서버소켓 생성
		ServerSocket ssk = new ServerSocket(port); //클라이언트가 접속했는지 안했는지만 판단을 합니다.
		System.out.println("접속대기중.");
		
		while(true) {
			Socket socket = ssk.accept();
			System.out.println("클라이언트 ip : "+socket.getInetAddress().getHostAddress());
		}
		
		
		
		
		
	}
}
