package MulChat;

import java.util.Random;

public class TodayWoonse {
	private static final String [] WOONSE = {
		"������ ���ÿ�.","���ȿ� ��������","����� ���� �Ͼ����.","��ſ��� ū ���� ~","������ �ޱ⺸�ٴ� ������ �ִ³�","���� �Ϸ� ������� �ູ�ϴ�",
		"������ ���϶�","�ǰ����� ���ؿ�","���Ͻô°���","������ ���","�޷��Դϴ�.","�˶��"
	};
	
	
	public static String selWoonse() {
		return WOONSE[new Random().nextInt(WOONSE.length)];
	}
	
}
