import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;



public class URLEx1 {
	public static void main(String []args) throws Exception {
		URL url = new URL(args[0]);
		
		System.out.println("�������� : "+url.getProtocol());//���������� ���. http
		System.out.println("ȣ��Ʈ : "+url.getHost()); //ȣ��Ʈ ���. www.naver.com
		System.out.println("��Ʈ : "+url.getPort()); //��Ʈ ���. 8080 80��Ʈ�� -1 �� ��ȯ�ϸ� �̴� ����.
		System.out.println("���� : "+url.getFile()); //���� ���
		
		//openStream() -> InputStream ���� �ش� url���� ������ ��� �ɴϴ�.
		InputStream ins = url.openStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(ins));
		String  str = "";
		while((str = br.readLine()) != null) {
			System.out.println(str);
		}
		
		br.close();ins.close();
		
	}
}
