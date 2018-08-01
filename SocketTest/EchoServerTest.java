package SocketTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class EchoServerTest {
	public static void main(String[] args) {
		
		int port = 7080;
		ServerSocket ssk = null;
		Socket sk = null;
		
		try {
			ssk = new ServerSocket(port);
			System.out.println("접속 대기중");
			sk = ssk.accept();
			System.out.println(sk.getLocalPort() +"포트 "+sk.getInetAddress() + "에서 접속이 되었습니다.");
			
			
			InputStream ins = sk.getInputStream();
			InputStreamReader inR = new InputStreamReader(ins);
			BufferedReader bffR = new BufferedReader(inR);
			
			//클라이언트와 통신하기위한 스트림을 생성
			//OutputStream 은 단순한 브릿지 역할을 한다.
			OutputStream out = sk.getOutputStream();
			PrintWriter pout = new PrintWriter(out, true); //true 하면 플러시 기능을 제공한다.
			pout.println("Hello Java.");
			
			String clientMsg = "";
			while((clientMsg = bffR.readLine()) != null) {
				if(clientMsg.startsWith("안녕") || clientMsg.startsWith("하이")) {
					pout.println(sk.getInetAddress()+"님 반갑습니다.");
				}else if(clientMsg.startsWith("오늘은 몇일")) {
					Date today = new Date();
					pout.println("오늘은 : "+today);
				}else {
					pout.println(sk.getInetAddress()+"님 빠이~");
				}
			}
			
			
			out.close();
			sk.close();
			ssk.close();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
}
