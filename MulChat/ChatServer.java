package MulChat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Iterator;
import java.util.Vector;

public class ChatServer {
	
	Vector <ClientHandler> clThrs; 
	
	public ChatServer(int port) throws Exception {
		ServerSocket ssk = new ServerSocket(port);//클라이언트가 들어왔는지 안들어 왔는지만을 판단 한다.
		clThrs = new Vector<ClientHandler>(4,2); //처음 4개 부족하면 2개
		
		
		System.out.println("클라이언트 연결 대기중.....");
		while(true) {
			Socket sk = ssk.accept(); //해당 port에 클라이언트가 접근을 할 경우. Socket 객체를 반환.
			System.out.println(sk.getInetAddress()+"님이 접속했습니다.");
			
			//접속한 클라이언트와 통신을 담당하는 스레드 생성.
			ClientHandler clThr = new ClientHandler(this, sk);
			
			clThrs.add(clThr);
			clThr.start();
			
			
			
		}//while		
	}//Constructor
	
	public static void main(String[] args) {
		try {
			new ChatServer(7070);
		} catch (Exception e) {
			e.printStackTrace(); 
		}
	}//main
	
	
	class ClientHandler extends Thread{
		ChatServer ssk;
		Socket sk;
		
		DataInputStream di;
		DataOutputStream dou;
		
		boolean flag = false;
		
		
		public ClientHandler(ChatServer ssk, Socket sk) {
			this.ssk = ssk;
			this.sk = sk;
			
			try {
				di = new DataInputStream(sk.getInputStream());
				dou = new DataOutputStream(sk.getOutputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}//Constructor
		
		public void run() {
			String nickName = null;
			try {
				nickName = di.readUTF(); //로그인 클라이언트의 닉네임일 얻어오기.
				output(nickName+"님 입장.");
				while(!flag) {
					String Cmsg = di.readUTF(); //클라이언트의 대화내용을 읽어 오기 
					output(nickName +" > " +Cmsg);
				}//while
				
				
			} catch (IOException e) {
				output(nickName+"님이 나가셨습니다.");
				e.printStackTrace();
			}
		}//run()
		
		
		//모든 클라이언트에게 메세지를 축력해주는 기능.
		synchronized public void output(String msg) {
			//Interator 와 비슷.
//			Enumeration<ClientHandler> enu = ssk.clThrs.elements();
//			while(enu.hasMoreElements()) {
//			ClientHandler cTh = enu.nextElement();
//			try {
//				cTh.dou.writeUTF(msg);
//				cTh.dou.flush();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
			Iterator it = ssk.clThrs.iterator();
			while(it.hasNext()) {
				ClientHandler cTh = (ClientHandler)it.next();
				try {
					cTh.dou.writeUTF(msg);
					cTh.dou.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
						
		}//output()

	}//ClientHandler 
	
}//ChatServer
