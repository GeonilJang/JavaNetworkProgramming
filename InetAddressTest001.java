import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest001 {
	public static void main(String[] args) throws UnknownHostException {
		
		InetAddress ia = null;
		InetAddress[] iaArr = null;
		
		
		ia = InetAddress.getByName("www.naver.com");
		System.out.println("호스트 네임: "+ia.getHostName());
		System.out.println("호스트의 ip주소: "+ia.getHostAddress());
		System.out.println("도메인명/IP:"+ia.toString());//도메인명과 ip 주소를 얻어오는 역할
		
		
		iaArr = InetAddress.getAllByName("www.naver.com");
		for(InetAddress i : iaArr) {
			System.out.println(i);
		}
		
		ia = InetAddress.getLocalHost();
		System.out.println("로컬호스트 : "+ia.getHostName());
		System.out.println("로컬호스트 ip: "+ia.getHostAddress());
		
		
	}
}
