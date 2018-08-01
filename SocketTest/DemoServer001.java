package SocketTest;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class DemoServer001 {
	public static void main(String[] args) throws IOException {
		//�����Դϴ�.
		int port = 5049;
		
		int number = Integer.parseInt(args[0]);
		String str = new String(args[1]);
		
		//�������� ����
		ServerSocket ssk = new ServerSocket(port); //Ŭ���̾�Ʈ�� �����ߴ��� ���ߴ����� �Ǵ��� �մϴ�.-> accept() �����.
		System.out.println("���Ӵ����.");
		
		while(true) {
			Socket socket = ssk.accept();
			System.out.println("Ŭ���̾�Ʈ ip : "+socket.getInetAddress().getHostAddress());
			
			//Ŭ���̾�Ʈ�� ������ ���� ��Ʈ���� ����.
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
