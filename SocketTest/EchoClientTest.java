package SocketTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class EchoClientTest {
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		//������ ������ ������ �ʱ�ȭ �Ѵ�.
		String ip = "183.99.6.38";
		int port = 7080;		
		Socket sk = new Socket(ip,port); // ������ ������ �Ǿ��ٸ� �Ʒ��� ���۵ǰ� �ƴϸ� ���ܰ� �߻��Ѵ�.
		System.out.println("������ ������ �Ǿ����ϴ�.");
		
		
		
		//������ ���� �����͸� �Է¹޴� ��Ʈ��.
		InputStream ins = sk.getInputStream();
		InputStreamReader isr = new InputStreamReader(ins);
		BufferedReader bff = new BufferedReader(isr); 
		
		OutputStream ous = sk.getOutputStream();
		PrintWriter pout = new PrintWriter(ous, true);
		//Ű����� ���� �����͸� �Է¹޴´�.
		InputStreamReader inR = new InputStreamReader(System.in);
		BufferedReader bffKey = new BufferedReader(inR);
		
		
		String servermsg = "",sendMsg="";
		
		//������ ���� ���޵Ǵ� ������ ���� �о� �´�.
		servermsg = bff.readLine();
		System.out.println("�����޼��� : "+servermsg);
		
		//Ű����� ���Ͱ��� �Է��ؼ� ���������� �����Ѵ�.
		while((sendMsg = bffKey.readLine()) != null) {
			pout.println(sendMsg);
			servermsg = bff.readLine();
			System.out.println(servermsg);
		}
		
		inR.close();
		bffKey.close();
		bff.close();
		sk.close();
		
	}
}
