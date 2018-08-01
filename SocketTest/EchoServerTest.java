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
			//서버소켓은 단순하게 접속 여부만 판단을 하게됩니다.
			ssk = new ServerSocket(port);
			System.out.println("접속 대기중");
			
			//소켓에 접속이 발생하게 되면 accept가 호출 됩니다.
			sk = ssk.accept();
			System.out.println(sk.getLocalPort() +"포트 "+sk.getInetAddress() + "에서 접속이 되었습니다.");
			
			//클라이언트에서 전달되는 메세지를 받기 위해서  소켓에서 제공 되는 getInputStream을 InputStream 객체를
			//통해서 인스턴스를 생성합니다. 그 후 InputStream 으로 전달 받은 값이 "스트링"이키 때문에
			//InputStreamReader를 통해서 새로운 객체를 InputStreamReader 객체를 생성하고 
			//생성한 스트림을 BufferedReader를 통해 버퍼에 담습니다.
			InputStream ins = sk.getInputStream();
			InputStreamReader inR = new InputStreamReader(ins);
			BufferedReader bffR = new BufferedReader(inR);
			
			
			//클라이언트로 값을 전송하기 위한 스트림을 만든다.
			//값을 클라이언트로 전송하기 위하여 PrintWriter 객체를 만들고 인자 값을 넣어준다.
			OutputStream out = sk.getOutputStream();
			PrintWriter pout = new PrintWriter(out, true); //true 하면 플러시 기능을 제공한다.
			pout.println("Hello Java.");
			
			
			//클라이언트로 부터 값이 전송되는 것을 계속 파악하며 그 값을 파악하고 해당 답변에 따라서 결과를 전달한다.
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
