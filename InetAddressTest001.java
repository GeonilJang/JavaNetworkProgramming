import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest001 {
	public static void main(String[] args) throws UnknownHostException {
		
		InetAddress ia = null;
		InetAddress[] iaArr = null;
		
		
		ia = InetAddress.getByName("www.naver.com");
		System.out.println("ȣ��Ʈ ����: "+ia.getHostName());
		System.out.println("ȣ��Ʈ�� ip�ּ�: "+ia.getHostAddress());
		System.out.println("�����θ�/IP:"+ia.toString());//�����θ�� ip �ּҸ� ������ ����
		
		
		iaArr = InetAddress.getAllByName("www.naver.com");
		for(InetAddress i : iaArr) {
			System.out.println(i);
		}
		
		ia = InetAddress.getLocalHost();
		System.out.println("����ȣ��Ʈ : "+ia.getHostName());
		System.out.println("����ȣ��Ʈ ip: "+ia.getHostAddress());
		
		
	}
}
