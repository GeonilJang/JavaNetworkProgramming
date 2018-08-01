import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

public class URLConnectionWriter004 {
	public static void main(String[] args) throws Exception {
		
		URL url = new URL("https://search.naver.com/search.naver?where=nexearch&sm=+"
				+ "top_hty&fbm=1&ie=utf8");
		
		URLConnection uc = url.openConnection();
		uc.setDoOutput(true); // 출력모드로 바꾼다.
		OutputStreamWriter ow = new OutputStreamWriter(uc.getOutputStream()); //출력스트림 생성
		
		ow.write("query=d");
		ow.close();
		
		BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
		String str = "";
		while((str = in.readLine()) != null) {
			System.out.println(str);
		}
		
	}
}
