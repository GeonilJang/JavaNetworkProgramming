package SocketTest;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class DemoClient002 {
	public static void main(String[] args) throws Exception {
		
		//����ÿ� ������ ������ �ȴ�. ������ �ȵɰ�쿡�� ���� �߻��Ѵ�.
		Socket sk = new Socket("183.99.6.38",5052);
		System.out.println("������ ���� : 5050");
		
	}
}
