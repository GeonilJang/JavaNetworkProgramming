package SocketTest;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.Socket;

public class DemoClient002 {
	public static void main(String[] args) throws Exception {
		
		//연결시에 소켓이 생성이 된다. 연결이 안될경우에는 예외 발생한다.
		Socket sk = new Socket("183.99.6.38",5049);
		System.out.println("서버와 접속 : 5050");
		
		InputStream ins = sk.getInputStream();
		DataInputStream dins = new DataInputStream(ins);
		
		int number = dins.readInt();
		String str = dins.readUTF();
		System.out.println("서버에서 전송된 값 : "+number+" , "+str);
		dins.close();
		ins.close();
		sk.close();
		
		
		
		
	}
}
