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
			//���������� �ܼ��ϰ� ���� ���θ� �Ǵ��� �ϰԵ˴ϴ�.
			ssk = new ServerSocket(port);
			System.out.println("���� �����");
			
			//���Ͽ� ������ �߻��ϰ� �Ǹ� accept�� ȣ�� �˴ϴ�.
			sk = ssk.accept();
			System.out.println(sk.getLocalPort() +"��Ʈ "+sk.getInetAddress() + "���� ������ �Ǿ����ϴ�.");
			
			//Ŭ���̾�Ʈ���� ���޵Ǵ� �޼����� �ޱ� ���ؼ�  ���Ͽ��� ���� �Ǵ� getInputStream�� InputStream ��ü��
			//���ؼ� �ν��Ͻ��� �����մϴ�. �� �� InputStream ���� ���� ���� ���� "��Ʈ��"��Ű ������
			//InputStreamReader�� ���ؼ� ���ο� ��ü�� InputStreamReader ��ü�� �����ϰ� 
			//������ ��Ʈ���� BufferedReader�� ���� ���ۿ� ����ϴ�.
			InputStream ins = sk.getInputStream();
			InputStreamReader inR = new InputStreamReader(ins);
			BufferedReader bffR = new BufferedReader(inR);
			
			
			//Ŭ���̾�Ʈ�� ���� �����ϱ� ���� ��Ʈ���� �����.
			//���� Ŭ���̾�Ʈ�� �����ϱ� ���Ͽ� PrintWriter ��ü�� ����� ���� ���� �־��ش�.
			OutputStream out = sk.getOutputStream();
			PrintWriter pout = new PrintWriter(out, true); //true �ϸ� �÷��� ����� �����Ѵ�.
			pout.println("Hello Java.");
			
			
			//Ŭ���̾�Ʈ�� ���� ���� ���۵Ǵ� ���� ��� �ľ��ϸ� �� ���� �ľ��ϰ� �ش� �亯�� ���� ����� �����Ѵ�.
			String clientMsg = "";
			while((clientMsg = bffR.readLine()) != null) {
				
				if(clientMsg.startsWith("�ȳ�") || clientMsg.startsWith("����")) {
					pout.println(sk.getInetAddress()+"�� �ݰ����ϴ�.");
				}else if(clientMsg.startsWith("������ ����")) {
					Date today = new Date();
					pout.println("������ : "+today);
				}else {
					pout.println(sk.getInetAddress()+"�� ����~");
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
