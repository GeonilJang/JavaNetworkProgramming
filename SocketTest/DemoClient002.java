package SocketTest;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.Socket;

public class DemoClient002 {
	public static void main(String[] args) throws Exception {
		
		//����ÿ� ������ ������ �ȴ�. ������ �ȵɰ�쿡�� ���� �߻��Ѵ�.
		Socket sk = new Socket("183.99.6.38",5049);
		System.out.println("������ ���� : 5050");
		
		InputStream ins = sk.getInputStream();
		DataInputStream dins = new DataInputStream(ins);
		
		int number = dins.readInt();
		String str = dins.readUTF();
		System.out.println("�������� ���۵� �� : "+number+" , "+str);
		dins.close();
		ins.close();
		sk.close();
		
		
		
		
	}
}
