package SocketTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer implements Runnable{
	Socket sk;
	int cnt=0;
	
	
	
	public ChatServer() {
		System.out.println("Server Start");
		String msg = "";
		try {
			ServerSocket ssk = new ServerSocket(6061);
			//클라이언트와 통신하는 소켓생성.
			sk = ssk.accept();     //동일 포트 접속시 새로운 소켓 생성;
			System.out.println("클라이언트와 연결 되었습니다."+cnt++);
			
			//클라이언트에게 데이터를 보내기위한 스트림 생성.
			InputStreamReader inR = new InputStreamReader(System.in); //키보드로 부터 값을 입력받는 스트림 생성.
			BufferedReader buR = new BufferedReader(inR); //키보드로 입력받은 스트림과 버퍼를 연결.
			
			//클라이언트에게 메세지를 보내기위한 스트림 생성 -> PrintWriter(아웃풋 스트림을 받아 출력해줌.)
			PrintWriter pout = new PrintWriter(sk.getOutputStream(), true); //자동 flush()
			
			Thread thr = new Thread(this);
			thr.start();
			
			
			
			while((msg = buR.readLine()) != null) {
				pout.println(msg);
			}
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void run() {
		//클라이언트의 메세지를 받아서 콘솔에 출력하는 기능.
		InputStream ins;
		try {
			ins = sk.getInputStream();
			BufferedReader buR = new BufferedReader(new InputStreamReader(ins));
			
			String clientMsg = "";
			while(true) {
				clientMsg = buR.readLine();
				System.out.println("Client > "+clientMsg);
			}//while
				
		} catch (IOException e) {

			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	
	
	public static void main(String[] args) {
		new ChatServer();
		
	}
}
