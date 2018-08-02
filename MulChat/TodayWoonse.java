package MulChat;

import java.util.Random;

public class TodayWoonse {
	private static final String [] WOONSE = {
		"나서지 마시오.","집안에 있으세요","당신의 운을 믿어보세요.","당신에게 큰 복을 ~","도움을 받기보다는 도움을 주는날","좋은 일로 모든사람이 행복하다",
		"과식을 피하라","건강관리 잘해요","뭐하시는거죠","복권을 사요","메롱입니다.","알라뷰"
	};
	
	
	public static String selWoonse() {
		return WOONSE[new Random().nextInt(WOONSE.length)];
	}
	
}
