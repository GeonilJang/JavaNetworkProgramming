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
			//Ŭ���̾�Ʈ�� ����ϴ� ���ϻ���.
			sk = ssk.accept();     //���� ��Ʈ ���ӽ� ���ο� ���� ����;
			System.out.println("Ŭ���̾�Ʈ�� ���� �Ǿ����ϴ�."+cnt++);
			
			//Ŭ���̾�Ʈ���� �����͸� ���������� ��Ʈ�� ����.
			InputStreamReader inR = new InputStreamReader(System.in); //Ű����� ���� ���� �Է¹޴� ��Ʈ�� ����.
			BufferedReader buR = new BufferedReader(inR); //Ű����� �Է¹��� ��Ʈ���� ���۸� ����.
			
			//Ŭ���̾�Ʈ���� �޼����� ���������� ��Ʈ�� ���� -> PrintWriter(�ƿ�ǲ ��Ʈ���� �޾� �������.)
			PrintWriter pout = new PrintWriter(sk.getOutputStream(), true); //�ڵ� flush()
			
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
		//Ŭ���̾�Ʈ�� �޼����� �޾Ƽ� �ֿܼ� ����ϴ� ���.
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
