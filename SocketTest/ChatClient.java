package SocketTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatClient implements Runnable{
	
	String ip = "183.99.6.38";
	int port = 6061;
	Socket sk;
	
	
	
	public ChatClient() {
		try {
			String sendMsg = "";
			sk = new Socket(ip, port);
			System.out.println("채팅서버와 연결되었습니다....");
			
			//서버로 보낼 메세지를 입력받는 스트림.
			InputStreamReader inR = new InputStreamReader(System.in);
			BufferedReader buR = new BufferedReader(inR);
			
			PrintWriter pout = new PrintWriter(sk.getOutputStream(), true);
			
			Thread thr = new Thread(this);
			thr.start();
			
			while((sendMsg = buR.readLine()) != null) {
				pout.println(sendMsg);
			}//while
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}//constructor
	
	
	public void run() {
		//클라이언트의 메세지를 받아서 콘솔에 출력하는 기능.
		InputStream ins;
		try {
			
			ins = sk.getInputStream();
			BufferedReader buR = new BufferedReader(new InputStreamReader(ins));
			
			String serverMsg = "";
			while(true) {
				serverMsg = buR.readLine();
				System.out.println("Server > "+serverMsg);
				System.out.println("Asdad");
			}//while
			
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		new ChatClient();
	}//main




	
}
