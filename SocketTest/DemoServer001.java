package SocketTest;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class DemoServer001 {
	public static void main(String[] args) throws IOException {
		//서버입니다.
		int port = 5049;
		
		int number = Integer.parseInt(args[0]);
		String str = new String(args[1]);
		
		//서버소켓 생성
		ServerSocket ssk = new ServerSocket(port); //클라이언트가 접속했는지 안했는지만 판단을 합니다.-> accept() 실행됨.
		System.out.println("접속대기중.");
		
		while(true) {
			Socket socket = ssk.accept();
			System.out.println("클라이언트 ip : "+socket.getInetAddress().getHostAddress());
			
			//클라이언트와 연결을 위한 스트림을 생성.
			OutputStream ous = socket.getOutputStream();
			DataOutputStream dous = new DataOutputStream(ous);
			dous.writeInt(number);
			dous.writeUTF(str);
			dous.flush();
			dous.close();
			socket.close();
		}
	}
}
