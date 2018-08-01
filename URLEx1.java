import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;



public class URLEx1 {
	public static void main(String []args) throws Exception {
		URL url = new URL(args[0]);
		
		System.out.println("프로토콜 : "+url.getProtocol());//프로토콜을 얻기. http
		System.out.println("호스트 : "+url.getHost()); //호스트 얻기. www.naver.com
		System.out.println("포트 : "+url.getPort()); //포트 얻기. 8080 80포트는 -1 을 반환하며 이는 정상.
		System.out.println("파일 : "+url.getFile()); //파일 얻기
		
		//openStream() -> InputStream 으로 해당 url에서 정보를 얻어 옵니다.
		InputStream ins = url.openStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(ins));
		String  str = "";
		while((str = br.readLine()) != null) {
			System.out.println(str);
		}
		
		br.close();ins.close();
		
	}
}
