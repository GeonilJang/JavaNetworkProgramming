import java.net.URL;
import java.net.URLConnection;

public class URLConnection002 {
	public static void main(String[] args) throws Exception {
		String str = "https://www.andar.co.kr/web/andar/banner/main_visual/180801/0801-sale-p.jpg";
		
		URL url = new URL(str);
		URLConnection conn = url.openConnection();
		System.out.println("���������� : "+conn.getContentLength());
		System.out.println("����Ÿ�� : "+conn.getContentType());
		System.out.println("���ӳ��� : "+conn.getDate());
		
		
	}
}
