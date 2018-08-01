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
			System.out.println("ä�ü����� ����Ǿ����ϴ�....");
			
			//������ ���� �޼����� �Է¹޴� ��Ʈ��.
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
		//Ŭ���̾�Ʈ�� �޼����� �޾Ƽ� �ֿܼ� ����ϴ� ���.
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
