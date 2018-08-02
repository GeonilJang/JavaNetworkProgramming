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
		ServerSocket ssk = new ServerSocket(port);//Ŭ���̾�Ʈ�� ���Դ��� �ȵ�� �Դ������� �Ǵ� �Ѵ�.
		clThrs = new Vector<ClientHandler>(4,2); //ó�� 4�� �����ϸ� 2��
		
		
		System.out.println("Ŭ���̾�Ʈ ���� �����.....");
		while(true) {
			Socket sk = ssk.accept(); //�ش� port�� Ŭ���̾�Ʈ�� ������ �� ���. Socket ��ü�� ��ȯ.
			System.out.println(sk.getInetAddress()+"���� �����߽��ϴ�.");
			
			//������ Ŭ���̾�Ʈ�� ����� ����ϴ� ������ ����.
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
				nickName = di.readUTF(); //�α��� Ŭ���̾�Ʈ�� �г����� ������.
				output(nickName+"�� ����.");
				while(!flag) {
					String Cmsg = di.readUTF(); //Ŭ���̾�Ʈ�� ��ȭ������ �о� ���� 
					output(nickName +" > " +Cmsg);
				}//while
				
				
			} catch (IOException e) {
				output(nickName+"���� �����̽��ϴ�.");
				e.printStackTrace();
			}
		}//run()
		
		
		//��� Ŭ���̾�Ʈ���� �޼����� ������ִ� ���.
		synchronized public void output(String msg) {
			//Interator �� ���.
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
