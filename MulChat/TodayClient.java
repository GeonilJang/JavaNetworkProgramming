package MulChat;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class TodayClient {
	public static void main(String[] args) throws Exception {
		DatagramSocket socket = new DatagramSocket();
		byte[] buffer = new byte[100];
		
		InetAddress ip = InetAddress.getByName("localhost");
		
		//전송
		DatagramPacket dp = new DatagramPacket(buffer , buffer.length, ip, 6061);
		socket.send(dp);
		
		
		dp = new DatagramPacket(buffer , buffer.length);
		socket.receive(dp);
		
		String woonse = new String(dp.getData());
		System.out.println("오늘의 운세 : "+woonse);
		socket.close();
		
			
	}
}
