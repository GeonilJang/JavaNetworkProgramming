package MulChat;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class TodayServer {
	public static void main(String [] args) throws Exception {
		DatagramSocket socket = new DatagramSocket(6061);
		
		while(true) {
			System.out.println("Ŭ���̾�Ʈ ���� �����~~");
			byte [] buffer = new byte[100];
			DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
			socket.receive(dp);//Ŭ���̾�Ʈ�� ������ ��Ŷ �ȿ�����ִ�.
			
			String woonse = TodayWoonse.selWoonse();//��� ��� �´�.
			buffer = woonse.getBytes();
			
			InetAddress ip = dp.getAddress();
			int port = dp.getPort();
			System.out.println("["+port+"]�� ������");
			//��� Ŭ���̾�Ʈ���� ����.
			dp = new DatagramPacket(buffer, buffer.length, ip, port);
			socket.send(dp);
		}
		
		
	}
}