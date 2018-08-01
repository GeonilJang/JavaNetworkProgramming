import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class URLFileCopyEx003 {
	public static void main(String[] args) throws Exception {
		String str = "https://www.andar.co.kr/web/andar/banner/main_visual/180801/0801-sale-p.jpg";
		
		URL url = new URL(str);
		InputStream in = url.openStream();
		BufferedInputStream bi = new BufferedInputStream(in);
		//Reader�� ���ڿ��� ó���ϱ� ���� ���Դϴ�.
		
		FileOutputStream fo = new FileOutputStream("D:\\test3.jpg");
		byte buff[] = new byte[2048];
		int imgData = 0;
		
		int cnt = 0 ;
		URLConnection conn = url.openConnection();
		int size = conn.getContentLength();
		System.out.println("�̹��� ũ��: "+size);
		while((imgData = bi.read(buff)) != -1) { //read(buff) -> buff�� ���� ��´�.
			fo.write(buff, 0, imgData);//imgData ���� ������ ũ�Ⱑ ����.
			fo.flush();
			cnt +=imgData;
			System.out.println(((cnt*100)/size)+"%");
		}
		fo.close();
		bi.close();
		in.close();
		
		
		
		 
		
		
		
		
		
	}
}
