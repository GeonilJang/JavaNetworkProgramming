package SocketTest;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class DemoServer001 {
	public static void main(String[] args) throws IOException {
		//�����Դϴ�.
		int port = 5052;
		
		//�������� ����
		ServerSocket ssk = new ServerSocket(port); //Ŭ���̾�Ʈ�� �����ߴ��� ���ߴ����� �Ǵ��� �մϴ�.
		System.out.println("���Ӵ����.");
		
		while(true) {
			Socket socket = ssk.accept();
			System.out.println("Ŭ���̾�Ʈ ip : "+socket.getInetAddress().getHostAddress());
		}
		
		
		
		
		
	}
}
