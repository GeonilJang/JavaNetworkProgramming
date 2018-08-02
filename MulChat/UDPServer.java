package MulChat;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPServer {
	public static void main(String[] args) throws Exception {
		byte [] buffer = new byte[256];
		
		DatagramSocket ds = new DatagramSocket(6060);
		DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
		
		System.out.println("연결대기중~~~~");
		while(true) {
			ds.receive(dp);
			byte [] buffMsg = dp.getData();
			String clientMsg = new String(buffMsg,0,dp.getLength());
			System.out.println(dp.getAddress()+">> "+clientMsg);
		}
		
		
		
		
		
	}
}
