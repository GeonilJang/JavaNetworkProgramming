import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;

public class URLFileCopyEx003 {
	public static void main(String[] args) throws Exception {
		String str = "https://www.andar.co.kr/web/andar/banner/main_visual/180801/0801-sale-p.jpg";
		
		URL url = new URL(str);
		InputStream in = url.openStream();
		BufferedInputStream bi = new BufferedInputStream(in);
		//Reader는 문자열을 처리하기 위한 것입니다.
		
		FileOutputStream fo = new FileOutputStream("D:\\test3.jpg");
		byte buff[] = new byte[2048];
		int imgData = 0;
		while((imgData = bi.read(buff)) != -1) {
			fo.write(buff, 0, imgData);
			fo.flush();
		}
		fo.close();
		bi.close();
		in.close();
		
		
		
		 
		
		
		
		
		
	}
}
